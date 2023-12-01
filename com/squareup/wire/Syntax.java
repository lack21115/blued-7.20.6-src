package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/Syntax.class */
public enum Syntax {
    PROTO_2("proto2"),
    PROTO_3("proto3");
    
    public static final Companion Companion = new Companion(null);
    private final String string;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/Syntax$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Syntax get(String str) {
            Intrinsics.e(str, "string");
            Syntax[] values = Syntax.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                Syntax syntax = values[i];
                i++;
                if (Intrinsics.a(syntax.string, str)) {
                    return syntax;
                }
            }
            throw new IllegalArgumentException(Intrinsics.a("unexpected syntax: ", str));
        }
    }

    Syntax(String str) {
        this.string = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }
}
