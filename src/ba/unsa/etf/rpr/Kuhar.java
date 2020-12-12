package ba.unsa.etf.rpr;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Kuhar {
    private Map<String,Recept> recepti= new HashMap<>();



    public void dodajRecept(Recept r) {
        if(!recepti.containsKey(r.getNazivJela()))recepti.put(r.getNazivJela(),r);
    }

    public Recept dajRecept(String ime) {
        return recepti.get(ime);
    }

    public int brojRecepata() {
        return recepti.values().size();
    }

    public ArrayList<Recept> receptiSaSastojkom(Sastojak sastojak) {
        ArrayList<Recept> povratni = new ArrayList<>();
        recepti.values().stream().forEach(recept -> {recept.getSastojci().stream().forEach(sastojak1 -> {if(sastojak1.getNaziv().equals(sastojak.getNaziv()))povratni.add(recept);});});
        return povratni;
    }

    public Set<Sastojak> sviSastojci() {
        Set<Sastojak> povratna = new TreeSet<Sastojak>();
        recepti.values().stream().forEach(recept -> {recept.getSastojci().stream().forEach(sastojak1 -> {povratna.add(sastojak1);});});
        return  povratna;
    }

    public ArrayList<Recept> filtriraj(Predicate<Recept> lambda){
        return (ArrayList<Recept>) recepti.values().stream().filter(lambda).collect(Collectors.toList());
    }
}
