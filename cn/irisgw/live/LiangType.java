package cn.irisgw.live;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiangType.class */
public enum LiangType implements ProtocolMessageEnum {
    None(0),
    Default(1),
    Pop(2),
    Super(3),
    UNRECOGNIZED(-1);
    
    public static final int Default_VALUE = 1;
    public static final int None_VALUE = 0;
    public static final int Pop_VALUE = 2;
    public static final int Super_VALUE = 3;
    private final int value;
    private static final Internal.EnumLiteMap<LiangType> internalValueMap = new Internal.EnumLiteMap<LiangType>() { // from class: cn.irisgw.live.LiangType.1
        /* renamed from: findValueByNumber */
        public LiangType m3892findValueByNumber(int i) {
            return LiangType.forNumber(i);
        }
    };
    private static final LiangType[] VALUES = values();

    LiangType(int i) {
        this.value = i;
    }

    public static LiangType forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Super;
                }
                return Pop;
            }
            return Default;
        }
        return None;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) LiveConstants.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal.EnumLiteMap<LiangType> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static LiangType valueOf(int i) {
        return forNumber(i);
    }

    public static LiangType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
