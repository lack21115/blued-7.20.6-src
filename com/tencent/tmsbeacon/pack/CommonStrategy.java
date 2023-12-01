package com.tencent.tmsbeacon.pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/pack/CommonStrategy.class */
public final class CommonStrategy extends AbstractJceStruct {
    public static Map<String, String> cache_cloudParas;
    public static ArrayList<ModuleStrategy> cache_moduleList;
    public Map<String, String> cloudParas;
    public ArrayList<ModuleStrategy> moduleList;
    public int queryInterval;
    public String url;

    public CommonStrategy() {
        this.moduleList = null;
        this.queryInterval = 0;
        this.url = "";
        this.cloudParas = null;
    }

    public CommonStrategy(ArrayList<ModuleStrategy> arrayList, int i, String str, Map<String, String> map) {
        this.moduleList = null;
        this.queryInterval = 0;
        this.url = "";
        this.cloudParas = null;
        this.moduleList = arrayList;
        this.queryInterval = i;
        this.url = str;
        this.cloudParas = map;
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void readFrom(a aVar) {
        if (cache_moduleList == null) {
            cache_moduleList = new ArrayList<>();
            cache_moduleList.add(new ModuleStrategy());
        }
        this.moduleList = (ArrayList) aVar.a((a) cache_moduleList, 0, true);
        this.queryInterval = aVar.a(this.queryInterval, 1, true);
        this.url = aVar.a(2, true);
        if (cache_cloudParas == null) {
            HashMap hashMap = new HashMap();
            cache_cloudParas = hashMap;
            hashMap.put("", "");
        }
        this.cloudParas = (Map) aVar.a((a) cache_cloudParas, 3, false);
    }

    @Override // com.tencent.tmsbeacon.pack.AbstractJceStruct
    public void writeTo(b bVar) {
        bVar.a((Collection) this.moduleList, 0);
        bVar.a(this.queryInterval, 1);
        bVar.a(this.url, 2);
        Map<String, String> map = this.cloudParas;
        if (map != null) {
            bVar.a((Map) map, 3);
        }
    }
}
