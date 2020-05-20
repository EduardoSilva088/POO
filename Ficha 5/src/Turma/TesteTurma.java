package Turma;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
public class TesteTurma {
    public static void main(String[] opts) throws IOException, ClassNotFoundException {
        Aluno a1 = new Aluno("1","Ze");
        Aluno a2 = new Aluno("2","Ana");
        Aluno a3 = new Aluno("3","To");
        //Aluno a4 = new AlunoTE("4","Ana Sofia", "DIUM");

        //System.out.println("TE :" + a4);

        Turma t = new Turma();

        try{
            t.insereAluno(a1);
            t.insereAluno(a2);
            t.insereAluno(a3);
            //t.removeAluno("5");
            //t.insereAluno(a2);
        }
        catch (ExisteAlunoException e){
            System.out.println("Aluno já existe. Nr: " + e.getMessage());
        }

        //t.insereAluno(a4);

        System.out.println(t.toString());

        Set<String> s = t.todosOsCodigos();
        s.remove("2");

        System.out.println("Alfabetica: ");

        System.out.println(t.alunosOrdemAlfabetica());

        System.out.println("Numerica:");

        System.out.println(t.alunosOrdemDescrescenteNumero());

        try{
            t.gravarObj("PL5.obj");
        } catch (IOException e){
            System.out.println("Erro ao gravar!");
        }

        Turma t2 = new Turma();

        try{
            t2 = t2.lerObj("PL5.obj");
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Erro a ler!!");

        }

        try{
            t.gravaTxt("PL5.txt");
        } catch (IOException e){
            System.out.println("Erro ao gravar!");
        }

        System.out.println(t2.toString());

    }
}
