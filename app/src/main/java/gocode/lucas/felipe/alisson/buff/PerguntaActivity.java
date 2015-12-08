package gocode.lucas.felipe.alisson.buff;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PerguntaActivity extends AppCompatActivity {

    private Button btnConfirmar;
    private TextView tvPergunta, tvPontos, tvTempo;
    private RadioButton rbAlternativa1, rbAlternativa2, rbAlternativa3, rbAlternativa4;
    private RadioButton alternativas[];
    private boolean rquestao = false;
    private int ids[], c = 0;
    private String resErrada[];
    private Questao questao;
    private Random random;
    private Bundle bundle;
    private CountDownTimer tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        tvPergunta = (TextView) findViewById(R.id.tvPerguntaPergunta);
        tvPontos = (TextView) findViewById(R.id.tvPerguntaPontos);
        rbAlternativa1 = (RadioButton) findViewById(R.id.rbPerguntaAlternativa1);
        rbAlternativa2 = (RadioButton) findViewById(R.id.rbPerguntaAlternativa2);
        rbAlternativa3 = (RadioButton) findViewById(R.id.rbPerguntaAlternativa3);
        rbAlternativa4 = (RadioButton) findViewById(R.id.rbPerguntaAlternativa4);
        tvTempo = (TextView) findViewById(R.id.tvPerguntaTempo);
        btnConfirmar = (Button) findViewById(R.id.btnPerguntaConfirmar);
        random = new Random();
        alternativas = new RadioButton[4];
        resErrada = new String[3];
        ids = new int[21];
        bundle = getIntent().getExtras();
        c = bundle.getInt("Count");
        ids = bundle.getIntArray("IDS");
        setPontos();
        questao = new Questao();
        questao = chamaQuestao(questao);
        tvPergunta.setText(String.valueOf(questao.getPergunta()));
        setAlternativas(questao);
        tempo = new CountDownTimer(15000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tvTempo.setText("Tempo: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                this.cancel();
                Intent intent = new Intent(getApplicationContext(),ResultadoActivity.class);
                intent.putExtra("IDS", ids);
                intent.putExtra("VENCEU",!rquestao);
                intent.putExtra("ERROU",rquestao);
                intent.putExtra("Count",c);
                finish();
                startActivity(intent);
            }
        }.start();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbAlternativa1.isChecked() || rbAlternativa2.isChecked() || rbAlternativa3.isChecked() || rbAlternativa4.isChecked()) {
                    tempo.cancel();
                    verifica();
                } else {
                    Toast.makeText(v.getContext(), "Seleciona uma alternativa !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void verifica(){
        if (acertou()){
            Intent intent = new Intent(this,ResultadoActivity.class);
            intent.putExtra("IDS", ids);
            intent.putExtra("VENCEU",!rquestao);
            intent.putExtra("ERROU",!rquestao);
            intent.putExtra("Count",c);
            finish();
            startActivity(intent);
        } else {
            Intent intent = new Intent(this,ResultadoActivity.class);
            intent.putExtra("IDS", ids);
            intent.putExtra("VENCEU",!rquestao);
            intent.putExtra("ERROU",rquestao);
            intent.putExtra("Count",c);
            finish();
            startActivity(intent);

        }
    }

    private void setPontos() {
        if (ids[20] != 0){
            tvPontos.setText("Pontos: " + String.valueOf(ids[20]));
        }
    }

    public boolean acertou(){
        boolean acertou = false;
        String rc = null;
        for (int i = 0; i < alternativas.length; i++){
            if (alternativas[i].isChecked()){
                rc = alternativas[i].getText().toString();
            }
        }
        if (rc.equals(questao.getResposta_correta())){
            acertou = true;
            ids[20] += 1;
        }
        return acertou;
    }

    public void setAlternativas(Questao q){
        alternativas[0] = rbAlternativa1;
        alternativas[1] = rbAlternativa2;
        alternativas[2] = rbAlternativa3;
        alternativas[3] = rbAlternativa4;
        resErrada[0] = q.getResposta_incorreta_a();
        resErrada[1] = q.getResposta_incorreta_b();
        resErrada[2] = q.getResposta_incorreta_c();
        alternativas[random.nextInt(4)].setText(q.getResposta_correta());
        int e = 0;
        for (int i = 0; i < alternativas.length; i++){
            if (alternativas[i].getText().equals("0")){
                alternativas[i].setText(resErrada[e]);
                e++;
            }
        }
    }

    public Questao chamaQuestao(Questao q){

        while (!rquestao){
            q = q.buscarQuestao(this);
            int id,numP;
            id = q.getId();
            numP = q.getNumPerguntas();

            boolean inserido = false;
            //passa array
            for (int i = 0; i < ids.length;i++){
                if (ids[i] == id){
                    inserido = true;
                    i = ids.length;
                }
            }
            if (!inserido){
                for (int i = 0; i < ids.length;i++){
                    if (ids[i] == 0){
                        ids[i] = id;
                        i = ids.length;
                    }
                }
                rquestao = true;
            } else {
                c++;
                if (c > numP){
                    rquestao = true;
                    Intent intent = new Intent(this,ResultadoActivity.class);
                    intent.putExtra("IDS", ids);
                    intent.putExtra("VENCEU",rquestao);
                    finish();
                    startActivity(intent);
                }
            }
        }
        return q;
    }
}
