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
            }
            else if (source instanceof Computer) {
                target.incrementStressLevel(150); // ААА, за мной гонится робот
            }

            if (tempo == ActionTempoType.FAST) {
                target.incrementStressLevel(250);
            }
            else if (tempo == ActionTempoType.MEDIUM) {
                target.incrementStressLevel(100);
            }
            else if (tempo == ActionTempoType.SLOW) {
                target.incrementStressLevel(50);
            }

            if (lightLevel == LightLevel.DARK) {
                target.incrementStressLevel(100);
            }
            else if (lightLevel == LightLevel.DIM) {
                target.incrementStressLevel(50);
            }
            else if (lightLevel == LightLevel.BRIGHT) {
                target.incrementStressLevel(10);
            }
        }
    }

}