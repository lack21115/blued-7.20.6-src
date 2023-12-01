package com.blued.community.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedOperationFloatModel.class */
public final class FeedOperationFloatModel {
    private int p_id;
    private FeedOperationFloatContentModel push_content;
    private String push_site;
    private String start_time;
    private int status;
    private String target_link;
    private int target_path;
    private String name = "";
    private String end_time = "";

    public final String getEnd_time() {
        return this.end_time;
    }

    public final String getName() {
        return this.name;
    }

    public final int getP_id() {
        return this.p_id;
    }

    public final FeedOperationFloatContentModel getPush_content() {
        return this.push_content;
    }

    public final String getPush_site() {
        return this.push_site;
    }

    public final String getStart_time() {
        return this.start_time;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTarget_link() {
        return this.target_link;
    }

    public final int getTarget_path() {
        return this.target_path;
    }

    public final void setEnd_time(String str) {
        this.end_time = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setP_id(int i) {
        this.p_id = i;
    }

    public final void setPush_content(FeedOperationFloatContentModel feedOperationFloatContentModel) {
        this.push_content = feedOperationFloatContentModel;
    }

    public final void setPush_site(String str) {
        this.push_site = str;
    }

    public final void setStart_time(String str) {
        this.start_time = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTarget_link(String str) {
        this.target_link = str;
    }

    public final void setTarget_path(int i) {
        this.target_path = i;
    }
}
