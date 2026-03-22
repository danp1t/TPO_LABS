package com.danp1t.case3.action;

import com.danp1t.case3.entity.Entity;
import com.danp1t.case3.types.ActionScopeType;
import com.danp1t.case3.types.ActionTempoType;
import com.danp1t.case3.types.ActionToneType;

public abstract class Action {
    protected ActionScopeType scope;
    protected ActionTempoType tempo;
    protected ActionToneType tone;
    protected Entity source;
    protected Entity target;

    public Action(ActionScopeType scope, ActionTempoType tempo, ActionToneType tone, Entity source, Entity target) {
        this.scope = scope;
        this.tempo = tempo;
        this.tone = tone;
        this.source = source;
        this.target = target;
    }

    public ActionScopeType getScope() {
        return scope;
    }

    public ActionTempoType getTempo() {
        return tempo;
    }

    public ActionToneType getTone() {
        return tone;
    }

    public Entity getSource() {
        return source;
    }

    public Entity getTarget() {
        return target;
    }

    public abstract void execute();

}
