package com.franca.bloggamerapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;

@Entity(name = "tb_comments")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id_comment")
    private Long idComment;

    private String body;
    private int likes;

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_created")
    private Date dateCreated;

    private Long idUser;

   private Long idTopic;

    @PrePersist
    protected void onCreate() {
        long currentTime = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(currentTime);
        dateCreated = sqlDate;
    }
}
