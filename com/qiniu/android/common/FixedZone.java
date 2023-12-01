package com.qiniu.android.common;

import android.util.Log;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.common.Zone;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/common/FixedZone.class */
public final class FixedZone extends Zone {
    private static ZoneInfo preCustomZone;
    private ZoneInfo zoneInfo;
    public static String[] arrayzone0 = {"upload.qiniup.com", "upload-jjh.qiniup.com", "upload-xs.qiniup.com", "up.qiniup.com", "up-jjh.qiniup.com", "up-xs.qiniup.com", "upload.qbox.me", "up.qbox.me"};
    public static final Zone zone0 = new FixedZone(arrayzone0);
    public static String[] arrayzone1 = {"upload-z1.qiniup.com", "up-z1.qiniup.com", "upload-z1.qbox.me", "up-z1.qbox.me"};
    public static final Zone zone1 = new FixedZone(arrayzone1);
    public static String[] arrayzone2 = {"upload-z2.qiniup.com", "upload-dg.qiniup.com", "upload-fs.qiniup.com", "up-z2.qiniup.com", "up-dg.qiniup.com", "up-fs.qiniup.com", "upload-z2.qbox.me", "up-z2.qbox.me"};
    public static final Zone zone2 = new FixedZone(arrayzone2);
    public static String[] arrayzoneNa0 = {"upload-na0.qiniup.com", "up-na0.qiniup.com", "upload-na0.qbox.me", "up-na0.qbox.me"};
    public static final Zone zoneNa0 = new FixedZone(arrayzoneNa0);
    public static String[] arrayZoneAs0 = {"upload-as0.qiniup.com", "up-as0.qiniup.com", "upload-as0.qbox.me", "up-as0.qbox.me"};
    public static final Zone zoneAs0 = new FixedZone(arrayZoneAs0);

    public FixedZone(ZoneInfo zoneInfo) {
        this.zoneInfo = zoneInfo;
    }

    public FixedZone(String[] strArr) {
        ZoneInfo createZoneInfo = createZoneInfo(strArr);
        this.zoneInfo = createZoneInfo;
        preCustomZone = createZoneInfo;
    }

    public static ZoneInfo createZoneInfo(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new ZoneInfo(0, arrayList, concurrentHashMap);
            }
            String str = strArr[i2];
            arrayList.add(str);
            concurrentHashMap.put(str, 0L);
            i = i2 + 1;
        }
    }

    public static List<ZoneInfo> getZoneInfos() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createZoneInfo(arrayzone0));
        arrayList.add(createZoneInfo(arrayzone1));
        arrayList.add(createZoneInfo(arrayzone2));
        arrayList.add(createZoneInfo(arrayzoneNa0));
        arrayList.add(createZoneInfo(arrayZoneAs0));
        ZoneInfo zoneInfo = preCustomZone;
        if (zoneInfo != null) {
            arrayList.add(zoneInfo);
        }
        return arrayList;
    }

    @Override // com.qiniu.android.common.Zone
    public void frozenDomain(String str) {
        synchronized (this) {
            if (str != null) {
                this.zoneInfo.frozenDomain(URI.create(str).getHost());
            }
        }
    }

    @Override // com.qiniu.android.common.Zone
    public void preQuery(LogHandler logHandler, String str, Zone.QueryHandler queryHandler) {
        queryHandler.onSuccess();
    }

    @Override // com.qiniu.android.common.Zone
    public boolean preQuery(LogHandler logHandler, String str) {
        return true;
    }

    @Override // com.qiniu.android.common.Zone
    public String upHost(String str, boolean z, String str2) {
        String upHost;
        synchronized (this) {
            upHost = upHost(this.zoneInfo, z, str2);
            for (Map.Entry<String, Long> entry : this.zoneInfo.upDomainsMap.entrySet()) {
                Log.d("Qiniu.FixedZone", entry.getKey() + ", " + entry.getValue());
            }
        }
        return upHost;
    }
}
