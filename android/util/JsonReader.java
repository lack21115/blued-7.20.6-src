package android.util;

import com.igexin.push.core.b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import libcore.internal.StringPool;

/* loaded from: source-9557208-dex2jar.jar:android/util/JsonReader.class */
public final class JsonReader implements Closeable {
    private static final String FALSE = "false";
    private static final String TRUE = "true";

    /* renamed from: in  reason: collision with root package name */
    private final Reader f1429in;
    private String name;
    private boolean skipping;
    private JsonToken token;
    private String value;
    private int valueLength;
    private int valuePos;
    private final StringPool stringPool = new StringPool();
    private boolean lenient = false;
    private final char[] buffer = new char[1024];
    private int pos = 0;
    private int limit = 0;
    private int bufferStartLine = 1;
    private int bufferStartColumn = 1;
    private final List<JsonScope> stack = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.util.JsonReader$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/util/JsonReader$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$util$JsonScope = new int[JsonScope.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:43:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:45:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006f -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0073 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0077 -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007b -> B:47:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x007f -> B:41:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.EMPTY_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.EMPTY_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.NONEMPTY_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.EMPTY_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.DANGLING_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.NONEMPTY_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.NONEMPTY_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$android$util$JsonScope[JsonScope.CLOSED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public JsonReader(Reader reader) {
        push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f1429in = reader;
    }

    private JsonToken advance() throws IOException {
        peek();
        JsonToken jsonToken = this.token;
        this.token = null;
        this.value = null;
        this.name = null;
        return jsonToken;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private JsonToken decodeLiteral() throws IOException {
        if (this.valuePos == -1) {
            return JsonToken.STRING;
        }
        if (this.valueLength == 4 && (('n' == this.buffer[this.valuePos] || 'N' == this.buffer[this.valuePos]) && (('u' == this.buffer[this.valuePos + 1] || 'U' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && ('l' == this.buffer[this.valuePos + 3] || 'L' == this.buffer[this.valuePos + 3]))))) {
            this.value = b.l;
            return JsonToken.NULL;
        } else if (this.valueLength == 4 && (('t' == this.buffer[this.valuePos] || 'T' == this.buffer[this.valuePos]) && (('r' == this.buffer[this.valuePos + 1] || 'R' == this.buffer[this.valuePos + 1]) && (('u' == this.buffer[this.valuePos + 2] || 'U' == this.buffer[this.valuePos + 2]) && ('e' == this.buffer[this.valuePos + 3] || 'E' == this.buffer[this.valuePos + 3]))))) {
            this.value = "true";
            return JsonToken.BOOLEAN;
        } else if (this.valueLength == 5 && (('f' == this.buffer[this.valuePos] || 'F' == this.buffer[this.valuePos]) && (('a' == this.buffer[this.valuePos + 1] || 'A' == this.buffer[this.valuePos + 1]) && (('l' == this.buffer[this.valuePos + 2] || 'L' == this.buffer[this.valuePos + 2]) && (('s' == this.buffer[this.valuePos + 3] || 'S' == this.buffer[this.valuePos + 3]) && ('e' == this.buffer[this.valuePos + 4] || 'E' == this.buffer[this.valuePos + 4])))))) {
            this.value = "false";
            return JsonToken.BOOLEAN;
        } else {
            this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
            return decodeNumber(this.buffer, this.valuePos, this.valueLength);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d9, code lost:
        if (r11 == 'E') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00fb, code lost:
        if (r0 == '-') goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.JsonToken decodeNumber(char[] r5, int r6, int r7) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.JsonReader.decodeNumber(char[], int, int):android.util.JsonToken");
    }

    private void expect(JsonToken jsonToken) throws IOException {
        peek();
        if (this.token != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + peek());
        }
        advance();
    }

    private boolean fillBuffer(int i) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.pos) {
                break;
            }
            if (this.buffer[i3] == '\n') {
                this.bufferStartLine++;
                this.bufferStartColumn = 1;
            } else {
                this.bufferStartColumn++;
            }
            i2 = i3 + 1;
        }
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(this.buffer, this.pos, this.buffer, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.f1429in.read(this.buffer, this.limit, this.buffer.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit += read;
            if (this.bufferStartLine == 1 && this.bufferStartColumn == 1 && this.limit > 0 && this.buffer[0] == 65279) {
                this.pos++;
                this.bufferStartColumn--;
            }
        } while (this.limit < i);
        return true;
    }

    private int getColumnNumber() {
        int i = this.bufferStartColumn;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.pos) {
                return i;
            }
            i = this.buffer[i3] == '\n' ? 1 : i + 1;
            i2 = i3 + 1;
        }
    }

    private int getLineNumber() {
        int i = this.bufferStartLine;
        int i2 = 0;
        while (i2 < this.pos) {
            int i3 = i;
            if (this.buffer[i2] == '\n') {
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    private CharSequence getSnippet() {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(this.pos, 20);
        sb.append(this.buffer, this.pos - min, min);
        sb.append(this.buffer, this.pos, Math.min(this.limit - this.pos, 20));
        return sb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JsonToken nextInArray(boolean z) throws IOException {
        if (z) {
            replaceTop(JsonScope.NONEMPTY_ARRAY);
        } else {
            switch (nextNonWhitespace()) {
                case 44:
                    break;
                case 59:
                    checkLenient();
                    break;
                case 93:
                    pop();
                    JsonToken jsonToken = JsonToken.END_ARRAY;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    throw syntaxError("Unterminated array");
            }
        }
        switch (nextNonWhitespace()) {
            case 44:
            case 59:
                break;
            default:
                this.pos--;
                return nextValue();
            case 93:
                if (z) {
                    pop();
                    JsonToken jsonToken2 = JsonToken.END_ARRAY;
                    this.token = jsonToken2;
                    return jsonToken2;
                }
                break;
        }
        checkLenient();
        this.pos--;
        this.value = b.l;
        JsonToken jsonToken3 = JsonToken.NULL;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken nextInObject(boolean z) throws IOException {
        if (z) {
            switch (nextNonWhitespace()) {
                case 125:
                    pop();
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    this.token = jsonToken;
                    return jsonToken;
                default:
                    this.pos--;
                    break;
            }
        } else {
            switch (nextNonWhitespace()) {
                case 44:
                case 59:
                    break;
                case 125:
                    pop();
                    JsonToken jsonToken2 = JsonToken.END_OBJECT;
                    this.token = jsonToken2;
                    return jsonToken2;
                default:
                    throw syntaxError("Unterminated object");
            }
        }
        int nextNonWhitespace = nextNonWhitespace();
        switch (nextNonWhitespace) {
            case 39:
                checkLenient();
            case 34:
                this.name = nextString((char) nextNonWhitespace);
                break;
            default:
                checkLenient();
                this.pos--;
                this.name = nextLiteral(false);
                if (this.name.isEmpty()) {
                    throw syntaxError("Expected name");
                }
                break;
        }
        replaceTop(JsonScope.DANGLING_NAME);
        JsonToken jsonToken3 = JsonToken.NAME;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private String nextLiteral(boolean z) throws IOException {
        StringBuilder sb;
        int i;
        String sb2;
        StringBuilder sb3 = null;
        this.valuePos = -1;
        this.valueLength = 0;
        int i2 = 0;
        while (true) {
            if (this.pos + i2 < this.limit) {
                sb = sb3;
                i = i2;
                switch (this.buffer[this.pos + i2]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        checkLenient();
                        i = i2;
                        sb = sb3;
                        break;
                    default:
                        i2++;
                }
            } else if (i2 >= this.buffer.length) {
                sb = sb3;
                if (sb3 == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.buffer, this.pos, i2);
                this.valueLength += i2;
                this.pos += i2;
                i = 0;
                i2 = 0;
                sb3 = sb;
                if (!fillBuffer(1)) {
                }
            } else if (!fillBuffer(i2 + 1)) {
                this.buffer[this.limit] = 0;
                sb = sb3;
                i = i2;
            }
        }
        if (z && sb == null) {
            this.valuePos = this.pos;
            sb2 = null;
        } else if (this.skipping) {
            sb2 = "skipped!";
        } else if (sb == null) {
            sb2 = this.stringPool.get(this.buffer, this.pos, i);
        } else {
            sb.append(this.buffer, this.pos, i);
            sb2 = sb.toString();
        }
        this.valueLength += i;
        this.pos += i;
        return sb2;
    }

    private int nextNonWhitespace() throws IOException {
        char c2;
        while (true) {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                c2 = cArr[i];
                switch (c2) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        break;
                    case '#':
                        checkLenient();
                        skipToEndOfLine();
                        break;
                    case '/':
                        if (this.pos == this.limit && !fillBuffer(1)) {
                            break;
                        } else {
                            checkLenient();
                            switch (this.buffer[this.pos]) {
                                case '*':
                                    this.pos++;
                                    if (skipTo("*/")) {
                                        this.pos += 2;
                                        continue;
                                    } else {
                                        throw syntaxError("Unterminated comment");
                                    }
                                case '/':
                                    this.pos++;
                                    skipToEndOfLine();
                                    continue;
                                default:
                                    return c2;
                            }
                        }
                }
            } else {
                throw new EOFException("End of input");
            }
        }
        return c2;
    }

    private String nextString(char c2) throws IOException {
        StringBuilder sb = null;
        do {
            int i = this.pos;
            while (this.pos < this.limit) {
                char[] cArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    if (this.skipping) {
                        return "skipped!";
                    }
                    if (sb == null) {
                        return this.stringPool.get(this.buffer, i, (this.pos - i) - 1);
                    }
                    sb.append(this.buffer, i, (this.pos - i) - 1);
                    return sb.toString();
                } else if (c3 == '\\') {
                    StringBuilder sb2 = sb;
                    if (sb == null) {
                        sb2 = new StringBuilder();
                    }
                    sb2.append(this.buffer, i, (this.pos - i) - 1);
                    sb2.append(readEscapeCharacter());
                    i = this.pos;
                    sb = sb2;
                }
            }
            StringBuilder sb3 = sb;
            if (sb == null) {
                sb3 = new StringBuilder();
            }
            sb3.append(this.buffer, i, this.pos - i);
            sb = sb3;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private JsonToken nextValue() throws IOException {
        int nextNonWhitespace = nextNonWhitespace();
        switch (nextNonWhitespace) {
            case 34:
                break;
            case 39:
                checkLenient();
                break;
            case 91:
                push(JsonScope.EMPTY_ARRAY);
                JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
                this.token = jsonToken;
                return jsonToken;
            case 123:
                push(JsonScope.EMPTY_OBJECT);
                JsonToken jsonToken2 = JsonToken.BEGIN_OBJECT;
                this.token = jsonToken2;
                return jsonToken2;
            default:
                this.pos--;
                return readLiteral();
        }
        this.value = nextString((char) nextNonWhitespace);
        JsonToken jsonToken3 = JsonToken.STRING;
        this.token = jsonToken3;
        return jsonToken3;
    }

    private JsonToken objectValue() throws IOException {
        switch (nextNonWhitespace()) {
            case 58:
                break;
            case 59:
            case 60:
            default:
                throw syntaxError("Expected ':'");
            case 61:
                checkLenient();
                if ((this.pos < this.limit || fillBuffer(1)) && this.buffer[this.pos] == '>') {
                    this.pos++;
                    break;
                }
                break;
        }
        replaceTop(JsonScope.NONEMPTY_OBJECT);
        return nextValue();
    }

    private JsonScope peekStack() {
        return this.stack.get(this.stack.size() - 1);
    }

    private JsonScope pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    private void push(JsonScope jsonScope) {
        this.stack.add(jsonScope);
    }

    private char readEscapeCharacter() throws IOException {
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            char c2 = cArr[i];
            switch (c2) {
                case 'b':
                    return '\b';
                case 'f':
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                        String str = this.stringPool.get(this.buffer, this.pos, 4);
                        this.pos += 4;
                        return (char) Integer.parseInt(str, 16);
                    }
                    throw syntaxError("Unterminated escape sequence");
                default:
                    return c2;
            }
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private JsonToken readLiteral() throws IOException {
        this.value = nextLiteral(true);
        if (this.valueLength == 0) {
            throw syntaxError("Expected literal value");
        }
        this.token = decodeLiteral();
        if (this.token == JsonToken.STRING) {
            checkLenient();
        }
        return this.token;
    }

    private void replaceTop(JsonScope jsonScope) {
        this.stack.set(this.stack.size() - 1, jsonScope);
    }

    private boolean skipTo(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.limit && !fillBuffer(str.length())) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= str.length()) {
                    return true;
                }
                if (this.buffer[this.pos + i2] != str.charAt(i2)) {
                    break;
                }
                i = i2 + 1;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c2;
        do {
            if (this.pos >= this.limit && !fillBuffer(1)) {
                return;
            }
            char[] cArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            c2 = cArr[i];
            if (c2 == '\r') {
                return;
            }
        } while (c2 != '\n');
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + " at line " + getLineNumber() + " column " + getColumnNumber());
    }

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
    }

    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.value = null;
        this.token = null;
        this.stack.clear();
        this.stack.add(JsonScope.CLOSED);
        this.f1429in.close();
    }

    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
    }

    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
    }

    public boolean hasNext() throws IOException {
        peek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public boolean nextBoolean() throws IOException {
        peek();
        if (this.token != JsonToken.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + this.token);
        }
        boolean z = this.value == "true";
        advance();
        return z;
    }

    public double nextDouble() throws IOException {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            double parseDouble = Double.parseDouble(this.value);
            advance();
            return parseDouble;
        }
        throw new IllegalStateException("Expected a double but was " + this.token);
    }

    public int nextInt() throws IOException {
        int i;
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            try {
                i = Integer.parseInt(this.value);
            } catch (NumberFormatException e) {
                double parseDouble = Double.parseDouble(this.value);
                int i2 = (int) parseDouble;
                i = i2;
                if (i2 != parseDouble) {
                    throw new NumberFormatException(this.value);
                }
            }
            advance();
            return i;
        }
        throw new IllegalStateException("Expected an int but was " + this.token);
    }

    public long nextLong() throws IOException {
        long j;
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            try {
                j = Long.parseLong(this.value);
            } catch (NumberFormatException e) {
                double parseDouble = Double.parseDouble(this.value);
                long j2 = (long) parseDouble;
                j = j2;
                if (j2 != parseDouble) {
                    throw new NumberFormatException(this.value);
                }
            }
            advance();
            return j;
        }
        throw new IllegalStateException("Expected a long but was " + this.token);
    }

    public String nextName() throws IOException {
        peek();
        if (this.token != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + peek());
        }
        String str = this.name;
        advance();
        return str;
    }

    public void nextNull() throws IOException {
        peek();
        if (this.token != JsonToken.NULL) {
            throw new IllegalStateException("Expected null but was " + this.token);
        }
        advance();
    }

    public String nextString() throws IOException {
        peek();
        if (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER) {
            String str = this.value;
            advance();
            return str;
        }
        throw new IllegalStateException("Expected a string but was " + peek());
    }

    public JsonToken peek() throws IOException {
        JsonToken jsonToken;
        if (this.token != null) {
            jsonToken = this.token;
        } else {
            switch (AnonymousClass1.$SwitchMap$android$util$JsonScope[peekStack().ordinal()]) {
                case 1:
                    replaceTop(JsonScope.NONEMPTY_DOCUMENT);
                    JsonToken nextValue = nextValue();
                    jsonToken = nextValue;
                    if (!this.lenient) {
                        jsonToken = nextValue;
                        if (this.token != JsonToken.BEGIN_ARRAY) {
                            jsonToken = nextValue;
                            if (this.token != JsonToken.BEGIN_OBJECT) {
                                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.token);
                            }
                        }
                    }
                    break;
                case 2:
                    return nextInArray(true);
                case 3:
                    return nextInArray(false);
                case 4:
                    return nextInObject(true);
                case 5:
                    return objectValue();
                case 6:
                    return nextInObject(false);
                case 7:
                    try {
                        JsonToken nextValue2 = nextValue();
                        if (this.lenient) {
                            return nextValue2;
                        }
                        throw syntaxError("Expected EOF");
                    } catch (EOFException e) {
                        JsonToken jsonToken2 = JsonToken.END_DOCUMENT;
                        this.token = jsonToken2;
                        return jsonToken2;
                    }
                case 8:
                    throw new IllegalStateException("JsonReader is closed");
                default:
                    throw new AssertionError();
            }
        }
        return jsonToken;
    }

    public void setLenient(boolean z) {
        this.lenient = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
        if (r0 == android.util.JsonToken.END_OBJECT) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void skipValue() throws java.io.IOException {
        /*
            r4 = this;
            r0 = r4
            r1 = 1
            r0.skipping = r1
            r0 = r4
            boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L16
            r0 = r4
            android.util.JsonToken r0 = r0.peek()     // Catch: java.lang.Throwable -> L21
            android.util.JsonToken r1 = android.util.JsonToken.END_DOCUMENT     // Catch: java.lang.Throwable -> L21
            if (r0 != r1) goto L29
        L16:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L21 java.lang.Throwable -> L21
            r1 = r0
            java.lang.String r2 = "No element left to skip"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L21
            throw r0     // Catch: java.lang.Throwable -> L21
        L21:
            r7 = move-exception
            r0 = r4
            r1 = 0
            r0.skipping = r1
            r0 = r7
            throw r0
        L29:
            r0 = 0
            r6 = r0
        L2b:
            r0 = r4
            android.util.JsonToken r0 = r0.advance()     // Catch: java.lang.Throwable -> L21
            r7 = r0
            r0 = r7
            android.util.JsonToken r1 = android.util.JsonToken.BEGIN_ARRAY     // Catch: java.lang.Throwable -> L21
            if (r0 == r1) goto L42
            android.util.JsonToken r0 = android.util.JsonToken.BEGIN_OBJECT     // Catch: java.lang.Throwable -> L21
            r8 = r0
            r0 = r7
            r1 = r8
            if (r0 != r1) goto L52
        L42:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L46:
            r0 = r5
            r6 = r0
            r0 = r5
            if (r0 != 0) goto L2b
            r0 = r4
            r1 = 0
            r0.skipping = r1
            return
        L52:
            r0 = r7
            android.util.JsonToken r1 = android.util.JsonToken.END_ARRAY     // Catch: java.lang.Throwable -> L21
            if (r0 == r1) goto L66
            android.util.JsonToken r0 = android.util.JsonToken.END_OBJECT     // Catch: java.lang.Throwable -> L21
            r8 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            r1 = r8
            if (r0 != r1) goto L46
        L66:
            r0 = r6
            r1 = 1
            int r0 = r0 - r1
            r5 = r0
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: android.util.JsonReader.skipValue():void");
    }

    public String toString() {
        return getClass().getSimpleName() + " near " + ((Object) getSnippet());
    }
}
