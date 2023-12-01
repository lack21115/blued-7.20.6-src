package com.blued.im.req;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqCode.class */
public final class ReqCode {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rReqCode.proto\u0012\u0010com.blued.im.req*5\n\u0004Code\u0012\u000f\n\u000bREQ_SUCCESS\u0010��\u0012\u001c\n\u0018REQ_ERROR_PROTOCOL_ERROR\u0010\u0001B\u0006¢\u0002\u0003Reqb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/req/ReqCode$Code.class */
    public enum Code implements ProtocolMessageEnum {
        REQ_SUCCESS(0),
        REQ_ERROR_PROTOCOL_ERROR(1),
        UNRECOGNIZED(-1);
        
        public static final int REQ_ERROR_PROTOCOL_ERROR_VALUE = 1;
        public static final int REQ_SUCCESS_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Code> internalValueMap = new Internal.EnumLiteMap<Code>() { // from class: com.blued.im.req.ReqCode.Code.1
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
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return REQ_ERROR_PROTOCOL_ERROR;
            }
            return REQ_SUCCESS;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ReqCode.getDescriptor().getEnumTypes().get(0);
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

    private ReqCode() {
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
