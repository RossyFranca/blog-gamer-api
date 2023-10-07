package com.franca.bloggamerapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(name = "tb_topics")
@Data
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topic")

    private Long idTopic;

    private String title;
    private String body;

    @JsonIgnore
    private int likes;

    @JsonIgnore
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_created")
    private Date dateCreated;

    @JoinColumn()
    private Long idUser;




    @PrePersist
    protected void onCreate() {
        long currentTime = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(currentTime);
        dateCreated = sqlDate;
    }

}
