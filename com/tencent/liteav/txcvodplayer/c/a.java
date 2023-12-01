package com.tencent.liteav.txcvodplayer.c;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.downloadlib.constants.EventConstants;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/c/a.class */
public class a {
    private static a d;

    /* renamed from: a  reason: collision with root package name */
    public final PersistStorage f36543a;
    public final PersistStorage b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f36544c;

    private a() {
        PersistStorage persistStorage = new PersistStorage("v4_cache");
        this.f36543a = persistStorage;
        Long l = persistStorage.getLong(EventConstants.ExtraJson.CLEAN_TIME);
        this.f36544c = l == null ? 0L : l.longValue();
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
        return i + BridgeUtil.UNDERLINE_STR + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, int i, String str, String str2, String str3) {
        String a2 = a(i, str);
        String a3 = TXCHLSEncoder.a(i, "default", str, 0);
        String a4 = TXCHLSEncoder.a(a3, str2);
        String a5 = TXCHLSEncoder.a(a3, str3);
        StringBuilder sb = new StringBuilder(a4);
        sb.append(BridgeUtil.UNDERLINE_STR);
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
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(a5);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(d2);
        sb.append(BridgeUtil.UNDERLINE_STR);
        sb.append(System.currentTimeMillis() / 3600000);
        aVar.f36543a.put(a2, sb.toString());
        aVar.f36543a.commit();
        LiteavLog.i("PlayInfoProtocolV4Storage", "put cache key: " + a2 + " value:" + sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, String str, long j) {
        String[] split;
        String str2 = str;
        if (!str.endsWith(BridgeUtil.SPLIT_MARK)) {
            str2 = str + BridgeUtil.SPLIT_MARK;
        }
        String[] allKeys = aVar.f36543a.getAllKeys();
        int length = allKeys.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                aVar.f36543a.put(EventConstants.ExtraJson.CLEAN_TIME, aVar.f36544c);
                aVar.f36543a.commit();
                return;
            }
            String str3 = allKeys[i2];
            String string = aVar.f36543a.getString(str3);
            if (string != null && (split = string.split(BridgeUtil.UNDERLINE_STR)) != null && split.length == 4 && j - Long.valueOf(split[3]).longValue() >= 24) {
                if (!new File(str2 + split[2]).exists()) {
                    aVar.f36543a.clear(str3);
                    aVar.f36543a.commit();
                    LiteavLog.i("PlayInfoProtocolV4Storage", "clean key: " + str3 + " value: " + string);
                }
            }
            i = i2 + 1;
        }
    }
}
