package Turma;

public class Aluno implements Comparable<Aluno> {
    private String numero;
    private String nome;


    public Aluno() {
        this.numero = new String();
        this.nome = new String();
    }

    public Aluno (String num, String nom) {
        this.numero = num;
        this.nome = nom;
    }

    public Aluno (Aluno al) {
        this.numero = al.getNumero();
        this.nome = al.getNome();
    }

    public String getNome() {
        return this.nome;
    }

    public String getNumero() {
        return this.numero;
    }




    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: ").append(this.numero).append(" , ")
                .append(this.nome).append("\n");
        return sb.toString();
    }

    public boolean equals (Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Aluno a = (Aluno) o;
        return this.numero.equals(a.getNumero()) &&
                this.nome.equals(a.getNome());
    }

    public Aluno clone() {
        return new Aluno(this); }

    public int compareTo(Aluno a) {
        return this.nome.compareTo(a.getNome());
    }

}
