package com.anythink.china.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.core.app.ActivityCompat;
import com.anythink.china.common.d;
import com.bytedance.applog.tracker.Tracker;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/activity/TransparentActivity.class */
public class TransparentActivity extends Activity {
    public static final String a = "type";
    public static final String b = "request_code";
    public static final int c = 1000;
    public static final String d = "permission_list";
    public static final ConcurrentHashMap<Integer, d.a> e = new ConcurrentHashMap<>();

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.getIntExtra("type", 0) == 1000) {
            ActivityCompat.requestPermissions(this, intent.getStringArrayExtra(d), intent.getIntExtra(b, 0));
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (e.get(Integer.valueOf(i)) != null) {
            e.remove(Integer.valueOf(i));
        }
        finish();
    }
}
