package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.android.dex.DexFormat;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/CharacterCodec.class */
public class CharacterCodec implements ObjectDeserializer, ObjectSerializer {
    public static final CharacterCodec instance = new CharacterCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parse = defaultJSONParser.parse();
        if (parse == null) {
            return null;
        }
        return (T) TypeUtils.castToChar(parse);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Character ch = (Character) obj;
        if (ch == null) {
            serializeWriter.writeString("");
        } else if (ch.charValue() == 0) {
            serializeWriter.writeString(DexFormat.MAGIC_SUFFIX);
        } else {
            serializeWriter.writeString(ch.toString());
        }
    }
}
