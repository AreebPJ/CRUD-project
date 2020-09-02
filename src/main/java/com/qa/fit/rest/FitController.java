package com.qa.fit.rest;

import com.qa.fit.domain.Fit;
import com.qa.fit.dto.FitDTO;
import com.qa.fit.service.FitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class FitController {

    private final FitService  fitService;

    @Autowired
    public FitController (FitService fitService){
        this.fitService = fitService;
    }
    @GetMapping("/")
    public ResponseEntity<List<FitDTO>> getAllFits(){
        return ResponseEntity.ok(this.fitService.readAllFits());
    }

    @PostMapping("/createFit")
    public ResponseEntity<FitDTO> createFit(@RequestBody Fit fit){
        return new ResponseEntity<FitDTO>(this.fitService.createFit(fit), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFit(@PathVariable Long id){
        return this.fitService.deleteFitById(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }
    @GetMapping("/getFitById/{id}")
    public ResponseEntity<FitDTO> getFitById(@PathVariable Long id){
        return ResponseEntity.ok(this.fitService.findFitById(id));
    }
    @PutMapping("/updateFit{id}")
    public ResponseEntity<FitDTO> updateFit(@PathVariable Long id, @RequestBody Fit fit){
        return ResponseEntity.ok(this.fitService.updateFit(id, fit));
    }



}
