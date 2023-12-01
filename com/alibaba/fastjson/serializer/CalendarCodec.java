package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.google.android.material.timepicker.TimeModel;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/CalendarCodec.class */
public class CalendarCodec implements ObjectDeserializer, ObjectSerializer {
    public static final CalendarCodec instance = new CalendarCodec();

    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Calendar, T] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t = (T) DateCodec.instance.deserialze(defaultJSONParser, type, obj);
        if (t instanceof Calendar) {
            return t;
        }
        Date date = (Date) t;
        if (date == null) {
            return null;
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        ?? r0 = (T) Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
        r0.setTime(date);
        return r0;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        char[] charArray;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Calendar calendar = (Calendar) obj;
        if (!serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
            jSONSerializer.write(calendar.getTime());
            return;
        }
        char c2 = serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
        serializeWriter.append(c2);
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        int i7 = calendar.get(13);
        int i8 = calendar.get(14);
        if (i8 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            IOUtils.getChars(i8, 23, charArray);
            IOUtils.getChars(i7, 19, charArray);
            IOUtils.getChars(i6, 16, charArray);
            IOUtils.getChars(i5, 13, charArray);
            IOUtils.getChars(i4, 10, charArray);
            IOUtils.getChars(i3, 7, charArray);
            IOUtils.getChars(i2, 4, charArray);
        } else if (i7 == 0 && i6 == 0 && i5 == 0) {
            charArray = "0000-00-00".toCharArray();
            IOUtils.getChars(i4, 10, charArray);
            IOUtils.getChars(i3, 7, charArray);
            IOUtils.getChars(i2, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            IOUtils.getChars(i7, 19, charArray);
            IOUtils.getChars(i6, 16, charArray);
            IOUtils.getChars(i5, 13, charArray);
            IOUtils.getChars(i4, 10, charArray);
            IOUtils.getChars(i3, 7, charArray);
            IOUtils.getChars(i2, 4, charArray);
        }
        serializeWriter.write(charArray);
        int rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
        if (rawOffset == 0) {
            serializeWriter.append((CharSequence) "Z");
        } else if (rawOffset > 0) {
            serializeWriter.append((CharSequence) "+").append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(rawOffset))).append((CharSequence) ":00");
        } else {
            serializeWriter.append((CharSequence) "-").append((CharSequence) String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(-rawOffset))).append((CharSequence) ":00");
        }
        serializeWriter.append(c2);
    }
}
