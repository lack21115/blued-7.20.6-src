package com.blued.track.trackUtils;

import android.text.TextUtils;
import com.blued.android.statistics.BluedStatistics;
import com.blued.track.auth.TrackServiceManager;
import com.google.protobuf.Message;

/* loaded from: source-7206380-dex2jar.jar:com/blued/track/trackUtils/EventTrackUtils.class */
public class EventTrackUtils {
    public static String a(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        }
        return str2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:12:0x0026). Please submit an issue!!! */
    public static void a(Message message) {
        long j;
        try {
            String b = TrackServiceManager.a().b();
            j = 0;
            if (!TextUtils.isEmpty(b)) {
                j = 0;
                if (TextUtils.isDigitsOnly(b)) {
                    j = Long.parseLong(b);
                }
            }
        } catch (Exception e) {
            j = 0;
        }
        BluedStatistics.f().a(message, j);
    }
}
