package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<GameMinDTO> findAll() {

        var resultSet = gameRepository.findAll();
        List<GameMinDTO> dto = resultSet.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }
    
}
