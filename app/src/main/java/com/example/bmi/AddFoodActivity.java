package com.example.bmi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);


        private ActivityAddFoodDetailsBinding binding;
        private Button saveBtn;
        private Button uploudPhotoBtn;
        private ImageView image;
        private Spinner categorySpinner;
        private EditText name;
        private TextView calory;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityAddFoodDetailsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            name = binding.nameEt;
            calory = binding.calory;
            categorySpinner = binding.categorySpinner;
            image = binding.foodImage;
            saveBtn = binding.saveButton;
            uploudPhotoBtn = binding.uplaodButton;

            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n = name.getText().toString().trim();
                    String cal = calory.getText().toString().trim();
                    String selectedItem = (String) categorySpinner.getSelectedItem();

                }
            });

            uploudPhotoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                }
            });
        }

        public static final int PICK_IMAGE = 1;

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == PICK_IMAGE) {
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    image.setImageURI(selectedImageUri);
                } else {
                    return;
                }
            }
        }
    }
}