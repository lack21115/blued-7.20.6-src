package com.blued.android.module.live_china.utils.log;

import android.text.TextUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.statistics.BluedStatistics;
import com.google.protobuf.Message;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/log/EventTrackUtils.class */
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
            String f = LiveRoomInfo.a().f();
            j = 0;
            if (!TextUtils.isEmpty(f)) {
                j = 0;
                if (TextUtils.isDigitsOnly(f)) {
                    j = Long.parseLong(f);
                }
            }
        } catch (Exception e) {
            j = 0;
        }
        BluedStatistics.f().a(message, j);
    }
}
