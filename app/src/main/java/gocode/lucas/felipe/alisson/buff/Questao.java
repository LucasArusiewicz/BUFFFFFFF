package gocode.lucas.felipe.alisson.buff;

import android.content.Context;

/**
 * Created by lucas on 01/12/15.
 */

public class Questao {

    private String pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c;
    private int id, numPerguntas;

    public Questao() {}

    public Questao(String pergunta, String resposta_correta, String resposta_incorreta_a, String resposta_incorreta_b, String resposta_incorreta_c, int id, int numPerguntas) {
        this.pergunta = pergunta;
        this.resposta_correta = resposta_correta;
        this.resposta_incorreta_a = resposta_incorreta_a;
        this.resposta_incorreta_b = resposta_incorreta_b;
        this.resposta_incorreta_c = resposta_incorreta_c;
        this.id = id;
        this.numPerguntas = numPerguntas;
    }

    public Questao buscarQuestao(Context context) {
        Banco db = new Banco(context);
        return db.buscarQuestao();
    }

    public int getNumPerguntas() {
        return numPerguntas;
    }

    public void setNumPerguntas(int numPerguntas) {
        this.numPerguntas = numPerguntas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta_correta() {
        return resposta_correta;
    }

    public void setResposta_correta(String resposta_correta) {
        this.resposta_correta = resposta_correta;
    }

    public String getResposta_incorreta_a() {
        return resposta_incorreta_a;
    }

    public void setResposta_incorreta_a(String resposta_incorreta_a) {
        this.resposta_incorreta_a = resposta_incorreta_a;
    }

    public String getResposta_incorreta_b() {
        return resposta_incorreta_b;
    }

    public void setResposta_incorreta_b(String resposta_incorreta_b) {
        this.resposta_incorreta_b = resposta_incorreta_b;
    }

    public String getResposta_incorreta_c() {
        return resposta_incorreta_c;
    }

    public void setResposta_incorreta_c(String resposta_incorreta_c) {
        this.resposta_incorreta_c = resposta_incorreta_c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
