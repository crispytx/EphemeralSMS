package com.phponacid.ephemeralsms;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectContactActivity extends AppCompatActivity {

    ImageView selectContactBtn;
    String extraUrlReceived;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // for some reason this activity does not feature an action bar,
        // so the code that disables the action bar has been removed (NullPointerException)

        /*
        TextView activitySelectContactH1 = (TextView) findViewById(R.id.activitySelectContactH1);
        TextView activitySelectContactH2 = (TextView) findViewById(R.id.activitySelectContactH2);
        TextView activitySelectContactH3 = (TextView) findViewById(R.id.activitySelectContactH3);
        Typeface typeFace= Typeface.createFromAsset(getAssets(),"fonts/chunkfive.otf");
        activitySelectContactH1.setTypeface(typeFace);
        activitySelectContactH2.setTypeface(typeFace);
        activitySelectContactH3.setTypeface(typeFace);
        */

        setContentView(R.layout.activity_select_contact);

        TextView activitySelectContactH1 = (TextView) findViewById(R.id.activitySelectContactH1);
        TextView activitySelectContactH2 = (TextView) findViewById(R.id.activitySelectContactH2);
        TextView activitySelectContactH3 = (TextView) findViewById(R.id.activitySelectContactH3);
        Typeface typeFace= Typeface.createFromAsset(getAssets(),"fonts/chunkfive.otf");
        activitySelectContactH1.setTypeface(typeFace);
        activitySelectContactH2.setTypeface(typeFace);
        activitySelectContactH3.setTypeface(typeFace);

        Intent intent = getIntent();
        extraUrlReceived = intent.getStringExtra("EXTRA_URL");

        selectContactBtn = (ImageView) findViewById(R.id.selectContactBtn);
        selectContactBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO: write code to select contact
                launchAddressBookActivity();
            }
        });
    }

    public void launchAddressBookActivity() {
        Intent i = new Intent(this, AddressBookActivity.class);
        // TODO: pass data via intent-extra
        i.putExtra("URL_EXTRA", extraUrlReceived);
        startActivity(i);
        finish(); // kill activity after new activity launches
    }
}
