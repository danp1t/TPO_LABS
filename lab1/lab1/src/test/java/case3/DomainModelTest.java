package case3;

import com.danp1t.case3.action.ApproachAction;
import com.danp1t.case3.action.CountAction;
import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.entity.Person;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.LightLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomainModelTest {

    @DisplayName("Тест: влияние освещённости на уровень стресса при приближении")
    @Test
    void stressLevelApproachActionDependsOnLightLevelTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Виктор");

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
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Виктор");

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
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Виктор");

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

    @DisplayName("Тест: чем больше считать, тем больше стресса испытает компьютер")
    @Test
    void stressLevelCountActionDependsOnCountTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Виктор");

        CountAction times50 = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                person,
                computer,
                50
        );

        CountAction times25 = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                person2,
                computer2,
                25
        );

        CountAction times5 = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                person3,
                computer3,
                5
        );

        times50.execute();
        times25.execute();
        times5.execute();

        assertTrue(computer.getStressLevel() > computer2.getStressLevel());
        assertTrue(computer2.getStressLevel() > computer3.getStressLevel());

    }

    @DisplayName("Тест: чем дольше считать, тем больше стресса испытает компьютер")
    @Test
    void stressLevelCountActionDependsOnTempoTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Виктор");

        CountAction fast = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.FAST,
                person,
                computer,
                10
        );

        CountAction medium = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.MEDIUM,
                person2,
                computer2,
                10
        );

        CountAction slow = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                person3,
                computer3,
                10
        );

        fast.execute();
        medium.execute();
        slow.execute();

        assertTrue(computer.getStressLevel() < computer2.getStressLevel());
        assertTrue(computer2.getStressLevel() < computer3.getStressLevel());

    }

    @DisplayName("Тест: люди не боятся подсчета чисел")
    @Test
    void stressLevelCountActionDependsOnEntityTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Виктор");

        CountAction times50Fast = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.FAST,
                computer,
                person,
                50
        );

        CountAction times25Medium = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.MEDIUM,
                computer2,
                person2,
                25
        );

        CountAction times5Slow = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                computer3,
                person3,
                5
        );

        times50Fast.execute();
        times25Medium.execute();
        times5Slow.execute();

        assertEquals(0, person.getStressLevel());
        assertEquals(0, person2.getStressLevel());
        assertEquals(0, person3.getStressLevel());

    }

    @DisplayName("Тест: подсчета про себя компьютеры не бояться")
    @Test
    void stressLevelCountActionDependsOnScopeTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Виктор");

        CountAction times50Fast = new CountAction(
                ActionScopeType.INTERNAL,
                ActionTempoType.FAST,
                person,
                computer,
                50
        );

        CountAction times25Medium = new CountAction(
                ActionScopeType.INTERNAL,
                ActionTempoType.MEDIUM,
                person2,
                computer2,
                25
        );

        CountAction times5Slow = new CountAction(
                ActionScopeType.INTERNAL,
                ActionTempoType.SLOW,
                person3,
                computer3,
                5
        );

        times50Fast.execute();
        times25Medium.execute();
        times5Slow.execute();

        assertEquals(0, computer.getStressLevel());
        assertEquals(0, computer2.getStressLevel());
        assertEquals(0, computer3.getStressLevel());

    }

}
