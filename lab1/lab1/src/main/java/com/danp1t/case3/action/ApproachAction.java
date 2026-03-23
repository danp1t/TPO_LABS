package com.danp1t.case3.action;

import com.danp1t.case3.entity.Entity;
import com.danp1t.case3.entity.Person;
import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.LightLevel;

public class ApproachAction extends Action {
    private final LightLevel lightLevel;

    public ApproachAction(ActionTempoType tempo,
                          Entity source, Entity target,
                          LightLevel lightLevel) {
        super(ActionScopeType.EXTERNAL, tempo, source, target);
        this.lightLevel = lightLevel;
    }

    @Override
    public void execute() {
        System.out.println(source.getName() + " " + tempo.getDisplayName() + " приближался " + lightLevel.getDisplayName() + " к " + target.getName());

        if (target instanceof Person) {
            if (source instanceof Person) {
                target.incrementStressLevel(50);
                if (((Person) source).getIsDrunk()) {
                    target.incrementStressLevel(120);
                }
                if (((Person) target).getIsDrunk()) {
                    target.decrementStressLevel(100);
                }

                if (((Person) target).getAge() < 13 && ((Person) target).getAge() > 5) {
                    target.incrementStressLevel(50); // Я СЛИШКОМ МОЛОД, чтобы умирать
                } else if (((Person) target).getAge() > 80) {
                    target.decrementStressLevel(600); // Наконец-то помру

                }
            }
            else {
                target.incrementStressLevel(150); // ААА, за мной гонится робот
                if (((Computer) source).getIsKillerRobot()) {
                    target.incrementStressLevel(500);
                }
            }

            if (tempo == ActionTempoType.FAST) {
                target.incrementStressLevel(250);
            }
            else if (tempo == ActionTempoType.MEDIUM) {
                target.incrementStressLevel(100);
            }
            else {
                target.incrementStressLevel(50);
            }

            if (lightLevel == LightLevel.DARK) {
                target.incrementStressLevel(100);
            }
            else if (lightLevel == LightLevel.DIM) {
                target.incrementStressLevel(50);
            }
            else {
                target.incrementStressLevel(10);
            }
        }
    }

}