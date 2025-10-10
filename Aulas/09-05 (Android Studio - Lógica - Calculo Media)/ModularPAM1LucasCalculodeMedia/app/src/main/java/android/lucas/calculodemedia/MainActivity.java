package android.lucas.calculodemedia;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Declarando as variaveis de acordo com seus elementos
    EditText nota1, nota2, nota3, nota4, faltas;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Chama a função que liga as variaveis com os ids no layout
        initComponents();

        //Manda um texto ao clicar no botão do resultado
        //setOnClickListener(view ->{...}); = evento acionado quando o botão for clicado, executando o código entre das chaves
        btnCalcular.setOnClickListener(view -> {
            validaCampos();
            calcularMedia();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calcularMedia() {
        //Conversão de String em double
        double n1 = Double.parseDouble(nota1.getText().toString());
        double n2 = Double.parseDouble(nota2.getText().toString());
        double n3 = Double.parseDouble(nota3.getText().toString());
        double n4 = Double.parseDouble(nota4.getText().toString());
        double f  = Double.parseDouble(faltas.getText().toString());

        //Calculo da media
        double media = (n1 + n2 + n3 + n4)/4;

        //Condicional Aprovado/Reprovado/Reprovado por Faltas
        if(media > 7){
            if(f < 20){
                //Envia um texto no campo vinculado a variavel com cor especifica
                txtResultado.setTextColor(Color.parseColor("#437845"));
                txtResultado.setText("Aluno Aprovado com media " + media);
            }else{
                txtResultado.setTextColor(Color.parseColor("#f44336"));
                txtResultado.setText("Aluno com Excesso de faltas. Reprovado com media " + media);
            }
        }else{
            txtResultado.setTextColor(Color.parseColor("#f44336"));
            txtResultado.setText("Aluno Reprovado com media " + media);
        }
    }

    private void validaCampos() {
        //TextUtils.isEmpty(variavel.getText()); verifica se o "texto" pego pela variavel está vazio/True
        if(TextUtils.isEmpty(nota1.getText())){
            nota1.setError("Esse campo não pode estar vazio");
        } else if (TextUtils.isEmpty(nota2.getText())) {
            nota2.setError("Esse campo não pode estar vazio");
        } else if (TextUtils.isEmpty(nota3.getText())) {
            nota3.setError("Esse campo não pode estar vazio");
        }else if (TextUtils.isEmpty(nota4.getText())) {
            nota4.setError("Esse campo não pode estar vazio");
        }else if (TextUtils.isEmpty(faltas.getText())) {
            faltas.setError("Esse campo não pode estar vazio");
        }
    }

    //função que liga as variaveis  com os IDs do Layout
    private void initComponents() {
        //Comando que faz as ligações "VARIAVEL = findViewById(R.id.IDLAYOUT);"
        nota1 = findViewById(R.id.edt_nota1);
        nota2 = findViewById(R.id.edt_nota2);
        nota3 = findViewById(R.id.edt_nota3);
        nota4 = findViewById(R.id.edt_nota4);
        txtResultado = findViewById(R.id.txt_resultado);
        faltas = findViewById(R.id.edt_faltas);
        btnCalcular = findViewById(R.id.btn_calcular);
    }
}