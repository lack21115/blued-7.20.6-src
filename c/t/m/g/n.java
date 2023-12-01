package c.t.m.g;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap f3839a = new HashMap();

    public static int a(Context context) {
        try {
            return a((WifiManager) context.getSystemService("wifi"));
        } catch (Throwable th) {
            return 4;
        }
    }

    public static int a(WifiManager wifiManager) {
        if (wifiManager == null) {
            return 4;
        }
        try {
            return wifiManager.getWifiState();
        } catch (Throwable th) {
            return 4;
        }
    }

    public static String a() {
        String bssid;
        try {
            WifiInfo a2 = r3.a();
            if (a2 == null || (bssid = a2.getBSSID()) == null || bssid.equals("000000000000") || bssid.equals("00-00-00-00-00-00") || bssid.equals("00:00:00:00:00:00")) {
                return "{}";
            }
            int rssi = a2.getRssi();
            if (rssi < -100 || rssi > -20) {
                return "{}";
            }
            String replace = a2.getSSID().replace("\"", "").replace("|", "");
            return "{\"mac\":\"" + bssid + "\",\"rssi\":" + rssi + ",\"ssid\":\"" + replace + "\"}";
        } catch (Throwable th) {
            return "{}";
        }
    }

    public static boolean a(List<ScanResult> list) {
        if (list == null || list.size() <= 1) {
            return true;
        }
        String str = list.get(0).BSSID;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return true;
            }
            if (!str.equals(list.get(i2).BSSID)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static boolean a(List<ScanResult> list, List<ScanResult> list2) {
        int size;
        HashMap hashMap;
        Iterator<ScanResult> it;
        ScanResult next;
        synchronized (n.class) {
            if (list == list2) {
                return true;
            }
            if (list == null) {
                size = 0;
            } else {
                try {
                    size = list.size();
                } finally {
                }
            }
            if (size != (list2 == null ? 0 : list2.size())) {
                return false;
            }
            if (size == 0) {
                return true;
            }
            try {
                hashMap = f3839a;
                hashMap.clear();
                for (ScanResult scanResult : list) {
                    hashMap.put(scanResult.BSSID, Integer.valueOf(scanResult.level));
                }
                it = list2.iterator();
            } catch (Throwable th) {
            }
            do {
                if (!it.hasNext()) {
                    return true;
                }
                next = it.next();
                if (!hashMap.containsKey(next.BSSID)) {
                    break;
                }
            } while (next.level == ((Integer) hashMap.get(next.BSSID)).intValue());
            return false;
        }
    }
}
