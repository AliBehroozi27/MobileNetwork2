package com.example.myapplication.di

import com.example.data.datasource.ProfessorLocalDataSource
import com.example.data.repository.ProfessorRepositoryImpl
import com.example.usecase.repository.ProfessorRepository
import com.example.local.datasource.ProfessorLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideProfessorRepository(
        professorLocalDataSource: ProfessorLocalDataSource
    ): ProfessorRepository {
        return ProfessorRepositoryImpl(professorLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideProfessorLocalDataSource(): ProfessorLocalDataSource {
        return ProfessorLocalDataSourceImpl() // TODO: pass local data parser (e.g json or sth)
    }
}