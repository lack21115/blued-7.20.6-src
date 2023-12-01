package com.blued.android.module.chat;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/ModuleChatConstant.class */
public class ModuleChatConstant {
    public static int DEFAULT_REMIND_AUDIO_VALUE = 0;
    public static final long DELAYED_GETSESSION_TIME = 1000;
    public static final int INTERVAL_TIME = 300000;
    public static final int ONCE_UPDATE_COUNT = 100;
    public static final String TAG = "@@@ module_chat_";
    public static final int UPDATE_MAX_COUNT = 500;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/ModuleChatConstant$RELATION_STATUS.class */
    public interface RELATION_STATUS {
        public static final int N = 0;
        public static final int UNKNOWN = 3;
        public static final int Y = 1;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/ModuleChatConstant$SESSION.class */
    public interface SESSION {
        public static final int DELETE = 1;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/ModuleChatConstant$UPDATE_RELATION_DATA_CODE.class */
    public interface UPDATE_RELATION_DATA_CODE {
        public static final int ERROR = 404;
        public static final int NO_UPDATE_TIME = 201;
        public static final int SUCESS = 200;
    }
}
