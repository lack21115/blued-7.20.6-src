package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/VerticalChainReference.class */
public class VerticalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/VerticalChainReference$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2111a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[State.Chain.values().length];
            f2111a = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2111a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2111a[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ConstraintReference constraintReference;
        Iterator<Object> it = this.ae.iterator();
        while (it.hasNext()) {
            this.ac.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it2 = this.ae.iterator();
        ConstraintReference constraintReference2 = null;
        ConstraintReference constraintReference3 = null;
        while (true) {
            constraintReference = constraintReference3;
            if (!it2.hasNext()) {
                break;
            }
            ConstraintReference constraints = this.ac.constraints(it2.next());
            ConstraintReference constraintReference4 = constraintReference;
            if (constraintReference == null) {
                if (this.R != null) {
                    constraints.topToTop(this.R);
                } else if (this.S != null) {
                    constraints.topToBottom(this.S);
                } else {
                    constraints.topToTop(State.PARENT);
                }
                constraintReference4 = constraints;
            }
            if (constraintReference2 != null) {
                constraintReference2.bottomToTop(constraints.getKey());
                constraints.topToBottom(constraintReference2.getKey());
            }
            constraintReference2 = constraints;
            constraintReference3 = constraintReference4;
        }
        if (constraintReference2 != null) {
            if (this.T != null) {
                constraintReference2.bottomToTop(this.T);
            } else if (this.U != null) {
                constraintReference2.bottomToBottom(this.U);
            } else {
                constraintReference2.bottomToBottom(State.PARENT);
            }
        }
        if (constraintReference == null) {
            return;
        }
        if (this.af != 0.5f) {
            constraintReference.verticalBias(this.af);
        }
        int i = AnonymousClass1.f2111a[this.ag.ordinal()];
        if (i == 1) {
            constraintReference.setVerticalChainStyle(0);
        } else if (i == 2) {
            constraintReference.setVerticalChainStyle(1);
        } else if (i != 3) {
        } else {
            constraintReference.setVerticalChainStyle(2);
        }
    }
}
