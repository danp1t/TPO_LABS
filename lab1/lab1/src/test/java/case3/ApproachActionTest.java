package case3;

import com.danp1t.case3.action.ApproachAction;
import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.entity.Person;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.LightLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApproachActionTest {
    @DisplayName("Тест: влияние освещённости на уровень стресса при приближении")
    @Test
    void stressLevelApproachActionDependsOnLightLevelTest() {
        Computer computer = new Computer("Терминатор", false);
        Person person = new Person("Иван", 18, false);
        Computer computer2 = new Computer("Терминатор 2", false);
        Person person2 = new Person("Петр", 18, false);
        Computer computer3 = new Computer("Терминатор 3", false);
        Person person3 = new Person("Виктор", 18,false);

        ApproachAction inDark = new ApproachAction(
                ActionTempoType.FAST, computer, person, LightLevel.DARK
        );

        ApproachAction inDim = new ApproachAction(
                ActionTempoType.FAST, computer2, person2, LightLevel.DIM
        );

        ApproachAction inBright = new ApproachAction(
                ActionTempoType.FAST, computer3, person3, LightLevel.BRIGHT
        );

        inDark.execute();
        inDim.execute();
        inBright.execute();

        assertTrue(person.getStressLevel() > person2.getStressLevel());
        assertTrue(person2.getStressLevel() > person3.getStressLevel());
        assertTrue((computer.getStressLevel() == computer2.getStressLevel()) && (computer2.getStressLevel() == computer3.getStressLevel()));

    }

    @DisplayName("Тест: влияние скорости на уровень стресса при приближении")
    @Test
    void stressLevelApproachActionDependsOnSpeedTest() {
        Computer computer = new Computer("Терминатор", false);
        Person person = new Person("Иван", 18, false);
        Computer computer2 = new Computer("Терминатор 2", false);
        Person person2 = new Person("Петр", 18, false);
        Computer computer3 = new Computer("Терминатор 3", false);
        Person person3 = new Person("Виктор", 18,false);

        ApproachAction fast = new ApproachAction(
                ActionTempoType.FAST, computer, person, LightLevel.DARK
        );

        ApproachAction medium = new ApproachAction(
                ActionTempoType.MEDIUM, computer2, person2, LightLevel.DARK
        );

        ApproachAction slow = new ApproachAction(
                ActionTempoType.SLOW, computer3, person3, LightLevel.DARK
        );

        fast.execute();
        medium.execute();
        slow.execute();

        assertTrue(person.getStressLevel() > person2.getStressLevel());
        assertTrue(person2.getStressLevel() > person3.getStressLevel());
        assertTrue((computer.getStressLevel() == computer2.getStressLevel()) && (computer2.getStressLevel() == computer3.getStressLevel()));
    }

    @DisplayName("Тест: компьютеры не боятся приближения")
    @Test
    void stressLevelApproachActionDependsOnEntityTest() {
        Computer computer = new Computer("Терминатор", false);
        Person person = new Person("Иван", 18, false);
        Computer computer2 = new Computer("Терминатор 2", false);
        Person person2 = new Person("Петр", 18, false);
        Computer computer3 = new Computer("Терминатор 3", false);
        Person person3 = new Person("Виктор", 18,false);

        ApproachAction fastDark = new ApproachAction(
                ActionTempoType.FAST, person, computer, LightLevel.DARK
        );

        ApproachAction mediumDim = new ApproachAction(
                ActionTempoType.MEDIUM, person2, computer2, LightLevel.DIM
        );

        ApproachAction slowBright = new ApproachAction(
                ActionTempoType.SLOW, person3, computer3, LightLevel.BRIGHT
        );

        fastDark.execute();
        mediumDim.execute();
        slowBright.execute();

        assertEquals(0, computer.getStressLevel());
        assertEquals(0, computer2.getStressLevel());
        assertEquals(0, computer3.getStressLevel());
    }
}
