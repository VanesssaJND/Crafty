package com.example.crafty.services;

import com.example.crafty.entities.yarn.Yarn;
import com.example.crafty.exceptions.ResourceNotFoundException;
import com.example.crafty.repositories.YarnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class YarnService {

    private final YarnRepository yarnRepository;

    public List<Yarn> getAllYarns(){
        return yarnRepository.findAll();
    }

    public Yarn findById(Long id) throws ResourceNotFoundException {
        Optional<Yarn> answer = yarnRepository.findById(id);

        if(answer.isPresent()) {
            return answer.get();
        }
        throw new ResourceNotFoundException("Yarn with id " + id + " doesn't exist");
    }


}
