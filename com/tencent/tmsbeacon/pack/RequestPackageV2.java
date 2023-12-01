package com.tencent.tmsbeacon.pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/pack/RequestPackageV2.class */
public final class RequestPackageV2 extends AbstractJceStruct implements Cloneable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Map<String, String> cache_common;
    public static ArrayList<EventRecordV2> cache_events = new ArrayList<>();
    public int platformId = 0;
    public String mainAppKey = "";
    public String appVersion = "";
    public String sdkVersion = "";
    public ArrayList<EventRecordV2> events = null;
    public String packageName = "";
    public Map<String, String> common = null;
    public String model = "";
    public String osVersion = "";
    public String reserved = "";
    public String sdkId = "";

    static {
        cache_events.add(new EventRecordV2());
        HashMap hashMap = new HashMap();
        cache_common = hashMap;
        hashMap.put("", "");
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.platformId = aVar.a(this.platformId, 0, true);
        this.mainAppKey = aVar.a(1, true);
        this.appVersion = aVar.a(2, true);
        this.sdkVersion = aVar.a(3, true);
        this.events = (ArrayList) aVar.a((a) cache_events, 4, true);
        this.packageName = aVar.a(5, false);
        this.common = (Map) aVar.a((a) cache_common, 6, false);
        this.model = aVar.a(7, false);
        this.osVersion = aVar.a(8, false);
        this.reserved = aVar.a(9, false);
        this.sdkId = aVar.a(10, false);
    }

    public String toString() {
        return "RequestPackageV2{platformId=" + this.platformId + ", mainAppKey='" + this.mainAppKey + "', appVersion='" + this.appVersion + "', sdkVersion='" + this.sdkVersion + "', packageName='" + this.packageName + "', model='" + this.model + "', osVersion='" + this.osVersion + "', reserved='" + this.reserved + "', sdkId='" + this.sdkId + "'} " + super.toString();
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a(this.platformId, 0);
        bVar.a(this.mainAppKey, 1);
        bVar.a(this.appVersion, 2);
        bVar.a(this.sdkVersion, 3);
        bVar.a((Collection) this.events, 4);
        String str = this.packageName;
        if (str != null) {
            bVar.a(str, 5);
        }
        Map<String, String> map = this.common;
        if (map != null) {
            bVar.a((Map) map, 6);
        }
        String str2 = this.model;
        if (str2 != null) {
            bVar.a(str2, 7);
        }
        String str3 = this.osVersion;
        if (str3 != null) {
            bVar.a(str3, 8);
        }
        String str4 = this.reserved;
        if (str4 != null) {
            bVar.a(str4, 9);
        }
        String str5 = this.sdkId;
        if (str5 != null) {
            bVar.a(str5, 10);
        }
    }
}
