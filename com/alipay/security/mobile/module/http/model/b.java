package com.alipay.security.mobile.module.http.model;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/http/model/b.class */
public class b {
    public static c a(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f4718a = dataReportResult.success;
        cVar.b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.h = map.get("apdid");
            cVar.i = map.get("apdidToken");
            cVar.l = map.get("dynamicKey");
            cVar.m = map.get("timeInterval");
            cVar.n = map.get("webrtcUrl");
            cVar.o = "";
            String str = map.get("drmSwitch");
            if (com.alipay.security.mobile.module.a.a.b(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    cVar.j = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    cVar.k = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.p = map.get("apse_degrade");
            }
        }
        return cVar;
    }

    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.f4720a;
        dataReportRequest.rpcVersion = dVar.j;
        dataReportRequest.bizType = "1";
        dataReportRequest.bizData = new HashMap();
        dataReportRequest.bizData.put("apdid", dVar.b);
        dataReportRequest.bizData.put("apdidToken", dVar.f4721c);
        dataReportRequest.bizData.put("umidToken", dVar.d);
        dataReportRequest.bizData.put("dynamicKey", dVar.e);
        dataReportRequest.deviceData = dVar.f;
        return dataReportRequest;
    }
}
