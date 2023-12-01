package com.soft.blued.ui.setting.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/MsgBackInfo.class */
public final class MsgBackInfo {
    private final long date = System.currentTimeMillis();
    private final String platform = "android";

    public final long getDate() {
        return this.date;
    }

    public final String getPlatform() {
        return this.platform;
    }
}
