package com.blued.android.module.common.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/NinePatchBitmapFactory.class */
public class NinePatchBitmapFactory {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/NinePatchBitmapFactory$Range.class */
    public static class Range {
        public int a;
        public int b;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/NinePatchBitmapFactory$RangeLists.class */
    public static class RangeLists {
    }

    public static NinePatchDrawable a(Resources resources, Bitmap bitmap, List<Range> list, List<Range> list2, String str) {
        return new NinePatchDrawable(resources, bitmap, a(list, list2).array(), new Rect(), str);
    }

    private static ByteBuffer a(List<Range> list, List<Range> list2) {
        ByteBuffer order = ByteBuffer.allocate((list.size() * 8) + 32 + (list2.size() * 8) + 36).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) (list.size() * 2));
        order.put((byte) (list2.size() * 2));
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        for (Range range : list) {
            order.putInt(range.a);
            order.putInt(range.b);
        }
        for (Range range2 : list2) {
            order.putInt(range2.a);
            order.putInt(range2.b);
        }
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        order.putInt(1);
        return order;
    }
}
