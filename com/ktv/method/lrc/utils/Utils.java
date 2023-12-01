package com.ktv.method.lrc.utils;

/* loaded from: source-7994992-dex2jar.jar:com/ktv/method/lrc/utils/Utils.class */
public class Utils {
    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? "vtt" : str.substring(lastIndexOf + 1).toLowerCase();
    }
}
