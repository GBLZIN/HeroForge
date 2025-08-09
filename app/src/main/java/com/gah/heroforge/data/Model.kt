package com.gah.heroforge.data

data class StoryNode(
    val id: Int,
    val text: String,
    val choices: List<Choice>
)

data class Choice(
    val text: String,
    val nextNodeId: Int?
)