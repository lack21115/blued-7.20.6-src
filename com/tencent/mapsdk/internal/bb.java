package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bb.class */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    public static final Random f37322a = new Random();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bb$a.class */
    public static final class a implements Comparator<Integer> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            return num.intValue() - num2.intValue();
        }
    }

    private static double a(PointF pointF, PointF pointF2, PointF pointF3) {
        if (pointF.equals(pointF2) || pointF3.equals(pointF) || pointF3.equals(pointF2)) {
            return 0.0d;
        }
        float f = pointF.x;
        float f2 = pointF2.y;
        float f3 = pointF2.x;
        float f4 = pointF3.y;
        float f5 = pointF3.x;
        float f6 = pointF.y;
        return (Math.abs(((((((f * f2) + (f3 * f4)) + (f5 * f6)) - (f3 * f6)) - (f5 * f2)) - (f * f4)) * 0.5d) * 2.0d) / Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    private static <E> int a(ArrayList<E> arrayList, int i, int i2, Comparator<? super E> comparator) {
        int nextInt = f37322a.nextInt((i2 - i) + 1) + i;
        E e = arrayList.get(nextInt);
        a(arrayList, nextInt, i2);
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i >= i2) {
                a(arrayList, i4, i2);
                return i4;
            }
            int i5 = i4;
            if (comparator.compare(arrayList.get(i), e) <= 0) {
                a(arrayList, i4, i);
                i5 = i4 + 1;
            }
            i++;
            i3 = i5;
        }
    }

    public static List<PointF> a(List<PointF> list, double d) {
        int size = list.size();
        if (!list.isEmpty() && size >= 3) {
            int size2 = list.size();
            ArrayList arrayList = new ArrayList();
            arrayList.add(0);
            int i = size2 - 1;
            while (list.get(0).equals(list.get(i))) {
                int i2 = i - 1;
                i = i2;
                if (i2 <= 0) {
                    return list;
                }
            }
            arrayList.add(Integer.valueOf(i));
            a(list, 0, i, d, arrayList);
            a(arrayList, new a());
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= arrayList.size()) {
                    return arrayList2;
                }
                arrayList2.add(list.get(((Integer) arrayList.get(i4)).intValue()));
                i3 = i4 + 1;
            }
        }
        return list;
    }

    private static <E> void a(ArrayList<E> arrayList, int i, int i2) {
        E e = arrayList.get(i);
        arrayList.set(i, arrayList.get(i2));
        arrayList.set(i2, e);
    }

    private static <E> void a(ArrayList<E> arrayList, Comparator<? super E> comparator) {
        b(arrayList, 0, arrayList.size() - 1, comparator);
    }

    private static void a(List<PointF> list, int i, int i2, double d, ArrayList<Integer> arrayList) {
        double d2 = 0.0d;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            double a2 = a(list.get(i), list.get(i2), list.get(i3));
            double d3 = d2;
            if (a2 > d2) {
                i4 = i3;
                d3 = a2;
            }
            i3++;
            d2 = d3;
        }
        if (d2 <= d || i4 == 0) {
            return;
        }
        arrayList.add(Integer.valueOf(i4));
        a(list, i, i4, d, arrayList);
        a(list, i4, i2, d, arrayList);
    }

    private static <E> void b(ArrayList<E> arrayList, int i, int i2, Comparator<? super E> comparator) {
        if (i2 > i) {
            int a2 = a(arrayList, i, i2, comparator);
            b(arrayList, i, a2 - 1, comparator);
            b(arrayList, a2 + 1, i2, comparator);
        }
    }
}
