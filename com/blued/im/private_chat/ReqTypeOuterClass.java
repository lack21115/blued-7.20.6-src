package com.blued.im.private_chat;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReqTypeOuterClass.class */
public final class ReqTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rReqType.proto\u0012\u0019com.blued.im.private_chat*¶\u0001\n\u0007ReqType\u0012\n\n\u0006ReqNil\u0010��\u0012\u0015\n\u0011ReqGetSessionInfo\u0010\u0001\u0012\u0011\n\rReqDelBurnMsg\u0010\u0002\u0012\u000f\n\u000bReqMakeCall\u0010\r\u0012\u000f\n\u000bReqStopCall\u0010\u000e\u0012\u0011\n\rReqUpdateCall\u0010\u000f\u0012\u0015\n\u0011ReqChangeCallType\u0010\u0010\u0012\u0012\n\u000eReqGetCallTime\u0010\u0011\u0012\u0015\n\u0011ReqStartStreaming\u00102B\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReqTypeOuterClass$ReqType.class */
    public enum ReqType implements ProtocolMessageEnum {
        ReqNil(0),
        ReqGetSessionInfo(1),
        ReqDelBurnMsg(2),
        ReqMakeCall(13),
        ReqStopCall(14),
        ReqUpdateCall(15),
        ReqChangeCallType(16),
        ReqGetCallTime(17),
        ReqStartStreaming(50),
        UNRECOGNIZED(-1);
        
        public static final int ReqChangeCallType_VALUE = 16;
        public static final int ReqDelBurnMsg_VALUE = 2;
        public static final int ReqGetCallTime_VALUE = 17;
        public static final int ReqGetSessionInfo_VALUE = 1;
        public static final int ReqMakeCall_VALUE = 13;
        public static final int ReqNil_VALUE = 0;
        public static final int ReqStartStreaming_VALUE = 50;
        public static final int ReqStopCall_VALUE = 14;
        public static final int ReqUpdateCall_VALUE = 15;
        private final int value;
        private static final Internal.EnumLiteMap<ReqType> internalValueMap = new Internal.EnumLiteMap<ReqType>() { // from class: com.blued.im.private_chat.ReqTypeOuterClass.ReqType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ReqType findValueByNumber(int i) {
                return ReqType.forNumber(i);
            }
        };
        private static final ReqType[] VALUES = values();

        ReqType(int i) {
            this.value = i;
        }

        public static ReqType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 50) {
                            switch (i) {
                                case 13:
                                    return ReqMakeCall;
                                case 14:
                                    return ReqStopCall;
                                case 15:
                                    return ReqUpdateCall;
                                case 16:
                                    return ReqChangeCallType;
                                case 17:
                                    return ReqGetCallTime;
                                default:
                                    return null;
                            }
                        }
                        return ReqStartStreaming;
                    }
                    return ReqDelBurnMsg;
                }
                return ReqGetSessionInfo;
            }
            return ReqNil;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ReqTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<ReqType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ReqType valueOf(int i) {
            return forNumber(i);
        }

        public static ReqType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    private ReqTypeOuterClass() {
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
