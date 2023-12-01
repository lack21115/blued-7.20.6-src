package com.blued.community.ui.send.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/FeedPostSignStateItem.class */
public final class FeedPostSignStateItem implements MultiItemEntity, Serializable {
    private int check;
    private String classify_style;
    private String feed_id;
    private int is_bubble_tt_click;
    private int is_classify;
    private String leading_words;
    private int sort;
    private String state_types;
    private String bubble_state_id = "";
    private String icon = "";
    private String name = "";

    public final String getBubble_state_id() {
        return this.bubble_state_id;
    }

    public final int getCheck() {
        return this.check;
    }

    public final String getClassify_style() {
        return this.classify_style;
    }

    public final String getFeed_id() {
        return this.feed_id;
    }

    public final String getIcon() {
        return this.icon;
    }

    public int getItemType() {
        return 0;
    }

    public final String getLeading_words() {
        return this.leading_words;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSort() {
        return this.sort;
    }

    public final String getState_types() {
        return this.state_types;
    }

    public final int is_bubble_tt_click() {
        return this.is_bubble_tt_click;
    }

    public final int is_classify() {
        return this.is_classify;
    }

    public final void setBubble_state_id(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bubble_state_id = str;
    }

    public final void setCheck(int i) {
        this.check = i;
    }

    public final void setClassify_style(String str) {
        this.classify_style = str;
    }

    public final void setFeed_id(String str) {
        this.feed_id = str;
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public final void setLeading_words(String str) {
        this.leading_words = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    public final void setState_types(String str) {
        this.state_types = str;
    }

    public final void set_bubble_tt_click(int i) {
        this.is_bubble_tt_click = i;
    }

    public final void set_classify(int i) {
        this.is_classify = i;
    }
}
