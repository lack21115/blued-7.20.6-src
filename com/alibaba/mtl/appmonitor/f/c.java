package com.alibaba.mtl.appmonitor.f;

import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.a.d;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.h;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.model.LogField;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/f/c.class */
public class c {
    public static void a(h hVar) {
        if (hVar == null) {
            return;
        }
        com.alibaba.mtl.log.a.a(hVar.u, String.valueOf(hVar.e), hVar.v, hVar.w, hVar.x, hVar.k);
        com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) hVar);
    }

    public static void a(UTDimensionValueSet uTDimensionValueSet, d dVar) {
        Integer eventId = uTDimensionValueSet.getEventId();
        if (eventId != null) {
            f a2 = f.a(eventId.intValue());
            h hVar = (h) com.alibaba.mtl.appmonitor.c.a.a().a(h.class, new Object[0]);
            hVar.e = 6699;
            if (uTDimensionValueSet.getMap() != null) {
                hVar.k.putAll(uTDimensionValueSet.getMap());
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TTDownloadField.TT_META, SdkMeta.getSDKMetaData());
            hashMap.put("_event_id", eventId);
            com.alibaba.mtl.appmonitor.c.d dVar2 = (com.alibaba.mtl.appmonitor.c.d) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
            dVar2.put(dVar.a());
            com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) dVar);
            hashMap.put("data", dVar2);
            hVar.k.put(a2.m2140a(), new JSONObject(hashMap).toString());
            hVar.k.put(LogField.EVENTID.toString(), String.valueOf(6699));
            b(hVar);
            com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) dVar2);
        }
    }

    public static void b(h hVar) {
        i.a("UTUtil", "upload without flowback. args:", hVar.k);
        com.alibaba.mtl.appmonitor.e.a.a().a(hVar.k);
        com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) hVar);
    }

    public static void b(Map<UTDimensionValueSet, List<d>> map) {
        Integer eventId;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<UTDimensionValueSet, List<d>> entry : map.entrySet()) {
            UTDimensionValueSet key = entry.getKey();
            List<d> value = entry.getValue();
            if (value.size() != 0 && (eventId = key.getEventId()) != null) {
                f a2 = f.a(eventId.intValue());
                int i = 0;
                h hVar = (h) com.alibaba.mtl.appmonitor.c.a.a().a(h.class, new Object[0]);
                hVar.e = eventId.intValue();
                if (key.getMap() != null) {
                    hVar.k.putAll(key.getMap());
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TTDownloadField.TT_META, SdkMeta.getSDKMetaData());
                com.alibaba.mtl.appmonitor.c.d dVar = (com.alibaba.mtl.appmonitor.c.d) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
                for (d dVar2 : value) {
                    dVar.put(dVar2.a());
                    if (i == 0) {
                        sb.append(dVar2.o);
                        sb2.append(dVar2.p);
                    } else {
                        sb.append(",");
                        sb.append(dVar2.o);
                        sb2.append(",");
                        sb2.append(dVar2.p);
                    }
                    i++;
                    com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) dVar2);
                }
                hashMap.put("data", dVar);
                hVar.k.put(a2.m2140a(), new JSONObject(hashMap).toString());
                String sb3 = sb.toString();
                String sb4 = sb2.toString();
                hVar.k.put(LogField.ARG1.toString(), sb3);
                hVar.k.put(LogField.ARG2.toString(), sb4);
                hVar.v = sb3;
                hVar.w = sb4;
                b(hVar);
                com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) dVar);
            }
            com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) key);
        }
    }
}
