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

        checkTimeButton.setOnClickListener(v -> {
            try {

                String input = inputField.getText().toString();

                GetResponse responseClass = new GetResponse(input);
                Thread responseThread = new Thread(responseClass);

                responseThread.start();

                responseThread.join();

                responseField.setText(responseClass.getResponse());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


    }




}