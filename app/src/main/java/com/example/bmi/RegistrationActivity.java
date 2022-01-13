package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        private static final String TAG = "TAG";
        private ActivityRegistrationBinding binding;
        private FirebaseAuth mAuth;
        private EditText nameET;
        private EditText emailET;
        private EditText passwordET;
        private EditText repasswordET;
        private Button createBtn;
        private TextView login;
        private ImageView imageView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);

            passwordET = binding.password;
            repasswordET = binding.rePassword;
            nameET = binding.nameEd;
            emailET = binding.emailEd;
            createBtn = binding.createBtn;
            mAuth = FirebaseAuth.getInstance();

            createBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validateInputs();
                }
            });
        }

        private void validateInputs() {
            String username = nameET.getText().toString().trim();
            String email = emailET.getText().toString().trim();
            String password = passwordET.getText().toString().trim();
            String rePassword = repasswordET.getText().toString().trim();
            if (TextUtils.isEmpty(username)) {
                nameET.setError("This field is required");
                return;
            }
            if (TextUtils.isEmpty(email)) {
                emailET.setError("This field is required");
                return;
            }
            if(!TextUtils.isEmpty(password) && password.length() <= 5) {
                passwordET.setError("minimum length is 6");
                return;
            }
            if (!rePassword.equals(password)) {
                repasswordET.setError("This field is required");
                return;
            }
            createAccount(email, password);
        }


        private void createAccount(String email, String password) {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegistrationActivity.this, "User Created.",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationActivity.this, CompleteInformationActivity.class));
                        finish();
//                            FirebaseUser user = mAuth.getCurrentUser();
////                            updateUI(user);
                    } else {
                        Log.d(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                    }
                }
            });
        }

        private void updateUI(FirebaseUser user) {

        }


        public void loginTVClicked(View view) {
            startActivity(new Intent(this, LoginActivity.class));
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