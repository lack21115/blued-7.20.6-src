package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet.class */
public class ConstraintSet {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int CIRCLE_REFERENCE = 8;
    public static final int END = 7;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_GUIDELINE = 0;
    public static final int INVISIBLE = 4;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_GUIDELINE = 1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    public static final int WRAP_CONTENT = -2;
    private static final int[] d = {0, 4, 8};
    private static SparseIntArray f = new SparseIntArray();
    private static SparseIntArray g = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    private boolean f2266a;
    public String mIdString;
    public String derivedState = "";
    public int mRotate = 0;
    private HashMap<String, ConstraintAttribute> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f2267c = true;
    private HashMap<Integer, Constraint> e = new HashMap<>();

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$Constraint.class */
    public static class Constraint {

        /* renamed from: a  reason: collision with root package name */
        int f2268a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        Delta f2269c;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$Constraint$Delta.class */
        public static class Delta {

            /* renamed from: a  reason: collision with root package name */
            int[] f2270a = new int[10];
            int[] b = new int[10];

            /* renamed from: c  reason: collision with root package name */
            int f2271c = 0;
            int[] d = new int[10];
            float[] e = new float[10];
            int f = 0;
            int[] g = new int[5];
            String[] h = new String[5];
            int i = 0;
            int[] j = new int[4];
            boolean[] k = new boolean[4];
            int l = 0;

            Delta() {
            }

            void a(int i, float f) {
                int i2 = this.f;
                int[] iArr = this.d;
                if (i2 >= iArr.length) {
                    this.d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.d;
                int i3 = this.f;
                iArr2[i3] = i;
                float[] fArr2 = this.e;
                this.f = i3 + 1;
                fArr2[i3] = f;
            }

            void a(int i, int i2) {
                int i3 = this.f2271c;
                int[] iArr = this.f2270a;
                if (i3 >= iArr.length) {
                    this.f2270a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.b;
                    this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f2270a;
                int i4 = this.f2271c;
                iArr3[i4] = i;
                int[] iArr4 = this.b;
                this.f2271c = i4 + 1;
                iArr4[i4] = i2;
            }

            void a(int i, String str) {
                int i2 = this.i;
                int[] iArr = this.g;
                if (i2 >= iArr.length) {
                    this.g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.g;
                int i3 = this.i;
                iArr2[i3] = i;
                String[] strArr2 = this.h;
                this.i = i3 + 1;
                strArr2[i3] = str;
            }

            void a(int i, boolean z) {
                int i2 = this.l;
                int[] iArr = this.j;
                if (i2 >= iArr.length) {
                    this.j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.k;
                    this.k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.j;
                int i3 = this.l;
                iArr2[i3] = i;
                boolean[] zArr2 = this.k;
                this.l = i3 + 1;
                zArr2[i3] = z;
            }

            void a(Constraint constraint) {
                int i;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.f2271c) {
                        break;
                    }
                    ConstraintSet.b(constraint, this.f2270a[i3], this.b[i3]);
                    i2 = i3 + 1;
                }
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= this.f) {
                        break;
                    }
                    ConstraintSet.b(constraint, this.d[i5], this.e[i5]);
                    i4 = i5 + 1;
                }
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= this.i) {
                        break;
                    }
                    ConstraintSet.b(constraint, this.g[i7], this.h[i7]);
                    i6 = i7 + 1;
                }
                for (i = 0; i < this.l; i++) {
                    ConstraintSet.b(constraint, this.j[i], this.k[i]);
                }
            }

