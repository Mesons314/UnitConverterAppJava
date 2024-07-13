package com.example.unitcon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
CardView storage,tempe,speed,weigh,len,numeric;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = findViewById(R.id.storage);
        tempe = findViewById(R.id.tempe);
        speed = findViewById(R.id.speed);
        weigh = findViewById(R.id.weigh);
        len = findViewById(R.id.len);
        numeric = findViewById(R.id.numeric);

       storage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), Data.class);
               startActivity(intent);
           }
       });

        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Speed.class);
                startActivity(intent);
            }
        });

        weigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTenet = new Intent(getApplicationContext(), Weight.class);
                startActivity(iTenet);
            }
        });

        tempe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Temperature.class);
                startActivity(intent);
            }
        });

        numeric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Numeral.class);
                startActivity(intent);
            }
        });

        len.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Length.class);
                startActivity(intent);
            }
        });

    }
}