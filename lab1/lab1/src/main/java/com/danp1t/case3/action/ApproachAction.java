package com.danp1t.case3.action;

import com.danp1t.case3.entity.Entity;
import com.danp1t.case3.entity.People;
import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.ActionToneType;
import com.danp1t.case3.types.LightLevel;

public class ApproachAction extends Action {
    private final LightLevel lightLevel;

    public ApproachAction(ActionScopeType scope, ActionTempoType tempo, ActionToneType tone,
                          Entity source, Entity target,
                          LightLevel lightLevel) {
        super(scope, tempo, tone, source, target);
        this.lightLevel = lightLevel;
    }

    public LightLevel getLightLevel() {
        return lightLevel;
    }

    @Override
    public void execute() {
        System.out.println(source.getName() + " " + tempo.getDisplayName() + " приближался " + lightLevel + " к" + target.getName());

        if (target instanceof People) {
            if (source instanceof People) {
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