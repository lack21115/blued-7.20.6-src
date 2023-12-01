package com.soft.blued.ui.setting.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/ResetPwdModel.class */
public final class ResetPwdModel {
    private String login_mobile = "";
    private String relation_mobile = "";
    private String token = "";
    private String _ = "";

    public final String getLogin_mobile() {
        return this.login_mobile;
    }

    public final String getRelation_mobile() {
        return this.relation_mobile;
    }

    public final String getToken() {
        return this.token;
    }

    public final String get_() {
        return this._;
    }

    public final void setLogin_mobile(String str) {
        Intrinsics.e(str, "<set-?>");
        this.login_mobile = str;
    }

    public final void setRelation_mobile(String str) {
        Intrinsics.e(str, "<set-?>");
        this.relation_mobile = str;
    }

    public final void setToken(String str) {
        Intrinsics.e(str, "<set-?>");
        this.token = str;
    }

    public final void set_(String str) {
        Intrinsics.e(str, "<set-?>");
        this._ = str;
    }
}
