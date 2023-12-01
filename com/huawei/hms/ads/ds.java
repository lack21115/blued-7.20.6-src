package com.huawei.hms.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ds.class */
public class ds {
    private static final String Code = "ActivityStarter";
    private static final String I = "com.huawei.hms.pps.action.PPS_AR";
    private static final String V = "com.huawei.hms.pps.action.PPS_DETAIL";
    private static final int Z = 1;

    private static void Code(Context context, AdContentData adContentData, Intent intent) {
        intent.putExtra("content_id", adContentData.S());
        intent.putExtra("sdk_version", "13.4.61.304");
        intent.putExtra(com.huawei.openalliance.ad.constant.at.e, adContentData.B());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.g, adContentData.E());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.y, context.getPackageName());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.N, adContentData.ao());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.O, adContentData.ap());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.C, adContentData.az());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.ac, adContentData.C());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.S, adContentData.aA());
    }

    private static void Code(Context context, AdContentData adContentData, fw fwVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(adContentData, jSONObject);
            jSONObject.put(com.huawei.openalliance.ad.constant.at.d, adContentData.t());
            jSONObject.put(com.huawei.openalliance.ad.constant.at.k, adContentData.v());
            jSONObject.put("unique_id", adContentData.T());
            Code(jSONObject, fwVar);
            com.huawei.openalliance.ad.ipc.h.Code(context, adContentData.ak()).Code(com.huawei.openalliance.ad.constant.p.f9344a, jSONObject.toString(), null, null);
        } catch (JSONException e) {
            ge.I(Code, "startAdActivityViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, AdContentData adContentData, fw fwVar, boolean z) {
        try {
            if (!(context instanceof Activity) || adContentData.ak()) {
                Code(context, adContentData, fwVar);
                return;
            }
            ge.V(Code, "activity context");
            Intent intent = new Intent();
            intent.setAction(V);
            intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(context));
            Code(context, adContentData, intent);
            intent.putExtra(com.huawei.openalliance.ad.constant.at.d, adContentData.t());
            intent.putExtra(com.huawei.openalliance.ad.constant.at.k, adContentData.v());
            intent.putExtra("unique_id", adContentData.T());
            Code(intent, fwVar);
            if (z) {
                intent.addFlags(268959744);
            }
            intent.setClipData(com.huawei.openalliance.ad.constant.t.cF);
            ((Activity) context).startActivityForResult(intent, 1);
        } catch (Throwable th) {
            ge.Code(3, th);
            ge.V(Code, "startAdActivity error, %s", th.getClass().getSimpleName());
        }
    }

    private static void Code(Intent intent, fw fwVar) {
        ge.Code(Code, "parseLinkedAdConfig");
        if (intent == null || fwVar == null) {
            return;
        }
        intent.putExtra(com.huawei.openalliance.ad.constant.at.n, fwVar.B());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.m, fwVar.C());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.o, fwVar.Code());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.q, fwVar.I());
        intent.putExtra(com.huawei.openalliance.ad.constant.at.p, fwVar.V());
    }

    private static void Code(Intent intent, JSONObject jSONObject, Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return;
        }
        String V2 = com.huawei.openalliance.ad.utils.z.V(map);
        if (com.huawei.openalliance.ad.utils.au.Code(V2)) {
            return;
        }
        if (z) {
            intent.putExtra(com.huawei.openalliance.ad.constant.at.P, V2);
            return;
        }
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.at.P, V2);
        } catch (JSONException e) {
            ge.Z(Code, "set ar linked params error," + e.getClass().getSimpleName());
        }
    }

    private static void Code(AdContentData adContentData, JSONObject jSONObject) {
        jSONObject.put("content_id", adContentData.S());
        jSONObject.put("sdk_version", "13.4.61.304");
        jSONObject.put(com.huawei.openalliance.ad.constant.at.e, adContentData.B());
        jSONObject.put(com.huawei.openalliance.ad.constant.at.g, adContentData.E());
        jSONObject.put(com.huawei.openalliance.ad.constant.at.N, adContentData.ao());
        jSONObject.put(com.huawei.openalliance.ad.constant.at.O, adContentData.ap());
        jSONObject.put(com.huawei.openalliance.ad.constant.at.C, adContentData.az());
        jSONObject.put(com.huawei.openalliance.ad.constant.at.ac, adContentData.C());
        jSONObject.put(com.huawei.openalliance.ad.constant.at.S, adContentData.aA());
    }

    public static void Code(JSONObject jSONObject, fw fwVar) {
        if (jSONObject == null || fwVar == null) {
            return;
        }
        ge.Code(Code, "parseLinkedAdConfigViaAid");
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.at.n, fwVar.B());
            jSONObject.put(com.huawei.openalliance.ad.constant.at.m, fwVar.C());
            jSONObject.put(com.huawei.openalliance.ad.constant.at.o, fwVar.Code());
            jSONObject.put(com.huawei.openalliance.ad.constant.at.q, fwVar.I());
            jSONObject.put(com.huawei.openalliance.ad.constant.at.p, fwVar.V());
        } catch (JSONException e) {
            ge.I(Code, "startAdActivityViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    public static boolean Code(Context context, AdContentData adContentData, Map<String, String> map) {
        String str;
        try {
            if (!(context instanceof Activity) || adContentData.ak()) {
                return V(context, adContentData, map);
            }
            try {
                Intent intent = new Intent();
                intent.setAction(I);
                intent.setPackage(com.huawei.openalliance.ad.utils.v.Z(context));
                Code(context, adContentData, intent);
                Code(intent, (JSONObject) null, map, true);
                intent.setClipData(com.huawei.openalliance.ad.constant.t.cF);
                ((Activity) context).startActivityForResult(intent, 1);
                return true;
            } catch (ActivityNotFoundException e) {
                str = "ActivityNotFoundException e:" + e.getClass().getSimpleName();
                ge.I(Code, str);
                return false;
            } catch (Exception e2) {
                str = "Exception e:" + e2.getClass().getSimpleName();
                ge.I(Code, str);
                return false;
            }
        } catch (Throwable th) {
            ge.Code(3, th);
            ge.V(Code, "startArActivity error, %s", th.getClass().getSimpleName());
            return false;
        }
    }

    private static boolean V(Context context, AdContentData adContentData, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            Code(adContentData, jSONObject);
            Code((Intent) null, jSONObject, map, false);
            com.huawei.openalliance.ad.ipc.h.Code(context, adContentData.ak()).Code(com.huawei.openalliance.ad.constant.p.o, jSONObject.toString(), null, null);
            return true;
        } catch (JSONException e) {
            ge.I(Code, "startArActivityViaAidl, e:" + e.getClass().getSimpleName());
            return false;
        }
    }
}
