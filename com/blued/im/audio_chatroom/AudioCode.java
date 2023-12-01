package com.blued.im.audio_chatroom;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioCode.class */
public final class AudioCode {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fAudioCode.proto\u0012\u001bcom.blued.im.audio_chatroom*Â\u0001\n\u0004Code\u0012\u0016\n\u0012AUDIO_SEND_SUCCESS\u0010��\u0012#\n\u001fAUDIO_SEND_ERROR_PROTOCOL_ERROR\u0010\u0001\u0012\u0019\n\u0015AUDIO_SEND_USER_ERROR\u0010\u0002\u0012\"\n\u001eAUDIO_SEND_ERROR_CONTENT_EMPTY\u0010\u0003\u0012$\n AUDIO_SEND_ERROR_CONTENT_ILLEGAL\u0010\u0004\u0012\u0018\n\u0014AUDIO_SEND_USER_MUTE\u0010\u0005B\u0010¢\u0002\rAudioChatroomb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/audio_chatroom/AudioCode$Code.class */
    public enum Code implements ProtocolMessageEnum {
        AUDIO_SEND_SUCCESS(0),
        AUDIO_SEND_ERROR_PROTOCOL_ERROR(1),
        AUDIO_SEND_USER_ERROR(2),
        AUDIO_SEND_ERROR_CONTENT_EMPTY(3),
        AUDIO_SEND_ERROR_CONTENT_ILLEGAL(4),
        AUDIO_SEND_USER_MUTE(5),
        UNRECOGNIZED(-1);
        
        public static final int AUDIO_SEND_ERROR_CONTENT_EMPTY_VALUE = 3;
        public static final int AUDIO_SEND_ERROR_CONTENT_ILLEGAL_VALUE = 4;
        public static final int AUDIO_SEND_ERROR_PROTOCOL_ERROR_VALUE = 1;
        public static final int AUDIO_SEND_SUCCESS_VALUE = 0;
        public static final int AUDIO_SEND_USER_ERROR_VALUE = 2;
        public static final int AUDIO_SEND_USER_MUTE_VALUE = 5;
        private final int value;
        private static final Internal.EnumLiteMap<Code> internalValueMap = new Internal.EnumLiteMap<Code>() { // from class: com.blued.im.audio_chatroom.AudioCode.Code.1
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
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return AUDIO_SEND_USER_MUTE;
                            }
                            return AUDIO_SEND_ERROR_CONTENT_ILLEGAL;
                        }
                        return AUDIO_SEND_ERROR_CONTENT_EMPTY;
                    }
                    return AUDIO_SEND_USER_ERROR;
                }
                return AUDIO_SEND_ERROR_PROTOCOL_ERROR;
            }
            return AUDIO_SEND_SUCCESS;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return AudioCode.getDescriptor().getEnumTypes().get(0);
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

    private AudioCode() {
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
