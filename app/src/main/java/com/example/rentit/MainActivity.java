package com.example.rentit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rentit.menuScreens.buyScreen;
import com.example.rentit.menuScreens.freeScreen;
import com.example.rentit.order.deliverybuy;
import com.example.rentit.order.orderBuy;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    String emails;
    String name , description , rating , address , image;

    EditText n , d , r , a;
    ImageView i;
    Button cancel , next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        // hide the title bar

        // login info passing
        Intent intents = getIntent();
        emails = intents.getStringExtra("emails");
        name  = intents.getStringExtra("name");
        description = intents.getStringExtra("description");
        rating = intents.getStringExtra("rating");
        address  = intents.getStringExtra("address");
        image = intents.getStringExtra("image");
        // login info passing

        setContentView(R.layout.activity_main);

        i = findViewById(R.id.p_image2);
        Glide.with(MainActivity.this).load(image).into(i);

        n = findViewById(R.id.p_name2);
        d = findViewById(R.id.p_des2);
        a = findViewById((R.id.p_address));
        r = findViewById(R.id.p_rating2);
        n.setText(name);
        d.setText(description);
        a.setText(address);
        r.setText(rating);


        cancel = findViewById(R.id.cancel2);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , freeScreen.class);
                // pass login data to menu
                intent.putExtra("emails" ,emails);
                // pass login data to menu
                startActivity(intent); // go to sell screen
            }
        });


        next = findViewById(R.id.confirm2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                // pass login data to menu
                intent.putExtra("emails" ,emails);
                // pass login data to menu
                startActivity(intent); // go to sell screen
            }
        });
    }

    public void onBackPressed() {

        Intent intent = new Intent(MainActivity.this, freeScreen.class);
        // pass login data to menu
        intent.putExtra("emails", emails);
        // pass login data to menu
        startActivity(intent); // go to sell screen

        super.onBackPressed();
    }
}