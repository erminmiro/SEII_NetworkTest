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
            String input = inputField.getText().toString();
            responseField.setText(input);
            new Thread(new GetResponse(input)).start();
        });


    }




}