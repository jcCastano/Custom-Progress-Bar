package com.example.customprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText progressNum;
    Button updateBtn;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressNum = (EditText) findViewById(R.id.progressNum);
        updateBtn = (Button) findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(updateClickedListener);
    }

    View.OnClickListener updateClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String num = progressNum.getText().toString();
            try {
                int progress = Integer.parseInt(num);
                if (progress > 0 && progress <= 100) {
                    progressBar.setProgress(progress);
                    return;
                }
            } catch (Exception e){
                Log.e(TAG, "onClick: ", e);
            }
            Toast.makeText(MainActivity.this, "Please enter a whole number between 0 and 100", Toast.LENGTH_LONG).show();
        }
    };

}
