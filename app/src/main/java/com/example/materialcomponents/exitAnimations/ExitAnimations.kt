package com.example.materialcomponents.exitAnimations


import android.os.Looper
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavHostController
import com.example.materialcomponents.Screens

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExitAnimations(navController: NavHostController) {
    var fadeOUT by remember {
        mutableStateOf(true)
    }
    var visible by remember {
        mutableStateOf(true)
    }
    var SlideOutVertically by remember {
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
        ClickableText(text = AnnotatedString("Exit Animations"), onClick = {
            
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
                        }, 800)
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
            AnimatedVisibility(visible = fadeOUT,
                enter = EnterTransition.None,
                exit = fadeOut(),
            ) {
                Button(onClick = {
                    fadeOUT = !fadeOUT
                    if (!fadeOUT) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            fadeOUT = true
                        }, 800)
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
                            text = "Fade Out",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

            }
        }


        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = SlideOutVertically,
                enter = EnterTransition.None,
                exit = slideOutVertically()
            ) {
                Button(onClick = {
                    SlideOutVertically = !SlideOutVertically
                    if (!SlideOutVertically) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            SlideOutVertically = true
                        }, 800)
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
                            text = "Slide Out Vertically",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

            }
        }


        var slideOutHorizontal by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = slideOutHorizontal,
                enter = EnterTransition.None,
                exit = slideOutHorizontally()
            ) {
                Button(onClick = {
                    slideOutHorizontal = !slideOutHorizontal
                    if (!slideOutHorizontal) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            slideOutHorizontal = true
                        }, 800)
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
                            text = "Slide Out Horizontally",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

            }
        }

        var expandOut by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = expandOut,
                enter = EnterTransition.None,
                exit = shrinkOut()
            ) {
                Button(onClick = {
                    expandOut = !expandOut
                    if (!expandOut) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            expandOut = true
                        }, 800)
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
                            text = "Shrink Out",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }


        var expandOutVertically by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = expandOutVertically,
                enter = EnterTransition.None,
                exit = shrinkVertically()
            ) {
                Button(onClick = {
                    expandOutVertically = !expandOutVertically
                    if (!expandOutVertically) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            expandOutVertically = true
                        }, 800)
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
                            text = "Shrink Out Vertically",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        var expandOutHorizontally by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = expandOutHorizontally,
                enter = EnterTransition.None,
                exit = shrinkHorizontally()
            ) {
                Button(onClick = {
                    expandOutHorizontally = !expandOutHorizontally
                    if (!expandOutHorizontally) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            expandOutHorizontally = true
                        }, 800)
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
                            text = "Shrink Out Horizontally",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        var scaleOut by remember {
            mutableStateOf(true)
        }
        Column(modifier = Modifier.height(56.dp)) {
            AnimatedVisibility(visible = scaleOut,
                enter = EnterTransition.None,
                exit = scaleOut()
            ) {
                Button(onClick = {
                    scaleOut = !scaleOut
                    if (!scaleOut) {
                        android.os.Handler(Looper.getMainLooper()).postDelayed({
                            scaleOut = true
                        }, 800)
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
                            text = "Scale Out",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

    }
}