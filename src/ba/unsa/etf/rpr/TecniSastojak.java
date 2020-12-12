package ba.unsa.etf.rpr;

public class TecniSastojak extends Sastojak{

    public TecniSastojak(String naziv, int kolicina) {
        super(naziv, kolicina);
    }

    @Override
    public String toString() {
        return getKolicina() + " dl " + getNaziv();
    }

    @Override
    public int compareTo(Sastojak o) {
        if(getKolicina()>o.getKolicina()) return 1;
        if(getKolicina()<o.getKolicina()) return -1;
        return 0;
    }

}
