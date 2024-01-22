package com.example.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
        double conversionRate= 2.2;
        double weightEntered;
        double convertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final RadioButton kiloToLb= findViewById(R.id.radioButton3);
        final RadioButton lbToKilo= findViewById(R.id.radioButton4);
        final EditText weight= findViewById(R.id.editTextNumber);
        final TextView result= findViewById(R.id.textView2);
        Button convert= findViewById(R.id.button);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weightEntered=Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth= new DecimalFormat("#.#");

                if(kiloToLb.isChecked()) {
                    if (weightEntered <= 255) {
                        convertedWeight = weightEntered * conversionRate;
                        result.setText(tenth.format(convertedWeight) + " pounds");
                    } else {
                        Toast.makeText(MainActivity.this, "Kilos must be less than 255", Toast.LENGTH_LONG).show();
                    }
                }

                if (lbToKilo.isChecked()){
                    if(weightEntered<=500){
                        convertedWeight= weightEntered/conversionRate;
                        result.setText(tenth.format(convertedWeight)+ " Kilograms");
                    }else{
                        Toast.makeText(MainActivity.this, "Pounds must be less than 500", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}