package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LikeUpdateCurrentBeansModel.class */
public final class LikeUpdateCurrentBeansModel implements Serializable {
    private final int beans_current_count;

    public LikeUpdateCurrentBeansModel(int i) {
        this.beans_current_count = i;
    }

    public static /* synthetic */ LikeUpdateCurrentBeansModel copy$default(LikeUpdateCurrentBeansModel likeUpdateCurrentBeansModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = likeUpdateCurrentBeansModel.beans_current_count;
        }
        return likeUpdateCurrentBeansModel.copy(i);
    }

    public final int component1() {
        return this.beans_current_count;
    }

    public final LikeUpdateCurrentBeansModel copy(int i) {
        return new LikeUpdateCurrentBeansModel(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LikeUpdateCurrentBeansModel) && this.beans_current_count == ((LikeUpdateCurrentBeansModel) obj).beans_current_count;
    }

    public final int getBeans_current_count() {
        return this.beans_current_count;
    }

    public int hashCode() {
        return this.beans_current_count;
    }

    public String toString() {
        return "LikeUpdateCurrentBeansModel(beans_current_count=" + this.beans_current_count + ')';
    }
}
