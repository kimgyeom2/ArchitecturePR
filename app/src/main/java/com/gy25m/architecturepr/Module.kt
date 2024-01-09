package com.gy25m.architecturepr

import android.content.Context
import androidx.room.Room
import com.gy25m.architecturepr.apiservice.ApiService
import com.gy25m.architecturepr.dao.UserDao
import com.gy25m.architecturepr.db.AppDatabase
import com.gy25m.architecturepr.repository.LoginRepository
import com.gy25m.architecturepr.repositoryimpl.LoginRepositoryImpl
import com.gy25m.architecturepr.usecase.LoginUsecase
import com.gy25m.architecturepr.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


// Koin

//var networkModule= module {
//    single {
//        Retrofit.Builder()
//            .baseUrl("https://jsonplaceholder.typicode.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//    }
//}
//
//val repositoryModule = module {
//    single<LoginRepository> {LoginRepositoryImpl(apiService = get())}
//}
//
//val useCaseModule = module {
//    factory { LoginUsecase(loginRepository = get()) }
//}
//
//val viewModelModule = module {
//    viewModel {
//        LoginViewModel(loginUsecase = get())
//    }
//}


// Hilt
@Module
@InstallIn(SingletonComponent::class)
object MyModule {

    @Provides
    @Singleton
    fun provideMyInterface( retrofit: ApiService,
                            appDatabase: AppDatabase): LoginRepository = LoginRepositoryImpl(retrofit,appDatabase)


    @Provides
    @Singleton
    fun provideRetrofit(): ApiService{
        // HTTP 인터셉터 생성
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // OkHttpClient 생성하고 인터셉터 설정
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient) // OkHttpClient 설정
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }





}