package com.youzan.spiderman.html;

import com.google.gson.annotations.SerializedName;
import com.youzan.spiderman.utils.JsonUtil;
import com.youzan.spiderman.utils.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/HtmlHeader.class */
public class HtmlHeader {
    @SerializedName("header_map")

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<String>> f41819a = new HashMap();

    public static HtmlHeader fromJson(String str) {
        if (str != null) {
            return (HtmlHeader) JsonUtil.fromJson(str, (Class<Object>) HtmlHeader.class);
        }
        return null;
    }

    public static HtmlHeader fromMap(Map<String, String> map) {
        HtmlHeader htmlHeader = new HtmlHeader();
        HashMap hashMap = new HashMap();
        htmlHeader.f41819a = hashMap;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(entry.getValue());
                hashMap.put(entry.getKey(), arrayList);
            }
        }
        return htmlHeader;
    }

    public static HtmlHeader fromMapList(Map<String, List<String>> map) {
        HtmlHeader htmlHeader = new HtmlHeader();
        if (map != null) {
            htmlHeader.f41819a = map;
            return htmlHeader;
        }
        htmlHeader.f41819a = new HashMap();
        return htmlHeader;
    }

    public static String toJson(HtmlHeader htmlHeader) {
        if (htmlHeader != null) {
            return JsonUtil.toJson(htmlHeader);
        }
        return null;
    }

    public static Map<String, String> transferHeaderMapList(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value != null) {
                if (value.size() == 1) {
                    hashMap.put(entry.getKey(), value.get(0));
                } else {
                    hashMap.put(entry.getKey(), StringUtils.join(value));
                }
            }
        }
        return hashMap;
    }

    public Map<String, List<String>> getHeaders() {
        return this.f41819a;
    }

    public Map<String, String> getTransferdedHeader() {
        return transferHeaderMapList(this.f41819a);
    }
}
