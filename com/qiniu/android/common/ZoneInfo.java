package com.qiniu.android.common;

import android.content.Context;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/common/ZoneInfo.class */
public class ZoneInfo {
    private static int DOMAIN_FROZEN_SECONDS = 600;
    private final int ttl;
    public final List<String> upDomainsList;
    public final Map<String, Long> upDomainsMap;

    public ZoneInfo(int i, List<String> list, Map<String, Long> map) {
        this.ttl = i;
        this.upDomainsList = list;
        this.upDomainsMap = map;
    }

    public static ZoneInfo buildFromJson(JSONObject jSONObject) throws JSONException {
        int i = jSONObject.getInt(RemoteMessageConst.TTL);
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        JSONObject jSONObject2 = jSONObject.getJSONObject("up");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                return new ZoneInfo(i, arrayList, concurrentHashMap);
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject(new String[]{"acc", OapsKey.KEY_SRC, "old_acc", "old_src"}[i3]);
            JSONArray jSONArray = jSONObject3.getJSONArray("main");
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < jSONArray.length()) {
                    String string = jSONArray.getString(i5);
                    arrayList.add(string);
                    concurrentHashMap.put(string, 0L);
                    i4 = i5 + 1;
                } else {
                    try {
                        break;
                    } catch (JSONException e) {
                    }
                }
            }
            JSONArray jSONArray2 = jSONObject3.getJSONArray(Context.BACKUP_SERVICE);
            if (jSONArray2 != null) {
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < jSONArray2.length()) {
                        String string2 = jSONArray2.getString(i7);
                        arrayList.add(string2);
                        concurrentHashMap.put(string2, 0L);
                        i6 = i7 + 1;
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    public void frozenDomain(String str) {
        this.upDomainsMap.put(str, Long.valueOf((System.currentTimeMillis() / 1000) + DOMAIN_FROZEN_SECONDS));
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(RemoteMessageConst.TTL, Integer.valueOf(this.ttl));
        hashMap.put("upDomainList", this.upDomainsList);
        hashMap.put("upDomainMap", this.upDomainsMap);
        return new JSONObject(hashMap).toString();
    }
}
