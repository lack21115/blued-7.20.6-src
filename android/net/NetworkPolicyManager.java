package android.net;

import android.content.Context;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.format.Time;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkPolicyManager.class */
public class NetworkPolicyManager {
    private static final boolean ALLOW_PLATFORM_APP_POLICY = true;
    public static final String EXTRA_NETWORK_TEMPLATE = "android.net.NETWORK_TEMPLATE";
    public static final int POLICY_ALLOW_BACKGROUND_BATTERY_SAVE = 2;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    public static final int RULE_ALLOW_ALL = 0;
    public static final int RULE_REJECT_METERED = 1;
    private INetworkPolicyManager mService;

    public NetworkPolicyManager(INetworkPolicyManager iNetworkPolicyManager) {
        if (iNetworkPolicyManager == null) {
            throw new IllegalArgumentException("missing INetworkPolicyManager");
        }
        this.mService = iNetworkPolicyManager;
    }

    public static long computeLastCycleBoundary(long j, NetworkPolicy networkPolicy) {
        if (networkPolicy.cycleDay == -1) {
            throw new IllegalArgumentException("Unable to compute boundary without cycleDay");
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(networkPolicy.cycleTimezone), Locale.getDefault());
        gregorianCalendar.setTimeInMillis(j);
        GregorianCalendar gregorianCalendar2 = (GregorianCalendar) gregorianCalendar.clone();
        gregorianCalendar2.set(11, 0);
        gregorianCalendar2.set(12, 0);
        gregorianCalendar2.set(13, 0);
        snapToCycleDay(gregorianCalendar2, networkPolicy.cycleDay);
        if (gregorianCalendar2.compareTo((Calendar) gregorianCalendar) >= 0) {
            GregorianCalendar gregorianCalendar3 = (GregorianCalendar) gregorianCalendar.clone();
            gregorianCalendar3.set(11, 0);
            gregorianCalendar3.set(12, 0);
            gregorianCalendar3.set(13, 0);
            gregorianCalendar3.set(5, 1);
            gregorianCalendar3.add(2, -1);
            gregorianCalendar2.setTimeInMillis(gregorianCalendar3.getTimeInMillis());
            snapToCycleDay(gregorianCalendar2, networkPolicy.cycleDay);
        }
        return gregorianCalendar2.getTimeInMillis();
    }

    public static long computeNextCycleBoundary(long j, NetworkPolicy networkPolicy) {
        if (networkPolicy.cycleDay == -1) {
            throw new IllegalArgumentException("Unable to compute boundary without cycleDay");
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(networkPolicy.cycleTimezone), Locale.getDefault());
        gregorianCalendar.setTimeInMillis(j);
        GregorianCalendar gregorianCalendar2 = (GregorianCalendar) gregorianCalendar.clone();
        gregorianCalendar2.set(11, 0);
        gregorianCalendar2.set(12, 0);
        gregorianCalendar2.set(13, 0);
        snapToCycleDay(gregorianCalendar2, networkPolicy.cycleDay);
        if (gregorianCalendar2.compareTo((Calendar) gregorianCalendar) <= 0) {
            GregorianCalendar gregorianCalendar3 = (GregorianCalendar) gregorianCalendar.clone();
            gregorianCalendar3.set(11, 0);
            gregorianCalendar3.set(12, 0);
            gregorianCalendar3.set(13, 0);
            gregorianCalendar3.set(5, 1);
            gregorianCalendar3.add(2, 1);
            gregorianCalendar2.setTimeInMillis(gregorianCalendar3.getTimeInMillis());
            snapToCycleDay(gregorianCalendar2, networkPolicy.cycleDay);
        }
        return gregorianCalendar2.getTimeInMillis();
    }

    public static void dumpPolicy(PrintWriter printWriter, int i) {
        printWriter.write("[");
        if ((i & 1) != 0) {
            printWriter.write("REJECT_METERED_BACKGROUND");
        }
        printWriter.write("]");
    }

    public static void dumpRules(PrintWriter printWriter, int i) {
        printWriter.write("[");
        if ((i & 1) != 0) {
            printWriter.write("REJECT_METERED");
        }
        printWriter.write("]");
    }

    public static NetworkPolicyManager from(Context context) {
        return (NetworkPolicyManager) context.getSystemService(Context.NETWORK_POLICY_SERVICE);
    }

    @Deprecated
    public static boolean isUidValidForPolicy(Context context, int i) {
        return UserHandle.isApp(i);
    }

    public static void snapToCycleDay(Time time, int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(time.timezone), Locale.getDefault());
        gregorianCalendar.setTimeInMillis(time.toMillis(true));
        snapToCycleDay(gregorianCalendar, i);
        time.set(gregorianCalendar.getTimeInMillis());
    }

    private static void snapToCycleDay(GregorianCalendar gregorianCalendar, int i) {
        if (i <= gregorianCalendar.getActualMaximum(5)) {
            gregorianCalendar.set(5, i);
            return;
        }
        gregorianCalendar.add(2, 1);
        gregorianCalendar.set(5, 1);
        gregorianCalendar.set(5, 1);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        gregorianCalendar.add(13, -1);
    }

    public void addUidPolicy(int i, int i2) {
        try {
            this.mService.addUidPolicy(i, i2);
        } catch (RemoteException e) {
        }
    }

    public NetworkPolicy[] getNetworkPolicies() {
        try {
            return this.mService.getNetworkPolicies();
        } catch (RemoteException e) {
            return null;
        }
    }

    public int[] getPowerSaveAppIdWhitelist() {
        try {
            return this.mService.getPowerSaveAppIdWhitelist();
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public boolean getRestrictBackground() {
        try {
            return this.mService.getRestrictBackground();
        } catch (RemoteException e) {
            return false;
        }
    }

    public int getUidPolicy(int i) {
        try {
            return this.mService.getUidPolicy(i);
        } catch (RemoteException e) {
            return 0;
        }
    }

    public int[] getUidsWithPolicy(int i) {
        try {
            return this.mService.getUidsWithPolicy(i);
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public void registerListener(INetworkPolicyListener iNetworkPolicyListener) {
        try {
            this.mService.registerListener(iNetworkPolicyListener);
        } catch (RemoteException e) {
        }
    }

    public void removeUidPolicy(int i, int i2) {
        try {
            this.mService.removeUidPolicy(i, i2);
        } catch (RemoteException e) {
        }
    }

    public void setNetworkPolicies(NetworkPolicy[] networkPolicyArr) {
        try {
            this.mService.setNetworkPolicies(networkPolicyArr);
        } catch (RemoteException e) {
        }
    }

    public void setRestrictBackground(boolean z) {
        try {
            this.mService.setRestrictBackground(z);
        } catch (RemoteException e) {
        }
    }

    public void setUidPolicy(int i, int i2) {
        try {
            this.mService.setUidPolicy(i, i2);
        } catch (RemoteException e) {
        }
    }

    public void unregisterListener(INetworkPolicyListener iNetworkPolicyListener) {
        try {
            this.mService.unregisterListener(iNetworkPolicyListener);
        } catch (RemoteException e) {
        }
    }
}
