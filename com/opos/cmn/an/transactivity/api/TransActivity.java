package com.opos.cmn.an.transactivity.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/transactivity/api/TransActivity.class */
public class TransActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.cmn.an.transactivity.a.a f24598a = null;

    private void a() {
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b("TransActivity", "onCreate");
        try {
            Intent intent = getIntent();
            if (intent != null) {
                com.opos.cmn.an.transactivity.a.a aVar = (com.opos.cmn.an.transactivity.a.a) intent.getSerializableExtra("extra_key_trans_life_callback");
                this.f24598a = aVar;
                if (aVar != null) {
                    aVar.a(this, bundle);
                    return;
                }
            }
            com.opos.cmn.an.f.a.b("TransActivity", "onCreate ITransLifeCallback cannot be null");
            a();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onCreate", e);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.opos.cmn.an.f.a.b("TransActivity", "onDestroy");
        try {
            if (this.f24598a != null) {
                this.f24598a.f(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onDestroy", e);
        }
        this.f24598a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.opos.cmn.an.f.a.b("TransActivity", "onNewIntent");
        try {
            if (this.f24598a != null) {
                this.f24598a.a(this, intent);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onNewIntent", e);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.opos.cmn.an.f.a.b("TransActivity", "onPause");
        try {
            if (this.f24598a != null) {
                this.f24598a.d(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onPause", e);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.opos.cmn.an.f.a.b("TransActivity", "onRestart");
        try {
            if (this.f24598a != null) {
                this.f24598a.b(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onRestart", e);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.b("TransActivity", "onResume");
        try {
            if (this.f24598a != null) {
                this.f24598a.c(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onResume", e);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.opos.cmn.an.f.a.b("TransActivity", "onStart");
        try {
            if (this.f24598a != null) {
                this.f24598a.a(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStart", e);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.opos.cmn.an.f.a.b("TransActivity", "onStop");
        try {
            if (this.f24598a != null) {
                this.f24598a.e(this);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("TransActivity", "onStop", e);
            a();
        }
    }
}
