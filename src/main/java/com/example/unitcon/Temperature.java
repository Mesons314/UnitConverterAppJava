package com.example.unitcon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
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

public class Temperature extends AppCompatActivity {
    Toolbar toolbar;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,button3;
    ImageButton btnBack;
    Spinner spinner3, spinner;
    EditText editTextText;
    TextView textView;
    ArrayList<String> temperatureUnits = new ArrayList<>();
    DecimalFormat decimalFormat = new DecimalFormat("#.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

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
        spinner= findViewById(R.id.spinner);
        editTextText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);

        editTextText.setShowSoftInputOnFocus(false);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Unit Coverter");


        temperatureUnits.add("K");
        temperatureUnits.add("°R");
        temperatureUnits.add("°F");
        temperatureUnits.add("°C");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, temperatureUnits);
        spinner3.setAdapter(adapter);
        spinner.setAdapter(adapter);

        editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                convertTemperature();
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertTemperature();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertTemperature();
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
                    Toast.makeText(Temperature.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if(itemId==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void convertTemperature() {
        String tempStr = editTextText.getText().toString().trim();
        if (tempStr.isEmpty()) return;

        double temperature = Double.parseDouble(tempStr);
        double result = 0;

        String fromUnit = spinner3.getSelectedItem().toString();
        String toUnit = spinner.getSelectedItem().toString();

        switch (fromUnit) {
            case "K":
                switch (toUnit) {
                    case "K":
                        result = temperature;
                        break;
                    case "°R":
                        result = temperature * 1.8;
                        break;
                    case "°F":
                        result = temperature * 1.8 - 459.67;
                        break;
                    case "°C":
                        result = temperature - 273.15;
                        break;
                }
                break;
            case "°R":
                switch (toUnit) {
                    case "K":
                        result = temperature * (5.0 / 9.0);
                        break;
                    case "°R":
                        result = temperature;
                        break;
                    case "°F":
                        result = temperature - 459.67;
                        break;
                    case "°C":
                        result = (temperature - 491.67) * (5.0 / 9.0);
                        break;
                }
                break;
            case "°F":
                switch (toUnit) {
                    case "K":
                        result = (temperature + 459.67) * (5.0 / 9.0);
                        break;
                    case "°R":
                        result = temperature + 459.67;
                        break;
                    case "°F":
                        result = temperature;
                        break;
                    case "°C":
                        result = (temperature - 32) * (5.0 / 9.0);
                        break;
                }
                break;
            case "°C":
                switch (toUnit) {
                    case "K":
                        result = temperature + 273.15;
                        break;
                    case "°R":
                        result = (temperature + 273.15) * (9.0 / 5.0);
                        break;
                    case "°F":
                        result = temperature * 1.8 + 32;
                        break;
                    case "°C":
                        result = temperature;
                        break;
                }
                break;
        }

        // Set the result in the TextView after formatting
        textView.setText(decimalFormat.format(result));
    }
}