            void a(String str) {
                Log.v(str, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f2271c) {
                        break;
                    }
                    Log.v(str, this.f2270a[i2] + " = " + this.b[i2]);
                    i = i2 + 1;
                }
                Log.v(str, TypedValues.Custom.S_FLOAT);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.f) {
                        break;
                    }
                    Log.v(str, this.d[i4] + " = " + this.e[i4]);
                    i3 = i4 + 1;
                }
                Log.v(str, "strings");
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= this.i) {
                        break;
                    }
                    Log.v(str, this.g[i6] + " = " + this.h[i6]);
                    i5 = i6 + 1;
                }
                Log.v(str, TypedValues.Custom.S_BOOLEAN);
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= this.l) {
                        return;
                    }
                    Log.v(str, this.j[i8] + " = " + this.k[i8]);
                    i7 = i8 + 1;
                }
            }
        }

        private ConstraintAttribute a(String str, ConstraintAttribute.AttributeType attributeType) {
            if (!this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute);
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
            if (constraintAttribute2.getType() == attributeType) {
                return constraintAttribute2;
            }
            throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute2.getType().name());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.f2268a = i;
            this.layout.leftToLeft = layoutParams.leftToLeft;
            this.layout.leftToRight = layoutParams.leftToRight;
            this.layout.rightToLeft = layoutParams.rightToLeft;
            this.layout.rightToRight = layoutParams.rightToRight;
            this.layout.topToTop = layoutParams.topToTop;
            this.layout.topToBottom = layoutParams.topToBottom;
            this.layout.bottomToTop = layoutParams.bottomToTop;
            this.layout.bottomToBottom = layoutParams.bottomToBottom;
            this.layout.baselineToBaseline = layoutParams.baselineToBaseline;
            this.layout.baselineToTop = layoutParams.baselineToTop;
            this.layout.baselineToBottom = layoutParams.baselineToBottom;
            this.layout.startToEnd = layoutParams.startToEnd;
            this.layout.startToStart = layoutParams.startToStart;
            this.layout.endToStart = layoutParams.endToStart;
            this.layout.endToEnd = layoutParams.endToEnd;
            this.layout.horizontalBias = layoutParams.horizontalBias;
            this.layout.verticalBias = layoutParams.verticalBias;
            this.layout.dimensionRatio = layoutParams.dimensionRatio;
            this.layout.circleConstraint = layoutParams.circleConstraint;
            this.layout.circleRadius = layoutParams.circleRadius;
            this.layout.circleAngle = layoutParams.circleAngle;
            this.layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.layout.orientation = layoutParams.orientation;
            this.layout.guidePercent = layoutParams.guidePercent;
            this.layout.guideBegin = layoutParams.guideBegin;
            this.layout.guideEnd = layoutParams.guideEnd;
            this.layout.mWidth = layoutParams.width;
            this.layout.mHeight = layoutParams.height;
            this.layout.leftMargin = layoutParams.leftMargin;
            this.layout.rightMargin = layoutParams.rightMargin;
            this.layout.topMargin = layoutParams.topMargin;
            this.layout.bottomMargin = layoutParams.bottomMargin;
            this.layout.baselineMargin = layoutParams.baselineMargin;
            this.layout.verticalWeight = layoutParams.verticalWeight;
            this.layout.horizontalWeight = layoutParams.horizontalWeight;
            this.layout.verticalChainStyle = layoutParams.verticalChainStyle;
            this.layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.layout.constrainedWidth = layoutParams.constrainedWidth;
            this.layout.constrainedHeight = layoutParams.constrainedHeight;
            this.layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            this.layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            this.layout.widthMax = layoutParams.matchConstraintMaxWidth;
            this.layout.heightMax = layoutParams.matchConstraintMaxHeight;
            this.layout.widthMin = layoutParams.matchConstraintMinWidth;
            this.layout.heightMin = layoutParams.matchConstraintMinHeight;
            this.layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            this.layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            this.layout.mConstraintTag = layoutParams.constraintTag;
            this.layout.goneTopMargin = layoutParams.goneTopMargin;
            this.layout.goneBottomMargin = layoutParams.goneBottomMargin;
            this.layout.goneLeftMargin = layoutParams.goneLeftMargin;
            this.layout.goneRightMargin = layoutParams.goneRightMargin;
            this.layout.goneStartMargin = layoutParams.goneStartMargin;
            this.layout.goneEndMargin = layoutParams.goneEndMargin;
            this.layout.goneBaselineMargin = layoutParams.goneBaselineMargin;
            this.layout.mWrapBehavior = layoutParams.wrapBehaviorInParent;
            if (Build.VERSION.SDK_INT >= 17) {
                this.layout.endMargin = layoutParams.getMarginEnd();
                this.layout.startMargin = layoutParams.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Constraints.LayoutParams layoutParams) {
            a(i, (ConstraintLayout.LayoutParams) layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            this.transform.rotation = layoutParams.rotation;
            this.transform.rotationX = layoutParams.rotationX;
            this.transform.rotationY = layoutParams.rotationY;
            this.transform.scaleX = layoutParams.scaleX;
            this.transform.scaleY = layoutParams.scaleY;
            this.transform.transformPivotX = layoutParams.transformPivotX;
            this.transform.transformPivotY = layoutParams.transformPivotY;
            this.transform.translationX = layoutParams.translationX;
            this.transform.translationY = layoutParams.translationY;
            this.transform.translationZ = layoutParams.translationZ;
            this.transform.elevation = layoutParams.elevation;
            this.transform.applyElevation = layoutParams.applyElevation;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            a(i, layoutParams);
            if (constraintHelper instanceof Barrier) {
                this.layout.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, float f) {
            a(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, int i) {
            a(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            a(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, int i) {
            a(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i);
        }

        public void applyDelta(Constraint constraint) {
            Delta delta = this.f2269c;
            if (delta != null) {
                delta.a(constraint);
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.leftToLeft = this.layout.leftToLeft;
            layoutParams.leftToRight = this.layout.leftToRight;
            layoutParams.rightToLeft = this.layout.rightToLeft;
            layoutParams.rightToRight = this.layout.rightToRight;
            layoutParams.topToTop = this.layout.topToTop;
            layoutParams.topToBottom = this.layout.topToBottom;
            layoutParams.bottomToTop = this.layout.bottomToTop;
            layoutParams.bottomToBottom = this.layout.bottomToBottom;
            layoutParams.baselineToBaseline = this.layout.baselineToBaseline;
            layoutParams.baselineToTop = this.layout.baselineToTop;
            layoutParams.baselineToBottom = this.layout.baselineToBottom;
            layoutParams.startToEnd = this.layout.startToEnd;
            layoutParams.startToStart = this.layout.startToStart;
            layoutParams.endToStart = this.layout.endToStart;
            layoutParams.endToEnd = this.layout.endToEnd;
            layoutParams.leftMargin = this.layout.leftMargin;
            layoutParams.rightMargin = this.layout.rightMargin;
            layoutParams.topMargin = this.layout.topMargin;
            layoutParams.bottomMargin = this.layout.bottomMargin;
            layoutParams.goneStartMargin = this.layout.goneStartMargin;
            layoutParams.goneEndMargin = this.layout.goneEndMargin;
            layoutParams.goneTopMargin = this.layout.goneTopMargin;
            layoutParams.goneBottomMargin = this.layout.goneBottomMargin;
            layoutParams.horizontalBias = this.layout.horizontalBias;
            layoutParams.verticalBias = this.layout.verticalBias;
            layoutParams.circleConstraint = this.layout.circleConstraint;
            layoutParams.circleRadius = this.layout.circleRadius;
            layoutParams.circleAngle = this.layout.circleAngle;
            layoutParams.dimensionRatio = this.layout.dimensionRatio;
            layoutParams.editorAbsoluteX = this.layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = this.layout.editorAbsoluteY;
            layoutParams.verticalWeight = this.layout.verticalWeight;
            layoutParams.horizontalWeight = this.layout.horizontalWeight;
            layoutParams.verticalChainStyle = this.layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = this.layout.horizontalChainStyle;
            layoutParams.constrainedWidth = this.layout.constrainedWidth;
            layoutParams.constrainedHeight = this.layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = this.layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = this.layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = this.layout.widthMax;
            layoutParams.matchConstraintMaxHeight = this.layout.heightMax;
            layoutParams.matchConstraintMinWidth = this.layout.widthMin;
            layoutParams.matchConstraintMinHeight = this.layout.heightMin;
            layoutParams.matchConstraintPercentWidth = this.layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = this.layout.heightPercent;
            layoutParams.orientation = this.layout.orientation;
            layoutParams.guidePercent = this.layout.guidePercent;
            layoutParams.guideBegin = this.layout.guideBegin;
            layoutParams.guideEnd = this.layout.guideEnd;
            layoutParams.width = this.layout.mWidth;
            layoutParams.height = this.layout.mHeight;
            if (this.layout.mConstraintTag != null) {
                layoutParams.constraintTag = this.layout.mConstraintTag;
            }
            layoutParams.wrapBehaviorInParent = this.layout.mWrapBehavior;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.layout.startMargin);
                layoutParams.setMarginEnd(this.layout.endMargin);
            }
            layoutParams.validate();
        }

        /* renamed from: clone */
        public Constraint m1387clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.f2268a = this.f2268a;
            constraint.f2269c = this.f2269c;
            return constraint;
        }

        public void printDelta(String str) {
            Delta delta = this.f2269c;
            if (delta != null) {
                delta.a(str);
            } else {
                Log.v(str, "DELTA IS NULL");
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$Layout.class */
    public static class Layout {
        public static final int UNSET = -1;
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2272a;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public boolean mOverride = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean guidelineUseRtl = true;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int baselineToTop = -1;
        public int baselineToBottom = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = 0;
        public int rightMargin = 0;
        public int topMargin = 0;
        public int bottomMargin = 0;
        public int endMargin = 0;
        public int startMargin = 0;
        public int baselineMargin = 0;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = 0;
        public int heightMax = 0;
        public int widthMin = 0;
        public int heightMin = 0;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mWrapBehavior = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2272a = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f2272a.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f2272a.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f2272a.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            f2272a.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            f2272a.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f2272a.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f2272a.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f2272a.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f2272a.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            f2272a.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            f2272a.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            f2272a.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            f2272a.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            f2272a.append(R.styleable.Layout_guidelineUseRtl, 90);
            f2272a.append(R.styleable.Layout_android_orientation, 26);
            f2272a.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            f2272a.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            f2272a.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f2272a.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f2272a.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            f2272a.append(R.styleable.Layout_layout_goneMarginTop, 16);
            f2272a.append(R.styleable.Layout_layout_goneMarginRight, 14);
            f2272a.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            f2272a.append(R.styleable.Layout_layout_goneMarginStart, 15);
            f2272a.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            f2272a.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            f2272a.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            f2272a.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f2272a.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f2272a.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            f2272a.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            f2272a.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            f2272a.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            f2272a.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            f2272a.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            f2272a.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            f2272a.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            f2272a.append(R.styleable.Layout_android_layout_marginLeft, 23);
            f2272a.append(R.styleable.Layout_android_layout_marginRight, 27);
            f2272a.append(R.styleable.Layout_android_layout_marginStart, 30);
            f2272a.append(R.styleable.Layout_android_layout_marginEnd, 8);
            f2272a.append(R.styleable.Layout_android_layout_marginTop, 33);
            f2272a.append(R.styleable.Layout_android_layout_marginBottom, 2);
            f2272a.append(R.styleable.Layout_android_layout_width, 22);
            f2272a.append(R.styleable.Layout_android_layout_height, 21);
            f2272a.append(R.styleable.Layout_layout_constraintWidth, 41);
            f2272a.append(R.styleable.Layout_layout_constraintHeight, 42);
            f2272a.append(R.styleable.Layout_layout_constrainedWidth, 41);
            f2272a.append(R.styleable.Layout_layout_constrainedHeight, 42);
            f2272a.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            f2272a.append(R.styleable.Layout_layout_constraintCircle, 61);
            f2272a.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            f2272a.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            f2272a.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            f2272a.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            f2272a.append(R.styleable.Layout_chainUseRtl, 71);
            f2272a.append(R.styleable.Layout_barrierDirection, 72);
            f2272a.append(R.styleable.Layout_barrierMargin, 73);
            f2272a.append(R.styleable.Layout_constraint_referenced_ids, 74);
            f2272a.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    obtainStyledAttributes.recycle();
                    return;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = f2272a.get(index);
                switch (i3) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.b(obtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.b(obtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.b(obtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT < 17) {
                            break;
                        } else {
                            this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                            break;
                        }
                    case 9:
                        this.endToEnd = ConstraintSet.b(obtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.b(obtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.b(obtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.b(obtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.b(obtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.b(obtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        if (Build.VERSION.SDK_INT < 17) {
                            break;
                        } else {
                            this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                            break;
                        }
                    case 31:
                        this.startToEnd = ConstraintSet.b(obtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.b(obtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.b(obtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.b(obtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    case 41:
                        ConstraintSet.a(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.a(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i3) {
                            case 61:
                                this.circleConstraint = ConstraintSet.b(obtainStyledAttributes, index, this.circleConstraint);
                                continue;
                            case 62:
                                this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                continue;
                            case 63:
                                this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                continue;
                            default:
                                switch (i3) {
                                    case 69:
                                        this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 70:
                                        this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        continue;
                                    case 72:
                                        this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                        continue;
                                    case 73:
                                        this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                        continue;
                                    case 74:
                                        this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                        continue;
                                    case 76:
                                        this.mWrapBehavior = obtainStyledAttributes.getInt(index, this.mWrapBehavior);
                                        continue;
                                    case 77:
                                        this.baselineToTop = ConstraintSet.b(obtainStyledAttributes, index, this.baselineToTop);
                                        continue;
                                    case 78:
                                        this.baselineToBottom = ConstraintSet.b(obtainStyledAttributes, index, this.baselineToBottom);
                                        continue;
                                    case 79:
                                        this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                        continue;
                                    case 80:
                                        this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                        continue;
                                    case 81:
                                        this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                        continue;
                                    case 82:
                                        this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                        continue;
                                    case 83:
                                        this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        continue;
                                    case 84:
                                        this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        continue;
                                    case 85:
                                        this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        continue;
                                    case 86:
                                        this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        continue;
                                    case 87:
                                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                                        continue;
                                    case 88:
                                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                                        continue;
                                    case 89:
                                        this.mConstraintTag = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        continue;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2272a.get(index));
                                        continue;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f2272a.get(index));
                                        continue;
                                        continue;
                                }
                        }
                }
                i = i2 + 1;
            }
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.guidelineUseRtl = layout.guidelineUseRtl;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.baselineToTop = layout.baselineToTop;
            this.baselineToBottom = layout.baselineToBottom;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.baselineMargin = layout.baselineMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.goneBaselineMargin = layout.goneBaselineMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr == null || layout.mReferenceIdString != null) {
                this.mReferenceIds = null;
            } else {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = layout.mWrapBehavior;
        }

        public void dump(MotionScene motionScene, StringBuilder sb) {
            Field[] declaredFields = getClass().getDeclaredFields();
            sb.append("\n");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= declaredFields.length) {
                    return;
                }
                Field field = declaredFields[i2];
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                String lookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                Object obj2 = num;
                                if (lookUpConstraintName != null) {
                                    obj2 = lookUpConstraintName;
                                }
                                sb.append((Object) obj2);
                                sb.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f = (Float) obj;
                            if (f.floatValue() != -1.0f) {
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(f);
                                sb.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$Motion.class */
    public static class Motion {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2273a;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2273a = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            f2273a.append(R.styleable.Motion_pathMotionArc, 2);
            f2273a.append(R.styleable.Motion_transitionEasing, 3);
            f2273a.append(R.styleable.Motion_drawPath, 4);
            f2273a.append(R.styleable.Motion_animateRelativeTo, 5);
            f2273a.append(R.styleable.Motion_animateCircleAngleTo, 6);
            f2273a.append(R.styleable.Motion_motionStagger, 7);
            f2273a.append(R.styleable.Motion_quantizeMotionSteps, 8);
            f2273a.append(R.styleable.Motion_quantizeMotionPhase, 9);
            f2273a.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    obtainStyledAttributes.recycle();
                    return;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f2273a.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type != 3) {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        } else {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.b(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                        if (peekValue.type != 1) {
                            if (peekValue.type != 3) {
                                this.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                                break;
                            } else {
                                String string = obtainStyledAttributes.getString(index);
                                this.mQuantizeInterpolatorString = string;
                                if (string.indexOf(BridgeUtil.SPLIT_MARK) <= 0) {
                                    this.mQuantizeInterpolatorType = -1;
                                    break;
                                } else {
                                    this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                    this.mQuantizeInterpolatorType = -2;
                                    break;
                                }
                            }
                        } else {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId == -1) {
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                }
                i = i2 + 1;
            }
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
            this.mPolarRelativeTo = motion.mPolarRelativeTo;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$PropertySet.class */
    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    obtainStyledAttributes.recycle();
                    return;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.d[this.visibility];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
                i = i2 + 1;
            }
        }

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$Transform.class */
    public static class Transform {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2274a;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public int transformPivotTarget = -1;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2274a = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            f2274a.append(R.styleable.Transform_android_rotationX, 2);
            f2274a.append(R.styleable.Transform_android_rotationY, 3);
            f2274a.append(R.styleable.Transform_android_scaleX, 4);
            f2274a.append(R.styleable.Transform_android_scaleY, 5);
            f2274a.append(R.styleable.Transform_android_transformPivotX, 6);
            f2274a.append(R.styleable.Transform_android_transformPivotY, 7);
            f2274a.append(R.styleable.Transform_android_translationX, 8);
            f2274a.append(R.styleable.Transform_android_translationY, 9);
            f2274a.append(R.styleable.Transform_android_translationZ, 10);
            f2274a.append(R.styleable.Transform_android_elevation, 11);
            f2274a.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    obtainStyledAttributes.recycle();
                    return;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f2274a.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.applyElevation = true;
                            this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                            break;
                        }
                    case 12:
                        this.transformPivotTarget = ConstraintSet.b(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
                i = i2 + 1;
            }
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.transformPivotTarget = transform.transformPivotTarget;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$WriteJsonEngine.class */
    class WriteJsonEngine {

        /* renamed from: a  reason: collision with root package name */
        Writer f2275a;
        ConstraintLayout b;

        /* renamed from: c  reason: collision with root package name */
        Context f2276c;
        int d;
        int e = 0;
        final String f = "'left'";
        final String g = "'right'";
        final String h = "'baseline'";
        final String i = "'bottom'";
        final String j = "'top'";
        final String k = "'start'";
        final String l = "'end'";
        HashMap<Integer, String> m = new HashMap<>();

        WriteJsonEngine(Writer writer, ConstraintLayout constraintLayout, int i) throws IOException {
            this.f2275a = writer;
            this.b = constraintLayout;
            this.f2276c = constraintLayout.getContext();
            this.d = i;
        }

        private void a(int i, int i2, int i3, float f) {
        }

        private void a(String str, int i, int i2, float f, int i3, int i4, boolean z) throws IOException {
            if (i != 0) {
                if (i == -2) {
                    Writer writer = this.f2275a;
                    writer.write("       " + str + ": 'wrap'\n");
                } else if (i == -1) {
                    Writer writer2 = this.f2275a;
                    writer2.write("       " + str + ": 'parent'\n");
                } else {
                    Writer writer3 = this.f2275a;
                    writer3.write("       " + str + ": " + i + ",\n");
                }
            } else if (i4 == -1 && i3 == -1) {
                if (i2 == 1) {
                    Writer writer4 = this.f2275a;
                    writer4.write("       " + str + ": '???????????',\n");
                } else if (i2 != 2) {
                } else {
                    Writer writer5 = this.f2275a;
                    writer5.write("       " + str + ": '" + f + "%',\n");
                }
            } else if (i2 == 0) {
                Writer writer6 = this.f2275a;
                writer6.write("       " + str + ": {'spread' ," + i3 + ", " + i4 + "}\n");
            } else if (i2 == 1) {
                Writer writer7 = this.f2275a;
                writer7.write("       " + str + ": {'wrap' ," + i3 + ", " + i4 + "}\n");
            } else if (i2 != 2) {
            } else {
                Writer writer8 = this.f2275a;
                writer8.write("       " + str + ": {'" + f + "'% ," + i3 + ", " + i4 + "}\n");
            }
        }

        String a(int i) {
            if (this.m.containsKey(Integer.valueOf(i))) {
                return "'" + this.m.get(Integer.valueOf(i)) + "'";
            } else if (i == 0) {
                return "'parent'";
            } else {
                String b = b(i);
                this.m.put(Integer.valueOf(i), b);
                return "'" + b + "'";
            }
        }

        void a() throws IOException {
            this.f2275a.write("\n'ConstraintSet':{\n");
            for (Integer num : ConstraintSet.this.e.keySet()) {
                Constraint constraint = (Constraint) ConstraintSet.this.e.get(num);
                String a2 = a(num.intValue());
                Writer writer = this.f2275a;
                writer.write(a2 + ":{\n");
                Layout layout = constraint.layout;
                a("height", layout.mHeight, layout.heightDefault, layout.heightPercent, layout.heightMin, layout.heightMax, layout.constrainedHeight);
                a("width", layout.mWidth, layout.widthDefault, layout.widthPercent, layout.widthMin, layout.widthMax, layout.constrainedWidth);
                a("'left'", layout.leftToLeft, "'left'", layout.leftMargin, layout.goneLeftMargin);
                a("'left'", layout.leftToRight, "'right'", layout.leftMargin, layout.goneLeftMargin);
                a("'right'", layout.rightToLeft, "'left'", layout.rightMargin, layout.goneRightMargin);
                a("'right'", layout.rightToRight, "'right'", layout.rightMargin, layout.goneRightMargin);
                a("'baseline'", layout.baselineToBaseline, "'baseline'", -1, layout.goneBaselineMargin);
                a("'baseline'", layout.baselineToTop, "'top'", -1, layout.goneBaselineMargin);
                a("'baseline'", layout.baselineToBottom, "'bottom'", -1, layout.goneBaselineMargin);
                a("'top'", layout.topToBottom, "'bottom'", layout.topMargin, layout.goneTopMargin);
                a("'top'", layout.topToTop, "'top'", layout.topMargin, layout.goneTopMargin);
                a("'bottom'", layout.bottomToBottom, "'bottom'", layout.bottomMargin, layout.goneBottomMargin);
                a("'bottom'", layout.bottomToTop, "'top'", layout.bottomMargin, layout.goneBottomMargin);
                a("'start'", layout.startToStart, "'start'", layout.startMargin, layout.goneStartMargin);
                a("'start'", layout.startToEnd, "'end'", layout.startMargin, layout.goneStartMargin);
                a("'end'", layout.endToStart, "'start'", layout.endMargin, layout.goneEndMargin);
                a("'end'", layout.endToEnd, "'end'", layout.endMargin, layout.goneEndMargin);
                a("'horizontalBias'", layout.horizontalBias, 0.5f);
                a("'verticalBias'", layout.verticalBias, 0.5f);
                a(layout.circleConstraint, layout.circleAngle, layout.circleRadius);
                a(layout.orientation, layout.guideBegin, layout.guideEnd, layout.guidePercent);
                a("'dimensionRatio'", layout.dimensionRatio);
                a("'barrierMargin'", layout.mBarrierMargin);
                a("'type'", layout.mHelperType);
                a("'ReferenceId'", layout.mReferenceIdString);
                a("'mBarrierAllowsGoneWidgets'", layout.mBarrierAllowsGoneWidgets, true);
                a("'WrapBehavior'", layout.mWrapBehavior);
                a("'verticalWeight'", layout.verticalWeight);
                a("'horizontalWeight'", layout.horizontalWeight);
                a("'horizontalChainStyle'", layout.horizontalChainStyle);
                a("'verticalChainStyle'", layout.verticalChainStyle);
                a("'barrierDirection'", layout.mBarrierDirection);
                if (layout.mReferenceIds != null) {
                    a("'ReferenceIds'", layout.mReferenceIds);
                }
                this.f2275a.write("}\n");
            }
            this.f2275a.write("}\n");
        }

        void a(int i, float f, int i2) throws IOException {
            if (i == -1) {
                return;
            }
            this.f2275a.write("       circle");
            this.f2275a.write(":[");
            this.f2275a.write(a(i));
            Writer writer = this.f2275a;
            writer.write(", " + f);
            Writer writer2 = this.f2275a;
            writer2.write(i2 + "]");
        }

        void a(String str, float f) throws IOException {
            if (f == -1.0f) {
                return;
            }
            Writer writer = this.f2275a;
            writer.write("       " + str);
            Writer writer2 = this.f2275a;
            writer2.write(": " + f);
            this.f2275a.write(",\n");
        }

        void a(String str, float f, float f2) throws IOException {
            if (f == f2) {
                return;
            }
            Writer writer = this.f2275a;
            writer.write("       " + str);
            Writer writer2 = this.f2275a;
            writer2.write(": " + f);
            this.f2275a.write(",\n");
        }

        void a(String str, int i) throws IOException {
            if (i == 0 || i == -1) {
                return;
            }
            Writer writer = this.f2275a;
            writer.write("       " + str);
            this.f2275a.write(":");
            Writer writer2 = this.f2275a;
            writer2.write(", " + i);
            this.f2275a.write("\n");
        }

        void a(String str, int i, String str2, int i2, int i3) throws IOException {
            if (i == -1) {
                return;
            }
            Writer writer = this.f2275a;
            writer.write("       " + str);
            this.f2275a.write(":[");
            this.f2275a.write(a(i));
            this.f2275a.write(" , ");
            this.f2275a.write(str2);
            if (i2 != 0) {
                Writer writer2 = this.f2275a;
                writer2.write(" , " + i2);
            }
            this.f2275a.write("],\n");
        }

        void a(String str, String str2) throws IOException {
            if (str2 == null) {
                return;
            }
            Writer writer = this.f2275a;
            writer.write("       " + str);
            this.f2275a.write(":");
            Writer writer2 = this.f2275a;
            writer2.write(", " + str2);
            this.f2275a.write("\n");
        }

        void a(String str, boolean z, boolean z2) throws IOException {
            if (z == z2) {
                return;
            }
            Writer writer = this.f2275a;
            writer.write("       " + str);
            Writer writer2 = this.f2275a;
            writer2.write(": " + z);
            this.f2275a.write(",\n");
        }

        void a(String str, int[] iArr) throws IOException {
            if (iArr == null) {
                return;
            }
            Writer writer = this.f2275a;
            writer.write("       " + str);
            this.f2275a.write(": ");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iArr.length) {
                    this.f2275a.write("],\n");
                    return;
                }
                Writer writer2 = this.f2275a;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "[" : ", ");
                sb.append(a(iArr[i2]));
                writer2.write(sb.toString());
                i = i2 + 1;
            }
        }

        String b(int i) {
            try {
                if (i != -1) {
                    return this.f2276c.getResources().getResourceEntryName(i);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unknown");
                int i2 = this.e + 1;
                this.e = i2;
                sb.append(i2);
                return sb.toString();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i3 = this.e + 1;
                this.e = i3;
                sb2.append(i3);
                return sb2.toString();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintSet$WriteXmlEngine.class */
    class WriteXmlEngine {

        /* renamed from: a  reason: collision with root package name */
        Writer f2277a;
        ConstraintLayout b;

        /* renamed from: c  reason: collision with root package name */
        Context f2278c;
        int d;
        int e = 0;
        final String f = "'left'";
        final String g = "'right'";
        final String h = "'baseline'";
        final String i = "'bottom'";
        final String j = "'top'";
        final String k = "'start'";
        final String l = "'end'";
        HashMap<Integer, String> m = new HashMap<>();

        WriteXmlEngine(Writer writer, ConstraintLayout constraintLayout, int i) throws IOException {
            this.f2277a = writer;
            this.b = constraintLayout;
            this.f2278c = constraintLayout.getContext();
            this.d = i;
        }

        private void a(String str, int i, int i2) throws IOException {
            if (i != i2) {
                Writer writer = this.f2277a;
                writer.write("\n       " + str + "=\"" + i + "dp\"");
            }
        }

        private void a(String str, int i, String[] strArr, int i2) throws IOException {
            if (i != i2) {
                Writer writer = this.f2277a;
                writer.write("\n       " + str + "=\"" + strArr[i] + "\"");
            }
        }

        private void a(String str, boolean z, boolean z2) throws IOException {
            if (z != z2) {
                Writer writer = this.f2277a;
                writer.write("\n       " + str + "=\"" + z + "dp\"");
            }
        }

        private void b(String str, int i, int i2) throws IOException {
            if (i != i2) {
                if (i == -2) {
                    Writer writer = this.f2277a;
                    writer.write("\n       " + str + "=\"wrap_content\"");
                } else if (i == -1) {
                    Writer writer2 = this.f2277a;
                    writer2.write("\n       " + str + "=\"match_parent\"");
                } else {
                    Writer writer3 = this.f2277a;
                    writer3.write("\n       " + str + "=\"" + i + "dp\"");
                }
            }
        }

        String a(int i) {
            if (this.m.containsKey(Integer.valueOf(i))) {
                return "@+id/" + this.m.get(Integer.valueOf(i)) + "";
            } else if (i == 0) {
                return "parent";
            } else {
                String b = b(i);
                this.m.put(Integer.valueOf(i), b);
                return "@+id/" + b + "";
            }
        }

        void a() throws IOException {
            this.f2277a.write("\n<ConstraintSet>\n");
            for (Integer num : ConstraintSet.this.e.keySet()) {
                Constraint constraint = (Constraint) ConstraintSet.this.e.get(num);
                String a2 = a(num.intValue());
                this.f2277a.write("  <Constraint");
                Writer writer = this.f2277a;
                writer.write("\n       android:id=\"" + a2 + "\"");
                Layout layout = constraint.layout;
                b("android:layout_width", layout.mWidth, -5);
                b("android:layout_height", layout.mHeight, -5);
                a("app:layout_constraintGuide_begin", (float) layout.guideBegin, -1.0f);
                a("app:layout_constraintGuide_end", layout.guideEnd, -1.0f);
                a("app:layout_constraintGuide_percent", layout.guidePercent, -1.0f);
                a("app:layout_constraintHorizontal_bias", layout.horizontalBias, 0.5f);
                a("app:layout_constraintVertical_bias", layout.verticalBias, 0.5f);
                a("app:layout_constraintDimensionRatio", layout.dimensionRatio, (String) null);
                a("app:layout_constraintCircle", layout.circleConstraint);
                a("app:layout_constraintCircleRadius", layout.circleRadius, 0.0f);
                a("app:layout_constraintCircleAngle", layout.circleAngle, 0.0f);
                a("android:orientation", layout.orientation, -1.0f);
                a("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                a("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                a("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle, 0.0f);
                a("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle, 0.0f);
                a("app:barrierDirection", layout.mBarrierDirection, -1.0f);
                a("app:barrierMargin", layout.mBarrierMargin, 0.0f);
                a("app:layout_marginLeft", layout.leftMargin, 0);
                a("app:layout_goneMarginLeft", layout.goneLeftMargin, Integer.MIN_VALUE);
                a("app:layout_marginRight", layout.rightMargin, 0);
                a("app:layout_goneMarginRight", layout.goneRightMargin, Integer.MIN_VALUE);
                a("app:layout_marginStart", layout.startMargin, 0);
                a("app:layout_goneMarginStart", layout.goneStartMargin, Integer.MIN_VALUE);
                a("app:layout_marginEnd", layout.endMargin, 0);
                a("app:layout_goneMarginEnd", layout.goneEndMargin, Integer.MIN_VALUE);
                a("app:layout_marginTop", layout.topMargin, 0);
                a("app:layout_goneMarginTop", layout.goneTopMargin, Integer.MIN_VALUE);
                a("app:layout_marginBottom", layout.bottomMargin, 0);
                a("app:layout_goneMarginBottom", layout.goneBottomMargin, Integer.MIN_VALUE);
                a("app:goneBaselineMargin", layout.goneBaselineMargin, Integer.MIN_VALUE);
                a("app:baselineMargin", layout.baselineMargin, 0);
                a("app:layout_constrainedWidth", layout.constrainedWidth, false);
                a("app:layout_constrainedHeight", layout.constrainedHeight, false);
                a("app:barrierAllowsGoneWidgets", layout.mBarrierAllowsGoneWidgets, true);
                a("app:layout_wrapBehaviorInParent", layout.mWrapBehavior, 0.0f);
                a("app:baselineToBaseline", layout.baselineToBaseline);
                a("app:baselineToBottom", layout.baselineToBottom);
                a("app:baselineToTop", layout.baselineToTop);
                a("app:layout_constraintBottom_toBottomOf", layout.bottomToBottom);
                a("app:layout_constraintBottom_toTopOf", layout.bottomToTop);
                a("app:layout_constraintEnd_toEndOf", layout.endToEnd);
                a("app:layout_constraintEnd_toStartOf", layout.endToStart);
                a("app:layout_constraintLeft_toLeftOf", layout.leftToLeft);
                a("app:layout_constraintLeft_toRightOf", layout.leftToRight);
                a("app:layout_constraintRight_toLeftOf", layout.rightToLeft);
                a("app:layout_constraintRight_toRightOf", layout.rightToRight);
                a("app:layout_constraintStart_toEndOf", layout.startToEnd);
                a("app:layout_constraintStart_toStartOf", layout.startToStart);
                a("app:layout_constraintTop_toBottomOf", layout.topToBottom);
                a("app:layout_constraintTop_toTopOf", layout.topToTop);
                String[] strArr = {"spread", "wrap", "percent"};
                a("app:layout_constraintHeight_default", layout.heightDefault, strArr, 0);
                a("app:layout_constraintHeight_percent", layout.heightPercent, 1.0f);
                a("app:layout_constraintHeight_min", layout.heightMin, 0);
                a("app:layout_constraintHeight_max", layout.heightMax, 0);
                a("android:layout_constrainedHeight", layout.constrainedHeight, false);
                a("app:layout_constraintWidth_default", layout.widthDefault, strArr, 0);
                a("app:layout_constraintWidth_percent", layout.widthPercent, 1.0f);
                a("app:layout_constraintWidth_min", layout.widthMin, 0);
                a("app:layout_constraintWidth_max", layout.widthMax, 0);
                a("android:layout_constrainedWidth", layout.constrainedWidth, false);
                a("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                a("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                b("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle);
                b("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle);
                a("app:barrierDirection", layout.mBarrierDirection, new String[]{"left", "right", Constant.MAP_KEY_TOP, "bottom", "start", "end"}, -1);
                a("app:layout_constraintTag", layout.mConstraintTag, (String) null);
                if (layout.mReferenceIds != null) {
                    a("'ReferenceIds'", layout.mReferenceIds);
                }
                this.f2277a.write(" />\n");
            }
            this.f2277a.write("</ConstraintSet>\n");
        }

        void a(String str, float f, float f2) throws IOException {
            if (f == f2) {
                return;
            }
            Writer writer = this.f2277a;
            writer.write("\n       " + str);
            Writer writer2 = this.f2277a;
            writer2.write("=\"" + f + "\"");
        }

        void a(String str, int i) throws IOException {
            if (i == -1) {
                return;
            }
            Writer writer = this.f2277a;
            writer.write("\n       " + str);
            Writer writer2 = this.f2277a;
            writer2.write("=\"" + a(i) + "\"");
        }

        void a(String str, String str2, String str3) throws IOException {
            if (str2 == null || str2.equals(str3)) {
                return;
            }
            Writer writer = this.f2277a;
            writer.write("\n       " + str);
            Writer writer2 = this.f2277a;
            writer2.write("=\"" + str2 + "\"");
        }

        void a(String str, int[] iArr) throws IOException {
            if (iArr == null) {
                return;
            }
            Writer writer = this.f2277a;
            writer.write("\n       " + str);
            this.f2277a.write(":");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= iArr.length) {
                    this.f2277a.write("],\n");
                    return;
                }
                Writer writer2 = this.f2277a;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "[" : ", ");
                sb.append(a(iArr[i2]));
                writer2.write(sb.toString());
                i = i2 + 1;
            }
        }

        String b(int i) {
            try {
                if (i != -1) {
                    return this.f2278c.getResources().getResourceEntryName(i);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unknown");
                int i2 = this.e + 1;
                this.e = i2;
                sb.append(i2);
                return sb.toString();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i3 = this.e + 1;
                this.e = i3;
                sb2.append(i3);
                return sb2.toString();
            }
        }

        void b(String str, int i) throws IOException {
            if (i == 0 || i == -1) {
                return;
            }
            Writer writer = this.f2277a;
            writer.write("\n       " + str + "=\"" + i + "\"\n");
        }
    }

    static {
        f.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        f.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        f.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        f.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        f.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        f.append(R.styleable.Constraint_guidelineUseRtl, 99);
        f.append(R.styleable.Constraint_android_orientation, 27);
        f.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        f.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        f.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        f.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        f.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        f.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        f.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        f.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        f.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        f.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        f.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        f.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        f.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        f.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        f.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        f.append(R.styleable.Constraint_android_layout_marginRight, 28);
        f.append(R.styleable.Constraint_android_layout_marginStart, 31);
        f.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        f.append(R.styleable.Constraint_android_layout_marginTop, 34);
        f.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        f.append(R.styleable.Constraint_android_layout_width, 23);
        f.append(R.styleable.Constraint_android_layout_height, 21);
        f.append(R.styleable.Constraint_layout_constraintWidth, 95);
        f.append(R.styleable.Constraint_layout_constraintHeight, 96);
        f.append(R.styleable.Constraint_android_visibility, 22);
        f.append(R.styleable.Constraint_android_alpha, 43);
        f.append(R.styleable.Constraint_android_elevation, 44);
        f.append(R.styleable.Constraint_android_rotationX, 45);
        f.append(R.styleable.Constraint_android_rotationY, 46);
        f.append(R.styleable.Constraint_android_rotation, 60);
        f.append(R.styleable.Constraint_android_scaleX, 47);
        f.append(R.styleable.Constraint_android_scaleY, 48);
        f.append(R.styleable.Constraint_android_transformPivotX, 49);
        f.append(R.styleable.Constraint_android_transformPivotY, 50);
        f.append(R.styleable.Constraint_android_translationX, 51);
        f.append(R.styleable.Constraint_android_translationY, 52);
        f.append(R.styleable.Constraint_android_translationZ, 53);
        f.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        f.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        f.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        f.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        f.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        f.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        f.append(R.styleable.Constraint_layout_constraintCircle, 61);
        f.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        f.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        f.append(R.styleable.Constraint_animateRelativeTo, 64);
        f.append(R.styleable.Constraint_transitionEasing, 65);
        f.append(R.styleable.Constraint_drawPath, 66);
        f.append(R.styleable.Constraint_transitionPathRotate, 67);
        f.append(R.styleable.Constraint_motionStagger, 79);
        f.append(R.styleable.Constraint_android_id, 38);
        f.append(R.styleable.Constraint_motionProgress, 68);
        f.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        f.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        f.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f.append(R.styleable.Constraint_chainUseRtl, 71);
        f.append(R.styleable.Constraint_barrierDirection, 72);
        f.append(R.styleable.Constraint_barrierMargin, 73);
        f.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        f.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f.append(R.styleable.Constraint_pathMotionArc, 76);
        f.append(R.styleable.Constraint_layout_constraintTag, 77);
        f.append(R.styleable.Constraint_visibilityMode, 78);
        f.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        f.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        f.append(R.styleable.Constraint_polarRelativeTo, 82);
        f.append(R.styleable.Constraint_transformPivotTarget, 83);
        f.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        f.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        f.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        g.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        g.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        g.append(R.styleable.ConstraintOverride_android_orientation, 27);
        g.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        g.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        g.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        g.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        g.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        g.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        g.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        g.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        g.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        g.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        g.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        g.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        g.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        g.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        g.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        g.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        g.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        g.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        g.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        g.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        g.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        g.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        g.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        g.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        g.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        g.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        g.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        g.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        g.append(R.styleable.ConstraintOverride_android_visibility, 22);
        g.append(R.styleable.ConstraintOverride_android_alpha, 43);
        g.append(R.styleable.ConstraintOverride_android_elevation, 44);
        g.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        g.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        g.append(R.styleable.ConstraintOverride_android_rotation, 60);
        g.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        g.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        g.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        g.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        g.append(R.styleable.ConstraintOverride_android_translationX, 51);
        g.append(R.styleable.ConstraintOverride_android_translationY, 52);
        g.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        g.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        g.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        g.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        g.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        g.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        g.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        g.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        g.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        g.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        g.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        g.append(R.styleable.ConstraintOverride_drawPath, 66);
        g.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        g.append(R.styleable.ConstraintOverride_motionStagger, 79);
        g.append(R.styleable.ConstraintOverride_android_id, 38);
        g.append(R.styleable.ConstraintOverride_motionTarget, 98);
        g.append(R.styleable.ConstraintOverride_motionProgress, 68);
        g.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        g.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        g.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        g.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        g.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        g.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        g.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        g.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        g.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        g.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        g.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        g.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        g.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        g.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        g.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        g.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        g.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        g.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    private Constraint a(int i) {
        if (!this.e.containsKey(Integer.valueOf(i))) {
            this.e.put(Integer.valueOf(i), new Constraint());
        }
        return this.e.get(Integer.valueOf(i));
    }

    private Constraint a(Context context, AttributeSet attributeSet, boolean z) {
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        a(context, constraint, obtainStyledAttributes, z);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    private void a(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            a(iArr[0]).layout.horizontalWeight = fArr[0];
        }
        a(iArr[0]).layout.horizontalChainStyle = i5;
        connect(iArr[0], i6, i, i2, -1);
        int i8 = 1;
        while (true) {
            int i9 = i8;
            if (i9 >= iArr.length) {
                connect(iArr[iArr.length - 1], i7, i3, i4, -1);
                return;
            }
            int i10 = iArr[i9];
            int i11 = i9 - 1;
            connect(iArr[i9], i6, iArr[i11], i7, -1);
            connect(iArr[i11], i7, iArr[i9], i6, -1);
            if (fArr != null) {
                a(iArr[i9]).layout.horizontalWeight = fArr[i9];
            }
            i8 = i9 + 1;
        }
    }

    private static void a(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.f2269c = delta;
        constraint.motion.mApply = false;
        constraint.layout.mApply = false;
        constraint.propertySet.mApply = false;
        constraint.transform.mApply = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                return;
            }
            int index = typedArray.getIndex(i2);
            switch (g.get(index)) {
                case 2:
                    delta.a(2, typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f.get(index));
                    break;
                case 5:
                    delta.a(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.a(6, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.a(7, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY));
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        delta.a(8, typedArray.getDimensionPixelSize(index, constraint.layout.endMargin));
                        break;
                    }
                case 11:
                    delta.a(11, typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.a(12, typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin));
                    break;
                case 13:
                    delta.a(13, typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.a(14, typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin));
                    break;
                case 15:
                    delta.a(15, typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin));
                    break;
                case 16:
                    delta.a(16, typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin));
                    break;
                case 17:
                    delta.a(17, typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin));
                    break;
                case 18:
                    delta.a(18, typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd));
                    break;
                case 19:
                    delta.a(19, typedArray.getFloat(index, constraint.layout.guidePercent));
                    break;
                case 20:
                    delta.a(20, typedArray.getFloat(index, constraint.layout.horizontalBias));
                    break;
                case 21:
                    delta.a(21, typedArray.getLayoutDimension(index, constraint.layout.mHeight));
                    break;
                case 22:
                    delta.a(22, d[typedArray.getInt(index, constraint.propertySet.visibility)]);
                    break;
                case 23:
                    delta.a(23, typedArray.getLayoutDimension(index, constraint.layout.mWidth));
                    break;
                case 24:
                    delta.a(24, typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin));
                    break;
                case 27:
                    delta.a(27, typedArray.getInt(index, constraint.layout.orientation));
                    break;
                case 28:
                    delta.a(28, typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin));
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        delta.a(31, typedArray.getDimensionPixelSize(index, constraint.layout.startMargin));
                        break;
                    }
                case 34:
                    delta.a(34, typedArray.getDimensionPixelSize(index, constraint.layout.topMargin));
                    break;
                case 37:
                    delta.a(37, typedArray.getFloat(index, constraint.layout.verticalBias));
                    break;
                case 38:
                    constraint.f2268a = typedArray.getResourceId(index, constraint.f2268a);
                    delta.a(38, constraint.f2268a);
                    break;
                case 39:
                    delta.a(39, typedArray.getFloat(index, constraint.layout.horizontalWeight));
                    break;
                case 40:
                    delta.a(40, typedArray.getFloat(index, constraint.layout.verticalWeight));
                    break;
                case 41:
                    delta.a(41, typedArray.getInt(index, constraint.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.a(42, typedArray.getInt(index, constraint.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.a(43, typedArray.getFloat(index, constraint.propertySet.alpha));
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        delta.a(44, true);
                        delta.a(44, typedArray.getDimension(index, constraint.transform.elevation));
                        break;
                    }
                case 45:
                    delta.a(45, typedArray.getFloat(index, constraint.transform.rotationX));
                    break;
                case 46:
                    delta.a(46, typedArray.getFloat(index, constraint.transform.rotationY));
                    break;
                case 47:
                    delta.a(47, typedArray.getFloat(index, constraint.transform.scaleX));
                    break;
                case 48:
                    delta.a(48, typedArray.getFloat(index, constraint.transform.scaleY));
                    break;
                case 49:
                    delta.a(49, typedArray.getDimension(index, constraint.transform.transformPivotX));
                    break;
                case 50:
                    delta.a(50, typedArray.getDimension(index, constraint.transform.transformPivotY));
                    break;
                case 51:
                    delta.a(51, typedArray.getDimension(index, constraint.transform.translationX));
                    break;
                case 52:
                    delta.a(52, typedArray.getDimension(index, constraint.transform.translationY));
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        delta.a(53, typedArray.getDimension(index, constraint.transform.translationZ));
                        break;
                    }
                case 54:
                    delta.a(54, typedArray.getInt(index, constraint.layout.widthDefault));
                    break;
                case 55:
                    delta.a(55, typedArray.getInt(index, constraint.layout.heightDefault));
                    break;
                case 56:
                    delta.a(56, typedArray.getDimensionPixelSize(index, constraint.layout.widthMax));
                    break;
                case 57:
                    delta.a(57, typedArray.getDimensionPixelSize(index, constraint.layout.heightMax));
                    break;
                case 58:
                    delta.a(58, typedArray.getDimensionPixelSize(index, constraint.layout.widthMin));
                    break;
                case 59:
                    delta.a(59, typedArray.getDimensionPixelSize(index, constraint.layout.heightMin));
                    break;
                case 60:
                    delta.a(60, typedArray.getFloat(index, constraint.transform.rotation));
                    break;
                case 62:
                    delta.a(62, typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius));
                    break;
                case 63:
                    delta.a(63, typedArray.getFloat(index, constraint.layout.circleAngle));
                    break;
                case 64:
                    delta.a(64, b(typedArray, index, constraint.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        delta.a(65, Easing.NAMED_EASING[typedArray.getInteger(index, 0)]);
                        break;
                    } else {
                        delta.a(65, typedArray.getString(index));
                        break;
                    }
                case 66:
                    delta.a(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.a(67, typedArray.getFloat(index, constraint.motion.mPathRotate));
                    break;
                case 68:
                    delta.a(68, typedArray.getFloat(index, constraint.propertySet.mProgress));
                    break;
                case 69:
                    delta.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    delta.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    delta.a(72, typedArray.getInt(index, constraint.layout.mBarrierDirection));
                    break;
                case 73:
                    delta.a(73, typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin));
                    break;
                case 74:
                    delta.a(74, typedArray.getString(index));
                    break;
                case 75:
                    delta.a(75, typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.a(76, typedArray.getInt(index, constraint.motion.mPathMotionArc));
                    break;
                case 77:
                    delta.a(77, typedArray.getString(index));
                    break;
                case 78:
                    delta.a(78, typedArray.getInt(index, constraint.propertySet.mVisibilityMode));
                    break;
                case 79:
                    delta.a(79, typedArray.getFloat(index, constraint.motion.mMotionStagger));
                    break;
                case 80:
                    delta.a(80, typedArray.getBoolean(index, constraint.layout.constrainedWidth));
                    break;
                case 81:
                    delta.a(81, typedArray.getBoolean(index, constraint.layout.constrainedHeight));
                    break;
                case 82:
                    delta.a(82, typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    delta.a(83, b(typedArray, index, constraint.transform.transformPivotTarget));
                    break;
                case 84:
                    delta.a(84, typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    delta.a(85, typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type != 1) {
                        if (peekValue.type != 3) {
                            constraint.motion.mQuantizeInterpolatorType = typedArray.getInteger(index, constraint.motion.mQuantizeInterpolatorID);
                            delta.a(88, constraint.motion.mQuantizeInterpolatorType);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                            delta.a(90, constraint.motion.mQuantizeInterpolatorString);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf(BridgeUtil.SPLIT_MARK) <= 0) {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                delta.a(88, constraint.motion.mQuantizeInterpolatorType);
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                                delta.a(89, constraint.motion.mQuantizeInterpolatorID);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                delta.a(88, constraint.motion.mQuantizeInterpolatorType);
                                break;
                            }
                        }
                    } else {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        delta.a(89, constraint.motion.mQuantizeInterpolatorID);
                        if (constraint.motion.mQuantizeInterpolatorID == -1) {
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorType = -2;
                            delta.a(88, constraint.motion.mQuantizeInterpolatorType);
                            break;
                        }
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f.get(index));
                    break;
                case 93:
                    delta.a(93, typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin));
                    break;
                case 94:
                    delta.a(94, typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin));
                    break;
                case 95:
                    a(delta, typedArray, index, 0);
                    break;
                case 96:
                    a(delta, typedArray, index, 1);
                    break;
                case 97:
                    delta.a(97, typedArray.getInt(index, constraint.layout.mWrapBehavior));
                    break;
                case 98:
                    if (!MotionLayout.IS_IN_EDIT_MODE) {
                        if (typedArray.peekValue(index).type != 3) {
                            constraint.f2268a = typedArray.getResourceId(index, constraint.f2268a);
                            break;
                        } else {
                            constraint.b = typedArray.getString(index);
                            break;
                        }
                    } else {
                        constraint.f2268a = typedArray.getResourceId(index, constraint.f2268a);
                        if (constraint.f2268a != -1) {
                            break;
                        } else {
                            constraint.b = typedArray.getString(index);
                            break;
                        }
                    }
                case 99:
                    delta.a(99, typedArray.getBoolean(index, constraint.layout.guidelineUseRtl));
                    break;
            }
            i = i2 + 1;
        }
    }

    private void a(Context context, Constraint constraint, TypedArray typedArray, boolean z) {
        if (z) {
            a(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                if (constraint.layout.mReferenceIdString != null) {
                    constraint.layout.mReferenceIds = null;
                    return;
                }
                return;
            }
            int index = typedArray.getIndex(i2);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (f.get(index)) {
                case 1:
                    constraint.layout.baselineToBaseline = b(typedArray, index, constraint.layout.baselineToBaseline);
                    break;
                case 2:
                    constraint.layout.bottomMargin = typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin);
                    break;
                case 3:
                    constraint.layout.bottomToBottom = b(typedArray, index, constraint.layout.bottomToBottom);
                    break;
                case 4:
                    constraint.layout.bottomToTop = b(typedArray, index, constraint.layout.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    constraint.layout.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX);
                    break;
                case 7:
                    constraint.layout.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        constraint.layout.endMargin = typedArray.getDimensionPixelSize(index, constraint.layout.endMargin);
                        break;
                    }
                case 9:
                    constraint.layout.endToEnd = b(typedArray, index, constraint.layout.endToEnd);
                    break;
                case 10:
                    constraint.layout.endToStart = b(typedArray, index, constraint.layout.endToStart);
                    break;
                case 11:
                    constraint.layout.goneBottomMargin = typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin);
                    break;
                case 12:
                    constraint.layout.goneEndMargin = typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin);
                    break;
                case 13:
                    constraint.layout.goneLeftMargin = typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin);
                    break;
                case 14:
                    constraint.layout.goneRightMargin = typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin);
                    break;
                case 15:
                    constraint.layout.goneStartMargin = typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin);
                    break;
                case 16:
                    constraint.layout.goneTopMargin = typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin);
                    break;
                case 17:
                    constraint.layout.guideBegin = typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin);
                    break;
                case 18:
                    constraint.layout.guideEnd = typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd);
                    break;
                case 19:
                    constraint.layout.guidePercent = typedArray.getFloat(index, constraint.layout.guidePercent);
                    break;
                case 20:
                    constraint.layout.horizontalBias = typedArray.getFloat(index, constraint.layout.horizontalBias);
                    break;
                case 21:
                    constraint.layout.mHeight = typedArray.getLayoutDimension(index, constraint.layout.mHeight);
                    break;
                case 22:
                    constraint.propertySet.visibility = typedArray.getInt(index, constraint.propertySet.visibility);
                    constraint.propertySet.visibility = d[constraint.propertySet.visibility];
                    break;
                case 23:
                    constraint.layout.mWidth = typedArray.getLayoutDimension(index, constraint.layout.mWidth);
                    break;
                case 24:
                    constraint.layout.leftMargin = typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin);
                    break;
                case 25:
                    constraint.layout.leftToLeft = b(typedArray, index, constraint.layout.leftToLeft);
                    break;
                case 26:
                    constraint.layout.leftToRight = b(typedArray, index, constraint.layout.leftToRight);
                    break;
                case 27:
                    constraint.layout.orientation = typedArray.getInt(index, constraint.layout.orientation);
                    break;
                case 28:
                    constraint.layout.rightMargin = typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin);
                    break;
                case 29:
                    constraint.layout.rightToLeft = b(typedArray, index, constraint.layout.rightToLeft);
                    break;
                case 30:
                    constraint.layout.rightToRight = b(typedArray, index, constraint.layout.rightToRight);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT < 17) {
                        break;
                    } else {
                        constraint.layout.startMargin = typedArray.getDimensionPixelSize(index, constraint.layout.startMargin);
                        break;
                    }
                case 32:
                    constraint.layout.startToEnd = b(typedArray, index, constraint.layout.startToEnd);
                    break;
                case 33:
                    constraint.layout.startToStart = b(typedArray, index, constraint.layout.startToStart);
                    break;
                case 34:
                    constraint.layout.topMargin = typedArray.getDimensionPixelSize(index, constraint.layout.topMargin);
                    break;
                case 35:
                    constraint.layout.topToBottom = b(typedArray, index, constraint.layout.topToBottom);
                    break;
                case 36:
                    constraint.layout.topToTop = b(typedArray, index, constraint.layout.topToTop);
                    break;
                case 37:
                    constraint.layout.verticalBias = typedArray.getFloat(index, constraint.layout.verticalBias);
                    break;
                case 38:
                    constraint.f2268a = typedArray.getResourceId(index, constraint.f2268a);
                    break;
                case 39:
                    constraint.layout.horizontalWeight = typedArray.getFloat(index, constraint.layout.horizontalWeight);
                    break;
                case 40:
                    constraint.layout.verticalWeight = typedArray.getFloat(index, constraint.layout.verticalWeight);
                    break;
                case 41:
                    constraint.layout.horizontalChainStyle = typedArray.getInt(index, constraint.layout.horizontalChainStyle);
                    break;
                case 42:
                    constraint.layout.verticalChainStyle = typedArray.getInt(index, constraint.layout.verticalChainStyle);
                    break;
                case 43:
                    constraint.propertySet.alpha = typedArray.getFloat(index, constraint.propertySet.alpha);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        constraint.transform.applyElevation = true;
                        constraint.transform.elevation = typedArray.getDimension(index, constraint.transform.elevation);
                        break;
                    }
                case 45:
                    constraint.transform.rotationX = typedArray.getFloat(index, constraint.transform.rotationX);
                    break;
                case 46:
                    constraint.transform.rotationY = typedArray.getFloat(index, constraint.transform.rotationY);
                    break;
                case 47:
                    constraint.transform.scaleX = typedArray.getFloat(index, constraint.transform.scaleX);
                    break;
                case 48:
                    constraint.transform.scaleY = typedArray.getFloat(index, constraint.transform.scaleY);
                    break;
                case 49:
                    constraint.transform.transformPivotX = typedArray.getDimension(index, constraint.transform.transformPivotX);
                    break;
                case 50:
                    constraint.transform.transformPivotY = typedArray.getDimension(index, constraint.transform.transformPivotY);
                    break;
                case 51:
                    constraint.transform.translationX = typedArray.getDimension(index, constraint.transform.translationX);
                    break;
                case 52:
                    constraint.transform.translationY = typedArray.getDimension(index, constraint.transform.translationY);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT < 21) {
                        break;
                    } else {
                        constraint.transform.translationZ = typedArray.getDimension(index, constraint.transform.translationZ);
                        break;
                    }
                case 54:
                    constraint.layout.widthDefault = typedArray.getInt(index, constraint.layout.widthDefault);
                    break;
                case 55:
                    constraint.layout.heightDefault = typedArray.getInt(index, constraint.layout.heightDefault);
                    break;
                case 56:
                    constraint.layout.widthMax = typedArray.getDimensionPixelSize(index, constraint.layout.widthMax);
                    break;
                case 57:
                    constraint.layout.heightMax = typedArray.getDimensionPixelSize(index, constraint.layout.heightMax);
                    break;
                case 58:
                    constraint.layout.widthMin = typedArray.getDimensionPixelSize(index, constraint.layout.widthMin);
                    break;
                case 59:
                    constraint.layout.heightMin = typedArray.getDimensionPixelSize(index, constraint.layout.heightMin);
                    break;
                case 60:
                    constraint.transform.rotation = typedArray.getFloat(index, constraint.transform.rotation);
                    break;
                case 61:
                    constraint.layout.circleConstraint = b(typedArray, index, constraint.layout.circleConstraint);
                    break;
                case 62:
                    constraint.layout.circleRadius = typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius);
                    break;
                case 63:
                    constraint.layout.circleAngle = typedArray.getFloat(index, constraint.layout.circleAngle);
                    break;
                case 64:
                    constraint.motion.mAnimateRelativeTo = b(typedArray, index, constraint.motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type != 3) {
                        constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                        break;
                    } else {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                        break;
                    }
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    constraint.motion.mPathRotate = typedArray.getFloat(index, constraint.motion.mPathRotate);
                    break;
                case 68:
                    constraint.propertySet.mProgress = typedArray.getFloat(index, constraint.propertySet.mProgress);
                    break;
                case 69:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    constraint.layout.mBarrierDirection = typedArray.getInt(index, constraint.layout.mBarrierDirection);
                    break;
                case 73:
                    constraint.layout.mBarrierMargin = typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin);
                    break;
                case 74:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    constraint.layout.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    constraint.motion.mPathMotionArc = typedArray.getInt(index, constraint.motion.mPathMotionArc);
                    break;
                case 77:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    constraint.propertySet.mVisibilityMode = typedArray.getInt(index, constraint.propertySet.mVisibilityMode);
                    break;
                case 79:
                    constraint.motion.mMotionStagger = typedArray.getFloat(index, constraint.motion.mMotionStagger);
                    break;
                case 80:
                    constraint.layout.constrainedWidth = typedArray.getBoolean(index, constraint.layout.constrainedWidth);
                    break;
                case 81:
                    constraint.layout.constrainedHeight = typedArray.getBoolean(index, constraint.layout.constrainedHeight);
                    break;
                case 82:
                    constraint.motion.mAnimateCircleAngleTo = typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo);
                    break;
                case 83:
                    constraint.transform.transformPivotTarget = b(typedArray, index, constraint.transform.transformPivotTarget);
                    break;
                case 84:
                    constraint.motion.mQuantizeMotionSteps = typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps);
                    break;
                case 85:
                    constraint.motion.mQuantizeMotionPhase = typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase);
                    break;
                case 86:
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type != 1) {
                        if (peekValue.type != 3) {
                            constraint.motion.mQuantizeInterpolatorType = typedArray.getInteger(index, constraint.motion.mQuantizeInterpolatorID);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf(BridgeUtil.SPLIT_MARK) <= 0) {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                break;
                            }
                        }
                    } else {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        if (constraint.motion.mQuantizeInterpolatorID == -1) {
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorType = -2;
                            break;
                        }
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f.get(index));
                    break;
                case 91:
                    constraint.layout.baselineToTop = b(typedArray, index, constraint.layout.baselineToTop);
                    break;
                case 92:
                    constraint.layout.baselineToBottom = b(typedArray, index, constraint.layout.baselineToBottom);
                    break;
                case 93:
                    constraint.layout.baselineMargin = typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin);
                    break;
                case 94:
                    constraint.layout.goneBaselineMargin = typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin);
                    break;
                case 95:
                    a(constraint.layout, typedArray, index, 0);
                    break;
                case 96:
                    a(constraint.layout, typedArray, index, 1);
                    break;
                case 97:
                    constraint.layout.mWrapBehavior = typedArray.getInt(index, constraint.layout.mWrapBehavior);
                    break;
            }
            i = i2 + 1;
        }
    }

    private void a(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            if (this.b.containsKey(strArr[i2])) {
                ConstraintAttribute constraintAttribute = this.b.get(strArr[i2]);
                if (constraintAttribute != null && constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.b.put(strArr[i2], new ConstraintAttribute(strArr[i2], attributeType));
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConstraintLayout.LayoutParams layoutParams, String str) {
        float f2 = Float.NaN;
        int i = -1;
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i2 = -1;
            int i3 = 0;
            if (indexOf > 0) {
                i2 = -1;
                i3 = 0;
                if (indexOf < length - 1) {
                    String substring = str.substring(0, indexOf);
                    if (substring.equalsIgnoreCase("W")) {
                        i2 = 0;
                    } else {
                        i2 = -1;
                        if (substring.equalsIgnoreCase("H")) {
                            i2 = 1;
                        }
                    }
                    i3 = indexOf + 1;
                }
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i3);
                    f2 = Float.NaN;
                    i = i2;
                    if (substring2.length() > 0) {
                        f2 = Float.parseFloat(substring2);
                        i = i2;
                    }
                } else {
                    String substring3 = str.substring(i3, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    f2 = Float.NaN;
                    i = i2;
                    if (substring3.length() > 0) {
                        f2 = Float.NaN;
                        i = i2;
                        if (substring4.length() > 0) {
                            float parseFloat = Float.parseFloat(substring3);
                            float parseFloat2 = Float.parseFloat(substring4);
                            f2 = Float.NaN;
                            i = i2;
                            if (parseFloat > 0.0f) {
                                f2 = Float.NaN;
                                i = i2;
                                if (parseFloat2 > 0.0f) {
                                    if (i2 == 1) {
                                        f2 = Math.abs(parseFloat2 / parseFloat);
                                        i = i2;
                                    } else {
                                        f2 = Math.abs(parseFloat / parseFloat2);
                                        i = i2;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                f2 = Float.NaN;
                i = i2;
            }
        }
        layoutParams.dimensionRatio = str;
        layoutParams.f2256c = f2;
        layoutParams.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, TypedArray typedArray, int i, int i2) {
        int dimensionPixelSize;
        if (obj == null) {
            return;
        }
        int i3 = typedArray.peekValue(i).type;
        if (i3 == 3) {
            a(obj, typedArray.getString(i), i2);
            return;
        }
        boolean z = false;
        if (i3 != 5) {
            dimensionPixelSize = typedArray.getInt(i, 0);
            if (dimensionPixelSize == -4) {
                z = true;
                dimensionPixelSize = -2;
            } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                dimensionPixelSize = 0;
            }
        } else {
            dimensionPixelSize = typedArray.getDimensionPixelSize(i, 0);
        }
        if (obj instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
            if (i2 == 0) {
                layoutParams.width = dimensionPixelSize;
                layoutParams.constrainedWidth = z;
                return;
            }
            layoutParams.height = dimensionPixelSize;
            layoutParams.constrainedHeight = z;
        } else if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            if (i2 == 0) {
                layout.mWidth = dimensionPixelSize;
                layout.constrainedWidth = z;
                return;
            }
            layout.mHeight = dimensionPixelSize;
            layout.constrainedHeight = z;
        } else if (obj instanceof Constraint.Delta) {
            Constraint.Delta delta = (Constraint.Delta) obj;
            if (i2 == 0) {
                delta.a(23, dimensionPixelSize);
                delta.a(80, z);
                return;
            }
            delta.a(21, dimensionPixelSize);
            delta.a(81, z);
        }
    }

    static void a(Object obj, String str, int i) {
        if (str == null) {
            return;
        }
        int indexOf = str.indexOf(61);
        int length = str.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if ("ratio".equalsIgnoreCase(trim)) {
                if (obj instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i == 0) {
                        layoutParams.width = 0;
                    } else {
                        layoutParams.height = 0;
                    }
                    a(layoutParams, trim2);
                    return;
                } else if (obj instanceof Layout) {
                    ((Layout) obj).dimensionRatio = trim2;
                    return;
                } else if (obj instanceof Constraint.Delta) {
                    ((Constraint.Delta) obj).a(5, trim2);
                    return;
                } else {
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                        if (i == 0) {
                            layoutParams2.width = 0;
                            layoutParams2.horizontalWeight = parseFloat;
                            return;
                        }
                        layoutParams2.height = 0;
                        layoutParams2.verticalWeight = parseFloat;
                    } else if (obj instanceof Layout) {
                        Layout layout = (Layout) obj;
                        if (i == 0) {
                            layout.mWidth = 0;
                            layout.horizontalWeight = parseFloat;
                            return;
                        }
                        layout.mHeight = 0;
                        layout.verticalWeight = parseFloat;
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta = (Constraint.Delta) obj;
                        if (i == 0) {
                            delta.a(23, 0);
                            delta.a(39, parseFloat);
                            return;
                        }
                        delta.a(21, 0);
                        delta.a(40, parseFloat);
                    }
                } else if ("parent".equalsIgnoreCase(trim)) {
                    float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                        if (i == 0) {
                            layoutParams3.width = 0;
                            layoutParams3.matchConstraintPercentWidth = max;
                            layoutParams3.matchConstraintDefaultWidth = 2;
                            return;
                        }
                        layoutParams3.height = 0;
                        layoutParams3.matchConstraintPercentHeight = max;
                        layoutParams3.matchConstraintDefaultHeight = 2;
                    } else if (obj instanceof Layout) {
                        Layout layout2 = (Layout) obj;
                        if (i == 0) {
                            layout2.mWidth = 0;
                            layout2.widthPercent = max;
                            layout2.widthDefault = 2;
                            return;
                        }
                        layout2.mHeight = 0;
                        layout2.heightPercent = max;
                        layout2.heightDefault = 2;
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta2 = (Constraint.Delta) obj;
                        if (i == 0) {
                            delta2.a(23, 0);
                            delta2.a(54, 2);
                            return;
                        }
                        delta2.a(21, 0);
                        delta2.a(55, 2);
                    }
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    private int[] a(View view, String str) {
        int i;
        int i2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i3 >= split.length) {
                break;
            }
            String trim = split[i3].trim();
            try {
                i2 = R.id.class.getField(trim).getInt(null);
            } catch (Exception e) {
                i2 = 0;
            }
            int i5 = i2;
            if (i2 == 0) {
                i5 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            int i6 = i5;
            if (i5 == 0) {
                i6 = i5;
                if (view.isInEditMode()) {
                    i6 = i5;
                    if (view.getParent() instanceof ConstraintLayout) {
                        Object designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim);
                        i6 = i5;
                        if (designInformation != null) {
                            i6 = i5;
                            if (designInformation instanceof Integer) {
                                i6 = ((Integer) designInformation).intValue();
                            }
                        }
                    }
                }
            }
            iArr[i] = i6;
            i3++;
            i4 = i + 1;
        }
        int[] iArr2 = iArr;
        if (i != split.length) {
            iArr2 = Arrays.copyOf(iArr, i);
        }
        return iArr2;
    }

    private static String[] a(String str) {
        int i;
        boolean z;
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (i2 >= charArray.length) {
                arrayList.add(new String(charArray, i3, charArray.length - i3));
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (charArray[i2] != ',' || z3) {
                i = i3;
                z = z3;
                if (charArray[i2] == '\"') {
                    z = !z3;
                    i = i3;
                }
            } else {
                arrayList.add(new String(charArray, i3, i2 - i3));
                i = i2 + 1;
                z = z3;
            }
            i2++;
            i3 = i;
            z2 = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        int i3 = resourceId;
        if (resourceId == -1) {
            i3 = typedArray.getInt(i, -1);
        }
        return i3;
    }

    private String b(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return Constant.MAP_KEY_TOP;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Constraint constraint, int i, float f2) {
        if (i == 19) {
            constraint.layout.guidePercent = f2;
        } else if (i == 20) {
            constraint.layout.horizontalBias = f2;
        } else if (i == 37) {
            constraint.layout.verticalBias = f2;
        } else if (i == 60) {
            constraint.transform.rotation = f2;
        } else if (i == 63) {
            constraint.layout.circleAngle = f2;
        } else if (i == 79) {
            constraint.motion.mMotionStagger = f2;
        } else if (i == 85) {
            constraint.motion.mQuantizeMotionPhase = f2;
        } else if (i != 87) {
            if (i == 39) {
                constraint.layout.horizontalWeight = f2;
            } else if (i == 40) {
                constraint.layout.verticalWeight = f2;
            } else {
                switch (i) {
                    case 43:
                        constraint.propertySet.alpha = f2;
                        return;
                    case 44:
                        constraint.transform.elevation = f2;
                        constraint.transform.applyElevation = true;
                        return;
                    case 45:
                        constraint.transform.rotationX = f2;
                        return;
                    case 46:
                        constraint.transform.rotationY = f2;
                        return;
                    case 47:
                        constraint.transform.scaleX = f2;
                        return;
                    case 48:
                        constraint.transform.scaleY = f2;
                        return;
                    case 49:
                        constraint.transform.transformPivotX = f2;
                        return;
                    case 50:
                        constraint.transform.transformPivotY = f2;
                        return;
                    case 51:
                        constraint.transform.translationX = f2;
                        return;
                    case 52:
                        constraint.transform.translationY = f2;
                        return;
                    case 53:
                        constraint.transform.translationZ = f2;
                        return;
                    default:
                        switch (i) {
                            case 67:
                                constraint.motion.mPathRotate = f2;
                                return;
                            case 68:
                                constraint.propertySet.mProgress = f2;
                                return;
                            case 69:
                                constraint.layout.widthPercent = f2;
                                return;
                            case 70:
                                constraint.layout.heightPercent = f2;
                                return;
                            default:
                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                return;
                        }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Constraint constraint, int i, int i2) {
        if (i == 6) {
            constraint.layout.editorAbsoluteX = i2;
        } else if (i == 7) {
            constraint.layout.editorAbsoluteY = i2;
        } else if (i == 8) {
            constraint.layout.endMargin = i2;
        } else if (i == 27) {
            constraint.layout.orientation = i2;
        } else if (i == 28) {
            constraint.layout.rightMargin = i2;
        } else if (i == 41) {
            constraint.layout.horizontalChainStyle = i2;
        } else if (i == 42) {
            constraint.layout.verticalChainStyle = i2;
        } else if (i == 61) {
            constraint.layout.circleConstraint = i2;
        } else if (i == 62) {
            constraint.layout.circleRadius = i2;
        } else if (i == 72) {
            constraint.layout.mBarrierDirection = i2;
        } else if (i == 73) {
            constraint.layout.mBarrierMargin = i2;
        } else {
            switch (i) {
                case 2:
                    constraint.layout.bottomMargin = i2;
                    return;
                case 11:
                    constraint.layout.goneBottomMargin = i2;
                    return;
                case 12:
                    constraint.layout.goneEndMargin = i2;
                    return;
                case 13:
                    constraint.layout.goneLeftMargin = i2;
                    return;
                case 14:
                    constraint.layout.goneRightMargin = i2;
                    return;
                case 15:
                    constraint.layout.goneStartMargin = i2;
                    return;
                case 16:
                    constraint.layout.goneTopMargin = i2;
                    return;
                case 17:
                    constraint.layout.guideBegin = i2;
                    return;
                case 18:
                    constraint.layout.guideEnd = i2;
                    return;
                case 31:
                    constraint.layout.startMargin = i2;
                    return;
                case 34:
                    constraint.layout.topMargin = i2;
                    return;
                case 38:
                    constraint.f2268a = i2;
                    return;
                case 64:
                    constraint.motion.mAnimateRelativeTo = i2;
                    return;
                case 66:
                    constraint.motion.mDrawPath = i2;
                    return;
                case 76:
                    constraint.motion.mPathMotionArc = i2;
                    return;
                case 78:
                    constraint.propertySet.mVisibilityMode = i2;
                    return;
                case 93:
                    constraint.layout.baselineMargin = i2;
                    return;
                case 94:
                    constraint.layout.goneBaselineMargin = i2;
                    return;
                case 97:
                    constraint.layout.mWrapBehavior = i2;
                    return;
                default:
                    switch (i) {
                        case 21:
                            constraint.layout.mHeight = i2;
                            return;
                        case 22:
                            constraint.propertySet.visibility = i2;
                            return;
                        case 23:
                            constraint.layout.mWidth = i2;
                            return;
                        case 24:
                            constraint.layout.leftMargin = i2;
                            return;
                        default:
                            switch (i) {
                                case 54:
                                    constraint.layout.widthDefault = i2;
                                    return;
                                case 55:
                                    constraint.layout.heightDefault = i2;
                                    return;
                                case 56:
                                    constraint.layout.widthMax = i2;
                                    return;
                                case 57:
                                    constraint.layout.heightMax = i2;
                                    return;
                                case 58:
                                    constraint.layout.widthMin = i2;
                                    return;
                                case 59:
                                    constraint.layout.heightMin = i2;
                                    return;
                                default:
                                    switch (i) {
                                        case 82:
                                            constraint.motion.mAnimateCircleAngleTo = i2;
                                            return;
                                        case 83:
                                            constraint.transform.transformPivotTarget = i2;
                                            return;
                                        case 84:
                                            constraint.motion.mQuantizeMotionSteps = i2;
                                            return;
                                        default:
                                            switch (i) {
                                                case 87:
                                                    return;
                                                case 88:
                                                    constraint.motion.mQuantizeInterpolatorType = i2;
                                                    return;
                                                case 89:
                                                    constraint.motion.mQuantizeInterpolatorID = i2;
                                                    return;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x");
                                                    return;
                                            }
                                    }
                            }
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Constraint constraint, int i, String str) {
        if (i == 5) {
            constraint.layout.dimensionRatio = str;
        } else if (i == 65) {
            constraint.motion.mTransitionEasing = str;
        } else if (i == 74) {
            constraint.layout.mReferenceIdString = str;
            constraint.layout.mReferenceIds = null;
        } else if (i == 77) {
            constraint.layout.mConstraintTag = str;
        } else if (i != 87) {
            if (i != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.motion.mQuantizeInterpolatorString = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Constraint constraint, int i, boolean z) {
        if (i == 44) {
            constraint.transform.applyElevation = z;
        } else if (i == 75) {
            constraint.layout.mBarrierAllowsGoneWidgets = z;
        } else if (i != 87) {
            if (i == 80) {
                constraint.layout.constrainedWidth = z;
            } else if (i != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                constraint.layout.constrainedHeight = z;
            }
        }
    }

    public static Constraint buildDelta(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        a(context, constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintLayout constraintLayout, boolean z) {
        int i;
        View findViewById;
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.e.keySet());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                Iterator it = hashSet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Integer num = (Integer) it.next();
                    Constraint constraint = this.e.get(num);
                    if (constraint != null) {
                        if (constraint.layout.mHelperType == 1) {
                            Barrier barrier = new Barrier(constraintLayout.getContext());
                            barrier.setId(num.intValue());
                            if (constraint.layout.mReferenceIds != null) {
                                barrier.setReferencedIds(constraint.layout.mReferenceIds);
                            } else if (constraint.layout.mReferenceIdString != null) {
                                constraint.layout.mReferenceIds = a(barrier, constraint.layout.mReferenceIdString);
                                barrier.setReferencedIds(constraint.layout.mReferenceIds);
                            }
                            barrier.setType(constraint.layout.mBarrierDirection);
                            barrier.setMargin(constraint.layout.mBarrierMargin);
                            ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                            barrier.validateParams();
                            constraint.applyTo(generateDefaultLayoutParams);
                            constraintLayout.addView(barrier, generateDefaultLayoutParams);
                        }
                        if (constraint.layout.mIsGuideline) {
                            View guideline = new Guideline(constraintLayout.getContext());
                            guideline.setId(num.intValue());
                            ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                            constraint.applyTo(generateDefaultLayoutParams2);
                            constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                        }
                    }
                }
                for (i = 0; i < childCount; i++) {
                    View childAt = constraintLayout.getChildAt(i);
                    if (childAt instanceof ConstraintHelper) {
                        ((ConstraintHelper) childAt).a(constraintLayout);
                    }
                }
                return;
            }
            View childAt2 = constraintLayout.getChildAt(i3);
            int id = childAt2.getId();
            if (!this.e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.getName(childAt2));
            } else if (this.f2267c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.e.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint2 = this.e.get(Integer.valueOf(id));
                        if (constraint2 != null) {
                            if (childAt2 instanceof Barrier) {
                                constraint2.layout.mHelperType = 1;
                                Barrier barrier2 = (Barrier) childAt2;
                                barrier2.setId(id);
                                barrier2.setType(constraint2.layout.mBarrierDirection);
                                barrier2.setMargin(constraint2.layout.mBarrierMargin);
                                barrier2.setAllowsGoneWidget(constraint2.layout.mBarrierAllowsGoneWidgets);
                                if (constraint2.layout.mReferenceIds != null) {
                                    barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                                } else if (constraint2.layout.mReferenceIdString != null) {
                                    constraint2.layout.mReferenceIds = a(barrier2, constraint2.layout.mReferenceIdString);
                                    barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt2.getLayoutParams();
                            layoutParams.validate();
                            constraint2.applyTo(layoutParams);
                            if (z) {
                                ConstraintAttribute.setAttributes(childAt2, constraint2.mCustomConstraints);
                            }
                            childAt2.setLayoutParams(layoutParams);
                            if (constraint2.propertySet.mVisibilityMode == 0) {
                                childAt2.setVisibility(constraint2.propertySet.visibility);
                            }
                            if (Build.VERSION.SDK_INT >= 17) {
                                childAt2.setAlpha(constraint2.propertySet.alpha);
                                childAt2.setRotation(constraint2.transform.rotation);
                                childAt2.setRotationX(constraint2.transform.rotationX);
                                childAt2.setRotationY(constraint2.transform.rotationY);
                                childAt2.setScaleX(constraint2.transform.scaleX);
                                childAt2.setScaleY(constraint2.transform.scaleY);
                                if (constraint2.transform.transformPivotTarget != -1) {
                                    if (((View) childAt2.getParent()).findViewById(constraint2.transform.transformPivotTarget) != null) {
                                        float top = (findViewById.getTop() + findViewById.getBottom()) / 2.0f;
                                        float left = (findViewById.getLeft() + findViewById.getRight()) / 2.0f;
                                        if (childAt2.getRight() - childAt2.getLeft() > 0 && childAt2.getBottom() - childAt2.getTop() > 0) {
                                            childAt2.setPivotX(left - childAt2.getLeft());
                                            childAt2.setPivotY(top - childAt2.getTop());
                                        }
                                    }
                                } else {
                                    if (!Float.isNaN(constraint2.transform.transformPivotX)) {
                                        childAt2.setPivotX(constraint2.transform.transformPivotX);
                                    }
                                    if (!Float.isNaN(constraint2.transform.transformPivotY)) {
                                        childAt2.setPivotY(constraint2.transform.transformPivotY);
                                    }
                                }
                                childAt2.setTranslationX(constraint2.transform.translationX);
                                childAt2.setTranslationY(constraint2.transform.translationY);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    childAt2.setTranslationZ(constraint2.transform.translationZ);
                                    if (constraint2.transform.applyElevation) {
                                        childAt2.setElevation(constraint2.transform.elevation);
                                    }
                                }
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    public void addColorAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        a(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        connect(i, 1, i2, i2 == 0 ? 1 : 2, 0);
        connect(i, 2, i3, i3 == 0 ? 2 : 1, 0);
        if (i2 != 0) {
            connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            connect(i3, 1, i, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        connect(i, 6, i2, i2 == 0 ? 6 : 7, 0);
        connect(i, 7, i3, i3 == 0 ? 7 : 6, 0);
        if (i2 != 0) {
            connect(i2, 7, i, 6, 0);
        }
        if (i3 != 0) {
            connect(i3, 6, i, 7, 0);
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        connect(i, 3, i2, i2 == 0 ? 3 : 4, 0);
        connect(i, 4, i3, i3 == 0 ? 4 : 3, 0);
        if (i2 != 0) {
            connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            connect(i3, 3, i, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.getName(childAt));
            } else if (this.f2267c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (this.e.containsKey(Integer.valueOf(id)) && (constraint = this.e.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
            }
            i = i2 + 1;
        }
    }

    public void applyDeltaFrom(ConstraintSet constraintSet) {
        for (Constraint constraint : constraintSet.e.values()) {
            if (constraint.f2269c != null) {
                if (constraint.b != null) {
                    for (Integer num : this.e.keySet()) {
                        Constraint constraint2 = getConstraint(num.intValue());
                        if (constraint2.layout.mConstraintTag != null && constraint.b.matches(constraint2.layout.mConstraintTag)) {
                            constraint.f2269c.a(constraint2);
                            constraint2.mCustomConstraints.putAll((HashMap) constraint.mCustomConstraints.clone());
                        }
                    }
                } else {
                    constraint.f2269c.a(getConstraint(constraint.f2268a));
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        a(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id = constraintHelper.getId();
        if (this.e.containsKey(Integer.valueOf(id)) && (constraint = this.e.get(Integer.valueOf(id))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public void applyToLayoutParams(int i, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (!this.e.containsKey(Integer.valueOf(i)) || (constraint = this.e.get(Integer.valueOf(i))) == null) {
            return;
        }
        constraint.applyTo(layoutParams);
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        a(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        if (i4 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f2 <= 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i3 == 1 || i3 == 2) {
            connect(i, 1, i2, i3, i4);
            connect(i, 2, i5, i6, i7);
            Constraint constraint = this.e.get(Integer.valueOf(i));
            if (constraint != null) {
                constraint.layout.horizontalBias = f2;
            }
        } else if (i3 == 6 || i3 == 7) {
            connect(i, 6, i2, i3, i4);
            connect(i, 7, i5, i6, i7);
            Constraint constraint2 = this.e.get(Integer.valueOf(i));
            if (constraint2 != null) {
                constraint2.layout.horizontalBias = f2;
            }
        } else {
            connect(i, 3, i2, i3, i4);
            connect(i, 4, i5, i6, i7);
            Constraint constraint3 = this.e.get(Integer.valueOf(i));
            if (constraint3 != null) {
                constraint3.layout.verticalBias = f2;
            }
        }
    }

    public void centerHorizontally(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, i2, 2, 0, i2, 1, 0, 0.5f);
        }
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        connect(i, 1, i2, i3, i4);
        connect(i, 2, i5, i6, i7);
        Constraint constraint = this.e.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.horizontalBias = f2;
        }
    }

    public void centerHorizontallyRtl(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, i2, 7, 0, i2, 6, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        connect(i, 6, i2, i3, i4);
        connect(i, 7, i5, i6, i7);
        Constraint constraint = this.e.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.horizontalBias = f2;
        }
    }

    public void centerVertically(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, i2, 4, 0, i2, 3, 0, 0.5f);
        }
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f2) {
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        Constraint constraint = this.e.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.verticalBias = f2;
        }
    }

    public void clear(int i) {
        this.e.remove(Integer.valueOf(i));
    }

    public void clear(int i, int i2) {
        Constraint constraint;
        if (!this.e.containsKey(Integer.valueOf(i)) || (constraint = this.e.get(Integer.valueOf(i))) == null) {
            return;
        }
        switch (i2) {
            case 1:
                constraint.layout.leftToRight = -1;
                constraint.layout.leftToLeft = -1;
                constraint.layout.leftMargin = -1;
                constraint.layout.goneLeftMargin = Integer.MIN_VALUE;
                return;
            case 2:
                constraint.layout.rightToRight = -1;
                constraint.layout.rightToLeft = -1;
                constraint.layout.rightMargin = -1;
                constraint.layout.goneRightMargin = Integer.MIN_VALUE;
                return;
            case 3:
                constraint.layout.topToBottom = -1;
                constraint.layout.topToTop = -1;
                constraint.layout.topMargin = 0;
                constraint.layout.goneTopMargin = Integer.MIN_VALUE;
                return;
            case 4:
                constraint.layout.bottomToTop = -1;
                constraint.layout.bottomToBottom = -1;
                constraint.layout.bottomMargin = 0;
                constraint.layout.goneBottomMargin = Integer.MIN_VALUE;
                return;
            case 5:
                constraint.layout.baselineToBaseline = -1;
                constraint.layout.baselineToTop = -1;
                constraint.layout.baselineToBottom = -1;
                constraint.layout.baselineMargin = 0;
                constraint.layout.goneBaselineMargin = Integer.MIN_VALUE;
                return;
            case 6:
                constraint.layout.startToEnd = -1;
                constraint.layout.startToStart = -1;
                constraint.layout.startMargin = 0;
                constraint.layout.goneStartMargin = Integer.MIN_VALUE;
                return;
            case 7:
                constraint.layout.endToStart = -1;
                constraint.layout.endToEnd = -1;
                constraint.layout.endMargin = 0;
                constraint.layout.goneEndMargin = Integer.MIN_VALUE;
                return;
            case 8:
                constraint.layout.circleAngle = -1.0f;
                constraint.layout.circleRadius = -1;
                constraint.layout.circleConstraint = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void clone(Context context, int i) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.e.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f2267c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.e.containsKey(Integer.valueOf(id))) {
                this.e.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.e.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.b, childAt);
                constraint.a(id, layoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        constraint.transform.transformPivotX = pivotX;
                        constraint.transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        constraint.transform.translationZ = childAt.getTranslationZ();
                        if (constraint.transform.applyElevation) {
                            constraint.transform.elevation = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            }
            i = i2 + 1;
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.e.clear();
        for (Integer num : constraintSet.e.keySet()) {
            Constraint constraint = constraintSet.e.get(num);
            if (constraint != null) {
                this.e.put(num, constraint.m1387clone());
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.e.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f2267c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.e.containsKey(Integer.valueOf(id))) {
                this.e.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.e.get(Integer.valueOf(id));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    constraint.a((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.a(id, layoutParams);
            }
            i = i2 + 1;
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        if (!this.e.containsKey(Integer.valueOf(i))) {
            this.e.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.e.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    constraint.layout.leftToLeft = i3;
                    constraint.layout.leftToRight = -1;
                    return;
                } else if (i4 == 2) {
                    constraint.layout.leftToRight = i3;
                    constraint.layout.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + b(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    constraint.layout.rightToLeft = i3;
                    constraint.layout.rightToRight = -1;
                    return;
                } else if (i4 == 2) {
                    constraint.layout.rightToRight = i3;
                    constraint.layout.rightToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                }
            case 3:
                if (i4 == 3) {
                    constraint.layout.topToTop = i3;
                    constraint.layout.topToBottom = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                    return;
                } else if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.topToBottom = i3;
                    constraint.layout.topToTop = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                    return;
                }
            case 4:
                if (i4 == 4) {
                    constraint.layout.bottomToBottom = i3;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                    return;
                } else if (i4 != 3) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.bottomToTop = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                    return;
                }
            case 5:
                if (i4 == 5) {
                    constraint.layout.baselineToBaseline = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.topToTop = -1;
                    constraint.layout.topToBottom = -1;
                    return;
                } else if (i4 == 3) {
                    constraint.layout.baselineToTop = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.topToTop = -1;
                    constraint.layout.topToBottom = -1;
                    return;
                } else if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.baselineToBottom = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.topToTop = -1;
                    constraint.layout.topToBottom = -1;
                    return;
                }
            case 6:
                if (i4 == 6) {
                    constraint.layout.startToStart = i3;
                    constraint.layout.startToEnd = -1;
                    return;
                } else if (i4 == 7) {
                    constraint.layout.startToEnd = i3;
                    constraint.layout.startToStart = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                }
            case 7:
                if (i4 == 7) {
                    constraint.layout.endToEnd = i3;
                    constraint.layout.endToStart = -1;
                    return;
                } else if (i4 == 6) {
                    constraint.layout.endToStart = i3;
                    constraint.layout.endToEnd = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                }
            default:
                throw new IllegalArgumentException(b(i2) + " to " + b(i4) + " unknown");
        }
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        if (!this.e.containsKey(Integer.valueOf(i))) {
            this.e.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = this.e.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    constraint.layout.leftToLeft = i3;
                    constraint.layout.leftToRight = -1;
                } else if (i4 != 2) {
                    throw new IllegalArgumentException("Left to " + b(i4) + " undefined");
                } else {
                    constraint.layout.leftToRight = i3;
                    constraint.layout.leftToLeft = -1;
                }
                constraint.layout.leftMargin = i5;
                return;
            case 2:
                if (i4 == 1) {
                    constraint.layout.rightToLeft = i3;
                    constraint.layout.rightToRight = -1;
                } else if (i4 != 2) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.rightToRight = i3;
                    constraint.layout.rightToLeft = -1;
                }
                constraint.layout.rightMargin = i5;
                return;
            case 3:
                if (i4 == 3) {
                    constraint.layout.topToTop = i3;
                    constraint.layout.topToBottom = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                } else if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.topToBottom = i3;
                    constraint.layout.topToTop = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                }
                constraint.layout.topMargin = i5;
                return;
            case 4:
                if (i4 == 4) {
                    constraint.layout.bottomToBottom = i3;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                } else if (i4 != 3) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.bottomToTop = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.baselineToBaseline = -1;
                    constraint.layout.baselineToTop = -1;
                    constraint.layout.baselineToBottom = -1;
                }
                constraint.layout.bottomMargin = i5;
                return;
            case 5:
                if (i4 == 5) {
                    constraint.layout.baselineToBaseline = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.topToTop = -1;
                    constraint.layout.topToBottom = -1;
                    return;
                } else if (i4 == 3) {
                    constraint.layout.baselineToTop = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.topToTop = -1;
                    constraint.layout.topToBottom = -1;
                    return;
                } else if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.baselineToBottom = i3;
                    constraint.layout.bottomToBottom = -1;
                    constraint.layout.bottomToTop = -1;
                    constraint.layout.topToTop = -1;
                    constraint.layout.topToBottom = -1;
                    return;
                }
            case 6:
                if (i4 == 6) {
                    constraint.layout.startToStart = i3;
                    constraint.layout.startToEnd = -1;
                } else if (i4 != 7) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.startToEnd = i3;
                    constraint.layout.startToStart = -1;
                }
                constraint.layout.startMargin = i5;
                return;
            case 7:
                if (i4 == 7) {
                    constraint.layout.endToEnd = i3;
                    constraint.layout.endToStart = -1;
                } else if (i4 != 6) {
                    throw new IllegalArgumentException("right to " + b(i4) + " undefined");
                } else {
                    constraint.layout.endToStart = i3;
                    constraint.layout.endToEnd = -1;
                }
                constraint.layout.endMargin = i5;
                return;
            default:
                throw new IllegalArgumentException(b(i2) + " to " + b(i4) + " unknown");
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f2) {
        Constraint a2 = a(i);
        a2.layout.circleConstraint = i2;
        a2.layout.circleRadius = i3;
        a2.layout.circleAngle = f2;
    }

    public void constrainDefaultHeight(int i, int i2) {
        a(i).layout.heightDefault = i2;
    }

    public void constrainDefaultWidth(int i, int i2) {
        a(i).layout.widthDefault = i2;
    }

    public void constrainHeight(int i, int i2) {
        a(i).layout.mHeight = i2;
    }

    public void constrainMaxHeight(int i, int i2) {
        a(i).layout.heightMax = i2;
    }

    public void constrainMaxWidth(int i, int i2) {
        a(i).layout.widthMax = i2;
    }

    public void constrainMinHeight(int i, int i2) {
        a(i).layout.heightMin = i2;
    }

    public void constrainMinWidth(int i, int i2) {
        a(i).layout.widthMin = i2;
    }

    public void constrainPercentHeight(int i, float f2) {
        a(i).layout.heightPercent = f2;
    }

    public void constrainPercentWidth(int i, float f2) {
        a(i).layout.widthPercent = f2;
    }

    public void constrainWidth(int i, int i2) {
        a(i).layout.mWidth = i2;
    }

    public void constrainedHeight(int i, boolean z) {
        a(i).layout.constrainedHeight = z;
    }

    public void constrainedWidth(int i, boolean z) {
        a(i).layout.constrainedWidth = z;
    }

    public void create(int i, int i2) {
        Constraint a2 = a(i);
        a2.layout.mIsGuideline = true;
        a2.layout.orientation = i2;
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        Constraint a2 = a(i);
        a2.layout.mHelperType = 1;
        a2.layout.mBarrierDirection = i2;
        a2.layout.mBarrierMargin = i3;
        a2.layout.mIsGuideline = false;
        a2.layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        a(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        a(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            a(iArr[0]).layout.verticalWeight = fArr[0];
        }
        a(iArr[0]).layout.verticalChainStyle = i5;
        connect(iArr[0], 3, i, i2, 0);
        int i6 = 1;
        while (true) {
            int i7 = i6;
            if (i7 >= iArr.length) {
                connect(iArr[iArr.length - 1], 4, i3, i4, 0);
                return;
            }
            int i8 = iArr[i7];
            int i9 = i7 - 1;
            connect(iArr[i7], 3, iArr[i9], 4, 0);
            connect(iArr[i9], 4, iArr[i7], 3, 0);
            if (fArr != null) {
                a(iArr[i7]).layout.verticalWeight = fArr[i7];
            }
            i6 = i7 + 1;
        }
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> keySet = this.e.keySet();
        if (iArr.length != 0) {
            HashSet hashSet2 = new HashSet();
            int length = iArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                hashSet = hashSet2;
                if (i2 >= length) {
                    break;
                }
                hashSet2.add(Integer.valueOf(iArr[i2]));
                i = i2 + 1;
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        Integer[] numArr = (Integer[]) hashSet.toArray(new Integer[0]);
        int length2 = numArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                System.out.println(sb.toString());
                return;
            }
            Integer num = numArr[i4];
            Constraint constraint = this.e.get(num);
            if (constraint != null) {
                sb.append("<Constraint id=");
                sb.append(num);
                sb.append(" \n");
                constraint.layout.dump(motionScene, sb);
                sb.append("/>\n");
            }
            i3 = i4 + 1;
        }
    }

    public boolean getApplyElevation(int i) {
        return a(i).transform.applyElevation;
    }

    public Constraint getConstraint(int i) {
        if (this.e.containsKey(Integer.valueOf(i))) {
            return this.e.get(Integer.valueOf(i));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.b;
    }

    public int getHeight(int i) {
        return a(i).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.e.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i) {
        return a(i);
    }

    public int[] getReferencedIds(int i) {
        Constraint a2 = a(i);
        return a2.layout.mReferenceIds == null ? new int[0] : Arrays.copyOf(a2.layout.mReferenceIds, a2.layout.mReferenceIds.length);
    }

    public int getVisibility(int i) {
        return a(i).propertySet.visibility;
    }

    public int getVisibilityMode(int i) {
        return a(i).propertySet.mVisibilityMode;
    }

    public int getWidth(int i) {
        return a(i).layout.mWidth;
    }

    public boolean isForceId() {
        return this.f2267c;
    }

    public void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint a2 = a(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.layout.mIsGuideline = true;
                    }
                    this.e.put(Integer.valueOf(a2.f2268a), a2);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void load(Context context, XmlPullParser xmlPullParser) {
        boolean z;
        boolean z2;
        try {
            int eventType = xmlPullParser.getEventType();
            Constraint constraint = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -2025855158:
                            z2 = true;
                            if (name.equals("Layout")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -1984451626:
                            z2 = true;
                            if (name.equals(TypedValues.MotionType.NAME)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -1962203927:
                            z2 = true;
                            if (name.equals(ViewTransition.CONSTRAINT_OVERRIDE)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -1269513683:
                            z2 = true;
                            if (name.equals("PropertySet")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -1238332596:
                            z2 = true;
                            if (name.equals("Transform")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case -71750448:
                            z2 = true;
                            if (name.equals("Guideline")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 366511058:
                            z2 = true;
                            if (name.equals(ViewTransition.CUSTOM_METHOD)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 1331510167:
                            z2 = true;
                            if (name.equals("Barrier")) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 1791837707:
                            z2 = true;
                            if (name.equals(ViewTransition.CUSTOM_ATTRIBUTE)) {
                                z2 = true;
                                break;
                            }
                            break;
                        case 1803088381:
                            z2 = true;
                            if (name.equals("Constraint")) {
                                z2 = false;
                                break;
                            }
                            break;
                        default:
                            z2 = true;
                            break;
                    }
                    switch (z2) {
                        case false:
                            constraint = a(context, Xml.asAttributeSet(xmlPullParser), false);
                            break;
                        case true:
                            constraint = a(context, Xml.asAttributeSet(xmlPullParser), true);
                            break;
                        case true:
                            constraint = a(context, Xml.asAttributeSet(xmlPullParser), false);
                            constraint.layout.mIsGuideline = true;
                            constraint.layout.mApply = true;
                            break;
                        case true:
                            constraint = a(context, Xml.asAttributeSet(xmlPullParser), false);
                            constraint.layout.mHelperType = 1;
                            break;
                        case true:
                            if (constraint == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            constraint.propertySet.a(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                        case true:
                            if (constraint == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            constraint.transform.a(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                        case true:
                            if (constraint == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            constraint.layout.a(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                        case true:
                            if (constraint == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            constraint.motion.a(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                        case true:
                        case true:
                            if (constraint == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            ConstraintAttribute.parse(context, xmlPullParser, constraint.mCustomConstraints);
                            break;
                    }
                } else if (eventType == 3) {
                    String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                    switch (lowerCase.hashCode()) {
                        case -2075718416:
                            z = true;
                            if (lowerCase.equals("guideline")) {
                                z = true;
                                break;
                            }
                            break;
                        case -190376483:
                            z = true;
                            if (lowerCase.equals("constraint")) {
                                z = true;
                                break;
                            }
                            break;
                        case 426575017:
                            z = true;
                            if (lowerCase.equals("constraintoverride")) {
                                z = true;
                                break;
                            }
                            break;
                        case 2146106725:
                            z = true;
                            if (lowerCase.equals("constraintset")) {
                                z = false;
                                break;
                            }
                            break;
                        default:
                            z = true;
                            break;
                    }
                    if (!z) {
                        return;
                    }
                    if (z || z || z) {
                        this.e.put(Integer.valueOf(constraint.f2268a), constraint);
                        constraint = null;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return;
            }
            String[] split2 = split[i2].split("=");
            if (split2.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + split[i2]);
            } else {
                constraint.b(split2[0], Color.parseColor(split2[1]));
            }
            i = i2 + 1;
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return;
            }
            String[] split2 = split[i2].split("=");
            if (split2.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + split[i2]);
            } else {
                constraint.a(split2[0], Float.parseFloat(split2[1]));
            }
            i = i2 + 1;
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return;
            }
            String[] split2 = split[i2].split("=");
            if (split2.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + split[i2]);
            } else {
                constraint.a(split2[0], Integer.decode(split2[1]).intValue());
            }
            i = i2 + 1;
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        String[] a2 = a(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.length) {
                return;
            }
            String[] split = a2[i2].split("=");
            Log.w("ConstraintSet", " Unable to parse " + a2[i2]);
            constraint.a(split[0], split[1]);
            i = i2 + 1;
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f2267c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.e.containsKey(Integer.valueOf(id))) {
                this.e.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = this.e.get(Integer.valueOf(id));
            if (constraint != null) {
                if (!constraint.layout.mApply) {
                    constraint.a(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                if (!constraint.propertySet.mApply) {
                    constraint.propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                if (Build.VERSION.SDK_INT >= 17 && !constraint.transform.mApply) {
                    constraint.transform.mApply = true;
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        constraint.transform.transformPivotX = pivotX;
                        constraint.transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        constraint.transform.translationZ = childAt.getTranslationZ();
                        if (constraint.transform.applyElevation) {
                            constraint.transform.elevation = childAt.getElevation();
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.e.keySet()) {
            int intValue = num.intValue();
            Constraint constraint = constraintSet.e.get(num);
            if (!this.e.containsKey(Integer.valueOf(intValue))) {
                this.e.put(Integer.valueOf(intValue), new Constraint());
            }
            Constraint constraint2 = this.e.get(Integer.valueOf(intValue));
            if (constraint2 != null) {
                if (!constraint2.layout.mApply) {
                    constraint2.layout.copyFrom(constraint.layout);
                }
                if (!constraint2.propertySet.mApply) {
                    constraint2.propertySet.copyFrom(constraint.propertySet);
                }
                if (!constraint2.transform.mApply) {
                    constraint2.transform.copyFrom(constraint.transform);
                }
                if (!constraint2.motion.mApply) {
                    constraint2.motion.copyFrom(constraint.motion);
                }
                for (String str : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(str)) {
                        constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                    }
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.b.remove(str);
    }

    public void removeFromHorizontalChain(int i) {
        Constraint constraint;
        if (!this.e.containsKey(Integer.valueOf(i)) || (constraint = this.e.get(Integer.valueOf(i))) == null) {
            return;
        }
        int i2 = constraint.layout.leftToRight;
        int i3 = constraint.layout.rightToLeft;
        if (i2 != -1 || i3 != -1) {
            if (i2 != -1 && i3 != -1) {
                connect(i2, 2, i3, 1, 0);
                connect(i3, 1, i2, 2, 0);
            } else if (constraint.layout.rightToRight != -1) {
                connect(i2, 2, constraint.layout.rightToRight, 2, 0);
            } else if (constraint.layout.leftToLeft != -1) {
                connect(i3, 1, constraint.layout.leftToLeft, 1, 0);
            }
            clear(i, 1);
            clear(i, 2);
            return;
        }
        int i4 = constraint.layout.startToEnd;
        int i5 = constraint.layout.endToStart;
        if (i4 != -1 || i5 != -1) {
            if (i4 != -1 && i5 != -1) {
                connect(i4, 7, i5, 6, 0);
                connect(i5, 6, i2, 7, 0);
            } else if (i5 != -1) {
                if (constraint.layout.rightToRight != -1) {
                    connect(i2, 7, constraint.layout.rightToRight, 7, 0);
                } else if (constraint.layout.leftToLeft != -1) {
                    connect(i5, 6, constraint.layout.leftToLeft, 6, 0);
                }
            }
        }
        clear(i, 6);
        clear(i, 7);
    }

    public void removeFromVerticalChain(int i) {
        if (this.e.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.e.get(Integer.valueOf(i));
            if (constraint == null) {
                return;
            }
            int i2 = constraint.layout.topToBottom;
            int i3 = constraint.layout.bottomToTop;
            if (i2 != -1 || i3 != -1) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 4, i3, 3, 0);
                    connect(i3, 3, i2, 4, 0);
                } else if (constraint.layout.bottomToBottom != -1) {
                    connect(i2, 4, constraint.layout.bottomToBottom, 4, 0);
                } else if (constraint.layout.topToTop != -1) {
                    connect(i3, 3, constraint.layout.topToTop, 3, 0);
                }
            }
        }
        clear(i, 3);
        clear(i, 4);
    }

    public void setAlpha(int i, float f2) {
        a(i).propertySet.alpha = f2;
    }

    public void setApplyElevation(int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i).transform.applyElevation = z;
        }
    }

    public void setBarrierType(int i, int i2) {
        a(i).layout.mHelperType = i2;
    }

    public void setColorValue(int i, String str, int i2) {
        a(i).b(str, i2);
    }

    public void setDimensionRatio(int i, String str) {
        a(i).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i, int i2) {
        a(i).layout.editorAbsoluteX = i2;
    }

    public void setEditorAbsoluteY(int i, int i2) {
        a(i).layout.editorAbsoluteY = i2;
    }

    public void setElevation(int i, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i).transform.elevation = f2;
            a(i).transform.applyElevation = true;
        }
    }

    public void setFloatValue(int i, String str, float f2) {
        a(i).a(str, f2);
    }

    public void setForceId(boolean z) {
        this.f2267c = z;
    }

    public void setGoneMargin(int i, int i2, int i3) {
        Constraint a2 = a(i);
        switch (i2) {
            case 1:
                a2.layout.goneLeftMargin = i3;
                return;
            case 2:
                a2.layout.goneRightMargin = i3;
                return;
            case 3:
                a2.layout.goneTopMargin = i3;
                return;
            case 4:
                a2.layout.goneBottomMargin = i3;
                return;
            case 5:
                a2.layout.goneBaselineMargin = i3;
                return;
            case 6:
                a2.layout.goneStartMargin = i3;
                return;
            case 7:
                a2.layout.goneEndMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        a(i).layout.guideBegin = i2;
        a(i).layout.guideEnd = -1;
        a(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i, int i2) {
        a(i).layout.guideEnd = i2;
        a(i).layout.guideBegin = -1;
        a(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i, float f2) {
        a(i).layout.guidePercent = f2;
        a(i).layout.guideEnd = -1;
        a(i).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i, float f2) {
        a(i).layout.horizontalBias = f2;
    }

    public void setHorizontalChainStyle(int i, int i2) {
        a(i).layout.horizontalChainStyle = i2;
    }

    public void setHorizontalWeight(int i, float f2) {
        a(i).layout.horizontalWeight = f2;
    }

    public void setIntValue(int i, String str, int i2) {
        a(i).a(str, i2);
    }

    public void setLayoutWrapBehavior(int i, int i2) {
        if (i2 < 0 || i2 > 3) {
            return;
        }
        a(i).layout.mWrapBehavior = i2;
    }

    public void setMargin(int i, int i2, int i3) {
        Constraint a2 = a(i);
        switch (i2) {
            case 1:
                a2.layout.leftMargin = i3;
                return;
            case 2:
                a2.layout.rightMargin = i3;
                return;
            case 3:
                a2.layout.topMargin = i3;
                return;
            case 4:
                a2.layout.bottomMargin = i3;
                return;
            case 5:
                a2.layout.baselineMargin = i3;
                return;
            case 6:
                a2.layout.startMargin = i3;
                return;
            case 7:
                a2.layout.endMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        a(i).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i, float f2) {
        a(i).transform.rotation = f2;
    }

    public void setRotationX(int i, float f2) {
        a(i).transform.rotationX = f2;
    }

    public void setRotationY(int i, float f2) {
        a(i).transform.rotationY = f2;
    }

    public void setScaleX(int i, float f2) {
        a(i).transform.scaleX = f2;
    }

    public void setScaleY(int i, float f2) {
        a(i).transform.scaleY = f2;
    }

    public void setStringValue(int i, String str, String str2) {
        a(i).a(str, str2);
    }

    public void setTransformPivot(int i, float f2, float f3) {
        Constraint a2 = a(i);
        a2.transform.transformPivotY = f3;
        a2.transform.transformPivotX = f2;
    }

    public void setTransformPivotX(int i, float f2) {
        a(i).transform.transformPivotX = f2;
    }

    public void setTransformPivotY(int i, float f2) {
        a(i).transform.transformPivotY = f2;
    }

    public void setTranslation(int i, float f2, float f3) {
        Constraint a2 = a(i);
        a2.transform.translationX = f2;
        a2.transform.translationY = f3;
    }

    public void setTranslationX(int i, float f2) {
        a(i).transform.translationX = f2;
    }

    public void setTranslationY(int i, float f2) {
        a(i).transform.translationY = f2;
    }

    public void setTranslationZ(int i, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            a(i).transform.translationZ = f2;
        }
    }

    public void setValidateOnParse(boolean z) {
        this.f2266a = z;
    }

    public void setVerticalBias(int i, float f2) {
        a(i).layout.verticalBias = f2;
    }

    public void setVerticalChainStyle(int i, int i2) {
        a(i).layout.verticalChainStyle = i2;
    }

    public void setVerticalWeight(int i, float f2) {
        a(i).layout.verticalWeight = f2;
    }

    public void setVisibility(int i, int i2) {
        a(i).propertySet.visibility = i2;
    }

    public void setVisibilityMode(int i, int i2) {
        a(i).propertySet.mVisibilityMode = i2;
    }

    public void writeState(Writer writer, ConstraintLayout constraintLayout, int i) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((i & 1) == 1) {
            new WriteXmlEngine(writer, constraintLayout, i).a();
        } else {
            new WriteJsonEngine(writer, constraintLayout, i).a();
        }
        writer.write("\n---------------------------------------------\n");
    }
}
