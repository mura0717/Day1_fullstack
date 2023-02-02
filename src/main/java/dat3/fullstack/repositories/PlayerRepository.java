package dat3.fullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import dat3.fullstack.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Player findPlayerByName(String name);
}

