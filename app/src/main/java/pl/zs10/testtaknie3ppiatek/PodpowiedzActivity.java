package pl.zs10.testtaknie3ppiatek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PodpowiedzActivity extends AppCompatActivity {
private TextView textViewNaglowek;
private TextView textViePodpowiedz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podpowiedz);
        int nrPytania = getIntent().getIntExtra("NR",0);
        textViewNaglowek = findViewById(R.id.textViewTrescPytaniaPodpowiedz);
        textViePodpowiedz = findViewById(R.id.textViewPodpowiedz);
        Pytanie pytanieAktualne = RepozytoriumPytania.utworzPytania().get(nrPytania);
        textViewNaglowek.setText("Podpowiedź do pytanie: \n"+pytanieAktualne.getTrescPytania());
        textViePodpowiedz.setText(pytanieAktualne.getPodpowiedz());
    }
}