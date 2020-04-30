package Turma;

public class AlunoTE extends Aluno {
    private String empresa;

    public AlunoTE(){
        super();
        this.empresa = new String();
    }

    public AlunoTE(String numero, String nome, String empresa){
        super(numero,nome);
        this.empresa = empresa;
    }

    public AlunoTE(AlunoTE a){
        super(a.getNumero(),a.getNome());
        this.empresa = a.getEmpresa();
    }

    public String getEmpresa(){
        return this.empresa;
    }

    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Empresa : ").append(this.empresa).append("\n");
        return sb.toString();
    }

    public AlunoTE clone(){
        return new AlunoTE(this);
    }

}

