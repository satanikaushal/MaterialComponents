package com.example.materialcomponents

import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.materialcomponents.Chips.AssistChipSample
import com.example.materialcomponents.Chips.ChipGroupReflowSample
import com.example.materialcomponents.Chips.ChipsList
import com.example.materialcomponents.Chips.FilterChipWithLeadingIconSample
import com.example.materialcomponents.ModalNavigationDrawer.DismissibleNavigationDrawerSample
import com.example.materialcomponents.ModalNavigationDrawer.ModalNavigationDrawerSample
import com.example.materialcomponents.ModalNavigationDrawer.ModalNavigationList
import com.example.materialcomponents.ModalNavigationDrawer.NavigationRailSample
import com.example.materialcomponents.alertboxes.AlertBoxSample
import com.example.materialcomponents.alertboxes.AlertBoxWithIcon
import com.example.materialcomponents.alertboxes.AlertBoxesList
import com.example.materialcomponents.badgeBox.NavigationBarItemWithBadge
import com.example.materialcomponents.bottomAppBar.BottomAppBarWithFAB
import com.example.materialcomponents.checkbox.CheckBoxList
import com.example.materialcomponents.checkbox.CheckboxWithTextSample
import com.example.materialcomponents.checkbox.TriStateCheckboxSample
import com.example.materialcomponents.datePickers.DatePickerSample
import com.example.materialcomponents.datePickers.DatePickersList
import com.example.materialcomponents.datePickers.DateRangePickerSample
import com.example.materialcomponents.dropDownMenu.DropDownSample
import com.example.materialcomponents.easing.EasingAnimations
import com.example.materialcomponents.enterAnimations.EnterAnimations
import com.example.materialcomponents.exitAnimations.ExitAnimations
import com.example.materialcomponents.exposedDropDownBox.ExposedDropdownMenuSample
import com.example.materialcomponents.indicators.CircularProgressIndicatorSample
import com.example.materialcomponents.indicators.IndicatorList
import com.example.materialcomponents.indicators.LinearProgressIndicatorSample
import com.example.materialcomponents.inputFields.DockedSearchBarSample
import com.example.materialcomponents.inputFields.InputFieldsList
import com.example.materialcomponents.inputFields.SearchBarSample
import com.example.materialcomponents.inputFields.SimpleOutlinedTextFieldSample
import com.example.materialcomponents.inputFields.SimpleTextFieldSample
import com.example.materialcomponents.listItem.ListItems
import com.example.materialcomponents.modalBottomSheet.ModalBottomSheetSample
import com.example.materialcomponents.navigationBar.NavigationBarSample
import com.example.materialcomponents.sliderList.RangeSliderSample
import com.example.materialcomponents.sliderList.SliderList
import com.example.materialcomponents.sliderList.StepsSliderSample
import com.example.materialcomponents.snackbar.ScaffoldWithCustomSnackbar
import com.example.materialcomponents.swipeToDismiss.SwipeToDismissListItems
import com.example.materialcomponents.switches.SwitchSample
import com.example.materialcomponents.tabs.LeadingIconTabs
import com.example.materialcomponents.timePicker.TimePickerSample
import com.example.materialcomponents.topAppBar.EnterAlwaysTopAppBar
import com.example.materialcomponents.topAppBar.ExitUntilCollapsedMediumTopAppBar
import com.example.materialcomponents.topAppBar.PinnedTopAppBar
import com.example.materialcomponents.topAppBar.SampleTopAppBar
import com.example.materialcomponents.topAppBar.TopAppBarList

