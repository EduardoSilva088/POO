package Turma;

import java.util.Set;
public class TesteTurma
{
    public static void main(String[] opts){
        Aluno a1 = new Aluno("1","Ze");
        Aluno a2 = new Aluno("2","Ana");
        Aluno a3 = new Aluno("3","To");
        Aluno a4 = new AlunoTE("4","Ana Sofia", "DIUM");

        System.out.println("TE :" + a4);

        Turma t = new Turma();

        t.insereAluno(a1);
        t.insereAluno(a2);
        t.insereAluno(a3);
        t.insereAluno(a4);

        System.out.println("Turma:");

        System.out.println(t.toString());

        Set<String> s = t.todosOsCodigos();
        s.remove("2");

        System.out.println("Alfabetica: ");

        System.out.println(t.alunosOrdemAlfabetica());

        System.out.println("Numerica:");

        System.out.println(t.alunosOrdemDescrescenteNumero());

    }
}
