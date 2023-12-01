package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Bundle;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetConfig;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpProxyRule;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/eb.class */
public abstract class eb implements NetAdapter {
    private static final String h = "NetImpl";

    /* renamed from: a  reason: collision with root package name */
    public Bundle f23717a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23718c;
    private List<HttpProxyRule> d;
    private String g;
    private boolean b = true;
    private HashMap<String, String> e = new HashMap<>();
    private HashSet<Class<? extends rb>> f = new HashSet<>();

    public static String a(String str) {
        if (str == null) {
            return "GBK";
        }
        String[] split = str.split(com.huawei.openalliance.ad.constant.t.aE);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "GBK";
            }
            String str2 = split[i2];
            if (str2.contains("charset")) {
                String[] split2 = str2.split("=");
                return split2.length <= 1 ? "GBK" : split2[1].trim();
            }
            i = i2 + 1;
        }
    }

    public abstract NetResponse a(NetRequest netRequest);

    public abstract void a(Context context, Bundle bundle);

    public void a(Class<? extends rb> cls) {
        this.f.add(cls);
    }

    public void a(HashMap<String, String> hashMap) {
        this.e.putAll(hashMap);
    }

    public void a(List<HttpProxyRule> list) {
        this.d = list;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public abstract NetResponse b(NetRequest netRequest);

    public void b(String str) {
        this.g = str;
    }

    public void b(boolean z) {
        this.f23718c = z;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doGet(NetRequest netRequest) {
        return a(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public NetResponse doPost(NetRequest netRequest) {
        return b(netRequest);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashSet<Class<? extends rb>> getNetFlowProcessor() {
        return this.f;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public HashMap<String, String> getNetFlowRuleList() {
        return this.e;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public List<HttpProxyRule> getProxyRuleList() {
        return this.d;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public String getSecretKey() {
        return this.g;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public void initNet(Context context, NetConfig netConfig) {
        try {
            a(netConfig.isForceHttps());
            b(netConfig.isLogEnable());
            a(netConfig.getProxyRuleList());
            a(netConfig.getNetFlowRuleList());
            b(netConfig.getSecretKey());
            a(netConfig.getProcessor());
            Bundle arguments = netConfig.getArguments();
            this.f23717a = arguments;
            a(context, arguments);
        } catch (Exception e) {
            na.b(h, "initNet error:" + e.toString());
        }
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean isForceHttps() {
        return this.b;
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean isLogEnable() {
        return this.f23718c;
    }
}
