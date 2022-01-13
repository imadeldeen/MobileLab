package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        private ActivityHomeBinding binding;
        private Button addFoodBtn, addRecordBtn, viewFoodBtn;
        private TextView statusTv;
        private NestedScrollView scrollView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityHomeBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            addFoodBtn = binding.addFoodBtn;
            addRecordBtn = binding.addRecordBtn;
            viewFoodBtn = binding.viewFoodBtn;
            statusTv = binding.statusTv;
            scrollView = binding.list;

//        scrollView.addView();
        }


        public void addFood(View view) {
            startActivity(new Intent(this, AddFoodDetailsActivity.class));
        }

        public void addRecord(View view) {
            startActivity(new Intent(this, NewRecordActivity.class));
        }

        public void viewFood(View view) {
            startActivity(new Intent(this, FoodListActivity.class));

        }

        public void logout(View view) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, LoginActivity.class));
            finish();

        }
}