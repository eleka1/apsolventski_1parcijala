package ba.unsa.etf.rpr;

import java.util.Objects;

public abstract class Sastojak implements Comparable<Sastojak>{
    private String naziv;
    private int kolicina;

    public Sastojak(String naziv, int kolicina){
        this.naziv = naziv;
        this.kolicina = kolicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, kolicina);
    }

    //dodati za string
}
