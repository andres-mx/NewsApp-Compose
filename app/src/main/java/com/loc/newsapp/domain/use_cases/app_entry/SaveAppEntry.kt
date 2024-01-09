package com.loc.newsapp.domain.use_cases.app_entry

import com.loc.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() = localUserManager.saveAppEntry()
}