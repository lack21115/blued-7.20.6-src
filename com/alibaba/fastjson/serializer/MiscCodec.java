package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/MiscCodec.class */
public class MiscCodec implements ObjectDeserializer, ObjectSerializer {
    public static final MiscCodec instance = new MiscCodec();

    /* JADX WARN: Type inference failed for: r0v55, types: [T, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parse;
        String str;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = 0;
        if (type != InetSocketAddress.class) {
            if (defaultJSONParser.resolveStatus == 2) {
                defaultJSONParser.resolveStatus = 0;
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
            } else {
                parse = defaultJSONParser.parse();
            }
            if (parse == null) {
                str = null;
            } else if (!(parse instanceof String)) {
                throw new JSONException("expect string");
            } else {
                str = (String) parse;
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e) {
                    throw new JSONException("create url error", e);
                }
            } else if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            } else {
                if (type == Locale.class) {
                    String[] split = str.split(BridgeUtil.UNDERLINE_STR);
                    return split.length == 1 ? (T) new Locale(split[0]) : split.length == 2 ? (T) new Locale(split[0], split[1]) : (T) new Locale(split[0], split[1], split[2]);
                } else if (type == SimpleDateFormat.class) {
                    ?? r0 = (T) new SimpleDateFormat(str, jSONLexer.getLocale());
                    r0.setTimeZone(jSONLexer.getTimeZone());
                    return r0;
                } else if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                    try {
                        return (T) InetAddress.getByName(str);
                    } catch (UnknownHostException e2) {
                        throw new JSONException("deserialize inet adress error", e2);
                    }
                } else if (type == File.class) {
                    return (T) new File(str);
                } else {
                    if (type == TimeZone.class) {
                        return (T) TimeZone.getTimeZone(str);
                    }
                    Type type2 = type;
                    if (type instanceof ParameterizedType) {
                        type2 = ((ParameterizedType) type).getRawType();
                    }
                    if (type2 == Class.class) {
                        return (T) TypeUtils.loadClass(str, defaultJSONParser.getConfig().getDefaultClassLoader());
                    }
                    throw new JSONException("MiscCodec not support " + type2);
                }
            }
        } else if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else {
            defaultJSONParser.accept(12);
            InetAddress inetAddress = null;
            while (true) {
                String stringVal = jSONLexer.stringVal();
                jSONLexer.nextToken(17);
                if (stringVal.equals("address")) {
                    defaultJSONParser.accept(17);
                    inetAddress = (InetAddress) defaultJSONParser.parseObject((Class<Object>) InetAddress.class);
                } else if (stringVal.equals("port")) {
                    defaultJSONParser.accept(17);
                    if (jSONLexer.token() != 2) {
                        throw new JSONException("port is not int");
                    }
                    i = jSONLexer.intValue();
                    jSONLexer.nextToken();
                } else {
                    defaultJSONParser.accept(17);
                    defaultJSONParser.parse();
                }
                if (jSONLexer.token() != 16) {
                    defaultJSONParser.accept(13);
                    return (T) new InetSocketAddress(inetAddress, i);
                }
                jSONLexer.nextToken();
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        String obj3;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            String pattern = ((SimpleDateFormat) obj).toPattern();
            obj3 = pattern;
            if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                obj3 = pattern;
                if (obj.getClass() != type) {
                    serializeWriter.write(123);
                    serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                    jSONSerializer.write(obj.getClass().getName());
                    serializeWriter.writeFieldValue(',', "val", pattern);
                    serializeWriter.write(125);
                    return;
                }
            }
        } else if (cls == Class.class) {
            obj3 = ((Class) obj).getName();
        } else if (cls == InetSocketAddress.class) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
            InetAddress address = inetSocketAddress.getAddress();
            serializeWriter.write(123);
            if (address != null) {
                serializeWriter.writeFieldName("address");
                jSONSerializer.write(address);
                serializeWriter.write(44);
            }
            serializeWriter.writeFieldName("port");
            serializeWriter.writeInt(inetSocketAddress.getPort());
            serializeWriter.write(125);
            return;
        } else if (obj instanceof File) {
            obj3 = ((File) obj).getPath();
        } else if (obj instanceof InetAddress) {
            obj3 = ((InetAddress) obj).getHostAddress();
        } else if (obj instanceof TimeZone) {
            obj3 = ((TimeZone) obj).getID();
        } else if (obj instanceof JSONStreamAware) {
            ((JSONStreamAware) obj).writeJSONString(serializeWriter);
            return;
        } else if (obj instanceof Iterator) {
            writeIterator(jSONSerializer, serializeWriter, (Iterator) obj);
            return;
        } else if (obj instanceof Iterable) {
            writeIterator(jSONSerializer, serializeWriter, ((Iterable) obj).iterator());
            return;
        } else {
            obj3 = obj.toString();
        }
        serializeWriter.writeString(obj3);
    }

    protected void writeIterator(JSONSerializer jSONSerializer, SerializeWriter serializeWriter, Iterator<?> it) {
        serializeWriter.write(91);
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                serializeWriter.write(93);
                return;
            }
            if (i2 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(it.next());
            i = i2 + 1;
        }
    }
}
