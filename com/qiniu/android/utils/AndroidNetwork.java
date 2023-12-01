package com.qiniu.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/AndroidNetwork.class */
public final class AndroidNetwork {
    public static String getHostIP() {
        String str;
        String str2 = null;
        String str3 = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (true) {
                str2 = str3;
                str = str3;
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                String str4 = str3;
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    String str5 = str3;
                    if (inetAddresses.hasMoreElements()) {
                        String str6 = str3;
                        InetAddress nextElement = inetAddresses.nextElement();
                        String str7 = str3;
                        if (!nextElement.isLinkLocalAddress()) {
                            String str8 = str3;
                            if (!nextElement.isLoopbackAddress()) {
                                String str9 = str3;
                                str3 = nextElement.getHostAddress();
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            str = str2;
        }
        return str;
    }

    public static int getMobileDbm() {
        Context applicationContext = ContextGetter.applicationContext();
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        int i = -1;
        if (Build.VERSION.SDK_INT >= 17) {
            if (applicationContext.checkPermission("android.permission.ACCESS_COARSE_LOCATION", Process.myPid(), Process.myUid()) != 0 || applicationContext.checkPermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) != 0) {
                return -1;
            }
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            i = -1;
            if (allCellInfo != null) {
                Iterator<CellInfo> it = allCellInfo.iterator();
                while (true) {
                    i = -1;
                    if (!it.hasNext()) {
                        break;
                    }
                    CellInfo next = it.next();
                    if (!(next instanceof CellInfoGsm)) {
                        if (!(next instanceof CellInfoCdma)) {
                            if (!(next instanceof CellInfoLte)) {
                                if (Build.VERSION.SDK_INT >= 18 && (next instanceof CellInfoWcdma)) {
                                    i = ((CellInfoWcdma) next).getCellSignalStrength().getDbm();
                                    break;
                                }
                            } else {
                                return ((CellInfoLte) next).getCellSignalStrength().getDbm();
                            }
                        } else {
                            return ((CellInfoCdma) next).getCellSignalStrength().getDbm();
                        }
                    } else {
                        return ((CellInfoGsm) next).getCellSignalStrength().getDbm();
                    }
                }
            }
        }
        return i;
    }

    private static String getNetWorkClass(Context context) {
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                return "none";
        }
    }

    public static boolean isNetWorkReady() {
        Context applicationContext = ContextGetter.applicationContext();
        if (applicationContext == null) {
            return true;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static String networkType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (connectivityManager == null || !activeNetworkInfo.isConnected()) {
            return "none";
        }
        int type = connectivityManager.getActiveNetworkInfo().getType();
        return type == 1 ? "wifi" : type == 0 ? getNetWorkClass(context) : "none";
    }
}
