package com.example.dtoslearning.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Aliens")
public class Aliens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long alienId;
    private String alienName;
    private String alienColor;
    private int alienAge;

    public Aliens(long alienId, String alienName, String alienColor, int alienAge) {
        this.alienId = alienId;
        this.alienName = alienName;
        this.alienColor = alienColor;
        this.alienAge = alienAge;
    }

    public long getAlienId() {
        return alienId;
    }

    public void setAlienId(long alienId) {
        this.alienId = alienId;
    }

    public String getAlienName() {
        return alienName;
    }

    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    public String getAlienColor() {
        return alienColor;
    }

    public void setAlienColor(String alienColor) {
        this.alienColor = alienColor;
    }

    public int getAlienAge() {
        return alienAge;
    }

    public void setAlienAge(int alienAge) {
        this.alienAge = alienAge;
    }

}
