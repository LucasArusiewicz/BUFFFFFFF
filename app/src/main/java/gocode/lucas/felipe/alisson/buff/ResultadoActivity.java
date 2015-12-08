package gocode.lucas.felipe.alisson.buff;

import android.content.Intent;
import android.graphics.Color;
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
        if (venceu){
            setBut(btnResultadoD, "Inicio", "#FF666666", InicioActivity.class);
            btnResultadoE.setVisibility(View.INVISIBLE);
            tvResultado.setText("Você Ganhou !");
        } else {
            if (errou){
                setBut(btnResultadoD, "Inicio", "#FF666666", InicioActivity.class);
                btnResultadoE.setVisibility(View.INVISIBLE);
                btnResultadoE.setWidth(1);
                tvResultado.setText("Você perdeu !");
                tvPontos.setText("Você marcou " + ids[20] + " pontos" );
            } else {
                tvResultado.setText("Parabéns, você acertou !");
                setBut(btnResultadoE, "Desistir","#FF666666", InicioActivity.class);
                setBut(btnResultadoD, "Proxima pergunta ?", "#FF666666", PerguntaActivity.class);
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

    }
}
