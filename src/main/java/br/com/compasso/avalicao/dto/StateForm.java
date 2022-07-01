package br.com.compasso.avalicao.dto;

import br.com.compasso.avalicao.model.Region;
import br.com.compasso.avalicao.model.State;
import br.com.compasso.avalicao.repository.StateRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class StateForm {
    @NotBlank
    private String name;
    @NotBlank
    private String region;
    @NotNull
    private Long population;
    @NotBlank
    private String capital;
    @NotNull
    private BigDecimal area;

    public StateForm() {
    }
    public StateForm(State state) {
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public State toConvert() {
        String region = String.valueOf(Region.valueOf(this.region.toUpperCase()));
        return new State(name, region, population, capital, area);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
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

    public State update(Long id, StateRepository repository) {
        State state = repository.getReferenceById(id);
        state.setName(this.name);
        state.setRegion(String.valueOf(Region.valueOf(this.region.toUpperCase())));
        state.setPopulation(this.population);
        state.setCapital(this.capital);
        state.setArea(this.area);
        return state;
    }
}