package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.applog.tracker.Tracker;
import com.ss.android.socialbase.appdownloader.b.b;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.hj;
import com.ss.android.socialbase.appdownloader.lz;
import com.ss.android.socialbase.appdownloader.ox;
import com.ss.android.socialbase.appdownloader.ww;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/view/JumpUnknownSourceActivity.class */
public class JumpUnknownSourceActivity extends Activity {
    private Intent b;
    private JSONObject h;
    private int hj;
    private jb mb;
    private Intent ox;

    private void mb() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void ox() {
        if (this.mb != null || this.ox == null) {
            return;
        }
        try {
            b mb = hj.x().mb();
            com.ss.android.socialbase.appdownloader.hj.mb mbVar = null;
            if (mb != null) {
                mbVar = mb.mb(this);
            }
            com.ss.android.socialbase.appdownloader.hj.mb mbVar2 = mbVar;
            if (mbVar == null) {
                mbVar2 = new com.ss.android.socialbase.appdownloader.hj.mb(this);
            }
            int mb2 = lz.mb(this, "tt_appdownloader_tip");
            int mb3 = lz.mb(this, "tt_appdownloader_label_ok");
            int mb4 = lz.mb(this, "tt_appdownloader_label_cancel");
            String optString = this.h.optString(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_TIPS);
            String str = optString;
            if (TextUtils.isEmpty(optString)) {
                str = getString(lz.mb(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            mbVar2.mb(mb2).mb(str).mb(mb3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (ox.mb(jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.h)) {
                        ox.b(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.h);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        ox.mb((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.b, true);
                    }
                    ox.mb(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.h);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ox(mb4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (JumpUnknownSourceActivity.this.b != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        ox.mb((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, true);
                    }
                    ox.ox(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.h);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).mb(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.b != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        ox.mb((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.b, true);
                    }
                    ox.ox(JumpUnknownSourceActivity.this.hj, JumpUnknownSourceActivity.this.h);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).mb(false);
            this.mb = mbVar2.mb();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        mb();
        ww.mb().mb(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        ww.mb().mb(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.ox = intent;
        if (intent != null) {
            this.b = (Intent) intent.getParcelableExtra("intent");
            this.hj = intent.getIntExtra("id", -1);
            try {
                this.h = new JSONObject(intent.getStringExtra(com.igexin.push.core.b.U));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.h == null) {
            com.ss.android.socialbase.appdownloader.b.mb((Activity) this);
            return;
        }
        ox();
        jb jbVar = this.mb;
        if (jbVar != null && !jbVar.ox()) {
            this.mb.mb();
        } else if (this.mb == null) {
            finish();
        }
    }
}
