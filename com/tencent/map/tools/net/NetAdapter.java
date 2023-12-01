package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.mapsdk.internal.rb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/tools/net/NetAdapter.class */
public interface NetAdapter {
    boolean cancel();

    NetResponse doGet(NetRequest netRequest);

    NetResponse doPost(NetRequest netRequest);

    NetResponse doRequest(NetRequest netRequest);

    HashSet<Class<? extends rb>> getNetFlowProcessor();

    HashMap<String, String> getNetFlowRuleList();

    List<HttpProxyRule> getProxyRuleList();

    String getSecretKey();

    void initNet(Context context, NetConfig netConfig);

    boolean isForceHttps();

    boolean isLogEnable();

    NetResponse openStream(NetRequest netRequest);
}
