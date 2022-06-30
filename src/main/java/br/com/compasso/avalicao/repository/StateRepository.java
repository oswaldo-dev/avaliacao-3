package br.com.compasso.avalicao.repository;

import br.com.compasso.avalicao.model.Region;
import br.com.compasso.avalicao.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {


    Page<State> findByRegion(Region region, Pageable sort);


}
