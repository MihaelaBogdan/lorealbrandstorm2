package com.example.lorealbrandstorm;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void createAccount(View view) {
        //... (codul pentru validarea câmpurilor)

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // Adaugă tranziția aici
        //finish(); // Nu mai este necesar aici, deoarece tranziția se face înainte de a închide activitatea
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Sunteți sigur că doriți să ieșiți?")
                .setPositiveButton("Da", (dialog, which) -> {
                    super.onBackPressed();
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out); // Adaugă tranziția și aici
                })
                .setNegativeButton("Nu", null)
                .show();
    }

}