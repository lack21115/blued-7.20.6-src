package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/AlignVerticallyReference.class */
public class AlignVerticallyReference extends HelperReference {
    private float af;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.af = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> it = this.ae.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = this.ac.constraints(it.next());
            constraints.clearVertical();
            if (this.R != null) {
                constraints.topToTop(this.R);
            } else if (this.S != null) {
                constraints.topToBottom(this.S);
            } else {
                constraints.topToTop(State.PARENT);
            }
            if (this.T != null) {
                constraints.bottomToTop(this.T);
            } else if (this.U != null) {
                constraints.bottomToBottom(this.U);
            } else {
                constraints.bottomToBottom(State.PARENT);
            }
            float f = this.af;
            if (f != 0.5f) {
                constraints.verticalBias(f);
            }
        }
    }
}
