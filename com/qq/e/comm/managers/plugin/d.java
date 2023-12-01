package com.qq.e.comm.managers.plugin;

import android.app.backup.FullBackup;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/plugin/d.class */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14235a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", FullBackup.DATA_TREE_TOKEN};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            byte b = bArr[i2];
            byte b2 = b;
            if (b < 0) {
                b2 = b + 256;
            }
            stringBuffer.append(f14235a[b2 / 16] + f14235a[b2 % 16]);
            i = i2 + 1;
        }
    }
}
