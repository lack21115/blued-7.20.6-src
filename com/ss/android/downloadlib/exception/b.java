package com.ss.android.downloadlib.exception;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.appdownloader.u.h;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/exception/b.class */
public class b implements com.ss.android.download.api.ox.mb {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/exception/b$mb.class */
    public static class mb {
        private static b mb = new b();
    }

    public static b mb() {
        return mb.mb;
    }

    public static String mb(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception e) {
            return null;
        }
    }

    private void ox(Throwable th) {
        if (h.ox(x.getContext())) {
            throw new com.ss.android.downloadlib.exception.mb(th);
        }
    }

    private boolean ox() {
        return x.lz().optInt("enable_monitor", 1) != 1;
    }

    public void mb(String str) {
        mb(true, str);
    }

    @Override // com.ss.android.download.api.ox.mb
    public void mb(Throwable th, String str) {
        mb(true, th, str);
    }

    public void mb(boolean z, String str) {
        if (ox()) {
            return;
        }
        if (z) {
            ox(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, "msg", str);
        jb.mb(jSONObject, "stack", mb(new Throwable()));
        x.ww().mb("service_ttdownloader", 2, jSONObject);
    }

    public void mb(boolean z, Throwable th, String str) {
        if (ox()) {
            return;
        }
        Throwable th2 = th;
        if (th == null) {
            th2 = new Throwable();
        }
        if (z) {
            ox(th2);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th2.getMessage();
        }
        jb.mb(jSONObject, "msg", str);
        jb.mb(jSONObject, "stack", Log.getStackTraceString(th2));
        x.ww().mb("service_ttdownloader", 1, jSONObject);
    }

    public void ox(String str) {
        ox(true, str);
    }

    public void ox(boolean z, String str) {
        if (ox()) {
            return;
        }
        if (z) {
            ox(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, "msg", str);
        jb.mb(jSONObject, "stack", mb(new Throwable()));
        x.ww().mb("service_ttdownloader", 3, jSONObject);
    }
}
