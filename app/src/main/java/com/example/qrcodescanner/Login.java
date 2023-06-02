package com.example.qrcodescanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private TextView login;
    private TextView password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();

        bidingData();
    }

    private void bidingData(){

        login = findViewById(R.id.edLogin);
        password = findViewById(R.id.edPassword);
        loginButton = findViewById(R.id.btLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleValidateData();
            }
        });
    }

    private void handleLogin(){

    }

    private boolean handleValidateData(){
        if(login.getText().toString().trim().equals("")){
            showToast("Informe seu login para continuar");
            return false;
        }

        if(password.getText().toString().trim().equals("")){
            showToast("Informe sua senha para continuar");
            return false;
        }

        return true;
    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}