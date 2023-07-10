package com.devmountain.gameApp.controllers;

import com.devmountain.gameApp.dtos.GameDto;
import com.devmountain.gameApp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping("/")

    @GetMapping("/dashboard")
    public List<GameDto> getGamesByUser(@PathVariable Long userId) {
        return gameService.getAllNotesByUserId(userId);
    }

    @GetMapping("/form")


    @PostMapping("/form")
    public void addGame(@RequestBody GameDto gameDto, @PathVariable Long userId) {
        System.out.println(gameDto);
        gameService.addGame(gameDto, userId);
    }

    @DeleteMapping("/{gameId}")
    public void deleteGameById(@PathVariable Long gameId) {
        gameService.deleteGameById(gameId);
    }
}
