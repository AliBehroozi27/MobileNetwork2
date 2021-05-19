package com.example.di

import com.example.app.executor.BackgroundThread
import com.example.app.executor.MainThread
import com.example.data.datasource.ProfessorLocalDataSource
import com.example.data.repository.ProfessorRepositoryImpl
import com.example.domain.executor.PostExecutorThread
import com.example.domain.executor.UseCaseExecutorThread
import com.example.domain.repository.ProfessorRepository
import com.example.local.datasource.ProfessorLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun providePostExecutorThread(): PostExecutorThread = MainThread()

    @Provides
    fun provideUseCaseExecutorThread(): UseCaseExecutorThread = BackgroundThread()

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