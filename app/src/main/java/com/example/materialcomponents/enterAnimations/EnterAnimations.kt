package com.example.materialcomponents.enterAnimations

import android.os.Looper
import android.transition.Visibility
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.rotationMatrix
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens
import kotlinx.coroutines.delay
import java.util.logging.Handler

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EnterAnimations(navController: NavHostController) {
    var fadeIN by remember {
        mutableStateOf(true)
    }
    var visible by remember {
        mutableStateOf(true)
    }
    var SlideInVertically by remember {
        mutableStateOf(true)
    }
    Row(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primaryContainer).padding(vertical = 10.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        ClickableText(text = AnnotatedString("Home"), onClick = {
            navController.popBackStack()
        },
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Text(text = ">",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        ClickableText(text = AnnotatedString("Enter Animations"), onClick = {

        },
            style = TextStyle(
                fontSize = 20.sp
            )
        )
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .animateContentSize(),
    verticalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterVertically),
    ) {

        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = visible,
                enter = EnterTransition.None,
                exit = ExitTransition.None
            ) {
                Button(onClick = {
                    visible = !visible
                    if (!visible) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            visible = true
                        }, 200)
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "No Transition",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

            }
        }


        Column(modifier = Modifier.height(56.dp)) {
    AnimatedVisibility(visible = fadeIN,
        enter = fadeIn(),
        exit = ExitTransition.None,
    ) {
        Button(onClick = {
            fadeIN = !fadeIN
            if (!fadeIN) {
                android.os.Handler(Looper.getMainLooper()).postDelayed({
                    fadeIN = true
                }, 200)
            }
        },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .height(56.dp)
                .animateContentSize(),
            shape = RoundedCornerShape(20)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Fade In",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
            }
        }

    }
}


       Column(modifier = Modifier.height(56.dp)) {
           AnimatedVisibility(visible = SlideInVertically,
               enter = slideInVertically(),
               exit = ExitTransition.None
           ) {
               Button(onClick = {
                   SlideInVertically = !SlideInVertically
                   if (!SlideInVertically) {
                       android.os.Handler(Looper.getMainLooper()).postDelayed({
                           SlideInVertically = true
                       }, 200)
                   }
               },
                   colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                       contentColor = MaterialTheme.colorScheme.primary),
                   modifier = Modifier
                       .padding(horizontal = 10.dp)
                       .height(56.dp),
                   shape = RoundedCornerShape(20)
               ) {
                   Row(
                       horizontalArrangement = Arrangement.SpaceBetween,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(
                           text = "Slide In Vertically",
                           textAlign = TextAlign.Center,
                           modifier = Modifier.weight(1f)
                       )
                   }
               }

           }
       }


        var slideInHorizontal by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = slideInHorizontal,
                enter = slideInHorizontally(),
                exit = ExitTransition.None
            ) {
                Button(onClick = {
                    slideInHorizontal = !slideInHorizontal
                    if (!slideInHorizontal) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            slideInHorizontal = true
                        }, 200)
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Slide In Horizontally",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

            }
        }

        var expandIn by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = expandIn,
                enter = expandIn(),
                exit = ExitTransition.None
            ) {
                Button(onClick = {
                    expandIn = !expandIn
                    if (!expandIn) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            expandIn = true
                        }, 200)
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Expand In",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }


        var expandInVertically by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = expandInVertically,
                enter = expandVertically(),
                exit = ExitTransition.None
            ) {
                Button(onClick = {
                    expandInVertically = !expandInVertically
                    if (!expandInVertically) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            expandInVertically = true
                        }, 200)
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Expand In Vertically",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        var expandInHorizontally by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = expandInHorizontally,
                enter = expandHorizontally(),
                exit = ExitTransition.None
            ) {
                Button(onClick = {
                    expandInHorizontally = !expandInHorizontally
                    if (!expandInHorizontally) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            expandInHorizontally = true
                        }, 200)
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Expand In Horizontally",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        var scaleIn by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = scaleIn,
                enter = scaleIn(),
                exit = ExitTransition.None
            ) {
                Button(onClick = {
                    scaleIn = !scaleIn
                    if (!scaleIn) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            scaleIn = true
                        }, 200)
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(20)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Scale In",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

    }
}