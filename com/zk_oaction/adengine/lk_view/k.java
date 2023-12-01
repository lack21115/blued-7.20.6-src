package com.zk_oaction.adengine.lk_view;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_view/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private Random f28380a = new Random();
    private Paint b;

    public k() {
        b();
    }

    private int a(int i) {
        return this.f28380a.nextBoolean() ? i : 0 - i;
    }

    private int a(int i, int i2) {
        Random random;
        if (i2 != 0) {
            random = this.f28380a;
            i /= 4;
        } else {
            random = this.f28380a;
        }
        return random.nextInt(i);
    }

    private Point a(float f, Point point, Point point2, Point point3, Point point4) {
        float f2 = 1.0f - f;
        float f3 = f * f;
        float f4 = f2 * f2;
        float f5 = f4 * f2;
        float f6 = f3 * f;
        Point point5 = new Point((int) (point.x * f5), (int) (f5 * point.y));
        float f7 = point5.x;
        float f8 = f4 * 3.0f * f;
        int i = (int) (f7 + (point2.x * f8));
        point5.x = i;
        int i2 = (int) ((f8 * point2.y) + point5.y);
        point5.y = i2;
        float f9 = i;
        float f10 = f2 * 3.0f * f3;
        int i3 = (int) ((point3.x * f10) + f9);
        point5.x = i3;
        int i4 = (int) ((f10 * point3.y) + i2);
        point5.y = i4;
        point5.x = (int) (i3 + (point4.x * f6));
        point5.y = (int) (i4 + (point4.y * f6));
        return point5;
    }

    private Point a(int i, int i2, int i3) {
        int nextInt;
        int i4 = i3;
        if (i3 <= 0) {
            i4 = 1;
        }
        return new Point(a(this.f28380a.nextInt(i4)) + i, a((int) Math.sqrt((i4 * i4) - (nextInt * nextInt))) + i2);
    }

    private void b() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
    }

    public Paint a() {
        return this.b;
    }

    public void a(List<j> list, l lVar) {
        if (lVar == null) {
            return;
        }
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (next.e == 0.0f) {
                next.e = a(lVar.f / 4, this.f28380a.nextInt(15)) + 1;
            }
            if (next.f == 0.0f) {
                int a2 = (int) (lVar.f / lVar.f28382c.a());
                Point point = new Point((int) next.f28378a, (int) next.b);
                next.i = point;
                next.j = a(point.x, point.y, (int) next.e);
                Point point2 = next.i;
                next.k = a(point2.x, point2.y, this.f28380a.nextInt(a2));
                Point point3 = next.j;
                next.l = a(point3.x, point3.y, this.f28380a.nextInt(a2));
            }
            float a3 = next.f + lVar.f28381a.a();
            next.f = a3;
            Point a4 = a(a3 / next.e, next.i, next.k, next.l, next.j);
            float f = next.f;
            float f2 = next.e;
            if (f <= f2) {
                float a5 = lVar.b.a();
                next.f28379c -= a5;
                next.d -= a5;
            } else if (f >= f2) {
                next.f = 0.0f;
                next.e = 0.0f;
                next.f28379c = 0.0f;
                next.d = 0.0f;
            }
            Rect rect = next.g;
            int i = a4.x;
            rect.left = i;
            int i2 = a4.y;
            rect.top = i2;
            float f3 = next.f28379c;
            int i3 = (int) f3;
            rect.right = i + i3;
            rect.bottom = i2 + i3;
            if (f3 <= 0.0f || next.d <= 0.0f) {
                it.remove();
            }
        }
    }
}
