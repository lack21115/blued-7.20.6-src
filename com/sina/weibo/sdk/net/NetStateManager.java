package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioSystem;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import org.apache.http.HttpHost;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/NetStateManager.class */
public class NetStateManager {
    public static NetState CUR_NETSTATE = NetState.Mobile;
    private static Context mContext;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/NetStateManager$NetState.class */
    public enum NetState {
        Mobile,
        WIFI,
        NOWAY;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetState[] valuesCustom() {
            NetState[] valuesCustom = values();
            int length = valuesCustom.length;
            NetState[] netStateArr = new NetState[length];
            System.arraycopy(valuesCustom, 0, netStateArr, 0, length);
            return netStateArr;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/NetStateManager$NetStateReceive.class */
    public class NetStateReceive extends BroadcastReceiver {
        public NetStateReceive() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetStateManager.mContext = context;
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (!wifiManager.isWifiEnabled() || -1 == connectionInfo.getNetworkId()) {
                    NetStateManager.CUR_NETSTATE = NetState.Mobile;
                }
            }
        }
    }

    public static HttpHost getAPN() {
        Uri parse = Uri.parse("content://telephony/carriers/preferapn");
        Context context = mContext;
        Cursor query = context != null ? context.getContentResolver().query(parse, null, null, null, null) : null;
        HttpHost httpHost = null;
        if (query != null) {
            httpHost = null;
            if (query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex(AudioSystem.DEVICE_OUT_PROXY_NAME));
                httpHost = null;
                if (string != null) {
                    httpHost = null;
                    if (string.trim().length() > 0) {
                        httpHost = new HttpHost(string, 80);
                    }
                }
                query.close();
            }
        }
        return httpHost;
    }
}
