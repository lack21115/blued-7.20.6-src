package cn.irisgw.live;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/VBadge.class */
public enum VBadge implements ProtocolMessageEnum {
    EMPTY_V(0),
    YELLOW_V(1),
    BLUE_V(2),
    PURPLE_V(3),
    AUTH_V(4),
    RED_V(5),
    STAR_V(6),
    ANCHOR_V(7),
    UNRECOGNIZED(-1);
    
    public static final int ANCHOR_V_VALUE = 7;
    public static final int AUTH_V_VALUE = 4;
    public static final int BLUE_V_VALUE = 2;
    public static final int EMPTY_V_VALUE = 0;
    public static final int PURPLE_V_VALUE = 3;
    public static final int RED_V_VALUE = 5;
    public static final int STAR_V_VALUE = 6;
    public static final int YELLOW_V_VALUE = 1;
    private final int value;
    private static final Internal.EnumLiteMap<VBadge> internalValueMap = new Internal.EnumLiteMap<VBadge>() { // from class: cn.irisgw.live.VBadge.1
        /* renamed from: findValueByNumber */
        public VBadge m8110findValueByNumber(int i) {
            return VBadge.forNumber(i);
        }
    };
    private static final VBadge[] VALUES = values();

    VBadge(int i) {
        this.value = i;
    }

    public static VBadge forNumber(int i) {
        switch (i) {
            case 0:
                return EMPTY_V;
            case 1:
                return YELLOW_V;
            case 2:
                return BLUE_V;
            case 3:
                return PURPLE_V;
            case 4:
                return AUTH_V;
            case 5:
                return RED_V;
            case 6:
                return STAR_V;
            case 7:
                return ANCHOR_V;
            default:
                return null;
        }
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) LiveConstants.getDescriptor().getEnumTypes().get(3);
    }

    public static Internal.EnumLiteMap<VBadge> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static VBadge valueOf(int i) {
        return forNumber(i);
    }

    public static VBadge valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
