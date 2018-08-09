package com.marlonmoorer.timeline.di

import android.content.Context
import com.marlonmoorer.timeline.api.WmataService
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule(context: Context) {

    private val context: Context

    init {
        this.context=context
    }

    @Provides
    @Singleton
    fun providesWmataService( client: OkHttpClient):WmataService {
        return Retrofit.Builder()
                .baseUrl(WmataService.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build().create(WmataService::class.java)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request= chain.request().newBuilder().addHeader("api_key","d0e9620068134b70b50eabae2536d88a").build()
            return@addInterceptor chain.proceed(request)
        }.build()
    }
}