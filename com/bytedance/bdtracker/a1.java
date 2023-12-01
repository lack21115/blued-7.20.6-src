package com.bytedance.bdtracker;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/a1.class */
public final class a1 {
    public static String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "STATE_DISABLED" : "STATE_ENABLED" : "STATE_DEFAULT";
    }
}
