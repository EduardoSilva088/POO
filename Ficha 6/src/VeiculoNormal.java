public class VeiculoNormal extends Veiculo {

    public VeiculoNormal(){
        super();
    }

    public VeiculoNormal(String codVeiculo, String marca, String modelo, int ano,
                          double velMed, double precoTeorico, double classificacao, double nrKms, int nrClientes){
        super(codVeiculo,marca,modelo,ano,velMed,precoTeorico,classificacao,nrKms,nrClientes);
    }

    public VeiculoNormal(VeiculoNormal a){
        super(a);
    }


    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        s.append("\n");
        return s.toString();
    }

    public VeiculoNormal clone(){
        return new VeiculoNormal(this);
    }

    public double custoRealKm(){
        return getNrKms() * getPrecoTeorico();
    }
}
