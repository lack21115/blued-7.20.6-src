package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.hq;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/PPSNotificationActivity.class */
public class PPSNotificationActivity extends Activity {
    private static final String Code = "PPSNotificationActivity";

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ge.Code(Code, "PPSNotification onCreate");
        hq.Code(this).Code(this, getIntent());
        finish();
    }
}
