package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/AlignHorizontallyReference.class */
public class AlignHorizontallyReference extends HelperReference {
    private float af;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.af = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> it = this.ae.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.ac.constraints(it.next());
            constraints.clearHorizontal();
            if (this.N != null) {
                constraints.startToStart(this.N);
            } else if (this.O != null) {
                constraints.startToEnd(this.O);
            } else {
                constraints.startToStart(State.PARENT);
            }
            if (this.P != null) {
                constraints.endToStart(this.P);
            } else if (this.Q != null) {
                constraints.endToEnd(this.Q);
            } else {
                constraints.endToEnd(State.PARENT);
            }
            float f = this.af;
            if (f != 0.5f) {
                constraints.horizontalBias(f);
            }
        }
    }
}
