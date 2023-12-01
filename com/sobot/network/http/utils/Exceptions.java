package com.sobot.network.http.utils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/utils/Exceptions.class */
public class Exceptions {
    public static void illegalArgument(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }
}
