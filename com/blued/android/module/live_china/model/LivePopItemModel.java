package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePopItemModel.class */
public final class LivePopItemModel implements Serializable {
    private int link_type;
    private int order;
    private int type;
    private String text = "";
    private String time = "";
    private String link = "";
    private int show_count_local = 1;
    private int pop_duration_local = 5000;

    public final String getLink() {
        return this.link;
    }

    public final int getLink_type() {
        return this.link_type;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getPop_duration_local() {
        return this.pop_duration_local;
    }

    public final int getShow_count_local() {
        return this.show_count_local;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTime() {
        return this.time;
    }

    public final int getType() {
        return this.type;
    }

    public final void setLink(String str) {
        this.link = str;
    }

    public final void setLink_type(int i) {
        this.link_type = i;
    }

    public final void setOrder(int i) {
        this.order = i;
    }

    public final void setPop_duration_local(int i) {
        this.pop_duration_local = i;
    }

    public final void setShow_count_local(int i) {
        this.show_count_local = i;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
