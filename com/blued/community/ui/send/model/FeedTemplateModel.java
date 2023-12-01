package com.blued.community.ui.send.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/FeedTemplateModel.class */
public final class FeedTemplateModel implements MultiItemEntity {
    private String background_img;
    private boolean isSelected;
    private boolean isShowed;
    private String p_id;

    public final String getBackground_img() {
        return this.background_img;
    }

    public int getItemType() {
        return 0;
    }

    public final String getP_id() {
        return this.p_id;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isShowed() {
        return this.isShowed;
    }

    public final void setBackground_img(String str) {
        this.background_img = str;
    }

    public final void setP_id(String str) {
        this.p_id = str;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setShowed(boolean z) {
        this.isShowed = z;
    }
}
