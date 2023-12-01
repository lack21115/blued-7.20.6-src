package com.huawei.hms.ads.analysis;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/analysis/DynamicLoaderAnalysis.class */
public class DynamicLoaderAnalysis {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f22438a = new byte[0];
    private static DynamicLoaderAnalysis b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, IDynamicLoaderAnalysis> f22439c;

    private DynamicLoaderAnalysis() {
    }

    public static DynamicLoaderAnalysis getInstance() {
        DynamicLoaderAnalysis dynamicLoaderAnalysis;
        synchronized (f22438a) {
            if (b == null) {
                b = new DynamicLoaderAnalysis();
            }
            dynamicLoaderAnalysis = b;
        }
        return dynamicLoaderAnalysis;
    }

    public void onLoaderException(String str, int i, String str2) {
        HashMap<String, IDynamicLoaderAnalysis> hashMap = this.f22439c;
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, IDynamicLoaderAnalysis> entry : hashMap.entrySet()) {
            IDynamicLoaderAnalysis value = entry.getValue();
            if (value != null) {
                value.onLoaderException(entry.getKey(), str, i, str2);
            }
        }
    }

    public void onLoaderSuccess(String str, long j) {
        HashMap<String, IDynamicLoaderAnalysis> hashMap = this.f22439c;
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, IDynamicLoaderAnalysis> entry : hashMap.entrySet()) {
            IDynamicLoaderAnalysis value = entry.getValue();
            if (value != null) {
                value.onLoaderSuccess(entry.getKey(), str, j);
            }
        }
    }

    public void registerDynamicLoaderAnalysis(String str, IDynamicLoaderAnalysis iDynamicLoaderAnalysis) {
        if (TextUtils.isEmpty(str) || iDynamicLoaderAnalysis == null) {
            return;
        }
        if (this.f22439c == null) {
            this.f22439c = new HashMap<>();
        }
        if (this.f22439c.containsKey(str)) {
            return;
        }
        this.f22439c.put(str, iDynamicLoaderAnalysis);
    }
}
