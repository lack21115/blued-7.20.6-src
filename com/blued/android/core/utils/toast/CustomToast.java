package com.blued.android.core.utils.toast;

import android.view.View;
import android.widget.TextView;
import com.blued.android.core.utils.toast.config.IToast;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/CustomToast.class */
public abstract class CustomToast implements IToast {

    /* renamed from: a  reason: collision with root package name */
    private View f9750a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private int f9751c;
    private int d;
    private int e;
    private int f;
    private float g;
    private float h;
    private int i = 16973828;
    private int j = 2000;
    private int k = 3500;

    public View a() {
        return this.f9750a;
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public /* synthetic */ TextView a(View view) {
        return IToast.CC.$default$a(this, view);
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.f9751c;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public float f() {
        return this.g;
    }

    public float g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    public int j() {
        return this.k;
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void setDuration(int i) {
        this.d = i;
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void setGravity(int i, int i2, int i3) {
        this.f9751c = i;
        this.e = i2;
        this.f = i3;
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void setMargin(float f, float f2) {
        this.g = f;
        this.h = f2;
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void setText(CharSequence charSequence) {
        TextView textView = this.b;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void setView(View view) {
        this.f9750a = view;
        if (view == null) {
            this.b = null;
        } else {
            this.b = a(view);
        }
    }
}
