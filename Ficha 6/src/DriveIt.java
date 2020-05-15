import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt
{
    private Map<String,Veiculo> veiculos;


    public DriveIt(){
        this.veiculos = new HashMap<>();
    }

    public DriveIt(Map<String,Veiculo> velos){
        setVeiculos(velos);
    }

    public DriveIt(DriveIt drive){
        setVeiculos(drive.getVeiculosC());
    }

    public Map<String,Veiculo> getVeiculosC(){
        Map<String,Veiculo> res = new HashMap<>();
        for(Map.Entry<String,Veiculo> e :this.veiculos.entrySet() )
            res.put(e.getKey(),e.getValue().clone());
        return res;
    }

    public void setVeiculos(Map<String,Veiculo> velos){
        this.veiculos = new HashMap<>();
        velos.entrySet().forEach(e->this.veiculos.put( e.getKey(),
                e.getValue().clone()));
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Lista: ").append(this.veiculos);
        return s.toString();
    }

    public DriveIt clone(){
        return new DriveIt(this);
    }

    //FASE I
    public boolean existeVeiculo(String cod){
        return this.veiculos.containsKey(cod);
    }

    public int quantos(){
        return this.veiculos.size();
    }

    public int quantos(String marca){
        return (int) this.veiculos.values().stream()
                .filter(v -> marca.equals(v.getMarca()))
                .count();
    }

    public int quantosT(String tipo){
        int res = 0;
        switch (tipo){
            case "Ocasião": res = (int) veiculos.values().stream()
                                                                .filter(v -> v instanceof VeiculoOcasiao)
                                                                .count();
                            break;
            case "Premium": res = (int) veiculos.values().stream()
                                                                .filter(v -> v instanceof VeiculoPremium)
                                                                .count();
                            break;
            case "Normal": res = quantos() - quantosT("Ocasiao") - quantosT("Premium");
                           break;
        }
        return res;
    }

    public Veiculo getVeiculo(String cod){
        return this.veiculos.get(cod).clone();
    }

    public void adiciona(Veiculo v){
        this.veiculos.put(v.getCodVeiculo(),v.clone());
    }

    public List<Veiculo> getVeiculos(){
        List<Veiculo> res = new ArrayList<>();
        this.veiculos.forEach((cod,veiculo) -> res.add(veiculo.clone()));
        return res;
    }

    public void adiciona(Set<Veiculo> vs){
        vs.forEach(e->adiciona(e));
    }

    public void registarAluguer(String codVeiculo, int numKms){
        Veiculo veiculo = this.veiculos.get(codVeiculo).clone();
        double kms = (veiculo.getNrKms() + numKms);
        veiculo.setNrKms(kms);
        this.veiculos.replace(codVeiculo,veiculo);
    }

    public void classificarVeiculo(String cod, int classificacao){
        Veiculo veiculo = this.veiculos.get(cod).clone();
        int nrClientes = veiculo.getNrClientes();
        double novaClassificacao = ((double)nrClientes * veiculo.getClassificacao() + (double) classificacao) / (nrClientes+1);
        nrClientes += 1;
        veiculo.setClassificacao(novaClassificacao);
        veiculo.setNrClientes(nrClientes);
        this.veiculos.replace(cod,veiculo);
    }

    public double custoRealKm(String cod){
        double res = 0;
        Veiculo vei = this.veiculos.get(cod).clone();
        if(vei != null) res = 1.10 * vei.custoRealKm();
        return res;
    }

    public Veiculo veiculoMaisBarato(){
        return this.veiculos.values().stream()
                                     .reduce((v1,v2) -> v1.custoRealKm() < v2.custoRealKm() ? v1 : v2)
                                     .get();
    }

    public Veiculo veiculoMenosUtilizado(){
        return this.veiculos.values().stream()
                                     .reduce((v1, v2) -> v1.getNrKms() < v2.getNrKms()? v1 :v2)
                                     .get();
    }

    public void alteraPromocao(boolean p){
        for(Veiculo v : this.veiculos.values()){
            if (v instanceof VeiculoOcasiao){
                VeiculoOcasiao e = (VeiculoOcasiao) v;
                e.setPromocao(p);
            }
        }
    }

    public double valorMedioKmBus(){
        double precoTotal = 0, media = 0;
        int tamanho = 0;
        for(Veiculo v : this.veiculos.values()){
            if(v instanceof AutocarroInteligente){
                AutocarroInteligente a = (AutocarroInteligente) v.clone();
                a.setOcupacao(0.85);
                tamanho++;
                precoTotal += a.custoRealKm();
            }
        }
        media = precoTotal/tamanho;
        return media;
    }
    //FASE II
    public Set<Veiculo> ordenarVeiculos(){
        Set<Veiculo> aux = new TreeSet<>();
        for(Veiculo v : this.veiculos.values()){
            aux.add(v.clone());
        }
        return aux;
    }

    public List<Veiculo> ordenarVeiculosLista(){
        return this.veiculos.values().stream()
                                     .sorted()
                                     .map(Veiculo::clone)
                                     .collect(Collectors.toList());
    }

    private Map<String,Comparator<Veiculo>> ordem = new TreeMap<>();

    public void addCriterio(String c, Comparator<Veiculo> cp){
        ordem.put(c,cp);
    }

    public Iterator<Veiculo> ordenarVeiculos(String criterio){
        Set<Veiculo> s = new TreeSet<>(ordem.get(criterio));
        for(Veiculo v : this.veiculos.values()){
            s.add(v.clone());
        }
        return s.iterator();
    }

    //FASE III
    public List<BonificaKms> daoPontos(){
        List<BonificaKms> bonificaKmsList = new ArrayList<>();
        for(Veiculo v : this.veiculos.values()){
            if(v instanceof VeiculoPremium || v instanceof AutocarroInteligente){
                BonificaKms bk = (BonificaKms) v.clone();
                bonificaKmsList.add(bk);
            }
        }
        return bonificaKmsList;
    }
}
