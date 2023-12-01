package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.shell.events.EngineWriteDataModel;
import com.tencent.mapsdk.shell.events.ReportEvent;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ni.class */
public class ni extends ReportEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ni(EngineWriteDataModel engineWriteDataModel) {
        super("map_engine_writeData", null);
        engineWriteDataModel.getClass();
        HashMap hashMap = new HashMap();
        this.params = hashMap;
        hashMap.put("err", engineWriteDataModel.resultCode + "");
        Map<String, String> map = this.params;
        map.put("writeCount", engineWriteDataModel.totalWriteCount + "");
        Map<String, String> map2 = this.params;
        map2.put("size", engineWriteDataModel.dataSize + "");
        Map<String, String> map3 = this.params;
        map3.put("ptr", engineWriteDataModel.ptr + "");
        Map<String, String> map4 = this.params;
        map4.put("url", engineWriteDataModel.url + "");
    }
}
