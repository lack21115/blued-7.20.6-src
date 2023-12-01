package com.blued.android.module.yy_china.utils;

import com.blued.android.module.yy_china.R;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/YYResourcesUtils.class */
public final class YYResourcesUtils {
    public static final YYResourcesUtils a = new YYResourcesUtils();
    private static final int[] b = {R.drawable.yy_ktv_style_num_0, R.drawable.yy_ktv_style_num_1, R.drawable.yy_ktv_style_num_2, R.drawable.yy_ktv_style_num_3, R.drawable.yy_ktv_style_num_4, R.drawable.yy_ktv_style_num_5};
    private static final int[] c = {R.drawable.yy_ktv_style_num_big_0, R.drawable.yy_ktv_style_num_big_1, R.drawable.yy_ktv_style_num_big_2, R.drawable.yy_ktv_style_num_big_3, R.drawable.yy_ktv_style_num_big_4, R.drawable.yy_ktv_style_num_big_5};

    private YYResourcesUtils() {
    }

    private final int c(int i) {
        if (i >= 90) {
            return 5;
        }
        if (i >= 80) {
            return 4;
        }
        if (i >= 70) {
            return 3;
        }
        if (i >= 60) {
            return 2;
        }
        return i >= 50 ? 1 : 0;
    }

    public final int a(int i) {
        return b[c(i)];
    }

    public final int b(int i) {
        return c[c(i)];
    }
}
