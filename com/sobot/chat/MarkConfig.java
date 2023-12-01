package com.sobot.chat;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/MarkConfig.class */
public class MarkConfig {
    public static final int AUTO_MATCH_TIMEZONE = 8;
    public static final int DISPLAY_INNOTCH = 4;
    public static final int LANDSCAPE_SCREEN = 1;
    public static final int LEAVE_COMPLETE_CAN_REPLY = 2;
    public static final int SHOW_PERMISSION_TIPS_POP = 16;
    private static int markValue = 2;

    public static boolean getON_OFF(int i) {
        return (markValue & i) == i;
    }

    public static void main(String[] strArr) {
        System.out.println(getON_OFF(4));
    }

    public static void setON_OFF(int i, boolean z) {
        if (z) {
            markValue = i | markValue;
        } else {
            markValue = i & markValue;
        }
    }
}
