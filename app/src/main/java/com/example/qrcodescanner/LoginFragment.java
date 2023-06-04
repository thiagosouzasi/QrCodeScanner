package com.example.qrcodescanner;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class LoginFragment extends Fragment {


    private TextView login;
    private TextView password;
    private Button loginButton;

    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        login = view.findViewById(R.id.edLogin);
        password = view.findViewById(R.id.edPassword);
        loginButton = view.findViewById(R.id.btLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin(v);
            }
        });
        return view;
    }

    private void handleLogin(View view){
        try {
            if(!handleValidateData()){
                return;
            }

            if(login.getText().toString().trim().equals("Admin") && password.getText().toString().trim().equals("Admin")){
                handleNavigate(view);
            }else{
                showToast("Usuário e senha inválidos");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void handleNavigate(View view){
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
    }

    private void showToast(String message){
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    //chamado no clique do botão direto do XML
    public boolean handleValidateData() {

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
}