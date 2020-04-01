package net.kathir.livedata.service;

import net.kathir.livedata.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {

    @GET("latest")
    Call<ResponseModel> getResponseData();
}
