package com.tencent.thumbplayer.api.report;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/report/TPLiveReportInfo.class */
public class TPLiveReportInfo extends TPDefaultReportInfo {
    public int adPlayLength;
    public String cdnServer;
    public int contentId;
    public boolean isLookBack;
    public boolean isUserPay;
    public int liveDelay;
    public int liveType;
    public int playTime;
    public int programId;
    public int streamId;

    @Override // com.tencent.thumbplayer.api.report.TPDefaultReportInfo
    public int getPlayType() {
        return 1;
    }
}
