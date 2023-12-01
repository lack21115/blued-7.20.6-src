package com.blued.android.module.yy_china.utils.log;

import android.text.TextUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.statistics.BluedStatistics;
import com.google.protobuf.Message;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/utils/log/EventTrackUtils.class */
public class EventTrackUtils {
    public static String a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:12:0x0024). Please submit an issue!!! */
    public static void a(Message message) {
        long j;
        try {
            String k = YYRoomInfoManager.e().k();
            j = 0;
            if (!TextUtils.isEmpty(k)) {
                j = 0;
                if (TextUtils.isDigitsOnly(k)) {
                    j = Long.parseLong(k);
                }
            }
        } catch (Exception e) {
            j = 0;
        }
        BluedStatistics.f().a(message, j);
    }
}
