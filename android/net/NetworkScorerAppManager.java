package android.net;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkScorerAppManager.class */
public final class NetworkScorerAppManager {
    private static final Intent SCORE_INTENT = new Intent(NetworkScoreManager.ACTION_SCORE_NETWORKS);
    private static final String TAG = "NetworkScorerAppManager";

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkScorerAppManager$NetworkScorerAppData.class */
    public static class NetworkScorerAppData {
        public final String mConfigurationActivityClassName;
        public final String mPackageName;
        public final CharSequence mScorerName;

        public NetworkScorerAppData(String str, CharSequence charSequence, String str2) {
            this.mScorerName = charSequence;
            this.mPackageName = str;
            this.mConfigurationActivityClassName = str2;
        }
    }

    private NetworkScorerAppManager() {
    }

    public static NetworkScorerAppData getActiveScorer(Context context) {
        return getScorer(context, Settings.Global.getString(context.getContentResolver(), Settings.Global.NETWORK_SCORER_APP));
    }

    public static Collection<NetworkScorerAppData> getAllValidScorers(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(SCORE_INTENT, 0, 0)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && Manifest.permission.BROADCAST_NETWORK_PRIVILEGED.equals(activityInfo.permission) && packageManager.checkPermission(Manifest.permission.SCORE_NETWORKS, activityInfo.packageName) == 0) {
                Intent intent = new Intent(NetworkScoreManager.ACTION_CUSTOM_ENABLE);
                intent.setPackage(activityInfo.packageName);
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                String str = null;
                if (!queryIntentActivities.isEmpty()) {
                    ActivityInfo activityInfo2 = queryIntentActivities.get(0).activityInfo;
                    str = null;
                    if (activityInfo2 != null) {
                        str = activityInfo2.name;
                    }
                }
                arrayList.add(new NetworkScorerAppData(activityInfo.packageName, activityInfo.loadLabel(packageManager), str));
            }
        }
        return arrayList;
    }

    public static NetworkScorerAppData getScorer(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (NetworkScorerAppData networkScorerAppData : getAllValidScorers(context)) {
            if (str.equals(networkScorerAppData.mPackageName)) {
                return networkScorerAppData;
            }
        }
        return null;
    }

    public static boolean isCallerActiveScorer(Context context, int i) {
        NetworkScorerAppData activeScorer = getActiveScorer(context);
        if (activeScorer == null) {
            return false;
        }
        try {
            ((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE)).checkPackage(i, activeScorer.mPackageName);
            return context.checkCallingPermission(Manifest.permission.SCORE_NETWORKS) == 0;
        } catch (SecurityException e) {
            return false;
        }
    }

    public static boolean setActiveScorer(Context context, String str) {
        String string = Settings.Global.getString(context.getContentResolver(), Settings.Global.NETWORK_SCORER_APP);
        if (TextUtils.equals(string, str)) {
            return true;
        }
        Log.i(TAG, "Changing network scorer from " + string + " to " + str);
        if (str == null) {
            Settings.Global.putString(context.getContentResolver(), Settings.Global.NETWORK_SCORER_APP, null);
            return true;
        } else if (getScorer(context, str) != null) {
            Settings.Global.putString(context.getContentResolver(), Settings.Global.NETWORK_SCORER_APP, str);
            return true;
        } else {
            Log.w(TAG, "Requested network scorer is not valid: " + str);
            return false;
        }
    }
}
