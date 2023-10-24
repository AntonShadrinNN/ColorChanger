package com.colorchange;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

/**
 * This activity display color from previous activity or exception message
 */
public class SecondActivity extends AppCompatActivity {

    /**
     * Is created with color from the first activity text area or exception message
     * if color was incorrect
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        RelativeLayout layout = findViewById(R.id.secondLayout);
        TextView textView = new TextView(this);
        textView.setText("Wrong color!");
        textView.setTextSize(30);

        Intent intent = getIntent();
        String color = Objects.requireNonNull(intent.getStringExtra("color")).trim();

        switch (color) {
            case "red":
                layout.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case "green":
                layout.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case "blue":
                layout.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            default:
                if (!setHexColor(layout, color)) {
                    layout.setBackgroundColor(getResources().getColor(R.color.black));
                    layout.addView(textView);
                }
                break;
        }
    }

    /**
     *
     * @param layout layout where color should be set
     * @param hex valid hex-code (#AARRGGBB or #RRGGBB)
     * @return true if color was set successfully, false otherwise
     */
    protected boolean setHexColor(RelativeLayout layout, String hex) {
        try {
            int color = Color.parseColor(hex);
            layout.setBackgroundColor(color);

            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
