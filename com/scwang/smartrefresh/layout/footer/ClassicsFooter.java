package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/footer/ClassicsFooter.class */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements RefreshFooter {

    /* renamed from: a  reason: collision with root package name */
    public static String f14288a;
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f14289c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    protected String h;
    protected String i;
    protected String j;
    protected String k;
    protected String l;
    protected String m;
    protected String n;
    protected boolean o;

    /* renamed from: com.scwang.smartrefresh.layout.footer.ClassicsFooter$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/footer/ClassicsFooter$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14290a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f14290a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14290a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14290a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14290a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14290a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14290a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = false;
        ImageView imageView = this.A;
        ImageView imageView2 = this.B;
        DensityUtil densityUtil = new DensityUtil();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, densityUtil.b(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsFooter_srlDrawableSize, layoutParams2.height);
        this.J = obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.J);
        this.x = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.x.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableArrow)) {
            this.A.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableArrow));
        } else {
            this.E = new ArrowDrawable();
            this.E.a(-10066330);
            this.A.setImageDrawable(this.E);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlDrawableProgress)) {
            this.B.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsFooter_srlDrawableProgress));
        } else {
            this.F = new ProgressDrawable();
            this.F.a(-10066330);
            this.B.setImageDrawable(this.F);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextSizeTitle)) {
            this.z.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlTextSizeTitle, DensityUtil.a(16.0f)));
        } else {
            this.z.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlPrimaryColor)) {
            super.c(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlAccentColor)) {
            super.b(obtainStyledAttributes.getColor(R.styleable.ClassicsFooter_srlAccentColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextPulling)) {
            this.h = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextPulling);
        } else {
            String str = f14288a;
            if (str != null) {
                this.h = str;
            } else {
                this.h = context.getString(R.string.srl_footer_pulling);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRelease)) {
            this.i = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRelease);
        } else {
            String str2 = b;
            if (str2 != null) {
                this.i = str2;
            } else {
                this.i = context.getString(R.string.srl_footer_release);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextLoading)) {
            this.j = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextLoading);
        } else {
            String str3 = f14289c;
            if (str3 != null) {
                this.j = str3;
            } else {
                this.j = context.getString(R.string.srl_footer_loading);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextRefreshing)) {
            this.k = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextRefreshing);
        } else {
            String str4 = d;
            if (str4 != null) {
                this.k = str4;
            } else {
                this.k = context.getString(R.string.srl_footer_refreshing);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFinish)) {
            this.l = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFinish);
        } else {
            String str5 = e;
            if (str5 != null) {
                this.l = str5;
            } else {
                this.l = context.getString(R.string.srl_footer_finish);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextFailed)) {
            this.m = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextFailed);
        } else {
            String str6 = f;
            if (str6 != null) {
                this.m = str6;
            } else {
                this.m = context.getString(R.string.srl_footer_failed);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsFooter_srlTextNothing)) {
            this.n = obtainStyledAttributes.getString(R.styleable.ClassicsFooter_srlTextNothing);
        } else {
            String str7 = g;
            if (str7 != null) {
                this.n = str7;
            } else {
                this.n = context.getString(R.string.srl_footer_nothing);
            }
        }
        obtainStyledAttributes.recycle();
        this.z.setTextColor(-10066330);
        this.z.setText(isInEditMode() ? this.j : this.h);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        if (this.o) {
            return 0;
        }
        this.z.setText(z ? this.l : this.m);
        return super.a(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(RefreshLayout refreshLayout, int i, int i2) {
        if (this.o) {
            return;
        }
        super.a(refreshLayout, i, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.A;
        if (this.o) {
            return;
        }
        switch (AnonymousClass1.f14290a[refreshState2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.z.setText(this.j);
                return;
            case 5:
                this.z.setText(this.i);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.z.setText(this.k);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
        this.z.setText(this.h);
        imageView.animate().rotation(180.0f);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean a(boolean z) {
        if (this.o != z) {
            this.o = z;
            ImageView imageView = this.A;
            if (z) {
                this.z.setText(this.n);
                imageView.setVisibility(8);
                return true;
            }
            this.z.setText(this.h);
            imageView.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.x == SpinnerStyle.FixedBehind) {
            super.setPrimaryColors(iArr);
        }
    }
}
