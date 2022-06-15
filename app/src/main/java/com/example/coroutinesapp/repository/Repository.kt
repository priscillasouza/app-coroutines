package com.example.coroutinesapp.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository {
    val listOfStrings = listOf<String>(
        "As informações",
        "estão",
        "sendo",
        "carregadas",
        "lentamente",
        "para",
        "você",
        "visualizar"
    )

    //Funções do tipo suspende são funções que são exceutadas em segundo plano
    //o Flow, que será retonadno é um fluxo de dados de algum tipo
    suspend fun getData(): Flow<String> {
        //retorna o fluxo
        return flow {
            listOfStrings.forEach { string ->
                //para o flow funcionar é preciso emitir o elemento da lista
                emit(string)
                delay(2000)
            }
        }
    }
}