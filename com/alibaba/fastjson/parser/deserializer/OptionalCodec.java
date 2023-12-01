package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/OptionalCodec.class */
public class OptionalCodec implements ObjectDeserializer, ObjectSerializer {
    public static OptionalCodec instance = new OptionalCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer castToInt = TypeUtils.castToInt(defaultJSONParser.parseObject((Class<Object>) Integer.class));
            return castToInt == null ? (T) OptionalInt.empty() : (T) OptionalInt.of(castToInt.intValue());
        } else if (type == OptionalLong.class) {
            Long castToLong = TypeUtils.castToLong(defaultJSONParser.parseObject((Class<Object>) Long.class));
            return castToLong == null ? (T) OptionalLong.empty() : (T) OptionalLong.of(castToLong.longValue());
        } else if (type == OptionalDouble.class) {
            Double castToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject((Class<Object>) Double.class));
            return castToDouble == null ? (T) OptionalDouble.empty() : (T) OptionalDouble.of(castToDouble.doubleValue());
        } else {
            Object parseObject = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
            return parseObject == null ? (T) Optional.empty() : (T) Optional.of(parseObject);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
        } else if (obj instanceof Optional) {
            jSONSerializer.write(((Optional) obj).get());
        } else if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                jSONSerializer.write(Double.valueOf(optionalDouble.getAsDouble()));
            } else {
                jSONSerializer.writeNull();
            }
        } else if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (!optionalInt.isPresent()) {
                jSONSerializer.writeNull();
                return;
            }
            jSONSerializer.out.writeInt(optionalInt.getAsInt());
        } else if (!(obj instanceof OptionalLong)) {
            throw new JSONException("not support optional : " + obj.getClass());
        } else {
            OptionalLong optionalLong = (OptionalLong) obj;
            if (!optionalLong.isPresent()) {
                jSONSerializer.writeNull();
                return;
            }
            jSONSerializer.out.writeLong(optionalLong.getAsLong());
        }
    }
}
