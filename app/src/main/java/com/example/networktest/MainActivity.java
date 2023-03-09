package com.example.networktest;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputField;
    private TextView responseField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.editTextNumber);

        responseField = findViewById(R.id.responseField);

        Button checkTimeButton = findViewById(R.id.button);
        Button checkSumButton = findViewById(R.id.checkSumButton);

        checkSumButton.setOnClickListener(v -> {
            String input = inputField.getText().toString();
            QuerSum querSum = new QuerSum(input);
            querSum.calculateQuerSum();
            int result = querSum.getSum();
            responseField.setText("The alternating checksum of your Marticulation ID is : "+result);
        });


        checkTimeButton.setOnClickListener(v -> {

            String input = inputField.getText().toString();
            responseField.setText(startThread(input));
        });
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