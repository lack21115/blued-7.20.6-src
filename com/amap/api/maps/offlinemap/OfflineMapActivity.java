package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.p0003sl.es;
import com.amap.api.col.p0003sl.et;
import com.amap.api.col.p0003sl.ev;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/offlinemap/OfflineMapActivity.class */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static int f5553a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private es f5554c;
    private es[] d = new es[32];
    private int e = -1;
    private et f;

    private void a(es esVar) {
        try {
            if (this.b != null) {
                this.b.c();
                this.b = null;
            }
            a c2 = c(esVar);
            this.b = c2;
            if (c2 != null) {
                this.f5554c = esVar;
                c2.a(this);
                this.b.e();
                this.b.a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            if ((f5553a != 1 || this.b == null) && f5553a > 1) {
                f5553a--;
                int i = ((this.e - 1) + 32) % 32;
                this.e = i;
                es esVar = this.d[i];
                esVar.b = bundle;
                a(esVar);
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void b(es esVar) {
        try {
            f5553a++;
            a(esVar);
            int i = (this.e + 1) % 32;
            this.e = i;
            this.d[i] = esVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a c(es esVar) {
        try {
            if (esVar.f4938a != 1) {
                return null;
            }
            if (this.f == null) {
                this.f = new et();
            }
            return this.f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (a((Bundle) null)) {
                return;
            }
            if (this.b != null) {
                this.b.c();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            if (this.b != null) {
                this.b.c();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        try {
            if (this.b != null) {
                this.b.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            ev.a(getApplicationContext());
            this.e = -1;
            f5553a = 0;
            b(new es());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            if (this.b != null) {
                this.b.c();
                this.b = null;
            }
            this.f5554c = null;
            this.d = null;
            if (this.f != null) {
                this.f.c();
                this.f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (this.b != null && !this.b.d()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f5553a == 1) {
                        finish();
                        return false;
                    }
                    return false;
                }
                this.e = -1;
                f5553a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.b.b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
