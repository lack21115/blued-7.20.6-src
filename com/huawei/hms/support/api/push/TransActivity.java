package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.android.hms.push.R;
import com.huawei.hms.push.r;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/push/TransActivity.class */
public class TransActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwpush_trans_activity);
        getWindow().addFlags(67108864);
        r.a(this, getIntent());
        finish();
    }
}
