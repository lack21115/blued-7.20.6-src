package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/NumberDeserializer.class */
public class NumberDeserializer implements ObjectDeserializer {
    public static final NumberDeserializer instance = new NumberDeserializer();

    /* JADX WARN: Type inference failed for: r0v33, types: [java.math.BigDecimal, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf((short) longValue) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf((byte) longValue) : (longValue < -2147483648L || longValue > 2147483647L) ? (T) Long.valueOf(longValue) : (T) Integer.valueOf((int) longValue);
        } else if (jSONLexer.token() != 3) {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (type == Double.TYPE || type == Double.class) ? (T) TypeUtils.castToDouble(parse) : (type == Short.TYPE || type == Short.class) ? (T) TypeUtils.castToShort(parse) : (type == Byte.TYPE || type == Byte.class) ? (T) TypeUtils.castToByte(parse) : (T) TypeUtils.castToBigDecimal(parse);
        } else if (type == Double.TYPE || type == Double.class) {
            String numberString2 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString2));
        } else {
            ?? r0 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf(r0.shortValue()) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r0.byteValue()) : r0;
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }
}
