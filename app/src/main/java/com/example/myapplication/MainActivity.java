package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

//    TextView txttitle;
//    Button btnad;
    private TextView txt;
    private Button ini;
    private Button rei;
    private Button enter;
    private EditText num;
    private int n;
    private int intentos;
    private int adivinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        n = new Random().nextInt(95) + 5;
        intentos = (int)(Math.log(n)/Math.log(2)) - 1;
        txt = findViewById(R.id.texto);
        ini = findViewById(R.id.jugar);
        rei = findViewById(R.id.reiniciar);
        num = findViewById(R.id.editable);
        num.setVisibility(View.INVISIBLE);
        enter = findViewById(R.id.ent);
        enter.setVisibility(View.INVISIBLE);
        num.setInputType(InputType.TYPE_CLASS_NUMBER);

        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("Di un numero del 1 al" + n);
                adivinar = new Random().nextInt(n);
                num.setVisibility(View.VISIBLE);
                ini.setEnabled(false);
                enter.setVisibility(View.VISIBLE);
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valor;
                valor = Integer.parseInt(num.getText().toString());

                if(valor == adivinar){
                    txt.setText("Numero Correcto");
                    txt.setTextColor(Color.GREEN);
                    enter.setVisibility(View.INVISIBLE);
                    num.setVisibility(View.INVISIBLE);
                }
                else{
                    intentos --;
                    if (intentos == 0){
                        txt.setText("Has Perdido. El numero era " + adivinar );
                        txt.setTextColor(Color.RED);
                        enter.setVisibility(View.INVISIBLE);
                        num.setVisibility(View.INVISIBLE);
                    }
                    else{
                        txt.setText("Te quedan " + intentos + " intentos. Di un numero del 1 al " + n);
                    }
                }
            }
        });

        rei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = new Random().nextInt(95) + 5;
                intentos = (int)(Math.log(n)/Math.log(2)) - 1;
                txt = findViewById(R.id.texto);
                ini = findViewById(R.id.jugar);
                rei = findViewById(R.id.reiniciar);
                num = findViewById(R.id.editable);
                num.setVisibility(View.INVISIBLE);
                enter = findViewById(R.id.ent);
                enter.setVisibility(View.INVISIBLE);
                num.setInputType(InputType.TYPE_CLASS_NUMBER);
                txt.setText("Adivina el numero");
                txt.setTextColor(Color.BLACK);
                ini.setEnabled(true);
            }
        });

//        txttitle = findViewById(R.id.txttitle);
//        btnad = findViewById(R.id.btnad);
//
//        btnad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Random rd = new Random();
//                int val = rd.nextInt(5)+1;
//                txttitle.setText(Integer.toString(val));
//            }
//        });
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}