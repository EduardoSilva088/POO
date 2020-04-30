package FBFeed;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FBFeed {
    private List<FBPost> posts;

    public FBFeed() {
        this.posts = new ArrayList<>();
    }

    public FBFeed(List<FBPost> posts) {
        this.setPosts(posts);
    }

    public FBFeed(FBFeed feed) {
        this.setPosts(feed.getPosts());
    }

    public void setPosts(List<FBPost> posts) {
        this.posts = new ArrayList<FBPost>();
        for (FBPost p : posts)
            this.posts.add(p.clone());
    }

    public List<FBPost> getPosts() {
        List<FBPost> aux = new ArrayList<>();
        for (FBPost p : this.posts)
            aux.add(p.clone());
        return aux;
    }
    //Alinea i)
    public int nrPosts(String user){
        return (int) this.posts.stream()
                               .filter(p->p.getNome().equals(user))
                               .count();
    }

    //Alinea ii)
    public List<FBPost> postsOf(String user){
        return this.posts.stream()
                         .filter(p->p.getNome().equals(user))
                         .collect(Collectors.toList());
    }

    //Alinea iii)
    public List<FBPost> postsOf (String user, LocalDateTime inicio, LocalDateTime fim){
        return this.posts.stream()
                         .filter(p->p.getNome().equals(user) && p.getData().isAfter(inicio) && p.getData().isBefore(fim))
                         .collect(Collectors.toList());
    }

    //Alinea iv)
    public FBPost getPost(int id){
        FBPost res = new FBPost();
        for (FBPost p : this.posts){
            if(p.getId() == id) res = p;
        }
        return res;
    }

    //Alinea v)
    public void comment(FBPost post, String comentario){
        List<String> comentarios = post.getComentarios();
        comentarios.add(comentario);
        post.setComentarios(comentarios);
    }

    //Alinea vi)
    public void comment(int postid, String comentario){
        List <String> comentarios = getPost(postid).getComentarios();
        comentarios.add(comentario);
        getPost(postid).setComentarios(comentarios);
    }

    //Alinea vii)
    public void like(FBPost post){
        int likes = post.getLikes();
        likes += 1;
        post.setLikes(likes);
    }

    //Alinea viii)
    public void like(int postid){
        like(getPost(postid));
    }

    //Alinea ix)
    public List<Integer> top5Comments(){
        return this.posts.stream()
                         .limit(5)
                         .map(x->x.getId())
                         .sorted(new Comparator<Integer>() {
                             @Override
                             public int compare(Integer o1, Integer o2) {
                                 int comp1 = getPost(o1).getComentarios().size();
                                 int comp2 = getPost(o2).getComentarios().size();
                                 if (comp1 == comp2) return 0;
                                 if (comp1 > comp2) return -1;
                                 else return 1;
                             }
                         })
                         .collect(Collectors.toList());
    }
}

