package com.blued.android.core.utils.toast.style;

import android.content.Context;
import android.view.View;
import com.blued.android.core.utils.toast.config.IToastStyle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/style/LocationToastStyle.class */
public class LocationToastStyle implements IToastStyle<View> {
    private final IToastStyle<?> a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    private final float f;

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public int a() {
        return this.b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View] */
    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public View a(Context context) {
        return this.a.a(context);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public float b() {
        return this.e;
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public int b(Context context) {
        return this.c;
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public float c() {
        return this.f;
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public int c(Context context) {
        return this.d;
    }
}
