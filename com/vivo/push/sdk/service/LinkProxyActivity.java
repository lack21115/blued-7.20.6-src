package com.vivo.push.sdk.service;

import android.app.Activity;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.vivo.push.util.p;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/sdk/service/LinkProxyActivity.class */
public class LinkProxyActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0132 A[Catch: Exception -> 0x014d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x014d, blocks: (B:15:0x009b, B:16:0x00a5, B:20:0x00b2, B:23:0x00c9, B:24:0x00d1, B:26:0x00d8, B:28:0x00e9, B:30:0x00f2, B:32:0x00ff, B:35:0x010b, B:37:0x011a, B:39:0x0121, B:44:0x0132, B:45:0x013b), top: B:51:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013b A[Catch: Exception -> 0x014d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x014d, blocks: (B:15:0x009b, B:16:0x00a5, B:20:0x00b2, B:23:0x00c9, B:24:0x00d1, B:26:0x00d8, B:28:0x00e9, B:30:0x00f2, B:32:0x00ff, B:35:0x010b, B:37:0x011a, B:39:0x0121, B:44:0x0132, B:45:0x013b), top: B:51:0x0091 }] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r5) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.sdk.service.LinkProxyActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        p.d("LinkProxyActivity", hashCode() + " onDestory " + getPackageName());
    }
}
