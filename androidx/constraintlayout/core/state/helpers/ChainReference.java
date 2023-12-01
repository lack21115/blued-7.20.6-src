package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/ChainReference.class */
public class ChainReference extends HelperReference {
    protected float af;
    protected State.Chain ag;

    public ChainReference(State state, State.Helper helper) {
        super(state, helper);
        this.af = 0.5f;
        this.ag = State.Chain.SPREAD;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ChainReference bias(float f) {
        this.af = f;
        return this;
    }

    public float getBias() {
        return this.af;
    }

    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public ChainReference style(State.Chain chain) {
        this.ag = chain;
        return this;
    }
}
