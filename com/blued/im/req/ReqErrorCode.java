package com.blued.im.req;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqErrorCode.class */
public final class ReqErrorCode {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012ReqErrorCode.proto\u0012\u0010com.blued.im.req*Ê\u0003\n\tErrorCode\u0012\u0015\n\u0011CHAT_ERROR_CODE_1\u0010��\u0012\u0015\n\u0011CHAT_ERROR_CODE_2\u0010\u0001\u0012\u0015\n\u0011CHAT_ERROR_CODE_3\u0010\u0002\u0012\u0015\n\u0011CHAT_ERROR_CODE_4\u0010\u0003\u0012\u0015\n\u0011CHAT_ERROR_CODE_5\u0010\u0004\u0012\u0015\n\u0011CHAT_ERROR_CODE_6\u0010\u0005\u0012\u0015\n\u0011CHAT_ERROR_CODE_7\u0010\u0006\u0012\u0015\n\u0011CHAT_ERROR_CODE_8\u0010\u0007\u0012\u0015\n\u0011CHAT_ERROR_CODE_9\u0010\b\u0012\u0016\n\u0012CHAT_ERROR_CODE_10\u0010\t\u0012\u0016\n\u0012CHAT_ERROR_CODE_11\u0010\n\u0012\u0016\n\u0012CHAT_ERROR_CODE_12\u0010\u000b\u0012\u0016\n\u0012CHAT_ERROR_CODE_13\u0010\f\u0012\u0016\n\u0012CHAT_ERROR_CODE_14\u0010\r\u0012\u0016\n\u0012CHAT_ERROR_CODE_15\u0010\u000e\u0012\u0016\n\u0012CHAT_ERROR_CODE_16\u0010\u000f\u0012\u0016\n\u0012CHAT_ERROR_CODE_17\u0010\u0010\u0012\u0016\n\u0012CHAT_ERROR_CODE_18\u0010\u0011\u0012\u0016\n\u0012CHAT_ERROR_CODE_19\u0010\u0012b\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqErrorCode$ErrorCode.class */
    public enum ErrorCode implements ProtocolMessageEnum {
        CHAT_ERROR_CODE_1(0),
        CHAT_ERROR_CODE_2(1),
        CHAT_ERROR_CODE_3(2),
        CHAT_ERROR_CODE_4(3),
        CHAT_ERROR_CODE_5(4),
        CHAT_ERROR_CODE_6(5),
        CHAT_ERROR_CODE_7(6),
        CHAT_ERROR_CODE_8(7),
        CHAT_ERROR_CODE_9(8),
        CHAT_ERROR_CODE_10(9),
        CHAT_ERROR_CODE_11(10),
        CHAT_ERROR_CODE_12(11),
        CHAT_ERROR_CODE_13(12),
        CHAT_ERROR_CODE_14(13),
        CHAT_ERROR_CODE_15(14),
        CHAT_ERROR_CODE_16(15),
        CHAT_ERROR_CODE_17(16),
        CHAT_ERROR_CODE_18(17),
        CHAT_ERROR_CODE_19(18),
        UNRECOGNIZED(-1);
        
        public static final int CHAT_ERROR_CODE_10_VALUE = 9;
        public static final int CHAT_ERROR_CODE_11_VALUE = 10;
        public static final int CHAT_ERROR_CODE_12_VALUE = 11;
        public static final int CHAT_ERROR_CODE_13_VALUE = 12;
        public static final int CHAT_ERROR_CODE_14_VALUE = 13;
        public static final int CHAT_ERROR_CODE_15_VALUE = 14;
        public static final int CHAT_ERROR_CODE_16_VALUE = 15;
        public static final int CHAT_ERROR_CODE_17_VALUE = 16;
        public static final int CHAT_ERROR_CODE_18_VALUE = 17;
        public static final int CHAT_ERROR_CODE_19_VALUE = 18;
        public static final int CHAT_ERROR_CODE_1_VALUE = 0;
        public static final int CHAT_ERROR_CODE_2_VALUE = 1;
        public static final int CHAT_ERROR_CODE_3_VALUE = 2;
        public static final int CHAT_ERROR_CODE_4_VALUE = 3;
        public static final int CHAT_ERROR_CODE_5_VALUE = 4;
        public static final int CHAT_ERROR_CODE_6_VALUE = 5;
        public static final int CHAT_ERROR_CODE_7_VALUE = 6;
        public static final int CHAT_ERROR_CODE_8_VALUE = 7;
        public static final int CHAT_ERROR_CODE_9_VALUE = 8;
        private final int value;
        private static final Internal.EnumLiteMap<ErrorCode> internalValueMap = new Internal.EnumLiteMap<ErrorCode>() { // from class: com.blued.im.req.ReqErrorCode.ErrorCode.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ErrorCode findValueByNumber(int i) {
                return ErrorCode.forNumber(i);
            }
        };
        private static final ErrorCode[] VALUES = values();

        ErrorCode(int i) {
            this.value = i;
        }

        public static ErrorCode forNumber(int i) {
            switch (i) {
                case 0:
                    return CHAT_ERROR_CODE_1;
                case 1:
                    return CHAT_ERROR_CODE_2;
                case 2:
                    return CHAT_ERROR_CODE_3;
                case 3:
                    return CHAT_ERROR_CODE_4;
                case 4:
                    return CHAT_ERROR_CODE_5;
                case 5:
                    return CHAT_ERROR_CODE_6;
                case 6:
                    return CHAT_ERROR_CODE_7;
                case 7:
                    return CHAT_ERROR_CODE_8;
                case 8:
                    return CHAT_ERROR_CODE_9;
                case 9:
                    return CHAT_ERROR_CODE_10;
                case 10:
                    return CHAT_ERROR_CODE_11;
                case 11:
                    return CHAT_ERROR_CODE_12;
                case 12:
                    return CHAT_ERROR_CODE_13;
                case 13:
                    return CHAT_ERROR_CODE_14;
                case 14:
                    return CHAT_ERROR_CODE_15;
                case 15:
                    return CHAT_ERROR_CODE_16;
                case 16:
                    return CHAT_ERROR_CODE_17;
                case 17:
                    return CHAT_ERROR_CODE_18;
                case 18:
                    return CHAT_ERROR_CODE_19;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ReqErrorCode.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<ErrorCode> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ErrorCode valueOf(int i) {
            return forNumber(i);
        }

        public static ErrorCode valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    private ReqErrorCode() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
