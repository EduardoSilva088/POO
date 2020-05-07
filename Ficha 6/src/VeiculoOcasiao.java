public class VeiculoOcasiao extends Veiculo {
    private boolean promocao;

    public VeiculoOcasiao(){
        super();
        this.promocao = false;
    }

    public VeiculoOcasiao(String codVeiculo, String marca, String modelo, int ano,
                          double velMed, double precoTeorico, double classificacao, double nrKms, int nrClientes,boolean promocao){
        super(codVeiculo,marca,modelo,ano,velMed,precoTeorico,classificacao,nrKms,nrClientes);
        setPromocao(promocao);
    }

    public VeiculoOcasiao(VeiculoOcasiao a){
        super(a);
        setPromocao(a.getPromocao());
    }

    public boolean getPromocao(){
        return this.promocao;
    }

    public void setPromocao(boolean a){
        this.promocao = a;
    }

    public double getPrecoTeorico(){
        return this.promocao ? 0.75 * super.getPrecoTeorico() : super.getPrecoTeorico();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(super.toString());
        if(this.promocao) s.append(" Em promocao!").append(getPrecoTeorico());
        else s.append(" Sem promocao!");
        s.append("\n");
        return s.toString();
    }

    public VeiculoOcasiao clone(){
        return new VeiculoOcasiao(this);
    }

    public double custoRealKm(){
        return getNrKms() * getPrecoTeorico();
    }

}

