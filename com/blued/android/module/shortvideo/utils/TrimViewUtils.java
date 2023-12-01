package com.blued.android.module.shortvideo.utils;

import com.blued.android.module.shortvideo.model.TrimDataModel;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/TrimViewUtils.class */
public class TrimViewUtils {
    public static int a(TrimDataModel trimDataModel) {
        if (trimDataModel != null) {
            return (int) (trimDataModel.getPaddingSize() + ((trimDataModel.getLeftProgress() - trimDataModel.getScrollMs()) * trimDataModel.getAverageMsPx()));
        }
        return 0;
    }

    public static int b(TrimDataModel trimDataModel) {
        if (trimDataModel != null) {
            return (int) (((((float) c(trimDataModel)) * trimDataModel.getAverageMsPx()) + trimDataModel.getPaddingSize()) - trimDataModel.getSlidingBlockPxWidth());
        }
        return 0;
    }

    public static long c(TrimDataModel trimDataModel) {
        if (trimDataModel != null) {
            return (long) ((trimDataModel.getRightProgress() - trimDataModel.getScrollMs()) - (trimDataModel.getLeftProgress() - trimDataModel.getScrollMs()));
        }
        return 0L;
    }
}
