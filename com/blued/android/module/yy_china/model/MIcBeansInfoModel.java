package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/MIcBeansInfoModel.class */
public final class MIcBeansInfoModel {
    private final String bean;
    private final String uid;

    public MIcBeansInfoModel(String uid, String bean) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(bean, "bean");
        this.uid = uid;
        this.bean = bean;
    }

    public static /* synthetic */ MIcBeansInfoModel copy$default(MIcBeansInfoModel mIcBeansInfoModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mIcBeansInfoModel.uid;
        }
        if ((i & 2) != 0) {
            str2 = mIcBeansInfoModel.bean;
        }
        return mIcBeansInfoModel.copy(str, str2);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.bean;
    }

    public final MIcBeansInfoModel copy(String uid, String bean) {
        Intrinsics.e(uid, "uid");
        Intrinsics.e(bean, "bean");
        return new MIcBeansInfoModel(uid, bean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MIcBeansInfoModel) {
            MIcBeansInfoModel mIcBeansInfoModel = (MIcBeansInfoModel) obj;
            return Intrinsics.a((Object) this.uid, (Object) mIcBeansInfoModel.uid) && Intrinsics.a((Object) this.bean, (Object) mIcBeansInfoModel.bean);
        }
        return false;
    }

    public final String getBean() {
        return this.bean;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (this.uid.hashCode() * 31) + this.bean.hashCode();
    }

    public String toString() {
        return "MIcBeansInfoModel(uid=" + this.uid + ", bean=" + this.bean + ')';
    }
}
