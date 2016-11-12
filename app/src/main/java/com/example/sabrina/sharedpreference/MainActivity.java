package com.example.sabrina.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int number;
    TextView numView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numView = (TextView)findViewById(R.id.numberView);


        SharedPreferences nums = getPreferences(0);
        number = nums.getInt("number", 0);
        numView.setText(Integer.toString(number));

        Button advance = (Button)findViewById(R.id.advance);
        advance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                number++;
                numView.setText(Integer.toString(number));
            }
        });

        Button saveCount = (Button)findViewById(R.id.saveCount);
        saveCount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                SharedPreferences nums = getPreferences(0);
                SharedPreferences.Editor editor = nums.edit();
                editor.putInt("number", number);

                editor.commit();
            }
        });
    }

}
