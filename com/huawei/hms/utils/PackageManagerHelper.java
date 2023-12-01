package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/PackageManagerHelper.class */
public class PackageManagerHelper {

    /* renamed from: a  reason: collision with root package name */
    public final PackageManager f22923a;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/utils/PackageManagerHelper$PackageStates.class */
    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED,
        SPOOF
    }

    public PackageManagerHelper(Context context) {
        this.f22923a = context.getPackageManager();
    }

    public final byte[] a(String str) {
        try {
            PackageInfo packageInfo = this.f22923a.getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (AndroidException e) {
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
        } catch (RuntimeException e2) {
            HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e2);
        }
        HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public String getApplicationName(String str) {
        try {
            return this.f22923a.getApplicationLabel(this.f22923a.getApplicationInfo(str, 128)).toString();
        } catch (AndroidException e) {
            HMSLog.e("PackageManagerHelper", "Failed to get application name for " + str);
            return null;
        }
    }

    public long getPackageFirstInstallTime(String str) {
        long j = 0;
        try {
            PackageInfo packageInfo = this.f22923a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                j = packageInfo.firstInstallTime;
            }
            return j;
        } catch (AndroidException | RuntimeException e) {
            return 0L;
        }
    }

    public String getPackageSignature(String str) {
        byte[] a2 = a(str);
        if (a2 == null || a2.length == 0) {
            return null;
        }
        return HEX.encodeHexString(SHA256.digest(a2), true);
    }

    public PackageStates getPackageStates(String str) {
        if (TextUtils.isEmpty(str)) {
            return PackageStates.NOT_INSTALLED;
        }
        try {
            return this.f22923a.getApplicationInfo(str, 128).enabled ? PackageStates.ENABLED : PackageStates.DISABLED;
        } catch (AndroidException e) {
            return PackageStates.NOT_INSTALLED;
        }
    }

    public int getPackageVersionCode(String str) {
        try {
            PackageInfo packageInfo = this.f22923a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (AndroidException e) {
            HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed " + e);
            return 0;
        } catch (RuntimeException e2) {
            HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed", e2);
            return 0;
        }
    }

    public String getPackageVersionName(String str) {
        try {
            PackageInfo packageInfo = this.f22923a.getPackageInfo(str, 16);
            return (packageInfo == null || packageInfo.versionName == null) ? "" : packageInfo.versionName;
        } catch (AndroidException e) {
            return "";
        } catch (RuntimeException e2) {
            HMSLog.e("PackageManagerHelper", "get getPackageVersionName failed", e2);
            return "";
        }
    }

    public boolean hasProvider(String str, String str2) {
        try {
            PackageInfo packageInfo = this.f22923a.getPackageInfo(str, 8);
            if (packageInfo == null || packageInfo.providers == null) {
                return false;
            }
            ProviderInfo[] providerInfoArr = packageInfo.providers;
            int length = providerInfoArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (str2.equals(providerInfoArr[i2].authority)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (AndroidException | RuntimeException e) {
            return false;
        }
    }

    public boolean isPackageFreshInstall(String str) {
        try {
            PackageInfo packageInfo = this.f22923a.getPackageInfo(str, 128);
            boolean z = false;
            if (packageInfo != null) {
                z = false;
                if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                    z = true;
                }
            }
            return z;
        } catch (AndroidException | RuntimeException e) {
            return false;
        }
    }

    public boolean verifyPackageArchive(String str, String str2, String str3) {
        PackageInfo packageArchiveInfo = this.f22923a.getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null || packageArchiveInfo.signatures.length <= 0 || !str2.equals(packageArchiveInfo.packageName)) {
            return false;
        }
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream inputStream3 = IOUtils.toInputStream(packageArchiveInfo.signatures[0].toByteArray());
                inputStream = inputStream3;
                inputStream2 = inputStream3;
                boolean equalsIgnoreCase = str3.equalsIgnoreCase(HEX.encodeHexString(SHA256.digest(CertificateFactory.getInstance("X.509").generateCertificate(inputStream3).getEncoded()), true));
                IOUtils.closeQuietly(inputStream3);
                return equalsIgnoreCase;
            } catch (IOException e) {
                e = e;
                inputStream = inputStream2;
                StringBuilder sb = new StringBuilder();
                InputStream inputStream4 = inputStream;
                sb.append("Failed to get application signature certificate fingerprint.");
                InputStream inputStream5 = inputStream;
                sb.append(e.getMessage());
                InputStream inputStream6 = inputStream;
                HMSLog.e("PackageManagerHelper", sb.toString());
                IOUtils.closeQuietly(inputStream);
                return false;
            } catch (CertificateException e2) {
                e = e2;
                StringBuilder sb2 = new StringBuilder();
                InputStream inputStream42 = inputStream;
                sb2.append("Failed to get application signature certificate fingerprint.");
                InputStream inputStream52 = inputStream;
                sb2.append(e.getMessage());
                InputStream inputStream62 = inputStream;
                HMSLog.e("PackageManagerHelper", sb2.toString());
                IOUtils.closeQuietly(inputStream);
                return false;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly((InputStream) null);
            throw th;
        }
    }
}
