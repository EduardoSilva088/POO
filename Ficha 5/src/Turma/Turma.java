package Turma;

import java.util.*;
import java.util.stream.Collectors;

public class Turma {
    private String nome;
    private String codigo;
    private Map<String,Aluno> alunos;

    public Turma(){
        this.nome = new String();
        this.codigo = new String();
        this.alunos = new HashMap<>();
    }

    public Turma(String n, String c, Map<String,Aluno> als){
        this.nome = n;
        this.codigo = c;
        setAlunos(als);
    }

    public Turma(Turma t){
        this.nome = t.getNome();
        this.codigo = t.getCodigo();
        setAlunos(t.getAlunos());
    }

    public String getNome(){
        return this.nome;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public Map<String,Aluno> getAlunos(){
        Map<String,Aluno> res = new HashMap<>();
        this.alunos.forEach((key, value) -> res.put(key, value.clone()));
        return res;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setAlunos(Map<String, Aluno> alunos) {
        this.alunos = new HashMap<>();
        alunos.forEach((key, value) -> this.alunos.put(key, value.clone()));
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Turma: ").append(this.nome).append("\n")
                .append(this.codigo).append("\n")
                .append(this.alunos);
        return s.toString();
    }

    public Turma clone(){
        return new Turma (this);
    }

    public int compareTo(Turma t){
        return this.nome.compareTo(t.getNome());
    }

    //Alinea ii)
    public void insereAluno(Aluno a){

    }
}
