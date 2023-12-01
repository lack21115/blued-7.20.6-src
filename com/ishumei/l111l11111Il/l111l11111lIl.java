package com.ishumei.l111l11111Il;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.io.ByteArrayInputStream;
import java.io.RandomAccessFile;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111lIl.class */
public final class l111l11111lIl {
    private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9a878f");
    private static final String l111l11111lIl = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e8f94ac969891b79e8c97bc909b9a");
    private static final String l111l11111I1l = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e8f94af9e8b97");
    private static final String l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c969891969198b6919990");

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l11111lIl$l1111l111111Il.class */
    public static final class l1111l111111Il {
        public List<String> l111l11111I1l;
        Map<String, Object> l111l11111Il;
        public String l111l1111l1Il;
        int l1111l111111Il = 0;
        int l111l11111lIl = 0;
    }

    public static int l1111l111111Il() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return 0;
        }
        return context.getApplicationInfo().targetSdkVersion;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x024a, code lost:
        if (r11 < r9) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0266, code lost:
        if (r14 < r10) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il l1111l111111Il(java.util.Map<java.lang.String, com.ishumei.l111l11111lIl.l111l11111lIl.l111l11111Il> r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il(java.util.Map, int, int):com.ishumei.l111l11111Il.l111l11111lIl$l1111l111111Il");
    }

    public static String l1111l111111Il(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream((byte[]) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(obj, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8b90bd868b9abe8d8d9e86"))))).getSubjectDN().toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static void l1111l111111Il(Map<String, Object> map) {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28) {
                return;
            }
            Signature[] apkContentsSigners = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728).signingInfo.getApkContentsSigners();
            ArrayList arrayList = new ArrayList();
            int length = apkContentsSigners.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    map.put(l111l11111Il, arrayList);
                    return;
                } else {
                    arrayList.add(Integer.valueOf(apkContentsSigners[i2].hashCode()));
                    i = i2 + 1;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void l1111l111111Il(Map<String, Object> map, String str) {
        RandomAccessFile randomAccessFile;
        if (TextUtils.isEmpty(str)) {
            map.put(l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf918a9393"));
            return;
        }
        map.put(l111l11111I1l, str);
        if (!str.startsWith(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d09b9e8b9ed09e8f8fd0") + l111l11111I1l())) {
            map.put(l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf91908bdf8c8b9e8d8bdf88968b97dfd8d09b9e8b9ed09e8f8fd0") + l111l11111I1l() + "'");
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            map.put(l111l11111lIl, Integer.valueOf(new Signature(com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il.l1111l111111Il(randomAccessFile, com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il.l1111l111111Il(randomAccessFile)).l1111l111111Il[0][0].getEncoded()).hashCode()));
            try {
                randomAccessFile.close();
            } catch (Exception e) {
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                map.put(l1111l111111Il, th.getMessage());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th3) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                }
                throw th3;
            }
        }
    }

    private static Object[] l1111l111111Il(String str) {
        Object[] objArr;
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return null;
        }
        try {
            Object l1111l111111Il2 = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(context.getPackageManager(), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8baf9e9c949e989ab6919990"), new Class[]{String.class, Integer.TYPE}, new Object[]{str, 64});
            if (l1111l111111Il2 == null || (objArr = (Object[]) com.ishumei.l111l1111llIl.l111l1111l1Il.l111l11111lIl(l1111l111111Il2, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c9698919e8b8a8d9a8c"))) == null) {
                return null;
            }
            if (objArr.length > 0) {
                return objArr;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String l111l11111I1l() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return "";
        }
        try {
            return (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(context, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8baf9e9c949e989ab19e929a"));
        } catch (Exception e) {
            return "";
        }
    }

    private static String l111l11111I1l(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            Object l1111l111111Il2 = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(obj, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8b90bd868b9abe8d8d9e86"));
            Object l1111l111111Il3 = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("959e899ed18c9a9c8a8d968b86d1b29a8c8c9e989abb96989a8c8b"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb6918c8b9e919c9a"), new Class[]{String.class}, (Object[]) new String[]{com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("b2bbca")});
            com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l1111l111111Il3, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8d9a8c9a8b"));
            com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l1111l111111Il3, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8a8f9b9e8b9a"), new Class[]{byte[].class}, new Object[]{l1111l111111Il2});
            for (byte b : (byte[]) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l1111l111111Il3, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b96989a8c8b"))) {
                int i = b & 255;
                if (Integer.toHexString(i).length() == 1) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    public static Object l111l11111Il() {
        Object[] l1111l111111Il2;
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null || (l1111l111111Il2 = l1111l111111Il(context.getPackageName())) == null || l1111l111111Il2.length <= 0) {
            return null;
        }
        return l1111l111111Il2[0];
    }

    public static String l111l11111lIl() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return "";
        }
        try {
            String str = context.getPackageManager().getPackageInfo(l111l11111I1l(), 0).versionName;
            return str == null ? "" : str;
        } catch (Exception e) {
            return "";
        }
    }

    private static String l111l11111lIl(String str) {
        return com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il(str);
    }

    private static List l111l11111lIl(Object obj) {
        return (List) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(obj, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb6918c8b9e93939a9baf9e9c949e989a8c"), new Class[]{Integer.TYPE}, new Object[]{0});
    }

    public static Map<String, Object> l111l1111l1Il() {
        HashMap hashMap = new HashMap();
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            hashMap.put(l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c8b87df968cdf918a9393"));
            return hashMap;
        }
        String str = context.getApplicationInfo().sourceDir;
        if (TextUtils.isEmpty(str)) {
            hashMap.put(l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf918a9393"));
        } else {
            hashMap.put(l111l11111I1l, str);
            if (!str.startsWith(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d09b9e8b9ed09e8f8fd0") + l111l11111I1l())) {
                hashMap.put(l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e8f94af9e8b97df968cdf91908bdf8c8b9e8d8bdf88968b97dfd8d09b9e8b9ed09e8f8fd0") + l111l11111I1l() + "'");
            }
            RandomAccessFile randomAccessFile = null;
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                    try {
                        hashMap.put(l111l11111lIl, Integer.valueOf(new Signature(com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il.l1111l111111Il(randomAccessFile2, com.ishumei.l111l11111Il.l111l11111lIl.l1111l111111Il.l1111l111111Il(randomAccessFile2)).l1111l111111Il[0][0].getEncoded()).hashCode()));
                        randomAccessFile2.close();
                    } catch (Throwable th) {
                        randomAccessFile = randomAccessFile2;
                        th = th;
                        try {
                            hashMap.put(l1111l111111Il, th.getMessage());
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            l1111l111111Il((Map<String, Object>) hashMap);
                            return hashMap;
                        } catch (Throwable th2) {
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e) {
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e2) {
            }
        }
        l1111l111111Il((Map<String, Object>) hashMap);
        return hashMap;
    }

    public static int l111l1111llIl() {
        return (l111l1111llIl.l1111l111111Il.l111l11111Il.getApplicationInfo().flags & 2) > 0 ? 1 : 0;
    }
}
