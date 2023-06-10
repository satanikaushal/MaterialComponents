package com.example.materialcomponents.easing

import android.os.Looper
import android.transition.Visibility
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.EaseInBack
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.EaseInElastic
import androidx.compose.animation.core.EaseInOutBack
import androidx.compose.animation.core.EaseInOutBounce
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun EasingAnimations(navController: NavHostController) {
    var fadeIN by remember {
        mutableStateOf(true)
    }
    var visible by remember {
        mutableStateOf(true)
    }
    var SlideInVertically by remember {
        mutableStateOf(true)
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primaryContainer)
        .padding(vertical = 10.dp, horizontal = 20.dp),
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
        ClickableText(text = AnnotatedString("Easing In Animations"), onClick = {

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
        val easing = listOf(EaseInBack, EaseInBounce, EaseInElastic, EaseInOutBack, EaseInOutBounce, EaseOutBounce, EaseOutElastic,
            FastOutLinearInEasing, LinearEasing)
        val easingName = listOf("Ease In Back","Ease In Bounce", "Ease In Elastic", "Ease In Out Back","Ease In Out Bounce","Ease Out Bounce",
            "Ease Out Elastic", "Fast Out Linear In Easing", "Linear Easing")
        
        Spacer(modifier = Modifier.height(30.dp))

        easing.forEachIndexed{ index ,name ->
                var slideInHorizontal by remember {
                    mutableStateOf(true)
                }
                Column(modifier = Modifier.height(56.dp)) {
                    AnimatedVisibility(visible = slideInHorizontal,
                        enter = slideInHorizontally(
                            animationSpec = tween(durationMillis = 1500,easing = name, delayMillis = 600),
                            initialOffsetX = {fullWidth -> -fullWidth/2 }
                        ),
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
                                    text = easingName[index],
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }

                    }
                }

            }
        }
}
