package com.blued.android.module.live_china.utils.dslspannable;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/dslspannable/DslSpanBuilderImpl.class */
public final class DslSpanBuilderImpl implements DslSpanBuilder {
    private boolean a;
    private boolean c;
    private boolean d;
    private Function0<Unit> e;
    private boolean f;
    private boolean h;
    private Typeface i;
    private boolean j;
    private boolean k;
    private int l;
    private int b = View.MEASURED_STATE_MASK;
    private float g = 1.0f;

    public DslSpanBuilderImpl() {
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.c(DEFAULT, "DEFAULT");
        this.i = DEFAULT;
    }

    @Override // com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder
    public void a(int i) {
        this.a = true;
        this.b = i;
    }

    @Override // com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder
    public void a(Context context, int i) {
        Intrinsics.e(context, "context");
        a(ContextCompat.getColor(AppInfo.d(), i));
    }

    public final boolean a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final Function0<Unit> e() {
        return this.e;
    }

    public final boolean f() {
        return this.f;
    }

    public final float g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public final Typeface i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final int l() {
        return this.l;
    }
}
