package pl.zs10.testtaknie3ppiatek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Button buttonTak;
    private Button buttonNie;
    private Button buttonPodpowiedz;
    private Button buttonKolejne;
    private int aktualne = 0;
    private ArrayList<Pytanie> pytanies = RepozytoriumPytania.utworzPytania();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        wyswietlPytanie(0);
        buttonTak = findViewById(R.id.button);
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(sprawdzCzyDobrze(aktualne, true))
                            Toast.makeText(MainActivity.this, "dobra odpowiedź", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "zła odpowiedź", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        buttonKolejne = findViewById(R.id.button4);
        buttonKolejne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        aktualne++;
                        if (aktualne < pytanies.size())
                            wyswietlPytanie(aktualne);
                    }
                }
        );
    }

    private boolean sprawdzCzyDobrze(int i, boolean odpowiedz) {
        Pytanie pytanie = pytanies.get(i);

        if (odpowiedz == pytanie.isOdpowiedz()) {
            pytanie.setCzyOdpowiedzianoPoprawnie(true);
            return true;
        }
        pytanie.setCzyOdpowiedzianoPoprawnie(false);
        return false;
    }

    private void wyswietlPytanie(int i) {
        Pytanie pytanie = pytanies.get(i);
        textView.setText(pytanie.getTrescPytania());
        imageView.setImageResource(pytanie.getIdObrazu());
    }
}