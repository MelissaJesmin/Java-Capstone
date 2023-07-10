package com.devmountain.gameApp.services;

import com.devmountain.gameApp.dtos.GameDto;

import com.devmountain.gameApp.entities.Game;

import com.devmountain.gameApp.entities.User;
import com.devmountain.gameApp.repositories.GameRepository;
import com.devmountain.gameApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameServiceImpl implements GameService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;

    @Override
    @Transactional
    public void addGame(GameDto gameDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Game game = new Game(gameDto);
        userOptional.ifPresent(game::setUser);
        gameRepository.saveAndFlush(game);
    }

    @Override
    @Transactional
    public void deleteGameById(Long gameId) {
        Optional<Game> gameOptional = gameRepository.findById(gameId);
        gameOptional.ifPresent(note -> gameRepository.delete(game));
    }


    @Override
    public List<GameDto> getAllGamesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Game> gameList = gameRepository.findAllByUser(userOptional.get());
            return gameList.stream().map(note -> new gameDto(game)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
