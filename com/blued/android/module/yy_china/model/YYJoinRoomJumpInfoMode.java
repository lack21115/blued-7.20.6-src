package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYJoinRoomJumpInfoMode.class */
public final class YYJoinRoomJumpInfoMode {
    public static final Companion Companion = new Companion(null);
    private static final int YY_JOIN_ROOM_JUMP_GIFT_WALL = 1;
    private static final int YY_JOIN_ROOM_JUMP_WEB_DIALOG = 0;
    private Object data;
    private int type;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYJoinRoomJumpInfoMode$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return YYJoinRoomJumpInfoMode.YY_JOIN_ROOM_JUMP_WEB_DIALOG;
        }

        public final YYJoinRoomJumpInfoMode a(int i, Object obj) {
            return new YYJoinRoomJumpInfoMode(i, obj);
        }

        public final int b() {
            return YYJoinRoomJumpInfoMode.YY_JOIN_ROOM_JUMP_GIFT_WALL;
        }
    }

    public YYJoinRoomJumpInfoMode() {
    }

    public YYJoinRoomJumpInfoMode(int i, Object obj) {
        this.type = i;
        this.data = obj;
    }

    public final Object getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
