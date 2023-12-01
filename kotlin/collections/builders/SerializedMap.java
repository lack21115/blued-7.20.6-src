package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/SerializedMap.class */
final class SerializedMap implements Externalizable {
    public static final Companion a = new Companion(null);
    private static final long serialVersionUID = 0;
    private Map<?, ?> b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/SerializedMap$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SerializedMap() {
        this(MapsKt.a());
    }

    public SerializedMap(Map<?, ?> map) {
        Intrinsics.e(map, "map");
        this.b = map;
    }

    private final Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        Intrinsics.e(input, "input");
        byte readByte = input.readByte();
        if (readByte != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte));
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        Map a2 = MapsKt.a(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                this.b = MapsKt.a(a2);
                return;
            } else {
                a2.put(input.readObject(), input.readObject());
                i = i2 + 1;
            }
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        Intrinsics.e(output, "output");
        output.writeByte(0);
        output.writeInt(this.b.size());
        for (Map.Entry<?, ?> entry : this.b.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }
}
