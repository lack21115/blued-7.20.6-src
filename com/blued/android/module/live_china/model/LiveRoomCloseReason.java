package com.blued.android.module.live_china.model;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomCloseReason.class */
public class LiveRoomCloseReason {
    public int errorCode;
    public String errorMessage;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomCloseReason$REASON.class */
    public interface REASON {
        public static final int BEEN_BLOCKED = 400004;
        public static final int BLOCKED_HIM = 400003;
        public static final int NORMAL = 400006;
        public static final int ROOM_FULL = 400005;
        public static final int UNKNOW = 0;
    }

    public LiveRoomCloseReason(int i, String str) {
        this.errorCode = i;
        this.errorMessage = str;
    }

    public static boolean isCloseByNormal(LiveRoomCloseReason liveRoomCloseReason) {
        return liveRoomCloseReason != null && liveRoomCloseReason.errorCode == 400006;
    }
}
