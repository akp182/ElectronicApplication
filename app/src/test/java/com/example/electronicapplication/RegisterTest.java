package com.example.electronicapplication;


import com.example.electronicapplication.API.UserAPI;
import com.example.electronicapplication.Model.User;
import com.example.electronicapplication.URL.url;
import com.example.electronicapplication.serverresponse.SignUpResponse;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

import static junit.framework.TestCase.assertEquals;

public class RegisterTest {

    boolean expected = true;
    boolean actual = false;

    @Test
    public void signupTest() {
        com.example.electronicapplication.Model.User user = new User("ayush", "prasai", "987654321", "ayushprasai", "ayushprasai", null);
        UserAPI userAPI = url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> signUpResponseCall = userAPI.registerUser(user);
        try {
            Response<SignUpResponse> register = signUpResponseCall.execute();
            if (register.isSuccessful() && register.body().getStatus().equals("Signup Success")) {
                actual = false;
            }
            else {
                actual= true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }

    @Test
    public void signupTestfailed() {
        com.example.electronicapplication.Model.User user = new User("ayush", "prasai", "987654321", "ayushprasai", "ayushprasai", null);
        UserAPI userAPI = url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> signUpResponseCall = userAPI.registerUser(user);
        try {
            Response<SignUpResponse> register = signUpResponseCall.execute();
            if (register.isSuccessful() && register.body().getStatus().equals("Signup Success")) {
                actual = false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);

    }
}
