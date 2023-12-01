package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/Dimension.class */
public class Dimension {

    /* renamed from: a  reason: collision with root package name */
    int f2042a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    float f2043c;
    int d;
    String e;
    Object f;
    boolean g;
    private final int h;
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object WRAP_DIMENSION = new Object();
    public static final Object SPREAD_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION = new Object();
    public static final Object PERCENT_DIMENSION = new Object();
    public static final Object RATIO_DIMENSION = new Object();

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/Dimension$Type.class */
    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.h = -2;
        this.f2042a = 0;
        this.b = Integer.MAX_VALUE;
        this.f2043c = 1.0f;
        this.d = 0;
        this.e = null;
        this.f = WRAP_DIMENSION;
        this.g = false;
    }

    private Dimension(Object obj) {
        this.h = -2;
        this.f2042a = 0;
        this.b = Integer.MAX_VALUE;
        this.f2043c = 1.0f;
        this.d = 0;
        this.e = null;
        this.f = WRAP_DIMENSION;
        this.g = false;
        this.f = obj;
    }

    public static Dimension Fixed(int i) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i);
        return dimension;
    }

    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object obj, float f) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f);
        return dimension;
    }

    public static Dimension Ratio(String str) {
        Dimension dimension = new Dimension(RATIO_DIMENSION);
        dimension.ratio(str);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int i) {
        Dimension dimension = new Dimension();
        dimension.suggested(i);
        return dimension;
    }

    public static Dimension Suggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.d;
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i) {
        String str = this.e;
        if (str != null) {
            constraintWidget.setDimensionRatio(str);
        }
        if (i == 0) {
            if (this.g) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.f;
                constraintWidget.setHorizontalMatchStyle(obj == WRAP_DIMENSION ? 1 : obj == PERCENT_DIMENSION ? 2 : 0, this.f2042a, this.b, this.f2043c);
                return;
            }
            int i2 = this.f2042a;
            if (i2 > 0) {
                constraintWidget.setMinWidth(i2);
            }
            int i3 = this.b;
            if (i3 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i3);
            }
            Object obj2 = this.f;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj2 == null) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setWidth(this.d);
            }
        } else if (this.g) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.f;
            constraintWidget.setVerticalMatchStyle(obj3 == WRAP_DIMENSION ? 1 : obj3 == PERCENT_DIMENSION ? 2 : 0, this.f2042a, this.b, this.f2043c);
        } else {
            int i4 = this.f2042a;
            if (i4 > 0) {
                constraintWidget.setMinHeight(i4);
            }
            int i5 = this.b;
            if (i5 < Integer.MAX_VALUE) {
                constraintWidget.setMaxHeight(i5);
            }
            Object obj4 = this.f;
            if (obj4 == WRAP_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj4 == PARENT_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj4 == null) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(this.d);
            }
        }
    }

    public boolean equalsFixedValue(int i) {
        return this.f == null && this.d == i;
    }

    public Dimension fixed(int i) {
        this.f = null;
        this.d = i;
        return this;
    }

    public Dimension fixed(Object obj) {
        this.f = obj;
        if (obj instanceof Integer) {
            this.d = ((Integer) obj).intValue();
            this.f = null;
        }
        return this;
    }

    public Dimension max(int i) {
        if (this.b >= 0) {
            this.b = i;
        }
        return this;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.g) {
            this.f = obj2;
            this.b = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension min(int i) {
        if (i >= 0) {
            this.f2042a = i;
        }
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.f2042a = -2;
        }
        return this;
    }

    public Dimension percent(Object obj, float f) {
        this.f2043c = f;
        return this;
    }

    public Dimension ratio(String str) {
        this.e = str;
        return this;
    }

    public Dimension suggested(int i) {
        this.g = true;
        if (i >= 0) {
            this.b = i;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.f = obj;
        this.g = true;
        return this;
    }
}
