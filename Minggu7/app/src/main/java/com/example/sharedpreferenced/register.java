package com.example.sharedpreferenced;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class register extends AppCompatActivity{
    EditText etUsername, etPassword;
    Button btnRegister, btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnRegister = findViewById(R.id.register);
        btnBack = findViewById(R.id.back);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(register.this, "Silahkan isi data!", Toast.LENGTH_SHORT).show();
                } else {
                    DataHelper dataHelper = new DataHelper(register.this);
                    dataHelper.addUser(username, password);

                    Toast.makeText(register.this, "Terimakasih sudah mendaftar!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(register.this, login.class);
                    startActivity(intent);
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
            }
        });
    }
}
