package com.andru.filemanagementandsqlite;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class acara26 extends AppCompatActivity {
EditText editText;
private int STORAGE_PERMISSION_CODE = 23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acara26);
        editText = (EditText) findViewById(R.id.editText1);
    }
    public void next(View view){
        Intent intent = new Intent(acara26.this, acara262.class);
        startActivity(intent);
    }
    public void savePublic(View view){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        String info = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile = new File(folder, "myData1.txt");
        writeDate(myfile, info);
        editText.setText("");
    }

    public void savePrivate(View view){
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("Andru");
        File myfile = new File(folder, "myData2.txt");
        writeDate(myfile, info);
        editText.setText("");
    }

    private void writeDate(File myfile, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            System.out.println("TES");
            fileOutputStream = new FileOutputStream(myfile);
            Toast.makeText(this,"Done"+ myfile.getAbsolutePath(),Toast.LENGTH_SHORT).show();
            fileOutputStream.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}