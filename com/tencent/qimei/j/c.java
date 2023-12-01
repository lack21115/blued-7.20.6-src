package com.tencent.qimei.j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/j/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38342a = "c";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.io.FileInputStream] */
    public static String a(String str, String str2) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        FileInputStream fileInputStream2 = null;
        try {
        } catch (IOException e) {
            com.tencent.qimei.k.a.a(e);
        }
        try {
            try {
                fileInputStream = new FileInputStream(str + str2);
                byte[] bArr2 = bArr;
                byte[] bArr3 = bArr;
                try {
                    byte[] bArr4 = new byte[fileInputStream.available()];
                    bArr2 = bArr4;
                    bArr3 = bArr4;
                    fileInputStream.read(bArr4);
                    fileInputStream.close();
                    fileInputStream2 = bArr4;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    bArr = bArr3;
                    com.tencent.qimei.k.a.a(e);
                    fileInputStream2 = bArr;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        fileInputStream2 = bArr;
                    }
                    return new String(fileInputStream2);
                } catch (IOException e3) {
                    e = e3;
                    bArr = bArr2;
                    com.tencent.qimei.k.a.a(e);
                    fileInputStream2 = bArr;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        fileInputStream2 = bArr;
                    }
                    return new String(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            com.tencent.qimei.k.a.a(e4);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileInputStream = null;
            } catch (IOException e6) {
                e = e6;
                fileInputStream = null;
            }
            return new String(fileInputStream2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.j.c.a(java.lang.String, java.lang.String, java.lang.String):void");
    }
}
