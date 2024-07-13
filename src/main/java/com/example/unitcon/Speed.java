package com.example.unitcon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Speed extends AppCompatActivity {
    Toolbar toolbar;
     Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,button3;
     ImageButton btnBack;
    Spinner spinner3,spinner;
    EditText editTextText;
    TextView textView;
    ArrayList<String> arrSpeed = new ArrayList<>();
    DecimalFormat decimalFormat = new DecimalFormat("#.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        Intent intent = getIntent();

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btndot = findViewById(R.id.btndot);
        button3 = findViewById(R.id.button3);
        btnBack = findViewById(R.id.btnBack);
        spinner3 = findViewById(R.id.spinner3);
        spinner = findViewById(R.id.spinner);
        editTextText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);

        editTextText.setShowSoftInputOnFocus(false);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Unit Coverter");

        arrSpeed.add("m/s");
        arrSpeed.add("km/s");
        arrSpeed.add("km/h");
        arrSpeed.add("mph");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrSpeed);
        spinner.setAdapter(adapter);
        spinner3.setAdapter(adapter);


            editTextText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
                @Override
                public void afterTextChanged(Editable s) {
                    updatedSpeed();
                }
            });

            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updatedSpeed();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    updatedSpeed();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editTextText.getText().toString();
                if (!str.isEmpty()) {
                    editTextText.setText(str.substring(0, str.length() - 1));

                } else {
                    textView.setText("");
                    Toast.makeText(Speed.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("8");
            }
        });
       btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append("0");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.append(".");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.setText("");
                textView.setText("");
            }
        });
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if(itemId==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updatedSpeed() {
        String str = editTextText.getText().toString();
        if (str.isEmpty()) return; // Return if editTextText is empty
        float speed = Float.parseFloat(str);
        double result = 0;

        String selectedFrom = spinner3.getSelectedItem().toString();
        String selectedTo = spinner.getSelectedItem().toString();

        // Conversion logic
        switch (selectedFrom) {
            case "m/s":
                switch (selectedTo) {
                    case "m/s":
                        result = speed;
                        break;
                    case "km/s":
                        result = speed * 0.001;
                        break;
                    case "km/h":
                        result = speed * 3.6;
                        break;
                    case "mph":
                        result = speed * 2.23694;
                        break;
                }
                break;
            case "km/s":
                switch (selectedTo) {
                    case "m/s":
                        result = speed * 1000;
                        break;
                    case "km/s":
                        result = speed;
                        break;
                    case "km/h":
                        result = speed * 3600;
                        break;
                    case "mph":
                        result = speed * 2236.94;
                        break;
                }
                break;
            case "km/h":
                switch (selectedTo) {
                    case "m/s":
                        result = speed * 0.277778;
                        break;
                    case "km/s":
                        result = speed * 0.000277778;
                        break;
                    case "km/h":
                        result = speed;
                        break;
                    case "mph":
                        result = speed * 0.621371;
                        break;
                }
                break;
            case "mph":
                switch (selectedTo) {
                    case "m/s":
                        result = speed * 0.44704;
                        break;
                    case "km/s":
                        result = speed * 0.00044704;
                        break;
                    case "km/h":
                        result = speed * 1.60934;
                        break;
                    case "mph":
                        result = speed;
                        break;
                }
                break;
        }
        textView.setText(decimalFormat.format(result));
    }
}

