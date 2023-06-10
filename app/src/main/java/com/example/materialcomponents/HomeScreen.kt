package com.example.materialcomponents

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay




@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun HomeScreen(navController: NavHostController){
    val names = listOf("Alert Boxes", "Drop Down Menu", "Top App Bars", "Bottom App Bars", "Simple Badge Box", "Bottom Sheet Scaffold", "Check Boxes",
        "Chips", "Date Pickers", "Exposed Drop Down", "List Item", "Modal Bottom Sheet", "Navigation Drawer", "Input Fields", "Indicators", "Sliders",
    "Snack Bars", "Swipe To Dismiss", "Switches", "Tabs", "Time Picker", "Enter Animations", "Exit Animations","Easing In Animations")

var searchQuery by rememberSaveable{
    mutableStateOf("")
}
    val backPressDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    DisposableEffect(backPressDispatcher) {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Empty the mutable state when the back button is pressed
                searchQuery = ""
            }
        }

        backPressDispatcher?.addCallback(callback)

        onDispose {
            callback.remove()
        }
    }

    var active by remember {
        mutableStateOf(false)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = Modifier
        .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    DockedSearchBar(
                        query = searchQuery,
                        onQueryChange = {
                            searchQuery = it
                        },
                        onSearch = {
                            searchQuery = it
                        },
                        active = active,
                        onActiveChange = {
                                         active = false
                        },
                        content = {},
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        },
                        trailingIcon = {
                            IconButton(onClick = { searchQuery = ""}) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                            }
                        },
                        placeholder = {
                            Text(text = "Enter your query here")
                        },
                    )
                     },
                scrollBehavior = scrollBehavior,
            )
        },
        content = { paddingValues ->
            val filteredNames = names.filter { it.lowercase().contains(searchQuery.lowercase()) }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(paddingValues),
                userScrollEnabled = true,
                state = rememberLazyListState()
            ) {
                item { 
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                            Text(text = "Material 3 UI Components",
                            style = TextStyle(
                                fontSize = 25.sp,
                                fontFamily = FontFamily.SansSerif
                            ),
                                textAlign = TextAlign.Center
                            )
                    }
                }
                if(filteredNames.isEmpty()){
                    item {
                        Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                            Text(text = "No results found")
                        }
                    }
                }else{
                    items(filteredNames) { item ->
                        ListItemBox(name = item, navController)
                    }
                    item { 
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    )
}


@Composable
fun ListItemBox(name: String, navController: NavHostController) {
       Button(onClick = { navController.navigate(name) },
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
                   text = name,
                   textAlign = TextAlign.Center,
                   modifier = Modifier.weight(1f)
               )
               Icon(Icons.Default.ArrowForward, contentDescription = "Favorite")
           }
       }
}