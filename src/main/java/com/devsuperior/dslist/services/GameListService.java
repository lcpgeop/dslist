package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {

        // var listSet = gameListRepository.findById(id).get();
        // ListDTO dto = new ListDTO(listSet);
        // return new ListDTO(listSet);
        return new GameListDTO(gameListRepository.findById(id).get());

    }
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {

        // var resultSet = gameListRepository.findAll();
        return gameListRepository.findAll()
            .stream().map(GameListDTO::new).toList();
        // List<ListDTO> dto = resultSet.stream().map(x -> new ListDTO(x)).toList();
        // return resultSet.stream().map(x -> new ListDTO(x)).toList();
        // return resultSet.stream().map(GameListDTO::new).toList();

    }
 }
