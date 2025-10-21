import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MechGameTest {
    MechGame mechGame;

    @BeforeEach
    void setUp() {
        mechGame = new MechGame();
        Mech mech1 = new Mech("Cloudwing", "Bravo", 13568,
                new Stats(3,1,15,4),
                List.of("wind")
                ,List.of("poison"));
        Mech mech2 = new Mech("Howler", "Delta", 29845,
                new Stats(2,2,24,3),
                List.of("fire")
                ,List.of());
        Mech mech3 = new Mech("Frosthorn", "Omega", 67458,
                new Stats(3,2,58,1),
                List.of("ice")
                ,List.of("fire", "acid"));
        Mech mech4 = new Mech("Acid Crawler", "Bravo", 43564,
                new Stats(5,4,36,5),
                List.of("acid")
                ,List.of("poison"));

        Equipment equipment1 = new Equipment("Rusted Spear",
                EquipmentType.Offensive,
                13568,1,
                List.of(),
                List.of());
        Equipment equipment2 = new Equipment("Leather Armor",
                EquipmentType.Defensive,
                43564,1,
                List.of(),
                List.of("wind"));
        Equipment equipment3 = new Equipment("Assassins Blade",
                EquipmentType.Offensive,
                67458,3,
                List.of("poison"),
                List.of());
        Equipment equipment4 = new Equipment("Power Armor",
                EquipmentType.Defensive,
                29845,3,
                List.of("fire", "electric"),
                List.of());

        mechGame.addEquipment(equipment1);
        mechGame.addEquipment(equipment2);
        mechGame.addEquipment(equipment3);
        mechGame.addEquipment(equipment4);
        mechGame.addMech(mech1);
        mechGame.addMech(mech2);
        mechGame.addMech(mech3);
        mechGame.addMech(mech4);


    }

    @Test
    void fightTest() {
        MechGame testMechGame = MechGame.readGame("C:\\Users\\vladp\\IdeaProjects\\Practice exams\\EndTerm_2022\\resources\\mechs.txt");
        testMechGame.fight();
        testMechGame.fight();
        testMechGame.fight();
        testMechGame.fight();

        Player player = new Player();

        player.setOffensiveEquipment(
                new Equipment("Assassins Blade",
                        EquipmentType.Offensive,
                        67458,3,
                        List.of("poison"),
                        List.of())
        );

        player.setDefensiveEquipment(
                new Equipment("Leather Armor",
                        EquipmentType.Defensive,
                        43564,1,
                        List.of(),
                        List.of("wind"))
        );
        mechGame.setPlayer(player);
        mechGame.setFightsWon(4);
        assertEquals(testMechGame, mechGame);
    }


    @Test
    void readGame() {
        MechGame testMechGame = MechGame.readGame("C:\\Users\\vladp\\IdeaProjects\\Practice exams\\EndTerm_2022\\resources\\mechs.txt");
        assertEquals(mechGame, testMechGame);
    }

    @Test
    void logAndInputtest() {
        mechGame.log();
        assertEquals(MechGame.in(), mechGame);
    }
}