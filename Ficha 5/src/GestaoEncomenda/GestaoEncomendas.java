package GestaoEncomenda;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {

    private Map<String,EncomendaAL> encomendas;

    public GestaoEncomendas(){
        this.encomendas = new HashMap<>();
    }

    private GestaoEncomendas(Map<String,EncomendaAL> enc){
        setEncomendas(enc);
    }

    private GestaoEncomendas(GestaoEncomendas g){
        setEncomendas(g.getEncomendas());
    }

    private Map<String,EncomendaAL> getEncomendas(){
        Map<String,EncomendaAL> res = new HashMap<>();
        this.encomendas.forEach((key,value)->res.put(key,value.clone()));
        return res;
    }

    private void setEncomendas(Map<String,EncomendaAL> encomendas){
        this.encomendas = new HashMap<>();
        encomendas.forEach((key,value)-> this.encomendas.put(key,value.clone()));
    }

    //Alinea i)
    public Set<String> todosCodigosEnc(){
        return this.encomendas.keySet();
    }

    //Alinea ii)
    public void addEncomenda(EncomendaAL enc){
        this.encomendas.put(enc.getNEnc(),enc.clone());
    }

    //Alinea iii)
    public EncomendaAL getEncomenda(String codEnc){
        return this.encomendas.get(codEnc).clone();
    }

    //Alinea iv)
    public void removeEncomenda(String codEnc){
        this.encomendas.remove(codEnc);
    }

    //Alinea v)
    public String encomendaComMaisProdutos(){
        String res = new String();
        int max = 0;
        for(EncomendaAL a : this.encomendas.values()){
            if(a.getLinhas().size() > max){
                max = a.getLinhas().size();
                res = a.getNEnc();
            }
        }
        return res;
    }

    //Alinea vi)
    public Set<String> encomendasComProduto(String codProd){
        return this.encomendas.values().stream()
                                       .filter(p -> p.existeProdutoEncomenda(codProd))
                                       .map(EncomendaAL::getNEnc)
                                       .collect(Collectors.toSet());
    }

    //Alinea vii)
    public Set<String> encomendasAposData(LocalDate d){
        return this.encomendas.values().stream()
                                       .filter(p->p.getData().isAfter(d))
                                       .map(EncomendaAL :: getNEnc)
                                       .collect(Collectors.toSet());
    }

    //Alinea viii)
    public Set<EncomendaAL> encomendasValorDecrescente(){
        Set<EncomendaAL> res = new TreeSet<>(new Comparator<EncomendaAL>() {
            @Override
            public int compare(EncomendaAL o1, EncomendaAL o2) {
                if(o1.calculaValorTotal() < o2.calculaValorTotal()) return -1;
                if(o1.calculaValorTotal() > o2.calculaValorTotal()) return 1;
                return 0;
            }
        });
        this.encomendas.values().forEach(a->res.add(a.clone()));
        return res;
    }

    //Alinea ix)
    public List<String> refEncs(){
        List <String> res = new ArrayList<String>();
        for(EncomendaAL s : this.encomendas.values()){
            for(String p : s.getReferencias()){
                if(!res.contains(p)) res.add(p);
            }
        }
        return res;
    }

    public List<String> setToList(Set<String> set){
        return new ArrayList<String>(set);
    }

    public Map<String,List<String>> encomendasDeProduto(){
        Map <String,List<String>> res = new HashMap<String,List<String>>();
        for(String s : refEncs()){
            res.put(s,setToList(encomendasComProduto(s)));
        }
        return res;
    }
    public boolean equals (Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        GestaoEncomendas enc = (GestaoEncomendas) o;
        return this.encomendas.equals(enc.getEncomendas());
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Encomenda: ").append(this.encomendas);
        return s.toString();
    }

    public GestaoEncomendas clone(){
        return new GestaoEncomendas (this);
    }


}
