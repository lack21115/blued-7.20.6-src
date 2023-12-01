package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ArrowDrawable;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/header/ClassicsHeader.class */
public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements RefreshHeader {

    /* renamed from: a  reason: collision with root package name */
    public static String f14296a;
    public static String b;

    /* renamed from: c  reason: collision with root package name */
    public static String f14297c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    protected String i;
    protected Date j;
    protected TextView k;
    protected SharedPreferences l;
    protected DateFormat m;
    protected boolean n;
    protected String o;
    protected String p;
    protected String q;
    protected String r;
    protected String s;
    protected String t;
    protected String u;
    protected String v;

    /* renamed from: com.scwang.smartrefresh.layout.header.ClassicsHeader$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/header/ClassicsHeader$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14298a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[RefreshState.values().length];
            f14298a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14298a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14298a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14298a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14298a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14298a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f14298a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        this.i = "LAST_UPDATE_TIME";
        this.n = true;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        TextView textView = new TextView(context);
        this.k = textView;
        textView.setTextColor(-8618884);
        ImageView imageView = this.A;
        TextView textView2 = this.k;
        ImageView imageView2 = this.B;
        LinearLayout linearLayout = this.C;
        DensityUtil densityUtil = new DensityUtil();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextTimeMarginTop, densityUtil.b(0.0f));
        layoutParams2.rightMargin = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsFooter_srlDrawableMarginRight, densityUtil.b(20.0f));
        layoutParams.rightMargin = layoutParams2.rightMargin;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableArrowSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableProgressSize, layoutParams2.height);
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(R.styleable.ClassicsHeader_srlDrawableSize, layoutParams2.height);
        this.J = obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlFinishDuration, this.J);
        this.n = obtainStyledAttributes.getBoolean(R.styleable.ClassicsHeader_srlEnableLastTime, this.n);
        this.x = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.x.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableArrow)) {
            this.A.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableArrow));
        } else {
            this.E = new ArrowDrawable();
            this.E.a(-10066330);
            this.A.setImageDrawable(this.E);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlDrawableProgress)) {
            this.B.setImageDrawable(obtainStyledAttributes.getDrawable(R.styleable.ClassicsHeader_srlDrawableProgress));
        } else {
            this.F = new ProgressDrawable();
            this.F.a(-10066330);
            this.B.setImageDrawable(this.F);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.z.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTitle, DensityUtil.a(16.0f)));
        } else {
            this.z.setTextSize(16.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSizeTime)) {
            this.k.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClassicsHeader_srlTextSizeTime, DensityUtil.a(12.0f)));
        } else {
            this.k.setTextSize(12.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlPrimaryColor)) {
            super.c(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlPrimaryColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlAccentColor)) {
            b(obtainStyledAttributes.getColor(R.styleable.ClassicsHeader_srlAccentColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextPulling)) {
            this.o = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextPulling);
        } else {
            String str = f14296a;
            if (str != null) {
                this.o = str;
            } else {
                this.o = context.getString(R.string.srl_header_pulling);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextLoading)) {
            this.q = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextLoading);
        } else {
            String str2 = f14297c;
            if (str2 != null) {
                this.q = str2;
            } else {
                this.q = context.getString(R.string.srl_header_loading);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRelease)) {
            this.r = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRelease);
        } else {
            String str3 = d;
            if (str3 != null) {
                this.r = str3;
            } else {
                this.r = context.getString(R.string.srl_header_release);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFinish)) {
            this.s = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFinish);
        } else {
            String str4 = e;
            if (str4 != null) {
                this.s = str4;
            } else {
                this.s = context.getString(R.string.srl_header_finish);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextFailed)) {
            this.t = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextFailed);
        } else {
            String str5 = f;
            if (str5 != null) {
                this.t = str5;
            } else {
                this.t = context.getString(R.string.srl_header_failed);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextSecondary)) {
            this.v = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextSecondary);
        } else {
            String str6 = h;
            if (str6 != null) {
                this.v = str6;
            } else {
                this.v = context.getString(R.string.srl_header_secondary);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextRefreshing)) {
            this.p = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextRefreshing);
        } else {
            String str7 = b;
            if (str7 != null) {
                this.p = str7;
            } else {
                this.p = context.getString(R.string.srl_header_refreshing);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.ClassicsHeader_srlTextUpdate)) {
            this.u = obtainStyledAttributes.getString(R.styleable.ClassicsHeader_srlTextUpdate);
        } else {
            String str8 = g;
            if (str8 != null) {
                this.u = str8;
            } else {
                this.u = context.getString(R.string.srl_header_update);
            }
        }
        this.m = new SimpleDateFormat(this.u, Locale.getDefault());
        obtainStyledAttributes.recycle();
        textView2.setId(4);
        textView2.setVisibility(this.n ? 0 : 8);
        linearLayout.addView(textView2, layoutParams3);
        this.z.setText(isInEditMode() ? this.p : this.o);
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                a(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.i += context.getClass().getName();
        this.l = context.getSharedPreferences("ClassicsHeader", 0);
        a(new Date(this.l.getLong(this.i, System.currentTimeMillis())));
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        if (z) {
            this.z.setText(this.s);
            if (this.j != null) {
                a(new Date());
            }
        } else {
            this.z.setText(this.t);
        }
        return super.a(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics
    /* renamed from: a */
    public ClassicsHeader b(int i) {
        this.k.setTextColor((16777215 & i) | (-872415232));
        return (ClassicsHeader) super.b(i);
    }

    public ClassicsHeader a(Date date) {
        this.j = date;
        this.k.setText(this.m.format(date));
        if (this.l != null && !isInEditMode()) {
            this.l.edit().putLong(this.i, date.getTime()).apply();
        }
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        ImageView imageView = this.A;
        TextView textView = this.k;
        int i = 8;
        switch (AnonymousClass1.f14298a[refreshState2.ordinal()]) {
            case 1:
                if (this.n) {
                    i = 0;
                }
                textView.setVisibility(i);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.z.setText(this.p);
                imageView.setVisibility(8);
                return;
            case 5:
                this.z.setText(this.r);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.z.setText(this.v);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                if (this.n) {
                    i = 4;
                }
                textView.setVisibility(i);
                this.z.setText(this.q);
                return;
            default:
                return;
        }
        this.z.setText(this.o);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }
}
