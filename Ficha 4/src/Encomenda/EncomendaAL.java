package Encomenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class EncomendaAL {
    private String nome;
    private String nif;
    private String morada;
    private int num;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> linhas;

    public EncomendaAL(){
        this.nome = new String();
        this.nif = new String();
        this.morada = new String();

        this.data = LocalDate.now();
        this.linhas = new ArrayList<>();
    }

    public EncomendaAL(String n, String nif, String m, ArrayList<LinhaEncomenda> l){
        this.setNome(n);
        this.setNif(nif);
        this.setMorada(m);
        this.setLinhas(l);
    }

    public EncomendaAL(EncomendaAL e){
        this.setNome(e.getNome());
        this.setNif(e.getNif());
        this.setMorada(e.getMorada());
        this.setNum(e.getNum());
        this.setData(e.getData());
        this.setLinhas(e.getLinhas());
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

    public int getNum(){
        return this.num;
    }

    public ArrayList<LinhaEncomenda> getLinhas(){
        return this.linhas;
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

    public void setNum(int e){
        this.num = e;
    }

    public void setData(LocalDate d){
        this.data = d;
    }

    // Alinea ii)
    public double calculaValorTotal() {
        return this.linhas.stream()
                          .mapToDouble(LinhaEncomenda :: calculaValorLinhaEnc)
                          .sum();
    }

    //Alinea iii)
    public double calculaValorDesconto(){
        return this.linhas.stream()
                          .mapToDouble(LinhaEncomenda::calculaValorDesconto)
                          .sum();
    }

    //Alinea iv)
    public int nrTotalProdutos(){
        return this.linhas.stream()
                          .mapToInt(LinhaEncomenda::getQuantidade)
                          .sum();
    }

    //Alinea v)
    public boolean existeProdutoEnc(String refProd){
        boolean existe = false;
        Iterator<LinhaEncomenda> it = this.linhas.iterator();
        while(it.hasNext() && !existe){
            LinhaEncomenda a = it.next();
            if(refProd.equals(a.getReferencia())) existe = true;
        }
        return existe;
    }

    //Alinea vi)
    public void adicionaLinhaEnc(LinhaEncomenda linha){
        this.linhas.add(linha);
    }

    //Alinea vii)
    public void removeProduto(String codProd){
        this.linhas.removeIf(a -> codProd.equals(a.getReferencia()));
    }
/*
    public void removeProduto(String codProd){
        Iterator<LinhaEncomenda> it = this.linhas.iterator();
        while(it.hasNext()){
            LinhaEncomenda a = it.next();
            if(codProd.equals(a.getReferencia()))
                it.remove();
        }
    }
*/


}
