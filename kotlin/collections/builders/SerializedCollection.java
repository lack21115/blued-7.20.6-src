package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/SerializedCollection.class */
public final class SerializedCollection implements Externalizable {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f42413a = new Companion(null);
    private static final long serialVersionUID = 0;
    private Collection<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final int f42414c;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/collections/builders/SerializedCollection$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SerializedCollection() {
        this(CollectionsKt.b(), 0);
    }

    public SerializedCollection(Collection<?> collection, int i) {
        Intrinsics.e(collection, "collection");
        this.b = collection;
        this.f42414c = i;
    }

    private final Object readResolve() {
        return this.b;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        Collection a2;
        Intrinsics.e(input, "input");
        byte readByte = input.readByte();
        int i = readByte & 1;
        if ((readByte & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        if (i == 0) {
            List a3 = CollectionsKt.a(readInt);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= readInt) {
                    break;
                }
                a3.add(input.readObject());
                i2 = i3 + 1;
            }
            a2 = CollectionsKt.a(a3);
        } else if (i != 1) {
            throw new InvalidObjectException("Unsupported collection type tag: " + i + '.');
        } else {
            Set a4 = SetsKt.a(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                a4.add(input.readObject());
            }
            a2 = SetsKt.a(a4);
        }
        this.b = a2;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        Intrinsics.e(output, "output");
        output.writeByte(this.f42414c);
        output.writeInt(this.b.size());
        Iterator<?> it = this.b.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }
}
