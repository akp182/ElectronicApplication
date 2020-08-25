package com.example.electronicapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.electronicapplication.API.ElectronicBookingAPI;
import com.example.electronicapplication.Model.ElectronicBooking;
import com.example.electronicapplication.URL.url;
import com.example.electronicapplication.createchannel.CreateChannel;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity  extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private NotificationManagerCompat notificationManagerCompat;
    private int counter = 1;
    private EditText cfullname, ccontact, clocation, cproblem;

    private TextView  date, time;
    private Button btncdate, btnctime, btncbook;
    int y1, m1, d1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        cfullname = findViewById(R.id.cfullname);
        ccontact = findViewById(R.id.ccontact);
        clocation = findViewById(R.id.clocation);
        cproblem = findViewById(R.id.cproblem);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        btncdate = findViewById(R.id.btncdate);
        btnctime = findViewById(R.id.btnctime);
        btncbook = findViewById(R.id.btncbook);



        btncbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter+=counter+1;
                if(TextUtils.isEmpty(cfullname.getText())){
                    cfullname.setError("Please enter your fullname");
                    return;
                }
                else if(TextUtils.isEmpty(ccontact.getText())){
                    ccontact.setError("Please enter your contact number");
                    return;
                }
                else if(TextUtils.isEmpty(clocation.getText())){
                    clocation.setError("Please enter your location");
                    return;
                }

                else if(TextUtils.isEmpty(cproblem.getText())){
                    cproblem.setError("Please enter problem on vehicle");
                    return;
                }
                else if(TextUtils.isEmpty(btncdate.getText())){
                    btncdate.setError("Please enter date");
                    return;
                }
                else if(TextUtils.isEmpty(btnctime.getText())){
                    btnctime.setError("Please enter time");
                    return;
                }

                else {
                    registercarbooking();
                }

                DisplayNotification();



            }
        });

        btncdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
        btnctime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
    }

    private void registercarbooking() {
        String name=cfullname.getText().toString();
        String contact=ccontact.getText().toString();
        String location=clocation.getText().toString();
        String problem=cproblem.getText().toString();

        String date=btncdate.getText().toString();
        String time=btnctime.getText().toString();

        ElectronicBooking electronicBooking=new ElectronicBooking(name,contact,location,problem,date,time);

        ElectronicBookingAPI electronicBookingAPI= url.getInstance().create(ElectronicBookingAPI.class);
        Call<ElectronicBooking> electronicBookingCall=electronicBookingAPI.registerelectronicbooking(electronicBooking);
        electronicBookingCall.enqueue(new Callback<ElectronicBooking>() {
            @Override
            public void onResponse(Call<ElectronicBooking> call, Response<ElectronicBooking> response) {
                if (! response.isSuccessful()) {
                    Toast.makeText(BookingActivity.this, "Error : API is not responding " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(BookingActivity.this, "Booked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ElectronicBooking> call, Throwable t) {
                Toast.makeText(BookingActivity.this, "Error : Network Problem  and Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }






    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_border_all_black_24dp)
                .setContentTitle("Notification")
                .setContentText("Succesfully Booked")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(counter, notification);

    }

    private void loadTime() {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int Minute = calendar.get(Calendar.MINUTE);

        boolean is24HourFormat = DateFormat.is24HourFormat(this);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = "hour:" + hourOfDay + "minute :" + minute;
                btnctime.setText(timeString);
            }
        }, HOUR,Minute,is24HourFormat);
        timePickerDialog.show();




    }

    private void loadDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Select Date:" + (month+1) + "/" + dayOfMonth + "/" + year;
        y1= year;
        m1= month;
        d1= dayOfMonth;

        btncdate.setText(date);

    }

}