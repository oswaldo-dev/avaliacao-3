package br.com.compasso.avalicao.controller;

import br.com.compasso.avalicao.dto.StateDto;
import br.com.compasso.avalicao.dto.StateForm;
import br.com.compasso.avalicao.service.StateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/states")
public class StatesController {

    private static final Logger log = LoggerFactory.getLogger(StatesController.class);
    @Autowired
    private StateService service;

    @PostMapping
    @Transactional
    public ResponseEntity<StateDto> registrationState(@RequestBody @Valid StateForm stateForm, UriComponentsBuilder componentsBuilder) {
        return service.addNewState(stateForm, componentsBuilder);
    }

    @GetMapping
    public Page<StateDto> listAll(String region, Pageable sort) {
        return service.listStates(region, sort);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDto> getState(@PathVariable Long id) {
        return service.listStateById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEntity<StateDto>> update (@PathVariable Long id, @RequestBody @Valid StateForm stateForm) {
        ResponseEntity<StateDto> stateDto = service.updateState(id, stateForm);
        return ResponseEntity.ok(stateDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.deleteState(id);
    }
}
