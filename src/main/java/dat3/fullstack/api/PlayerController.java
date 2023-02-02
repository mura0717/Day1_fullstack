package dat3.fullstack.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dat3.fullstack.entity.Player;
import dat3.fullstack.repositories.PlayerRepository;

@RestController
@RequestMapping("/api/players")
public class PlayerController {


    PlayerRepository playerRepository;


    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @GetMapping
    Iterable<Player> getPlayers() {
        var players =  playerRepository.findAll();
        return players;
    }
}
