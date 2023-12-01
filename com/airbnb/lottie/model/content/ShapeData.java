package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/content/ShapeData.class */
public class ShapeData {
    private final List<CubicCurveData> a;
    private PointF b;
    private boolean c;

    public ShapeData() {
        this.a = new ArrayList();
    }

    public ShapeData(PointF pointF, boolean z, List<CubicCurveData> list) {
        this.b = pointF;
        this.c = z;
        this.a = new ArrayList(list);
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
        this.c = shapeData.b() || shapeData2.b();
        if (shapeData.c().size() != shapeData2.c().size()) {
            Logger.b("Curves must have the same number of control points. Shape 1: " + shapeData.c().size() + "\tShape 2: " + shapeData2.c().size());
        }
        int min = Math.min(shapeData.c().size(), shapeData2.c().size());
        if (this.a.size() < min) {
            int size = this.a.size();
            while (true) {
                int i = size;
                if (i >= min) {
                    break;
                }
                this.a.add(new CubicCurveData());
                size = i + 1;
            }
        } else if (this.a.size() > min) {
            int size2 = this.a.size();
            while (true) {
                int i2 = size2 - 1;
                if (i2 < min) {
                    break;
                }
                List<CubicCurveData> list = this.a;
                list.remove(list.size() - 1);
                size2 = i2;
            }
        }
        PointF a = shapeData.a();
        PointF a2 = shapeData2.a();
        a(MiscUtils.a(a.x, a2.x, f), MiscUtils.a(a.y, a2.y, f));
        int size3 = this.a.size();
        while (true) {
            int i3 = size3 - 1;
            if (i3 < 0) {
                return;
            }
            CubicCurveData cubicCurveData = shapeData.c().get(i3);
            CubicCurveData cubicCurveData2 = shapeData2.c().get(i3);
            PointF a3 = cubicCurveData.a();
            PointF b = cubicCurveData.b();
            PointF c = cubicCurveData.c();
            PointF a4 = cubicCurveData2.a();
            PointF b2 = cubicCurveData2.b();
            PointF c2 = cubicCurveData2.c();
            this.a.get(i3).a(MiscUtils.a(a3.x, a4.x, f), MiscUtils.a(a3.y, a4.y, f));
            this.a.get(i3).b(MiscUtils.a(b.x, b2.x, f), MiscUtils.a(b.y, b2.y, f));
            this.a.get(i3).c(MiscUtils.a(c.x, c2.x, f), MiscUtils.a(c.y, c2.y, f));
            size3 = i3;
        }
    }

    public boolean b() {
        return this.c;
    }

    public List<CubicCurveData> c() {
        return this.a;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.a.size() + "closed=" + this.c + '}';
    }
}
