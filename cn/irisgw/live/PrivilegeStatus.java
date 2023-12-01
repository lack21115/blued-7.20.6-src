package cn.irisgw.live;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PrivilegeStatus.class */
public enum PrivilegeStatus implements ProtocolMessageEnum {
    CLOSE(0),
    OPEN(1),
    UNRECOGNIZED(-1);
    
    public static final int CLOSE_VALUE = 0;
    public static final int OPEN_VALUE = 1;
    private final int value;
    private static final Internal.EnumLiteMap<PrivilegeStatus> internalValueMap = new Internal.EnumLiteMap<PrivilegeStatus>() { // from class: cn.irisgw.live.PrivilegeStatus.1
        /* renamed from: findValueByNumber */
        public PrivilegeStatus m7064findValueByNumber(int i) {
            return PrivilegeStatus.forNumber(i);
        }
    };
    private static final PrivilegeStatus[] VALUES = values();

    PrivilegeStatus(int i) {
        this.value = i;
    }

    public static PrivilegeStatus forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return OPEN;
        }
        return CLOSE;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) LiveConstants.getDescriptor().getEnumTypes().get(5);
    }

    public static Internal.EnumLiteMap<PrivilegeStatus> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static PrivilegeStatus valueOf(int i) {
        return forNumber(i);
    }

    public static PrivilegeStatus valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
        if (enumValueDescriptor.getType() == getDescriptor()) {
            return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
        }
        throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }

    public final Descriptors.EnumDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
        if (this != UNRECOGNIZED) {
            return (Descriptors.EnumValueDescriptor) getDescriptor().getValues().get(ordinal());
        }
        throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
}
