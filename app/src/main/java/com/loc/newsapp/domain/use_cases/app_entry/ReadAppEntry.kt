package com.loc.newsapp.domain.use_cases.app_entry

import com.loc.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean> = localUserManager.readAppEntry()
}