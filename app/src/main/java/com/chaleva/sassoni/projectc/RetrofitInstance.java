package com.chaleva.sassoni.projectc;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by sassa on 4/5/16.
 */
public enum RetrofitInstance {
    INSTANCE;

    private Retrofit mRetrofit;

    RetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.songkick.com/api/3.0/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
