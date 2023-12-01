package com.blued.android.module.live_china.utils;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.external_sense_library.utils.lisense_utils.STNewLicenseUtils;
import com.blued.android.module.live_china.model.STMessageModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/SenseTimeLicUtils.class */
public class SenseTimeLicUtils {
    public static boolean a = false;

    public static void a(String str) {
        if (TextUtils.isEmpty(str) || a) {
            return;
        }
        a = true;
        try {
            final STMessageModel sTMessageModel = (STMessageModel) AppInfo.f().fromJson(str, STMessageModel.class);
            if (sTMessageModel == null || TextUtils.isEmpty(sTMessageModel.url)) {
                return;
            }
            ThreadManager.a().a(new ThreadExecutor("SenseTimeTask") { // from class: com.blued.android.module.live_china.utils.SenseTimeLicUtils.1
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    if (STNewLicenseUtils.a(AppInfo.d())) {
                        return;
                    }
                    STNewLicenseUtils.a(sTMessageModel.url);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
