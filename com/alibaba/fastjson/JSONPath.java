package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ASMJavaBeanSerializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.core.api.ATAdConst;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath.class */
public class JSONPath implements JSONAware {
    private static int CACHE_SIZE = 1024;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private ParserConfig parserConfig;
    private final String path;
    private Segement[] segments;
    private SerializeConfig serializeConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$ArrayAccessSegement.class */
    public static class ArrayAccessSegement implements Segement {
        private final int index;

        public ArrayAccessSegement(int i) {
            this.index = i;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$Filter.class */
    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$FilterSegement.class */
    public static class FilterSegement implements Segement {
        private final Filter filter;

        public FilterSegement(Filter filter) {
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            if (!(obj2 instanceof Iterable)) {
                if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                    return obj2;
                }
                return null;
            }
            for (Object obj3 : (Iterable) obj2) {
                if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                    arrayList.add(obj3);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$IntBetweenSegement.class */
    public static class IntBetweenSegement implements Filter {
        private final long endValue;
        private final boolean not;
        private final String propertyName;
        private final long startValue;

        public IntBetweenSegement(String str, long j, long j2, boolean z) {
            this.propertyName = str;
            this.startValue = j;
            this.endValue = j2;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                if (longValue >= this.startValue && longValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$IntInSegement.class */
    public static class IntInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final long[] values;

        public IntInSegement(String str, long[] jArr, boolean z) {
            this.propertyName = str;
            this.values = jArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                for (long j : this.values) {
                    if (j == longValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$IntObjInSegement.class */
    public static class IntObjInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final Long[] values;

        public IntObjInSegement(String str, Long[] lArr, boolean z) {
            this.propertyName = str;
            this.values = lArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                for (Long l : this.values) {
                    if (l == null) {
                        return !this.not;
                    }
                }
                return this.not;
            }
            if (propertyValue instanceof Number) {
                long longValue = ((Number) propertyValue).longValue();
                Long[] lArr = this.values;
                int length = lArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Long l2 = lArr[i2];
                    if (l2 != null && l2.longValue() == longValue) {
                        return !this.not;
                    }
                    i = i2 + 1;
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$IntOpSegement.class */
    public static class IntOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final long value;

        public IntOpSegement(String str, long j, Operator operator) {
            this.propertyName = str;
            this.value = j;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean z = false;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue != null && (propertyValue instanceof Number)) {
                long longValue = ((Number) propertyValue).longValue();
                if (this.op == Operator.EQ) {
                    if (longValue == this.value) {
                        z = true;
                    }
                    return z;
                } else if (this.op == Operator.NE) {
                    boolean z2 = false;
                    if (longValue != this.value) {
                        z2 = true;
                    }
                    return z2;
                } else if (this.op == Operator.GE) {
                    boolean z3 = false;
                    if (longValue >= this.value) {
                        z3 = true;
                    }
                    return z3;
                } else if (this.op == Operator.GT) {
                    boolean z4 = false;
                    if (longValue > this.value) {
                        z4 = true;
                    }
                    return z4;
                } else if (this.op == Operator.LE) {
                    boolean z5 = false;
                    if (longValue <= this.value) {
                        z5 = true;
                    }
                    return z5;
                } else {
                    boolean z6 = false;
                    if (this.op == Operator.LT) {
                        z6 = false;
                        if (longValue < this.value) {
                            z6 = true;
                        }
                    }
                    return z6;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$JSONPathParser.class */
    public static class JSONPathParser {
        private char ch;
        private int level;
        private final String path;
        private int pos;

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        static boolean isDigitFirst(char c) {
            if (c == '-' || c == '+') {
                return true;
            }
            return c >= '0' && c <= '9';
        }

        void accept(char c) {
            if (this.ch == c) {
                if (isEOF()) {
                    return;
                }
                next();
                return;
            }
            throw new JSONPathException("expect '" + c + ", but '" + this.ch + "'");
        }

        Segement buildArraySegement(String str) {
            int length = str.length();
            char charAt = str.charAt(0);
            int i = length - 1;
            char charAt2 = str.charAt(i);
            int indexOf = str.indexOf(44);
            if (str.length() <= 2 || charAt != '\'' || charAt2 != '\'') {
                int indexOf2 = str.indexOf(58);
                if (indexOf == -1 && indexOf2 == -1) {
                    return new ArrayAccessSegement(Integer.parseInt(str));
                }
                if (indexOf != -1) {
                    String[] split = str.split(",");
                    int[] iArr = new int[split.length];
                    for (int i2 = 0; i2 < split.length; i2++) {
                        iArr[i2] = Integer.parseInt(split[i2]);
                    }
                    return new MultiIndexSegement(iArr);
                } else if (indexOf2 == -1) {
                    throw new UnsupportedOperationException();
                } else {
                    String[] split2 = str.split(":");
                    int length2 = split2.length;
                    int[] iArr2 = new int[length2];
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= split2.length) {
                            int i5 = iArr2[0];
                            int i6 = length2 > 1 ? iArr2[1] : -1;
                            int i7 = length2 == 3 ? iArr2[2] : 1;
                            if (i6 < 0 || i6 >= i5) {
                                if (i7 > 0) {
                                    return new RangeSegement(i5, i6, i7);
                                }
                                throw new UnsupportedOperationException("step must greater than zero : " + i7);
                            }
                            throw new UnsupportedOperationException("end must greater than or equals start. start " + i5 + ",  end " + i6);
                        }
                        String str2 = split2[i4];
                        if (!str2.isEmpty()) {
                            iArr2[i4] = Integer.parseInt(str2);
                        } else if (i4 != 0) {
                            throw new UnsupportedOperationException();
                        } else {
                            iArr2[i4] = 0;
                        }
                        i3 = i4 + 1;
                    }
                }
            } else if (indexOf == -1) {
                return new PropertySegement(str.substring(1, i));
            } else {
                String[] split3 = str.split(",");
                String[] strArr = new String[split3.length];
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i9 >= split3.length) {
                        return new MultiPropertySegement(strArr);
                    }
                    String str3 = split3[i9];
                    strArr[i9] = str3.substring(1, str3.length() - 1);
                    i8 = i9 + 1;
                }
            }
        }

        public Segement[] explain() {
            String str = this.path;
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException();
            }
            Segement[] segementArr = new Segement[8];
            while (true) {
                Segement readSegement = readSegement();
                if (readSegement == null) {
                    break;
                }
                int i = this.level;
                this.level = i + 1;
                segementArr[i] = readSegement;
            }
            int i2 = this.level;
            if (i2 == 8) {
                return segementArr;
            }
            Segement[] segementArr2 = new Segement[i2];
            System.arraycopy(segementArr, 0, segementArr2, 0, i2);
            return segementArr2;
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        Segement parseArrayAccess(boolean z) {
            boolean z2;
            String str;
            Operator operator;
            int i;
            int i2;
            if (z) {
                accept('[');
            }
            if (this.ch == '?') {
                next();
                accept('(');
                if (this.ch == '@') {
                    next();
                    accept('.');
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !IOUtils.firstIdentifier(this.ch)) {
                int i3 = this.pos;
                while (true) {
                    char c = this.ch;
                    if (c == ']' || c == '/' || isEOF()) {
                        break;
                    }
                    next();
                }
                if (z) {
                    i2 = this.pos;
                } else if (this.ch != '/') {
                    i = this.pos;
                    Segement buildArraySegement = buildArraySegement(this.path.substring(i3 - 1, i));
                    if (z && !isEOF()) {
                        accept(']');
                    }
                    return buildArraySegement;
                } else {
                    i2 = this.pos;
                }
                i = i2 - 1;
                Segement buildArraySegement2 = buildArraySegement(this.path.substring(i3 - 1, i));
                if (z) {
                    accept(']');
                }
                return buildArraySegement2;
            }
            String readName = readName();
            skipWhitespace();
            if (z2 && this.ch == ')') {
                next();
                if (z) {
                    accept(']');
                }
                return new FilterSegement(new NotNullSegement(readName));
            } else if (z && this.ch == ']') {
                next();
                return new FilterSegement(new NotNullSegement(readName));
            } else {
                Operator readOp = readOp();
                skipWhitespace();
                if (readOp == Operator.BETWEEN || readOp == Operator.NOT_BETWEEN) {
                    boolean z3 = readOp == Operator.NOT_BETWEEN;
                    Object readValue = readValue();
                    if ("and".equalsIgnoreCase(readName())) {
                        Object readValue2 = readValue();
                        if (readValue == null || readValue2 == null) {
                            throw new JSONPathException(this.path);
                        }
                        if (JSONPath.isInt(readValue.getClass()) && JSONPath.isInt(readValue2.getClass())) {
                            return new FilterSegement(new IntBetweenSegement(readName, ((Number) readValue).longValue(), ((Number) readValue2).longValue(), z3));
                        }
                        throw new JSONPathException(this.path);
                    }
                    throw new JSONPathException(this.path);
                } else if (readOp != Operator.IN && readOp != Operator.NOT_IN) {
                    char c2 = this.ch;
                    if (c2 != '\'' && c2 != '\"') {
                        if (isDigitFirst(c2)) {
                            long readLongValue = readLongValue();
                            if (z2) {
                                accept(')');
                            }
                            if (z) {
                                accept(']');
                            }
                            return new FilterSegement(new IntOpSegement(readName, readLongValue, readOp));
                        } else if (this.ch == 'n' && "null".equals(readName())) {
                            if (z2) {
                                accept(')');
                            }
                            accept(']');
                            if (readOp == Operator.EQ) {
                                return new FilterSegement(new NullSegement(readName));
                            }
                            if (readOp == Operator.NE) {
                                return new FilterSegement(new NotNullSegement(readName));
                            }
                            throw new UnsupportedOperationException();
                        } else {
                            throw new UnsupportedOperationException();
                        }
                    }
                    String readString = readString();
                    if (z2) {
                        accept(')');
                    }
                    if (z) {
                        accept(']');
                    }
                    if (readOp == Operator.RLIKE) {
                        return new FilterSegement(new RlikeSegement(readName, readString, false));
                    }
                    if (readOp == Operator.NOT_RLIKE) {
                        return new FilterSegement(new RlikeSegement(readName, readString, true));
                    }
                    String str2 = readString;
                    if (readOp != Operator.LIKE) {
                        str2 = readString;
                        operator = readOp;
                        if (readOp == Operator.NOT_LIKE) {
                            str2 = readString;
                        }
                        return new FilterSegement(new StringOpSegement(readName, str2, operator));
                    }
                    while (str2.indexOf("%%") != -1) {
                        str2 = str2.replaceAll("%%", "%");
                    }
                    boolean z4 = readOp == Operator.NOT_LIKE;
                    int indexOf = str2.indexOf(37);
                    if (indexOf == -1) {
                        operator = readOp == Operator.LIKE ? Operator.EQ : Operator.NE;
                        return new FilterSegement(new StringOpSegement(readName, str2, operator));
                    }
                    String[] split = str2.split("%");
                    String str3 = null;
                    if (indexOf == 0) {
                        if (str2.charAt(str2.length() - 1) == '%') {
                            int length = split.length - 1;
                            String[] strArr = new String[length];
                            System.arraycopy(split, 1, strArr, 0, length);
                            split = strArr;
                            str = null;
                            return new FilterSegement(new MatchSegement(readName, str, str3, split, z4));
                        }
                        str3 = split[split.length - 1];
                        if (split.length > 2) {
                            int length2 = split.length - 2;
                            String[] strArr2 = new String[length2];
                            System.arraycopy(split, 1, strArr2, 0, length2);
                            split = strArr2;
                        } else {
                            split = null;
                        }
                        str = null;
                        return new FilterSegement(new MatchSegement(readName, str, str3, split, z4));
                    }
                    if (str2.charAt(str2.length() - 1) != '%') {
                        if (split.length == 1) {
                            str = split[0];
                            split = null;
                        } else if (split.length == 2) {
                            str = split[0];
                            str3 = split[1];
                            split = null;
                        } else {
                            str = split[0];
                            str3 = split[split.length - 1];
                            int length3 = split.length - 2;
                            String[] strArr3 = new String[length3];
                            System.arraycopy(split, 1, strArr3, 0, length3);
                            split = strArr3;
                        }
                        return new FilterSegement(new MatchSegement(readName, str, str3, split, z4));
                    }
                    str = null;
                    return new FilterSegement(new MatchSegement(readName, str, str3, split, z4));
                } else {
                    boolean z5 = readOp == Operator.NOT_IN;
                    accept('(');
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(readValue());
                    while (true) {
                        skipWhitespace();
                        if (this.ch != ',') {
                            break;
                        }
                        next();
                        arrayList.add(readValue());
                    }
                    accept(')');
                    if (z2) {
                        accept(')');
                    }
                    if (z) {
                        accept(']');
                    }
                    boolean z6 = true;
                    boolean z7 = true;
                    boolean z8 = true;
                    for (Object obj : arrayList) {
                        if (obj != null) {
                            Class<?> cls = obj.getClass();
                            boolean z9 = z6;
                            boolean z10 = z8;
                            if (z6) {
                                z9 = z6;
                                z10 = z8;
                                if (cls != Byte.class) {
                                    z9 = z6;
                                    z10 = z8;
                                    if (cls != Short.class) {
                                        z9 = z6;
                                        z10 = z8;
                                        if (cls != Integer.class) {
                                            z9 = z6;
                                            z10 = z8;
                                            if (cls != Long.class) {
                                                z9 = false;
                                                z10 = false;
                                            }
                                        }
                                    }
                                }
                            }
                            z6 = z9;
                            z8 = z10;
                            if (z7) {
                                z6 = z9;
                                z8 = z10;
                                if (cls != String.class) {
                                    z7 = false;
                                    z6 = z9;
                                    z8 = z10;
                                }
                            }
                        } else if (z6) {
                            z6 = false;
                        }
                    }
                    if (arrayList.size() == 1 && arrayList.get(0) == 0) {
                        return z5 ? new FilterSegement(new NotNullSegement(readName)) : new FilterSegement(new NullSegement(readName));
                    } else if (z6) {
                        if (arrayList.size() == 1) {
                            return new FilterSegement(new IntOpSegement(readName, ((Number) arrayList.get(0)).longValue(), z5 ? Operator.NE : Operator.EQ));
                        }
                        int size = arrayList.size();
                        long[] jArr = new long[size];
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= size) {
                                return new FilterSegement(new IntInSegement(readName, jArr, z5));
                            }
                            jArr[i5] = ((Number) arrayList.get(i5)).longValue();
                            i4 = i5 + 1;
                        }
                    } else if (z7) {
                        if (arrayList.size() == 1) {
                            return new FilterSegement(new StringOpSegement(readName, (String) arrayList.get(0), z5 ? Operator.NE : Operator.EQ));
                        }
                        String[] strArr4 = new String[arrayList.size()];
                        arrayList.toArray(strArr4);
                        return new FilterSegement(new StringInSegement(readName, strArr4, z5));
                    } else if (!z8) {
                        throw new UnsupportedOperationException();
                    } else {
                        int size2 = arrayList.size();
                        Long[] lArr = new Long[size2];
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            if (i7 >= size2) {
                                return new FilterSegement(new IntObjInSegement(readName, lArr, z5));
                            }
                            Number number = (Number) arrayList.get(i7);
                            if (number != null) {
                                lArr[i7] = Long.valueOf(number.longValue());
                            }
                            i6 = i7 + 1;
                        }
                    }
                }
            }
        }

        protected long readLongValue() {
            int i = this.pos;
            char c = this.ch;
            if (c == '+' || c == '-') {
                next();
            }
            while (true) {
                char c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                    break;
                }
                next();
            }
            return Long.parseLong(this.path.substring(i - 1, this.pos - 1));
        }

        String readName() {
            skipWhitespace();
            char c = this.ch;
            if (c != '\\' && !IOUtils.firstIdentifier(c)) {
                throw new JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            StringBuilder sb = new StringBuilder();
            while (!isEOF()) {
                char c2 = this.ch;
                if (c2 == '\\') {
                    next();
                    sb.append(this.ch);
                    if (isEOF()) {
                        break;
                    }
                    next();
                } else if (!IOUtils.isIdent(c2)) {
                    break;
                } else {
                    sb.append(this.ch);
                    next();
                }
            }
            if (isEOF() && IOUtils.isIdent(this.ch)) {
                sb.append(this.ch);
            }
            return sb.toString();
        }

        protected Operator readOp() {
            Operator operator;
            char c = this.ch;
            if (c == '=') {
                next();
                operator = Operator.EQ;
            } else if (c == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator == null) {
                String readName = readName();
                if (!"not".equalsIgnoreCase(readName)) {
                    if ("like".equalsIgnoreCase(readName)) {
                        return Operator.LIKE;
                    }
                    if ("rlike".equalsIgnoreCase(readName)) {
                        return Operator.RLIKE;
                    }
                    if ("in".equalsIgnoreCase(readName)) {
                        return Operator.IN;
                    }
                    if ("between".equalsIgnoreCase(readName)) {
                        return Operator.BETWEEN;
                    }
                    throw new UnsupportedOperationException();
                }
                skipWhitespace();
                String readName2 = readName();
                if ("like".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
            return operator;
        }

        Segement readSegement() {
            char c;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegement(this.ch - '0');
                }
                char c2 = this.ch;
                if ((c2 >= 'a' && c2 <= 'z') || ((c = this.ch) >= 'A' && c <= 'Z')) {
                    return new PropertySegement(Character.toString(this.ch));
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c3 = this.ch;
                if (c3 == '@') {
                    next();
                    return SelfSegement.instance;
                } else if (c3 != '$') {
                    if (c3 != '.' && c3 != '/') {
                        if (c3 == '[') {
                            return parseArrayAccess(true);
                        }
                        if (this.level == 0) {
                            return new PropertySegement(readName());
                        }
                        throw new UnsupportedOperationException();
                    }
                    next();
                    char c4 = this.ch;
                    if (c4 == '*') {
                        if (!isEOF()) {
                            next();
                        }
                        return WildCardSegement.instance;
                    } else if (isDigitFirst(c4)) {
                        return parseArrayAccess(false);
                    } else {
                        String readName = readName();
                        if (this.ch == '(') {
                            next();
                            if (this.ch == ')') {
                                if (!isEOF()) {
                                    next();
                                }
                                if (ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE.equals(readName)) {
                                    return SizeSegement.instance;
                                }
                                throw new UnsupportedOperationException();
                            }
                            throw new UnsupportedOperationException();
                        }
                        return new PropertySegement(readName);
                    }
                } else {
                    next();
                }
            }
            return null;
        }

        String readString() {
            char c = this.ch;
            next();
            int i = this.pos;
            while (this.ch != c && !isEOF()) {
                next();
            }
            String substring = this.path.substring(i - 1, isEOF() ? this.pos : this.pos - 1);
            accept(c);
            return substring;
        }

        protected Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c = this.ch;
            if (c == '\"' || c == '\'') {
                return readString();
            }
            if (c == 'n') {
                if ("null".equals(readName())) {
                    return null;
                }
                throw new JSONPathException(this.path);
            }
            throw new UnsupportedOperationException();
        }

        public final void skipWhitespace() {
            while (true) {
                char c = this.ch;
                if (c > ' ') {
                    return;
                }
                if (c != ' ' && c != '\r' && c != '\n' && c != '\t' && c != '\f' && c != '\b') {
                    return;
                }
                next();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$MatchSegement.class */
    public static class MatchSegement implements Filter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String propertyName;
        private final String startsWithValue;

        public MatchSegement(String str, String str2, String str3, String[] strArr, boolean z) {
            this.propertyName = str;
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z;
            int i = 0;
            int length = str2 != null ? str2.length() + 0 : 0;
            int length2 = str3 != null ? length + str3.length() : length;
            int i2 = length2;
            if (strArr != null) {
                int length3 = strArr.length;
                while (true) {
                    i2 = length2;
                    if (i >= length3) {
                        break;
                    }
                    length2 += strArr[i].length();
                    i++;
                }
            }
            this.minLength = i2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            String obj4 = propertyValue.toString();
            if (obj4.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i = 0;
            } else if (!obj4.startsWith(str)) {
                return this.not;
            } else {
                i = this.startsWithValue.length() + 0;
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj4.indexOf(str2, i);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            return (str3 == null || obj4.endsWith(str3)) ? !this.not : this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$MultiIndexSegement.class */
    public static class MultiIndexSegement implements Segement {
        private final int[] indexes;

        public MultiIndexSegement(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.indexes.length);
            int i = 0;
            while (true) {
                int i2 = i;
                int[] iArr = this.indexes;
                if (i2 >= iArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getArrayItem(obj2, iArr[i2]));
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$MultiPropertySegement.class */
    public static class MultiPropertySegement implements Segement {
        private final String[] propertyNames;

        public MultiPropertySegement(String[] strArr) {
            this.propertyNames = strArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            String[] strArr = this.propertyNames;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i2], true));
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$NotNullSegement.class */
    public static class NotNullSegement implements Filter {
        private final String propertyName;

        public NotNullSegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean z = false;
            if (jSONPath.getPropertyValue(obj3, this.propertyName, false) != null) {
                z = true;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$NullSegement.class */
    public static class NullSegement implements Filter {
        private final String propertyName;

        public NullSegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean z = false;
            if (jSONPath.getPropertyValue(obj3, this.propertyName, false) == null) {
                z = true;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$Operator.class */
    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$PropertySegement.class */
    public static class PropertySegement implements Segement {
        private final String propertyName;

        public PropertySegement(String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValue(obj2, this.propertyName, true);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            jSONPath.setPropertyValue(obj, this.propertyName, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$RangeSegement.class */
    public static class RangeSegement implements Segement {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegement(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegement.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start;
            if (i < 0) {
                i += intValue;
            }
            int i2 = this.end;
            if (i2 < 0) {
                i2 += intValue;
            }
            ArrayList arrayList = new ArrayList(((i2 - i) / this.step) + 1);
            while (i <= i2 && i < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i));
                i += this.step;
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$RlikeSegement.class */
    public static class RlikeSegement implements Filter {
        private final boolean not;
        private final Pattern pattern;
        private final String propertyName;

        public RlikeSegement(String str, String str2, boolean z) {
            this.propertyName = str;
            this.pattern = Pattern.compile(str2);
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (propertyValue == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(propertyValue.toString()).matches();
            boolean z = matches;
            if (this.not) {
                z = !matches;
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$Segement.class */
    public interface Segement {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$SelfSegement.class */
    public static class SelfSegement implements Segement {
        public static final SelfSegement instance = new SelfSegement();

        SelfSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return obj2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$SizeSegement.class */
    public static class SizeSegement implements Segement {
        public static final SizeSegement instance = new SizeSegement();

        SizeSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$StringInSegement.class */
    public static class StringInSegement implements Filter {
        private final boolean not;
        private final String propertyName;
        private final String[] values;

        public StringInSegement(String str, String[] strArr, boolean z) {
            this.propertyName = str;
            this.values = strArr;
            this.not = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            String[] strArr;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            for (String str : this.values) {
                if (str == propertyValue) {
                    return !this.not;
                }
                if (str != null && str.equals(propertyValue)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$StringOpSegement.class */
    public static class StringOpSegement implements Filter {
        private final Operator op;
        private final String propertyName;
        private final String value;

        public StringOpSegement(String str, String str2, Operator operator) {
            this.propertyName = str;
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean z = false;
            Object propertyValue = jSONPath.getPropertyValue(obj3, this.propertyName, false);
            if (this.op == Operator.EQ) {
                return this.value.equals(propertyValue);
            }
            if (this.op == Operator.NE) {
                return !this.value.equals(propertyValue);
            }
            if (propertyValue == null) {
                return false;
            }
            int compareTo = this.value.compareTo(propertyValue.toString());
            if (this.op == Operator.GE) {
                if (compareTo <= 0) {
                    z = true;
                }
                return z;
            } else if (this.op == Operator.GT) {
                boolean z2 = false;
                if (compareTo < 0) {
                    z2 = true;
                }
                return z2;
            } else if (this.op == Operator.LE) {
                boolean z3 = false;
                if (compareTo >= 0) {
                    z3 = true;
                }
                return z3;
            } else {
                boolean z4 = false;
                if (this.op == Operator.LT) {
                    z4 = false;
                    if (compareTo > 0) {
                        z4 = true;
                    }
                }
                return z4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/JSONPath$WildCardSegement.class */
    public static class WildCardSegement implements Segement {
        public static WildCardSegement instance = new WildCardSegement();

        WildCardSegement() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segement
        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getPropertyValues(obj2);
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
    }

    public JSONPath(String str, SerializeConfig serializeConfig, ParserConfig parserConfig) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.path = str;
        this.serializeConfig = serializeConfig;
        this.parserConfig = parserConfig;
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static JSONPath compile(String str) {
        JSONPath jSONPath = pathCache.get(str);
        JSONPath jSONPath2 = jSONPath;
        if (jSONPath == null) {
            JSONPath jSONPath3 = new JSONPath(str);
            jSONPath2 = jSONPath3;
            if (pathCache.size() < CACHE_SIZE) {
                pathCache.putIfAbsent(str, jSONPath3);
                jSONPath2 = pathCache.get(str);
            }
        }
        return jSONPath2;
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() != obj2.getClass() && (obj instanceof Number)) {
            if (obj2 instanceof Number) {
                return eqNotNull((Number) obj, (Number) obj2);
            }
            return false;
        }
        return obj.equals(obj2);
    }

    static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number.getClass();
        boolean isInt2 = isInt(cls2);
        if (isInt && isInt2) {
            return number.longValue() == number2.longValue();
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        return ((isDouble && isDouble2) || ((isDouble && isInt) || (isDouble2 && isInt))) && number.doubleValue() == number2.doubleValue();
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    protected static boolean isDouble(Class<?> cls) {
        return cls == Float.class || cls == Double.class;
    }

    protected static boolean isInt(Class<?> cls) {
        return cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class;
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        Object obj2 = null;
        Object obj3 = obj;
        int i = 0;
        while (true) {
            int i2 = i;
            Segement[] segementArr = this.segments;
            if (i2 >= segementArr.length) {
                break;
            }
            if (i2 == segementArr.length - 1) {
                obj2 = obj3;
            }
            obj3 = this.segments[i2].eval(this, obj, obj3);
            i = i2 + 1;
        }
        if (obj3 == null) {
            throw new JSONPathException("value not found in path " + this.path);
        } else if (!(obj3 instanceof Collection)) {
            Class<?> cls = obj3.getClass();
            if (!cls.isArray()) {
                throw new UnsupportedOperationException();
            }
            int length = Array.getLength(obj3);
            Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length);
            System.arraycopy(obj3, 0, newInstance, 0, length);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= objArr.length) {
                    break;
                }
                Array.set(newInstance, length + i4, objArr[i4]);
                i3 = i4 + 1;
            }
            Segement[] segementArr2 = this.segments;
            Segement segement = segementArr2[segementArr2.length - 1];
            if (segement instanceof PropertySegement) {
                ((PropertySegement) segement).setValue(this, obj2, newInstance);
            } else if (!(segement instanceof ArrayAccessSegement)) {
                throw new UnsupportedOperationException();
            } else {
                ((ArrayAccessSegement) segement).setValue(this, obj2, newInstance);
            }
        } else {
            Collection collection = (Collection) obj3;
            int length2 = objArr.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length2) {
                    return;
                }
                collection.add(objArr[i6]);
                i5 = i6 + 1;
            }
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i = 0;
        while (true) {
            int i2 = i;
            Segement[] segementArr = this.segments;
            if (i2 >= segementArr.length) {
                return true;
            }
            obj2 = segementArr[i2].eval(this, obj, obj2);
            if (obj2 == null) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (eval instanceof Iterable) {
            for (Object obj3 : (Iterable) eval) {
                if (eq(obj3, obj2)) {
                    return true;
                }
            }
            return false;
        }
        return eq(eval, obj2);
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                return obj2;
            }
            obj2 = segementArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        int i = 0;
        if (obj instanceof Map) {
            int i2 = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i2++;
                }
            }
            return i2;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            List<Object> fieldValues = javaBeanSerializer.getFieldValues(obj);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i >= fieldValues.size()) {
                    return i4;
                }
                int i5 = i4;
                if (fieldValues.get(i) != null) {
                    i5 = i4 + 1;
                }
                i++;
                i3 = i5;
            }
        } catch (Exception e) {
            throw new JSONException("evalSize error : " + this.path, e);
        }
    }

    protected Object getArrayItem(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            } else if (Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return Array.get(obj, i);
                }
                return null;
            } else if (Math.abs(i) <= length) {
                return Array.get(obj, length + i);
            } else {
                return null;
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    protected JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        if (objectWriter instanceof ASMJavaBeanSerializer) {
            return ((ASMJavaBeanSerializer) objectWriter).getJavaBeanSerializer();
        }
        return null;
    }

    public String getPath() {
        return this.path;
    }

    protected Object getPropertyValue(Object obj, String str, boolean z) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                if (fieldSerializer == null) {
                    return null;
                }
                return fieldSerializer.getPropertyValue(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
            }
        } else if (!(obj instanceof List)) {
            throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str);
        } else {
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return arrayList;
                }
                arrayList.add(getPropertyValue(list.get(i2), str, z));
                i = i2 + 1;
            }
        }
    }

    protected Collection<Object> getPropertyValues(Object obj) {
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            if (obj instanceof Map) {
                return ((Map) obj).values();
            }
            throw new UnsupportedOperationException();
        }
        try {
            return javaBeanSerializer.getFieldValues(obj);
        } catch (Exception e) {
            throw new JSONPathException("jsonpath error, path " + this.path, e);
        }
    }

    protected void init() {
        if (this.segments != null) {
            return;
        }
        if (PhoneConstants.APN_TYPE_ALL.equals(this.path)) {
            this.segments = new Segement[]{WildCardSegement.instance};
        } else {
            this.segments = new JSONPathParser(this.path).explain();
        }
    }

    public boolean set(Object obj, Object obj2) {
        Object obj3;
        if (obj == null) {
            return false;
        }
        init();
        Object obj4 = obj;
        int i = 0;
        while (true) {
            int i2 = i;
            Segement[] segementArr = this.segments;
            obj3 = null;
            if (i2 >= segementArr.length) {
                break;
            } else if (i2 == segementArr.length - 1) {
                obj3 = obj4;
                break;
            } else {
                obj4 = segementArr[i2].eval(this, obj, obj4);
                if (obj4 == null) {
                    obj3 = null;
                    break;
                }
                i = i2 + 1;
            }
        }
        if (obj3 == null) {
            return false;
        }
        Segement[] segementArr2 = this.segments;
        Segement segement = segementArr2[segementArr2.length - 1];
        if (segement instanceof PropertySegement) {
            ((PropertySegement) segement).setValue(this, obj3, obj2);
            return true;
        } else if (segement instanceof ArrayAccessSegement) {
            return ((ArrayAccessSegement) segement).setValue(this, obj3, obj2);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                list.set(i, obj2);
                return true;
            }
            list.set(list.size() + i, obj2);
            return true;
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    Array.set(obj, i, obj2);
                    return true;
                }
                return true;
            } else if (Math.abs(i) <= length) {
                Array.set(obj, length + i, obj2);
                return true;
            } else {
                return true;
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    protected boolean setPropertyValue(Object obj, String str, Object obj2) {
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        } else if (obj instanceof List) {
            for (Object obj3 : (List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, obj2);
                }
            }
            return true;
        } else {
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
            JavaBeanDeserializer javaBeanDeserializer = null;
            if (deserializer instanceof JavaBeanDeserializer) {
                javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
            } else if (deserializer instanceof ASMJavaBeanDeserializer) {
                javaBeanDeserializer = ((ASMJavaBeanDeserializer) deserializer).getInnterSerializer();
            }
            if (javaBeanDeserializer != null) {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                if (fieldDeserializer == null) {
                    return false;
                }
                fieldDeserializer.setValue(obj, obj2);
                return true;
            }
            throw new UnsupportedOperationException();
        }
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segement[] segementArr = this.segments;
            if (i >= segementArr.length) {
                return evalSize(obj2);
            }
            obj2 = segementArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        jSONSerializer.write(this.path);
    }
}
