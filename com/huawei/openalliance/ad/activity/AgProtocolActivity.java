package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.appmarket.service.externalservice.activityresult.IActivityResult;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.download.app.d;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/AgProtocolActivity.class */
public class AgProtocolActivity extends Activity {
    public static final int B = 1005;
    public static final String C = "agd.extra.autofinish";
    public static final int Code = 1001;
    public static final String D = "agd.extra.bundle.binder";
    public static final String F = "agd.extra.bundle.requestcode";
    public static final int I = 1003;
    public static final int L = 1;
    public static final String S = "agd.extra.bundle";
    public static final int V = 1002;
    public static final int Z = 1004;
    private static final int d = 100;
    private static final int e = 101;
    private static final int f = 102;
    private static final String g = "resolution";
    private static final List<String> h;

    /* renamed from: a  reason: collision with root package name */
    String f22930a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    String f22931c;
    private final IActivityResult i = new a(this);

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/AgProtocolActivity$a.class */
    static class a extends IActivityResult.b {
        private WeakReference<AgProtocolActivity> V;

        public a(AgProtocolActivity agProtocolActivity) {
            this.V = new WeakReference<>(agProtocolActivity);
        }

        @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
        public void onActivityCancel(final int i) {
            ge.V("resolution", "onActivityCancel requestCode=" + i);
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.a.1
                @Override // java.lang.Runnable
                public void run() {
                    AgProtocolActivity agProtocolActivity = a.this.V == null ? null : (AgProtocolActivity) a.this.V.get();
                    if (agProtocolActivity != null) {
                        agProtocolActivity.onActivityResult(i, 0, null);
                    }
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        h = arrayList;
        arrayList.add(t.f22960cn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        eh.Code(getApplicationContext(), this.b, this.f22930a, this.f22931c, com.huawei.openalliance.ad.download.app.a.V);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        super.onActivityResult(i, i2, intent);
        ge.V("resolution", "requestCode=" + i + "resultCode=" + i2 + " appPackageName=" + this.f22930a);
        if (100 == i) {
            i3 = 1001;
            if (1001 == i2) {
                ge.V("resolution", "AG agree protocol");
            } else {
                ge.V("resolution", "AG disagree protocol");
                i3 = 1002;
            }
        } else if (101 != i) {
            if (102 == i) {
                if (i2 == -1) {
                    ge.V("resolution", "install hiapp");
                    i3 = 1004;
                } else {
                    ge.V("resolution", "install hiapp, user cancel");
                    i3 = 1005;
                }
            }
            finish();
        } else {
            ge.V("resolution", "syncAgResolutionStatus:101");
            i3 = 1003;
        }
        c.Code(this, i3, this.f22930a, this.f22931c, (Class) null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.activity.AgProtocolActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = AgProtocolActivity.this.getIntent();
                if (intent != null) {
                    try {
                        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(d.d);
                        AgProtocolActivity.this.b = intent.getIntExtra(d.e, 6);
                        AgProtocolActivity.this.f22930a = intent.getStringExtra(d.f);
                        AgProtocolActivity.this.f22931c = intent.getStringExtra("ag_action_name");
                        AgProtocolActivity.this.V();
                        int i = AgProtocolActivity.this.b == 6 ? 101 : AgProtocolActivity.this.b == 8888 ? 102 : 100;
                        Intent intent2 = new Intent();
                        Bundle bundle2 = new Bundle();
                        bundle2.putBinder(AgProtocolActivity.D, AgProtocolActivity.this.i.asBinder());
                        bundle2.putInt(AgProtocolActivity.F, i);
                        intent2.putExtra(AgProtocolActivity.S, bundle2);
                        if (AgProtocolActivity.h.contains(AgProtocolActivity.this.getPackageName())) {
                            intent2.putExtra(AgProtocolActivity.C, 1);
                        }
                        ge.V("resolution", "resolution type=" + AgProtocolActivity.this.b);
                        AgProtocolActivity.this.startIntentSenderForResult(pendingIntent.getIntentSender(), i, intent2, 0, 0, 0);
                    } catch (Throwable th) {
                        ge.V("resolution", "startIntentSenderForResult error:e=" + th.getClass().getName());
                        AgProtocolActivity.this.finish();
                    }
                }
            }
        });
    }
}
