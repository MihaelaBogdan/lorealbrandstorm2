package com.example.lorealbrandstorm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity {

    private LinearLayout authLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);

        authLinearLayout = findViewById(R.id.authLinearLayout);

        authLinearLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                showViewsWithAnimation();
            }
        }, 500); // Delay before animation starts
    }

    private void showViewsWithAnimation() {
        ImageView logoImageView = findViewById(R.id.logoImageView);
        Animation fadeInLogo = new AlphaAnimation(0, 1);
        fadeInLogo.setDuration(500);
        logoImageView.startAnimation(fadeInLogo);


        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button createAccountButton = findViewById(R.id.createAccountButton);

        showViewWithAnimation(usernameEditText);
        showViewWithAnimation(passwordEditText);
        showViewWithAnimation(loginButton);
        showViewWithAnimation(createAccountButton);
    }

    private void showViewWithAnimation(View view) {
        view.setVisibility(View.VISIBLE);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(500);
        view.startAnimation(fadeIn);
    }


    public void login(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (username.equals("user") && password.equals("password")) {
            // Successful login logic (e.g., SharedPreferences, Intent)
            Intent intent = new Intent(AuthActivity.this, MainActivity.class); // Or your desired activity
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
        }
    }

    public void createAccount(View view) {
        Intent intent = new Intent(AuthActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }
}