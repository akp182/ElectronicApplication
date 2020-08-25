package com.example.electronicapplication;



import com.example.electronicapplication.API.UserAPI;
import com.example.electronicapplication.Model.username;
import com.example.electronicapplication.URL.url;
import com.example.electronicapplication.serverresponse.SignUpResponse;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginTest {

    boolean actual = false;
    boolean expected= true;

    @Test
    public void Login(){
        com.example.electronicapplication.Model.username Username = new username("ayushprasai","ayushprasai");
        UserAPI userAPI = url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> usersCall = userAPI.checklogin(Username);

        try{
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() && loginResponse.body().getStatus().equals("Login Success")) {
                actual=false;
            }
            else {
                actual=true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
