package br.com.compasso.avalicao.dto;

import br.com.compasso.avalicao.model.State;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class StateDto {

    private Long id;
    private String name;
    private String region;
    private Long population;
    private String capital;
    private BigDecimal area;

    public StateDto() {
    }

    public StateDto(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.region = state.getRegion();
        this.population = state.getPopulation();
        this.capital = state.getCapital();
        this.area = state.getArea();
    }

    public StateDto(String name, String region, Long population, String capital, BigDecimal area) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.area = area;
    }

    public static Page<StateDto> toConvertList(Page<State> states) {
        return states.map(StateDto::new);
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public Long getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public BigDecimal getArea() {
        return area;
    }
}
