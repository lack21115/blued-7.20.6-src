package com.blued.android.module.external_sense_library.utils;

import com.blued.android.module.external_sense_library.config.BluedFilterType;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/utils/FilterUitls.class */
public class FilterUitls {
    public static BluedFilterType.FILER a(String str) {
        BluedFilterType.FILER[] values = BluedFilterType.FILER.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            BluedFilterType.FILER filer = values[i2];
            if (filer.getValue().equals(str)) {
                return filer;
            }
            i = i2 + 1;
        }
    }
}
