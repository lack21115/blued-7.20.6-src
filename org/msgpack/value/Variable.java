package org.msgpack.value;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessageIntegerOverflowException;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageStringCodingException;
import org.msgpack.core.MessageTypeCastException;
import org.msgpack.value.impl.ImmutableBigIntegerValueImpl;

/* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable.class */
public class Variable implements Value {
    private static final long BYTE_MAX = 127;
    private static final long BYTE_MIN = -128;
    private static final long INT_MAX = 2147483647L;
    private static final long INT_MIN = -2147483648L;
    private static final long SHORT_MAX = 32767;
    private static final long SHORT_MIN = -32768;
    private AbstractValueAccessor accessor;
    private double doubleValue;
    private long longValue;
    private Object objectValue;
    private Type type;
    private static final BigInteger LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    private final NilValueAccessor nilAccessor = new NilValueAccessor();
    private final BooleanValueAccessor booleanAccessor = new BooleanValueAccessor();
    private final IntegerValueAccessor integerAccessor = new IntegerValueAccessor();
    private final FloatValueAccessor floatAccessor = new FloatValueAccessor();
    private final BinaryValueAccessor binaryAccessor = new BinaryValueAccessor();
    private final StringValueAccessor stringAccessor = new StringValueAccessor();
    private final ArrayValueAccessor arrayAccessor = new ArrayValueAccessor();
    private final MapValueAccessor mapAccessor = new MapValueAccessor();
    private final ExtensionValueAccessor extensionAccessor = new ExtensionValueAccessor();

    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$AbstractNumberValueAccessor.class */
    abstract class AbstractNumberValueAccessor extends AbstractValueAccessor implements NumberValue {
        private AbstractNumberValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public NumberValue asNumberValue() {
            return this;
        }

        @Override // org.msgpack.value.NumberValue
        public BigInteger toBigInteger() {
            return Variable.this.type == Type.BIG_INTEGER ? (BigInteger) Variable.this.objectValue : Variable.this.type == Type.DOUBLE ? new BigDecimal(Variable.this.doubleValue).toBigInteger() : BigInteger.valueOf(Variable.this.longValue);
        }

        @Override // org.msgpack.value.NumberValue
        public byte toByte() {
            return Variable.this.type == Type.BIG_INTEGER ? ((BigInteger) Variable.this.objectValue).byteValue() : (byte) Variable.this.longValue;
        }

        @Override // org.msgpack.value.NumberValue
        public double toDouble() {
            return Variable.this.type == Type.BIG_INTEGER ? ((BigInteger) Variable.this.objectValue).doubleValue() : Variable.this.type == Type.DOUBLE ? Variable.this.doubleValue : Variable.this.longValue;
        }

        @Override // org.msgpack.value.NumberValue
        public float toFloat() {
            return Variable.this.type == Type.BIG_INTEGER ? ((BigInteger) Variable.this.objectValue).floatValue() : Variable.this.type == Type.DOUBLE ? (float) Variable.this.doubleValue : (float) Variable.this.longValue;
        }

        @Override // org.msgpack.value.NumberValue
        public int toInt() {
            return Variable.this.type == Type.BIG_INTEGER ? ((BigInteger) Variable.this.objectValue).intValue() : (int) Variable.this.longValue;
        }

        @Override // org.msgpack.value.NumberValue
        public long toLong() {
            return Variable.this.type == Type.BIG_INTEGER ? ((BigInteger) Variable.this.objectValue).longValue() : Variable.this.longValue;
        }

