package cn.irisgw.live;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FanStatus.class */
public enum FanStatus implements ProtocolMessageEnum {
    Out(0),
    Join(1),
    Unactive(2),
    UNRECOGNIZED(-1);
    
    public static final int Join_VALUE = 1;
    public static final int Out_VALUE = 0;
    public static final int Unactive_VALUE = 2;
    private final int value;
    private static final Internal.EnumLiteMap<FanStatus> internalValueMap = new Internal.EnumLiteMap<FanStatus>() { // from class: cn.irisgw.live.FanStatus.1
        /* renamed from: findValueByNumber */
        public FanStatus m2470findValueByNumber(int i) {
            return FanStatus.forNumber(i);
        }
    };
    private static final FanStatus[] VALUES = values();

    FanStatus(int i) {
        this.value = i;
    }

    public static FanStatus forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Unactive;
            }
            return Join;
        }
        return Out;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) LiveConstants.getDescriptor().getEnumTypes().get(2);
    }

    public static Internal.EnumLiteMap<FanStatus> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static FanStatus valueOf(int i) {
        return forNumber(i);
    }

    public static FanStatus valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
