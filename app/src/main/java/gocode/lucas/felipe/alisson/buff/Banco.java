package gocode.lucas.felipe.alisson.buff;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lucas on 01/12/15.
 */

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String NOME_BANCO = "buff_quiz";

    public Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS questoes ( _id INTEGER PRIMARY KEY AUTOINCREMENT, pergunta TEXT, resposta_correta TEXT, resposta_incorreta_a TEXT, resposta_incorreta_b TEXT, resposta_incorreta_c TEXT);");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 1,'Qual a montanha mais alta do mundo?','Monte Everest','Kangchenjunga','Cho Oyu','Manaslu' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 1 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 2,'Qsdgsdfjnsfjnskf?','sdgsdfad','sdgsdafaf','sdfagsdfafs','asfsdgfasdsf' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 2 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 3,'Linha imaginaria utilizada pela cartografia, organizada na vertical?','Merediano','Tropico','Paralelograma','Equandor' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 3 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 4,'fffffffffffff?','sdgsdfad','sdgsdafaf','sdfagsdfafs','asfsdgfasdsf' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 4 );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inicializarBanco (){
        SQLiteDatabase db = getWritableDatabase();
        onCreate(db);
    }

    public Questao buscarQuestao() {

        Questao questao = new Questao();
        SQLiteDatabase db = getReadableDatabase();

        String c = "SELECT COUNT(*) FROM questoes ;";
        Cursor Count= db.rawQuery(c, null);
        Count.moveToFirst();
        int count= Count.getInt(0);
        questao.setNumPerguntas(count);

        String r = "SELECT * FROM questoes ORDER BY RANDOM() LIMIT 1 ;";
        Count = db.rawQuery(r, null);
        Count.moveToFirst();

        questao.setId(Count.getInt(Count.getColumnIndex("_id")));
        questao.setPergunta(Count.getString(Count.getColumnIndex("pergunta")));
        questao.setResposta_correta(Count.getString(Count.getColumnIndex("resposta_correta")));
        questao.setResposta_incorreta_a(Count.getString(Count.getColumnIndex("resposta_incorreta_a")));
        questao.setResposta_incorreta_b(Count.getString(Count.getColumnIndex("resposta_incorreta_b")));
        questao.setResposta_incorreta_c(Count.getString(Count.getColumnIndex("resposta_incorreta_c")));

        Count.close();

        return questao;
    }
}
