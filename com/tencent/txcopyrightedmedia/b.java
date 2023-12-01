package com.tencent.txcopyrightedmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/b.class */
public class b {
    public static int a(TXCMAudioFrameInfo tXCMAudioFrameInfo) {
        return tXCMAudioFrameInfo.REUSE_TIMES;
    }

    public static String a(TXCMMusicInfo tXCMMusicInfo) {
        return tXCMMusicInfo.musicId;
    }

    public static void a(TXCMMusicInfo tXCMMusicInfo, String str) {
        tXCMMusicInfo.musicParams = str;
    }

    public static String b(TXCMMusicInfo tXCMMusicInfo) {
        return tXCMMusicInfo.musicParams;
    }

    public static int c(TXCMMusicInfo tXCMMusicInfo) {
        return tXCMMusicInfo.musicType;
    }
}
