package ba.unsa.etf.rpr;

public class PraskastiSastojak extends Sastojak{
    public PraskastiSastojak(String naziv, int kolicina) {
        super(naziv, kolicina);
    }

    @Override
    public boolean equals(Object obj) {
        if((obj instanceof PraskastiSastojak) && ((Sastojak)obj).getNaziv().equals(getNaziv())) return true;
        return false;
    }

    @Override
    public int compareTo(Sastojak sastojak) {
        return Double.compare(getKolicina(), sastojak.getKolicina());
    }

    @Override
    public String toString() {
        return getKolicina() + " g " + getNaziv();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
