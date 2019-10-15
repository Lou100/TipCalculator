package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Referencing widgets
    private EditText billAmountID;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView resultID;
    private TextView textViewSeekBar;
    private int seekBarPercentage;
    private float enteredBillFloat;
    private TextView totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Finding the widgets in main activity

        billAmountID = (EditText) findViewById(R.id.billAmountID);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        resultID = (TextView) findViewById(R.id.resultID);
        textViewSeekBar = (TextView) findViewById(R.id.textViewSeekBar);
        totalBill= (TextView) findViewById(R.id.textView);

        //Programming button to work with seekBar
        calculateButton.setOnClickListener(this);
        //Programming the seekBar movement
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Setting textViewSeekBar to display movement progress
                textViewSeekBar.setText(String.valueOf(seekBar.getProgress()) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Programming seekBar as a percentage
                seekBarPercentage = seekBar.getProgress();

            }
        });






    }

    @Override
    public void onClick(View v) {
        //When button is click calculate the equation below
        calculate();

    }

    public void calculate() {
        /*If statement to calculate the equation if no number is entered
        "Please enter a bill amount." will be displayed
         */
        float result = 0.0f;
        if (!billAmountID.getText().toString().equals("")){


        enteredBillFloat = Float.parseFloat(billAmountID.getText().toString());
        result = enteredBillFloat * seekBarPercentage / 100;
        resultID.setText("Your tip will be: " +  "$" + String.valueOf(result));
        totalBill.setText("Total bill: " + "$" +  String.valueOf(enteredBillFloat + result));
    }else{
            Toast.makeText(MainActivity.this,"Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }
    }
}
