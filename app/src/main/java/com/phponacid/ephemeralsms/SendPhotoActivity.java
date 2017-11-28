package com.phponacid.ephemeralsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SendPhotoActivity extends AppCompatActivity {

    Button sendPhotoBtn;
    String returnedUrlExtra;
    String returnedPhoneNumber;
    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_photo);

        returnedUrlExtra = getIntent().getStringExtra("RETURNED_URL_EXTRA");
        returnedPhoneNumber = getIntent().getStringExtra("RETURNED_PHONE_NUMBER");


        sendPhotoBtn = (Button) findViewById(R.id.sendPhotoBtn);
        sendPhotoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO: write code to send photo
                sendSMS(); // send text message
            }
        });
    }

    public void sendSMS() {
        smsManager.sendTextMessage(returnedPhoneNumber, null, returnedUrlExtra, null, null);
        Toast.makeText(getApplicationContext(), "SMS Sent :)", Toast.LENGTH_LONG).show();
    }
}
