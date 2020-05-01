package Youtube;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public class Video {

    private String nome;
    private byte[] conteudo;
    private LocalDate data;
    private String resolucao;
    private int likes;
    private int dislikes;
    private List<String> comentarios;
    private String codigo;

    public Video() {
        comentarios  = new ArrayList<>();
        nome     = new String();
        conteudo = null;
        data     =LocalDate.now();
        resolucao=new String();
        likes=0;
        dislikes = 0;
        codigo = new String();
    }

    public Video(String nome, byte[] conteudo, LocalDate data, String resolucao, int likes, int dislikes, List<String> comentarios, String Codigo) {
        this.nome = nome;
        this.conteudo = conteudo;
        this.data = data;
        this.resolucao = resolucao;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comentarios = comentarios;
        this.codigo = codigo;
    }

    public Video(Video video){
        setNome(video.getNome());
        setConteudo(video.getConteudo());
        setData(video.getData());
        setResolucao(video.getResolucao());
        setLikes(video.getLikes());
        setDislikes(video.getDislikes());
        setComentarios(video.getComentarios());
        setCodigo(video.getCodigo());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public List<String> getComentarios() {
        return new ArrayList<>(this.comentarios);
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = new ArrayList<>();
        this.comentarios.addAll(comentarios);
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    //i)
    public void insereComentario(String comentario){
        this.comentarios.add(comentario);
    }

    //ii)
    public long qtsDiasDepois(){
        return DAYS.between(data,LocalDate.now());
    }

    //iii)
    public void thumbsUp(){
        setLikes(getLikes()+1);
    }

    //iv)
    public String processa(){
        return conteudo.toString();
    }

    public String toString() {
        return "Video{" +
                "nome='" + nome + '\'' +
                ", conteudo=" + Arrays.toString(conteudo) +
                ", data=" + data +
                ", resolucao='" + resolucao + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", comentarios=" + comentarios +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public Video clone(){
        return new Video(this);
    }



}
