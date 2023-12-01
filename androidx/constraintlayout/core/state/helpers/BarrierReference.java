package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.HelperWidget;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/BarrierReference.class */
public class BarrierReference extends HelperReference {
    private State.Direction af;
    private int ag;
    private Barrier ah;

    /* renamed from: androidx.constraintlayout.core.state.helpers.BarrierReference$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/helpers/BarrierReference$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2107a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[State.Direction.values().length];
            f2107a = iArr;
            try {
                iArr[State.Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2107a[State.Direction.START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2107a[State.Direction.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2107a[State.Direction.END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2107a[State.Direction.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2107a[State.Direction.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        int i = AnonymousClass1.f2107a[this.af.ordinal()];
        int i2 = 3;
        if (i == 3 || i == 4) {
            i2 = 1;
        } else if (i == 5) {
            i2 = 2;
        } else if (i != 6) {
            i2 = 0;
        }
        this.ah.setBarrierType(i2);
        this.ah.setMargin(this.ag);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.ah == null) {
            this.ah = new Barrier();
        }
        return this.ah;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ConstraintReference margin(int i) {
        this.ag = i;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ConstraintReference margin(Object obj) {
        margin(this.ac.convertDimension(obj));
        return this;
    }

    public void setBarrierDirection(State.Direction direction) {
        this.af = direction;
    }
}
