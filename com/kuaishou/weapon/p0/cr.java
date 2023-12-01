package com.kuaishou.weapon.p0;

import android.location.Location;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cr.class */
public class cr {

    /* renamed from: a  reason: collision with root package name */
    private cs f23796a = new cs();

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            cs csVar = new cs();
            int a2 = csVar.a(TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a2 > 0) {
                jSONObject.put("0", a2);
            }
            int a3 = csVar.a(TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a3 > 0) {
                jSONObject.put("1", a3);
            }
            int a4 = csVar.a(TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a4 > 0) {
                jSONObject.put("2", a4);
            }
            int a5 = csVar.a(Location.class, "getLatitude", new Object[0]);
            if (a5 > 0) {
                jSONObject.put("3", a5);
            }
            int a6 = csVar.a(Location.class, "getLongitude", new Object[0]);
            if (a6 > 0) {
                jSONObject.put("4", a6);
            }
            int a7 = csVar.a(WifiInfo.class, "getMacAddress", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("6", a7);
            }
            int a8 = csVar.a(WifiInfo.class, "getBSSID", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("7", a8);
            }
            int a9 = csVar.a(WifiInfo.class, "getRssi", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("8", a9);
            }
            int a10 = csVar.a(JSONObject.class, "toString", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("9", a10);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            int a2 = this.f23796a.a();
            if (a2 <= 0) {
                return null;
            }
            int a3 = this.f23796a.a(a2, TelephonyManager.class, "getDeviceId", new Object[0]);
            if (a3 > 0) {
                jSONObject.put("0", a3);
            }
            int a4 = this.f23796a.a(a2, TelephonyManager.class, "getSubscriberId", new Object[0]);
            if (a4 > 0) {
                jSONObject.put("1", a4);
            }
            int a5 = this.f23796a.a(a2, TelephonyManager.class, "getSimSerialNumber", new Object[0]);
            if (a5 > 0) {
                jSONObject.put("2", a5);
            }
            int a6 = this.f23796a.a(a2, Location.class, "getLatitude", new Object[0]);
            if (a6 > 0) {
                jSONObject.put("3", a6);
            }
            int a7 = this.f23796a.a(a2, Location.class, "getLongitude", new Object[0]);
            if (a7 > 0) {
                jSONObject.put("4", a7);
            }
            int a8 = this.f23796a.a(a2, WifiInfo.class, "getMacAddress", new Object[0]);
            if (a8 > 0) {
                jSONObject.put("6", a8);
            }
            int a9 = this.f23796a.a(a2, WifiInfo.class, "getBSSID", new Object[0]);
            if (a9 > 0) {
                jSONObject.put("7", a9);
            }
            int a10 = this.f23796a.a(a2, WifiInfo.class, "getRssi", new Object[0]);
            if (a10 > 0) {
                jSONObject.put("8", a10);
            }
            int a11 = this.f23796a.a(a2, JSONObject.class, "toString", new Object[0]);
            if (a11 > 0) {
                jSONObject.put("9", a11);
            }
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }
}
