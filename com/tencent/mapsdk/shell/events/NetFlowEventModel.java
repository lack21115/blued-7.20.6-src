package com.tencent.mapsdk.shell.events;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/shell/events/NetFlowEventModel.class */
public class NetFlowEventModel {
    public String bizType;
    public double downloadFlow;
    public long downloadTime;
    public int errorCode;
    public final String eventCode = "cm_nf";
    public double uploadFlow;
    public long uploadTime;
    public String url;

    public NetFlowEventModel() {
    }

    public NetFlowEventModel(double d, double d2, long j, long j2, int i, String str, String str2) {
        this.uploadFlow = d;
        this.downloadFlow = d2;
        this.uploadTime = j;
        this.downloadTime = j2;
        this.errorCode = i;
        this.url = str;
        this.bizType = str2;
    }
}
