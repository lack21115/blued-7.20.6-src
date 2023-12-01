package com.blued.android.core.utils.toast.style;

import android.content.Context;
import android.view.View;
import com.blued.android.core.utils.toast.config.IToastStyle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/style/LocationToastStyle.class */
public class LocationToastStyle implements IToastStyle<View> {

    /* renamed from: a  reason: collision with root package name */
    private final IToastStyle<?> f9770a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9771c;
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
        return this.f9770a.a(context);
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public float b() {
        return this.e;
    }

    @Override // com.blued.android.core.utils.toast.config.IToastStyle
    public int b(Context context) {
        return this.f9771c;
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
