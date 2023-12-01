package com.blued.android.module.yy_china.model;

import $r8;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents104Model.class */
public final class IMJsonContents104Model {
    private final long countdown;
    private final int type;
    private final String uid;
    private final ArrayList<String> uids;

    public IMJsonContents104Model(ArrayList<String> uids, String uid, long j, int i) {
        Intrinsics.e(uids, "uids");
        Intrinsics.e(uid, "uid");
        this.uids = uids;
        this.uid = uid;
        this.countdown = j;
        this.type = i;
    }

    public static /* synthetic */ IMJsonContents104Model copy$default(IMJsonContents104Model iMJsonContents104Model, ArrayList arrayList, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = iMJsonContents104Model.uids;
        }
        if ((i2 & 2) != 0) {
            str = iMJsonContents104Model.uid;
        }
        if ((i2 & 4) != 0) {
            j = iMJsonContents104Model.countdown;
        }
        if ((i2 & 8) != 0) {
            i = iMJsonContents104Model.type;
        }
        return iMJsonContents104Model.copy(arrayList, str, j, i);
    }

    public final ArrayList<String> component1() {
        return this.uids;
    }

    public final String component2() {
        return this.uid;
    }

    public final long component3() {
        return this.countdown;
    }

    public final int component4() {
        return this.type;
    }

    public final IMJsonContents104Model copy(ArrayList<String> uids, String uid, long j, int i) {
        Intrinsics.e(uids, "uids");
        Intrinsics.e(uid, "uid");
        return new IMJsonContents104Model(uids, uid, j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents104Model) {
            IMJsonContents104Model iMJsonContents104Model = (IMJsonContents104Model) obj;
            return Intrinsics.a(this.uids, iMJsonContents104Model.uids) && Intrinsics.a((Object) this.uid, (Object) iMJsonContents104Model.uid) && this.countdown == iMJsonContents104Model.countdown && this.type == iMJsonContents104Model.type;
        }
        return false;
    }

    public final long getCountdown() {
        return this.countdown;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public final ArrayList<String> getUids() {
        return this.uids;
    }

    public int hashCode() {
        return (((((this.uids.hashCode() * 31) + this.uid.hashCode()) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.countdown)) * 31) + this.type;
    }

    public String toString() {
        return "IMJsonContents104Model(uids=" + this.uids + ", uid=" + this.uid + ", countdown=" + this.countdown + ", type=" + this.type + ')';
    }
}
