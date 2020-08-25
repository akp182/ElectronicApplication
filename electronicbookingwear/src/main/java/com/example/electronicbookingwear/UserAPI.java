package com.example.electronicbookingwear;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("users/login")
    Call<SignUpResponse> checklogin (@Body username Username);
}
