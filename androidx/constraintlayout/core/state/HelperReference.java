package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/HelperReference.class */
public class HelperReference extends ConstraintReference implements Facade {
    protected final State ac;
    final State.Helper ad;
    protected ArrayList<Object> ae;
    private HelperWidget af;

    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.ae = new ArrayList<>();
        this.ac = state;
        this.ad = helper;
    }

    public HelperReference add(Object... objArr) {
        Collections.addAll(this.ae, objArr);
        return this;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }

    public HelperWidget getHelperWidget() {
        return this.af;
    }

    public State.Helper getType() {
        return this.ad;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.af = helperWidget;
    }
}
