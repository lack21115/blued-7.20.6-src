package com.ishumei.l1111l111111Il;

import android.content.pm.PackageManager;
import android.os.Build;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l1111l111111Il.class */
public class l1111l111111Il {
    private static int l1111l111111Il = 1;
    private static String l111l11111I1l;
    private static String l111l11111Il;
    private static int l111l11111lIl = 2;
    private static String l111l1111l1Il;
    private static String l111l1111lI1l;
    private static String l111l1111lIl;
    private static String l111l1111llIl;
    private static String l11l1111I11l;
    private static String l11l1111I1l;
    private static String l11l1111I1ll;
    private static String l11l1111Il;
    private static String l11l1111Il1l;
    private static String l11l1111Ill;
    private static String l11l1111lIIl;
    private static String l11l111l11Il;
    private static l1111l111111Il l11l111l1lll;
    private static String l11l11IlIIll;
    private String l111l11IlIlIl;

    static {
        try {
            l111l11111I1l = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("919a8b88908d94");
            l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("908f9a8d9e8b908d");
            l111l1111l1Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c8c969b");
            l111l1111llIl = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9d8c8c969b");
            l111l1111lI1l = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("88969996968f");
            l111l1111lIl = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("96929a96");
            l11l1111lIIl = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("96928c96");
            l11l1111I11l = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("969c9c969b");
            l11l1111I1l = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e9b969b");
            l11l1111I1ll = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9a9393");
            l11l1111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e8f8f8c");
            l11l1111Il1l = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("919a8b");
            l11l1111Ill = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c9a918c908d");
            l11l11IlIIll = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e96919990");
            l11l111l11Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d968c949e8f8f");
        } catch (Exception e) {
        }
        l11l111l1lll = null;
    }

    public static l1111l111111Il l1111l111111Il() {
        if (l11l111l1lll == null) {
            synchronized (l1111l111111Il.class) {
                try {
                    if (l11l111l1lll == null) {
                        l11l111l1lll = new l1111l111111Il();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return l11l111l1lll;
    }

    private static Map<String, Object> l1111l111111Il(Map<String, l111l11111lIl.C0289l111l11111lIl> map) {
        Integer num;
        HashMap hashMap = new HashMap();
        if (map != null) {
            if (map.size() != 0 && l111l1111llIl.l1111l111111Il.l111l11111Il != null) {
                PackageManager packageManager = l111l1111llIl.l1111l111111Il.l111l11111Il.getPackageManager();
                HashMap hashMap2 = new HashMap();
                for (Map.Entry<String, l111l11111lIl.C0289l111l11111lIl> entry : map.entrySet()) {
                    String key = entry.getKey();
                    l111l11111lIl.C0289l111l11111lIl value = entry.getValue();
                    hashMap2.put(value.l111l11111lIl(), key);
                    try {
                        if (packageManager.getLaunchIntentForPackage(value.l111l11111lIl()) != null) {
                            hashMap.put(key, 1);
                        }
                        if (packageManager.getPackageInfo(value.l111l11111lIl(), 0) != null) {
                            hashMap.put(key, 1);
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                            if (new File("/data/app/" + value.l111l11111lIl() + "-1/").exists()) {
                                num = 1;
                            } else {
                                if (new File("/data/app/" + value.l111l11111lIl() + "-2/").exists()) {
                                    num = 1;
                                }
                            }
                            hashMap.put(key, num);
                        }
                    } catch (Exception e) {
                    }
                }
            }
            return hashMap;
        }
        return hashMap;
    }

    private static Map<String, Object> l111l11111lIl(Map<String, l111l11111lIl.l111l11111I1l> map) {
        String key;
        l111l11111lIl.l111l11111I1l value;
        Integer num;
        HashMap hashMap = new HashMap();
        if (map != null) {
            if (map.size() == 0) {
                return hashMap;
            }
            for (Map.Entry<String, l111l11111lIl.l111l11111I1l> entry : map.entrySet()) {
                try {
                    key = entry.getKey();
                    value = entry.getValue();
                } catch (Exception e) {
                }
                if (value.l111l11111I1l() == 0) {
                    if (com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(value.l111l11111lIl())) {
                        num = 1;
                    }
                } else if (1 == value.l111l11111I1l() && com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111lIl(value.l111l11111lIl())) {
                    num = 1;
                }
                hashMap.put(key, num);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:177:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0606 A[Catch: all -> 0x0624, TryCatch #3 {, blocks: (B:4:0x0002, B:190:0x0632, B:194:0x0650, B:196:0x0658, B:198:0x0661, B:200:0x068d, B:206:0x069f, B:207:0x06bf, B:6:0x0023, B:9:0x0033, B:11:0x003a, B:16:0x005d, B:20:0x008e, B:22:0x00ef, B:24:0x00fc, B:27:0x011d, B:29:0x0128, B:31:0x0133, B:34:0x013f, B:35:0x014c, B:38:0x0158, B:40:0x0165, B:45:0x0177, B:47:0x0183, B:48:0x018b, B:50:0x019a, B:52:0x01a7, B:55:0x01ba, B:57:0x01c7, B:59:0x01d4, B:62:0x01e3, B:64:0x01f0, B:66:0x01fd, B:67:0x0207, B:68:0x020a, B:70:0x021d, B:73:0x0227, B:75:0x0242, B:77:0x024a, B:78:0x0262, B:79:0x026c, B:82:0x0278, B:84:0x0285, B:89:0x0297, B:91:0x02a3, B:92:0x02ab, B:95:0x02ba, B:97:0x02c7, B:99:0x02d4, B:101:0x02e0, B:103:0x02eb, B:105:0x02f7, B:107:0x0302, B:109:0x030e, B:114:0x0326, B:116:0x0330, B:117:0x0338, B:120:0x0345, B:122:0x0352, B:124:0x035f, B:126:0x037b, B:130:0x0414, B:132:0x042a, B:134:0x0434, B:141:0x0453, B:139:0x044a, B:142:0x045e, B:144:0x0467, B:146:0x0480, B:147:0x048a, B:150:0x0494, B:152:0x04ad, B:154:0x04be, B:156:0x04ce, B:159:0x04ed, B:161:0x04f9, B:162:0x050d, B:165:0x0515, B:167:0x054d, B:169:0x055d, B:173:0x0571, B:175:0x0587, B:179:0x058f, B:181:0x0606, B:184:0x0611, B:186:0x0619, B:14:0x0054), top: B:232:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x064c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String l1111l111111Il(int r8) {
        /*
            Method dump skipped, instructions count: 1797
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l1111l111111Il.l1111l111111Il.l1111l111111Il(int):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String l111l11111lIl() {
        return this.l111l11IlIlIl;
    }
}
