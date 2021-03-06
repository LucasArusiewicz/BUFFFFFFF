package gocode.lucas.felipe.alisson.buff;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultadoActivity extends AppCompatActivity {

    private Button btnResultadoD, btnResultadoE;
    private TextView tvResultado, tvPontos;
    private Bundle bundle;
    private int ids[] = new int[21];
    private CountDownTimer tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        bundle = getIntent().getExtras();
        ids = bundle.getIntArray("IDS");
        boolean venceu = bundle.getBoolean("VENCEU");
        boolean errou = bundle.getBoolean("ERROU");
        btnResultadoD = (Button) findViewById(R.id.btnResultadoD);
        btnResultadoE = (Button) findViewById(R.id.btnResultadoE);
        tvResultado = (TextView) findViewById(R.id.tvResultadoResultado);
        tvPontos = (TextView) findViewById(R.id.tvResultadoPontos);
        tempo = new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                btnResultadoD.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                finish();
            }
        };
        if (venceu){
            tempo.start();
            btnResultadoE.setText("Voltando para o inicio em ...");
            btnResultadoD.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            btnResultadoE.setBackgroundColor(Color.parseColor("#00FFFFFF"));
            btnResultadoE.setTextColor(Color.RED);
            btnResultadoD.setTextColor(Color.RED);
            tvResultado.setText("Você Ganhou !");
        } else {
            if (errou){
                tempo.start();
                btnResultadoE.setText("Voltando para o inicio em ...");
                btnResultadoD.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                btnResultadoE.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                btnResultadoE.setTextColor(Color.RED);
                btnResultadoD.setTextColor(Color.RED);
                tvResultado.setText("Você perdeu !");
                tvPontos.setText("Você marcou " + ids[20] + " pontos" );
            } else {
                tvResultado.setText("Parabéns, você acertou !");
                setBut(btnResultadoE, "Desistir", "#FF666666");
                setBut(btnResultadoD, "Proxima pergunta ?", "#FF666666", PerguntaActivity.class);
                tvPontos.setText("Você está com " + ids[20] + " pontos");
            }
        }
    }

    public void setBut(Button botao, String texto, String cor, final Class aClass) {
        botao.setBackgroundColor(Color.parseColor(cor));
        botao.setText(texto);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), aClass);
                intent.putExtra("IDS",bundle.getIntArray("IDS"));
                intent.putExtra("Count",bundle.getInt("Count"));
                finish();
                startActivity(intent);
            }
        });
    }
    public void setBut(Button botao, String texto, String cor){
        botao.setBackgroundColor(Color.parseColor(cor));
        botao.setText(texto);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
