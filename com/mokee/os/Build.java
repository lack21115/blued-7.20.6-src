package com.mokee.os;

import android.content.Context;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.content.NativeLibraryHelper;
import java.math.BigInteger;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/os/Build.class */
public class Build {
    public static final String MAINTAINER = null;
    public static final String MOD_VERSION = null;
    public static final String PRODUCT = null;
    public static final String RELEASE_TYPE = null;
    public static final String VERSION = null;
    private static final String[] a = null;
    public static int b;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/os/Build$VERSION.class */
    public static class VERSION {
        private static final String[] a = Build.VERSION.split(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
        public static final String CODENAME = a[0];
        public static final String DATETIME = a[2];
    }

    static {
        String[] strArr = new String[4];
        throw new VerifyError("bad dex opcode");
    }

    private static String a(String str) {
        try {
            return new BigInteger(1, MessageDigest.getInstance(a[3]).digest(str.getBytes())).toString(16).toUpperCase(Locale.ENGLISH);
        } catch (Exception e) {
            return null;
        }
    }

    private static String a(String str, String str2) {
        return SystemProperties.get(str, str2);
    }

    public static String getUniqueID(Context context) {
        String a2 = a(String.valueOf(((TelephonyManager) context.getSystemService(a[0])).getDeviceId()) + android.os.Build.SERIAL);
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            try {
                str = a(new String(NetworkInterface.getByName(SystemProperties.get(a[2])).getHardwareAddress()));
            } catch (Exception e) {
                return a[1];
            }
        }
        return str;
    }
}
