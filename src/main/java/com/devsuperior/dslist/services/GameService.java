package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {

        // var gameSet = gameRepository.findById(id).get();
        // GameDTO dto = new GameDTO(gameSet);
        // return new GameDTO(gameSet);
        return new GameDTO(gameRepository.findById(id).get());

    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {

        var resultSet = gameRepository.findAll();
        // List<GameMinDTO> dto = resultSet.stream().map(x -> new GameMinDTO(x)).toList();
        // return resultSet.stream().map(x -> new GameMinDTO(x)).toList();
        return resultSet.stream().map(GameMinDTO::new).toList();

    }

    //Consulta os games de uma determinada lista...
    //Utiliza um recurso do java chamado PROJECTION
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {

        List<GameMinProjection> resultSet = gameRepository.searchByList(listId);
        // List<GameMinDTO> dto = resultSet.stream().map(x -> new GameMinDTO(x)).toList();
        // return resultSet.stream().map(x -> new GameMinDTO(x)).toList();
        return resultSet.stream().map(GameMinDTO::new).toList();

    }
 }
