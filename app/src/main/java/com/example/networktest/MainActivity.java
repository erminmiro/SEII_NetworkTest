package com.example.networktest;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private TextView responseField;
    private TextWatcher textWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.editTextNumber);

        responseField = findViewById(R.id.responseField);

        Button checkTimeButton = findViewById(R.id.button);
        Button checkSumButton = findViewById(R.id.checkSumButton);

        checkSumButton.setEnabled(false);
        checkTimeButton.setEnabled(false);

        inputField.addTextChangedListener(new NoInputWatcher() {
            @Override
            public void onEmptyField() {
                checkSumButton.setEnabled(false);
                checkTimeButton.setEnabled(false);
            }

            @Override
            public void onFilledField() {
                checkSumButton.setEnabled(true);
                checkTimeButton.setEnabled(true);

            }
        });


        checkSumButton.setOnClickListener(v -> {
            String input = inputField.getText().toString();
            responseField.setText(getQuerSum(input));
        });


        checkTimeButton.setOnClickListener(v -> {

            String input = inputField.getText().toString();
            responseField.setText(startThread(input));
        });
    }




    public String getQuerSum(String input){

        QuerSum querSum = new QuerSum(input);
        querSum.calculateQuerSum();

        int result = querSum.getSum();

        return "The alternating checksum of your Marticulation ID is : "+result;
    }



    public String startThread(String input){
            try {

                GetResponse responseClass = new GetResponse(input);
                Thread responseThread = new Thread(responseClass);

                responseThread.start();
                responseThread.join();

                return responseClass.getResponse();

            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }





}