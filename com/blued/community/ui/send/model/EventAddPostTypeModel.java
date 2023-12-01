package com.blued.community.ui.send.model;

import android.text.TextUtils;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/EventAddPostTypeModel.class */
public final class EventAddPostTypeModel {
    private boolean isMore;
    private int mode_id;
    private String type_id;
    private String type_name;

    public EventAddPostTypeModel() {
    }

    public EventAddPostTypeModel(boolean z) {
        this.isMore = z;
    }

    public final int getMode_id() {
        return this.mode_id;
    }

    public final String getType_id() {
        return this.type_id;
    }

    public final String getType_name() {
        return this.type_name;
    }

    public final boolean isMore() {
        return this.isMore;
    }

    public final boolean isSelect(String str) {
        return TextUtils.equals(this.type_id, str);
    }

    public final void setMode_id(int i) {
        this.mode_id = i;
    }

    public final void setMore(boolean z) {
        this.isMore = z;
    }

    public final void setType_id(String str) {
        this.type_id = str;
    }

    public final void setType_name(String str) {
        this.type_name = str;
    }
}
