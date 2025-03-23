package com.example.elearningapp.data.manager

import com.example.elearningapp.data.DataManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * ProfileManager - класс для управления данными профиля пользователя
 * Служит промежуточным слоем между UI и хранилищем данных
 */
class ProfileManager(private val dataManager: DataManager) {

    // Состояние загрузки
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Состояние ошибки
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    // Получение потоков данных из DataManager
    val userNameFlow: Flow<String> = dataManager.userNameFlow
    val userEmailFlow: Flow<String> = dataManager.userEmailFlow
    val notificationsEnabledFlow: Flow<Boolean> = dataManager.notificationsEnabledFlow

    // Обновление имени пользователя
    suspend fun updateUserName(name: String) {
        try {
            _isLoading.value = true
            dataManager.saveUserName(name)
        } catch (e: Exception) {
            _error.value = "Failed to update name: ${e.message}"
        } finally {
            _isLoading.value = false
        }
    }

    // Обновление email пользователя
    suspend fun updateUserEmail(email: String) {
        try {
            _isLoading.value = true
            dataManager.saveUserEmail(email)
        } catch (e: Exception) {
            _error.value = "Failed to update email: ${e.message}"
        } finally {
            _isLoading.value = false
        }
    }

    // Обновление настройки уведомлений
    suspend fun updateNotificationsEnabled(enabled: Boolean) {
        try {
            _isLoading.value = true
            dataManager.saveNotificationsEnabled(enabled)
        } catch (e: Exception) {
            _error.value = "Failed to update notifications: ${e.message}"
        } finally {
            _isLoading.value = false
        }
    }

    // Очистка ошибки
    fun clearError() {
        _error.value = null
    }
}

