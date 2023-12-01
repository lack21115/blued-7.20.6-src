package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgListCheatModel.class */
public final class MsgListCheatModel {
    private long version;
    private String button = "";
    private String title = "";
    private String content = "";
    private String url = "";

    public final String getButton() {
        return this.button;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setButton(String str) {
        Intrinsics.e(str, "<set-?>");
        this.button = str;
    }

    public final void setContent(String str) {
        Intrinsics.e(str, "<set-?>");
        this.content = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void setUrl(String str) {
        Intrinsics.e(str, "<set-?>");
        this.url = str;
    }

    public final void setVersion(long j) {
        this.version = j;
    }
}
