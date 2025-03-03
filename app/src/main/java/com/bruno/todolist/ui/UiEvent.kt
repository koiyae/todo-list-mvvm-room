package com.bruno.todolist.ui

sealed interface UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent
    data object NavigateBack : UiEvent
    data class Navigate<T : Any>(val route: T) : UiEvent
}