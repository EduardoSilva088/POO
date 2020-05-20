import java.io.*;
import java.nio.file.Files;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIt implements Serializable
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
    public boolean existeVeiculo(String cod) throws ExisteVeiculoException {
        if(!this.veiculos.containsKey(cod))
            throw new ExisteVeiculoException(cod);
        else{
            return true;
        }
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

    public void adiciona(Veiculo v) throws ExisteVeiculoException {
        if(this.veiculos.containsKey(v.getCodVeiculo()))
            throw new ExisteVeiculoException(v.getCodVeiculo());
        else this.veiculos.put(v.getCodVeiculo(),v.clone());
    }

    public List<Veiculo> getVeiculos(){
        List<Veiculo> res = new ArrayList<>();
        this.veiculos.forEach((cod,veiculo) -> res.add(veiculo.clone()));
        return res;
    }

    public void adiciona(Set<Veiculo> vs){
        vs.forEach(e-> {
            try {
                adiciona(e);
            } catch (ExisteVeiculoException existeVeiculoException) {
                existeVeiculoException.printStackTrace();
            }
        });
    }

    public void registarAluguer(String codVeiculo, int numKms) throws ExisteVeiculoException, ValoresNegativosException {
        if(this.veiculos.containsKey(codVeiculo)){
            throw new ExisteVeiculoException(codVeiculo);
        }
        if(numKms < 0){
            throw new ValoresNegativosException(numKms);
        }
        else{
            Veiculo veiculo = this.veiculos.get(codVeiculo).clone();
            double kms = (veiculo.getNrKms() + numKms);
            veiculo.setNrKms(kms);
            this.veiculos.replace(codVeiculo,veiculo);
        }

    }

    public void classificarVeiculo(String cod, int classificacao) throws ExisteVeiculoException, ValoresNegativosException {
        if(this.veiculos.containsKey(cod)){
            throw new ExisteVeiculoException(cod);
        }
        if(classificacao < 0){
            throw new ValoresNegativosException(classificacao);
        }
        else {
            Veiculo veiculo = this.veiculos.get(cod).clone();
            int nrClientes = veiculo.getNrClientes();
            double novaClassificacao = ((double)nrClientes * veiculo.getClassificacao() + (double) classificacao) / (nrClientes+1);
            nrClientes += 1;
            veiculo.setClassificacao(novaClassificacao);
            veiculo.setNrClientes(nrClientes);
            this.veiculos.replace(cod,veiculo);
        }
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

    //FASE IV
    public void ExportCsv(String file) throws IOException, ClassNotFoundException, FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        StringBuilder sb = new StringBuilder();
        for(Veiculo v : this.veiculos.values()) {
            sb.append(v.getCodVeiculo()).append(',')
                    .append(v.getMarca()).append(',')
                    .append(v.getModelo()).append(',')
                    .append(v.getAno()).append(',')
                    .append(v.getVelMed()).append(',')
                    .append(v.getPrecoTeorico()).append(',')
                    .append(v.getClassificacao()).append(',')
                    .append(v.getNrKms()).append(',')
                    .append(v.getNrClientes()).append(',')
                    .append(v.getEstaAlugado());
            if(v instanceof VeiculoOcasiao) sb.append(',').append(((VeiculoOcasiao) v).getPromocao()).append('\n');
            if(v instanceof VeiculoPremium) sb.append(',').append(((VeiculoPremium) v).getTaxa()).append('\n');
            if(v instanceof AutocarroInteligente) sb.append(',').append(((AutocarroInteligente) v).getOcupacao()).append('\n');
            if(v instanceof VeiculoNormal) sb.append('\n');
        }
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }


    public void gravarObj(String fileName) throws IOException {
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName));
        o.writeObject(this);
        o.flush();
        o.close();
    }

    public DriveIt lerObj(String fileName) throws IOException, ClassNotFoundException{
        ObjectInputStream o = new ObjectInputStream(new FileInputStream(fileName));
        DriveIt res = (DriveIt) o.readObject();
        o.close();
        return res;
    }
}
