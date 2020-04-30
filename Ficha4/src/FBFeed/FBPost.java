package FBFeed;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class FBPost
{
    private int id;
    private String nome;
    private LocalDateTime data;
    private String conteudo;
    private int likes;
    private List<String> comentarios;

    public FBPost(){
        this.id = 0;
        this.nome = new String();
        this.data = LocalDateTime.now();
        this.conteudo = new String();
        this.likes = 0;
        this.comentarios = new ArrayList<>();
    }

    public FBPost(int id, String nome, LocalDateTime data, String conteudo,
                  int likes, List<String> comentarios){
        this.setId(id);
        this.setNome(nome);
        this.setData(data);
        this.setConteudo(conteudo);
        this.setLikes(likes);
        this.setComentarios(comentarios);
    }

    public FBPost(FBPost post){
        this.setId(post.getId());
        this.setNome(post.getNome());
        this.setData(post.getData());
        this.setConteudo(post.getConteudo());
        this.setLikes(post.getLikes());
        this.setComentarios(post.getComentarios());
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public void setLikes (int likes){
        this.likes = likes;
    }

    public void setComentarios(List<String> comentarios){
        this.comentarios = new ArrayList<String>();
        this.comentarios.addAll(comentarios);
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public LocalDateTime getData(){
        return this.data;
    }

    public String getConteudo(){
        return this.conteudo;
    }

    public int getLikes(){
        return this.likes;
    }

    public List<String> getComentarios(){
        List<String> aux = new ArrayList<>();
        for (String s : this.comentarios)
            aux.add(s);
        return aux;
    }

    public int compComment(FBPost other){
        int a = other.getComentarios().size();
        int b = this.getComentarios().size();
        if  (a > b) return -1;
        else if (a < b) return -1;
        return 0;
    }

    public FBPost clone(){
        return new FBPost(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\nNome: ").append(this.nome);
        sb.append("\nData: ").append(this.data);
        sb.append("\nConteudo: ").append(this.conteudo);
        sb.append("\nLikes: ").append(this.likes);
        sb.append("\nComentários: ").append(this.comentarios);

        return sb.toString();

    }

    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || o.getClass() != this.getClass()) return false;
        FBPost post = (FBPost) o;
        return this.nome.equals(post.getNome()) &&
                this.id == post.getId() &&
                this.data.equals(post.getData()) &&
                this.conteudo.equals(post.getConteudo()) &&
                this.likes == post.getLikes() &&
                this.comentarios.equals(post.getComentarios());
    }



}

