package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/VipHttpDataModel.class */
public final class VipHttpDataModel implements Serializable {
    private ArrayList<VipLevelHttpDataModel> config;
    private VipCurrentHttpDataModel current;
    private int uid;
    private String avatar = "";
    private String avatar_frame = "";
    private String name = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final ArrayList<VipLevelHttpDataModel> getConfig() {
        return this.config;
    }

    public final VipCurrentHttpDataModel getCurrent() {
        return this.current;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUid() {
        return this.uid;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatar_frame(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar_frame = str;
    }

    public final void setConfig(ArrayList<VipLevelHttpDataModel> arrayList) {
        this.config = arrayList;
    }

    public final void setCurrent(VipCurrentHttpDataModel vipCurrentHttpDataModel) {
        this.current = vipCurrentHttpDataModel;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setUid(int i) {
        this.uid = i;
    }
}
