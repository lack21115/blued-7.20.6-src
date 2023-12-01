package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ya.class */
public class ya {
    public static final int e = 1;
    public static final int f = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Rect f38127a = new Rect();
    public int[] b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f38128c;
    public int[] d;

    public static ya a(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == 0) {
            return null;
        }
        ya yaVar = new ya();
        yaVar.b = new int[order.get()];
        yaVar.f38128c = new int[order.get()];
        yaVar.d = new int[order.get()];
        a(yaVar.b.length);
        a(yaVar.f38128c.length);
        order.getInt();
        order.getInt();
        yaVar.f38127a.left = order.getInt();
        yaVar.f38127a.right = order.getInt();
        yaVar.f38127a.top = order.getInt();
        yaVar.f38127a.bottom = order.getInt();
        order.getInt();
        a(yaVar.b, order);
        a(yaVar.f38128c, order);
        a(yaVar.d, order);
        return yaVar;
    }

    private static void a(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    private static void a(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            iArr[i2] = byteBuffer.getInt();
            i = i2 + 1;
        }
    }
}
