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

import java.math.BigInteger;
import java.util.ArrayList;

public class Numeral extends AppCompatActivity {

    Toolbar toolbar;
    Spinner spinner3, spinner;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndot, button3, btnA, btnB, btnC, btnD, btnE, btnF;
    ImageButton btnBack;
    EditText editTextText;
    TextView textView;
    ArrayList<String> numeralSystems = new ArrayList<>();

    int fromBase = 10; // Default base is decimal
    int toBase = 10; // Default base is decimal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeral);

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
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);
        btndot = findViewById(R.id.btndot);
        button3 = findViewById(R.id.button3);
        btnBack = findViewById(R.id.btnBack);
        spinner3 = findViewById(R.id.spinner3);
        spinner = findViewById(R.id.spinner);
        editTextText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Unit Converter");

        editTextText.setShowSoftInputOnFocus(false);

        // Populate numeral systems array
        numeralSystems.add("Binary");
        numeralSystems.add("Decimal");
        numeralSystems.add("Hexadecimal");
//        numeralSystems.add("Octal");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numeralSystems);
        spinner3.setAdapter(adapter);
        spinner.setAdapter(adapter);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner3.getSelectedItem().toString().equals("Decimal")) {
                    btn1.setEnabled(true);
                    btn0.setEnabled(true);
                    btn3.setEnabled(true);
                    btn2.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    btn6.setEnabled(true);
                    btn7.setEnabled(true);
                    btn8.setEnabled(true);
                    btn9.setEnabled(true);
                    btnA.setEnabled(false);
                    btnB.setEnabled(false);
                    btnC.setEnabled(false);
                    btnD.setEnabled(false);
                    btnE.setEnabled(false);
                    btnF.setEnabled(false);
                }
                else if (spinner3.getSelectedItem().toString().equals("Hexadecimal")){
                    btn1.setEnabled(true);
                    btn0.setEnabled(true);
                    btn3.setEnabled(true);
                    btn2.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    btn6.setEnabled(true);
                    btn7.setEnabled(true);
                    btn8.setEnabled(true);
                    btn9.setEnabled(true);
                    btnA.setEnabled(true);
                    btnB.setEnabled(true);
                    btnC.setEnabled(true);
                    btnD.setEnabled(true);
                    btnE.setEnabled(true);
                    btnF.setEnabled(true);
                }
                else {
                    btn1.setEnabled(true);
                    btn0.setEnabled(true);
                    btn3.setEnabled(false);
                    btn2.setEnabled(false);
                    btn4.setEnabled(false);
                    btn5.setEnabled(false);
                    btn6.setEnabled(false);
                    btn7.setEnabled(false);
                    btn8.setEnabled(false);
                    btn9.setEnabled(false);
                    btnA.setEnabled(false);
                    btnB.setEnabled(false);
                    btnC.setEnabled(false);
                    btnD.setEnabled(false);
                    btnE.setEnabled(false);
                    btnF.setEnabled(false);
                }
                updateBase(position, true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateBase(position, false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                convertNumeral();
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
                    Toast.makeText(Numeral.this, "Nothing to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listeners for numeral buttons
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
        btnA.setOnClickListener(numeralButtonClickListener);
        btnB.setOnClickListener(numeralButtonClickListener);
        btnC.setOnClickListener(numeralButtonClickListener);
        btnD.setOnClickListener(numeralButtonClickListener);
        btnE.setOnClickListener(numeralButtonClickListener);
        btnF.setOnClickListener(numeralButtonClickListener);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextText.setText("");
                textView.setText("");
            }
        });
    }

    // Click listener for numeral buttons
    private View.OnClickListener numeralButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            editTextText.append(btn.getText().toString());
        }
    };

    private void updateBase(int position, boolean isFrom) {
        switch (position) {
            case 0: // Binary
                fromBase = isFrom ? 2 : fromBase;
                toBase = !isFrom ? 2 : toBase;
                break;
            case 1: // Decimal
                fromBase = isFrom ? 10 : fromBase;
                toBase = !isFrom ? 10 : toBase;
                break;
            case 2: // Hexadecimal
                fromBase = isFrom ? 16 : fromBase;
                toBase = !isFrom ? 16 : toBase;
                break;
        }
        convertNumeral();
    }

    private void convertNumeral() {
        String numberStr = editTextText.getText().toString().trim();
        if (numberStr.isEmpty()) return;

        try {
            BigInteger number = new BigInteger(numberStr, fromBase);
            String result = number.toString(toBase).toUpperCase();
            textView.setText(result);
        } catch (NumberFormatException e) {
            textView.setText("Invalid input");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
