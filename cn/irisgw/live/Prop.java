package cn.irisgw.live;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/Prop.class */
public enum Prop implements ProtocolMessageEnum {
    NONE_PROP(0),
    SMALL_BLOOD(1),
    BIG_BLOOD(2),
    FOG(3),
    UNRECOGNIZED(-1);
    
    public static final int BIG_BLOOD_VALUE = 2;
    public static final int FOG_VALUE = 3;
    public static final int NONE_PROP_VALUE = 0;
    public static final int SMALL_BLOOD_VALUE = 1;
    private final int value;
    private static final Internal.EnumLiteMap<Prop> internalValueMap = new Internal.EnumLiteMap<Prop>() { // from class: cn.irisgw.live.Prop.1
        /* renamed from: findValueByNumber */
        public Prop m7068findValueByNumber(int i) {
            return Prop.forNumber(i);
        }
    };
    private static final Prop[] VALUES = values();

    Prop(int i) {
        this.value = i;
    }

    public static Prop forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return FOG;
                }
                return BIG_BLOOD;
            }
            return SMALL_BLOOD;
        }
        return NONE_PROP;
    }

    public static final Descriptors.EnumDescriptor getDescriptor() {
        return (Descriptors.EnumDescriptor) LiveConstants.getDescriptor().getEnumTypes().get(6);
    }

    public static Internal.EnumLiteMap<Prop> internalGetValueMap() {
        return internalValueMap;
    }

    @Deprecated
    public static Prop valueOf(int i) {
        return forNumber(i);
    }

    public static Prop valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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
