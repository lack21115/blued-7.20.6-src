package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/internal/Internal__InternalJvmKt.class */
final /* synthetic */ class Internal__InternalJvmKt {
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <E extends com.squareup.wire.WireEnum> E getIdentityOrNull(java.lang.Class<E> r4) {
        /*
            r0 = r4
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r4
            java.lang.Object[] r0 = r0.getEnumConstants()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "enumConstants"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r8
            int r0 = r0.length
            r7 = r0
            r0 = 0
            r6 = r0
        L19:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L54
            r0 = r8
            r1 = r6
            r0 = r0[r1]
            r4 = r0
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r4
            com.squareup.wire.WireEnum r0 = (com.squareup.wire.WireEnum) r0
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L4a
            r0 = r9
            int r0 = r0.getValue()
            if (r0 != 0) goto L41
            r0 = 1
            r5 = r0
            goto L43
        L41:
            r0 = 0
            r5 = r0
        L43:
            r0 = r5
            if (r0 == 0) goto L19
            goto L56
        L4a:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            java.lang.String r2 = "null cannot be cast to non-null type com.squareup.wire.WireEnum"
            r1.<init>(r2)
            throw r0
        L54:
            r0 = 0
            r4 = r0
        L56:
            r0 = r4
            com.squareup.wire.WireEnum r0 = (com.squareup.wire.WireEnum) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.internal.Internal__InternalJvmKt.getIdentityOrNull(java.lang.Class):com.squareup.wire.WireEnum");
    }

    public static final <T> void redactElements(List<T> list, ProtoAdapter<T> protoAdapter) {
        Intrinsics.e(list, "list");
        Intrinsics.e(protoAdapter, "adapter");
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            list.set(i2, protoAdapter.redact(list.get(i2)));
            i = i2 + 1;
        }
    }

    public static final <T> void redactElements(Map<?, T> map, ProtoAdapter<T> protoAdapter) {
        Intrinsics.e(map, "map");
        Intrinsics.e(protoAdapter, "adapter");
        for (Map.Entry<?, T> entry : map.entrySet()) {
            entry.setValue(protoAdapter.redact(entry.getValue()));
        }
    }
}
