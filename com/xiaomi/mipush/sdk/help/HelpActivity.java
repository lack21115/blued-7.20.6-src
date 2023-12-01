package com.xiaomi.mipush.sdk.help;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.xiaomi.mipush.sdk.o;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/help/HelpActivity.class */
public class HelpActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a(this, getIntent(), null);
        finish();
    }
}
