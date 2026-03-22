package com.danp1t.case3.action;

import com.danp1t.case3.entity.Computer;
import com.danp1t.case3.entity.Entity;
import com.danp1t.case3.entity.Person;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.ActionToneType;

public class RepeatAction extends Action {
    private final String text;
    private final int count;

    public RepeatAction(ActionScopeType scope, ActionTempoType tempo, ActionToneType tone,
                        Entity source, Entity target, String text, int count) {
        super(scope, tempo, tone, source, target);
        this.text = text;
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void execute() {
        System.out.println(source.getName() + " " + tone.getDisplayName() + " и " + tempo.getDisplayName() + " повторял " + scope.getDisplayName() + ":");
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }

        if (target instanceof Person) {
            if (scope == ActionScopeType.EXTERNAL) {
                target.incrementStressLevel(20 + count);

                if (source instanceof Computer) { // ААА, ТЕРМИНАТОРЫ НАСТУПАЮТ!!! СПАСИТЕ, ПОМОГИТЕ
                    target.incrementStressLevel(100);
                }
                else if (source instanceof Person) {
                    target.incrementStressLevel(50);
                }

                if (tempo == ActionTempoType.SLOW) {
                    target.incrementStressLevel(10 + (count * 3));
                }
                else if (tempo == ActionTempoType.MEDIUM) {
                    target.incrementStressLevel(5 + count);
                }
                else if (tempo == ActionTempoType.FAST) {
                    target.incrementStressLevel(5);
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