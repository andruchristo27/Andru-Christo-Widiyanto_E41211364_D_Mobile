package com.example.sharedpreferenced;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class sucess extends AppCompatActivity {
    Button back;
    Session sessionManager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess);
        sessionManager = new Session(sucess.this);

        // Cek apakah user sudah login atau belum
        if (!sessionManager.isLogin()) {
            // Jika belum login, pindahkan ke halaman login
            movetoLogin();
        }
        back = findViewById(R.id.logout);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                movetoLogin();

            }
        });


    }
    private void movetoLogin() {
        Intent intent = new Intent(sucess.this, login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}
