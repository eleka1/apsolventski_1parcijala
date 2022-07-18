package ba.unsa.etf.rpr;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Kuhar {
    private Map<String,Recept> recepti = new HashMap<>();


    public void dodajRecept(Recept r) {
        recepti.put(r.getNazivJela(), r);
    }


    public int brojRecepata() {
        return recepti.size();
    }


    public Recept dajRecept(String r) {
        return (Recept) recepti.get(r);
    }


    public ArrayList<Recept> receptiSaSastojkom(Sastojak sastojak) {
//        return filtriraj(r -> r.getSastojci().stream().filter(s -> s.getNaziv().equals(sastojak.getNaziv())).findFirst().isPresent());
        return filtriraj(r -> {
           ArrayList<Sastojak> sastojci = (ArrayList<Sastojak>) r.getSastojci();
           boolean prisutan = false;
           for(var s : sastojci){
               if(s.getNaziv().equals(sastojak.getNaziv()))
                   prisutan = true;
           }
           return prisutan;
        });
    }

    public Set<Sastojak> sviSastojci() {
//        return recepti.values().stream().map(Recept::getSastojci).flatMap(List::stream).collect(Collectors.toCollection(TreeSet::new));
        TreeSet<Sastojak> povrat = new TreeSet<>();
        for(var recept : recepti.keySet()){

            List<Sastojak> sastojci = (ArrayList<Sastojak>) recepti.get(recept).getSastojci();
            povrat.addAll(sastojci);
        }
        return povrat;
    }

    public ArrayList<Recept> filtriraj(Predicate<Recept> p) {
//        return recepti.values().stream().filter(p).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Recept> povrat = new ArrayList<>();
        for(var recept : recepti.keySet()){
            if(p.test(recepti.get(recept)))
                povrat.add(recepti.get(recept));
        }
        return povrat;
    }
}
