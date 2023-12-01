package com.soft.blued.push.getui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.sdk.GTServiceManager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/getui/GetuiKeepAliveActivity.class */
public class GetuiKeepAliveActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GTServiceManager.getInstance().onActivityCreate(this);
    }
}
