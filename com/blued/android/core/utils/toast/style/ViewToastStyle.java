package com.blued.android.core.utils.toast.style;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.utils.toast.config.IToastStyle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/style/ViewToastStyle.class */
public class ViewToastStyle implements IToastStyle<View> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9772a;
    private final IToastStyle<?> b;

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public int a() {
        IToastStyle<?> iToastStyle = this.b;
        if (iToastStyle == null) {
            return 17;
        }
        return iToastStyle.a();
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public View a(Context context) {
        return LayoutInflater.from(context).inflate(this.f9772a, (ViewGroup) null);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public float b() {
        IToastStyle<?> iToastStyle = this.b;
        if (iToastStyle == null) {
            return 0.0f;
        }
        return iToastStyle.b();
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public int b(Context context) {
        IToastStyle<?> iToastStyle = this.b;
        if (iToastStyle == null) {
            return 0;
        }
        return iToastStyle.b(context);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public float c() {
        IToastStyle<?> iToastStyle = this.b;
        if (iToastStyle == null) {
            return 0.0f;
        }
        return iToastStyle.c();
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public int c(Context context) {
        IToastStyle<?> iToastStyle = this.b;
        if (iToastStyle == null) {
            return 0;
        }
        return iToastStyle.c(context);
    }
}
