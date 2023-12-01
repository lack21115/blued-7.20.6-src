package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bp.class */
public final class bp {
    private static boolean aBG = false;
    private static final List<a> aBH = new ArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/bp$a.class */
    public static final class a implements com.kwad.sdk.core.b {
        public String aBI;
        public String aBJ;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, BatteryManager.EXTRA_LEVEL, this.level);
            t.putValue(jSONObject, "ssid", this.aBI);
            t.putValue(jSONObject, "bssid", this.aBJ);
            return jSONObject;
        }
    }

    public static boolean dd(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1 : ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1;
    }

    public static List<a> m(Context context, int i) {
        WifiManager wifiManager;
        if (at.Ee()) {
            return new ArrayList();
        }
        if (aBG || !ServiceProvider.CB().canReadNearbyWifiList() || !aBH.isEmpty() || context == null) {
            return aBH;
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(32L)) {
            return aBH;
        }
        try {
        } catch (Exception e) {
            aBG = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
        if (!dd(context) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Iterator<ScanResult> it = scanResults.iterator();
                do {
                    if (it.hasNext()) {
                        ScanResult next = it.next();
                        a aVar = new a();
                        aVar.aBI = next.SSID;
                        aVar.aBJ = next.BSSID;
                        aVar.level = next.level;
                        if (connectionInfo.getBSSID() == null || next.BSSID == null || !TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), next.BSSID.replace("\"", "")) || connectionInfo.getSSID() == null || next.SSID == null || !TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), next.SSID.replace("\"", ""))) {
                            aBH.add(aVar);
                        } else {
                            aBH.add(0, aVar);
                        }
                    }
                } while (aBH.size() < i);
                return aBH;
            }
            return aBH;
        }
        return aBH;
    }
}
