package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.e.a;
import com.alibaba.mtl.log.e.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.e.n;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/d/b.class */
public abstract class b implements Runnable {
    static int A = 0;
    private static volatile boolean E = false;
    private static boolean F = false;
    int B = -1;

    /* renamed from: a  reason: collision with root package name */
    float f4489a = 200.0f;
    int C = 0;

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0152, code lost:
        if (r22.size() == 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0247, code lost:
        com.alibaba.mtl.log.e.k.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02e5, code lost:
        com.alibaba.mtl.log.d.b.E = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void M() {
        /*
            Method dump skipped, instructions count: 765
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.d.b.M():void");
    }

    private int a(Boolean bool, long j) {
        if (j < 0) {
            return this.B;
        }
        float f = this.C / ((float) j);
        if (!bool.booleanValue()) {
            this.B /= 2;
            A++;
        } else if (j > 45000) {
            return this.B;
        } else {
            this.B = (int) (((f * 45000.0f) / this.f4489a) - A);
        }
        int i = this.B;
        if (i < 1) {
            this.B = 1;
            A = 0;
        } else if (i > 350) {
            this.B = 350;
        }
        i.a("UploadTask", "winsize:", Integer.valueOf(this.B));
        return this.B;
    }

    private a.C0043a a(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = e.a(2, str, map, false).e;
            i.a("UploadTask", "url:", str);
            if (bArr != null) {
                String str2 = null;
                try {
                    str2 = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (str2 != null) {
                    i.a("UploadTask", "result:", str2);
                    return com.alibaba.mtl.log.e.a.a(str2);
                }
            }
        }
        return a.C0043a.f4490a;
    }

    private List<String> a(com.alibaba.mtl.log.model.a aVar) {
        return com.alibaba.mtl.log.a.a.m2161a(aVar.T);
    }

    private Map<String, Object> a(List<com.alibaba.mtl.log.model.a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            List<String> a2 = a(list.get(i2));
            if (a2 != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < a2.size()) {
                        StringBuilder sb = (StringBuilder) hashMap.get(a2.get(i4));
                        if (sb == null) {
                            sb = new StringBuilder();
                            hashMap.put(a2.get(i4), sb);
                        } else {
                            sb.append("\n");
                        }
                        sb.append(list.get(i2).h());
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
        HashMap hashMap2 = new HashMap();
        this.C = 0;
        for (String str : hashMap.keySet()) {
            byte[] a3 = a(((StringBuilder) hashMap.get(str)).toString());
            hashMap2.put(str, a3);
            this.C += a3.length;
        }
        float size = this.C / list.size();
        this.f4489a = size;
        i.a("UploadTask", "averagePackageSize:", Float.valueOf(size));
        return hashMap2;
    }

    private byte[] a(String str) {
        GZIPOutputStream gZIPOutputStream;
        byte[] a2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream3 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream3.write(str.getBytes("UTF-8"));
                        gZIPOutputStream3.flush();
                        gZIPOutputStream3.close();
                    } catch (IOException e) {
                        gZIPOutputStream = gZIPOutputStream3;
                        e = e;
                        gZIPOutputStream2 = gZIPOutputStream;
                        e.printStackTrace();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        a2 = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
                        byteArrayOutputStream.close();
                        return a2;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream2 = gZIPOutputStream3;
                        if (gZIPOutputStream2 != null) {
                            try {
                                gZIPOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
                gZIPOutputStream = null;
            }
        } catch (Exception e4) {
        }
        a2 = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
        try {
            byteArrayOutputStream.close();
            return a2;
        } catch (Exception e5) {
            return a2;
        }
    }

    private int b(List<com.alibaba.mtl.log.model.a> list) {
        int i = 0;
        if (list == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= list.size()) {
                return i3;
            }
            String str = list.get(i).T;
            int i4 = i3;
            if (str != null) {
                i4 = i3;
                if ("6005".equalsIgnoreCase(str.toString())) {
                    i4 = i3 + 1;
                }
            }
            i++;
            i2 = i4;
        }
    }

    private int h() {
        if (this.B == -1) {
            String u = l.u();
            if ("wifi".equalsIgnoreCase(u)) {
                this.B = 20;
            } else if ("4G".equalsIgnoreCase(u)) {
                this.B = 16;
            } else if ("3G".equalsIgnoreCase(u)) {
                this.B = 12;
            } else {
                this.B = 8;
            }
        }
        return this.B;
    }

    public static boolean isRunning() {
        return E;
    }

    public abstract void K();

    public abstract void L();

    @Override // java.lang.Runnable
    public void run() {
        try {
            M();
            K();
        } catch (Throwable th) {
        }
    }
}
