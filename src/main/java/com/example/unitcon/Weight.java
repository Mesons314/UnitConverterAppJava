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

public class Weight extends AppCompatActivity {
    Toolbar toolbar;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btndot,button3;
    ImageButton btnBack;
    Spinner spinner3, spinner;
    EditText editTextText;
    TextView textView;
    ArrayList<String> arrWeight = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

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

        arrWeight.add("kg");
        arrWeight.add("g");
        arrWeight.add("lbs");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrWeight);
        spinner3.setAdapter(adapter);
        spinner.setAdapter(adapter);


        editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                updateConvertedWeight();
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateConvertedWeight();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                updateConvertedWeight();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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


    private void updateConvertedWeight() {
        String str = editTextText.getText().toString();
        if (str.isEmpty()) return; // Return if editTextText is empty
        float weight = Float.parseFloat(str);

        int spin3 = spinner3.getSelectedItemPosition();
        int start = spinner.getSelectedItemPosition();

        double convertedWeight = 0;
        switch (spin3) {
            case 0: //kg
                switch (start) {
                    case 0: //kg
                        convertedWeight = weight;
                        break;
                    case 1: //g
                        convertedWeight = weight * 1000;
                        break;
                    case 2: // lbs
                        convertedWeight = weight * 2.205;
                        break;
                }
                break;
            case 1: // g
                switch (start) {
                    case 0: // kg
                        convertedWeight = weight / 1000;
                        break;
                    case 1: // g
                        convertedWeight = weight;
                        break;
                    case 2: // lbs
                        convertedWeight = weight / 453.592;
                        break;
                }
                break;
            case 2: // lbs
                switch (start) {
                    case 0: // kg
                        convertedWeight = weight / 2.205;
                        break;
                    case 1: // g
                        convertedWeight = weight * 453.592;
                        break;
                    case 2: // lbs
                        convertedWeight = weight;
                        break;
                }
                break;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        textView.setText(decimalFormat.format(convertedWeight));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editTextText.getText().toString();
//                String res = textView.getText().toString();
                if (!str.isEmpty()) {
                    editTextText.setText(str.substring(0, str.length() - 1));

                } else {
                    textView.setText("");
                    Toast.makeText(Weight.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
