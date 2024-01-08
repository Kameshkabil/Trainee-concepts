package com.example.dtoslearning.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "movie")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Movie")
    private String movieName;
    @Column(name = "Director")
    private String director;
    @Column(name = "Year_Of_Movie")
    private String year;
    @Column(name = "Description")
    private String description;
}
