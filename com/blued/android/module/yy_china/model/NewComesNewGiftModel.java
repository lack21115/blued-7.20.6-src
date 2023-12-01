package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/NewComesNewGiftModel.class */
public final class NewComesNewGiftModel {
    private final String count;
    private final String duration;
    private final String id;
    private final String name;
    private final String pic;
    private int status;
    private final String type;

    public NewComesNewGiftModel(String type, String id, String name, String count, String pic, String duration, int i) {
        Intrinsics.e(type, "type");
        Intrinsics.e(id, "id");
        Intrinsics.e(name, "name");
        Intrinsics.e(count, "count");
        Intrinsics.e(pic, "pic");
        Intrinsics.e(duration, "duration");
        this.type = type;
        this.id = id;
        this.name = name;
        this.count = count;
        this.pic = pic;
        this.duration = duration;
        this.status = i;
    }

    public static /* synthetic */ NewComesNewGiftModel copy$default(NewComesNewGiftModel newComesNewGiftModel, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = newComesNewGiftModel.type;
        }
        if ((i2 & 2) != 0) {
            str2 = newComesNewGiftModel.id;
        }
        if ((i2 & 4) != 0) {
            str3 = newComesNewGiftModel.name;
        }
        if ((i2 & 8) != 0) {
            str4 = newComesNewGiftModel.count;
        }
        if ((i2 & 16) != 0) {
            str5 = newComesNewGiftModel.pic;
        }
        if ((i2 & 32) != 0) {
            str6 = newComesNewGiftModel.duration;
        }
        if ((i2 & 64) != 0) {
            i = newComesNewGiftModel.status;
        }
        return newComesNewGiftModel.copy(str, str2, str3, str4, str5, str6, i);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.count;
    }

    public final String component5() {
        return this.pic;
    }

    public final String component6() {
        return this.duration;
    }

    public final int component7() {
        return this.status;
    }

    public final NewComesNewGiftModel copy(String type, String id, String name, String count, String pic, String duration, int i) {
        Intrinsics.e(type, "type");
        Intrinsics.e(id, "id");
        Intrinsics.e(name, "name");
        Intrinsics.e(count, "count");
        Intrinsics.e(pic, "pic");
        Intrinsics.e(duration, "duration");
        return new NewComesNewGiftModel(type, id, name, count, pic, duration, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewComesNewGiftModel) {
            NewComesNewGiftModel newComesNewGiftModel = (NewComesNewGiftModel) obj;
            return Intrinsics.a((Object) this.type, (Object) newComesNewGiftModel.type) && Intrinsics.a((Object) this.id, (Object) newComesNewGiftModel.id) && Intrinsics.a((Object) this.name, (Object) newComesNewGiftModel.name) && Intrinsics.a((Object) this.count, (Object) newComesNewGiftModel.count) && Intrinsics.a((Object) this.pic, (Object) newComesNewGiftModel.pic) && Intrinsics.a((Object) this.duration, (Object) newComesNewGiftModel.duration) && this.status == newComesNewGiftModel.status;
        }
        return false;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPic() {
        return this.pic;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.type.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.count.hashCode()) * 31) + this.pic.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "NewComesNewGiftModel(type=" + this.type + ", id=" + this.id + ", name=" + this.name + ", count=" + this.count + ", pic=" + this.pic + ", duration=" + this.duration + ", status=" + this.status + ')';
    }
}
