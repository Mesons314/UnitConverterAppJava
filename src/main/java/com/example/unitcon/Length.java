package com.example.unitcon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

public class Length extends AppCompatActivity {
Toolbar toolbar;
    Spinner spinner3, spinner;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,button3;
    ImageButton btnBack;
    EditText editTextText;
    TextView textView;
    ArrayList<String> lengthUnits = new ArrayList<>();
    DecimalFormat decimalFormat = new DecimalFormat("#.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);


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

        // Populate length units array
        lengthUnits.add("cm");
        lengthUnits.add("m");
        lengthUnits.add("km");
        lengthUnits.add("in");
        lengthUnits.add("ft");
        lengthUnits.add("mile");

        // Create adapter for spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lengthUnits);
        spinner3.setAdapter(adapter);
        spinner.setAdapter(adapter);


        editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                convertLength();
            }
        });


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertLength();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertLength();
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
                    Toast.makeText(Length.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
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

    private void convertLength() {
        String lengthStr = editTextText.getText().toString().trim();
        if (lengthStr.isEmpty()) return;

        double length = Double.parseDouble(lengthStr);
        double result = 0;

        String fromUnit = spinner3.getSelectedItem().toString();
        String toUnit = spinner.getSelectedItem().toString();

        // Conversion logic
        switch (fromUnit) {
            case "cm":
                switch (toUnit) {
                    case "cm":
                        result = length;
                        break;
                    case "m":
                        result = length / 100;
                        break;
                    case "km":
                        result = length / 100000;
                        break;
                    case "in":
                        result = length / 2.54;
                        break;
                    case "ft":
                        result = length / 30.48;
                        break;
                }
                break;
            case "m":
                switch (toUnit) {
                    case "cm":
                        result = length * 100;
                        break;
                    case "m":
                        result = length;
                        break;
                    case "km":
                        result = length / 1000;
                        break;
                    case "in":
                        result = length * 39.37;
                        break;
                    case "ft":
                        result = length * 3.281;
                        break;
                }
                break;
            case "km":
                switch (toUnit) {
                    case "cm":
                        result = length * 100000;
                        break;
                    case "m":
                        result = length * 1000;
                        break;
                    case "km":
                        result = length;
                        break;
                    case "in":
                        result = length * 39370.079;
                        break;
                    case "ft":
                        result = length * 3280.84;
                        break;
                }
                break;
            case "in":
                switch (toUnit) {
                    case "cm":
                        result = length * 2.54;
                        break;
                    case "m":
                        result = length * 0.0254;
                        break;
                    case "km":
                        result = length * 0.0000254;
                        break;
                    case "in":
                        result = length;
                        break;
                    case "ft":
                        result = length / 12;
                        break;
                }
                break;
            case "ft":
                switch (toUnit) {
                    case "cm":
                        result = length * 30.48;
                        break;
                    case "m":
                        result = length * 0.3048;
                        break;
                    case "km":
                        result = length * 0.0003048;
                        break;
                    case "in":
                        result = length * 12;
                        break;
                    case "ft":
                        result = length;
                        break;
                }
                break;
            case "mi":
                switch (toUnit) {
                    case "cm":
                        result = length * 160934;
                        break;
                    case "m":
                        result = length * 1609.34;
                        break;
                    case "km":
                        result = length * 1.60934;
                        break;
                    case "in":
                        result = length * 63360;
                        break;
                    case "ft":
                        result = length * 5280;
                        break;
                    case "mi":
                        result = length;
                        break;
                }
                break;

        }

        textView.setText(decimalFormat.format(result));

    }
}
