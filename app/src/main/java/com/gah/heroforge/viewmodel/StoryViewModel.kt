package com.gah.heroforge.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.gah.heroforge.data.Choice
import com.gah.heroforge.data.StoryNode

class StoryViewModel : ViewModel() {

    // All chapters and options
    private val storyList = listOf(
        StoryNode(
            id = 1,
            text = "Você acorda numa floresta com neblina e não lembra de nada.\n" +
                    "Perto de você, uma espada antiga brilha em azul.\n" +
                    "Na frente, um caminho divide-se em trilha escura e uma caverna.\n" +
                    "O que você faz?",
            choices = listOf(
                Choice("Seguir pela trilha escura", 2),
                Choice("Investigar a caverna", 3),
                Choice("Ir pelo rio", 7)
            )
        ),
        StoryNode(
            id = 2,
            text = "A trilha leva você até uma vila abandonada.\n" +
                    "Símbolos estranhos nas paredes e um velho aparece oferecendo ajuda.\n" +
                    "Será que é uma armadilha?",
            choices = listOf(
                Choice("Aceitar ajuda", 4),
                Choice("Recusar e seguir sozinho", 5)
            )
        ),
        StoryNode(
            id = 3,
            text = "Dentro da caverna, ecos sussurram seu nome.\n" +
                    "Você encontra um artefato antigo que te dá poder.\n" +
                    "Mas algo te observa na escuridão...",
            choices = listOf(
                Choice("Pegar artefato", 6),
                Choice("Sair correndo", 2)
            )
        ),
        StoryNode(
            id = 4,
            text = "O velho era um espírito guardião e te dá sabedoria.\n" +
                    "Você está pronto(a) para o que vem. Fim.",
            choices = emptyList()
        ),
        StoryNode(
            id = 5,
            text = "Sem ajuda, você cai numa armadilha e fica preso(a) para sempre. Fim.",
            choices = emptyList()
        ),
        StoryNode(
            id = 6,
            text = "O artefato te dá poder, mas corrompe seu coração.\n" +
                    "Você vira um(a) mago(a) sombrio(a) e poderoso(a). Fim.",
            choices = emptyList()
        ),
        StoryNode(
            id = 7,
            text = "Seguindo o rio, você acha um barco abandonado.\n" +
                    "Ele pode levar você para fora da floresta ou para uma armadilha.",
            choices = listOf(
                Choice("Entrar no barco", 8),
                Choice("Andar pela margem", 9)
            )
        ),
        StoryNode(
            id = 8,
            text = "O barco desliza e a névoa some.\n" +
                    "Uma cidade dourada aparece, o reino perdido de Eldoria.\n" +
                    "Você nunca quer sair. Fim.",
            choices = emptyList()
        ),
        StoryNode(
            id = 9,
            text = "Você encontra um acampamento de mercenários.\n" +
                    "Eles lhe oferecem comida e abrigo por um preço.",
            choices = listOf(
                Choice("Aceitar e trabalhar para eles", 10),
                Choice("Recusar e fugir", 5)
            )
        ),
        StoryNode(
            id = 10,
            text = "Você vira um(a) mercenário(a) famoso(a) e rico(a).\n" +
                    "Mas lembra sempre da floresta. Fim.",
            choices = emptyList()
        )
    )

    // State (current chapter)
    var currentNode = mutableStateOf(storyList[0])
        private set

    // Changes (chapter based on choice)
    fun makeChoice(choice: Choice) {
        val next = storyList.find { it.id == choice.nextNodeId }
        currentNode.value = next ?: storyList[0]
    }

    // Restart history
    fun restart() {
        currentNode.value = storyList[0]
    }

    // Returns current and total progress
    fun getProgress(): Pair<Int, Int> {
        val index = storyList.indexOf(currentNode.value) + 1
        return Pair(index, storyList.size)
    }
}