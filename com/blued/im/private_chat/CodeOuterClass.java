package com.blued.im.private_chat;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/CodeOuterClass.class */
public final class CodeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\nCode.proto\u0012\u0019com.blued.im.private_chat*Ó\u0005\n\u0004Code\u0012\u0013\n\u000fPRIVATE_SUCCESS\u0010��\u0012 \n\u001cPRIVATE_ERROR_PROTOCOL_ERROR\u0010\u0001\u0012\u001f\n\u001bPRIVATE_ERROR_CONTENT_EMPTY\u0010\u0002\u0012!\n\u001dPRIVATE_ERROR_CONTENT_ILLEGAL\u0010\u0003\u0012 \n\u001cPRIVATE_ERROR_USER_FORBIDDEN\u0010\u0004\u0012\"\n\u001ePRIVATE_ERROR_IN_HIS_BLACKLIST\u0010\u0005\u0012!\n\u001dPRIVATE_ERROR_IN_MY_BLACKLIST\u0010\u0006\u0012\u001a\n\u0016PRIVATE_ERROR_TOO_FAST\u0010\u0007\u0012!\n\u001dPRIVATE_ERROR_ACOUNT_NOT_AUTH\u0010\b\u0012#\n\u001fPRIVATE_ERROR_NOT_EACH_FOLLOWED\u0010\t\u0012 \n\u001cPRIVATE_ERROR_FORBIDEDTOTALK\u0010\n\u0012\u001c\n\u0018PRIVATE_ERROR_BIND_PHONE\u0010\u000b\u0012\u001d\n\u0019PRIVATE_ERROR_NOT_DISTRUB\u0010\f\u0012!\n\u001dPRIVATE_ERROR_DELETE_OUT_TIME\u0010\r\u0012\u001e\n\u001aPRIVATE_ERROR_NOT_IN_GROUP\u0010\u000e\u0012\u001d\n\u0019PRIVATE_ERROR_MSG_URL_ERR\u0010\u000f\u0012\u001f\n\u001bPRIVATE_ERROR_USER_AUTH_ERR\u0010\u0010\u0012\u001d\n\u0019PRIVATE_ERROR_MSG_SVC_ERR\u0010\u0011\u0012\u001c\n\u0018PRIVATE_ERROR_KAFKA_PUSH\u0010\u0012\u0012\u001c\n\u0018PRIVATE_ERROR_KAFKA_PULL\u0010\u0013\u0012\u001a\n\u0016PRIVATE_ERROR_CODE_LOW\u0010\u0014\u0012*\n&PRIVATE_ERROR_FAST_PICTURE_AUDIT_ERROR\u0010\u0015B\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/CodeOuterClass$Code.class */
    public enum Code implements ProtocolMessageEnum {
        PRIVATE_SUCCESS(0),
        PRIVATE_ERROR_PROTOCOL_ERROR(1),
        PRIVATE_ERROR_CONTENT_EMPTY(2),
        PRIVATE_ERROR_CONTENT_ILLEGAL(3),
        PRIVATE_ERROR_USER_FORBIDDEN(4),
        PRIVATE_ERROR_IN_HIS_BLACKLIST(5),
        PRIVATE_ERROR_IN_MY_BLACKLIST(6),
        PRIVATE_ERROR_TOO_FAST(7),
        PRIVATE_ERROR_ACOUNT_NOT_AUTH(8),
        PRIVATE_ERROR_NOT_EACH_FOLLOWED(9),
        PRIVATE_ERROR_FORBIDEDTOTALK(10),
        PRIVATE_ERROR_BIND_PHONE(11),
        PRIVATE_ERROR_NOT_DISTRUB(12),
        PRIVATE_ERROR_DELETE_OUT_TIME(13),
        PRIVATE_ERROR_NOT_IN_GROUP(14),
        PRIVATE_ERROR_MSG_URL_ERR(15),
        PRIVATE_ERROR_USER_AUTH_ERR(16),
        PRIVATE_ERROR_MSG_SVC_ERR(17),
        PRIVATE_ERROR_KAFKA_PUSH(18),
        PRIVATE_ERROR_KAFKA_PULL(19),
        PRIVATE_ERROR_CODE_LOW(20),
        PRIVATE_ERROR_FAST_PICTURE_AUDIT_ERROR(21),
        UNRECOGNIZED(-1);
        
        public static final int PRIVATE_ERROR_ACOUNT_NOT_AUTH_VALUE = 8;
        public static final int PRIVATE_ERROR_BIND_PHONE_VALUE = 11;
        public static final int PRIVATE_ERROR_CODE_LOW_VALUE = 20;
        public static final int PRIVATE_ERROR_CONTENT_EMPTY_VALUE = 2;
        public static final int PRIVATE_ERROR_CONTENT_ILLEGAL_VALUE = 3;
        public static final int PRIVATE_ERROR_DELETE_OUT_TIME_VALUE = 13;
        public static final int PRIVATE_ERROR_FAST_PICTURE_AUDIT_ERROR_VALUE = 21;
        public static final int PRIVATE_ERROR_FORBIDEDTOTALK_VALUE = 10;
        public static final int PRIVATE_ERROR_IN_HIS_BLACKLIST_VALUE = 5;
        public static final int PRIVATE_ERROR_IN_MY_BLACKLIST_VALUE = 6;
        public static final int PRIVATE_ERROR_KAFKA_PULL_VALUE = 19;
        public static final int PRIVATE_ERROR_KAFKA_PUSH_VALUE = 18;
        public static final int PRIVATE_ERROR_MSG_SVC_ERR_VALUE = 17;
        public static final int PRIVATE_ERROR_MSG_URL_ERR_VALUE = 15;
        public static final int PRIVATE_ERROR_NOT_DISTRUB_VALUE = 12;
        public static final int PRIVATE_ERROR_NOT_EACH_FOLLOWED_VALUE = 9;
        public static final int PRIVATE_ERROR_NOT_IN_GROUP_VALUE = 14;
        public static final int PRIVATE_ERROR_PROTOCOL_ERROR_VALUE = 1;
        public static final int PRIVATE_ERROR_TOO_FAST_VALUE = 7;
        public static final int PRIVATE_ERROR_USER_AUTH_ERR_VALUE = 16;
        public static final int PRIVATE_ERROR_USER_FORBIDDEN_VALUE = 4;
        public static final int PRIVATE_SUCCESS_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Code> internalValueMap = new Internal.EnumLiteMap<Code>() { // from class: com.blued.im.private_chat.CodeOuterClass.Code.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Code findValueByNumber(int i) {
                return Code.forNumber(i);
            }
        };
        private static final Code[] VALUES = values();

        Code(int i) {
            this.value = i;
        }

        public static Code forNumber(int i) {
            switch (i) {
                case 0:
                    return PRIVATE_SUCCESS;
                case 1:
                    return PRIVATE_ERROR_PROTOCOL_ERROR;
                case 2:
                    return PRIVATE_ERROR_CONTENT_EMPTY;
                case 3:
                    return PRIVATE_ERROR_CONTENT_ILLEGAL;
                case 4:
                    return PRIVATE_ERROR_USER_FORBIDDEN;
                case 5:
                    return PRIVATE_ERROR_IN_HIS_BLACKLIST;
                case 6:
                    return PRIVATE_ERROR_IN_MY_BLACKLIST;
                case 7:
                    return PRIVATE_ERROR_TOO_FAST;
                case 8:
                    return PRIVATE_ERROR_ACOUNT_NOT_AUTH;
                case 9:
                    return PRIVATE_ERROR_NOT_EACH_FOLLOWED;
                case 10:
                    return PRIVATE_ERROR_FORBIDEDTOTALK;
                case 11:
                    return PRIVATE_ERROR_BIND_PHONE;
                case 12:
                    return PRIVATE_ERROR_NOT_DISTRUB;
                case 13:
                    return PRIVATE_ERROR_DELETE_OUT_TIME;
                case 14:
                    return PRIVATE_ERROR_NOT_IN_GROUP;
                case 15:
                    return PRIVATE_ERROR_MSG_URL_ERR;
                case 16:
                    return PRIVATE_ERROR_USER_AUTH_ERR;
                case 17:
                    return PRIVATE_ERROR_MSG_SVC_ERR;
                case 18:
                    return PRIVATE_ERROR_KAFKA_PUSH;
                case 19:
                    return PRIVATE_ERROR_KAFKA_PULL;
                case 20:
                    return PRIVATE_ERROR_CODE_LOW;
                case 21:
                    return PRIVATE_ERROR_FAST_PICTURE_AUDIT_ERROR;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CodeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Code> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Code valueOf(int i) {
            return forNumber(i);
        }

        public static Code valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    private CodeOuterClass() {
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
