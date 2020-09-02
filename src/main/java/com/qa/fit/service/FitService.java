package com.qa.fit.service;

import com.qa.fit.domain.Fit;
import com.qa.fit.dto.FitDTO;
import com.qa.fit.exceptions.FitNotFoundException;
import com.qa.fit.repo.FitRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class FitService {
    private final FitRepository fitrepo;
    private final ModelMapper mapper;

    @Autowired
    public FitService(FitRepository fitrepo, ModelMapper mapper) {
        this.fitrepo = fitrepo;
        this.mapper = mapper;
    }
    private FitDTO mapTODTO(Fit fit){
        return this.mapper.map(fit, FitDTO.class);
    }

    public List<FitDTO> readAllFits() {
        return this.fitrepo.findAll().stream().map(this::mapTODTO).collect(Collectors.toList());
    }

    public FitDTO createFit (Fit fit){
        return this.mapTODTO(this.fitrepo.save(fit));
    }
    public FitDTO findFitById( Long id){
        return this.mapTODTO(this.fitrepo.findById(id).orElseThrow(FitNotFoundException::new));
    }
    public FitDTO updateFit(Long id, Fit fit){
        Fit update = this.fitrepo.findById(id).orElseThrow(FitNotFoundException::new);
        update.setTitle(fit.getTitle());
        update.setDescription(fit.getDescription());
        return this.mapTODTO(this.fitrepo.save(update));
    }
    public Boolean deleteFitById(Long id){
        if (!this.fitrepo.existsById(id)){
            throw new FitNotFoundException();
        }
        this.fitrepo.deleteById(id);
        return this.fitrepo.existsById(id);
    }
}


