package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddNewRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_record);

        private ActivityNewRecordBinding binding;
        private Button saveBtn;
        private EditText time;
        private EditText date;
        private EditText weight;
        private EditText length;
        private ImageView increaseWeight, decreaseWeight;
        private ImageView increaseLength, decreaseLength;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityNewRecordBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            date = binding.dateEt;
            time = binding.timeEt;
            length = binding.lenEt;
            weight = binding.weitEt;
            saveBtn = binding.saveBtn;


            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String l = length.getText().toString().trim();
                    String w = weight.getText().toString().trim();
                    String d = date.getText().toString().trim();
                    String t = time.getText().toString().trim();
                    new Record(l, w, d, t);
////////////////  not finished
                }
            });
    }
}