package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/FieldEncoding.class */
public enum FieldEncoding {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);
    
    public static final Companion Companion = new Companion(null);
    private final int value;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/FieldEncoding$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final FieldEncoding get$wire_runtime(int i) throws IOException {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 5) {
                            return FieldEncoding.FIXED32;
                        }
                        throw new ProtocolException(Intrinsics.a("Unexpected FieldEncoding: ", Integer.valueOf(i)));
                    }
                    return FieldEncoding.LENGTH_DELIMITED;
                }
                return FieldEncoding.FIXED64;
            }
            return FieldEncoding.VARINT;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/squareup/wire/FieldEncoding$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FieldEncoding.values().length];
            iArr[FieldEncoding.VARINT.ordinal()] = 1;
            iArr[FieldEncoding.FIXED32.ordinal()] = 2;
            iArr[FieldEncoding.FIXED64.ordinal()] = 3;
            iArr[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    FieldEncoding(int i) {
        this.value = i;
    }

    public final int getValue$wire_runtime() {
        return this.value;
    }

    public final ProtoAdapter<?> rawProtoAdapter() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return ProtoAdapter.BYTES;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return ProtoAdapter.FIXED64;
            }
            return ProtoAdapter.FIXED32;
        }
        return ProtoAdapter.UINT64;
    }
}
