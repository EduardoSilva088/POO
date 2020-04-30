package GestaoEncomenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EncomendaAL{
    private String nome;
    private String nif;
    private String morada;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;
    private String nEnc;

    public EncomendaAL(){
        this.nome = new String();
        this.nif = new String();
        this.morada = new String();
        this.data = LocalDate.now();
        this.linhas = new ArrayList<>();
        this.nEnc = new String();
    }

    public EncomendaAL(String n, String nif, String m, ArrayList<LinhaEncomenda> l, String nEnc){
        this.setNome(n);
        this.setNif(nif);
        this.setMorada(m);
        this.setLinhas(l);
        this.setNEnc(nEnc);
    }

    public EncomendaAL(EncomendaAL e){
        this.setNome(e.getNome());
        this.setNif(e.getNif());
        this.setMorada(e.getMorada());
        this.setData(e.getData());
        this.setLinhas(e.getLinhas());
        this.setNEnc(e.getNEnc());
    }

    public String getNome(){
        return this.nome;
    }

    public String getNif(){
        return this.nif;
    }

    public String getMorada(){
        return this.morada;
    }

    public LocalDate getData(){
        return this.data;
    }

    public ArrayList<LinhaEncomenda> getLinhas(){
        return this.linhas;
    }

    public String getNEnc(){
        return this.nEnc;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNif(String nif){
        this.nif = nif;
    }

    public void setMorada(String m){
        this.morada = m;
    }

    public void setLinhas(ArrayList<LinhaEncomenda> l){
        this.linhas = new ArrayList<>();
        for(LinhaEncomenda s : l)
            this.linhas.add(s);
    }

    public void setData(LocalDate d){
        this.data = d;
    }

    public void setNEnc(String n){
        this.nEnc = n;
    }

    public double calculaValorTotal(){
        double res = 0;
        for (LinhaEncomenda s : this.linhas)
            res += s.calculaValorLinhaEnc();
        return res;
    }

    public double calculaValorDesconto(){
        double res = 0;
        this.linhas = new ArrayList<LinhaEncomenda>();
        for(LinhaEncomenda s : this.linhas)
            res += s.calculaValorDesconto();
        return res;
    }

    public int numeroTotalProdutos(){
        int res = 0;
        this.linhas = new ArrayList<LinhaEncomenda>();
        for(LinhaEncomenda s : this.linhas){
            res += s.getQuantidade();
        }
        return res;
    }

    public List<String> getReferencias(){
        List<String> aux = new ArrayList<String>();
        for(LinhaEncomenda s : this.linhas)
            aux.add(s.getReferencia());
        return aux;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        boolean res = false;
        for(LinhaEncomenda s : this.linhas){
            if(refProduto.equals(s.getReferencia())){
                res = true;
                break;
            }
        }
        return res;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        this.linhas.add(linha);
    }

    public void removeProduto(String codProd){
        int i = 0;
        for (LinhaEncomenda s : this.linhas){
            if (codProd.equals(s.getReferencia())){
                this.linhas.remove(i);
                break;
            }
            i++;
        }
    }

    public String toString(){
        return "\nEnc: " + this.nome + "\nNif: " + this.nif
                + "\nMorada: " + this.morada
                + "\nData: " + this.data
                + "\nNEncomenda " + this.nEnc;
    }

    public EncomendaAL clone(){
        return new EncomendaAL(this);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass() ) return false;
        EncomendaAL e = (EncomendaAL) o;
        return this.nome.equals(e.getNome()) &&
                this.nif.equals(e.getNif()) &&
                this.morada.equals(e.getMorada()) &&
                this.nEnc.equals(e.getNEnc()) &&
                this.data.equals(e.getData()) &&
                this.nEnc.equals(e.getNEnc()) &&
                this.linhas.equals(e.getLinhas());
    }

}