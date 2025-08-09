package com.gah.heroforge.screens

import android.app.Activity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gah.heroforge.R
import com.gah.heroforge.ui.theme.*
import com.gah.heroforge.viewmodel.StoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoryScreen(viewModel: StoryViewModel) {
    val currentNode by viewModel.currentNode
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val (currentChapter, totalChapters) = viewModel.getProgress()

    var canClick by remember { mutableStateOf(true) }

    // Reset scroll to top when currentNode changes
    LaunchedEffect(currentNode) {
        scrollState.animateScrollTo(0)
        canClick = true
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.rpg_background),
            contentDescription = "Fundo do jogo (RPG)",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Progress Bar (Chapter Title and Linear Progress)
            Column(modifier = Modifier.fillMaxWidth()) {

                TopAppBar(
                    title = {
                        Text(
                            text = "Capítulo $currentChapter de $totalChapters",
                            fontSize = 20.sp,
                            color = White
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = ChoicesBackground
                    )
                )
                // Progress Bar
                LinearProgressIndicator(
                    progress = { currentChapter.toFloat() / totalChapters.coerceAtLeast(1) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .padding(top = 6.dp),
                    color = GreenBar,
                    trackColor = ElegantBackgroundEnd,
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                // Displaying the current story text using a Surface with elevation
                Surface(
                    tonalElevation = 8.dp,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Crossfade(targetState = currentNode.text) { text ->
                        Text(
                            text = text,
                            modifier = Modifier.padding(20.dp),
                            color = White,
                            fontSize = 17.sp,
                            lineHeight = 25.sp,
                            textAlign = TextAlign.Justify
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Choices: Display buttons for user choices
                if (currentNode.choices.isNotEmpty()) {
                    currentNode.choices.forEach { choice ->
                        Button(
                            onClick = {
                                if (canClick) {
                                    canClick = false
                                    viewModel.makeChoice(choice)
                                }
                            },
                            enabled = canClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp),
                            shape = RoundedCornerShape(22.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Choices,
                                contentColor = White
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Book,
                                contentDescription = null,
                                modifier = Modifier.padding(end = 6.dp)
                            )
                            Text(
                                text = choice.text,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp)) // Spacing between choice buttons
                    }
                } else {
                    // Restart button
                    Button(
                        onClick = { viewModel.restart() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(22.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ResetButton,
                            contentColor = White
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.RestartAlt,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 6.dp)
                        )
                        Text(
                            text = "Reiniciar História",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Close button
            Button(
                onClick = { (context as? Activity)?.finish() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(22.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red_AP,
                    contentColor = White
                )
            ) {
                Text(
                    text = "Fechar",
                    fontSize = 17.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                )
            }
        }
    }
}
