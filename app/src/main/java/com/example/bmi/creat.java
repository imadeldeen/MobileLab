package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class creat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);

        private ActivityLoginBinding binding;
        private FirebaseAuth mAuth;
        private Button loginBtn;
        private EditText usernameET;
        private EditText passwordET;
        private ImageView imageView;
        private TextView signUp;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityLoginBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            loginBtn = binding.loginBtn;
            signUp = binding.singUpTv;
            passwordET = binding.passwordEt;
            usernameET = binding.usernameEt;
            mAuth = FirebaseAuth.getInstance();
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String username = usernameET.getText().toString().trim();
                    String password = passwordET.getText().toString().trim();
                    if (username.isEmpty() || password.isEmpty()) {
                        usernameET.setError("This filed is required");
                        passwordET.setError("This filed is required");
                    } else {
                        signIn(username, password);
                    }
                }
            });

        }




        private void signIn(String email, String password) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LoginActivity.this, "Login Succeeded.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
//                            updateUI(user);
                            } else {
                                Toast.makeText(LoginActivity.this, "Login failed.", Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            }
                        }
                    });

        }

        @Override
        public void onStart() {
            super.onStart();
//         Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            if (currentUser != null) {

            }

        }

        private void updateUI(FirebaseUser user) {

        }

        public void sigUpTVClicked(View view) {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
            finish();
        }


        boolean showPassword = false;
        public void showOrHidePassword(View view) {
            if (view.isPressed() && showPassword == false) {
                //to shaw
                passwordET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                showPassword = true;
            } else {
                //to hide
                passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                showPassword = false;
            }
    }
}