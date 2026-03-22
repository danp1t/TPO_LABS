package case3;

import com.danp1t.case3.action.ApproachAction;
import com.danp1t.case3.action.CountAction;
import com.danp1t.case3.action.RepeatAction;
import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.entity.Person;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.LightLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DomainModelTest {

    @DisplayName("Тест: подсчет вслух равносилен медленному приближению в темноте к человеку, повторяя: \"Умри... умри... умри...\"")
    @Test
    void equivalentActionTest() {
        Computer computer = new Computer("Bravo");
        Person person = new Person("Форд");

        Person person1 = new Person("Маньяк");
        Person person2 = new Person("Иван");

        CountAction countAction = new CountAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.SLOW,
                person,
                computer,
                64
        );

        ApproachAction approachAction = new ApproachAction(
                ActionTempoType.SLOW, person1, person2, LightLevel.DARK
        );

        RepeatAction repeatAction = new RepeatAction(
                ActionScopeType.EXTERNAL,
                ActionTempoType.MEDIUM,
                person1,
                person2,
                "умри ",
                3
        );

        countAction.execute();
        approachAction.execute();
        repeatAction.execute();

        assertEquals(computer.getStressLevel(), person2.getStressLevel());
    }

}
