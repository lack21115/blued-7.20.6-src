package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ko.class */
public final class ko {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ko$mb.class */
    public static class mb {
        private Drawable b;
        private String h;
        private String hj;
        private boolean ko;
        private String mb;
        private String ox;
        private int u;

        public mb(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            ox(str2);
            mb(drawable);
            mb(str);
            b(str3);
            hj(str4);
            mb(i);
            mb(z);
        }

        public String b() {
            return this.mb;
        }

        public void b(String str) {
            this.hj = str;
        }

        public String h() {
            return this.hj;
        }

        public String hj() {
            return this.ox;
        }

        public void hj(String str) {
            this.h = str;
        }

        public String ko() {
            return this.h;
        }

        public Drawable mb() {
            return this.b;
        }

        public void mb(int i) {
            this.u = i;
        }

        public void mb(Drawable drawable) {
            this.b = drawable;
        }

        public void mb(String str) {
            this.mb = str;
        }

        public void mb(boolean z) {
            this.ko = z;
        }

        public void ox(String str) {
            this.ox = str;
        }

        public boolean ox() {
            return this.ko;
        }

        public String toString() {
            return "{\n  pkg name: " + b() + "\n  app icon: " + mb() + "\n  app name: " + hj() + "\n  app path: " + h() + "\n  app v name: " + ko() + "\n  app v code: " + u() + "\n  is system: " + ox() + "}";
        }

        public int u() {
            return this.u;
        }
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static int mb(String str) {
        if (b(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = DownloadComponentManager.getAppContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static mb mb(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawable;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String charSequence = applicationInfo.loadLabel(packageManager).toString();
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception e) {
            drawable = null;
        }
        return new mb(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static mb ox(String str) {
        try {
            PackageManager packageManager = DownloadComponentManager.getAppContext().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return mb(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
