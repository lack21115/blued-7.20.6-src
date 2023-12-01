package com.blued.track.trackUtils;

import android.net.Uri;
import com.bytedance.applog.AppLog;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/blued/track/trackUtils/EventTrackCommon.class */
public class EventTrackCommon {
    public static void a(Uri uri, final IALinkListener iALinkListener) {
        AppLog.activateALink(uri);
        AppLog.setALinkListener(new com.bytedance.applog.alink.IALinkListener() { // from class: com.blued.track.trackUtils.EventTrackCommon.1
            @Override // com.bytedance.applog.alink.IALinkListener
            public void onALinkData(Map<String, String> map, Exception exc) {
                IALinkListener iALinkListener2 = IALinkListener.this;
                if (iALinkListener2 != null) {
                    iALinkListener2.a(map, exc);
                }
            }

            @Override // com.bytedance.applog.alink.IALinkListener
            public void onAttributionData(Map<String, String> map, Exception exc) {
                IALinkListener iALinkListener2 = IALinkListener.this;
                if (iALinkListener2 != null) {
                    iALinkListener2.b(map, exc);
                }
            }
        });
    }
}
