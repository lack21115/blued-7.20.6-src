package com.github.mikephil.charting.renderer;

import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/AxisRenderer.class */
public abstract class AxisRenderer extends Renderer {

    /* renamed from: a  reason: collision with root package name */
    protected AxisBase f8561a;
    protected Transformer b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f8562c;
    protected Paint d;
    protected Paint e;
    protected Paint f;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.b = transformer;
        this.f8561a = axisBase;
        if (this.o != null) {
            this.d = new Paint(1);
            Paint paint = new Paint();
            this.f8562c = paint;
            paint.setColor(Color.GRAY);
            this.f8562c.setStrokeWidth(1.0f);
            this.f8562c.setStyle(Paint.Style.STROKE);
            this.f8562c.setAlpha(90);
            Paint paint2 = new Paint();
            this.e = paint2;
            paint2.setColor(-16777216);
            this.e.setStrokeWidth(1.0f);
            this.e.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.f = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public Paint a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(float f, float f2) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        float f4 = f;
        float f5 = f2;
        if (this.o != null) {
            f4 = f;
            f5 = f2;
            if (this.o.i() > 10.0f) {
                f4 = f;
                f5 = f2;
                if (!this.o.t()) {
                    MPPointD a2 = this.b.a(this.o.f(), this.o.e());
                    MPPointD a3 = this.b.a(this.o.f(), this.o.h());
                    if (z) {
                        f3 = (float) a2.b;
                        d = a3.b;
                    } else {
                        f3 = (float) a3.b;
                        d = a2.b;
                    }
                    f5 = (float) d;
                    MPPointD.a(a2);
                    MPPointD.a(a3);
                    f4 = f3;
                }
            }
        }
        a(f4, f5);
    }
}
