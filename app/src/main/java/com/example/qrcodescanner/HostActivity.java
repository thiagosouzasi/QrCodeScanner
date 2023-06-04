package com.example.qrcodescanner;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.qrcodescanner.databinding.ActivityHostBinding;

public class HostActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityHostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());







    }


}