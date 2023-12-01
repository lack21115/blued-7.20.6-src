package com.blued.android.module.external_sense_library.manager;

import android.content.Context;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/SenseTimeFactory.class */
public class SenseTimeFactory {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/manager/SenseTimeFactory$ProcessorTypeDef.class */
    public @interface ProcessorTypeDef {
        public static final int EDIT_VIDEO = 2;
        public static final int FLASH_VIDEO = 3;
        public static final int LIVE = 0;
        public static final int SHORT_VIDEO = 1;
    }

    public static ISenseTimeProcessor createInstance(Context context, int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return new SenseTimeZegoFlashManger(context, false);
                }
                return new SenseTimeQiniuEditVideoManager(context, false);
            }
            return new SenseTimeQiniuShortVideoManager(context, true);
        }
        return new SenseTimeQiniuLiveManager(context, true);
    }
}
