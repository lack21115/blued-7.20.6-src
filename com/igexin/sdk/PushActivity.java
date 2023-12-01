package com.igexin.sdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.sdk.main.PushCoreLoader;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/PushActivity.class */
public class PushActivity extends Activity {
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            return PushCoreLoader.getInstance().getPushCore().onActivityCreateOptionsMenu(this, menu);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityDestroy(this);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (PushCoreLoader.getInstance().getPushCore() == null || !PushCoreLoader.getInstance().getPushCore().onActivityKeyDown(this, i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityNewIntent(this, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityPause(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityRestart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityResume(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityStart(this, getIntent());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (PushCoreLoader.getInstance().getPushCore() != null) {
            PushCoreLoader.getInstance().getPushCore().onActivityStop(this);
        }
    }
}
