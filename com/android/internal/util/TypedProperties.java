package com.android.internal.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/TypedProperties.class */
public class TypedProperties extends HashMap<String, Object> {
    static final String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    public static final int STRING_NOT_SET = -1;
    public static final int STRING_NULL = 0;
    public static final int STRING_SET = 1;
    public static final int STRING_TYPE_MISMATCH = -2;
    static final int TYPE_BOOLEAN = 90;
    static final int TYPE_BYTE = 329;
    static final int TYPE_DOUBLE = 2118;
    static final int TYPE_ERROR = -1;
    static final int TYPE_FLOAT = 1094;
    static final int TYPE_INT = 1097;
    static final int TYPE_LONG = 2121;
    static final int TYPE_SHORT = 585;
    static final int TYPE_STRING = 29516;
    static final int TYPE_UNSET = 120;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/TypedProperties$ParseException.class */
    public static class ParseException extends IllegalArgumentException {
        ParseException(StreamTokenizer streamTokenizer, String str) {
            super("expected " + str + ", saw " + streamTokenizer.toString());
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/TypedProperties$TypeException.class */
    public static class TypeException extends IllegalArgumentException {
        TypeException(String str, Object obj, String str2) {
            super(str + " has type " + obj.getClass().getName() + ", not " + str2);
        }
    }

    static StreamTokenizer initTokenizer(Reader reader) {
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        streamTokenizer.resetSyntax();
        streamTokenizer.wordChars(48, 57);
        streamTokenizer.wordChars(65, 90);
        streamTokenizer.wordChars(97, 122);
        streamTokenizer.wordChars(95, 95);
        streamTokenizer.wordChars(36, 36);
        streamTokenizer.wordChars(46, 46);
        streamTokenizer.wordChars(45, 45);
        streamTokenizer.wordChars(43, 43);
        streamTokenizer.ordinaryChar(61);
        streamTokenizer.whitespaceChars(32, 32);
        streamTokenizer.whitespaceChars(9, 9);
        streamTokenizer.whitespaceChars(10, 10);
        streamTokenizer.whitespaceChars(13, 13);
        streamTokenizer.quoteChar(34);
        streamTokenizer.slashStarComments(true);
        streamTokenizer.slashSlashComments(true);
        return streamTokenizer;
    }

    static int interpretType(String str) {
        if ("unset".equals(str)) {
            return 120;
        }
        if ("boolean".equals(str)) {
            return 90;
        }
        if ("byte".equals(str)) {
            return TYPE_BYTE;
        }
        if ("short".equals(str)) {
            return TYPE_SHORT;
        }
        if ("int".equals(str)) {
            return TYPE_INT;
        }
        if ("long".equals(str)) {
            return TYPE_LONG;
        }
        if ("float".equals(str)) {
            return TYPE_FLOAT;
        }
        if ("double".equals(str)) {
            return TYPE_DOUBLE;
        }
        if ("String".equals(str)) {
            return TYPE_STRING;
        }
        return -1;
    }

    static void parse(Reader reader, Map<String, Object> map) throws ParseException, IOException {
        StreamTokenizer initTokenizer = initTokenizer(reader);
        Pattern compile = Pattern.compile("([a-zA-Z_$][0-9a-zA-Z_$]*\\.)*[a-zA-Z_$][0-9a-zA-Z_$]*");
        do {
            int nextToken = initTokenizer.nextToken();
            if (nextToken == -1) {
                return;
            }
            if (nextToken != -3) {
                throw new ParseException(initTokenizer, "type name");
            }
            int interpretType = interpretType(initTokenizer.sval);
            if (interpretType == -1) {
                throw new ParseException(initTokenizer, "valid type name");
            }
            initTokenizer.sval = null;
            if (interpretType == 120 && initTokenizer.nextToken() != 40) {
                throw new ParseException(initTokenizer, "'('");
            }
            if (initTokenizer.nextToken() != -3) {
                throw new ParseException(initTokenizer, "property name");
            }
            String str = initTokenizer.sval;
            if (!compile.matcher(str).matches()) {
                throw new ParseException(initTokenizer, "valid property name");
            }
            initTokenizer.sval = null;
            if (interpretType == 120) {
                if (initTokenizer.nextToken() != 41) {
                    throw new ParseException(initTokenizer, "')'");
                }
                map.remove(str);
            } else if (initTokenizer.nextToken() != 61) {
                throw new ParseException(initTokenizer, "'='");
            } else {
                Object parseValue = parseValue(initTokenizer, interpretType);
                Object remove = map.remove(str);
                if (remove != null && parseValue.getClass() != remove.getClass()) {
                    throw new ParseException(initTokenizer, "(property previously declared as a different type)");
                }
                map.put(str, parseValue);
            }
        } while (initTokenizer.nextToken() == 59);
        throw new ParseException(initTokenizer, "';'");
    }

    static Object parseValue(StreamTokenizer streamTokenizer, int i) throws IOException {
        int nextToken = streamTokenizer.nextToken();
        if (i == 90) {
            if (nextToken != -3) {
                throw new ParseException(streamTokenizer, "boolean constant");
            }
            if ("true".equals(streamTokenizer.sval)) {
                return Boolean.TRUE;
            }
            if ("false".equals(streamTokenizer.sval)) {
                return Boolean.FALSE;
            }
            throw new ParseException(streamTokenizer, "boolean constant");
        } else if ((i & 255) == 73) {
            if (nextToken != -3) {
                throw new ParseException(streamTokenizer, "integer constant");
            }
            try {
                long longValue = Long.decode(streamTokenizer.sval).longValue();
                int i2 = (i >> 8) & 255;
                switch (i2) {
                    case 1:
                        if (longValue < -128 || longValue > 127) {
                            throw new ParseException(streamTokenizer, "8-bit integer constant");
                        }
                        return new Byte((byte) longValue);
                    case 2:
                        if (longValue < -32768 || longValue > 32767) {
                            throw new ParseException(streamTokenizer, "16-bit integer constant");
                        }
                        return new Short((short) longValue);
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        throw new IllegalStateException("Internal error; unexpected integer type width " + i2);
                    case 4:
                        if (longValue < -2147483648L || longValue > 2147483647L) {
                            throw new ParseException(streamTokenizer, "32-bit integer constant");
                        }
                        return new Integer((int) longValue);
                    case 8:
                        if (longValue < Long.MIN_VALUE || longValue > Long.MAX_VALUE) {
                            throw new ParseException(streamTokenizer, "64-bit integer constant");
                        }
                        return new Long(longValue);
                }
            } catch (NumberFormatException e) {
                throw new ParseException(streamTokenizer, "integer constant");
            }
        } else if ((i & 255) != 70) {
            if (i == TYPE_STRING) {
                if (nextToken == 34) {
                    return streamTokenizer.sval;
                }
                if (nextToken == -3 && "null".equals(streamTokenizer.sval)) {
                    return NULL_STRING;
                }
                throw new ParseException(streamTokenizer, "double-quoted string or 'null'");
            }
            throw new IllegalStateException("Internal error; unknown type " + i);
        } else if (nextToken != -3) {
            throw new ParseException(streamTokenizer, "float constant");
        } else {
            try {
                double parseDouble = Double.parseDouble(streamTokenizer.sval);
                if (((i >> 8) & 255) == 4) {
                    double abs = Math.abs(parseDouble);
                    if (abs == 0.0d || Double.isInfinite(parseDouble) || Double.isNaN(parseDouble) || (abs >= 1.401298464324817E-45d && abs <= 3.4028234663852886E38d)) {
                        return new Float((float) parseDouble);
                    }
                    throw new ParseException(streamTokenizer, "32-bit float constant");
                }
                return new Double(parseDouble);
            } catch (NumberFormatException e2) {
                throw new ParseException(streamTokenizer, "float constant");
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Object obj2 = super.get(obj);
        Object obj3 = obj2;
        if (obj2 == NULL_STRING) {
            obj3 = null;
        }
        return obj3;
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = super.get(str);
        if (obj == null) {
            return z;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        throw new TypeException(str, obj, "boolean");
    }

    public byte getByte(String str) {
        return getByte(str, (byte) 0);
    }

    public byte getByte(String str, byte b) {
        Object obj = super.get(str);
        if (obj == null) {
            return b;
        }
        if (obj instanceof Byte) {
            return ((Byte) obj).byteValue();
        }
        throw new TypeException(str, obj, "byte");
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        Object obj = super.get(str);
        if (obj == null) {
            return d;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        throw new TypeException(str, obj, "double");
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public float getFloat(String str, float f) {
        Object obj = super.get(str);
        if (obj == null) {
            return f;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        throw new TypeException(str, obj, "float");
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        Object obj = super.get(str);
        if (obj == null) {
            return i;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        throw new TypeException(str, obj, "int");
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        Object obj = super.get(str);
        if (obj == null) {
            return j;
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        throw new TypeException(str, obj, "long");
    }

    public short getShort(String str) {
        return getShort(str, (short) 0);
    }

    public short getShort(String str, short s) {
        Object obj = super.get(str);
        if (obj == null) {
            return s;
        }
        if (obj instanceof Short) {
            return ((Short) obj).shortValue();
        }
        throw new TypeException(str, obj, "short");
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getString(String str, String str2) {
        Object obj = super.get(str);
        if (obj == null) {
            return str2;
        }
        if (obj == NULL_STRING) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new TypeException(str, obj, "string");
    }

    public int getStringInfo(String str) {
        Object obj = super.get(str);
        if (obj == null) {
            return -1;
        }
        if (obj == NULL_STRING) {
            return 0;
        }
        return obj instanceof String ? 1 : -2;
    }

    public void load(Reader reader) throws IOException {
        parse(reader, this);
    }
}
