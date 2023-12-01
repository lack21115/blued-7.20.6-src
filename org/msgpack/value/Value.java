package org.msgpack.value;

import java.io.IOException;
import org.msgpack.core.MessagePacker;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Value.class */
public interface Value {
    ArrayValue asArrayValue();

    BinaryValue asBinaryValue();

    BooleanValue asBooleanValue();

    ExtensionValue asExtensionValue();

    FloatValue asFloatValue();

    IntegerValue asIntegerValue();

    MapValue asMapValue();

    NilValue asNilValue();

    NumberValue asNumberValue();

    RawValue asRawValue();

    StringValue asStringValue();

    boolean equals(Object obj);

    ValueType getValueType();

    ImmutableValue immutableValue();

    boolean isArrayValue();

    boolean isBinaryValue();

    boolean isBooleanValue();

    boolean isExtensionValue();

    boolean isFloatValue();

    boolean isIntegerValue();

    boolean isMapValue();

    boolean isNilValue();

    boolean isNumberValue();

    boolean isRawValue();

    boolean isStringValue();

    String toJson();

    void writeTo(MessagePacker messagePacker) throws IOException;
}
