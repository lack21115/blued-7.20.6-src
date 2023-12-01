package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ConfessedUserGiftMode.class */
public final class ConfessedUserGiftMode {
    private final ArrayList<YYGiftModel> confession_goods;
    private final ArrayList<ConfessedUserMode> confession_user;
    private final String random_confession_declare;

    public ConfessedUserGiftMode(ArrayList<ConfessedUserMode> confession_user, ArrayList<YYGiftModel> confession_goods, String random_confession_declare) {
        Intrinsics.e(confession_user, "confession_user");
        Intrinsics.e(confession_goods, "confession_goods");
        Intrinsics.e(random_confession_declare, "random_confession_declare");
        this.confession_user = confession_user;
        this.confession_goods = confession_goods;
        this.random_confession_declare = random_confession_declare;
    }

    public static /* synthetic */ ConfessedUserGiftMode copy$default(ConfessedUserGiftMode confessedUserGiftMode, ArrayList arrayList, ArrayList arrayList2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = confessedUserGiftMode.confession_user;
        }
        if ((i & 2) != 0) {
            arrayList2 = confessedUserGiftMode.confession_goods;
        }
        if ((i & 4) != 0) {
            str = confessedUserGiftMode.random_confession_declare;
        }
        return confessedUserGiftMode.copy(arrayList, arrayList2, str);
    }

    public final ArrayList<ConfessedUserMode> component1() {
        return this.confession_user;
    }

    public final ArrayList<YYGiftModel> component2() {
        return this.confession_goods;
    }

    public final String component3() {
        return this.random_confession_declare;
    }

    public final ConfessedUserGiftMode copy(ArrayList<ConfessedUserMode> confession_user, ArrayList<YYGiftModel> confession_goods, String random_confession_declare) {
        Intrinsics.e(confession_user, "confession_user");
        Intrinsics.e(confession_goods, "confession_goods");
        Intrinsics.e(random_confession_declare, "random_confession_declare");
        return new ConfessedUserGiftMode(confession_user, confession_goods, random_confession_declare);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfessedUserGiftMode) {
            ConfessedUserGiftMode confessedUserGiftMode = (ConfessedUserGiftMode) obj;
            return Intrinsics.a(this.confession_user, confessedUserGiftMode.confession_user) && Intrinsics.a(this.confession_goods, confessedUserGiftMode.confession_goods) && Intrinsics.a((Object) this.random_confession_declare, (Object) confessedUserGiftMode.random_confession_declare);
        }
        return false;
    }

    public final ArrayList<YYGiftModel> getConfession_goods() {
        return this.confession_goods;
    }

    public final ArrayList<ConfessedUserMode> getConfession_user() {
        return this.confession_user;
    }

    public final String getRandom_confession_declare() {
        return this.random_confession_declare;
    }

    public int hashCode() {
        return (((this.confession_user.hashCode() * 31) + this.confession_goods.hashCode()) * 31) + this.random_confession_declare.hashCode();
    }

    public String toString() {
        return "ConfessedUserGiftMode(confession_user=" + this.confession_user + ", confession_goods=" + this.confession_goods + ", random_confession_declare=" + this.random_confession_declare + ')';
    }
}
