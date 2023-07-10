package com.devmountain.gameApp.services;

import com.devmountain.gameApp.dtos.GameDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameService {
    @Transactional
    void addGame(GameDto gameDto, Long userId);

    @Transactional
    void deleteGameById(Long gameId);

    List<GameDto> getAllGamesByUserId(Long userId);
}
