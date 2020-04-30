package CasaInteligente;


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;

public class CasaInteligente {
    private String nome;
    private List<Lampada> lampadas;

    //Construtor por omissaão
    public CasaInteligente(){
        this.nome = new String();
        this.lampadas  = new ArrayList<>();
    }

    //construtor parametrizado
    public CasaInteligente(String nome, List<Lampada> lps){
        this.nome = nome;
        setLampadas(lps);
    }

    public CasaInteligente(CasaInteligente ci){
        this.nome = ci.getNome();
        setLampadas(ci.getLampadas());
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Lampada> getLampadas() {
        List<Lampada> lamps = new ArrayList<>();
        for(Lampada l : this.lampadas)
            lamps.add(l.clone());
        return lamps;
    }

    public void setLampadas(List<Lampada> lps) {
        this.lampadas = new ArrayList<>();
        for (Lampada l : lps)
            this.lampadas.add(l.clone());
    }

    //Alinea i)
    public void addLampada(Lampada l) {
        this.lampadas.add(l.clone());
    }

    //Alinea ii)
    public void ligaLampadaNormal(int index){
        this.lampadas.get(index).lampON();
    }

    //Alinea iii)
    public void ligaLampadaEco(int index){
        this.lampadas.get(index).lampECO();
    }

    //Alinea iv)
    public int qtEmEco(){
        return (int) this.lampadas.stream()
                                  .filter(p->p.getModo() == 2)
                                  .count();
    }
    //Com Iterador
    public int qtEmEcoIT(){
        int c = 0;
        Iterator<Lampada> it = this.lampadas.iterator();
        while(it.hasNext()){
            Lampada l = it.next();  //Lampada l= it[i++]
            if(l.getModo() == 2)
                c++;
        }
        return c;
    }

    //Alinea v)
    public void removeLampada(int index){
        this.lampadas.remove(index);
    }

    //Alinea vi)
    public void ligaTodasEco(){
        this.lampadas.stream()
                     .forEach(l->l.lampECO());
    }

    public void ligaTodasMax(){
        this.lampadas.stream()
                     .forEach(l->l.lampON());
    }

    //Alinea vii)
    public double consumoTotal(){
        return (double) this.lampadas.stream()
                            .mapToLong(l->l.getTotal())
                            .sum();
    }

    //Alinea viii)
    public void reset(){
        this.lampadas.stream()
                     .forEach(l->l.setTotal(0));
    }

    //Lampada mais gastadora
    public Lampada lampadaMaisGastadora(){
        TreeSet<Lampada> ts = new TreeSet<>();
        //Ordem do compareTo da lampada.
        ts.addAll(this.lampadas);
        return ts.first().clone();
    }
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        CasaInteligente ci = (CasaInteligente) o;
        return this.nome.equals(ci.getNome()) &&
                this.lampadas.equals(ci.getLampadas());
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }

}
