package com.devmountain.gameApp.repositories;

import com.devmountain.gameApp.entities.Game;
import com.devmountain.gameApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findAllByUser(User user);
}

