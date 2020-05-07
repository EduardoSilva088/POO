public abstract class Veiculo  implements Comparable<Veiculo>{
    private String codVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private double velMed;
    private double precoTeorico;
    private double classificacao;
    private double nrKms;
    private int nrClientes;
    //private boolean estaAlugado;

    public Veiculo(){
        this.codVeiculo = new String();
        this.marca = new String();
        this.modelo = new String();
        this.ano = 0;
        this. velMed = 0;
        this.precoTeorico = 0;
        this.classificacao = 0;
        this.nrKms = 0;
        this.nrClientes = 0;
        //this.estaAlugado = false;
    }

    public Veiculo(String codVeiculo,
                   String marca,
                   String modelo,
                   int ano,
                   double velMed,
                   double precoTeorico,
                   double classificacao,
                   double nrKms,
                   int nrClientes){
        this.codVeiculo = codVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velMed = velMed;
        this.precoTeorico = precoTeorico;
        this.classificacao = classificacao;
        this.nrKms = nrKms;
        this.nrClientes = nrClientes;
        //this.estaAlugado = estaAlugado;
    }

    public Veiculo(Veiculo v){
        this.codVeiculo = v.getCodVeiculo();
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        setAno(v.getAno());
        setVelMed(v.getVelMed());
        setPrecoTeorico(v.getPrecoTeorico());
        setClassificacao(v.getClassificacao());
        setNrKms(v.getNrKms());
        setNrClientes(v.getNrClientes());
        //setEstaAlugado(v.getEstaAlugado);
    }

    public String getCodVeiculo(){
        return this.codVeiculo;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getAno(){
        return this.ano;
    }

    public double getVelMed(){
        return this.velMed;
    }

    public double getPrecoTeorico(){
        return this.precoTeorico;
    }

    public double getClassificacao(){
        return this.classificacao;
    }

    public double getNrKms(){
        return this.nrKms;
    }

    public int getNrClientes(){
        return this.nrClientes;
    }
/*
    public boolean getEstaAlugado(){
        return this.estaAlugado;
    }

 */

    public void setAno(int ano){
        this.ano = ano;
    }

    public void setVelMed(double velMed){
        this.velMed = velMed;
    }

    public void setPrecoTeorico(double precoTeorico){
        this.precoTeorico = precoTeorico;
    }

    public void setClassificacao(double classificacao){
        this.classificacao = classificacao;
    }

    public void setNrKms(double nrKms){
        this.nrKms = nrKms;
    }

    public void setNrClientes(int nrClientes){
        this.nrClientes = nrClientes;
    }
/*
    public void setEstaAlugado(boolean estaAlugado){
        this.estaAlugado = estaAlugado;
    }

 */

    public abstract Veiculo clone();
    public abstract double custoRealKm();

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(" Codigo: ").append(this.codVeiculo)
         .append(" Marca: ").append(this.marca)
         .append(" Modelo: ").append(this.modelo)
         .append(" Ano: ").append(this.ano)
         .append(" VelMedia: ").append(this.velMed)
         .append(" PrecoTeorico: ").append(this.precoTeorico)
         .append(" Classificacao: ").append(this.classificacao)
         .append(" Nr Kms: ").append(this.nrKms)
         .append(" Nr Clientes: ").append(this.nrClientes);
        return s.toString();
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass() ) return false;
        Veiculo e = (Veiculo) o;
        return this.codVeiculo.equals(e.getCodVeiculo()) &&
                this.marca.equals(e.getMarca()) &&
                this.modelo.equals(e.getModelo()) &&
                this.ano == e.ano &&
                this.velMed == e.velMed &&
                this.precoTeorico == e.precoTeorico &&
                this.classificacao == e.classificacao &&
                this.nrKms == e.nrKms;
    }

    public int compareTo(Veiculo v){
        if(this.marca.equals(v.getMarca()))
            return this.modelo.compareTo(v.getModelo());
        return this.marca.compareTo(v.getMarca());
    }
}
