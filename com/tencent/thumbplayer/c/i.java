package com.tencent.thumbplayer.c;

import android.content.Context;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.i;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/i.class */
public class i implements f.a, i.b {

    /* renamed from: a  reason: collision with root package name */
    private int f25571a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f25572c;
    private ConcurrentHashMap<Integer, b> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/i$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static i f25574a = new i();
    }

    private i() {
        this.f25571a = 0;
        this.b = "";
        this.f25572c = 0;
        if (this.d == null) {
            this.d = new ConcurrentHashMap<>();
        }
        com.tencent.thumbplayer.utils.f.a(this);
        com.tencent.thumbplayer.utils.i.a().a(this);
    }

    public static i a() {
        return a.f25574a;
    }

    private static TPDLProxyInitParam a(Context context) {
        return new TPDLProxyInitParam(TPPlayerConfig.getPlatform(), TPPlayerConfig.getAppVersionName(context), TPPlayerConfig.getGuid(), TPPlayerConfig.getProxyCacheDir(), TPPlayerConfig.getProxyDataDir(), TPPlayerConfig.getProxyConfigDir());
    }

    private void a(String str, int i) {
        this.b = str;
        this.f25572c = i;
        for (b bVar : this.d.values()) {
            bVar.a().setUserData(TPDownloadProxyEnum.USER_UPC, str);
            bVar.a().setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(i));
        }
    }

    private String b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("EnableReport", z);
            return jSONObject.toString();
        } catch (JSONException e) {
            TPLogUtil.e("TPProxyGlobalManager", e);
            return "";
        }
    }

    private void b(int i) {
        for (b bVar : this.d.values()) {
            bVar.a(i);
        }
    }

    private String c(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("MaxUseMemoryLevel1MB", j);
            jSONObject.put("MaxUseMemoryLevel2MB", j);
            jSONObject.put("MaxUseMemoryMB", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            TPLogUtil.e("TPProxyGlobalManager", e);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0101 A[Catch: all -> 0x0130, TryCatch #0 {all -> 0x0130, blocks: (B:12:0x002c, B:14:0x003e, B:16:0x004e, B:19:0x0065, B:21:0x006d, B:28:0x009d, B:30:0x00d9, B:32:0x00e7, B:34:0x00ef, B:35:0x00f9, B:35:0x00f9, B:38:0x0101, B:39:0x010a, B:39:0x010a, B:40:0x010d, B:24:0x007c, B:27:0x0093), top: B:46:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.thumbplayer.c.b a(int r6) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.c.i.a(int):com.tencent.thumbplayer.c.b");
    }

    @Override // com.tencent.thumbplayer.utils.i.b
    public void a(int i, int i2, int i3, int i4) {
        int i5 = 10;
        if (i2 == 1) {
            b(1);
        } else if (i2 != 2) {
            if (i2 == 3) {
                b(2);
                b(10);
                return;
            }
            return;
        } else {
            b(2);
            i5 = 9;
        }
        b(i5);
    }

    @Override // com.tencent.thumbplayer.utils.f.a
    public void a(int i, int i2, int i3, Object obj) {
        int i4;
        TPLogUtil.i("TPProxyGlobalManager", "onEvent eventId: " + i + ", arg1: " + i2 + ", arg2: " + i3 + ", object" + obj);
        switch (i) {
            case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /* 100001 */:
                i4 = 13;
                break;
            case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND /* 100002 */:
                i4 = 14;
                break;
            case 100003:
                a((String) obj, i2);
                return;
            default:
                return;
        }
        this.f25571a = i4;
        b(i4);
    }

    public void a(long j) {
        for (b bVar : this.d.values()) {
            ITPDownloadProxy a2 = bVar.a();
            if (a2 != null && j > 0) {
                a2.setMaxStorageSizeMB(j);
            }
        }
    }

    public void a(boolean z) {
        for (b bVar : this.d.values()) {
            bVar.a().setUserData(TPDownloadProxyEnum.USER_PROXY_CONFIG, b(z));
        }
    }

    public void b(long j) {
        for (b bVar : this.d.values()) {
            bVar.a().setUserData(TPDownloadProxyEnum.USER_PROXY_CONFIG, c(j));
        }
    }
}
