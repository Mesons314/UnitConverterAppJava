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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Data extends AppCompatActivity {
Toolbar toolbar;
    Spinner spinner3, spinner;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,button3;
    ImageButton btnBack;
    EditText editTextText;
    TextView textView;
    ArrayList<String> dataUnits = new ArrayList<>();
    double[] unitValues = {1, 1024, Math.pow(1024, 2), Math.pow(1024, 3)};
    DecimalFormat decimalFormat = new DecimalFormat("#.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

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

        dataUnits.add("MB");
        dataUnits.add("KB");
        dataUnits.add("GB");
        dataUnits.add("TB");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dataUnits);
        spinner3.setAdapter(adapter);
        spinner.setAdapter(adapter);


        editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                convertData();
            }
        });


        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convertData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };

        spinner3.setOnItemSelectedListener(listener);
        spinner.setOnItemSelectedListener(listener);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editTextText.getText().toString();
                if (!str.isEmpty()) {
                    editTextText.setText(str.substring(0, str.length() - 1));

                } else {
                    textView.setText("");
                    Toast.makeText(Data.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
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

    private void convertData() {
        String dataStr = editTextText.getText().toString().trim();
        if (dataStr.isEmpty()) return;

        double data = Double.parseDouble(dataStr);
        double result = 0;

        String fromUnit = spinner3.getSelectedItem().toString();
        String toUnit = spinner.getSelectedItem().toString();
        switch (fromUnit){
            case "KB":
                switch (toUnit){
                    case "KB":
                        result = data;
                        break;
                    case "MB":
                        result = data*0.00097;
                        break;
                    case "GB":
                        result = data*0.0000009;
                        break;
                    case "TB":
                        result = data*0.0000000009;
                        break;
                }
                break;
            case "MB":
                switch (toUnit){
                    case "KB":
                       result = data*1024;
                       break;
                    case "MB":
                        result = data;
                        break;
                    case "GB":
                        result = data*0.000976;
                        break;
                    case "TB":
                        result = data*0.00000095;
                        break;
                }
                break;
            case "GB":
                switch (toUnit){
                    case "KB":
                        result = data*1048576;
                        break;
                    case "MB":
                        result = data*1024;
                        break;
                    case "GB":
                        result = data;
                        break;
                    case "TB":
                        result = data*0.00097;
                        break;
                }
                break;
            case "TB":
                switch (toUnit){
                    case "KB":
                        result = data*1073741824;
                        break;
                    case "MB":
                        result = data*1048576;
                        break;
                    case "GB":
                        result = data*1024;
                        break;
                    case "TB":
                        result = data*1;
                        break;
                }
                break;
        }
        textView.setText(decimalFormat.format(result));
    }
}
