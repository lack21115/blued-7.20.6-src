package com.tencent.smtt.sdk.ui.dialog.widget;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/ui/dialog/widget/b.class */
public class b extends Button {

    /* renamed from: a  reason: collision with root package name */
    private int f25217a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private float f25218c;
    private float d;
    private float e;
    private float f;
    private c g;
    private c h;
    private c i;

    public b(Context context, float f, float f2, float f3, float f4, int i) {
        super(context);
        this.g = null;
        this.h = null;
        this.i = null;
        this.f25218c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
        this.f25217a = i;
        this.b = Color.parseColor("#D0D0D0");
        a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(android.content.Context r9, int r10, int r11) {
        /*
            r8 = this;
            r0 = r10
            float r0 = (float) r0
            r12 = r0
            r0 = r8
            r1 = r9
            r2 = r12
            r3 = r12
            r4 = r12
            r5 = r12
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ui.dialog.widget.b.<init>(android.content.Context, int, int):void");
    }

    public void a() {
        c cVar = new c(this.f25217a, this.f25218c, this.d, this.e, this.f);
        this.g = cVar;
        cVar.a(getWidth(), getHeight());
        c cVar2 = new c(1342177280 | (this.f25217a & 16777215), this.f25218c, this.d, this.e, this.f);
        this.h = cVar2;
        cVar2.a(getWidth(), getHeight());
        c cVar3 = new c(this.b, this.f25218c, this.d, this.e, this.f);
        this.i = cVar3;
        cVar3.a(getWidth(), getHeight());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled, -16842919}, this.g);
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_pressed}, this.h);
        stateListDrawable.addState(new int[]{-16842910}, this.i);
        setBackgroundDrawable(stateListDrawable);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(i3 - i, i4 - i2);
        }
        c cVar2 = this.h;
        if (cVar2 != null) {
            cVar2.a(i3 - i, i4 - i2);
        }
        c cVar3 = this.i;
        if (cVar3 != null) {
            cVar3.a(i3 - i, i4 - i2);
        }
    }
}
