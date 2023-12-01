package cn.irisgw.live;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PrivilegeType.class */
public enum PrivilegeType implements ProtocolMessageEnum {
    EMPTY_P(0),
    JOIN(1),
    CONSUMER(2),
    UNRECOGNIZED(-1);
    
    public static final int CONSUMER_VALUE = 2;
    public static final int EMPTY_P_VALUE = 0;
    public static final int JOIN_VALUE = 1;
    private final int value;
    private static final Internal.EnumLiteMap<PrivilegeType> internalValueMap = new Internal.EnumLiteMap<PrivilegeType>() { // from class: cn.irisgw.live.PrivilegeType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public PrivilegeType findValueByNumber(int i) {
            return PrivilegeType.forNumber(i);
        }
    };
    private static final PrivilegeType[] VALUES = values();

    PrivilegeType(int i) {
        this.value = i;
    }

    public static PrivilegeType forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return CONSUMER;
            }
            return JOIN;
        }
        return EMPTY_P;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return LiveConstants.getDescriptor().getEnumTypes().get(4);
    }

    public static Internal.EnumLiteMap<PrivilegeType> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static PrivilegeType valueOf(int i) {
        return forNumber(i);
    }

    public static PrivilegeType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