        @Override // org.msgpack.value.NumberValue
        public short toShort() {
            return Variable.this.type == Type.BIG_INTEGER ? ((BigInteger) Variable.this.objectValue).shortValue() : (short) Variable.this.longValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$AbstractRawValueAccessor.class */
    public abstract class AbstractRawValueAccessor extends AbstractValueAccessor implements RawValue {
        private AbstractRawValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.RawValue
        public byte[] asByteArray() {
            return (byte[]) Variable.this.objectValue;
        }

        @Override // org.msgpack.value.RawValue
        public ByteBuffer asByteBuffer() {
            return ByteBuffer.wrap(asByteArray());
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public RawValue asRawValue() {
            return this;
        }

        @Override // org.msgpack.value.RawValue
        public String asString() {
            try {
                return MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap((byte[]) Variable.this.objectValue)).toString();
            } catch (CharacterCodingException e) {
                throw new MessageStringCodingException(e);
            }
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.RawValue
        public String toString() {
            try {
                return MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(ByteBuffer.wrap((byte[]) Variable.this.objectValue)).toString();
            } catch (CharacterCodingException e) {
                throw new MessageStringCodingException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$AbstractValueAccessor.class */
    public abstract class AbstractValueAccessor implements Value {
        private AbstractValueAccessor() {
        }

        @Override // org.msgpack.value.Value
        public ArrayValue asArrayValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public BinaryValue asBinaryValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public BooleanValue asBooleanValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public ExtensionValue asExtensionValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public FloatValue asFloatValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public IntegerValue asIntegerValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public MapValue asMapValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public NilValue asNilValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public NumberValue asNumberValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public RawValue asRawValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public StringValue asStringValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public boolean equals(Object obj) {
            return Variable.this.equals(obj);
        }

        public int hashCode() {
            return Variable.this.hashCode();
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

        @Override // org.msgpack.value.Value
        public String toJson() {
            return Variable.this.toJson();
        }

        public String toString() {
            return Variable.this.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$ArrayValueAccessor.class */
    public class ArrayValueAccessor extends AbstractValueAccessor implements ArrayValue {
        private ArrayValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public ArrayValue asArrayValue() {
            return this;
        }

        @Override // org.msgpack.value.ArrayValue
        public Value get(int i) {
            return list().get(i);
        }

        @Override // org.msgpack.value.ArrayValue
        public Value getOrNilValue(int i) {
            List<Value> list = list();
            return (list.size() >= i || i < 0) ? list.get(i) : ValueFactory.newNil();
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.ARRAY;
        }

        @Override // org.msgpack.value.Value
        public ImmutableArrayValue immutableValue() {
            return ValueFactory.newArray(list());
        }

        @Override // org.msgpack.value.ArrayValue, java.lang.Iterable
        public Iterator<Value> iterator() {
            return list().iterator();
        }

        @Override // org.msgpack.value.ArrayValue
        public List<Value> list() {
            return (List) Variable.this.objectValue;
        }

        @Override // org.msgpack.value.ArrayValue
        public int size() {
            return list().size();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            List<Value> list = list();
            messagePacker.packArrayHeader(list.size());
            for (Value value : list) {
                value.writeTo(messagePacker);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$BinaryValueAccessor.class */
    public class BinaryValueAccessor extends AbstractRawValueAccessor implements BinaryValue {
        private BinaryValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public BinaryValue asBinaryValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.BINARY;
        }

        @Override // org.msgpack.value.Value
        public ImmutableBinaryValue immutableValue() {
            return ValueFactory.newBinary(asByteArray());
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            byte[] bArr = (byte[]) Variable.this.objectValue;
            messagePacker.packBinaryHeader(bArr.length);
            messagePacker.writePayload(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$BooleanValueAccessor.class */
    public class BooleanValueAccessor extends AbstractValueAccessor implements BooleanValue {
        private BooleanValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public BooleanValue asBooleanValue() {
            return this;
        }

        @Override // org.msgpack.value.BooleanValue
        public boolean getBoolean() {
            return Variable.this.longValue == 1;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.BOOLEAN;
        }

        @Override // org.msgpack.value.Value
        public ImmutableBooleanValue immutableValue() {
            return ValueFactory.newBoolean(getBoolean());
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            messagePacker.packBoolean(Variable.this.longValue == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$ExtensionValueAccessor.class */
    public class ExtensionValueAccessor extends AbstractValueAccessor implements ExtensionValue {
        private ExtensionValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public ExtensionValue asExtensionValue() {
            return this;
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte[] getData() {
            return ((ImmutableExtensionValue) Variable.this.objectValue).getData();
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte getType() {
            return ((ImmutableExtensionValue) Variable.this.objectValue).getType();
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.EXTENSION;
        }

        @Override // org.msgpack.value.Value
        public ImmutableExtensionValue immutableValue() {
            return (ImmutableExtensionValue) Variable.this.objectValue;
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            ((ImmutableExtensionValue) Variable.this.objectValue).writeTo(messagePacker);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$FloatValueAccessor.class */
    public class FloatValueAccessor extends AbstractNumberValueAccessor implements FloatValue {
        private FloatValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public FloatValue asFloatValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.FLOAT;
        }

        @Override // org.msgpack.value.Value
        public ImmutableFloatValue immutableValue() {
            return ValueFactory.newFloat(Variable.this.doubleValue);
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            messagePacker.packDouble(Variable.this.doubleValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$IntegerValueAccessor.class */
    public class IntegerValueAccessor extends AbstractNumberValueAccessor implements IntegerValue {
        private IntegerValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.IntegerValue
        public BigInteger asBigInteger() {
            return Variable.this.type == Type.BIG_INTEGER ? (BigInteger) Variable.this.objectValue : BigInteger.valueOf(Variable.this.longValue);
        }

        @Override // org.msgpack.value.IntegerValue
        public byte asByte() {
            if (isInByteRange()) {
                return (byte) Variable.this.longValue;
            }
            throw new MessageIntegerOverflowException(Variable.this.longValue);
        }

        @Override // org.msgpack.value.IntegerValue
        public int asInt() {
            if (isInIntRange()) {
                return (int) Variable.this.longValue;
            }
            throw new MessageIntegerOverflowException(Variable.this.longValue);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public IntegerValue asIntegerValue() {
            return this;
        }

        @Override // org.msgpack.value.IntegerValue
        public long asLong() {
            if (isInLongRange()) {
                return Variable.this.longValue;
            }
            throw new MessageIntegerOverflowException(Variable.this.longValue);
        }

        @Override // org.msgpack.value.IntegerValue
        public short asShort() {
            if (isInByteRange()) {
                return (short) Variable.this.longValue;
            }
            throw new MessageIntegerOverflowException(Variable.this.longValue);
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.INTEGER;
        }

        @Override // org.msgpack.value.Value
        public ImmutableIntegerValue immutableValue() {
            return Variable.this.type == Type.BIG_INTEGER ? ValueFactory.newInteger((BigInteger) Variable.this.objectValue) : ValueFactory.newInteger(Variable.this.longValue);
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInByteRange() {
            if (Variable.this.type == Type.BIG_INTEGER) {
                return false;
            }
            boolean z = false;
            if (Variable.BYTE_MIN <= Variable.this.longValue) {
                z = false;
                if (Variable.this.longValue <= Variable.BYTE_MAX) {
                    z = true;
                }
            }
            return z;
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInIntRange() {
            if (Variable.this.type == Type.BIG_INTEGER) {
                return false;
            }
            boolean z = false;
            if (Variable.INT_MIN <= Variable.this.longValue) {
                z = false;
                if (Variable.this.longValue <= Variable.INT_MAX) {
                    z = true;
                }
            }
            return z;
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInLongRange() {
            return Variable.this.type != Type.BIG_INTEGER;
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInShortRange() {
            if (Variable.this.type == Type.BIG_INTEGER) {
                return false;
            }
            boolean z = false;
            if (Variable.SHORT_MIN <= Variable.this.longValue) {
                z = false;
                if (Variable.this.longValue <= Variable.SHORT_MAX) {
                    z = true;
                }
            }
            return z;
        }

        @Override // org.msgpack.value.IntegerValue
        public MessageFormat mostSuccinctMessageFormat() {
            return ImmutableBigIntegerValueImpl.mostSuccinctMessageFormat(this);
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            if (Variable.this.type == Type.BIG_INTEGER) {
                messagePacker.packBigInteger((BigInteger) Variable.this.objectValue);
            } else {
                messagePacker.packLong(Variable.this.longValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$MapValueAccessor.class */
    public class MapValueAccessor extends AbstractValueAccessor implements MapValue {
        private MapValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public MapValue asMapValue() {
            return this;
        }

        @Override // org.msgpack.value.MapValue
        public Set<Map.Entry<Value, Value>> entrySet() {
            return map().entrySet();
        }

        @Override // org.msgpack.value.MapValue
        public Value[] getKeyValueArray() {
            Map<Value, Value> map = map();
            Value[] valueArr = new Value[map.size() * 2];
            Iterator<Map.Entry<Value, Value>> it = map.entrySet().iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return valueArr;
                }
                Map.Entry<Value, Value> next = it.next();
                valueArr[i2] = next.getKey();
                int i3 = i2 + 1;
                valueArr[i3] = next.getValue();
                i = i3 + 1;
            }
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.MAP;
        }

        @Override // org.msgpack.value.Value
        public ImmutableMapValue immutableValue() {
            return ValueFactory.newMap(map());
        }

        @Override // org.msgpack.value.MapValue
        public Set<Value> keySet() {
            return map().keySet();
        }

        @Override // org.msgpack.value.MapValue
        public Map<Value, Value> map() {
            return (Map) Variable.this.objectValue;
        }

        @Override // org.msgpack.value.MapValue
        public int size() {
            return map().size();
        }

        @Override // org.msgpack.value.MapValue
        public Collection<Value> values() {
            return map().values();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            Map<Value, Value> map = map();
            messagePacker.packArrayHeader(map.size());
            for (Map.Entry<Value, Value> entry : map.entrySet()) {
                entry.getKey().writeTo(messagePacker);
                entry.getValue().writeTo(messagePacker);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$NilValueAccessor.class */
    public class NilValueAccessor extends AbstractValueAccessor implements NilValue {
        private NilValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public NilValue asNilValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.NIL;
        }

        @Override // org.msgpack.value.Value
        public ImmutableNilValue immutableValue() {
            return ValueFactory.newNil();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            messagePacker.packNil();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$StringValueAccessor.class */
    public class StringValueAccessor extends AbstractRawValueAccessor implements StringValue {
        private StringValueAccessor() {
            super();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public StringValue asStringValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.STRING;
        }

        @Override // org.msgpack.value.Value
        public ImmutableStringValue immutableValue() {
            return ValueFactory.newString((byte[]) Variable.this.objectValue);
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker messagePacker) throws IOException {
            byte[] bArr = (byte[]) Variable.this.objectValue;
            messagePacker.packRawStringHeader(bArr.length);
            messagePacker.writePayload(bArr);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:org/msgpack/value/Variable$Type.class */
    public enum Type {
        NULL(ValueType.NIL),
        BOOLEAN(ValueType.BOOLEAN),
        LONG(ValueType.INTEGER),
        BIG_INTEGER(ValueType.INTEGER),
        DOUBLE(ValueType.FLOAT),
        BYTE_ARRAY(ValueType.BINARY),
        RAW_STRING(ValueType.STRING),
        LIST(ValueType.ARRAY),
        MAP(ValueType.MAP),
        EXTENSION(ValueType.EXTENSION);
        
        private final ValueType valueType;

        Type(ValueType valueType) {
            this.valueType = valueType;
        }

        public ValueType getValueType() {
            return this.valueType;
        }
    }

    public Variable() {
        setNilValue();
    }

    @Override // org.msgpack.value.Value
    public ArrayValue asArrayValue() {
        if (isArrayValue()) {
            return (ArrayValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public BinaryValue asBinaryValue() {
        if (isBinaryValue()) {
            return (BinaryValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public BooleanValue asBooleanValue() {
        if (isBooleanValue()) {
            return (BooleanValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ExtensionValue asExtensionValue() {
        if (isExtensionValue()) {
            return (ExtensionValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public FloatValue asFloatValue() {
        if (isFloatValue()) {
            return (FloatValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public IntegerValue asIntegerValue() {
        if (isIntegerValue()) {
            return (IntegerValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public MapValue asMapValue() {
        if (isMapValue()) {
            return (MapValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public NilValue asNilValue() {
        if (isNilValue()) {
            return (NilValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public NumberValue asNumberValue() {
        if (isNumberValue()) {
            return (NumberValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public RawValue asRawValue() {
        if (isRawValue()) {
            return (RawValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public StringValue asStringValue() {
        if (isStringValue()) {
            return (StringValue) this.accessor;
        }
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object obj) {
        return immutableValue().equals(obj);
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return this.type.getValueType();
    }

    public int hashCode() {
        return immutableValue().hashCode();
    }

    @Override // org.msgpack.value.Value
    public ImmutableValue immutableValue() {
        return this.accessor.immutableValue();
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

    public Variable setArrayValue(List<Value> list) {
        this.type = Type.LIST;
        this.accessor = this.arrayAccessor;
        this.objectValue = list;
        return this;
    }

    public Variable setBinaryValue(byte[] bArr) {
        this.type = Type.BYTE_ARRAY;
        this.accessor = this.binaryAccessor;
        this.objectValue = bArr;
        return this;
    }

    public Variable setBooleanValue(boolean z) {
        this.type = Type.BOOLEAN;
        this.accessor = this.booleanAccessor;
        this.longValue = z ? 1L : 0L;
        return this;
    }

    public Variable setExtensionValue(byte b, byte[] bArr) {
        this.type = Type.EXTENSION;
        this.accessor = this.extensionAccessor;
        this.objectValue = ValueFactory.newExtension(b, bArr);
        return this;
    }

    public Variable setFloatValue(double d) {
        this.type = Type.DOUBLE;
        this.accessor = this.floatAccessor;
        this.doubleValue = d;
        this.longValue = (long) d;
        return this;
    }

    public Variable setFloatValue(float f) {
        this.type = Type.DOUBLE;
        this.accessor = this.floatAccessor;
        this.longValue = f;
        return this;
    }

    public Variable setIntegerValue(long j) {
        this.type = Type.LONG;
        this.accessor = this.integerAccessor;
        this.longValue = j;
        return this;
    }

    public Variable setIntegerValue(BigInteger bigInteger) {
        if (bigInteger.compareTo(LONG_MIN) < 0 || bigInteger.compareTo(LONG_MAX) > 0) {
            this.type = Type.BIG_INTEGER;
            this.accessor = this.integerAccessor;
            this.objectValue = bigInteger;
            return this;
        }
        this.type = Type.LONG;
        this.accessor = this.integerAccessor;
        this.longValue = bigInteger.longValue();
        return this;
    }

    public Variable setMapValue(Map<Value, Value> map) {
        this.type = Type.MAP;
        this.accessor = this.mapAccessor;
        this.objectValue = map;
        return this;
    }

    public Variable setNilValue() {
        this.type = Type.NULL;
        this.accessor = this.nilAccessor;
        return this;
    }

    public Variable setStringValue(String str) {
        return setStringValue(str.getBytes(MessagePack.UTF8));
    }

    public Variable setStringValue(byte[] bArr) {
        this.type = Type.RAW_STRING;
        this.accessor = this.stringAccessor;
        this.objectValue = bArr;
        return this;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        return immutableValue().toJson();
    }

    public String toString() {
        return immutableValue().toString();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker messagePacker) throws IOException {
        this.accessor.writeTo(messagePacker);
    }
}
