package com.danp1t.case3.action;

import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.entity.Entity;
import com.danp1t.case3.entity.People;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.ActionToneType;

public class CountAction extends Action {
    private final int count;

    public CountAction(ActionScopeType scope, ActionTempoType tempo, ActionToneType tone,
                       Entity source, Entity target, int count, String text) {
        super(scope, tempo, tone, source, target);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void execute() {
        System.out.println(source.getName() + " " + tone.getDisplayName() + " и " + tempo.getDisplayName() + " считал " + scope.getDisplayName() + ":") ;
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }

        if (source instanceof People && target instanceof Computer) {
            if (scope == ActionScopeType.EXTERNAL) {
                target.incrementStressLevel(20 + count);
                if (tempo == ActionTempoType.SLOW) {
                    target.incrementStressLevel(10 + (count * 3));
                }
                else if (tempo == ActionTempoType.MEDIUM) {
                    target.incrementStressLevel(5 + count);
                }

                if (tone == ActionToneType.AGGRESSIVE) {
                    target.incrementStressLevel(20 + (count * 5));
                }
                else if (tone == ActionToneType.BENEVOLENT) {
                    target.decrementStressLevel(10 + (count * 3));
                }
            }
        }
    }
}