package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/h.class */
public class h {
    private static Boolean mb;

    public static boolean b() {
        try {
            InetAddress.getByName(mb("3132372e302e302e31"));
            new Socket(mb("3132372e302e302e31"), Integer.parseInt(mb("3237303432")));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean b(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        boolean z = false;
        if (registerReceiver == null) {
            return false;
        }
        if (registerReceiver.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) == 2) {
            z = true;
        }
        return z;
    }

    private static boolean h() {
        String mb2 = mb("2f7362696e2f7375");
        String mb3 = mb("2f73797374656d2f62696e2f7375");
        String mb4 = mb("2f73797374656d2f7862696e2f7375");
        String mb5 = mb("2f646174612f6c6f63616c2f7862696e2f7375");
        String mb6 = mb("2f646174612f6c6f63616c2f62696e2f7375");
        String mb7 = mb("2f73797374656d2f73642f7862696e2f7375");
        String mb8 = mb("2f73797374656d2f62696e2f6661696c736166652f7375");
        String mb9 = mb("2f646174612f6c6f63616c2f7375");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return false;
            }
            if (new File(new String[]{mb2, mb3, mb4, mb5, mb6, mb7, mb8, mb9}[i2]).exists()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean h(Context context) {
        return u() || u(context);
    }

    private static int hj() {
        String str;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, mb("726f2e736563757265"));
            str = null;
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception e) {
            str = null;
        }
        return (str != null && "0".equals(str)) ? 0 : 1;
    }

    public static boolean hj(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            boolean z = false;
            if (simState != 1) {
                z = false;
                if (simState != 0) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    private static String mb(String str) {
        return DownloadUtils.hexToString(str);
    }

    public static void mb(Context context) {
        synchronized (h.class) {
            try {
                if (mb == null) {
                    mb = Boolean.valueOf((ox() || ox(context) || b(context) || !hj(context) || b() || h(context)) ? false : true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean mb() {
        Boolean bool = mb;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static boolean ox() {
        if (hj() == 0) {
            return true;
        }
        return h();
    }

    public static boolean ox(Context context) {
        boolean z = false;
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean u() {
        String str;
        try {
            HashSet hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.endsWith(".so") || readLine.endsWith(ShareConstants.JAR_SUFFIX)) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            Iterator it = hashSet.iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
                str = (String) it.next();
                if (str.contains(mb("636f6d2e73617572696b2e737562737472617465")) || str.contains(mb("58706f7365644272696467652e6a6172"))) {
                    return true;
                }
            } while (!str.contains(mb("6c696273616e64686f6f6b2e656478702e736f")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean u(Context context) {
        List<String> asList = Arrays.asList(mb("64652e726f62762e616e64726f69642e78706f736564"), mb("636f6d2e746f706a6f686e77752e6d616769736b"), mb("696f2e76612e6578706f736564"), mb("636f6d2e77696e642e636f74746572"), mb("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), mb("6d652e7765697368752e657870"), mb("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        for (String str : asList) {
            try {
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (packageManager.getPackageInfo(str, 0) != null) {
                return true;
            }
        }
        return false;
    }
}
