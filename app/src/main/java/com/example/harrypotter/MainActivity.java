package com.example.harrypotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_count,txt_pass;
    public static final String COUNT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_count = findViewById(R.id.txt_count);
        txt_pass = findViewById(R.id.txt_pass);


    }


    public void start(View view) {
        if (txt_count.getText().toString().isEmpty() || txt_pass.getText().toString().isEmpty()){
            Toast.makeText(this,"Complete camps",Toast.LENGTH_SHORT).show();
        }else{
            if (txt_count.getText().toString().equals("Admin") && txt_pass.getText().toString().equals("admin")){
                Intent intent = new Intent(this,ContenidoActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Count or pass is incorrect",Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void developers(View view) {
        Intent i = new Intent(this,AboutActivity.class);
        startActivity(i);
    }
}