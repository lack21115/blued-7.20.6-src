package com.soft.blued.ui.msg.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MobPushModel.class */
public final class MobPushModel {
    private Extra extra;
    private int msg_type;
    private String push_type = "";
    private int session_id;
    private int session_type;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MobPushModel$Extra.class */
    public static final class Extra {
        private int redirect;
        private int redirect_type;
        private int version;
        private String title = "";
        private String content = "";
        private String link = "";

        public final String getContent() {
            return this.content;
        }

        public final String getLink() {
            return this.link;
        }

        public final int getRedirect() {
            return this.redirect;
        }

        public final int getRedirect_type() {
            return this.redirect_type;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getVersion() {
            return this.version;
        }

        public final void setContent(String str) {
            Intrinsics.e(str, "<set-?>");
            this.content = str;
        }

        public final void setLink(String str) {
            Intrinsics.e(str, "<set-?>");
            this.link = str;
        }

        public final void setRedirect(int i) {
            this.redirect = i;
        }

        public final void setRedirect_type(int i) {
            this.redirect_type = i;
        }

        public final void setTitle(String str) {
            Intrinsics.e(str, "<set-?>");
            this.title = str;
        }

        public final void setVersion(int i) {
            this.version = i;
        }
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final int getMsg_type() {
        return this.msg_type;
    }

    public final String getPush_type() {
        return this.push_type;
    }

    public final int getSession_id() {
        return this.session_id;
    }

    public final int getSession_type() {
        return this.session_type;
    }

    public final void setExtra(Extra extra) {
        this.extra = extra;
    }

    public final void setMsg_type(int i) {
        this.msg_type = i;
    }

    public final void setPush_type(String str) {
        Intrinsics.e(str, "<set-?>");
        this.push_type = str;
    }

    public final void setSession_id(int i) {
        this.session_id = i;
    }

    public final void setSession_type(int i) {
        this.session_type = i;
    }
}
