public class VeiculoPremium extends Veiculo {
    private double taxa;

    public VeiculoPremium(){
        super();
        this.taxa = 0.0;
    }

    public VeiculoPremium(String codVeiculo, String marca, String modelo, int ano,
                          double velMed, double precoTeorico, double classificacao, double nrKms, int nrClientes,double taxa){
        super(codVeiculo,marca,modelo,ano,velMed,precoTeorico,classificacao,nrKms,nrClientes);
        setTaxa(taxa);
    }

    public VeiculoPremium(VeiculoPremium a){
        super(a);
        setTaxa(a.getTaxa());
    }

    public double getTaxa(){
        return this.taxa;
    }

    public void setTaxa(double taxa){
        this.taxa = taxa;
    }

    public VeiculoPremium clone() {
        return new VeiculoPremium(this);
    }

    public double custoRealKm() {
        return getNrKms() * getPrecoTeorico() * (1+taxa);
    }
}
