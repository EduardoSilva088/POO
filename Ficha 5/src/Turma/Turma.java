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
        this.alunos.put(a.getNumero(),a.clone());
    }

    //Alinea iii)
    public Aluno getAluno(String codAluno){
        return this.alunos.get(codAluno).clone();
    }

    //Alinea iv)
    public void removeAluno(String codAluno){
        this.alunos.remove(codAluno);
    }

    //Alinea v)
    public Set<String> todosOsCodigos(){
        return new TreeSet<>(this.alunos.keySet());
    }

    //Alinea vi)
    public int qtsAlunos(){
        return this.alunos.size();
    }


    //Alinea vii)
    public Set<Aluno> alunosOrdemAlfabetica(){
        Set<Aluno> s = new TreeSet<>(new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                if (a1.getNumero().compareTo(a2.getNumero()) > 0) return 1;
                if (a1.getNumero().compareTo(a2.getNumero()) < 0) return -1;
                return a1.getNome().compareTo(a2.getNome());
            }
        });
        this.alunos.values().forEach(a ->s.add(a.clone()));
        return s;
    }

    //Alinea viii)
    public Set<Aluno> alunosOrdemDescrescenteNumero(){
        Set<Aluno> s = new TreeSet<>(new Comparator<Aluno>() {
            @Override
            public int compare(Aluno o1, Aluno o2) {
                if(o1.getNumero().compareTo(o2.getNumero()) > 0) return -1;
                if(o1.getNumero().compareTo(o2.getNumero()) < 0) return 1;
                return o1.getNumero().compareTo(o2.getNumero());
            }
        });
        this.alunos.values().forEach(a->s.add(a.clone()));
        return s;
    }

}
