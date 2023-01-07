package com.example.ponlineapp.network.repository

import androidx.lifecycle.LiveData
import com.example.ponlineapp.network.dto.TokenDto
import com.example.ponlineapp.network.modelDatabase.User
import com.example.ponlineapp.network.modelDatabase.UserDao
import kotlinx.coroutines.delay
import javax.inject.Inject

interface UserRepository {
    suspend fun getNewUser(): User
    suspend fun deleteUser(toDelete: User)
    fun getAllUsers(): LiveData<List<User>>

}

class UserRepositoryImp @Inject constructor(
    private val dataSource: TokenDto,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getNewUser(): User {
        delay(3000)
        val token = dataSource.accessToken
        val user = User(token)
        userDao.insert(user)
        return user
    }

    override fun getAllUsers() = userDao.getAll()

    override suspend fun deleteUser(toDelete: User) = userDao.delete(toDelete)

}
