package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.hms.ads.jsb.constant.Constant;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintProperties.class */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a  reason: collision with root package name */
    ConstraintLayout.LayoutParams f2265a;
    View b;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout.LayoutParams)) {
            throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
        }
        this.f2265a = (ConstraintLayout.LayoutParams) layoutParams;
        this.b = view;
    }

    private String a(int i) {
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

    public ConstraintProperties addToHorizontalChain(int i, int i2) {
        connect(1, i, i == 0 ? 1 : 2, 0);
        connect(2, i2, i2 == 0 ? 2 : 1, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i)).connect(2, this.b.getId(), 1, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2)).connect(1, this.b.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i, int i2) {
        connect(6, i, i == 0 ? 6 : 7, 0);
        connect(7, i2, i2 == 0 ? 7 : 6, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i)).connect(7, this.b.getId(), 6, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2)).connect(6, this.b.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i, int i2) {
        connect(3, i, i == 0 ? 3 : 4, 0);
        connect(4, i2, i2 == 0 ? 4 : 3, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i)).connect(4, this.b.getId(), 3, 0);
        }
        if (i2 != 0) {
            new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2)).connect(3, this.b.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f) {
        this.b.setAlpha(f);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        if (i3 >= 0) {
            if (i6 >= 0) {
                if (f <= 0.0f || f > 1.0f) {
                    throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
                }
                if (i2 == 1 || i2 == 2) {
                    connect(1, i, i2, i3);
                    connect(2, i4, i5, i6);
                    this.f2265a.horizontalBias = f;
                    return this;
                } else if (i2 == 6 || i2 == 7) {
                    connect(6, i, i2, i3);
                    connect(7, i4, i5, i6);
                    this.f2265a.horizontalBias = f;
                    return this;
                } else {
                    connect(3, i, i2, i3);
                    connect(4, i4, i5, i6);
                    this.f2265a.verticalBias = f;
                    return this;
                }
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
        throw new IllegalArgumentException("margin must be > 0");
    }

    public ConstraintProperties centerHorizontally(int i) {
        if (i == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
            return this;
        }
        center(i, 2, 0, i, 1, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(1, i, i2, i3);
        connect(2, i4, i5, i6);
        this.f2265a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i) {
        if (i == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
            return this;
        }
        center(i, 7, 0, i, 6, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(6, i, i2, i3);
        connect(7, i4, i5, i6);
        this.f2265a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerVertically(int i) {
        if (i == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
            return this;
        }
        center(i, 4, 0, i, 3, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerVertically(int i, int i2, int i3, int i4, int i5, int i6, float f) {
        connect(3, i, i2, i3);
        connect(4, i4, i5, i6);
        this.f2265a.verticalBias = f;
        return this;
    }

    public ConstraintProperties connect(int i, int i2, int i3, int i4) {
        switch (i) {
            case 1:
                if (i3 == 1) {
                    this.f2265a.leftToLeft = i2;
                    this.f2265a.leftToRight = -1;
                } else if (i3 != 2) {
                    throw new IllegalArgumentException("Left to " + a(i3) + " undefined");
                } else {
                    this.f2265a.leftToRight = i2;
                    this.f2265a.leftToLeft = -1;
                }
                this.f2265a.leftMargin = i4;
                break;
            case 2:
                if (i3 == 1) {
                    this.f2265a.rightToLeft = i2;
                    this.f2265a.rightToRight = -1;
                } else if (i3 != 2) {
                    throw new IllegalArgumentException("right to " + a(i3) + " undefined");
                } else {
                    this.f2265a.rightToRight = i2;
                    this.f2265a.rightToLeft = -1;
                }
                this.f2265a.rightMargin = i4;
                return this;
            case 3:
                if (i3 == 3) {
                    this.f2265a.topToTop = i2;
                    this.f2265a.topToBottom = -1;
                    this.f2265a.baselineToBaseline = -1;
                    this.f2265a.baselineToTop = -1;
                    this.f2265a.baselineToBottom = -1;
                } else if (i3 != 4) {
                    throw new IllegalArgumentException("right to " + a(i3) + " undefined");
                } else {
                    this.f2265a.topToBottom = i2;
                    this.f2265a.topToTop = -1;
                    this.f2265a.baselineToBaseline = -1;
                    this.f2265a.baselineToTop = -1;
                    this.f2265a.baselineToBottom = -1;
                }
                this.f2265a.topMargin = i4;
                return this;
            case 4:
                if (i3 == 4) {
                    this.f2265a.bottomToBottom = i2;
                    this.f2265a.bottomToTop = -1;
                    this.f2265a.baselineToBaseline = -1;
                    this.f2265a.baselineToTop = -1;
                    this.f2265a.baselineToBottom = -1;
                } else if (i3 != 3) {
                    throw new IllegalArgumentException("right to " + a(i3) + " undefined");
                } else {
                    this.f2265a.bottomToTop = i2;
                    this.f2265a.bottomToBottom = -1;
                    this.f2265a.baselineToBaseline = -1;
                    this.f2265a.baselineToTop = -1;
                    this.f2265a.baselineToBottom = -1;
                }
                this.f2265a.bottomMargin = i4;
                return this;
            case 5:
                if (i3 == 5) {
                    this.f2265a.baselineToBaseline = i2;
                    this.f2265a.bottomToBottom = -1;
                    this.f2265a.bottomToTop = -1;
                    this.f2265a.topToTop = -1;
                    this.f2265a.topToBottom = -1;
                }
                if (i3 == 3) {
                    this.f2265a.baselineToTop = i2;
                    this.f2265a.bottomToBottom = -1;
                    this.f2265a.bottomToTop = -1;
                    this.f2265a.topToTop = -1;
                    this.f2265a.topToBottom = -1;
                } else if (i3 != 4) {
                    throw new IllegalArgumentException("right to " + a(i3) + " undefined");
                } else {
                    this.f2265a.baselineToBottom = i2;
                    this.f2265a.bottomToBottom = -1;
                    this.f2265a.bottomToTop = -1;
                    this.f2265a.topToTop = -1;
                    this.f2265a.topToBottom = -1;
                }
                this.f2265a.baselineMargin = i4;
                return this;
            case 6:
                if (i3 == 6) {
                    this.f2265a.startToStart = i2;
                    this.f2265a.startToEnd = -1;
                } else if (i3 != 7) {
                    throw new IllegalArgumentException("right to " + a(i3) + " undefined");
                } else {
                    this.f2265a.startToEnd = i2;
                    this.f2265a.startToStart = -1;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f2265a.setMarginStart(i4);
                    return this;
                }
                break;
            case 7:
                if (i3 == 7) {
                    this.f2265a.endToEnd = i2;
                    this.f2265a.endToStart = -1;
                } else if (i3 != 6) {
                    throw new IllegalArgumentException("right to " + a(i3) + " undefined");
                } else {
                    this.f2265a.endToStart = i2;
                    this.f2265a.endToEnd = -1;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f2265a.setMarginEnd(i4);
                    return this;
                }
                break;
            default:
                throw new IllegalArgumentException(a(i) + " to " + a(i3) + " unknown");
        }
        return this;
    }

    public ConstraintProperties constrainDefaultHeight(int i) {
        this.f2265a.matchConstraintDefaultHeight = i;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i) {
        this.f2265a.matchConstraintDefaultWidth = i;
        return this;
    }

    public ConstraintProperties constrainHeight(int i) {
        this.f2265a.height = i;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i) {
        this.f2265a.matchConstraintMaxHeight = i;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i) {
        this.f2265a.matchConstraintMaxWidth = i;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i) {
        this.f2265a.matchConstraintMinHeight = i;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i) {
        this.f2265a.matchConstraintMinWidth = i;
        return this;
    }

    public ConstraintProperties constrainWidth(int i) {
        this.f2265a.width = i;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.f2265a.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setElevation(f);
        }
        return this;
    }

    public ConstraintProperties goneMargin(int i, int i2) {
        switch (i) {
            case 1:
                this.f2265a.goneLeftMargin = i2;
                return this;
            case 2:
                this.f2265a.goneRightMargin = i2;
                return this;
            case 3:
                this.f2265a.goneTopMargin = i2;
                return this;
            case 4:
                this.f2265a.goneBottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f2265a.goneStartMargin = i2;
                return this;
            case 7:
                this.f2265a.goneEndMargin = i2;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f) {
        this.f2265a.horizontalBias = f;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i) {
        this.f2265a.horizontalChainStyle = i;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f) {
        this.f2265a.horizontalWeight = f;
        return this;
    }

    public ConstraintProperties margin(int i, int i2) {
        switch (i) {
            case 1:
                this.f2265a.leftMargin = i2;
                return this;
            case 2:
                this.f2265a.rightMargin = i2;
                return this;
            case 3:
                this.f2265a.topMargin = i2;
                return this;
            case 4:
                this.f2265a.bottomMargin = i2;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f2265a.setMarginStart(i2);
                return this;
            case 7:
                this.f2265a.setMarginEnd(i2);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i) {
        switch (i) {
            case 1:
                this.f2265a.leftToRight = -1;
                this.f2265a.leftToLeft = -1;
                this.f2265a.leftMargin = -1;
                this.f2265a.goneLeftMargin = Integer.MIN_VALUE;
                return this;
            case 2:
                this.f2265a.rightToRight = -1;
                this.f2265a.rightToLeft = -1;
                this.f2265a.rightMargin = -1;
                this.f2265a.goneRightMargin = Integer.MIN_VALUE;
                return this;
            case 3:
                this.f2265a.topToBottom = -1;
                this.f2265a.topToTop = -1;
                this.f2265a.topMargin = -1;
                this.f2265a.goneTopMargin = Integer.MIN_VALUE;
                return this;
            case 4:
                this.f2265a.bottomToTop = -1;
                this.f2265a.bottomToBottom = -1;
                this.f2265a.bottomMargin = -1;
                this.f2265a.goneBottomMargin = Integer.MIN_VALUE;
                return this;
            case 5:
                this.f2265a.baselineToBaseline = -1;
                return this;
            case 6:
                this.f2265a.startToEnd = -1;
                this.f2265a.startToStart = -1;
                this.f2265a.setMarginStart(-1);
                this.f2265a.goneStartMargin = Integer.MIN_VALUE;
                return this;
            case 7:
                this.f2265a.endToStart = -1;
                this.f2265a.endToEnd = -1;
                this.f2265a.setMarginEnd(-1);
                this.f2265a.goneEndMargin = Integer.MIN_VALUE;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        int i = this.f2265a.leftToRight;
        int i2 = this.f2265a.rightToLeft;
        ConstraintLayout.LayoutParams layoutParams = this.f2265a;
        if (i != -1 || i2 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2));
            if (i != -1 && i2 != -1) {
                constraintProperties.connect(2, i2, 1, 0);
                constraintProperties2.connect(1, i, 2, 0);
            } else if (i != -1 || i2 != -1) {
                int i3 = this.f2265a.rightToRight;
                ConstraintLayout.LayoutParams layoutParams2 = this.f2265a;
                if (i3 != -1) {
                    constraintProperties.connect(2, layoutParams2.rightToRight, 2, 0);
                } else {
                    int i4 = layoutParams2.leftToLeft;
                    ConstraintLayout.LayoutParams layoutParams3 = this.f2265a;
                    if (i4 != -1) {
                        constraintProperties2.connect(1, layoutParams3.leftToLeft, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
            return this;
        }
        int i5 = layoutParams.startToEnd;
        int i6 = this.f2265a.endToStart;
        if (i5 != -1 || i6 != -1) {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i5));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i6));
            if (i5 != -1 && i6 != -1) {
                constraintProperties3.connect(7, i6, 6, 0);
                constraintProperties4.connect(6, i, 7, 0);
            } else if (i != -1 || i6 != -1) {
                int i7 = this.f2265a.rightToRight;
                ConstraintLayout.LayoutParams layoutParams4 = this.f2265a;
                if (i7 != -1) {
                    constraintProperties3.connect(7, layoutParams4.rightToRight, 7, 0);
                } else {
                    int i8 = layoutParams4.leftToLeft;
                    ConstraintLayout.LayoutParams layoutParams5 = this.f2265a;
                    if (i8 != -1) {
                        constraintProperties4.connect(6, layoutParams5.leftToLeft, 6, 0);
                    }
                }
            }
        }
        removeConstraints(6);
        removeConstraints(7);
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        int i = this.f2265a.topToBottom;
        int i2 = this.f2265a.bottomToTop;
        if (i != -1 || i2 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.b.getParent()).findViewById(i2));
            if (i != -1 && i2 != -1) {
                constraintProperties.connect(4, i2, 3, 0);
                constraintProperties2.connect(3, i, 4, 0);
            } else if (i != -1 || i2 != -1) {
                int i3 = this.f2265a.bottomToBottom;
                ConstraintLayout.LayoutParams layoutParams = this.f2265a;
                if (i3 != -1) {
                    constraintProperties.connect(4, layoutParams.bottomToBottom, 4, 0);
                } else {
                    int i4 = layoutParams.topToTop;
                    ConstraintLayout.LayoutParams layoutParams2 = this.f2265a;
                    if (i4 != -1) {
                        constraintProperties2.connect(3, layoutParams2.topToTop, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f) {
        this.b.setRotation(f);
        return this;
    }

    public ConstraintProperties rotationX(float f) {
        this.b.setRotationX(f);
        return this;
    }

    public ConstraintProperties rotationY(float f) {
        this.b.setRotationY(f);
        return this;
    }

    public ConstraintProperties scaleX(float f) {
        this.b.setScaleY(f);
        return this;
    }

    public ConstraintProperties scaleY(float f) {
        return this;
    }

    public ConstraintProperties transformPivot(float f, float f2) {
        this.b.setPivotX(f);
        this.b.setPivotY(f2);
        return this;
    }

    public ConstraintProperties transformPivotX(float f) {
        this.b.setPivotX(f);
        return this;
    }

    public ConstraintProperties transformPivotY(float f) {
        this.b.setPivotY(f);
        return this;
    }

    public ConstraintProperties translation(float f, float f2) {
        this.b.setTranslationX(f);
        this.b.setTranslationY(f2);
        return this;
    }

    public ConstraintProperties translationX(float f) {
        this.b.setTranslationX(f);
        return this;
    }

    public ConstraintProperties translationY(float f) {
        this.b.setTranslationY(f);
        return this;
    }

    public ConstraintProperties translationZ(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setTranslationZ(f);
        }
        return this;
    }

    public ConstraintProperties verticalBias(float f) {
        this.f2265a.verticalBias = f;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i) {
        this.f2265a.verticalChainStyle = i;
        return this;
    }

    public ConstraintProperties verticalWeight(float f) {
        this.f2265a.verticalWeight = f;
        return this;
    }

    public ConstraintProperties visibility(int i) {
        this.b.setVisibility(i);
        return this;
    }
}
