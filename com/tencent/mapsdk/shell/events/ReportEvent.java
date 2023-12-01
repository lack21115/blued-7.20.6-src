package com.tencent.mapsdk.shell.events;

import com.tencent.mapsdk.internal.mi;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/shell/events/ReportEvent.class */
public class ReportEvent {
    public String code;
    public boolean isSucceed;
    public Map<String, String> params;
    public String appKey = mi.k;
    public boolean realtime = false;

    public ReportEvent(String str, Map<String, String> map) {
        this.code = str;
        this.params = map;
    }
}
