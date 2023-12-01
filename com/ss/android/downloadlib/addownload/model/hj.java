package com.ss.android.downloadlib.addownload.model;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/hj.class */
public class hj {
    private static final String[] b = {"com", "android", "ss"};
    private static final int[] hj = {3101, 3102, 3103, 3201, 3202, 3203};
    private static volatile hj mb;
    private final LinkedList<mb> ox = new LinkedList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/model/hj$mb.class */
    public static class mb {
        public final String b;
        public final long h;
        public final String hj;
        public final String mb;
        public final int ox;

        private mb(String str, int i, String str2, String str3, long j) {
            this.mb = str;
            this.ox = i;
            this.b = str2 != null ? str2.toLowerCase() : null;
            this.hj = str3 != null ? str3.toLowerCase() : null;
            this.h = j;
        }
    }

    private hj() {
    }

    private mb b(String str) {
        try {
            PackageManager packageManager = x.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new mb(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static hj mb() {
        if (mb == null) {
            synchronized (hj.class) {
                try {
                    if (mb == null) {
                        mb = new hj();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mb;
    }

    private static boolean mb(String str, String str2) {
        boolean z;
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (split.length == 0 || split2.length == 0) {
                return false;
            }
            int length = split.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i >= length) {
                    return false;
                }
                String str3 = split[i];
                String[] strArr = b;
                int length2 = strArr.length;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= length2) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i6];
                    if (str4.equals(str3)) {
                        int i7 = i2;
                        if (i2 < split2.length) {
                            i7 = i2;
                            if (str4.equals(split2[i2])) {
                                i7 = i2 + 1;
                            }
                        }
                        z = true;
                        i2 = i7;
                    } else {
                        i5 = i6 + 1;
                    }
                }
                int i8 = i2;
                int i9 = i4;
                if (!z) {
                    int i10 = i2;
                    int i11 = i2;
                    while (i10 < split2.length) {
                        int i12 = i11;
                        int i13 = i4;
                        if (str3.equals(split2[i10])) {
                            i12 = i11;
                            if (i10 == i11) {
                                i12 = i11 + 1;
                            }
                            int i14 = i4 + 1;
                            i13 = i14;
                            if (i14 >= 2) {
                                return true;
                            }
                        }
                        i10++;
                        i11 = i12;
                        i4 = i13;
                    }
                    i9 = i4;
                    i8 = i11;
                }
                i++;
                i2 = i8;
                i3 = i9;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void ox() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.ox) {
            Iterator<mb> it = this.ox.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().h > 1800000) {
                it.remove();
            }
        }
    }

    public mb mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        mb next;
        if (oxVar == null) {
            return null;
        }
        ox();
        synchronized (this.ox) {
            Iterator<mb> it = this.ox.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (next.h <= oxVar.xa());
            return next;
        }
    }

    public void mb(String str) {
        mb b2;
        ox();
        if (TextUtils.isEmpty(str) || (b2 = b(str)) == null) {
            return;
        }
        synchronized (this.ox) {
            this.ox.add(b2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x02d7, code lost:
        r0[1] = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ee, code lost:
        r0[2] = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.model.hj.mb, java.lang.Integer> ox(com.ss.android.downloadad.api.mb.ox r7) {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.model.hj.ox(com.ss.android.downloadad.api.mb.ox):android.util.Pair");
    }

    public void ox(String str) {
        ox();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.ox) {
            Iterator<mb> it = this.ox.iterator();
            do {
                if (!it.hasNext()) {
                    return;
                }
            } while (!str.equals(it.next().mb));
            it.remove();
        }
    }
}
