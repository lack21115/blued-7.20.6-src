package com.tencent.mapsdk.beacon;

import android.content.Context;
import com.tencent.mapsdk.internal.c7;
import com.tencent.mapsdk.internal.g7;
import com.tencent.mapsdk.internal.li;
import com.tencent.mapsdk.internal.m1;
import com.tencent.mapsdk.internal.mi;
import com.tencent.mapsdk.shell.events.ReportEvent;
import com.tencent.tmsbeacon.event.open.BeaconConfig;
import com.tencent.tmsbeacon.event.open.BeaconEvent;
import com.tencent.tmsbeacon.event.open.BeaconReport;
import com.tencent.tmsbeacon.event.open.EventType;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/beacon/TMSBeaconReport.class */
public class TMSBeaconReport implements li {
    private static final HashMap<String, String> additionParams = new HashMap<>();
    private static final HashMap<String, String> lazyLoadAdditionParams = new HashMap<>();

    @Override // com.tencent.mapsdk.internal.mi.a
    public void close() {
        if (mi.h) {
            BeaconReport.getInstance().stopReport(true);
        }
    }

    @Override // com.tencent.mapsdk.internal.mi.a
    public void init(Context context, String str) {
        if (!mi.h) {
            m1.a(context);
            boolean z = mi.d;
            m1.a(z, z);
            m1.a(mi.k, mi.b(), mi.a(str));
            return;
        }
        BeaconConfig build = BeaconConfig.builder().setAndroidID(g7.h(context)).setModel(g7.c()).setNormalPollingTime(50000L).build();
        BeaconReport.getInstance().setCollectProcessInfo(false);
        BeaconReport.getInstance().setChannelID(mi.a(str));
        BeaconReport.getInstance().setAppVersion(mi.b());
        BeaconReport.getInstance().setUserID(g7.h(context));
        String[] split = str.split(",");
        HashMap<String, String> hashMap = additionParams;
        hashMap.put("cm_userid", split[1]);
        hashMap.put("cm_appid", context.getPackageName());
        hashMap.put("cm_appver", g7.b(context));
        hashMap.put("cm_duid", g7.e(context));
        hashMap.put("map_cm_key", split[0]);
        hashMap.put("map_cm_ver", c7.F());
        hashMap.put("cm_sessionid", g7.b());
        hashMap.putAll(lazyLoadAdditionParams);
        BeaconReport.getInstance().setAdditionalParams(hashMap);
        BeaconReport.getInstance().setLogAble(mi.d);
        BeaconReport.getInstance().start(context, mi.k, build);
    }

    public void onAdditionalParams(HashMap<String, String> hashMap) {
        lazyLoadAdditionParams.putAll(hashMap);
        if (mi.h) {
            HashMap<String, String> hashMap2 = additionParams;
            hashMap2.putAll(hashMap);
            BeaconReport.getInstance().setAdditionalParams(hashMap2);
        }
    }

    @Override // com.tencent.mapsdk.internal.li
    public void onPauseReport() {
        if (mi.h) {
            BeaconReport.getInstance().stopReport(false);
        }
    }

    @Override // com.tencent.mapsdk.internal.li
    public void onReport(ReportEvent reportEvent) {
        if (reportEvent == null) {
            return;
        }
        if (mi.h) {
            BeaconReport.getInstance().report(BeaconEvent.builder().withAppKey(reportEvent.appKey).withCode(reportEvent.code).withParams(reportEvent.params).withType(reportEvent.realtime ? EventType.REALTIME : EventType.NORMAL).withIsSucceed(reportEvent.isSucceed).build());
        } else {
            m1.a(reportEvent.appKey, reportEvent.code, reportEvent.params, reportEvent.realtime, reportEvent.isSucceed);
        }
    }

    @Override // com.tencent.mapsdk.internal.li
    public void onResumeReport() {
        if (mi.h) {
            BeaconReport.getInstance().resumeReport();
        }
    }
}
