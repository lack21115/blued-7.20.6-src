package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/ui/BaseResolutionAdapter.class */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f22426a;
    public String b = "";

    public final void a() {
        Activity b = b();
        if (b == null || b.isFinishing()) {
            return;
        }
        b.finish();
    }

    public final Activity b() {
        WeakReference<Activity> weakReference = this.f22426a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void c() {
        SystemManager.getInstance().notifyResolutionResult(null, this.b);
        a();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        this.f22426a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            c();
            return;
        }
        Bundle extras = intent.getExtras();
        this.b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
        if (extras == null) {
            c();
            return;
        }
        Parcelable parcelable = extras.getParcelable("resolution");
        if (parcelable == null) {
            c();
        } else if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult((Intent) parcelable, 1001);
            } catch (ActivityNotFoundException e) {
                c();
                HMSLog.e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
            }
        } else if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException e2) {
                c();
                HMSLog.e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f22426a = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (r6 == 1002) goto L19;
     */
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onBridgeActivityResult(int r5, int r6, android.content.Intent r7) {
        /*
            r4 = this;
            r0 = r5
            r1 = r4
            int r1 = r1.getRequestCode()
            if (r0 == r1) goto La
            r0 = 0
            return r0
        La:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "onBridgeActivityResult, resultCode: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "BaseResolutionAdapter"
            r1 = r8
            java.lang.String r1 = r1.toString()
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            r0 = r6
            r1 = 1001(0x3e9, float:1.403E-42)
            if (r0 == r1) goto L3d
            r0 = r7
            r8 = r0
            r0 = r6
            r1 = 1002(0x3ea, float:1.404E-42)
            if (r0 != r1) goto L56
        L3d:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L4d
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            r1.<init>()
            r8 = r0
        L4d:
            r0 = r8
            java.lang.String r1 = "privacy_statement_confirm_result"
            r2 = r6
            android.content.Intent r0 = r0.putExtra(r1, r2)
        L56:
            r0 = r6
            r1 = -1
            if (r0 == r1) goto L80
            r0 = r8
            java.lang.String r1 = "kit_update_result"
            boolean r0 = r0.hasExtra(r1)
            if (r0 != 0) goto L80
            r0 = r8
            java.lang.String r1 = "privacy_statement_confirm_result"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L72
            goto L80
        L72:
            com.huawei.hms.adapter.sysobs.SystemManager r0 = com.huawei.hms.adapter.sysobs.SystemManager.getInstance()
            r1 = 0
            r2 = r4
            java.lang.String r2 = r2.b
            r0.notifyResolutionResult(r1, r2)
            goto L8c
        L80:
            com.huawei.hms.adapter.sysobs.SystemManager r0 = com.huawei.hms.adapter.sysobs.SystemManager.getInstance()
            r1 = r8
            r2 = r4
            java.lang.String r2 = r2.b
            r0.notifyResolutionResult(r1, r2)
        L8c:
            r0 = r4
            r0.a()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.ui.BaseResolutionAdapter.onBridgeActivityResult(int, int, android.content.Intent):boolean");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }
}
