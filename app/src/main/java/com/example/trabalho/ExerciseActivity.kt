package com.example.trabalho

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trabalho.databinding.ActivityExerciseBinding
import com.example.trabalho.data.ExerciseData
import com.example.trabalho.model.Exercise

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = false
    private val exercicios = ExerciseData.obterExercicios()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        val exerciseId = intent.getIntExtra("exercise_id", -1)
        val exercicio = exercicios.find { it.id == exerciseId }
        if (exercicio != null) {
            carregarExercicio(exercicio)
        } else {
            mostrarErro()
        }
    }

    private fun carregarExercicio(exercicio: Exercise) {
        binding.tvHeaderTitle.text = exercicio.titulo
        binding.tvTime.text = formatTime(exercicio.tempo)
        binding.ivExercise.setImageResource(exercicio.imagemResId)
        binding.tvTitle.text = exercicio.titulo
        binding.stepsContainer.removeAllViews()

        exercicio.passos.forEachIndexed { index, passo ->
            val stepView = layoutInflater.inflate(
                R.layout.item_exercise_step,
                binding.stepsContainer,
                false
            )
            val stepNumberText = stepView.context.getString(R.string.step_number, index + 1)
            stepView.findViewById<TextView>(R.id.tv_step_number).text = stepNumberText
            stepView.findViewById<TextView>(R.id.tv_step_description).text = passo
            binding.stepsContainer.addView(stepView)
        }

        configurarAudio(exercicio.audioResId)
    }

    private fun configurarAudio(audioResId: Int) {
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying = false

        mediaPlayer = MediaPlayer.create(this, audioResId)
        
        // Set maximum volume (1.0f = 100% volume)
        mediaPlayer?.setVolume(1.0f, 1.0f)
        
        binding.audioSeekbar.max = mediaPlayer?.duration ?: 0
        binding.audioSeekbar.progress = 0

        binding.btnPlayPause.setOnClickListener {
            alternarPlayPause()
        }

        binding.audioSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer?.seekTo(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        atualizarSeekbar()

        mediaPlayer?.setOnCompletionListener {
            isPlaying = false
            binding.btnPlayPause.setImageResource(R.drawable.ic_play)
            binding.audioSeekbar.progress = 0
        }
    }

    private fun alternarPlayPause() {
        mediaPlayer?.let { player ->
            if (isPlaying) {
                player.pause()
                binding.btnPlayPause.setImageResource(R.drawable.ic_play)
            } else {
                player.start()
                binding.btnPlayPause.setImageResource(R.drawable.ic_pause)
                atualizarSeekbar()
            }
            isPlaying = !isPlaying
        }
    }

    private fun mostrarErro() {
        binding.tvTitle.text = getString(R.string.exercise_not_found)
        binding.ivExercise.setImageResource(R.drawable.ic_error)
        binding.stepsContainer.removeAllViews()
        binding.tvTime.text = "--:--"
        binding.btnPlayPause.isEnabled = false
        binding.audioSeekbar.isEnabled = false
    }

    private fun atualizarSeekbar() {
        binding.audioSeekbar.postDelayed(object : Runnable {
            override fun run() {
                mediaPlayer?.let { player ->
                    if (isPlaying && player.isPlaying) {
                        binding.audioSeekbar.progress = player.currentPosition
                        binding.audioSeekbar.postDelayed(this, 100)
                    }
                }
            }
        }, 100)
    }

    private fun formatTime(seconds: Int): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return getString(R.string.formatted_time, minutes, remainingSeconds)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}