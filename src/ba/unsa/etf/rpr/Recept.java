package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recept implements Comparable {
    private String nazivJela;
    private List<Sastojak> sastojci = new ArrayList<>();
    private VrstaPripreme vrstaPripreme = VrstaPripreme.KUHANJE; //popravi ali kasnije
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

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    public void dodajSastojak(Sastojak s){
//        sastojci.stream().filter(sastojak -> s.equals(sastojak))
//        .findFirst().ifPresentOrElse(sastojak -> sastojak.setKolicina(sastojak.getKolicina() + s.getKolicina()), () -> sastojci.add(s));
        boolean postoji = false;
        for(int i = 0; i<sastojci.size(); i++){
            if(sastojci.get(i).equals(s)){
                postoji = true;
                sastojci.get(i).setKolicina(s.getKolicina() + sastojci.get(i).getKolicina());
                break;
            }
        }
        if(!postoji)
            sastojci.add(s);
    }

    public void izbaciSastojak(Sastojak s){
//        sastojci.stream().filter(sastojak -> s.equals(sastojak))
//        .findFirst().ifPresentOrElse((sastojak) -> sastojci.remove(s), () -> {throw new NoSuchSastojakException("Nepoznat sastojak " + s.getNaziv());});
        boolean postoji = false;
        for(int i = 0; i<sastojci.size(); i++){
            if(sastojci.get(i).equals(s)){
                postoji = true;
                sastojci.remove(s);
                break;
            }
        }
        if(!postoji)
            throw new NoSuchSastojakException("Nepoznat sastojak " + s.getNaziv());
    }

    @Override
    public String toString() { //POPRAVI oprostit
//        return "Recept za " + nazivJela + "\n" +
//                sastojci.stream().map(Sastojak::toString).collect(Collectors.joining("\n"))
//                + vrstaPripreme : ? "";
//        String povrat = "Recept za " + nazivJela + "\n" +
//                sastojci.stream().map(Sastojak::toString).collect(Collectors.joining("\n"));
        String povrat = "Recept za " + nazivJela + "\n";
        for(int i=0; i<sastojci.size(); i++){
            if(i == sastojci.size() - 1)
                povrat+= sastojci.get(i).toString();
            else
                povrat+= sastojci.get(i).toString() + "\n";
        }
//        for(var sastojak : sastojci){
//            povrat +=  "\n" + sastojak.toString();
//        }
        if(vrstaPripreme.equals(VrstaPripreme.PECENJE)) povrat += "\nPeći na " + podatak + " stepeni";
        else if(vrstaPripreme.equals(VrstaPripreme.KUHANJE)) povrat += "\nKuhati " + podatak + " minuta";
        else povrat += "\nPržiti " + podatak + " minuta";
        return povrat;
    }


    @Override
    public int compareTo(Object o) {
        if(((Sastojak)o).getNaziv().equals(nazivJela)) return 0;
        return 1;
    }
}
