package org.msgpack.value.impl;

import org.msgpack.core.MessageTypeCastException;
import org.msgpack.value.ImmutableArrayValue;
import org.msgpack.value.ImmutableBinaryValue;
import org.msgpack.value.ImmutableBooleanValue;
import org.msgpack.value.ImmutableExtensionValue;
import org.msgpack.value.ImmutableFloatValue;
import org.msgpack.value.ImmutableIntegerValue;
import org.msgpack.value.ImmutableMapValue;
import org.msgpack.value.ImmutableNilValue;
import org.msgpack.value.ImmutableNumberValue;
import org.msgpack.value.ImmutableRawValue;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.ImmutableValue;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/impl/AbstractImmutableValue.class */
abstract class AbstractImmutableValue implements ImmutableValue {
    @Override // org.msgpack.value.Value
    public ImmutableArrayValue asArrayValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableBinaryValue asBinaryValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableBooleanValue asBooleanValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableExtensionValue asExtensionValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableFloatValue asFloatValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableIntegerValue asIntegerValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableMapValue asMapValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableNilValue asNilValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableNumberValue asNumberValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableRawValue asRawValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ImmutableStringValue asStringValue() {
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public boolean isArrayValue() {
        return getValueType().isArrayType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBinaryValue() {
        return getValueType().isBinaryType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBooleanValue() {
        return getValueType().isBooleanType();
    }

    @Override // org.msgpack.value.Value
    public boolean isExtensionValue() {
        return getValueType().isExtensionType();
    }

    @Override // org.msgpack.value.Value
    public boolean isFloatValue() {
        return getValueType().isFloatType();
    }

    @Override // org.msgpack.value.Value
    public boolean isIntegerValue() {
        return getValueType().isIntegerType();
    }

    @Override // org.msgpack.value.Value
    public boolean isMapValue() {
        return getValueType().isMapType();
    }

    @Override // org.msgpack.value.Value
    public boolean isNilValue() {
        return getValueType().isNilType();
    }

    @Override // org.msgpack.value.Value
    public boolean isNumberValue() {
        return getValueType().isNumberType();
    }

    @Override // org.msgpack.value.Value
    public boolean isRawValue() {
        return getValueType().isRawType();
    }

    @Override // org.msgpack.value.Value
    public boolean isStringValue() {
        return getValueType().isStringType();
    }
}
