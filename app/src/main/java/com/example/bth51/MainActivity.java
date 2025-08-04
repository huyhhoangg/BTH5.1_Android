package com.example.bth51;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity{
    Button btnTieptuc,btnGiai,btnThoat;
    EditText edita,editb,editc;
    TextView txtkq;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTieptuc = findViewById(R.id.btntieptuc);
        btnGiai = findViewById(R.id.btngiaipt);
        btnThoat = findViewById(R.id.btnthoat);
        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        editc = findViewById(R.id.editc);
        txtkq = findViewById(R.id.textkq);
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                String sa = edita.getText() + "";
                String sb = editb.getText() + "";
                String sc = editc.getText() + "";
                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);
                String kq = "";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if (a == 0) {
                    if (b == 0) {

                        if (c == 0)
                            kq = "PT vô số nghiệm";
                        else
                            kq = "PT vô nghiệm";
                    } else {
                        kq = "Pt có 1 No, x=" + dcf.format(-c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        kq = "PT vô nghiệm";
                    } else if (delta == 0) {
                        kq = "Pt có No kép x1=x2=" + dcf.format(-b / (2 * a));
                    } else {
                        kq = "Pt có 2 No: x1=" + dcf.format((-b + Math.sqrt(delta)) / (2 * a)) + "; x2=" + dcf.format((-
                                b - Math.sqrt(delta)) / (2 * a));
                    }
                }
                txtkq.setText(kq);
            }
        });
        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                edita.setText("");
                editb.setText("");
                editc.setText("");
                edita.requestFocus();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                finish();
            }
        });
    };
}