package com.opos.mobad.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.q.a.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/activity/VideoActivity.class */
public class VideoActivity extends Activity {
    public static final int ACTION_TYPE_INTERSTITIAL = 2;
    public static final int ACTION_TYPE_PLAY_REWARD_VIDEO = 1;
    public static final String EXTRA_KEY_ACTION_TYPE = "actionType";
    public static final String EXTRA_KEY_AD_ITEM_DATA = "adItemData";
    public static final String EXTRA_KEY_BID_PRICE = "bidPrice";
    public static final String EXTRA_KEY_EVENT_DESCRIPTION = "eventDescription";
    public static final String EXTRA_KEY_SCREEN_MODE = "screenMode";
    public static final String EXTRA_KEY_TEMPLATE_CREATOR = "templateCreator";
    private static final String TAG = "VideoActivity";
    private com.opos.mobad.q.a.d.a mIntentDispatcher;

    private void destroy() {
        try {
            com.opos.cmn.an.f.a.b(TAG, "destroy");
            finish();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e);
        }
    }

    private void handleAction(Intent intent) {
        if (intent != null) {
            try {
                com.opos.mobad.q.a.d.a aVar = new com.opos.mobad.q.a.d.a(this);
                this.mIntentDispatcher = aVar;
                aVar.a(intent, createInteractor(), new g() { // from class: com.opos.mobad.activity.VideoActivity.1
                    @Override // com.opos.mobad.q.a.g
                    public void a() {
                        if (VideoActivity.this.isDestroyed() || VideoActivity.this.isFinishing()) {
                            return;
                        }
                        VideoActivity.this.finish();
                    }
                });
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e);
                destroy();
            }
        }
    }

    protected d createInteractor() {
        return new com.opos.mobad.a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.opos.cmn.an.f.a.b(TAG, "onConfigurationChanged newConfig=" + configuration.toString());
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        com.opos.cmn.i.g.a((Activity) this);
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b(TAG, "onCreate");
        handleAction(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        com.opos.cmn.an.f.a.b(TAG, "onDestroy");
        try {
            if (this.mIntentDispatcher != null) {
                this.mIntentDispatcher.c();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar == null || !aVar.a(i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        com.opos.cmn.an.f.a.b(TAG, "onPause");
        super.onPause();
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.b(TAG, "onResume");
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar != null) {
            aVar.a();
        }
    }
}
