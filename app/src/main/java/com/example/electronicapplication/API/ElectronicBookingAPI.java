package com.example.electronicapplication.API;

import com.example.electronicapplication.Model.ElectronicBooking;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ElectronicBookingAPI {
    @POST("electronicbooking")
    Call<ElectronicBooking> registerelectronicbooking(@Body ElectronicBooking electronicBooking);
}
