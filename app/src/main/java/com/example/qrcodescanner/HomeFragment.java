package com.example.qrcodescanner;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.List;


public class HomeFragment extends Fragment {

    private Button scanButton;
    private DecoratedBarcodeView barcodeView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        scanButton  = view.findViewById(R.id.btOpenQrScenner);
        barcodeView = view.findViewById(R.id.barcodeview);

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
//        }
        barcodeView.decodeContinuous(callback);
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleToggleVisibilityQrCodeScan();
            }
        });

        return view;
    }

    private void handleToggleVisibilityQrCodeScan (){
        if (barcodeView.getVisibility() == View.VISIBLE) {
            barcodeView.setVisibility(View.GONE);
        } else {
            barcodeView.setVisibility(View.VISIBLE);
        }
    }

    private final BarcodeCallback callback = new BarcodeCallback() {
        @Override
        public void barcodeResult(BarcodeResult result) {
            if (result.getBarcodeFormat() == BarcodeFormat.QR_CODE) {
                // É um QR code
                String qrCodeData = result.getText();
                Toast.makeText(getContext(), "QR Code: " + qrCodeData, Toast.LENGTH_SHORT).show();
            } else {
                // Outro tipo de código de barras
                Toast.makeText(getContext(), "Outro tipo de código de barras: " + result.getText(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void possibleResultPoints(List<ResultPoint> resultPoints) {
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        barcodeView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeView.pause();
    }

}