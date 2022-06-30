package br.com.compasso.avalicao.service;

import br.com.compasso.avalicao.dto.StateDto;
import br.com.compasso.avalicao.dto.StateForm;
import br.com.compasso.avalicao.model.Region;
import br.com.compasso.avalicao.model.State;
import br.com.compasso.avalicao.repository.StateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    private static final Logger log = LoggerFactory.getLogger(StateService.class);
    @Autowired
    private StateRepository repository;

    public ResponseEntity<StateDto> addNewState(StateForm stateForm, UriComponentsBuilder componentsBuilder) {
        log.info("addNewState() - INICIO - salvando o estado {}", stateForm.getName());
        State state = stateForm.toConvert();
        repository.save(state);
        URI uri = componentsBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
        log.info("addNewState() - FIM - estado salvo com o id {}", state.getId());
        return ResponseEntity.created(uri).body(new StateDto(state));
    }

    public Page<StateDto> listStates(@RequestParam(required = false) Region region,
                                     @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable sort) {
        log.info("listStates() - INICIO - listando todos os estados.");
        if (region == null) {
            Page<State> states = repository.findAll(sort);
            log.info("listStates() - FIM - devolvendo todos os estados.");
            return StateDto.toConvertList(states);
        } else {
            Page<State> states = repository.findByRegion(region, sort);
            return StateDto.toConvertList(states);
        }
    }

    public ResponseEntity<StateDto> listStateById(Long id) {
        log.info("listStateById(Long id) - INICIO - pegando estado com id {}", id);
        Optional<State> state = repository.findById(id);
        if (state.isPresent()) {
            log.info("listStateById(Long id) - FIM - devolvendo estado com id {}", id);
            return ResponseEntity.ok(new StateDto(state.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<StateDto> updateState(Long id, StateForm stateForm) {
        log.info("updateState(Long id) - INICIO - atualizando estado com id {}", id);
        Optional<State> optional = repository.findById(id);
        if(optional.isPresent()) {
            State state = stateForm.update(id, repository);
            return ResponseEntity.ok(new StateDto(state));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deleteState(Long id) {
        Optional<State> optional = repository.findById(id);
        if(optional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
