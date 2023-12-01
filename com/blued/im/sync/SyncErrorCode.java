package com.blued.im.sync;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncErrorCode.class */
public final class SyncErrorCode {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013SyncErrorCode.proto\u0012\u0011com.blued.im.sync*}\n\tErrorCode\u0012\u000f\n\u000bErrorCodeOK\u0010��\u0012 \n\u001cErrorCodeIncompatibleVersion\u0010\u0001\u0012\u001e\n\u001aErrorCodeIncompletePackage\u0010\u0002\u0012\u001d\n\u0018ErrorInternalServerError\u0010ÿ\u0001BFZ=git.ourbluecity.com/moka20477/Hermes-Sync-Main-Go/grpc/pbfile¢\u0002\u0004Syncb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/sync/SyncErrorCode$ErrorCode.class */
    public enum ErrorCode implements ProtocolMessageEnum {
        ErrorCodeOK(0),
        ErrorCodeIncompatibleVersion(1),
        ErrorCodeIncompletePackage(2),
        ErrorInternalServerError(255),
        UNRECOGNIZED(-1);
        
        public static final int ErrorCodeIncompatibleVersion_VALUE = 1;
        public static final int ErrorCodeIncompletePackage_VALUE = 2;
        public static final int ErrorCodeOK_VALUE = 0;
        public static final int ErrorInternalServerError_VALUE = 255;
        private final int value;
        private static final Internal.EnumLiteMap<ErrorCode> internalValueMap = new Internal.EnumLiteMap<ErrorCode>() { // from class: com.blued.im.sync.SyncErrorCode.ErrorCode.1
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
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 255) {
                            return null;
                        }
                        return ErrorInternalServerError;
                    }
                    return ErrorCodeIncompletePackage;
                }
                return ErrorCodeIncompatibleVersion;
            }
            return ErrorCodeOK;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SyncErrorCode.getDescriptor().getEnumTypes().get(0);
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

    private SyncErrorCode() {
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
