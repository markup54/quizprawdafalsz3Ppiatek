package pl.zs10.testtaknie3ppiatek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("NRPYTANKA",aktualne);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        if(savedInstanceState != null){
            aktualne = savedInstanceState.getInt("NRPYTANKA");
            wyswietlPytanie(aktualne);
        }
        else {
            wyswietlPytanie(0);
        }
        buttonTak = findViewById(R.id.button);
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (sprawdzCzyDobrze(aktualne, true))
                            Toast.makeText(MainActivity.this, "dobra odpowiedź", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "zła odpowiedź", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        buttonNie = findViewById(R.id.button2);
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (sprawdzCzyDobrze(aktualne, false))
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
                        else {
                            int p=podliczPunkty();
                            zakonczTest(p);//nie widac tak nie podpowiedz kolejne, zamiast pytania jest liczba punktów
                        }
                    }
                }
        );
        buttonPodpowiedz = findViewById(R.id.button3);
        buttonPodpowiedz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, PodpowiedzActivity.class);
                        intent.putExtra("NR",aktualne);
                        startActivity(intent);
                    }
                }
        );
    }
    private void zakonczTest(int p){
        buttonNie.setVisibility(View.INVISIBLE);
        buttonTak.setVisibility(View.INVISIBLE);
        buttonKolejne.setVisibility(View.INVISIBLE);
        buttonPodpowiedz.setVisibility(View.INVISIBLE);
        textView.setText("Test został zakończony \n Otrzymano "+p+" puntów");
    }
    private int podliczPunkty() {
        int punkty = 0;
        for (Pytanie p :
                pytanies) {
            if (p.isCzyOdpowiedzianoPoprawnie())
                punkty++;
        }
        return punkty;
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

    //TODO odpornosc na obracanie
    //TODO odporność na oszustów:)
    //TODO jeżeli ktoś skorzysta z podpowiedzi to miej punktów
}