package com.danp1t.case3.action;

import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.entity.Entity;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;

public class CountAction extends Action {
    private final int count;

    public CountAction(ActionScopeType scope, ActionTempoType tempo,
                       Entity source, Entity target, int count) {
        super(scope, tempo, source, target);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void execute() {
        System.out.println(source.getName() + " " + tempo.getDisplayName() + " считал " + scope.getDisplayName() + ":") ;
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }

        if (target instanceof Computer) {
            if (scope == ActionScopeType.EXTERNAL) {
                target.incrementStressLevel(20 + count);
                if (tempo == ActionTempoType.SLOW) {
                    target.incrementStressLevel(10 + (count * 3));
                }
                else if (tempo == ActionTempoType.MEDIUM) {
                    target.incrementStressLevel(5 + count);
                }
            }
        }
    }
}