package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRomanticCityExtra.class */
public final class YYRomanticCityExtra extends BluedEntityBaseExtra {
    private final String receive_all_high;
    private final String receive_all_low;

    public YYRomanticCityExtra(String receive_all_high, String receive_all_low) {
        Intrinsics.e(receive_all_high, "receive_all_high");
        Intrinsics.e(receive_all_low, "receive_all_low");
        this.receive_all_high = receive_all_high;
        this.receive_all_low = receive_all_low;
    }

    public static /* synthetic */ YYRomanticCityExtra copy$default(YYRomanticCityExtra yYRomanticCityExtra, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRomanticCityExtra.receive_all_high;
        }
        if ((i & 2) != 0) {
            str2 = yYRomanticCityExtra.receive_all_low;
        }
        return yYRomanticCityExtra.copy(str, str2);
    }

    public final String component1() {
        return this.receive_all_high;
    }

    public final String component2() {
        return this.receive_all_low;
    }

    public final YYRomanticCityExtra copy(String receive_all_high, String receive_all_low) {
        Intrinsics.e(receive_all_high, "receive_all_high");
        Intrinsics.e(receive_all_low, "receive_all_low");
        return new YYRomanticCityExtra(receive_all_high, receive_all_low);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRomanticCityExtra) {
            YYRomanticCityExtra yYRomanticCityExtra = (YYRomanticCityExtra) obj;
            return Intrinsics.a((Object) this.receive_all_high, (Object) yYRomanticCityExtra.receive_all_high) && Intrinsics.a((Object) this.receive_all_low, (Object) yYRomanticCityExtra.receive_all_low);
        }
        return false;
    }

    public final String getReceive_all_high() {
        return this.receive_all_high;
    }

    public final String getReceive_all_low() {
        return this.receive_all_low;
    }

    public int hashCode() {
        return (this.receive_all_high.hashCode() * 31) + this.receive_all_low.hashCode();
    }

    public String toString() {
        return "YYRomanticCityExtra(receive_all_high=" + this.receive_all_high + ", receive_all_low=" + this.receive_all_low + ')';
    }
}
