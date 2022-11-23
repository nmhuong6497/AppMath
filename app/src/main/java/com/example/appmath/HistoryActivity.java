package com.example.appmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    TextView tvHistory;
    ImageView imgClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tvHistory = findViewById(R.id.text_view_history);
        imgClear = findViewById(R.id.image_clear);

        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        String history = sharedPreferences.getString("history", "");
        tvHistory.setText(history);

        imgClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvHistory.setText("");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
//
//                Intent intent = new Intent(HistoryActivity.this, CaculationActivity.class);
//                startActivity(intent);
            }
        });
    }
}