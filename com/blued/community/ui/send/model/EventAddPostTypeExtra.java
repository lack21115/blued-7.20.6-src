package com.blued.community.ui.send.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/EventAddPostTypeExtra.class */
public final class EventAddPostTypeExtra extends BluedEntityBaseExtra {
    private Integer offline_limit_day;
    private Integer offline_limit_num;
    private Integer online_limit_day;
    private Integer online_limit_num;

    public final Integer getOffline_limit_day() {
        return this.offline_limit_day;
    }

    public final Integer getOffline_limit_num() {
        return this.offline_limit_num;
    }

    public final Integer getOnline_limit_day() {
        return this.online_limit_day;
    }

    public final Integer getOnline_limit_num() {
        return this.online_limit_num;
    }

    public final void setOffline_limit_day(Integer num) {
        this.offline_limit_day = num;
    }

    public final void setOffline_limit_num(Integer num) {
        this.offline_limit_num = num;
    }

    public final void setOnline_limit_day(Integer num) {
        this.online_limit_day = num;
    }

    public final void setOnline_limit_num(Integer num) {
        this.online_limit_num = num;
    }
}
