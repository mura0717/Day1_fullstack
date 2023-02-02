package dat3.fullstack.day1.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import dat3.fullstack.entity.Player;
import dat3.fullstack.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    boolean dataIsInitalized = false;

    @BeforeEach
    public void setupPlayers() {
        if (!dataIsInitalized) {
            List<String> players = new ArrayList<>(Arrays.asList("aa", "bb", "cc"));
            List<Player> playerEnities = players.stream().map(p -> new Player(p)).toList();
            playerRepository.saveAll(playerEnities);
            dataIsInitalized = true;
        }
    }

    @Test
    public void testGetAll() {
        //Will this test pass, if it runs AFTER the next text
        List<Player> players = playerRepository.findAll();
        assertEquals(3, players.size());
    }

    @Test
    public void testAddPlayer() {
        Player player = playerRepository.save(new Player("dd"));
        //Q1: What's the difference between the player we add, and the player returned by the save method?
        //Q2: Write the test
        assertTrue(player.getId() > 0);
        long playerCount = playerRepository.count();
        assertEquals(4, playerCount);
    }

    @Test
    public void testFindPlayerByName() {
        //List<Player> players = playerRepository.findAll();
        Player p = playerRepository.findPlayerByName("dd");
        assertEquals("dd", p.getName());
        // Q1: Write this test if you can. If not implement the missing parts
        // Q2: Can You find player "dd" if this test runs after the previous test
    }
}
