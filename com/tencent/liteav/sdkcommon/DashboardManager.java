package com.tencent.liteav.sdkcommon;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdkcommon.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JNINamespace("liteav::dashboard")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdkcommon/DashboardManager.class */
public class DashboardManager {
    private static final int LOG_MAX_SIZE = 15000;
    private static final String TAG = "DashboardManager";
    private final Context mAppContext;
    private final g mDashboardManagerView;
    private boolean mIsInit;
    private String mSelectedDashboardId;
    private final Handler mUIHandler;
    private final ArrayList<String> mDashboards = new ArrayList<>();
    private final Map<String, String> mDashboardStatus = new HashMap();
    private final Map<String, StringBuilder> mDashboardLogs = new HashMap();
    private final g.a mSelectedDashboardChangeListener = new g.a() { // from class: com.tencent.liteav.sdkcommon.DashboardManager.1
        @Override // com.tencent.liteav.sdkcommon.g.a
        public final void a(int i) {
            if (DashboardManager.this.mDashboards.size() <= i) {
                return;
            }
            DashboardManager dashboardManager = DashboardManager.this;
            dashboardManager.mSelectedDashboardId = (String) dashboardManager.mDashboards.get(i);
            if (DashboardManager.this.mDashboards.contains(DashboardManager.this.mSelectedDashboardId)) {
                DashboardManager.this.mDashboardManagerView.b((String) DashboardManager.this.mDashboardStatus.get(DashboardManager.this.mSelectedDashboardId));
                StringBuilder sb = (StringBuilder) DashboardManager.this.mDashboardLogs.get(DashboardManager.this.mSelectedDashboardId);
                if (sb != null) {
                    DashboardManager.this.mDashboardManagerView.a(sb.toString());
                } else {
                    DashboardManager.this.mDashboardManagerView.a("");
                }
            }
        }
    };

    public DashboardManager() {
        LiteavLog.i(TAG, "java DashBoardManager Construct");
        this.mIsInit = false;
        Context applicationContext = ContextUtils.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mDashboardManagerView = new g(applicationContext, this.mSelectedDashboardChangeListener);
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDashboardInternal(String str) {
        if (this.mDashboards.contains(str)) {
            return;
        }
        this.mDashboards.add(str);
        g gVar = this.mDashboardManagerView;
        gVar.k.add(str);
        if (gVar.n == null) {
            gVar.n = gVar.k.getItem(0);
            gVar.p.a(0);
        }
        gVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendLogInternal(String str, String str2) {
        if (this.mDashboards.contains(str)) {
            StringBuilder sb = this.mDashboardLogs.get(str);
            StringBuilder sb2 = sb;
            if (sb == null) {
                sb2 = new StringBuilder();
                this.mDashboardLogs.put(str, sb2);
            }
            sb2.append(str2);
            sb2.append("\n");
            if (sb2.length() > 15000) {
                sb2.delete(0, sb2.length() / 2);
            }
            if (str.equals(this.mSelectedDashboardId)) {
                g gVar = this.mDashboardManagerView;
                if (gVar.i != null) {
                    TextView textView = gVar.i;
                    textView.append(str2 + "\n");
                }
                if (gVar.l != null) {
                    gVar.l.fullScroll(130);
                }
            }
        }
    }

    private boolean checkPermission() {
        if (LiteavSystemInfo.getSystemOSVersionInt() <= 23 || Settings.canDrawOverlays(this.mAppContext)) {
            return true;
        }
        Toast.makeText(this.mAppContext, "no system alert window permission, please authorize", 0).show();
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean init() {
        /*
            Method dump skipped, instructions count: 923
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.sdkcommon.DashboardManager.init():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllDashboardInternal() {
        this.mDashboards.clear();
        this.mDashboardStatus.clear();
        this.mDashboardLogs.clear();
        g gVar = this.mDashboardManagerView;
        gVar.k.clear();
        if (gVar.h != null) {
            gVar.h.setText("");
        }
        if (gVar.i != null) {
            gVar.i.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDashboardInternal(String str) {
        if (this.mDashboards.contains(str)) {
            this.mDashboards.remove(str);
            this.mDashboardStatus.remove(str);
            this.mDashboardLogs.remove(str);
            g gVar = this.mDashboardManagerView;
            if (str.equals(gVar.n)) {
                int position = gVar.k.getPosition(gVar.n);
                if (position != gVar.k.getCount() - 1) {
                    int i = position + 1;
                    gVar.n = gVar.k.getItem(i);
                    gVar.p.a(i - 1);
                }
                if (gVar.k.getCount() == 1) {
                    gVar.n = null;
                }
            }
            gVar.k.remove(str);
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusInternal(String str, String str2) {
        if (this.mDashboards.contains(str)) {
            this.mDashboardStatus.put(str, str2);
            if (str.equals(this.mSelectedDashboardId)) {
                this.mDashboardManagerView.b(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDashboardInternal(boolean z) {
        if (z && (!checkPermission() || !init())) {
            LiteavLog.i(TAG, "init or check permission is fail");
            return;
        }
        g gVar = this.mDashboardManagerView;
        if (z != gVar.m) {
            if (!z) {
                gVar.f22745c.removeView(gVar.f);
                gVar.f22745c.removeView(gVar.g);
            } else if (gVar.f22745c != null && gVar.f != null) {
                gVar.f22745c.addView(gVar.f, gVar.d);
                gVar.f22745c.addView(gVar.g, gVar.e);
            }
            gVar.m = z;
        }
    }

    public int addDashboard(String str) {
        LiteavLog.i(TAG, "addDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(b.a(this, str));
        return 0;
    }

    public int appendLog(String str, String str2) {
        this.mUIHandler.post(f.a(this, str, str2));
        return 0;
    }

    public int removeAllDashboard() {
        LiteavLog.i(TAG, "removeAllDashboard ");
        this.mUIHandler.post(d.a(this));
        return 0;
    }

    public int removeDashboard(String str) {
        LiteavLog.i(TAG, "removeDashboard dashboardId = ".concat(String.valueOf(str)));
        this.mUIHandler.post(c.a(this, str));
        return 0;
    }

    public int setStatus(String str, String str2) {
        this.mUIHandler.post(e.a(this, str, str2));
        return 0;
    }

    public int showDashboard(boolean z) {
        LiteavLog.i(TAG, "showDashBoard isShow = ".concat(String.valueOf(z)));
        this.mUIHandler.post(a.a(this, z));
        return 0;
    }
}
