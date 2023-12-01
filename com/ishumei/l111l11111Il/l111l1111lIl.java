package com.ishumei.l111l11111Il;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.google.android.material.timepicker.TimeModel;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l111l1111lIl.class */
public final class l111l1111lIl {
    private static final int l111l11111I1l = -1;
    private static final int l111l11111Il = -101;
    private Context l1111l111111Il;
    private Object l111l11111lIl;

    public l111l1111lIl() {
        Object l1111l111111Il;
        this.l1111l111111Il = null;
        this.l111l11111lIl = null;
        try {
            Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
            this.l1111l111111Il = context;
            if (context == null || (l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(context, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[]{String.class}, new Object[]{com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("88969996")})) == null) {
                return;
            }
            this.l111l11111lIl = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbc9091919a9c8b969091b6919990"));
        } catch (Exception e) {
        }
    }

    private static String l1111l111111Il(int i) {
        if (i != -101) {
            switch (i) {
                case -1:
                    return "nil";
                case 0:
                    return "unknown";
                case 1:
                    return "2g.gprs";
                case 2:
                    return "2g.edge";
                case 3:
                    return "3g.umts";
                case 4:
                    return "2g.cdma";
                case 5:
                    return "3g.evdo_0";
                case 6:
                    return "3g.evdo_a";
                case 7:
                    return "2g.1xrtt";
                case 8:
                    return "3g.hsdpa";
                case 9:
                    return "3g.hsupa";
                case 10:
                    return "3g.hspa";
                case 11:
                    return "2g.iden";
                case 12:
                    return "3g.evdo_b";
                case 13:
                    return "4g.lte";
                case 14:
                    return "3g.ehrpd";
                case 15:
                    return "3g.hspap";
                default:
                    return String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
            }
        }
        return "wifi";
    }

    private static String l1111l111111Il(String str) {
        if (str == null) {
            return "";
        }
        try {
            String hostAddress = InetAddress.getByName(str).getHostAddress();
            return hostAddress == null ? "" : hostAddress;
        } catch (Exception e) {
            return "";
        }
    }

    public static List<String> l111l1111l1Il() {
        ArrayList arrayList = new ArrayList();
        try {
            Object l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("959e899ed1919a8bd1b19a8b88908d94b6918b9a8d999e9c9a"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb19a8b88908d94b6918b9a8d999e9c9a8c"));
            Method declaredMethod = Enumeration.class.getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("979e8cb2908d9aba939a929a918b8c"), new Class[0]);
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = Enumeration.class.getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("919a878bba939a929a918b"), new Class[0]);
            declaredMethod2.setAccessible(true);
            while (((Boolean) declaredMethod.invoke(l1111l111111Il, new Object[0])).booleanValue()) {
                NetworkInterface networkInterface = (NetworkInterface) declaredMethod2.invoke(l1111l111111Il, new Object[0]);
                String displayName = networkInterface.getDisplayName();
                if (displayName.startsWith("wlan0") || displayName.startsWith("eth0")) {
                    if (!networkInterface.isLoopback()) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        String str = "";
                        String l111l11111Il2 = (hardwareAddress == null || hardwareAddress.length <= 0) ? "" : com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111Il(com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(hardwareAddress));
                        if (!l111l11111Il2.isEmpty() && !l111l11111Il2.equals("000000000000")) {
                            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                            String str2 = "";
                            while (inetAddresses.hasMoreElements()) {
                                InetAddress nextElement = inetAddresses.nextElement();
                                if (!nextElement.isLoopbackAddress()) {
                                    String hostAddress = nextElement.getHostAddress();
                                    if (hostAddress.trim().length() < 17) {
                                        str = hostAddress;
                                    } else {
                                        str2 = hostAddress;
                                    }
                                }
                            }
                            arrayList.add(displayName + "," + str + "," + l111l11111Il2 + "," + str2);
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            return arrayList;
        }
    }

    public static boolean l111l1111lI1l() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) l111l1111llIl.l1111l111111Il.l111l11111Il.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static String l111l1111lIl() {
        try {
            Object invoke = Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd19d938a9a8b90908b97d1bd938a9a8b90908b97be9b9e8f8b9a8d")).getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbb9a999e8a938bbe9b9e8f8b9a8d"), new Class[0]).invoke(null, new Object[0]);
            return com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111Il((String) invoke.getClass().getDeclaredMethod(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbe9b9b8d9a8c8c"), new Class[0]).invoke(invoke, new Object[0]));
        } catch (Throwable th) {
            try {
                return com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111Il(com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(new File(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d09a998cd09d938a9a8b90908b97d09d8ba09e9b9b8d"))));
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static String l111l1111llIl() {
        String host;
        String valueOf;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                host = property;
                valueOf = property2;
                if (TextUtils.isEmpty(property2)) {
                    valueOf = "-1";
                    host = property;
                }
            } else {
                Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
                if (context == null) {
                    return "";
                }
                host = Proxy.getHost(context);
                valueOf = String.valueOf(Proxy.getPort(context));
            }
            if (TextUtils.isEmpty(host)) {
                return "";
            }
            return host + ":" + valueOf;
        } catch (Exception e) {
            return "";
        }
    }

    private static boolean l11l1111I11l() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0;
    }

    private String l11l1111lIIl() {
        int i;
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.l1111l111111Il.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        } catch (Exception e) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                i = -101;
            } else {
                if (type == 0) {
                    i = ((TelephonyManager) this.l1111l111111Il.getSystemService("phone")).getNetworkType();
                }
                i = 0;
            }
        } else {
            i = -1;
        }
        if (i != -101) {
            switch (i) {
                case -1:
                    return "nil";
                case 0:
                    return "unknown";
                case 1:
                    return "2g.gprs";
                case 2:
                    return "2g.edge";
                case 3:
                    return "3g.umts";
                case 4:
                    return "2g.cdma";
                case 5:
                    return "3g.evdo_0";
                case 6:
                    return "3g.evdo_a";
                case 7:
                    return "2g.1xrtt";
                case 8:
                    return "3g.hsdpa";
                case 9:
                    return "3g.hsupa";
                case 10:
                    return "3g.hspa";
                case 11:
                    return "2g.iden";
                case 12:
                    return "3g.evdo_b";
                case 13:
                    return "4g.lte";
                case 14:
                    return "3g.ehrpd";
                case 15:
                    return "3g.hspap";
                default:
                    return String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
            }
        }
        return "wifi";
    }

    public final String l1111l111111Il() {
        String str = "";
        try {
            if (l11l1111I11l()) {
                if (this.l111l11111lIl != null) {
                    str = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bacacb6bb"));
                    if (str == null) {
                        return "";
                    }
                }
                return str;
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public final String l111l11111I1l() {
        String str = "";
        try {
            if (this.l111l11111lIl != null) {
                str = Formatter.formatIpAddress(((Integer) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb68fbe9b9b8d9a8c8c"))).intValue());
                if (str == null) {
                    return "";
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public final String l111l11111Il() {
        String str = "";
        try {
            if (this.l1111l111111Il != null) {
                str = l11l1111lIIl();
                if (str == null) {
                    return "";
                }
            }
            return str;
        } catch (Exception e) {
            return "";
        }
    }

    public final String l111l11111lIl() {
        String str = "";
        try {
            if (l11l1111I11l()) {
                if (this.l111l11111lIl != null) {
                    str = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbdacacb6bb"));
                    if (str == null) {
                        return "";
                    }
                }
                return str;
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }
}
