package pl.zs10.testtaknie3ppiatek;

import java.util.ArrayList;

public class RepozytoriumPytania {
    public static ArrayList<Pytanie> utworzPytania(){
        ArrayList<Pytanie> pytania = new ArrayList<>();
        pytania.add(new Pytanie("Góra na zdjęciu to Giewont",
                true,
                "Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego Jest to słynna góra widoczna z Zakopanego",
                R.drawable.giewont));
        pytania.add(new Pytanie("Czy na zdjęciu jest widoczny Mnich?",
                true,
                "Na zdjęciu jest widoczny szczyt w poblizu Morskiego Oka, góra kształtem przypomina zakonnika",
                R.drawable.mnich));
        pytania.add(new Pytanie("Czy na zdjęciu przedstawiono Tarnowskie Góry?",
                false,
                "Na zdjęciu są widoczne góry wysunięte najbardziej na wschód Polski, charakteryzują się pięknymi połoninami.",
                R.drawable.bieszczady));

        return  pytania;
    }

}
