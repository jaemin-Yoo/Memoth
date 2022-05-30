package com.jaemin.memoth.di.module

import android.app.Application
import androidx.room.Room
import com.jaemin.data.products.datasource.WordDatabase
import com.jaemin.data.products.repository.WordRepositoryImpl
import com.jaemin.domain.products.repository.WordRepository
import com.jaemin.domain.products.usecase.DeleteWordUseCase
import com.jaemin.domain.products.usecase.GetWordsUseCase
import com.jaemin.domain.products.usecase.WordUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideWordDatabase(app: Application): WordDatabase {
        return Room.databaseBuilder(
            app,
            WordDatabase::class.java,
            WordDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideWordRepository(db: WordDatabase): WordRepository {
        return WordRepositoryImpl(db.wordDao)
    }

    @Provides
    @Singleton
    fun provideWordUseCases(repository: WordRepository): WordUseCases {
        return WordUseCases(
            getWords = GetWordsUseCase(repository),
            deleteWord = DeleteWordUseCase(repository)
        )
    }
}