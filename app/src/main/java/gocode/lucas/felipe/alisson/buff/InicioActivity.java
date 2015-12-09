package gocode.lucas.felipe.alisson.buff;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity {

    private Button btncomecar;
    private Button btnComoJogar;
    private int ids[] = new int[21];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnComoJogar = (Button)findViewById(R.id.btnComoJogar);
        btnComoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(InicioActivity.this);
                dlg.setTitle("BuffQuiz - Como Jogar");
                dlg.setMessage("Para Jogar clique no botão começar, e responda as questões corretamente.");
                dlg.setCancelable(false);
                dlg.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Bem-Vindo ao BuffQUiz", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = dlg.create();
                dlg.show();
            }
        });

        Banco banco = new Banco(this);
        banco.inicializarBanco();
        btncomecar = (Button) findViewById(R.id.btnInicioComecar);
        btncomecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PerguntaActivity.class);
                intent.putExtra("IDS", ids);
                startActivity(intent);
            }
        });

    }

    @Override
     protected void onRestart() {
        super.onRestart();
    }
}
