package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/Description.class */
public class Description extends ComponentBase {
    private MPPointF b;

    /* renamed from: a  reason: collision with root package name */
    private String f22087a = "Description Label";

    /* renamed from: c  reason: collision with root package name */
    private Paint.Align f22088c = Paint.Align.RIGHT;

    public Description() {
        this.A = Utils.a(8.0f);
    }

    public String a() {
        return this.f22087a;
    }

    public MPPointF b() {
        return this.b;
    }

    public Paint.Align c() {
        return this.f22088c;
    }
}
