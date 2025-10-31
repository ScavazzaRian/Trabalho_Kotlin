package com.example.trabalho.data

import com.example.trabalho.model.Exercise
import com.example.trabalho.R

object ExerciseData {
    fun obterExercicios(): List<Exercise> {
        return listOf(
           Exercise(
                id = 1,
                titulo = "Corrida",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                passos = listOf(
                    "Aqueça com caminhada leve por 5 minutos",
                    "Corra em ritmo moderado por 20 minutos",
                    "Desacelere com caminhada leve por 5 minutos"
                ),
                tempo = 30*60
            ),
            Exercise(
                id = 2,
                titulo = "Alongamento",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                passos = listOf(
                    "Alongue braços e ombros por 1 minuto",
                    "Alongue pernas e quadris por 2 minutos",
                    "Respire fundo e relaxe por 1 minuto"
                ),
                tempo = 5*60
            ),
            Exercise(
                id = 3,
                titulo = "Yoga",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                passos = listOf(
                    "Postura da montanha por 1 minuto",
                    "Cachorro olhando para baixo por 2 minutos",
                    "Postura da criança por 2 minutos"
                ),
                tempo = 5*60
            ),
            Exercise(
                id = 4,
                titulo = "Treino de força",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                passos = listOf(
                    "Agachamentos: 3 séries de 15",
                    "Flexões: 3 séries de 10",
                    "Prancha: 3 séries de 30 segundos"
                ),
                tempo = 2*60
            )
            // Adicione mais exercícios aqui
            // Exercise(
            //     titulo = "Alongamento de Braços:",
            //     imagemResId = R.drawable.exercise_2,
            //     audioResId = R.raw.exercise_2_audio,
            //     passos = listOf(...)
            // )
        )
    }
}
