package com.blued.android.framework.view.SuperToast;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.blued.android.framework.R;
import com.blued.android.framework.view.SuperToast.utils.AccessibilityUtils;
import com.blued.android.framework.view.SuperToast.utils.BackgroundUtils;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/SuperToast.class */
public class SuperToast {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10194a;
    private final View b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f10195c;
    private Style d;
    private OnDismissListener e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/SuperToast$OnDismissListener.class */
    public interface OnDismissListener {
        void a(View view, Parcelable parcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SuperToast(Context context, int i) {
        this.f10194a = context;
        Style style = new Style();
        this.d = style;
        style.w = i;
        View a2 = a(context, (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), i);
        this.b = a2;
        this.f10195c = (TextView) a2.findViewById(R.id.message);
    }

    public SuperToast(Context context, Style style) {
        this.f10194a = context;
        this.d = style;
        View a2 = a(context, (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), this.d.w);
        this.b = a2;
        this.f10195c = (TextView) a2.findViewById(R.id.message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SuperToast(Context context, Style style, int i) {
        this.f10194a = context;
        this.d = style;
        style.w = i;
        View a2 = a(context, (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), i);
        this.b = a2;
        this.f10195c = (TextView) a2.findViewById(R.id.message);
    }

    protected View a(Context context, LayoutInflater layoutInflater, int i) {
        return layoutInflater.inflate(R.layout.supertoast_button, (ViewGroup) null);
    }

    public SuperToast a(int i) {
        if (i <= 5000) {
            this.d.b = i;
            return this;
        }
        Log.e(getClass().getName(), "SuperToast duration cannot exceed 4500ms.");
        this.d.b = 5000;
        return this;
    }

    public SuperToast b(int i, int i2, int i3) {
        this.d.g = i;
        this.d.h = i2;
        this.d.i = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        int i = Build.VERSION.SDK_INT;
        TextView textView = this.f10195c;
        if (textView != null) {
            textView.setText(this.d.f10189a);
            TextView textView2 = this.f10195c;
            textView2.setTypeface(textView2.getTypeface(), this.d.q);
            this.f10195c.setTextColor(this.d.r);
            this.f10195c.setTextSize(this.d.s);
            if (this.d.u > 0) {
                if (this.d.t == 1) {
                    this.f10195c.setCompoundDrawablesWithIntrinsicBounds(this.d.u, 0, 0, 0);
                } else if (this.d.t == 4) {
                    this.f10195c.setCompoundDrawablesWithIntrinsicBounds(0, this.d.u, 0, 0);
                } else if (this.d.t == 2) {
                    this.f10195c.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.d.u, 0);
                } else if (this.d.t == 3) {
                    this.f10195c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, this.d.u);
                }
            }
        }
        if (i >= 16) {
            View view = this.b;
            Style style = this.d;
            view.setBackground(BackgroundUtils.a(style, style.f10190c));
            if (i >= 21) {
                this.b.setElevation(3.0f);
            }
        } else {
            View view2 = this.b;
            Style style2 = this.d;
            view2.setBackgroundDrawable(BackgroundUtils.a(style2, style2.f10190c));
        }
        if (this.d.e == 3) {
            TextView textView3 = this.f10195c;
            if (textView3 != null) {
                textView3.setGravity(8388611);
            }
            if ((this.f10194a.getResources().getConfiguration().screenLayout & 15) >= 3) {
                this.d.h = BackgroundUtils.b(12);
                this.d.i = BackgroundUtils.b(12);
                this.d.j = BackgroundUtils.b(288);
                this.d.g = BadgeDrawable.BOTTOM_START;
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(BackgroundUtils.b(2));
                gradientDrawable.setColor(this.d.f10190c);
                if (i >= 16) {
                    this.b.setBackground(gradientDrawable);
                } else {
                    this.b.setBackgroundDrawable(gradientDrawable);
                }
            } else {
                this.d.i = 0;
                this.d.j = -1;
            }
            if (this.d.d != 0) {
                this.b.findViewById(R.id.border).setVisibility(0);
                this.b.findViewById(R.id.border).setBackgroundColor(this.d.d);
            }
        }
        j().o = System.currentTimeMillis();
    }

    public Context getContext() {
        return this.f10194a;
    }

    public int h() {
        return this.d.b;
    }

    public OnDismissListener i() {
        return this.e;
    }

    public Style j() {
        return this.d;
    }

    public View k() {
        return this.b;
    }

    public boolean l() {
        View view = this.b;
        return view != null && view.isShown();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowManager.LayoutParams m() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.height = this.d.k;
        layoutParams.width = this.d.j;
        layoutParams.flags = 152;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 16973826;
        layoutParams.type = 2005;
        layoutParams.gravity = this.d.g;
        layoutParams.x = 0;
        layoutParams.y = 0;
        return layoutParams;
    }

    public void n() {
        f();
        Toaster.a().a(this);
        AccessibilityUtils.a(this.b);
    }

    public void o() {
        Toaster.a().b(this);
    }
}
