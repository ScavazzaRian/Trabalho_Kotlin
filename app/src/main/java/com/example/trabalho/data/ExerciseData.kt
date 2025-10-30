package com.example.trabalho.data

import com.example.trabalho.model.Exercise
import com.example.trabalho.R

object ExerciseData {
    fun obterExercicios(): List<Exercise> {
        return listOf(
            // Alongamento de Isquiotibiais Sentado
            Exercise(
                id = 1,
                titulo = "Alongamento de Isquiotibiais Sentado",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                tempo = 30,
                passos = listOf(
                    "Fique em pé ou sentado com a coluna reta",
                    "Incline-se para frente mantendo a costas ereta, coloque as mãos sobre a coxa.",
                    "Abaixe o tronco um pouco mais, sem forçar ou curvar as costas",
                    "Volte devagar para a posição inicial. Depois, repita o mesmo processo com a outra perna."
                )
            ),

            // Alongamento Matinal de Pernas
            Exercise(
                id = 2,
                titulo = "Alongamento Matinal de Pernas",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                tempo = 30,
                passos = listOf(
                    "Sente-se confortavelmente com a coluna ereta",
                    "Estenda uma perna à frente e flexione levemente a outra",
                    "Incline-se suavemente para frente, mantendo as costas retas",
                    "Segure a posição por alguns segundos e retorne lentamente"
                )
            ),

            // Relaxamento Pós-Treino de Posteriores
            Exercise(
                id = 3,
                titulo = "Relaxamento Pós-Treino de Posteriores",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                tempo = 30,
                passos = listOf(
                    "Posicione-se sentado com uma perna estendida",
                    "Mantenha a coluna alinhada e relaxe os ombros",
                    "Deslize as mãos pela coxa em direção ao joelho",
                    "Respire profundamente e volte à posição inicial com calma"
                )
            ),

            // Alongamento para Escritório
            Exercise(
                id = 4,
                titulo = "Alongamento para Escritório",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                tempo = 30,
                passos = listOf(
                    "Sente-se na beira da cadeira com os pés no chão",
                    "Estenda uma perna mantendo o calcanhar apoiado",
                    "Incline-se gentilmente para frente sem curvar as costas",
                    "Mantenha por 15-20 segundos e troque de perna"
                )
            ),

            // Flexibilidade de Isquiotibiais
            Exercise(
                id = 5,
                titulo = "Flexibilidade de Isquiotibiais",
                imagemResId = R.drawable.exercise_1,
                audioResId = R.raw.exercise_1_audio,
                tempo = 30,
                passos = listOf(
                    "Comece em posição sentada com coluna ereta",
                    "Estenda uma perna e mantenha a outra flexionada",
                    "Avance o tronco para frente mantendo alinhamento",
                    "Sinta o alongamento na parte posterior da perna e retorne"
                )
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
