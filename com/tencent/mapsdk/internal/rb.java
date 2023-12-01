package com.tencent.mapsdk.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import com.tencent.mapsdk.shell.events.NetFlowEventModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/rb.class */
public class rb implements RequestProcessor, ResponseProcessor {
    private static final String d = "NetFlow";
    private static final boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, String> f24049a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    public NetFlowEventModel f24050c;

    public rb() {
        this.f24049a = new HashMap<>();
        this.b = false;
    }

    public rb(HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.f24049a = hashMap2;
        this.b = false;
        hashMap2.putAll(hashMap);
    }

    public boolean a(String str) {
        Uri parse;
        String scheme;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (scheme = parse.getScheme()) == null || !scheme.startsWith("http")) {
            return false;
        }
        String str2 = parse.getHost() + parse.getPath();
        if (!this.f24049a.containsKey(str2)) {
            Iterator<String> it = this.f24049a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (str2.contains(next)) {
                    this.f24050c.bizType = this.f24049a.get(next);
                    this.b = true;
                    break;
                }
            }
        } else {
            this.f24050c.bizType = this.f24049a.get(str2);
            this.b = true;
        }
        return this.b;
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) throws Exception {
        String str;
        byte[] bArr;
        double d2;
        NetFlowEventModel netFlowEventModel = new NetFlowEventModel();
        this.f24050c = netFlowEventModel;
        netFlowEventModel.url = netRequest.url;
        netFlowEventModel.uploadFlow = str.getBytes().length;
        if (netRequest.postData != null) {
            this.f24050c.uploadFlow += bArr.length;
        }
        for (Map.Entry<String, String> entry : netRequest.mapHeaders.entrySet()) {
            this.f24050c.uploadFlow += entry.getKey().getBytes().length + entry.getValue().getBytes().length;
        }
        NetFlowEventModel netFlowEventModel2 = this.f24050c;
        netFlowEventModel2.uploadFlow = netFlowEventModel2.uploadFlow / 1000.0d;
        netFlowEventModel2.uploadFlow = Math.round(d2 * 1000.0d) / 1000.0d;
        this.f24050c.uploadTime = System.currentTimeMillis();
        if (a(netRequest.url)) {
            return;
        }
        this.f24050c.bizType = "";
    }

    public void onResponse(NetResponse netResponse) throws Exception {
        if (netResponse.available()) {
            NetFlowEventModel netFlowEventModel = this.f24050c;
            netFlowEventModel.errorCode = netResponse.statusCode;
            if (netResponse.errorCode != 0) {
                byte[] bArr = netResponse.errorData;
                if (bArr != null) {
                    netFlowEventModel.downloadFlow = bArr.length;
                } else {
                    netFlowEventModel.downloadFlow = -1.0d;
                }
            } else {
                byte[] bArr2 = netResponse.data;
                if (bArr2 != null) {
                    netFlowEventModel.downloadFlow = bArr2.length;
                } else {
                    netFlowEventModel.downloadFlow = -1.0d;
                }
            }
            double d2 = netFlowEventModel.downloadFlow / 1000.0d;
            netFlowEventModel.downloadFlow = d2;
            netFlowEventModel.downloadFlow = Math.round(d2 * 1000.0d) / 1000.0d;
        } else {
            this.f24050c.errorCode = -100;
        }
        this.f24050c.downloadTime = System.currentTimeMillis();
    }
}
