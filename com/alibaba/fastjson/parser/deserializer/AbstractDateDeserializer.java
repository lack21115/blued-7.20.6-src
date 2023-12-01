package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/parser/deserializer/AbstractDateDeserializer.class */
public abstract class AbstractDateDeserializer implements ObjectDeserializer {
    protected abstract <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Long parse;
        Type type2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            parse = Long.valueOf(jSONLexer.longValue());
            jSONLexer.nextToken(16);
            type2 = type;
        } else if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            parse = stringVal;
            type2 = type;
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                parse = stringVal;
                if (jSONScanner.scanISO8601DateIfMatch()) {
                    parse = jSONScanner.getCalendar().getTime();
                }
                jSONScanner.close();
                type2 = type;
            }
        } else if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            parse = null;
            type2 = type;
        } else if (jSONLexer.token() == 12) {
            jSONLexer.nextToken();
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            Type type3 = type;
            if (JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                defaultJSONParser.accept(17);
                Class<?> loadClass = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.getConfig().getDefaultClassLoader());
                if (loadClass != null) {
                    type = loadClass;
                }
                defaultJSONParser.accept(4);
                defaultJSONParser.accept(16);
                type3 = type;
            }
            jSONLexer.nextTokenWithColon(2);
            if (jSONLexer.token() != 2) {
                throw new JSONException("syntax error : " + jSONLexer.tokenName());
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken();
            parse = Long.valueOf(longValue);
            defaultJSONParser.accept(13);
            type2 = type3;
        } else if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
            defaultJSONParser.accept(16);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            if (!"val".equals(jSONLexer.stringVal())) {
                throw new JSONException("syntax error");
            }
            jSONLexer.nextToken();
            defaultJSONParser.accept(17);
            parse = defaultJSONParser.parse();
            defaultJSONParser.accept(13);
            type2 = type;
        } else {
            parse = defaultJSONParser.parse();
            type2 = type;
        }
        return (T) cast(defaultJSONParser, type2, obj, parse);
    }
}
