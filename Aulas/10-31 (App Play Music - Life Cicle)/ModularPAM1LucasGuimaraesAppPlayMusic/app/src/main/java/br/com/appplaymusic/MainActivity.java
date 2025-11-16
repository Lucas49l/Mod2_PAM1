package br.com.appplaymusic;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView play, pause, stop;
    TextView musicStatus;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initComponents();

        //Criou a instancia da classe mediaPlayer com a musica nothing na pasta raw
        mediaPlayer = MediaPlayer.create(this, R.raw.nothing);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer !=null){
                    mediaPlayer.start();
                    musicStatus.setText("Música em execução");
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    musicStatus.setText("Música em pause");
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nothing);
                    musicStatus.setText("Música Destruida");
                }
            }
        });

        /*
        play.setOnClickListener(view -> {
            if (mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(this, R.raw.nothing);
            }
        });
        */

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override // App em segundo plano a música para
    protected void onStop() {
        super.onStop();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            musicStatus.setText("Música em pause");
        }
    }

    @Override // Quando sair do App música para e a memória é liberada
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release(); //libera memória
    }

    @Override // Quando abrir o aplicativo música tocar automaticamente
    protected void onStart() {
        super.onStart();
        if(mediaPlayer != null){
            mediaPlayer.start();
            musicStatus.setText("Música em execução");
        }
    }

    private void initComponents() {
        play  = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        stop  = findViewById(R.id.stop);
        musicStatus = findViewById(R.id.musicStatus);
    }
}