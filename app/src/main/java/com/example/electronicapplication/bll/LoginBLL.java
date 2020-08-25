package com.example.electronicapplication.bll;



import com.example.electronicapplication.API.UserAPI;
import com.example.electronicapplication.Model.username;
import com.example.electronicapplication.URL.url;
import com.example.electronicapplication.serverresponse.SignUpResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {

    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {
        com.example.electronicapplication.Model.username Username=new username(username, password);

        UserAPI userAPI= url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> usersCall = userAPI.checklogin(Username);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
