package com.Tarun.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

 

@Document(collection = "movies")
 public class Movie {

    public String getTitle() {
    return title;
} 
public void setTitle(String title) {
    this.title = title;
}

     public String getPosterUrl() {
    return posterUrl;
}

public void setPosterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
}

    @Id
    private String id;

    private String title;

    private String genre;

    private String language;

    private Integer releaseYear;

    private Integer duration;

    private Double rating;

    private String director;

    private List<String> cast;

    private String description;


    private String posterUrl;

    private String trailerUrl;

    

}

