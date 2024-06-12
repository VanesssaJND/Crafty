package com.example.crafty.services.ServiceImpl;

import com.example.crafty.entities.yarn.Yarn;
import com.example.crafty.exceptions.ResourceNotFoundException;
import com.example.crafty.repositories.YarnRepository;
import com.example.crafty.services.Service.YarnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class YarnServiceImpl implements YarnService {

    private final YarnRepository yarnRepository;

    public List<Yarn> getAllYarns(){
        return yarnRepository.findAll();
    }

    public Yarn findById(UUID id) throws ResourceNotFoundException {
        Optional<Yarn> answer = yarnRepository.findById(id);

        if(answer.isPresent()) {
            return answer.get();
        }
        throw new ResourceNotFoundException("Yarn with id " + id + " doesn't exist");
    }

    @Override
    public Yarn AddNewYarn(Yarn yarn) {
        return null;
    }


}
