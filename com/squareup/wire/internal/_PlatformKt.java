package com.squareup.wire.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/_PlatformKt.class */
public final class _PlatformKt {
    public static final String camelCase(String string, boolean z) {
        Intrinsics.e(string, "string");
        StringBuilder sb = new StringBuilder(string.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= string.length()) {
                String sb2 = sb.toString();
                Intrinsics.c(sb2, "StringBuilder(capacity).…builderAction).toString()");
                return sb2;
            }
            int codePointAt = string.codePointAt(i2);
            int charCount = i2 + Character.charCount(codePointAt);
            if (codePointAt == 95) {
                z = true;
                i = charCount;
            } else {
                int i3 = codePointAt;
                if (z) {
                    i3 = codePointAt;
                    if (codePointAt <= 122 && 97 <= codePointAt) {
                        i3 = codePointAt - 32;
                    }
                }
                sb.appendCodePoint(i3);
                z = false;
                i = charCount;
            }
        }
    }

    public static /* synthetic */ String camelCase$default(String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return camelCase(str, z);
    }

    public static final <T> List<T> toUnmodifiableList(List<T> list) {
        Intrinsics.e(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(list);
        Intrinsics.c(unmodifiableList, "unmodifiableList(this)");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toUnmodifiableMap(Map<K, V> map) {
        Intrinsics.e(map, "<this>");
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.c(unmodifiableMap, "unmodifiableMap(this)");
        return unmodifiableMap;
    }
}
