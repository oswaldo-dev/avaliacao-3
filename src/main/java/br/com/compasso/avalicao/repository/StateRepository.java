package br.com.compasso.avalicao.repository;

import br.com.compasso.avalicao.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {


    Page<State> findByRegion(String region, Pageable sort);


}
