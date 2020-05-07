public class AutocarroInteligente extends Veiculo {

    private double ocupacao;

    public AutocarroInteligente(){
        super();
        this.ocupacao=0;
    }
    public AutocarroInteligente(String codVeiculo,
                                String marca,
                                String modelo,
                                int ano,
                                double velMed,
                                double precoTeorico,
                                double classificacao,
                                double nrKms,
                                int nrClientes,
                                boolean estaAlugado,
                                double ocupacao) {
        super(codVeiculo,marca,modelo,ano,velMed,precoTeorico,classificacao,nrKms,nrClientes,estaAlugado);
        this.ocupacao = ocupacao;
    }
    public AutocarroInteligente(AutocarroInteligente a){
        super(a);
        this.ocupacao=a.getOcupacao();
    }

    public double getOcupacao() {
        return ocupacao;
    }
    public void setOcupacao(double ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double custoRealKm() {
        double ocupacao = getOcupacao();
        double taxa = 0;
        if(ocupacao <= 0.6) taxa = 0.5;
        else taxa = 0.25;
        return getNrKms() * getPrecoTeorico() * taxa;
    }
    public AutocarroInteligente clone(){
        return new AutocarroInteligente(this);
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" Taxa de ocupação: ");
        sb.append(this.ocupacao).append("\n");
        return sb.toString();
    }

}
