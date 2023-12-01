package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeData.class */
public class ShapeData {

    /* renamed from: a  reason: collision with root package name */
    private final List<CubicCurveData> f4360a;
    private PointF b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4361c;

    public ShapeData() {
        this.f4360a = new ArrayList();
    }

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.b = pointF;
        this.f4361c = z;
        this.f4360a = new ArrayList(list);
    }

    private void a(float f, float f2) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.b.set(f, f2);
    }

    public PointF a() {
        return this.b;
    }

    public void a(ShapeData shapeData, ShapeData shapeData2, float f) {
        if (this.b == null) {
            this.b = new PointF();
        }
        this.f4361c = shapeData.b() || shapeData2.b();
        if (shapeData.c().size() != shapeData2.c().size()) {
            Logger.b("Curves must have the same number of control points. Shape 1: " + shapeData.c().size() + "\tShape 2: " + shapeData2.c().size());
        }
        int min = Math.min(shapeData.c().size(), shapeData2.c().size());
        if (this.f4360a.size() < min) {
            int size = this.f4360a.size();
            while (true) {
                int i = size;
                if (i >= min) {
                    break;
                }
                this.f4360a.add(new CubicCurveData());
                size = i + 1;
            }
        } else if (this.f4360a.size() > min) {
            int size2 = this.f4360a.size();
            while (true) {
                int i2 = size2 - 1;
                if (i2 < min) {
                    break;
                }
                List<CubicCurveData> list = this.f4360a;
                list.remove(list.size() - 1);
                size2 = i2;
            }
        }
        PointF a2 = shapeData.a();
        PointF a3 = shapeData2.a();
        a(MiscUtils.a(a2.x, a3.x, f), MiscUtils.a(a2.y, a3.y, f));
        int size3 = this.f4360a.size();
        while (true) {
            int i3 = size3 - 1;
            if (i3 < 0) {
                return;
            }
            CubicCurveData cubicCurveData = shapeData.c().get(i3);
            CubicCurveData cubicCurveData2 = shapeData2.c().get(i3);
            PointF a4 = cubicCurveData.a();
            PointF b = cubicCurveData.b();
            PointF c2 = cubicCurveData.c();
            PointF a5 = cubicCurveData2.a();
            PointF b2 = cubicCurveData2.b();
            PointF c3 = cubicCurveData2.c();
            this.f4360a.get(i3).a(MiscUtils.a(a4.x, a5.x, f), MiscUtils.a(a4.y, a5.y, f));
            this.f4360a.get(i3).b(MiscUtils.a(b.x, b2.x, f), MiscUtils.a(b.y, b2.y, f));
            this.f4360a.get(i3).c(MiscUtils.a(c2.x, c3.x, f), MiscUtils.a(c2.y, c3.y, f));
            size3 = i3;
        }
    }

    public boolean b() {
        return this.f4361c;
    }

    public List<CubicCurveData> c() {
        return this.f4360a;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f4360a.size() + "closed=" + this.f4361c + '}';
    }
}
