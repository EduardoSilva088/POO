package Youtube;

import java.time.LocalDate;
import java.util.*;

public class SistemaVideos {

    private Map<String, Video> videos;

    public SistemaVideos(){
        videos=new HashMap<>();
    }
    public SistemaVideos(Map<String,Video> youtube){
        setVideos(youtube);
    }
    public SistemaVideos(SistemaVideos youtube){
        setVideos(youtube.getVideos());
    }

    public Map<String, Video> getVideos() {
        Map<String,Video> res = new HashMap<>();
        this.videos.forEach((key,value) -> res.put(key,value.clone()));
        return res;
    }

    public void setVideos(Map<String, Video> videos) {
        videos.forEach((key,value) -> this.videos.put(key,value.clone()));
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaVideos that = (SistemaVideos) o;
        return Objects.equals(videos, that.videos);
    }

    public String toString() {
        return "SistemaVideos{" +
                "videos=" + videos +
                '}';
    }

    //ii)
    public void addVideo(Video v){
        this.videos.put(v.getCodigo(),v.clone());
    }

    //iii)
    public Video getVideo(String codVideo){
        return this.videos.get(codVideo);
    }

    //iv)
    public void removeVideo(String codVideo){
        this.videos.remove(codVideo);
    }

    //v)
    public void addLike(String codVideo){
        this.videos.get(codVideo).thumbsUp();
    }

    //vi)
    public String topLikes(){
        String res = new String();
        int max = 0;
        for(Video p : this.videos.values()){
            if(p.getLikes() > max){
                max = p.getLikes();
                res = p.getCodigo();
            }
        }
        return res;
    }

    //vii)
    public String topLikes(LocalDate dinicial, LocalDate dfinal){
        String res = new String();
        int max = 0;
        for(Video p : this.videos.values()){
            if(p.getLikes() > max && p.getData().isAfter(dinicial) && p.getData().isBefore(dfinal)){
                max = p.getLikes();
                res = p.getCodigo();
            }
        }
        return res;
    }
}
