package com.marlonmoorer.timeline.di

import android.content.Context
import com.marlonmoorer.timeline.api.WmataService
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

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
                .client(client)
                .build().create(WmataService::class.java)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request= chain.request().newBuilder().addHeader("api_key","").build()
            return@addInterceptor chain.proceed(request)
        }.build()
    }
}