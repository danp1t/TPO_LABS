package case3;

import com.danp1t.case3.action.RepeatAction;
import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.entity.Person;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatActionTest {
    @DisplayName("Тест: повторение слов от компьютера страшнее чем от человека")
    @Test
    void stressLevelRepeatActionDependsOnEntityTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Person person2 = new Person("КСВ");
        Person person3 = new Person("Петр");

        RepeatAction computerSpeak = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                computer,
                person,
                "умри ",
                3
        );

        RepeatAction personSpeak = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                person2,
                person3,
                "своевременно... ",
                3
        );

        computerSpeak.execute();
        personSpeak.execute();

        assertTrue(person.getStressLevel() > person3.getStressLevel());
    }

    @DisplayName("Тест: чем больше повторов, тем страшнее")
    @Test
    void stressLevelRepeatActionDependsOnCountTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");

        RepeatAction times3 = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                computer,
                person,
                "умри ",
                3
        );

        RepeatAction times5 = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                computer2,
                person2,
                "своевременно... ",
                5
        );

        times3.execute();
        times5.execute();

        assertTrue(person.getStressLevel() < person2.getStressLevel());
    }

    @DisplayName("Тест: медленнее, тем страшнее")
    @Test
    void stressLevelRepeatActionDependsOnTempoTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Игорь");

        RepeatAction fast = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.FAST,
                computer,
                person,
                "умри ",
                3
        );

        RepeatAction medium = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.MEDIUM,
                computer2,
                person2,
                "умри ",
                3
        );

        RepeatAction slow = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                computer3,
                person3,
                "своевременно... ",
                3
        );

        fast.execute();
        medium.execute();
        slow.execute();

        assertTrue(person.getStressLevel() < person2.getStressLevel());
        assertTrue(person2.getStressLevel() < person3.getStressLevel());
    }

    @DisplayName("Тест: компьютеры не бояться повторов фраз")
    @Test
    void stressLevelRepeatActionTest() {
        Computer computer = new Computer("Терминатор");
        Person person = new Person("Иван");
        Computer computer2 = new Computer("Терминатор 2");
        Person person2 = new Person("Петр");
        Computer computer3 = new Computer("Терминатор 3");
        Person person3 = new Person("Игорь");

        RepeatAction fast = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.FAST,
                person,
                computer,
                "умри ",
                100
        );

        RepeatAction medium = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.MEDIUM,
                person2,
                computer2,
                "умри ",
                24
        );

        RepeatAction slow = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                person3,
                computer3,
                "своевременно... ",
                32
        );

        fast.execute();
        medium.execute();
        slow.execute();

        assertEquals(0, computer.getStressLevel());
        assertEquals(0, computer2.getStressLevel());
        assertEquals(0, computer3.getStressLevel());
    }
}
