public class VeiculoPremium extends Veiculo implements BonificaKms {


    private double taxa;
    private int pontosKM;


    public VeiculoPremium(){
        super();
        this.taxa = 0.0;
        this.pontosKM=0;
    }

    public VeiculoPremium(String codVeiculo,
                          String marca,
                          String modelo,
                          int ano,
                          double velMed,
                          double precoTeorico,
                          double classificacao,
                          double nrKms,
                          int nrClientes,
                          boolean estaAlugado,
                          double taxa,
                          int pontosKM){
        super(codVeiculo,marca,modelo,ano,velMed,precoTeorico,classificacao,nrKms,nrClientes,estaAlugado);
        setTaxa(taxa);
        this.pontosKM=pontosKM;
    }

    public VeiculoPremium(VeiculoPremium a){
        super(a);
        setTaxa(a.getTaxa());
        pontosKM=a.getPtsPorKm();
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

    public void definirPtsPorKm(int pts) {
        this.pontosKM=pts;
    }

    public int getPtsPorKm() {
        return pontosKM;
    }

    public double getPtsVeiculo(Veiculo v) {
        return pontosKM * v.getNrKms();
    }
}
