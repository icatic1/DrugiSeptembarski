package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Recept{
    private String nazivJela;
    private List<Sastojak> sastojci = new ArrayList<>();
    private VrstaPripreme vrstaPripreme=VrstaPripreme.KUHANJE;
    private int podatak;


    public Recept(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public String getNazivJela() {
        return nazivJela;
    }

    public void setNazivJela(String nazivJela) {
        this.nazivJela = nazivJela;
    }

    public VrstaPripreme getVrstaPripreme() {
        return vrstaPripreme;
    }

    public void setVrstaPripreme(VrstaPripreme vrstaPripreme) {
        this.vrstaPripreme = vrstaPripreme;
    }

    public int getPodatak() {
        return podatak;
    }

    public void setPodatak(int podatak) {
        this.podatak = podatak;
    }


    public void dodajSastojak(Sastojak sastojak) {
        if(!sastojci.contains(sastojak))sastojci.add(sastojak);
        else sastojci.stream().forEach(sastojak1 -> {if(sastojak1.equals(sastojak))sastojak1.setKolicina(sastojak1.getKolicina()+sastojak.getKolicina());});
    }

    public void izbaciSastojak(Sastojak sastojak) {
        if(sastojci.contains(sastojak))sastojci.remove(sastojak);
        else throw new NoSuchSastojakException("Nepoznat sastojak "+sastojak.getNaziv());
    }

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recept za "+getNazivJela()+"\n");

        for(var x:sastojci){
            sb.append(x.toString()+"\n");
        }
        if (sastojci.isEmpty())sb.append("\n");
        if(vrstaPripreme.equals(VrstaPripreme.PECENJE)) sb.append("Peći na "+getPodatak()+" stepeni");
        else if(vrstaPripreme.equals(VrstaPripreme.KUHANJE)) sb.append("Kuhati "+getPodatak()+" minuta");
        else if(vrstaPripreme.equals(VrstaPripreme.PRZENJE)) sb.append("Pržiti "+getPodatak()+" minuta");

        return sb.toString();
    }

}
