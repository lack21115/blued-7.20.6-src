package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveCommonSwitchModel.class */
public final class LiveCommonSwitchModel implements Serializable {
    private String content;
    private String extra;
    private final int id;
    private final int status;

    public LiveCommonSwitchModel(int i, int i2, String str, String str2) {
        this.id = i;
        this.status = i2;
        this.content = str;
        this.extra = str2;
    }

    public /* synthetic */ LiveCommonSwitchModel(int i, int i2, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2);
    }

    public static /* synthetic */ LiveCommonSwitchModel copy$default(LiveCommonSwitchModel liveCommonSwitchModel, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = liveCommonSwitchModel.id;
        }
        if ((i3 & 2) != 0) {
            i2 = liveCommonSwitchModel.status;
        }
        if ((i3 & 4) != 0) {
            str = liveCommonSwitchModel.content;
        }
        if ((i3 & 8) != 0) {
            str2 = liveCommonSwitchModel.extra;
        }
        return liveCommonSwitchModel.copy(i, i2, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.status;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.extra;
    }

    public final LiveCommonSwitchModel copy(int i, int i2, String str, String str2) {
        return new LiveCommonSwitchModel(i, i2, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveCommonSwitchModel) {
            LiveCommonSwitchModel liveCommonSwitchModel = (LiveCommonSwitchModel) obj;
            return this.id == liveCommonSwitchModel.id && this.status == liveCommonSwitchModel.status && Intrinsics.a((Object) this.content, (Object) liveCommonSwitchModel.content) && Intrinsics.a((Object) this.extra, (Object) liveCommonSwitchModel.extra);
        }
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i = this.id;
        int i2 = this.status;
        String str = this.content;
        int i3 = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.extra;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return (((((i * 31) + i2) * 31) + hashCode) * 31) + i3;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final void setExtra(String str) {
        this.extra = str;
    }

    public String toString() {
        return "LiveCommonSwitchModel(id=" + this.id + ", status=" + this.status + ", content=" + ((Object) this.content) + ", extra=" + ((Object) this.extra) + ')';
    }
}
