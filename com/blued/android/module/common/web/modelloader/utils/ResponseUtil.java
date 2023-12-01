package com.blued.android.module.common.web.modelloader.utils;

import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.web.modelloader.model.ResponseModel;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/modelloader/utils/ResponseUtil.class */
public class ResponseUtil {
    public static String makeResponse(int i, String str) {
        Log.v("drb", "makeResponse code:" + i + " -- message:" + str);
        return AppInfo.f().toJson(new ResponseModel(i, str));
    }

    public static String makeResponse(int i, String str, String str2) {
        return AppInfo.f().toJson(new ResponseModel(i, str, str2));
    }
}
