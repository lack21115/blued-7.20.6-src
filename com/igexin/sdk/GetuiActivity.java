package com.igexin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.c.a.c.a;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.a.b;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/GetuiActivity.class */
public class GetuiActivity extends Activity {
    private String TAG = "GetuiActivity";

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            b.d();
            Intent intent = new Intent(this, b.a((Context) this));
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.hasExtra("action") && intent2.hasExtra("broadcast_intent")) {
                intent.putExtra("action", intent2.getStringExtra("action"));
                intent.putExtra("broadcast_intent", (Intent) intent2.getParcelableExtra("broadcast_intent"));
            }
            ServiceManager.getInstance().b(getApplicationContext(), intent);
            a.a(this.TAG + "|GetuiActivity create " + intent.toString(), new Object[0]);
        } catch (Throwable th) {
            a.a(th);
            a.a(this.TAG + "|put GetuiActivity exception" + th.toString(), new Object[0]);
        }
        finish();
    }
}
