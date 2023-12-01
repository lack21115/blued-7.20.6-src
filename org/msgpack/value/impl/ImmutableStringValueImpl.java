package org.msgpack.value.impl;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/impl/ImmutableStringValueImpl.class */
public class ImmutableStringValueImpl extends AbstractImmutableRawValue implements ImmutableStringValue {
    public ImmutableStringValueImpl(String str) {
        super(str);
    }

    public ImmutableStringValueImpl(byte[] bArr) {
        super(bArr);
    }

    @Override // org.msgpack.value.impl.AbstractImmutableValue, org.msgpack.value.Value
    public ImmutableStringValue asStringValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Value) {
            Value value = (Value) obj;
            if (value.isStringValue()) {
                if (value instanceof ImmutableStringValueImpl) {
                    return Arrays.equals(this.data, ((ImmutableStringValueImpl) value).data);
                }
                return Arrays.equals(this.data, value.asStringValue().asByteArray());
            }
            return false;
        }
        return false;
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return ValueType.STRING;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    @Override // org.msgpack.value.Value
    public ImmutableStringValue immutableValue() {
        return this;
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker messagePacker) throws IOException {
        messagePacker.packRawStringHeader(this.data.length);
        messagePacker.writePayload(this.data);
    }
}
