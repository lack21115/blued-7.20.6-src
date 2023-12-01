package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/HorizontalChainReference.class */
public class HorizontalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/HorizontalChainReference$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2062a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[State.Chain.values().length];
            f2062a = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2062a[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2062a[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ConstraintReference constraintReference;
        Iterator<Object> it = this.ae.iterator();
        while (it.hasNext()) {
            this.ac.constraints(it.next()).clearHorizontal();
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
                if (this.N != null) {
                    constraints.startToStart(this.N).margin(this.l);
                } else if (this.O != null) {
                    constraints.startToEnd(this.O).margin(this.l);
                } else if (this.J != null) {
                    constraints.startToStart(this.J).margin(this.j);
                } else if (this.K != null) {
                    constraints.startToEnd(this.K).margin(this.j);
                } else {
                    constraints.startToStart(State.PARENT);
                }
                constraintReference4 = constraints;
            }
            if (constraintReference2 != null) {
                constraintReference2.endToStart(constraints.getKey());
                constraints.startToEnd(constraintReference2.getKey());
            }
            constraintReference2 = constraints;
            constraintReference3 = constraintReference4;
        }
        if (constraintReference2 != null) {
            if (this.P != null) {
                constraintReference2.endToStart(this.P).margin(this.m);
            } else if (this.Q != null) {
                constraintReference2.endToEnd(this.Q).margin(this.m);
            } else if (this.L != null) {
                constraintReference2.endToStart(this.L).margin(this.k);
            } else if (this.M != null) {
                constraintReference2.endToEnd(this.M).margin(this.k);
            } else {
                constraintReference2.endToEnd(State.PARENT);
            }
        }
        if (constraintReference == null) {
            return;
        }
        if (this.af != 0.5f) {
            constraintReference.horizontalBias(this.af);
        }
        int i = AnonymousClass1.f2062a[this.ag.ordinal()];
        if (i == 1) {
            constraintReference.setHorizontalChainStyle(0);
        } else if (i == 2) {
            constraintReference.setHorizontalChainStyle(1);
        } else if (i != 3) {
        } else {
            constraintReference.setHorizontalChainStyle(2);
        }
    }
}