@Composable
fun SetUpScreens(navController: NavHostController){
        NavHost(navController = navController, startDestination = Screens.Home.Route){
            composable(route = Screens.Home.Route){
                HomeScreen(navController)
            }
            composable(route = Screens.AlertBoxList.Route){
                AlertBoxesList(navController)
            }
            composable(route = Screens.AlertBoxSample.Route){
                AlertBoxSample(navController)
            }
            composable(route = Screens.AlertBoxIcon.Route){
                AlertBoxWithIcon(navController)
            }
            composable(route = Screens.DropDownSample.Route){
                DropDownSample(navController)
            }
            composable(route = Screens.TopAppBarList.Route){
                TopAppBarList(navController)
            }
            composable(route = Screens.SampleTopAppBar.Route){
                SampleTopAppBar()
            }
            composable(route = Screens.PinnedTopAppBar.Route){
                PinnedTopAppBar()
            }
            composable(route = Screens.EnterAlwaysTopAppBar.Route){
                EnterAlwaysTopAppBar()
            }
            composable(route = Screens.SimpleCenterAlignedTopAppBar.Route){
                SimpleCenterAlignedTopAppBar()
            }
            composable(route = Screens.ExitUntilCollapsedMediumTopAppBar.Route){
                ExitUntilCollapsedMediumTopAppBar()
            }
            composable(route = Screens.BottomAppBarWithFAB.Route){
                BottomAppBarWithFAB(navController)
            }
            composable(route = Screens.NavigationBarItemWithBadge.Route){
                NavigationBarItemWithBadge(navController)
            }
            composable(route = Screens.SimpleBottomSheetScaffoldSample.Route){
                SimpleBottomSheetScaffoldSample(navController)
            }
            composable(route = Screens.CheckBoxList.Route){
                CheckBoxList(navController)
            }
            composable(route = Screens.CheckboxWithTextSample.Route){
                CheckboxWithTextSample()
            }
            composable(route = Screens.TriStateCheckboxSample.Route){
                TriStateCheckboxSample()
            }
            composable(route = Screens.ChipsList.Route){
                ChipsList(navController)
            }
            composable(route = Screens.AssistChipSample.Route){
                AssistChipSample(navController)
            }
            composable(route = Screens.FilterChipWithLeadingIconSample.Route){
                FilterChipWithLeadingIconSample(navController)
            }
            composable(route = Screens.ChipGroupReflowSample.Route){
                ChipGroupReflowSample(navController)
            }
            composable(route = Screens.DatePickersList.Route){
                DatePickersList(navController)
            }
            composable(route = Screens.DatePickerSample.Route){
                DatePickerSample(navController)
            }
            composable(route = Screens.DateRangePickerSample.Route){
                DateRangePickerSample(navController)
            }
            composable(route = Screens.ExposedDropdownMenuSample.Route){
                ExposedDropdownMenuSample(navController)
            }
            composable(route = Screens.ListItem.Route){
                ListItems(navController)
            }
            composable(route = Screens.ModalBottomSheet.Route){
                ModalBottomSheetSample(navController)
            }
            composable(route = Screens.NavigationBarSample.Route){
                NavigationBarSample(navController)
            }
            composable(route = Screens.ModalNavigationList.Route){
                ModalNavigationList(navController)
            }
            composable(route = Screens.ModalNavigationDrawerSample.Route){
                ModalNavigationDrawerSample()
            }
            composable(route = Screens.DismissibleNavigationDrawerSample.Route){
                DismissibleNavigationDrawerSample()
            }
            composable(route = Screens.NavigationRailSample.Route){
                NavigationRailSample(navController)
            }
            composable(route = Screens.InputFieldsList.Route){
                InputFieldsList(navController)
            }
            composable(route = Screens.SimpleOutlinedTextFieldSample.Route){
                SimpleOutlinedTextFieldSample(navController)
            }
            composable(route = Screens.SimpleTextFieldSample.Route){
                SimpleTextFieldSample(navController)
            }
            composable(route = Screens.SearchBarSample.Route){
                SearchBarSample()
            }
            composable(route = Screens.DockedSearchBarSample.Route){
                DockedSearchBarSample()
            }
            composable(route = Screens.IndicatorList.Route){
                IndicatorList(navController)
            }

            composable(route = Screens.LinearProgressIndicatorSample.Route){
                LinearProgressIndicatorSample(navController)
            }

            composable(route = Screens.CircularProgressIndicatorSample.Route){
                CircularProgressIndicatorSample(navController)
            }
            composable(route = Screens.SliderList.Route){
                SliderList(navController)
            }
            composable(route = Screens.StepsSliderSample.Route){
                StepsSliderSample(navController)
            }
            composable(route = Screens.RangeSliderSample.Route){
                RangeSliderSample(navController)
            }
            composable(route = Screens.ScaffoldWithCustomSnackbar.Route){
                ScaffoldWithCustomSnackbar(navController)
            }

            composable(route = Screens.SwipeToDismissListItems.Route){
                SwipeToDismissListItems()
            }
            composable(route = Screens.SwitchSample.Route){
                SwitchSample(navController)
            }
            composable(route = Screens.LeadingIconTabs.Route){
                LeadingIconTabs(navController)
            }
            composable(route = Screens.TimePickerSample.Route){
                TimePickerSample(navController)
            }
            composable(route = Screens.EnterAnimations.Route){
                EnterAnimations(navController)
            }
            composable(route = Screens.ExitAnimations.Route){
                ExitAnimations(navController)
            }
            composable(route = Screens.EasingInAnimations.Route){
                EasingAnimations(navController)
            }
        }
}