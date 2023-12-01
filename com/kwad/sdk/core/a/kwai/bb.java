package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bb.class */
public final class bb implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ase = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                aVar.ase.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        aVar.asf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (optJSONArray2 != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= optJSONArray2.length()) {
                    break;
                }
                aVar.asf.add((String) optJSONArray2.opt(i4));
                i3 = i4 + 1;
            }
        }
        aVar.asg = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (optJSONArray3 != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= optJSONArray3.length()) {
                    break;
                }
                aVar.asg.add((String) optJSONArray3.opt(i6));
                i5 = i6 + 1;
            }
        }
        aVar.ash = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (optJSONArray4 != null) {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= optJSONArray4.length()) {
                    break;
                }
                aVar.ash.add((String) optJSONArray4.opt(i8));
                i7 = i8 + 1;
            }
        }
        aVar.asi = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (optJSONArray5 != null) {
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= optJSONArray5.length()) {
                    break;
                }
                com.kwad.sdk.crash.online.monitor.kwai.b bVar = new com.kwad.sdk.crash.online.monitor.kwai.b();
                bVar.parseJson(optJSONArray5.optJSONObject(i10));
                aVar.asi.add(bVar);
                i9 = i10 + 1;
            }
        }
        aVar.ask = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        aVar.asl = jSONObject.optInt("batchNum", new Integer("10").intValue());
        aVar.aii = jSONObject.optDouble("ratio", new Double("0.01").doubleValue());
        aVar.asm = jSONObject.optInt("monitorSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "systemFilterList", aVar.ase);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkFilterList", aVar.asf);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "matrixPrinterNameList", aVar.asg);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "commonPrinterNameList", aVar.ash);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "featureConfigList", aVar.asi);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "afterFilterSystemCheckNum", aVar.ask);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "batchNum", aVar.asl);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "ratio", aVar.aii);
        if (aVar.asm != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "monitorSwitch", aVar.asm);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
