package com.tencent.mapsdk.shell.events;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/shell/events/NetFlowEvent.class */
public class NetFlowEvent extends ReportEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetFlowEvent(NetFlowEventModel netFlowEventModel) {
        super("cm_nf", null);
        netFlowEventModel.getClass();
        HashMap hashMap = new HashMap();
        this.params = hashMap;
        hashMap.put("up", netFlowEventModel.uploadFlow + "");
        Map<String, String> map = this.params;
        map.put("dw", netFlowEventModel.downloadFlow + "");
        Map<String, String> map2 = this.params;
        map2.put("up_time", netFlowEventModel.uploadTime + "");
        Map<String, String> map3 = this.params;
        map3.put("dw_time", netFlowEventModel.downloadTime + "");
        Map<String, String> map4 = this.params;
        map4.put("rt", (netFlowEventModel.downloadTime - netFlowEventModel.uploadTime) + "");
        this.params.put("biz_type", netFlowEventModel.bizType);
        this.params.put("url", netFlowEventModel.url);
        Map<String, String> map5 = this.params;
        map5.put("err", netFlowEventModel.errorCode + "");
    }
}
