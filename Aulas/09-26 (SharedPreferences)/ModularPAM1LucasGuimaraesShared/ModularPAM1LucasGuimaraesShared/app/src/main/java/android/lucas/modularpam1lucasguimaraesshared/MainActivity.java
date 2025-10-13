package android.lucas.modularpam1lucasguimaraesshared;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //instanciando o objeto preference da classe SharedPreferences para acessar os seus métodos
    SharedPreferences preferences;

    //Constante dados
    public static final String PREFS_NAME = "dados";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // desenha a tela activity_main

        //
        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // usando o metodo editor() dentro de SharedPreferences
        // criar um meusDados para editar o preferences.edit
        SharedPreferences.Editor meusDados = preferences.edit();

        //
        meusDados.putString("nome","fabio");
        meusDados.putString("email","fabioclaret@gmail.com");
        meusDados.putString("senha","123456");

        meusDados.apply();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}