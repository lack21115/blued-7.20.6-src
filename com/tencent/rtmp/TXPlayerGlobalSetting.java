package com.tencent.rtmp;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXPlayerGlobalSetting.class */
public class TXPlayerGlobalSetting {
    public static String getCacheFolderPath() {
        return com.tencent.liteav.txcplayer.a.b.a();
    }

    public static int getMaxCacheSize() {
        return Math.max(com.tencent.liteav.txcplayer.a.b.b(), 0);
    }

    public static void setCacheFolderPath(String str) {
        com.tencent.liteav.txcplayer.a.b.a(str);
    }

    public static void setMaxCacheSize(int i) {
        com.tencent.liteav.txcplayer.a.b.a(i);
    }
}
