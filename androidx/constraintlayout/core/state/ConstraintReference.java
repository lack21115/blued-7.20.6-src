package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/ConstraintReference.class */
public class ConstraintReference implements Reference {

    /* renamed from: a  reason: collision with root package name */
    final State f2086a;
    private Object ac;
    private float ad;
    private float ae;
    private Object af;
    private ConstraintWidget ag;
    String b = null;

    /* renamed from: c  reason: collision with root package name */
    Facade f2087c = null;
    int d = 0;
    int e = 0;
    float f = -1.0f;
    float g = -1.0f;
    float h = 0.5f;
    float i = 0.5f;
    protected int j = 0;
    protected int k = 0;
    protected int l = 0;
    protected int m = 0;
    int n = 0;
    int o = 0;
    int p = 0;
    int q = 0;
    int r = 0;
    int s = 0;
    int t = 0;
    int u = 0;
    int v = 0;
    int w = 0;
    float x = Float.NaN;
    float y = Float.NaN;
    float z = Float.NaN;
    float A = Float.NaN;
    float B = Float.NaN;
    float C = Float.NaN;
    float D = Float.NaN;
    float E = Float.NaN;
    float F = Float.NaN;
    float G = Float.NaN;
    float H = Float.NaN;
    int I = 0;
    protected Object J = null;
    protected Object K = null;
    protected Object L = null;
    protected Object M = null;
    protected Object N = null;
    protected Object O = null;
    protected Object P = null;
    protected Object Q = null;
    protected Object R = null;
    protected Object S = null;
    protected Object T = null;
    protected Object U = null;
    Object V = null;
    Object W = null;
    Object X = null;
    Object Y = null;
    State.Constraint Z = null;
    Dimension aa = Dimension.Fixed(Dimension.WRAP_DIMENSION);
    Dimension ab = Dimension.Fixed(Dimension.WRAP_DIMENSION);
    private HashMap<String, Integer> ah = new HashMap<>();
    private HashMap<String, Float> ai = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.state.ConstraintReference$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/ConstraintReference$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2088a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00dd -> B:109:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e1 -> B:103:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00e5 -> B:81:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e9 -> B:77:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00ed -> B:89:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00f1 -> B:85:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f5 -> B:99:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00f9 -> B:93:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00fd -> B:107:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0101 -> B:101:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0105 -> B:79:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0109 -> B:75:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x010d -> B:87:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0111 -> B:83:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0115 -> B:97:0x00b8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0119 -> B:91:0x00c4). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x011d -> B:105:0x00d0). Please submit an issue!!! */
        static {
            int[] iArr = new int[State.Constraint.values().length];
            f2088a = iArr;
            try {
                iArr[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2088a[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2088a[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2088a[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2088a[State.Constraint.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2088a[State.Constraint.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2088a[State.Constraint.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2088a[State.Constraint.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2088a[State.Constraint.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f2088a[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f2088a[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f2088a[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f2088a[State.Constraint.BASELINE_TO_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f2088a[State.Constraint.BASELINE_TO_TOP.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f2088a[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f2088a[State.Constraint.CIRCULAR_CONSTRAINT.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f2088a[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f2088a[State.Constraint.CENTER_VERTICALLY.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/ConstraintReference$ConstraintReferenceFactory.class */
    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/ConstraintReference$IncorrectConstraintException.class */
    static class IncorrectConstraintException extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<String> f2089a;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.f2089a = arrayList;
        }

        public ArrayList<String> getErrors() {
            return this.f2089a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "IncorrectConstraintException: " + this.f2089a.toString();
        }
    }

    public ConstraintReference(State state) {
        this.f2086a = state;
    }

    private Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        Reference reference = obj;
        if (!(obj instanceof ConstraintReference)) {
            reference = this.f2086a.a(obj);
        }
        return reference;
    }

    private void a() {
        this.J = a(this.J);
        this.K = a(this.K);
        this.L = a(this.L);
        this.M = a(this.M);
        this.N = a(this.N);
        this.O = a(this.O);
        this.P = a(this.P);
        this.Q = a(this.Q);
        this.R = a(this.R);
        this.S = a(this.S);
        this.T = a(this.T);
        this.U = a(this.U);
        this.V = a(this.V);
        this.W = a(this.W);
        this.X = a(this.X);
    }

    private void a(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget b = b(obj);
        if (b == null) {
            return;
        }
        int i = AnonymousClass1.f2088a[constraint.ordinal()];
        switch (AnonymousClass1.f2088a[constraint.ordinal()]) {
            case 1:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(b.getAnchor(ConstraintAnchor.Type.LEFT), this.j, this.p, false);
                return;
            case 2:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(b.getAnchor(ConstraintAnchor.Type.RIGHT), this.j, this.p, false);
                return;
            case 3:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(b.getAnchor(ConstraintAnchor.Type.LEFT), this.k, this.q, false);
                return;
            case 4:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(b.getAnchor(ConstraintAnchor.Type.RIGHT), this.k, this.q, false);
                return;
            case 5:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(b.getAnchor(ConstraintAnchor.Type.LEFT), this.l, this.r, false);
                return;
            case 6:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(b.getAnchor(ConstraintAnchor.Type.RIGHT), this.l, this.r, false);
                return;
            case 7:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(b.getAnchor(ConstraintAnchor.Type.LEFT), this.m, this.s, false);
                return;
            case 8:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(b.getAnchor(ConstraintAnchor.Type.RIGHT), this.m, this.s, false);
                return;
            case 9:
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(b.getAnchor(ConstraintAnchor.Type.TOP), this.n, this.t, false);
                return;
            case 10:
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(b.getAnchor(ConstraintAnchor.Type.BOTTOM), this.n, this.t, false);
                return;
            case 11:
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(b.getAnchor(ConstraintAnchor.Type.TOP), this.o, this.u, false);
                return;
            case 12:
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(b.getAnchor(ConstraintAnchor.Type.BOTTOM), this.o, this.u, false);
                return;
            case 13:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, b, ConstraintAnchor.Type.BOTTOM, this.v, this.w);
                return;
            case 14:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, b, ConstraintAnchor.Type.TOP, this.v, this.w);
                return;
            case 15:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, b, ConstraintAnchor.Type.BASELINE, this.v, this.w);
                return;
            case 16:
                constraintWidget.connectCircularConstraint(b, this.ad, (int) this.ae);
                return;
            default:
                return;
        }
    }

    private ConstraintWidget b(Object obj) {
        if (obj instanceof Reference) {
            return ((Reference) obj).getConstraintWidget();
        }
        return null;
    }

    public void addCustomColor(String str, int i) {
        this.ah.put(str, Integer.valueOf(i));
    }

    public void addCustomFloat(String str, float f) {
        if (this.ai == null) {
            this.ai = new HashMap<>();
        }
        this.ai.put(str, Float.valueOf(f));
    }

    public ConstraintReference alpha(float f) {
        this.F = f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void apply() {
        if (this.ag == null) {
            return;
        }
        Facade facade = this.f2087c;
        if (facade != null) {
            facade.apply();
        }
        this.aa.apply(this.f2086a, this.ag, 0);
        this.ab.apply(this.f2086a, this.ag, 1);
        a();
        a(this.ag, this.J, State.Constraint.LEFT_TO_LEFT);
        a(this.ag, this.K, State.Constraint.LEFT_TO_RIGHT);
        a(this.ag, this.L, State.Constraint.RIGHT_TO_LEFT);
        a(this.ag, this.M, State.Constraint.RIGHT_TO_RIGHT);
        a(this.ag, this.N, State.Constraint.START_TO_START);
        a(this.ag, this.O, State.Constraint.START_TO_END);
        a(this.ag, this.P, State.Constraint.END_TO_START);
        a(this.ag, this.Q, State.Constraint.END_TO_END);
        a(this.ag, this.R, State.Constraint.TOP_TO_TOP);
        a(this.ag, this.S, State.Constraint.TOP_TO_BOTTOM);
        a(this.ag, this.T, State.Constraint.BOTTOM_TO_TOP);
        a(this.ag, this.U, State.Constraint.BOTTOM_TO_BOTTOM);
        a(this.ag, this.V, State.Constraint.BASELINE_TO_BASELINE);
        a(this.ag, this.W, State.Constraint.BASELINE_TO_TOP);
        a(this.ag, this.X, State.Constraint.BASELINE_TO_BOTTOM);
        a(this.ag, this.Y, State.Constraint.CIRCULAR_CONSTRAINT);
        int i = this.d;
        if (i != 0) {
            this.ag.setHorizontalChainStyle(i);
        }
        int i2 = this.e;
        if (i2 != 0) {
            this.ag.setVerticalChainStyle(i2);
        }
        float f = this.f;
        if (f != -1.0f) {
            this.ag.setHorizontalWeight(f);
        }
        float f2 = this.g;
        if (f2 != -1.0f) {
            this.ag.setVerticalWeight(f2);
        }
        this.ag.setHorizontalBiasPercent(this.h);
        this.ag.setVerticalBiasPercent(this.i);
        this.ag.frame.pivotX = this.x;
        this.ag.frame.pivotY = this.y;
        this.ag.frame.rotationX = this.z;
        this.ag.frame.rotationY = this.A;
        this.ag.frame.rotationZ = this.B;
        this.ag.frame.translationX = this.C;
        this.ag.frame.translationY = this.D;
        this.ag.frame.translationZ = this.E;
        this.ag.frame.scaleX = this.G;
        this.ag.frame.scaleY = this.H;
        this.ag.frame.alpha = this.F;
        this.ag.frame.visibility = this.I;
        this.ag.setVisibility(this.I);
        HashMap<String, Integer> hashMap = this.ah;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.ag.frame.setCustomAttribute(str, 902, this.ah.get(str).intValue());
            }
        }
        HashMap<String, Float> hashMap2 = this.ai;
        if (hashMap2 != null) {
            for (String str2 : hashMap2.keySet()) {
                this.ag.frame.setCustomAttribute(str2, 901, this.ai.get(str2).floatValue());
            }
        }
    }

    public ConstraintReference baseline() {
        this.Z = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object obj) {
        this.Z = State.Constraint.BASELINE_TO_BASELINE;
        this.V = obj;
        return this;
    }

    public ConstraintReference baselineToBottom(Object obj) {
        this.Z = State.Constraint.BASELINE_TO_BOTTOM;
        this.X = obj;
        return this;
    }

    public ConstraintReference baselineToTop(Object obj) {
        this.Z = State.Constraint.BASELINE_TO_TOP;
        this.W = obj;
        return this;
    }

    public ConstraintReference bias(float f) {
        if (this.Z == null) {
            return this;
        }
        int i = AnonymousClass1.f2088a[this.Z.ordinal()];
        if (i != 17) {
            if (i != 18) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        return this;
                }
            }
            this.i = f;
            return this;
        }
        this.h = f;
        return this;
    }

    public ConstraintReference bottom() {
        if (this.T != null) {
            this.Z = State.Constraint.BOTTOM_TO_TOP;
            return this;
        }
        this.Z = State.Constraint.BOTTOM_TO_BOTTOM;
        return this;
    }

    public ConstraintReference bottomToBottom(Object obj) {
        this.Z = State.Constraint.BOTTOM_TO_BOTTOM;
        this.U = obj;
        return this;
    }

    public ConstraintReference bottomToTop(Object obj) {
        this.Z = State.Constraint.BOTTOM_TO_TOP;
        this.T = obj;
        return this;
    }

    public ConstraintReference centerHorizontally(Object obj) {
        Object a2 = a(obj);
        this.N = a2;
        this.Q = a2;
        this.Z = State.Constraint.CENTER_HORIZONTALLY;
        this.h = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object obj) {
        Object a2 = a(obj);
        this.R = a2;
        this.U = a2;
        this.Z = State.Constraint.CENTER_VERTICALLY;
        this.i = 0.5f;
        return this;
    }

    public ConstraintReference circularConstraint(Object obj, float f, float f2) {
        this.Y = a(obj);
        this.ad = f;
        this.ae = f2;
        this.Z = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    public ConstraintReference clear() {
        if (this.Z == null) {
            this.J = null;
            this.K = null;
            this.j = 0;
            this.L = null;
            this.M = null;
            this.k = 0;
            this.N = null;
            this.O = null;
            this.l = 0;
            this.P = null;
            this.Q = null;
            this.m = 0;
            this.R = null;
            this.S = null;
            this.n = 0;
            this.T = null;
            this.U = null;
            this.o = 0;
            this.V = null;
            this.Y = null;
            this.h = 0.5f;
            this.i = 0.5f;
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 0;
            return this;
        }
        switch (AnonymousClass1.f2088a[this.Z.ordinal()]) {
            case 1:
            case 2:
                this.J = null;
                this.K = null;
                this.j = 0;
                this.p = 0;
                return this;
            case 3:
            case 4:
                this.L = null;
                this.M = null;
                this.k = 0;
                this.q = 0;
                return this;
            case 5:
            case 6:
                this.N = null;
                this.O = null;
                this.l = 0;
                this.r = 0;
                return this;
            case 7:
            case 8:
                this.P = null;
                this.Q = null;
                this.m = 0;
                this.s = 0;
                return this;
            case 9:
            case 10:
                this.R = null;
                this.S = null;
                this.n = 0;
                this.t = 0;
                return this;
            case 11:
            case 12:
                this.T = null;
                this.U = null;
                this.o = 0;
                this.u = 0;
                return this;
            case 13:
            case 14:
            default:
                return this;
            case 15:
                this.V = null;
                return this;
            case 16:
                this.Y = null;
                return this;
        }
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().a(), getHeight().a());
    }

    public ConstraintReference end() {
        if (this.P != null) {
            this.Z = State.Constraint.END_TO_START;
            return this;
        }
        this.Z = State.Constraint.END_TO_END;
        return this;
    }

    public ConstraintReference endToEnd(Object obj) {
        this.Z = State.Constraint.END_TO_END;
        this.Q = obj;
        return this;
    }

    public ConstraintReference endToStart(Object obj) {
        this.Z = State.Constraint.END_TO_START;
        this.P = obj;
        return this;
    }

    public float getAlpha() {
        return this.F;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.ag == null) {
            ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.ag = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.af);
        }
        return this.ag;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return this.f2087c;
    }

    public Dimension getHeight() {
        return this.ab;
    }

    public int getHorizontalChainStyle() {
        return this.d;
    }

    public float getHorizontalChainWeight() {
        return this.f;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.ac;
    }

    public float getPivotX() {
        return this.x;
    }

    public float getPivotY() {
        return this.y;
    }

    public float getRotationX() {
        return this.z;
    }

    public float getRotationY() {
        return this.A;
    }

    public float getRotationZ() {
        return this.B;
    }

    public float getScaleX() {
        return this.G;
    }

    public float getScaleY() {
        return this.H;
    }

    public String getTag() {
        return this.b;
    }

    public float getTranslationX() {
        return this.C;
    }

    public float getTranslationY() {
        return this.D;
    }

    public float getTranslationZ() {
        return this.E;
    }

    public int getVerticalChainStyle(int i) {
        return this.e;
    }

    public float getVerticalChainWeight() {
        return this.g;
    }

    public Object getView() {
        return this.af;
    }

    public Dimension getWidth() {
        return this.aa;
    }

    public ConstraintReference height(Dimension dimension) {
        return setHeight(dimension);
    }

    public ConstraintReference horizontalBias(float f) {
        this.h = f;
        return this;
    }

    public ConstraintReference left() {
        if (this.J != null) {
            this.Z = State.Constraint.LEFT_TO_LEFT;
            return this;
        }
        this.Z = State.Constraint.LEFT_TO_RIGHT;
        return this;
    }

    public ConstraintReference leftToLeft(Object obj) {
        this.Z = State.Constraint.LEFT_TO_LEFT;
        this.J = obj;
        return this;
    }

    public ConstraintReference leftToRight(Object obj) {
        this.Z = State.Constraint.LEFT_TO_RIGHT;
        this.K = obj;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ConstraintReference margin(int i) {
        if (this.Z == null) {
            this.j = i;
            this.k = i;
            this.l = i;
            this.m = i;
            this.n = i;
            this.o = i;
            return this;
        }
        switch (AnonymousClass1.f2088a[this.Z.ordinal()]) {
            case 1:
            case 2:
                this.j = i;
                return this;
            case 3:
            case 4:
                this.k = i;
                return this;
            case 5:
            case 6:
                this.l = i;
                return this;
            case 7:
            case 8:
                this.m = i;
                return this;
            case 9:
            case 10:
                this.n = i;
                return this;
            case 11:
            case 12:
                this.o = i;
                return this;
            case 13:
            case 14:
            case 15:
                this.v = i;
                break;
            case 16:
                break;
            default:
                return this;
        }
        this.ae = i;
        return this;
    }

    public ConstraintReference margin(Object obj) {
        return margin(this.f2086a.convertDimension(obj));
    }

    public ConstraintReference marginGone(int i) {
        if (this.Z == null) {
            this.p = i;
            this.q = i;
            this.r = i;
            this.s = i;
            this.t = i;
            this.u = i;
            return this;
        }
        switch (AnonymousClass1.f2088a[this.Z.ordinal()]) {
            case 1:
            case 2:
                this.p = i;
                return this;
            case 3:
            case 4:
                this.q = i;
                return this;
            case 5:
            case 6:
                this.r = i;
                return this;
            case 7:
            case 8:
                this.s = i;
                return this;
            case 9:
            case 10:
                this.t = i;
                return this;
            case 11:
            case 12:
                this.u = i;
                return this;
            case 13:
            case 14:
            case 15:
                this.w = i;
                return this;
            default:
                return this;
        }
    }

    public ConstraintReference marginGone(Object obj) {
        return marginGone(this.f2086a.convertDimension(obj));
    }

    public ConstraintReference pivotX(float f) {
        this.x = f;
        return this;
    }

    public ConstraintReference pivotY(float f) {
        this.y = f;
        return this;
    }

    public ConstraintReference right() {
        if (this.L != null) {
            this.Z = State.Constraint.RIGHT_TO_LEFT;
            return this;
        }
        this.Z = State.Constraint.RIGHT_TO_RIGHT;
        return this;
    }

    public ConstraintReference rightToLeft(Object obj) {
        this.Z = State.Constraint.RIGHT_TO_LEFT;
        this.L = obj;
        return this;
    }

    public ConstraintReference rightToRight(Object obj) {
        this.Z = State.Constraint.RIGHT_TO_RIGHT;
        this.M = obj;
        return this;
    }

    public ConstraintReference rotationX(float f) {
        this.z = f;
        return this;
    }

    public ConstraintReference rotationY(float f) {
        this.A = f;
        return this;
    }

    public ConstraintReference rotationZ(float f) {
        this.B = f;
        return this;
    }

    public ConstraintReference scaleX(float f) {
        this.G = f;
        return this;
    }

    public ConstraintReference scaleY(float f) {
        this.H = f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.ag = constraintWidget;
        constraintWidget.setCompanionWidget(this.af);
    }

    public void setFacade(Facade facade) {
        this.f2087c = facade;
        if (facade != null) {
            setConstraintWidget(facade.getConstraintWidget());
        }
    }

    public ConstraintReference setHeight(Dimension dimension) {
        this.ab = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int i) {
        this.d = i;
    }

    public void setHorizontalChainWeight(float f) {
        this.f = f;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object obj) {
        this.ac = obj;
    }

    public void setTag(String str) {
        this.b = str;
    }

    public void setVerticalChainStyle(int i) {
        this.e = i;
    }

    public void setVerticalChainWeight(float f) {
        this.g = f;
    }

    public void setView(Object obj) {
        this.af = obj;
        ConstraintWidget constraintWidget = this.ag;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        this.aa = dimension;
        return this;
    }

    public ConstraintReference start() {
        if (this.N != null) {
            this.Z = State.Constraint.START_TO_START;
            return this;
        }
        this.Z = State.Constraint.START_TO_END;
        return this;
    }

    public ConstraintReference startToEnd(Object obj) {
        this.Z = State.Constraint.START_TO_END;
        this.O = obj;
        return this;
    }

    public ConstraintReference startToStart(Object obj) {
        this.Z = State.Constraint.START_TO_START;
        this.N = obj;
        return this;
    }

    public ConstraintReference top() {
        if (this.R != null) {
            this.Z = State.Constraint.TOP_TO_TOP;
            return this;
        }
        this.Z = State.Constraint.TOP_TO_BOTTOM;
        return this;
    }

    public ConstraintReference topToBottom(Object obj) {
        this.Z = State.Constraint.TOP_TO_BOTTOM;
        this.S = obj;
        return this;
    }

    public ConstraintReference topToTop(Object obj) {
        this.Z = State.Constraint.TOP_TO_TOP;
        this.R = obj;
        return this;
    }

    public ConstraintReference translationX(float f) {
        this.C = f;
        return this;
    }

    public ConstraintReference translationY(float f) {
        this.D = f;
        return this;
    }

    public ConstraintReference translationZ(float f) {
        this.E = f;
        return this;
    }

    public void validate() throws IncorrectConstraintException {
        ArrayList arrayList = new ArrayList();
        if (this.J != null && this.K != null) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (this.L != null && this.M != null) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (this.N != null && this.O != null) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (this.P != null && this.Q != null) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if ((this.J != null || this.K != null || this.L != null || this.M != null) && (this.N != null || this.O != null || this.P != null || this.Q != null)) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new IncorrectConstraintException(arrayList);
        }
    }

    public ConstraintReference verticalBias(float f) {
        this.i = f;
        return this;
    }

    public ConstraintReference visibility(int i) {
        this.I = i;
        return this;
    }

    public ConstraintReference width(Dimension dimension) {
        return setWidth(dimension);
    }
}
