package com.blued.android.module.yy_china.model;

import $r8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/ConfessedMode.class */
public final class ConfessedMode {
    private final ConfessedUserMode being_confession_user_to;
    private final long confession_duration;
    private final long confession_score;
    private final ConfessedUserMode confession_user;
    private final String declare;
    private final int difference;
    private final long position_end_time;
    private final int ranking;
    private final int score;

    public ConfessedMode(ConfessedUserMode confession_user, ConfessedUserMode being_confession_user_to, long j, long j2, long j3, int i, int i2, int i3, String declare) {
        Intrinsics.e(confession_user, "confession_user");
        Intrinsics.e(being_confession_user_to, "being_confession_user_to");
        Intrinsics.e(declare, "declare");
        this.confession_user = confession_user;
        this.being_confession_user_to = being_confession_user_to;
        this.position_end_time = j;
        this.confession_duration = j2;
        this.confession_score = j3;
        this.score = i;
        this.difference = i2;
        this.ranking = i3;
        this.declare = declare;
    }

    public static /* synthetic */ ConfessedMode copy$default(ConfessedMode confessedMode, ConfessedUserMode confessedUserMode, ConfessedUserMode confessedUserMode2, long j, long j2, long j3, int i, int i2, int i3, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            confessedUserMode = confessedMode.confession_user;
        }
        if ((i4 & 2) != 0) {
            confessedUserMode2 = confessedMode.being_confession_user_to;
        }
        if ((i4 & 4) != 0) {
            j = confessedMode.position_end_time;
        }
        if ((i4 & 8) != 0) {
            j2 = confessedMode.confession_duration;
        }
        if ((i4 & 16) != 0) {
            j3 = confessedMode.confession_score;
        }
        if ((i4 & 32) != 0) {
            i = confessedMode.score;
        }
        if ((i4 & 64) != 0) {
            i2 = confessedMode.difference;
        }
        if ((i4 & 128) != 0) {
            i3 = confessedMode.ranking;
        }
        if ((i4 & 256) != 0) {
            str = confessedMode.declare;
        }
        return confessedMode.copy(confessedUserMode, confessedUserMode2, j, j2, j3, i, i2, i3, str);
    }

    public final ConfessedUserMode component1() {
        return this.confession_user;
    }

    public final ConfessedUserMode component2() {
        return this.being_confession_user_to;
    }

    public final long component3() {
        return this.position_end_time;
    }

    public final long component4() {
        return this.confession_duration;
    }

    public final long component5() {
        return this.confession_score;
    }

    public final int component6() {
        return this.score;
    }

    public final int component7() {
        return this.difference;
    }

    public final int component8() {
        return this.ranking;
    }

    public final String component9() {
        return this.declare;
    }

    public final ConfessedMode copy(ConfessedUserMode confession_user, ConfessedUserMode being_confession_user_to, long j, long j2, long j3, int i, int i2, int i3, String declare) {
        Intrinsics.e(confession_user, "confession_user");
        Intrinsics.e(being_confession_user_to, "being_confession_user_to");
        Intrinsics.e(declare, "declare");
        return new ConfessedMode(confession_user, being_confession_user_to, j, j2, j3, i, i2, i3, declare);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfessedMode) {
            ConfessedMode confessedMode = (ConfessedMode) obj;
            return Intrinsics.a(this.confession_user, confessedMode.confession_user) && Intrinsics.a(this.being_confession_user_to, confessedMode.being_confession_user_to) && this.position_end_time == confessedMode.position_end_time && this.confession_duration == confessedMode.confession_duration && this.confession_score == confessedMode.confession_score && this.score == confessedMode.score && this.difference == confessedMode.difference && this.ranking == confessedMode.ranking && Intrinsics.a((Object) this.declare, (Object) confessedMode.declare);
        }
        return false;
    }

    public final ConfessedUserMode getBeing_confession_user_to() {
        return this.being_confession_user_to;
    }

    public final long getConfession_duration() {
        return this.confession_duration;
    }

    public final long getConfession_score() {
        return this.confession_score;
    }

    public final ConfessedUserMode getConfession_user() {
        return this.confession_user;
    }

    public final String getDeclare() {
        return this.declare;
    }

    public final int getDifference() {
        return this.difference;
    }

    public final long getPosition_end_time() {
        return this.position_end_time;
    }

    public final int getRanking() {
        return this.ranking;
    }

    public final int getScore() {
        return this.score;
    }

    public int hashCode() {
        return (((((((((((((((this.confession_user.hashCode() * 31) + this.being_confession_user_to.hashCode()) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.position_end_time)) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.confession_duration)) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.confession_score)) * 31) + this.score) * 31) + this.difference) * 31) + this.ranking) * 31) + this.declare.hashCode();
    }

    public String toString() {
        return "ConfessedMode(confession_user=" + this.confession_user + ", being_confession_user_to=" + this.being_confession_user_to + ", position_end_time=" + this.position_end_time + ", confession_duration=" + this.confession_duration + ", confession_score=" + this.confession_score + ", score=" + this.score + ", difference=" + this.difference + ", ranking=" + this.ranking + ", declare=" + this.declare + ')';
    }
}
