package com.tencent.liteav.txcvodplayer.c;

import com.ss.android.downloadlib.constants.EventConstants;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/c/a.class */
public class a {
    private static a d;

    /* renamed from: a  reason: collision with root package name */
    public final PersistStorage f22852a;
    public final PersistStorage b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f22853c;

    private a() {
        PersistStorage persistStorage = new PersistStorage("v4_cache");
        this.f22852a = persistStorage;
        Long l = persistStorage.getLong(EventConstants.ExtraJson.CLEAN_TIME);
        this.f22853c = l == null ? 0L : l.longValue();
        this.b = new PersistStorage("v4_download");
    }

    public static a a() {
        synchronized (a.class) {
            try {
                if (d == null) {
                    d = new a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return d;
    }

    public static String a(int i, String str) {
        return i + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, int i, String str, String str2, String str3) {
        String a2 = a(i, str);
        String a3 = TXCHLSEncoder.a(i, "default", str, 0);
        String a4 = TXCHLSEncoder.a(a3, str2);
        String a5 = TXCHLSEncoder.a(a3, str3);
        StringBuilder sb = new StringBuilder(a4);
        sb.append("_");
        sb.append(a5);
        aVar.b.put(a2, sb.toString());
        aVar.b.commit();
        LiteavLog.i("PlayInfoProtocolV4Storage", "put download key: " + a2 + " value:" + sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, int i, String str, String str2, String str3, String str4) {
        String a2 = a(i, str);
        String d2 = com.tencent.liteav.txcplayer.e.a.d(str2);
        String a3 = TXCHLSEncoder.a(i, "default", str, 0);
        String a4 = TXCHLSEncoder.a(a3, str3);
        String a5 = TXCHLSEncoder.a(a3, str4);
        StringBuilder sb = new StringBuilder(a4);
        sb.append("_");
        sb.append(a5);
        sb.append("_");
        sb.append(d2);
        sb.append("_");
        sb.append(System.currentTimeMillis() / 3600000);
        aVar.f22852a.put(a2, sb.toString());
        aVar.f22852a.commit();
        LiteavLog.i("PlayInfoProtocolV4Storage", "put cache key: " + a2 + " value:" + sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, String str, long j) {
        String[] split;
        String str2 = str;
        if (!str.endsWith("/")) {
            str2 = str + "/";
        }
        String[] allKeys = aVar.f22852a.getAllKeys();
        int length = allKeys.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                aVar.f22852a.put(EventConstants.ExtraJson.CLEAN_TIME, aVar.f22853c);
                aVar.f22852a.commit();
                return;
            }
            String str3 = allKeys[i2];
            String string = aVar.f22852a.getString(str3);
            if (string != null && (split = string.split("_")) != null && split.length == 4 && j - Long.valueOf(split[3]).longValue() >= 24) {
                if (!new File(str2 + split[2]).exists()) {
                    aVar.f22852a.clear(str3);
                    aVar.f22852a.commit();
                    LiteavLog.i("PlayInfoProtocolV4Storage", "clean key: " + str3 + " value: " + string);
                }
            }
            i = i2 + 1;
        }
    }
}
