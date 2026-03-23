package com.example.statsapp;
import static com.example.statsapp.Calculator.getMean;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        private ArrayList<Double> numbers = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        public void doAdd(View v){
            EditText e = (EditText)findViewById(R.id.editText1);
            String value = e.getText().toString();
            Double d = Double.parseDouble(value);
            numbers.add(d);
            e.setText(" ");
        }

        public void doMean(View v){

            String mean = getMean(numbers).toString();
            TextView t = (TextView)findViewById(R.id.textView);
            t.setText(mean);
        }
}
