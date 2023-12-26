package com.example.dtoslearning.model;


import jakarta.persistence.*;

@Entity
@Table(name = "movie")
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
