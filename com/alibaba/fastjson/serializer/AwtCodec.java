package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.amap.api.col.p0003sl.iu;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.g;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/AwtCodec.class */
public class AwtCodec implements ObjectDeserializer, ObjectSerializer {
    public static final AwtCodec instance = new AwtCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            jSONLexer.nextToken();
            if (type == Point.class) {
                return (T) parsePoint(defaultJSONParser);
            }
            if (type == Rectangle.class) {
                return (T) parseRectangle(defaultJSONParser);
            }
            if (type == Color.class) {
                return (T) parseColor(defaultJSONParser);
            }
            if (type == Font.class) {
                return (T) parseFont(defaultJSONParser);
            }
            throw new JSONException("not support awt class : " + type);
        } else {
            throw new JSONException("syntax error");
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    protected Color parseColor(DefaultJSONParser defaultJSONParser) {
        int i;
        int i2;
        int i3;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextTokenWithColon(2);
            if (jSONLexer.token() != 2) {
                throw new JSONException("syntax error");
            }
            int intValue = jSONLexer.intValue();
            jSONLexer.nextToken();
            if (stringVal.equalsIgnoreCase(g.o.o)) {
                i3 = i5;
                i2 = i6;
                i = i7;
            } else if (stringVal.equalsIgnoreCase(iu.f)) {
                i3 = intValue;
                intValue = i4;
                i2 = i6;
                i = i7;
            } else if (stringVal.equalsIgnoreCase("b")) {
                i2 = intValue;
                intValue = i4;
                i3 = i5;
                i = i7;
            } else if (!stringVal.equalsIgnoreCase("alpha")) {
                throw new JSONException("syntax error, " + stringVal);
            } else {
                i = intValue;
                i2 = i6;
                i3 = i5;
                intValue = i4;
            }
            i4 = intValue;
            i5 = i3;
            i6 = i2;
            i7 = i;
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(4);
                i4 = intValue;
                i5 = i3;
                i6 = i2;
                i7 = i;
            }
        }
        jSONLexer.nextToken();
        return new Color(i4, i5, i6, i7);
    }

    protected Font parseFont(DefaultJSONParser defaultJSONParser) {
        int intValue;
        String str;
        int i;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextTokenWithColon(2);
            if (stringVal.equalsIgnoreCase("name")) {
                if (jSONLexer.token() != 4) {
                    throw new JSONException("syntax error");
                }
                str = jSONLexer.stringVal();
                jSONLexer.nextToken();
                i = i2;
                intValue = i3;
            } else if (stringVal.equalsIgnoreCase("style")) {
                if (jSONLexer.token() != 2) {
                    throw new JSONException("syntax error");
                }
                i = jSONLexer.intValue();
                jSONLexer.nextToken();
                intValue = i3;
                str = str2;
            } else if (!stringVal.equalsIgnoreCase(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) {
                throw new JSONException("syntax error, " + stringVal);
            } else if (jSONLexer.token() != 2) {
                throw new JSONException("syntax error");
            } else {
                intValue = jSONLexer.intValue();
                jSONLexer.nextToken();
                str = str2;
                i = i2;
            }
            i2 = i;
            i3 = intValue;
            str2 = str;
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(4);
                i2 = i;
                i3 = intValue;
                str2 = str;
            }
        }
        jSONLexer.nextToken();
        return new Font(str2, i2, i3);
    }

    protected Point parsePoint(DefaultJSONParser defaultJSONParser) {
        int i;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = 0;
        int i3 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            if (JSON.DEFAULT_TYPE_KEY.equals(stringVal)) {
                defaultJSONParser.acceptType("java.awt.Point");
            } else {
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() != 2) {
                    throw new JSONException("syntax error : " + jSONLexer.tokenName());
                }
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken();
                if (stringVal.equalsIgnoreCase("x")) {
                    i = i3;
                } else if (!stringVal.equalsIgnoreCase("y")) {
                    throw new JSONException("syntax error, " + stringVal);
                } else {
                    i = intValue;
                    intValue = i2;
                }
                i2 = intValue;
                i3 = i;
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                    i2 = intValue;
                    i3 = i;
                }
            }
        }
        jSONLexer.nextToken();
        return new Point(i2, i3);
    }

    protected Rectangle parseRectangle(DefaultJSONParser defaultJSONParser) {
        int i;
        int i2;
        int i3;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextTokenWithColon(2);
            if (jSONLexer.token() != 2) {
                throw new JSONException("syntax error");
            }
            int intValue = jSONLexer.intValue();
            jSONLexer.nextToken();
            if (stringVal.equalsIgnoreCase("x")) {
                i3 = i5;
                i2 = i6;
                i = i7;
            } else if (stringVal.equalsIgnoreCase("y")) {
                i3 = intValue;
                intValue = i4;
                i2 = i6;
                i = i7;
            } else if (stringVal.equalsIgnoreCase("width")) {
                i2 = intValue;
                intValue = i4;
                i3 = i5;
                i = i7;
            } else if (!stringVal.equalsIgnoreCase("height")) {
                throw new JSONException("syntax error, " + stringVal);
            } else {
                i = intValue;
                i2 = i6;
                i3 = i5;
                intValue = i4;
            }
            i4 = intValue;
            i5 = i3;
            i6 = i2;
            i7 = i;
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken(4);
                i4 = intValue;
                i5 = i3;
                i6 = i2;
                i7 = i;
            }
        }
        jSONLexer.nextToken();
        return new Rectangle(i4, i5, i6, i7);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Point.class, '{'), "x", point.getX());
            serializeWriter.writeFieldValue(',', "y", point.getY());
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Font.class, '{'), "name", font.getName());
            serializeWriter.writeFieldValue(',', "style", font.getStyle());
            serializeWriter.writeFieldValue(',', ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Rectangle.class, '{'), "x", rectangle.getX());
            serializeWriter.writeFieldValue(',', "y", rectangle.getY());
            serializeWriter.writeFieldValue(',', "width", rectangle.getWidth());
            serializeWriter.writeFieldValue(',', "height", rectangle.getHeight());
        } else if (!(obj instanceof Color)) {
            throw new JSONException("not support awt class : " + obj.getClass().getName());
        } else {
            Color color = (Color) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, Color.class, '{'), g.o.o, color.getRed());
            serializeWriter.writeFieldValue(',', iu.f, color.getGreen());
            serializeWriter.writeFieldValue(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                serializeWriter.writeFieldValue(',', "alpha", color.getAlpha());
            }
        }
        serializeWriter.write(125);
    }

    protected char writeClassName(SerializeWriter serializeWriter, Class<?> cls, char c) {
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            serializeWriter.write(123);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            serializeWriter.writeString(cls.getName());
            c = ',';
        }
        return c;
    }
}
