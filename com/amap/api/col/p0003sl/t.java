package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003sl.hp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.t  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/t.class */
public final class t extends Thread {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<IAMapDelegate> f5422a;
    private Context b;

    public t(Context context, IAMapDelegate iAMapDelegate) {
        this.f5422a = null;
        this.b = context;
        this.f5422a = new WeakReference<>(iAMapDelegate);
    }

    private Pair<JSONObject, hp.b.a> a(StringBuilder sb) {
        String str;
        JSONObject jSONObject;
        hp.b.a aVar;
        try {
            long longValue = dm.a(this.b, "cloud_config_pull", "cloud_config_pull_timestamp", (Long) 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) >= 86400000) {
                str = sb.toString();
                str.replaceAll(";;", ";");
                dm.a(this.b, "cloud_config_pull", "cloud_config_pull_timestamp", (Object) new Long(currentTimeMillis));
            } else {
                str = "";
            }
            hp.b a2 = hp.a(this.b, dw.a(), str, (Map<String, String>) null);
            if (hp.f5080a != 1 && str != "" && a2 != null && this.f5422a != null && this.f5422a.get() != null) {
                Message obtainMessage = this.f5422a.get().getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                if (a2.f5085c != null) {
                    obtainMessage.obj = a2.f5085c;
                }
                this.f5422a.get().getMainHandler().sendMessage(obtainMessage);
            }
            String str2 = GLFileUtil.getCacheDir(this.b).getAbsolutePath() + "/authCustomConfigName";
            if (TextUtils.isEmpty(str) || a2 == null || a2.f == null) {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str2)));
            } else {
                jSONObject = a2.f;
                GLFileUtil.writeDatasToFile(str2, a2.f.toString().getBytes());
            }
            String str3 = GLFileUtil.getCacheDir(this.b).getAbsolutePath() + "/authLogConfigName";
            if (TextUtils.isEmpty(str) || a2 == null || a2.g == null) {
                byte[] readFileContents = GLFileUtil.readFileContents(str3);
                aVar = new hp.b.a();
                JSONObject jSONObject2 = new JSONObject(new String(readFileContents));
                aVar.f5086a = jSONObject2.getBoolean("IsExceptionUpdate");
                if (jSONObject2.has("mOfflineLoc")) {
                    aVar.f5087c = jSONObject2.getJSONObject("mOfflineLoc");
                }
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("IsExceptionUpdate", a2.g.f5086a);
                jSONObject3.put("mOfflineLoc", a2.g.f5087c);
                GLFileUtil.writeDatasToFile(str3, jSONObject3.toString().getBytes());
                aVar = a2.g;
            }
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable th) {
            return null;
        }
    }

    private static void a(Context context, ia iaVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16V");
            boolean a2 = hp.a(optJSONObject.optString(AppIconSetting.DEFAULT_LARGE_ICON, ""), false);
            String optString = optJSONObject.optString("dis", "");
            boolean a3 = hp.a(optJSONObject.optString("able", ""), false);
            boolean a4 = hp.a(optJSONObject.optString("isFilter", ""), true);
            if (!a2 || ib.e(optString)) {
                je.a(iaVar).a(context, a3, a4);
            }
        } catch (Throwable th) {
        }
    }

    private void a(hp.b.a aVar) {
        if (aVar != null) {
            try {
                ds.a(this.b, "maploc", "ue", Boolean.valueOf(aVar.f5086a));
                JSONObject jSONObject = aVar.f5087c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                int i = optInt2;
                if (optInt2 > 500) {
                    i = 500;
                }
                int i2 = i;
                if (i < 30) {
                    i2 = 30;
                }
                ki.a(optInt, hp.a(jSONObject.optString("igu"), false));
                ds.a(this.b, "maploc", "opn", Integer.valueOf(i2));
            } catch (Throwable th) {
                iw.c(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            dy.a(jSONObject.optJSONObject("17E"));
        } catch (Throwable th) {
        }
    }

    private static void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16G");
            boolean a2 = hp.a(optJSONObject.optString("able", ""), false);
            boolean a3 = hp.a(optJSONObject.optString("removeCache", ""), false);
            boolean a4 = hp.a(optJSONObject.optString("uploadInfo", ""), false);
            dn.a(a2);
            dn.b(a3);
            dn.c(a4);
        } catch (Throwable th) {
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean z = false;
            boolean a2 = hp.a(jSONObject.optJSONObject("17W").optString("able", ""), false);
            Context context = this.b;
            if (!a2) {
                z = true;
            }
            dm.a(context, "amap_param", "overlay_use_old_type", Boolean.valueOf(z));
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        super.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0421 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0331  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.t.run():void");
    }
}
