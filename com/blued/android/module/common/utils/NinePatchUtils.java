package com.blued.android.module.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.R;
import com.blued.android.module.common.utils.NinePatchBitmapFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/NinePatchUtils.class */
public final class NinePatchUtils {
    public static final NinePatchUtils a = new NinePatchUtils();

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/NinePatchUtils$GuideArrowPosition.class */
    public enum GuideArrowPosition {
        LEFT,
        CENTER,
        RIGHT
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/NinePatchUtils$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GuideArrowPosition.values().length];
            iArr[GuideArrowPosition.LEFT.ordinal()] = 1;
            iArr[GuideArrowPosition.CENTER.ordinal()] = 2;
            iArr[GuideArrowPosition.RIGHT.ordinal()] = 3;
            a = iArr;
        }
    }

    private NinePatchUtils() {
    }

    private final Drawable a(Bitmap bitmap, List<? extends NinePatchBitmapFactory.Range> list, List<? extends NinePatchBitmapFactory.Range> list2) {
        return NinePatchBitmapFactory.a(AppInfo.d().getResources(), bitmap, list, list2, null);
    }

    @JvmStatic
    public static final Drawable a(GuideArrowPosition guideArrowPosition, int... resId) {
        Intrinsics.e(resId, "resId");
        Bitmap bitmap = BitmapFactory.decodeResource(AppInfo.d().getResources(), ((resId.length == 0) || resId[0] == 0) ? R.drawable.guide_black_bubble_up : resId[0]);
        ArrayList arrayList = new ArrayList();
        int i = guideArrowPosition == null ? -1 : WhenMappings.a[guideArrowPosition.ordinal()];
        if (i == 1) {
            int width = (bitmap.getWidth() / 4) * 3;
            arrayList.add(a.a(width - 1, width + 1).get(0));
        } else if (i == 2) {
            int width2 = bitmap.getWidth() / 4;
            arrayList.add(a.a(width2 - 1, width2 + 1).get(0));
            int width3 = (bitmap.getWidth() / 4) * 3;
            arrayList.add(a.a(width3 - 1, width3 + 1).get(0));
        } else if (i == 3) {
            int width4 = bitmap.getWidth() / 4;
            arrayList.add(a.a(width4 - 1, width4 + 1).get(0));
        }
        List<NinePatchBitmapFactory.Range> a2 = a.a((bitmap.getHeight() / 2) - 1, (bitmap.getHeight() / 2) + 1);
        NinePatchUtils ninePatchUtils = a;
        Intrinsics.c(bitmap, "bitmap");
        return ninePatchUtils.a(bitmap, arrayList, a2);
    }

    private final List<NinePatchBitmapFactory.Range> a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        NinePatchBitmapFactory.Range range = new NinePatchBitmapFactory.Range();
        range.a = i;
        range.b = i2;
        arrayList.add(range);
        return arrayList;
    }

    public final Drawable a(int i) {
        Bitmap bitmap = BitmapFactory.decodeResource(AppInfo.d().getResources(), i);
        List<NinePatchBitmapFactory.Range> a2 = a((bitmap.getHeight() / 2) - 1, (bitmap.getHeight() / 2) + 1);
        List<NinePatchBitmapFactory.Range> a3 = a((bitmap.getWidth() / 2) - 1, (bitmap.getWidth() / 2) + 1);
        Intrinsics.c(bitmap, "bitmap");
        return a(bitmap, a3, a2);
    }
}
