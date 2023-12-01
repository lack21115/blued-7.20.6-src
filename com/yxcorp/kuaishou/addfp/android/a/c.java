package com.yxcorp.kuaishou.addfp.android.a;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/a/c.class */
public class c {
    private static boolean d = true;

    /* renamed from: a  reason: collision with root package name */
    private String f28160a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private ReentrantLock f28161c;

    private c() {
        this.b = "";
        this.f28161c = new ReentrantLock();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #3 {all -> 0x00f1, blocks: (B:2:0x0000, B:15:0x002c, B:19:0x003c, B:21:0x0044, B:23:0x0051, B:25:0x005e, B:31:0x0074, B:33:0x0084, B:47:0x00c1, B:49:0x00cc, B:53:0x00d7, B:55:0x00e2, B:7:0x000f), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c1 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #3 {all -> 0x00f1, blocks: (B:2:0x0000, B:15:0x002c, B:19:0x003c, B:21:0x0044, B:23:0x0051, B:25:0x005e, B:31:0x0074, B:33:0x0084, B:47:0x00c1, B:49:0x00cc, B:53:0x00d7, B:55:0x00e2, B:7:0x000f), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e2 A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #3 {all -> 0x00f1, blocks: (B:2:0x0000, B:15:0x002c, B:19:0x003c, B:21:0x0044, B:23:0x0051, B:25:0x005e, B:31:0x0074, B:33:0x0084, B:47:0x00c1, B:49:0x00cc, B:53:0x00d7, B:55:0x00e2, B:7:0x000f), top: B:69:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bd A[EDGE_INSN: B:72:0x00bd->B:45:0x00bd ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context):java.lang.String");
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace(ContainerUtils.FIELD_DELIMITER, "");
    }

    public static void a(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if ("64".equals(next) && jSONObject.optInt(next, 1) == 0) {
                    d = false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String b() {
        BufferedReader bufferedReader;
        try {
            File file = new File("/sys/class/android_usb/android0/iSerial");
            if (file.exists()) {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    String readLine = bufferedReader2.readLine();
                    bufferedReader = bufferedReader2;
                    if (!TextUtils.isEmpty(readLine)) {
                        String trim = readLine.trim();
                        try {
                            bufferedReader2.close();
                            return trim;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return trim;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    try {
                        th.printStackTrace();
                        if (bufferedReader == null) {
                            return null;
                        }
                        bufferedReader.close();
                        return null;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        throw th3;
                    }
                }
            } else {
                bufferedReader = null;
            }
            if (bufferedReader == null) {
                return null;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
            return null;
        } catch (Throwable th6) {
            th6.printStackTrace();
            return null;
        }
    }

    public static c c() {
        return b.f28159a;
    }

    public String a() {
        try {
            return !TextUtils.isEmpty(this.f28160a) ? this.f28160a : "KWE_N";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_N";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0365 A[Catch: all -> 0x04b5, TryCatch #8 {all -> 0x04b5, blocks: (B:70:0x0262, B:76:0x02aa, B:87:0x02e0, B:89:0x02f3, B:91:0x0305, B:93:0x031f, B:95:0x0333, B:97:0x0349, B:99:0x0353, B:101:0x035d, B:103:0x0365, B:105:0x0371, B:107:0x0380, B:108:0x0388, B:109:0x0391, B:110:0x039f, B:121:0x0431, B:122:0x0434, B:85:0x02d7, B:81:0x02c5, B:111:0x03a2, B:115:0x03b2, B:117:0x03d7, B:118:0x03e9), top: B:156:0x0262, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03b2 A[Catch: all -> 0x042a, TRY_ENTER, TryCatch #8 {all -> 0x04b5, blocks: (B:70:0x0262, B:76:0x02aa, B:87:0x02e0, B:89:0x02f3, B:91:0x0305, B:93:0x031f, B:95:0x0333, B:97:0x0349, B:99:0x0353, B:101:0x035d, B:103:0x0365, B:105:0x0371, B:107:0x0380, B:108:0x0388, B:109:0x0391, B:110:0x039f, B:121:0x0431, B:122:0x0434, B:85:0x02d7, B:81:0x02c5, B:111:0x03a2, B:115:0x03b2, B:117:0x03d7, B:118:0x03e9), top: B:156:0x0262, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03e9 A[EDGE_INSN: B:170:0x03e9->B:118:0x03e9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0349 A[Catch: all -> 0x04b5, TRY_ENTER, TryCatch #8 {all -> 0x04b5, blocks: (B:70:0x0262, B:76:0x02aa, B:87:0x02e0, B:89:0x02f3, B:91:0x0305, B:93:0x031f, B:95:0x0333, B:97:0x0349, B:99:0x0353, B:101:0x035d, B:103:0x0365, B:105:0x0371, B:107:0x0380, B:108:0x0388, B:109:0x0391, B:110:0x039f, B:121:0x0431, B:122:0x0434, B:85:0x02d7, B:81:0x02c5, B:111:0x03a2, B:115:0x03b2, B:117:0x03d7, B:118:0x03e9), top: B:156:0x0262, inners: #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r8, com.yxcorp.kuaishou.addfp.ResponseDfpCallback r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 1302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.android.a.c.a(android.content.Context, com.yxcorp.kuaishou.addfp.ResponseDfpCallback, boolean):java.lang.String");
    }

    public void b(String str) {
        this.f28160a = str;
    }
}
