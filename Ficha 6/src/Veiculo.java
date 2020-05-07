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
    }

    public Veiculo(String codVeiculo, String marca, String modelo, int ano,
                   double velMed, double precoTeorico, double classificacao, double nrKms, int nrClientes){
        this.codVeiculo = codVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velMed = velMed;
        this.precoTeorico = precoTeorico;
        this.classificacao = classificacao;
        this.nrKms = nrKms;
        this.nrClientes = nrClientes;
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

    public abstract Veiculo clone();
    public abstract double custoRealKm();

    public String toString(){
        return "Codigo: " + this.codVeiculo + " Marca: " + this.marca
                + " Modelo: " + this.modelo
                + " Ano: " + this.ano
                + " VelMedia: " + this.velMed
                + " PrecoTeorico: " + this.precoTeorico
                + " Classificacao: " + this.classificacao
                + " Nr Kms: " + this.nrKms
                + " Nr Clientes: " + this.nrClientes;
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
