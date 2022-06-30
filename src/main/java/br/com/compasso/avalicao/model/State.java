package br.com.compasso.avalicao.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Region region;
    private Long population;
    private String capital;
    private BigDecimal area;

    public State() {
    }

    public State(Long id, String name, Region region, Long population, String capital, BigDecimal area) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.area = area;
    }

    public State(String name, Region region, Long population, String capital, BigDecimal area) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
}
