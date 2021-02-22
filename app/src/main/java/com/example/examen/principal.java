package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class principal extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tv1 = findViewById(R.id.txtEntrada);
    }

    public void Evaluar(View view) {

        String numS = tv1.getText().toString();

        if (numS.isEmpty()) {
            tv1.setError("Llenar este campo");
        } else if (!numS.isEmpty()) {
            int numI = Integer.parseInt(numS);
            if (numI % 4 == 0) {//paso 1
                if (numI % 100 == 0) {//paso 2
                    if (numI % 400 == 0) {//paso 3
                        Afirmacion();
                    } else {
                        Negacion();
                    }
                } else {//paso 4
                    Afirmacion();
                }
            } else {//paso 5
                Negacion();
            }
        }
    }

    public void Afirmacion() {
        AlertDialog alertDialog = new AlertDialog.Builder(principal.this).create();
        alertDialog.setTitle(":)");
        alertDialog.setMessage("El año ingresado SI es año bisiesto");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void Negacion() {
        AlertDialog alertDialog = new AlertDialog.Builder(principal.this).create();
        alertDialog.setTitle(":(");
        alertDialog.setMessage("El año ingresado NO es año bisiesto");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}