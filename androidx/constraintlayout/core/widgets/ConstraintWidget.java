package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/ConstraintWidget.class */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    int G;
    int H;
    boolean I;
    boolean J;
    protected ConstraintWidget[] K;
    protected ConstraintWidget[] L;
    ConstraintWidget M;
    ConstraintWidget N;
    private boolean O;
    private boolean P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private int[] X;
    private float Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f2119a;
    private boolean aa;
    private boolean ab;
    private int ac;
    private int ad;
    private boolean[] ae;
    private Object af;
    private int ag;
    private int ah;
    private String ai;
    private String aj;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    int f2120c;
    float d;
    ConstraintAnchor e;
    ConstraintAnchor f;
    public WidgetFrame frame;
    protected ArrayList<ConstraintAnchor> g;
    int h;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    int i;
    public boolean[] isTerminalWidget;
    protected int j;
    protected int k;
    protected int l;
    int m;
    public ConstraintAnchor mBaseline;
    public ConstraintAnchor mBottom;
    public ConstraintAnchor mCenter;
    public float mDimensionRatio;
    public int mHorizontalResolution;
    public boolean mIsHeightWrapContent;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    public ConstraintWidget mParent;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    public ConstraintAnchor mTop;
    public int mVerticalResolution;
    public float[] mWeight;
    public boolean measured;
    int n;
    protected int o;
    protected int p;
    int q;
    protected int r;
    public WidgetRun[] run;
    protected int s;
    public String stringId;
    float t;
    float u;
    int v;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;
    int w;
    int x;
    int y;
    boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/ConstraintWidget$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2121a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a6 -> B:62:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00aa -> B:58:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ae -> B:70:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b2 -> B:10:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00b6 -> B:74:0x0049). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00ba -> B:72:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00be -> B:80:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c2 -> B:76:0x006a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00c6 -> B:60:0x0075). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ca -> B:56:0x0081). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00ce -> B:68:0x008d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d2 -> B:64:0x0099). Please submit an issue!!! */
        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f2121a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2121a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2121a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2121a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2121a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f2121a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f2121a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f2121a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f2121a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/ConstraintWidget$DimensionBehaviour.class */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.b = false;
        this.f2119a = true;
        this.O = false;
        this.P = true;
        this.Q = -1;
        this.R = -1;
        this.frame = new WidgetFrame(this);
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.W = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f2120c = -1;
        this.d = 1.0f;
        this.X = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.Y = 0.0f;
        this.Z = false;
        this.ab = false;
        this.ac = 0;
        this.ad = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.e = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.g = new ArrayList<>();
        this.ae = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.h = 0;
        this.i = 0;
        this.mDimensionRatio = 0.0f;
        this.j = -1;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        float f = DEFAULT_BIAS;
        this.t = f;
        this.u = f;
        this.ag = 0;
        this.ah = 0;
        this.ai = null;
        this.aj = null;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.K = new ConstraintWidget[]{null, null};
        this.L = new ConstraintWidget[]{null, null};
        this.M = null;
        this.N = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        a();
    }

    public ConstraintWidget(int i, int i2) {
        this(0, 0, i, i2);
    }

    public ConstraintWidget(int i, int i2, int i3, int i4) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.b = false;
        this.f2119a = true;
        this.O = false;
        this.P = true;
        this.Q = -1;
        this.R = -1;
        this.frame = new WidgetFrame(this);
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.W = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f2120c = -1;
        this.d = 1.0f;
        this.X = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.Y = 0.0f;
        this.Z = false;
        this.ab = false;
        this.ac = 0;
        this.ad = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.e = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.g = new ArrayList<>();
        this.ae = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.h = 0;
        this.i = 0;
        this.mDimensionRatio = 0.0f;
        this.j = -1;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        float f = DEFAULT_BIAS;
        this.t = f;
        this.u = f;
        this.ag = 0;
        this.ah = 0;
        this.ai = null;
        this.aj = null;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.K = new ConstraintWidget[]{null, null};
        this.L = new ConstraintWidget[]{null, null};
        this.M = null;
        this.N = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.k = i;
        this.l = i2;
        this.h = i3;
        this.i = i4;
        a();
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.b = false;
        this.f2119a = true;
        this.O = false;
        this.P = true;
        this.Q = -1;
        this.R = -1;
        this.frame = new WidgetFrame(this);
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.W = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.f2120c = -1;
        this.d = 1.0f;
        this.X = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.Y = 0.0f;
        this.Z = false;
        this.ab = false;
        this.ac = 0;
        this.ad = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.e = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.g = new ArrayList<>();
        this.ae = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.h = 0;
        this.i = 0;
        this.mDimensionRatio = 0.0f;
        this.j = -1;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        float f = DEFAULT_BIAS;
        this.t = f;
        this.u = f;
        this.ag = 0;
        this.ah = 0;
        this.ai = null;
        this.aj = null;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.K = new ConstraintWidget[]{null, null};
        this.L = new ConstraintWidget[]{null, null};
        this.M = null;
        this.N = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        a();
        setDebugName(str);
    }

    public ConstraintWidget(String str, int i, int i2) {
        this(i, i2);
        setDebugName(str);
    }

    public ConstraintWidget(String str, int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4);
        setDebugName(str);
    }

    private void a() {
        this.g.add(this.mLeft);
        this.g.add(this.mTop);
        this.g.add(this.mRight);
        this.g.add(this.mBottom);
        this.g.add(this.e);
        this.g.add(this.f);
        this.g.add(this.mCenter);
        this.g.add(this.mBaseline);
    }

    /* JADX WARN: Code restructure failed: missing block: B:341:0x07f1, code lost:
        if (r14 != false) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x087d, code lost:
        if (r0 == r0) goto L245;
     */
    /* JADX WARN: Removed duplicated region for block: B:281:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x06e1  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x07dd  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x08a8  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x08d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.constraintlayout.core.LinearSystem r11, boolean r12, boolean r13, boolean r14, boolean r15, androidx.constraintlayout.core.SolverVariable r16, androidx.constraintlayout.core.SolverVariable r17, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r18, boolean r19, androidx.constraintlayout.core.widgets.ConstraintAnchor r20, androidx.constraintlayout.core.widgets.ConstraintAnchor r21, int r22, int r23, int r24, int r25, float r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, int r32, int r33, int r34, int r35, float r36, boolean r37) {
        /*
            Method dump skipped, instructions count: 2564
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.a(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private void a(StringBuilder sb, ConstraintAnchor constraintAnchor, float f) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append("circle : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("',");
        sb.append(constraintAnchor.mMargin);
        sb.append(",");
        sb.append(f);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private void a(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    private void a(StringBuilder sb, String str, float f, int i) {
        if (f == 0.0f) {
            return;
        }
        sb.append(str);
        sb.append(" :  [");
        sb.append(f);
        sb.append(",");
        sb.append(i);
        sb.append("");
        sb.append("],\n");
    }

    private void a(StringBuilder sb, String str, int i, int i2) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    private void a(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        sb.append(str);
        sb.append(" :  {\n");
        a(sb, "size", i, Integer.MIN_VALUE);
        a(sb, "min", i2, 0);
        a(sb, "max", i3, Integer.MAX_VALUE);
        a(sb, "matchMin", i5, 0);
        a(sb, "matchDef", i6, 0);
        a(sb, "matchPercent", i6, 1);
        sb.append("},\n");
    }

    private void a(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("',");
        sb.append(constraintAnchor.mMargin);
        sb.append(",");
        sb.append(constraintAnchor.f2115a);
        sb.append(",");
        sb.append(" ] ,\n");
    }

    private boolean a(int i) {
        int i2 = i * 2;
        if (this.mListAnchors[i2].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[i2].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            if (constraintAnchor != constraintAnchorArr[i2]) {
                int i3 = i2 + 1;
                return constraintAnchorArr[i3].mTarget != null && this.mListAnchors[i3].mTarget.mTarget == this.mListAnchors[i3];
            }
            return false;
        }
        return false;
    }

    private void b(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2) {
        sb.append(str);
        sb.append(" :  {\n");
        a(sb, "      size", i, 0);
        a(sb, "      min", i2, 0);
        a(sb, "      max", i3, Integer.MAX_VALUE);
        a(sb, "      matchMin", i5, 0);
        a(sb, "      matchDef", i6, 0);
        a(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    private void b(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.mTarget);
        sb.append("'");
        if (constraintAnchor.f2115a != Integer.MIN_VALUE || constraintAnchor.mMargin != 0) {
            sb.append(",");
            sb.append(constraintAnchor.mMargin);
            if (constraintAnchor.f2115a != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.f2115a);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, boolean z) {
        this.ae[i] = z;
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.a(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x070e  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x089b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x08c0  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x08eb  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x08fa  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0917  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0961  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x09d7  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x09dd  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0a24  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0a6a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addToSolver(androidx.constraintlayout.core.LinearSystem r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 2718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean allowedInBarrier() {
        return this.ah != 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return this.k + this.o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        return this.l + this.p;
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        boolean z;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 != ConstraintAnchor.Type.CENTER) {
                if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                    connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                } else {
                    return;
                }
            }
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            boolean z2 = true;
            if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0);
                z = true;
            } else {
                z = false;
            }
            if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
            } else if (z) {
                getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
            } else if (z2) {
                getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
        } else {
            ConstraintAnchor anchor9 = getAnchor(type);
            ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
            if (anchor9.isValidConnection(anchor10)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                    if (anchor11 != null) {
                        anchor11.reset();
                    }
                    if (anchor12 != null) {
                        anchor12.reset();
                    }
                } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.BASELINE);
                    if (anchor13 != null) {
                        anchor13.reset();
                    }
                    ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor14.getTarget() != anchor10) {
                        anchor14.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                    if (anchor15.isConnected()) {
                        opposite.reset();
                        anchor15.reset();
                    }
                } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor16.getTarget() != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                anchor9.connect(anchor10, i);
            }
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int i) {
        immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i, 0);
        this.Y = f;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.f2120c = constraintWidget.f2120c;
        this.d = constraintWidget.d;
        int[] iArr3 = constraintWidget.X;
        this.X = Arrays.copyOf(iArr3, iArr3.length);
        this.Y = constraintWidget.Y;
        this.Z = constraintWidget.Z;
        this.aa = constraintWidget.aa;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.e.reset();
        this.f.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        this.mParent = this.mParent == null ? null : hashMap.get(constraintWidget.mParent);
        this.h = constraintWidget.h;
        this.i = constraintWidget.i;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.j = constraintWidget.j;
        this.k = constraintWidget.k;
        this.l = constraintWidget.l;
        this.m = constraintWidget.m;
        this.n = constraintWidget.n;
        this.o = constraintWidget.o;
        this.p = constraintWidget.p;
        this.q = constraintWidget.q;
        this.r = constraintWidget.r;
        this.s = constraintWidget.s;
        this.t = constraintWidget.t;
        this.u = constraintWidget.u;
        this.af = constraintWidget.af;
        this.ag = constraintWidget.ag;
        this.ah = constraintWidget.ah;
        this.ai = constraintWidget.ai;
        this.aj = constraintWidget.aj;
        this.v = constraintWidget.v;
        this.w = constraintWidget.w;
        this.x = constraintWidget.x;
        this.y = constraintWidget.y;
        this.z = constraintWidget.z;
        this.A = constraintWidget.A;
        this.B = constraintWidget.B;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        this.J = constraintWidget.J;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.K;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.K;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.L;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.L;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.M;
        this.M = constraintWidget2 == null ? null : hashMap.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.N;
        this.N = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.q > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void ensureMeasureRequested() {
        this.f2119a = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f2121a[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.e;
            case 8:
                return this.f;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.g;
    }

    public int getBaselineDistance() {
        return this.q;
    }

    public float getBiasPercent(int i) {
        if (i == 0) {
            return this.t;
        }
        if (i == 1) {
            return this.u;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.i;
    }

    public Object getCompanionWidget() {
        return this.af;
    }

    public int getContainerItemSkip() {
        return this.ag;
    }

    public String getDebugName() {
        return this.ai;
    }

    public DimensionBehaviour getDimensionBehaviour(int i) {
        if (i == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.j;
    }

    public boolean getHasBaseline() {
        return this.Z;
    }

    public int getHeight() {
        if (this.ah == 8) {
            return 0;
        }
        return this.i;
    }

    public float getHorizontalBiasPercent() {
        return this.t;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget constraintWidget = null;
        if (isInHorizontalChain()) {
            ConstraintWidget constraintWidget2 = this;
            constraintWidget = null;
            while (constraintWidget == null && constraintWidget2 != null) {
                ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
                ConstraintWidget owner = target == null ? null : target.getOwner();
                if (owner == getParent()) {
                    return constraintWidget2;
                }
                ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
                if (target2 == null || target2.getOwner() == constraintWidget2) {
                    constraintWidget2 = owner;
                } else {
                    constraintWidget = constraintWidget2;
                }
            }
        }
        return constraintWidget;
    }

    public int getHorizontalChainStyle() {
        return this.G;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i = 0;
        if (constraintAnchor != null) {
            i = 0 + constraintAnchor.mMargin;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        int i2 = i;
        if (constraintAnchor2 != null) {
            i2 = i + constraintAnchor2.mMargin;
        }
        return i2;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.ac;
    }

    public int getLastVerticalMeasureSpec() {
        return this.ad;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i) {
        if (i == 0) {
            return getWidth();
        }
        if (i == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.X[1];
    }

    public int getMaxWidth() {
        return this.X[0];
    }

    public int getMinHeight() {
        return this.s;
    }

    public int getMinWidth() {
        return this.r;
    }

    public ConstraintWidget getNextChainMember(int i) {
        if (i == 0) {
            if (this.mRight.mTarget != null) {
                ConstraintAnchor constraintAnchor = this.mRight.mTarget.mTarget;
                ConstraintAnchor constraintAnchor2 = this.mRight;
                if (constraintAnchor == constraintAnchor2) {
                    return constraintAnchor2.mTarget.mOwner;
                }
                return null;
            }
            return null;
        } else if (i != 1 || this.mBottom.mTarget == null) {
            return null;
        } else {
            ConstraintAnchor constraintAnchor3 = this.mBottom.mTarget.mTarget;
            ConstraintAnchor constraintAnchor4 = this.mBottom;
            if (constraintAnchor3 == constraintAnchor4) {
                return constraintAnchor4.mTarget.mOwner;
            }
            return null;
        }
    }

    public int getOptimizerWrapHeight() {
        int i;
        int i2 = this.i;
        int i3 = i2;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                i = Math.max(this.mMatchConstraintMinHeight, i2);
            } else {
                i = this.mMatchConstraintMinHeight;
                if (i > 0) {
                    this.i = i;
                } else {
                    i = 0;
                }
            }
            int i4 = this.mMatchConstraintMaxHeight;
            i3 = i;
            if (i4 > 0) {
                i3 = i;
                if (i4 < i) {
                    i3 = i4;
                }
            }
        }
        return i3;
    }

    public int getOptimizerWrapWidth() {
        int i;
        int i2 = this.h;
        int i3 = i2;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultWidth == 1) {
                i = Math.max(this.mMatchConstraintMinWidth, i2);
            } else {
                i = this.mMatchConstraintMinWidth;
                if (i > 0) {
                    this.h = i;
                } else {
                    i = 0;
                }
            }
            int i4 = this.mMatchConstraintMaxWidth;
            i3 = i;
            if (i4 > 0) {
                i3 = i;
                if (i4 < i) {
                    i3 = i4;
                }
            }
        }
        return i3;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i) {
        if (i == 0) {
            if (this.mLeft.mTarget != null) {
                ConstraintAnchor constraintAnchor = this.mLeft.mTarget.mTarget;
                ConstraintAnchor constraintAnchor2 = this.mLeft;
                if (constraintAnchor == constraintAnchor2) {
                    return constraintAnchor2.mTarget.mOwner;
                }
                return null;
            }
            return null;
        } else if (i != 1 || this.mTop.mTarget == null) {
            return null;
        } else {
            ConstraintAnchor constraintAnchor3 = this.mTop.mTarget.mTarget;
            ConstraintAnchor constraintAnchor4 = this.mTop;
            if (constraintAnchor3 == constraintAnchor4) {
                return constraintAnchor4.mTarget.mOwner;
            }
            return null;
        }
    }

    public int getRight() {
        return getX() + this.h;
    }

    public WidgetRun getRun(int i) {
        if (i == 0) {
            return this.horizontalRun;
        }
        if (i == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb) {
        sb.append("  " + this.stringId + ":{\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    actualWidth:");
        sb2.append(this.h);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.i);
        sb.append("\n");
        sb.append("    actualLeft:" + this.k);
        sb.append("\n");
        sb.append("    actualTop:" + this.l);
        sb.append("\n");
        b(sb, "left", this.mLeft);
        b(sb, Constant.MAP_KEY_TOP, this.mTop);
        b(sb, "right", this.mRight);
        b(sb, "bottom", this.mBottom);
        b(sb, "baseline", this.mBaseline);
        b(sb, "centerX", this.e);
        b(sb, "centerY", this.f);
        b(sb, "    width", this.h, this.r, this.X[0], this.Q, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        b(sb, "    height", this.i, this.s, this.X[1], this.R, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        a(sb, "    dimensionRatio", this.mDimensionRatio, this.j);
        a(sb, "    horizontalBias", this.t, DEFAULT_BIAS);
        a(sb, "    verticalBias", this.u, DEFAULT_BIAS);
        a(sb, "    horizontalChainStyle", this.G, 0);
        a(sb, "    verticalChainStyle", this.H, 0);
        sb.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.aj;
    }

    public float getVerticalBiasPercent() {
        return this.u;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget constraintWidget = null;
        if (isInVerticalChain()) {
            ConstraintWidget constraintWidget2 = this;
            constraintWidget = null;
            while (constraintWidget == null && constraintWidget2 != null) {
                ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
                ConstraintWidget owner = target == null ? null : target.getOwner();
                if (owner == getParent()) {
                    return constraintWidget2;
                }
                ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
                if (target2 == null || target2.getOwner() == constraintWidget2) {
                    constraintWidget2 = owner;
                } else {
                    constraintWidget = constraintWidget2;
                }
            }
        }
        return constraintWidget;
    }

    public int getVerticalChainStyle() {
        return this.H;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i = 0;
        if (this.mLeft != null) {
            i = 0 + this.mTop.mMargin;
        }
        int i2 = i;
        if (this.mRight != null) {
            i2 = i + this.mBottom.mMargin;
        }
        return i2;
    }

    public int getVisibility() {
        return this.ah;
    }

    public int getWidth() {
        if (this.ah == 8) {
            return 0;
        }
        return this.h;
    }

    public int getWrapBehaviorInParent() {
        return this.W;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.k : ((ConstraintWidgetContainer) constraintWidget).Q + this.k;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.l : ((ConstraintWidgetContainer) constraintWidget).R + this.l;
    }

    public boolean hasBaseline() {
        return this.Z;
    }

    public boolean hasDanglingDimension(int i) {
        if (i == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        int size = this.g.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (this.g.get(i2).hasDependents()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean hasDimensionOverride() {
        return (this.Q == -1 && this.R == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i, int i2) {
        return i == 0 ? this.mLeft.mTarget != null && this.mLeft.mTarget.hasFinalValue() && this.mRight.mTarget != null && this.mRight.mTarget.hasFinalValue() && (this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.mTarget.getFinalValue() + this.mLeft.getMargin()) >= i2 : this.mTop.mTarget != null && this.mTop.mTarget.hasFinalValue() && this.mBottom.mTarget != null && this.mBottom.mTarget.hasFinalValue() && (this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.mTarget.getFinalValue() + this.mTop.getMargin()) >= i2;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i, i2, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.U;
    }

    public boolean isInBarrier(int i) {
        return this.ae[i];
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null || this.mLeft.mTarget.mTarget != this.mLeft) {
            return this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight;
        }
        return true;
    }

    public boolean isInPlaceholder() {
        return this.aa;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null || this.mTop.mTarget.mTarget != this.mTop) {
            return this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom;
        }
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.ab;
    }

    public boolean isMeasureRequested() {
        return this.f2119a && this.ah != 8;
    }

    public boolean isResolvedHorizontally() {
        if (this.S) {
            return true;
        }
        return this.mLeft.hasFinalValue() && this.mRight.hasFinalValue();
    }

    public boolean isResolvedVertically() {
        if (this.T) {
            return true;
        }
        return this.mTop.hasFinalValue() && this.mBottom.hasFinalValue();
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        boolean z = false;
        if (this.mMatchConstraintDefaultWidth == 0) {
            z = false;
            if (this.mDimensionRatio == 0.0f) {
                z = false;
                if (this.mMatchConstraintMinWidth == 0) {
                    z = false;
                    if (this.mMatchConstraintMaxWidth == 0) {
                        z = false;
                        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.V;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.U = true;
    }

    public void markVerticalSolvingPassDone() {
        this.V = true;
    }

    public boolean oppositeDimensionDependsOn(int i) {
        byte b = i == 0 ? (byte) 1 : (byte) 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        return dimensionBehaviourArr[i] == DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviourArr[b == 1 ? 1 : 0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean oppositeDimensionsTied() {
        boolean z = false;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            z = false;
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                z = true;
            }
        }
        return z;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.e.reset();
        this.f.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.Y = 0.0f;
        this.h = 0;
        this.i = 0;
        this.mDimensionRatio = 0.0f;
        this.j = -1;
        this.k = 0;
        this.l = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        float f = DEFAULT_BIAS;
        this.t = f;
        this.u = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.af = null;
        this.ag = 0;
        this.ah = 0;
        this.aj = null;
        this.D = false;
        this.E = false;
        this.G = 0;
        this.H = 0;
        this.I = false;
        this.J = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.X;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.b = false;
        this.f2120c = -1;
        this.d = 1.0f;
        this.F = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.ab = false;
        boolean[] zArr2 = this.ae;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f2119a = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.Q = -1;
        this.R = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.t = 0.5f;
            this.u = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.t = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.u = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).reset();
        }
    }

    public void resetFinalResolution() {
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.e.resetSolverVariable(cache);
        this.f.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.U = false;
        this.V = false;
    }

    public StringBuilder serialize(StringBuilder sb) {
        sb.append("{\n");
        a(sb, "left", this.mLeft);
        a(sb, Constant.MAP_KEY_TOP, this.mTop);
        a(sb, "right", this.mRight);
        a(sb, "bottom", this.mBottom);
        a(sb, "baseline", this.mBaseline);
        a(sb, "centerX", this.e);
        a(sb, "centerY", this.f);
        a(sb, this.mCenter, this.Y);
        a(sb, "width", this.h, this.r, this.X[0], this.Q, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        a(sb, "height", this.i, this.s, this.X[1], this.R, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        a(sb, "dimensionRatio", this.mDimensionRatio, this.j);
        a(sb, "horizontalBias", this.t, DEFAULT_BIAS);
        a(sb, "verticalBias", this.u, DEFAULT_BIAS);
        sb.append("}\n");
        return sb;
    }

    public void setBaselineDistance(int i) {
        this.q = i;
        this.Z = i > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.af = obj;
    }

    public void setContainerItemSkip(int i) {
        if (i >= 0) {
            this.ag = i;
        } else {
            this.ag = 0;
        }
    }

    public void setDebugName(String str) {
        this.ai = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.ai = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        createObjectVariable5.setName(str + ".baseline");
    }

    public void setDimension(int i, int i2) {
        this.h = i;
        int i3 = this.r;
        if (i < i3) {
            this.h = i3;
        }
        this.i = i2;
        int i4 = this.s;
        if (i2 < i4) {
            this.i = i4;
        }
    }

    public void setDimensionRatio(float f, int i) {
        this.mDimensionRatio = f;
        this.j = i;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00f1 -> B:39:0x00f3). Please submit an issue!!! */
    public void setDimensionRatio(String str) {
        float f;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i = -1;
        int i2 = 0;
        if (indexOf > 0) {
            i = -1;
            i2 = 0;
            if (indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i = 0;
                } else {
                    i = -1;
                    if (substring.equalsIgnoreCase("H")) {
                        i = 1;
                    }
                }
                i2 = indexOf + 1;
            }
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i2);
            if (substring2.length() > 0) {
                f = Float.parseFloat(substring2);
            }
            f = 0.0f;
        } else {
            String substring3 = str.substring(i2, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f = i == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f = 0.0f;
        }
        if (f > 0.0f) {
            this.mDimensionRatio = f;
            this.j = i;
        }
    }

    public void setFinalBaseline(int i) {
        if (this.Z) {
            int i2 = i - this.q;
            int i3 = this.i;
            this.l = i2;
            this.mTop.setFinalValue(i2);
            this.mBottom.setFinalValue(i3 + i2);
            this.mBaseline.setFinalValue(i);
            this.T = true;
        }
    }

    public void setFinalFrame(int i, int i2, int i3, int i4, int i5, int i6) {
        setFrame(i, i2, i3, i4);
        setBaselineDistance(i5);
        if (i6 == 0) {
            this.S = true;
            this.T = false;
        } else if (i6 == 1) {
            this.S = false;
            this.T = true;
        } else if (i6 == 2) {
            this.S = true;
            this.T = true;
        } else {
            this.S = false;
            this.T = false;
        }
    }

    public void setFinalHorizontal(int i, int i2) {
        if (this.S) {
            return;
        }
        this.mLeft.setFinalValue(i);
        this.mRight.setFinalValue(i2);
        this.k = i;
        this.h = i2 - i;
        this.S = true;
    }

    public void setFinalLeft(int i) {
        this.mLeft.setFinalValue(i);
        this.k = i;
    }

    public void setFinalTop(int i) {
        this.mTop.setFinalValue(i);
        this.l = i;
    }

    public void setFinalVertical(int i, int i2) {
        if (this.T) {
            return;
        }
        this.mTop.setFinalValue(i);
        this.mBottom.setFinalValue(i2);
        this.l = i;
        this.i = i2 - i;
        if (this.Z) {
            this.mBaseline.setFinalValue(i + this.q);
        }
        this.T = true;
    }

    public void setFrame(int i, int i2, int i3) {
        if (i3 == 0) {
            setHorizontalDimension(i, i2);
        } else if (i3 == 1) {
            setVerticalDimension(i, i2);
        }
    }

    public void setFrame(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.k = i;
        this.l = i2;
        if (this.ah == 8) {
            this.h = 0;
            this.i = 0;
            return;
        }
        int i7 = i5;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
            int i8 = this.h;
            i7 = i5;
            if (i5 < i8) {
                i7 = i8;
            }
        }
        int i9 = i6;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
            int i10 = this.i;
            i9 = i6;
            if (i6 < i10) {
                i9 = i10;
            }
        }
        this.h = i7;
        this.i = i9;
        int i11 = this.s;
        if (i9 < i11) {
            this.i = i11;
        }
        int i12 = this.h;
        int i13 = this.r;
        if (i12 < i13) {
            this.h = i13;
        }
        if (this.mMatchConstraintMaxWidth > 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.h = Math.min(this.h, this.mMatchConstraintMaxWidth);
        }
        if (this.mMatchConstraintMaxHeight > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.i = Math.min(this.i, this.mMatchConstraintMaxHeight);
        }
        int i14 = this.h;
        if (i7 != i14) {
            this.Q = i14;
        }
        int i15 = this.i;
        if (i9 != i15) {
            this.R = i15;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i) {
        int i2 = AnonymousClass1.f2121a[type.ordinal()];
        if (i2 == 1) {
            this.mLeft.f2115a = i;
        } else if (i2 == 2) {
            this.mTop.f2115a = i;
        } else if (i2 == 3) {
            this.mRight.f2115a = i;
        } else if (i2 == 4) {
            this.mBottom.f2115a = i;
        } else if (i2 != 5) {
        } else {
            this.mBaseline.f2115a = i;
        }
    }

    public void setHasBaseline(boolean z) {
        this.Z = z;
    }

    public void setHeight(int i) {
        this.i = i;
        int i2 = this.s;
        if (i < i2) {
            this.i = i2;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f) {
        this.t = f;
    }

    public void setHorizontalChainStyle(int i) {
        this.G = i;
    }

    public void setHorizontalDimension(int i, int i2) {
        this.k = i;
        int i3 = i2 - i;
        this.h = i3;
        int i4 = this.r;
        if (i3 < i4) {
            this.h = i4;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultWidth = i;
        this.mMatchConstraintMinWidth = i2;
        int i4 = i3;
        if (i3 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.mMatchConstraintMaxWidth = i4;
        this.mMatchConstraintPercentWidth = f;
        if (f <= 0.0f || f >= 1.0f || this.mMatchConstraintDefaultWidth != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    public void setInPlaceholder(boolean z) {
        this.aa = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.ab = z;
    }

    public void setLastMeasureSpec(int i, int i2) {
        this.ac = i;
        this.ad = i2;
        setMeasureRequested(false);
    }

    public void setLength(int i, int i2) {
        if (i2 == 0) {
            setWidth(i);
        } else if (i2 == 1) {
            setHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        this.X[1] = i;
    }

    public void setMaxWidth(int i) {
        this.X[0] = i;
    }

    public void setMeasureRequested(boolean z) {
        this.f2119a = z;
    }

    public void setMinHeight(int i) {
        if (i < 0) {
            this.s = 0;
        } else {
            this.s = i;
        }
    }

    public void setMinWidth(int i) {
        if (i < 0) {
            this.r = 0;
        } else {
            this.r = i;
        }
    }

    public void setOffset(int i, int i2) {
        this.o = i;
        this.p = i2;
    }

    public void setOrigin(int i, int i2) {
        this.k = i;
        this.l = i2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setType(String str) {
        this.aj = str;
    }

    public void setVerticalBiasPercent(float f) {
        this.u = f;
    }

    public void setVerticalChainStyle(int i) {
        this.H = i;
    }

    public void setVerticalDimension(int i, int i2) {
        this.l = i;
        int i3 = i2 - i;
        this.i = i3;
        int i4 = this.s;
        if (i3 < i4) {
            this.i = i4;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i, int i2, int i3, float f) {
        this.mMatchConstraintDefaultHeight = i;
        this.mMatchConstraintMinHeight = i2;
        int i4 = i3;
        if (i3 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.mMatchConstraintMaxHeight = i4;
        this.mMatchConstraintPercentHeight = f;
        if (f <= 0.0f || f >= 1.0f || this.mMatchConstraintDefaultHeight != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int i) {
        this.ah = i;
    }

    public void setWidth(int i) {
        this.h = i;
        int i2 = this.r;
        if (i < i2) {
            this.h = i2;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setWrapBehaviorInParent(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.W = i;
    }

    public void setX(int i) {
        this.k = i;
    }

    public void setY(int i) {
        this.l = i;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f2120c == -1) {
            if (z3 && !z4) {
                this.f2120c = 0;
            } else if (!z3 && z4) {
                this.f2120c = 1;
                if (this.j == -1) {
                    this.d = 1.0f / this.d;
                }
            }
        }
        if (this.f2120c == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.f2120c = 1;
        } else if (this.f2120c == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.f2120c = 0;
        }
        if (this.f2120c == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.f2120c = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.d = 1.0f / this.d;
                this.f2120c = 1;
            }
        }
        if (this.f2120c == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.f2120c = 0;
            } else if (this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMinHeight <= 0) {
            } else {
                this.d = 1.0f / this.d;
                this.f2120c = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.aj != null) {
            str = "type: " + this.aj + " ";
        } else {
            str = "";
        }
        sb.append(str);
        String str2 = "";
        if (this.ai != null) {
            str2 = "id: " + this.ai + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.k);
        sb.append(", ");
        sb.append(this.l);
        sb.append(") - (");
        sb.append(this.h);
        sb.append(" x ");
        sb.append(this.i);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
        if (r0 == Integer.MAX_VALUE) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateFromRuns(boolean r4, boolean r5) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.updateFromRuns(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0127, code lost:
        if (r10 == Integer.MAX_VALUE) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateFromSolver(androidx.constraintlayout.core.LinearSystem r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.updateFromSolver(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }
}
