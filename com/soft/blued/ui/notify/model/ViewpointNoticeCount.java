package com.soft.blued.ui.notify.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/model/ViewpointNoticeCount.class */
public class ViewpointNoticeCount {
    public int circle;
    public int followers;
    public int groups;
    public boolean isHttp = false;
    public int liked;

    public int getSum() {
        return this.followers + this.liked + this.groups + this.circle;
    }
}
