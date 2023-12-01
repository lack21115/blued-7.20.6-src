package com.tencent.tmsbeacon.pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/pack/ModuleStrategy.class */
public final class ModuleStrategy extends AbstractJceStruct {
    public static Map<String, String> cache_detail;
    public static ArrayList<String> cache_preventEventCode;
    public static ArrayList<String> cache_sampleEvent;
    public static Object cache_sms;
    public Map<String, String> detail;
    public byte mId;
    public byte onOff;
    public ArrayList<String> preventEventCode;
    public ArrayList<String> sampleEvent;
    public Object sms;
    public String url;

    public ModuleStrategy() {
        this.mId = (byte) 0;
        this.onOff = (byte) 0;
        this.url = "";
        this.detail = null;
        this.preventEventCode = null;
        this.sms = null;
        this.sampleEvent = null;
    }

    public ModuleStrategy(byte b, byte b2, String str, Map<String, String> map, ArrayList<String> arrayList, Object obj, ArrayList<String> arrayList2) {
        this.mId = (byte) 0;
        this.onOff = (byte) 0;
        this.url = "";
        this.detail = null;
        this.preventEventCode = null;
        this.sms = null;
        this.sampleEvent = null;
        this.mId = b;
        this.onOff = b2;
        this.url = str;
        this.detail = map;
        this.preventEventCode = arrayList;
        this.sms = obj;
        this.sampleEvent = arrayList2;
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        this.mId = aVar.a(this.mId, 0, true);
        this.onOff = aVar.a(this.onOff, 1, true);
        this.url = aVar.a(2, true);
        if (cache_detail == null) {
            HashMap hashMap = new HashMap();
            cache_detail = hashMap;
            hashMap.put("", "");
        }
        this.detail = (Map) aVar.a((a) cache_detail, 3, true);
        if (cache_preventEventCode == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_preventEventCode = arrayList;
            arrayList.add("");
        }
        this.preventEventCode = (ArrayList) aVar.a((a) cache_preventEventCode, 4, false);
        Object obj = cache_sms;
        if (obj != null) {
            this.sms = aVar.a((a) obj, 5, false);
        }
        if (cache_sampleEvent == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            cache_sampleEvent = arrayList2;
            arrayList2.add("");
        }
        this.sampleEvent = (ArrayList) aVar.a((a) cache_sampleEvent, 6, false);
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a(this.mId, 0);
        bVar.a(this.onOff, 1);
        bVar.a(this.url, 2);
        bVar.a((Map) this.detail, 3);
        ArrayList<String> arrayList = this.preventEventCode;
        if (arrayList != null) {
            bVar.a((Collection) arrayList, 4);
        }
        Object obj = this.sms;
        if (obj != null) {
            bVar.a(obj, 5);
        }
        ArrayList<String> arrayList2 = this.sampleEvent;
        if (arrayList2 != null) {
            bVar.a((Collection) arrayList2, 6);
        }
    }
}
