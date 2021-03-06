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
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 2,'Em que Ano Steve Paul Jobs morreu?','24 de fevereiro de 2011','23 de fevereiro de 2016','1  de Janeiro   de 2001','18 de fevereiro de 2005' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 2 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 3,'Linha imaginaria utilizada pela cartografia, organizada na vertical?','Merediano','Tropico','Paralelograma','Equandor' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 3 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 4,'Sócrates foi um...','Filósofo ateniense do perído dlássico da Grécia Antiga','Filósofo americado do perído dlássico de Roma','Filósofo brasileiro do período clássico do Brasil','Filósofo enigmático dos dias de hoje' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 4 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 5,'Qual a massa atômica do hidrogênio?','1','3','8','4' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 5 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 6,'Magnésio de acordo com a tabela periódica é um...','Metal Alcalino-terroso','Metal Alcalino','Metalde transição','Lantanídeo' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 6 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 7,'A sigla PUCRS significa...','Pontifícia Universidade Católica do Rio Grande do Sul','Pontifísia Universidade Catolica do Rio Grande do Sul','Pontifíssia Universidade Católica do Rio Grande do Sul','Pontifirica Universidade Católica do Rio Grande do Sul' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 7 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 8,'Friedrich Nietzsche...','Nasceu em 15 de outubro e Falecu em 25 de agosto de 1900','Nasceu em 10 de outubro e Falecu em 18 de maio de 1854','Nasceu em 03 de outubro e Falecu em 12 de junho de 1839','Nasceu em 19 de outubro e Falecu em 25 de setembro de 1926' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 8 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 9,'Famoso pensador que primeiro escreveu sobre a existência da lendária Atlântida.','Platão','Heródoto','Sócrates','Leonardo da Vinci' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 9 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 10,'O avião que ultrapassa a velocidade do som é?','Supersônico','Ultrasônico','Hipersônico','Teco teco' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 10 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 11,'A soma de dois número é ?','adição','subtração','multiplicação','divisão' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 11 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 12,'Capacidade que um corpo, uma substância ou um sistema físico têm de realizar trabalho...','Energia','Calor','Temperatura','Aquecimento' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 12 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 13,'Albert Einstein foi um... ','físico teórico alemão','físico teórico grego','físico teórico Argentino','físico teórico Brasileiro' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 13 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 14,'A sigla FMSS significa','Fundação Maurício Sirotsky Sobrinho','Fundação Maurísio Sirotski Sobrynho','Fifa Master Super Soccer','Fundação Mauro Siriutsky Sobrinho' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 14 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 15,'Goku foi um...','Personagem de um anime','grande guerreio','saijin Deus','Grande rival de vegeta' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 15 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 16,'... é um físico teórico e cosmólogo britânico e um dos mais consagrados cientistas da atualidade.','Stephen Hawking','Isaac Newton','Galileu Galilei','Max Von Laue' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 16 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 17,'Ganhador do Nobel de Química de 1996 é...','Robert Curl','James Dewar','Otto Hahn','Paul Karrer' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 17 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 18,'O que foi inuyasha um(a)...','Anime','Música','Shopping do Japão','Banda' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 18 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 19,'FPS significa...','Frames Per Second','Fast Per Second','Furious Per Second','Fator de Proteção Solar' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 19 );");
        db.execSQL("INSERT INTO questoes (_id, pergunta, resposta_correta, resposta_incorreta_a, resposta_incorreta_b, resposta_incorreta_c) SELECT 20,'A sigla RBS TV','Rede Brasil Sul de Televisão','Rede Brasileira Sul de Televisão','Rede Boa Sul de Televisão','Rede Bem Sul de Televisão' WHERE NOT EXISTS ( SELECT 1 FROM questoes WHERE _id = 20 );");

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
