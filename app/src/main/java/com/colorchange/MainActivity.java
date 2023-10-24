package com.colorchange;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Main Activity class to open other activity by button click
 */
public class MainActivity extends AppCompatActivity {

    private EditText colorEditText;

    /**
     * Creates text area and button. Text area expects color in text format or hex-code
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorEditText = findViewById(R.id.colorEditText);
        Button launchButton = findViewById(R.id.launchButton);

        launchButton.setOnClickListener(v -> {
            String color = colorEditText.getText().toString().toLowerCase();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("color", color);
            startActivity(intent);
        });
    }
}
