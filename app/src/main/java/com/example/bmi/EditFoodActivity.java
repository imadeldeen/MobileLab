package com.example.bmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);

        private ActivityEditFoodBinding binding;
        private Button saveBtn;
        private Button uploudPhotoBtn;
        private ImageView image;
        private Spinner categorySpinner;
        private EditText name;
        private TextView calory;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityEditFoodBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());


        }
}