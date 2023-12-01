package com.blued.android.module.common.face;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/face/ChannelModel.class */
public final class ChannelModel {
    private final int is_tencent;

    public ChannelModel() {
        this(0, 1, null);
    }

    public ChannelModel(int i) {
        this.is_tencent = i;
    }

    public /* synthetic */ ChannelModel(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public static /* synthetic */ ChannelModel copy$default(ChannelModel channelModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = channelModel.is_tencent;
        }
        return channelModel.copy(i);
    }

    public final int component1() {
        return this.is_tencent;
    }

    public final ChannelModel copy(int i) {
        return new ChannelModel(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChannelModel) && this.is_tencent == ((ChannelModel) obj).is_tencent;
    }

    public int hashCode() {
        return this.is_tencent;
    }

    public final int is_tencent() {
        return this.is_tencent;
    }

    public String toString() {
        return "ChannelModel(is_tencent=" + this.is_tencent + ')';
    }
}
