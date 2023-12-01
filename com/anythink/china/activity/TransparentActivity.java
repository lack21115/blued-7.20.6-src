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

    /* renamed from: a  reason: collision with root package name */
    public static final String f6266a = "type";
    public static final String b = "request_code";

    /* renamed from: c  reason: collision with root package name */
    public static final int f6267c = 1000;
    public static final String d = "permission_list";
    public static final ConcurrentHashMap<Integer, d.a> e = new ConcurrentHashMap<>();

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent.getIntExtra("type", 0) == 1000) {
            ActivityCompat.requestPermissions(this, intent.getStringArrayExtra(d), intent.getIntExtra(b, 0));
        } else {
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (e.get(Integer.valueOf(i)) != null) {
            e.remove(Integer.valueOf(i));
        }
        finish();
    }
}
