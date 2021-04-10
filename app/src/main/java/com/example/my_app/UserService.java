package com.example.my_app;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("reg")
    Call<RegisterResponse> registeruser(@Body RegisterRequest registerRequest);

    @POST("login")
    Call<LoginResponse> loginuser(@Body LoginRequest loginRequest);
}
