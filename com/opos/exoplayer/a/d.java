package com.opos.exoplayer.a;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.opos.exoplayer.core.f.j;
import com.opos.exoplayer.core.i.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/a/d.class */
public final class d extends View implements j {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f24996a;
    private List<com.opos.exoplayer.core.f.b> b;

    /* renamed from: c  reason: collision with root package name */
    private int f24997c;
    private float d;
    private boolean e;
    private boolean f;
    private com.opos.exoplayer.core.f.a g;
    private float h;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24996a = new ArrayList();
        this.f24997c = 0;
        this.d = 0.0533f;
        this.e = true;
        this.f = true;
        this.g = com.opos.exoplayer.core.f.a.f25325a;
        this.h = 0.08f;
    }

    private void a(int i, float f) {
        if (this.f24997c == i && this.d == f) {
            return;
        }
        this.f24997c = i;
        this.d = f;
        invalidate();
    }

    private float c() {
        return ((CaptioningManager) getContext().getSystemService(Context.CAPTIONING_SERVICE)).getFontScale();
    }

    private com.opos.exoplayer.core.f.a d() {
        return com.opos.exoplayer.core.f.a.a(((CaptioningManager) getContext().getSystemService(Context.CAPTIONING_SERVICE)).getUserStyle());
    }

    public void a() {
        a(((u.f25510a < 19 || isInEditMode()) ? 1.0f : c()) * 0.0533f);
    }

    public void a(float f) {
        a(f, false);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(float f, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(com.opos.exoplayer.core.f.a aVar) {
        if (this.g == aVar) {
            return;
        }
        this.g = aVar;
        invalidate();
    }

    @Override // com.opos.exoplayer.core.f.j
    public void a(List<com.opos.exoplayer.core.f.b> list) {
        b(list);
    }

    public void b() {
        a((u.f25510a < 19 || isInEditMode()) ? com.opos.exoplayer.core.f.a.f25325a : d());
    }

    public void b(List<com.opos.exoplayer.core.f.b> list) {
        if (this.b == list) {
            return;
        }
        this.b = list;
        int size = list == null ? 0 : list.size();
        while (this.f24996a.size() < size) {
            this.f24996a.add(new e(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<com.opos.exoplayer.core.f.b> list = this.b;
        int size = list == null ? 0 : list.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom <= paddingTop || right <= left) {
            return;
        }
        int i = this.f24997c;
        float f = i == 2 ? this.d : (i == 0 ? paddingBottom - paddingTop : bottom - top) * this.d;
        if (f > 0.0f) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f24996a.get(i2).a(this.b.get(i2), this.e, this.f, this.g, f, this.h, canvas, left, paddingTop, right, paddingBottom);
            }
        }
    }
}
