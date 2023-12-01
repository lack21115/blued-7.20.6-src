package org.json;

import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:org/json/JSONStringer.class */
public class JSONStringer {
    private final String indent;
    final StringBuilder out;
    private final List<Scope> stack;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:org/json/JSONStringer$Scope.class */
    public enum Scope {
        EMPTY_ARRAY,
        NONEMPTY_ARRAY,
        EMPTY_OBJECT,
        DANGLING_KEY,
        NONEMPTY_OBJECT,
        NULL
    }

    public JSONStringer() {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        this.indent = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONStringer(int i) {
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        char[] cArr = new char[i];
        Arrays.fill(cArr, ' ');
        this.indent = new String(cArr);
    }

    private void beforeKey() throws JSONException {
        Scope peek = peek();
        if (peek == Scope.NONEMPTY_OBJECT) {
            this.out.append(',');
        } else if (peek != Scope.EMPTY_OBJECT) {
            throw new JSONException("Nesting problem");
        }
        newline();
        replaceTop(Scope.DANGLING_KEY);
    }

    private void beforeValue() throws JSONException {
        if (this.stack.isEmpty()) {
            return;
        }
        Scope peek = peek();
        if (peek == Scope.EMPTY_ARRAY) {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } else if (peek == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
            newline();
        } else if (peek == Scope.DANGLING_KEY) {
            this.out.append(this.indent == null ? ":" : ": ");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } else if (peek != Scope.NULL) {
            throw new JSONException("Nesting problem");
        }
    }

    private void newline() {
        if (this.indent == null) {
            return;
        }
        this.out.append("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.stack.size()) {
                return;
            }
            this.out.append(this.indent);
            i = i2 + 1;
        }
    }

    private Scope peek() throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        return this.stack.get(this.stack.size() - 1);
    }

    private void replaceTop(Scope scope) {
        this.stack.set(this.stack.size() - 1, scope);
    }

    private void string(String str) {
        this.out.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    this.out.append("\\b");
                    break;
                case '\t':
                    this.out.append("\\t");
                    break;
                case '\n':
                    this.out.append("\\n");
                    break;
                case '\f':
                    this.out.append("\\f");
                    break;
                case '\r':
                    this.out.append("\\r");
                    break;
                case '\"':
                case '/':
                case '\\':
                    this.out.append('\\').append(charAt);
                    break;
                default:
                    if (charAt <= 31) {
                        this.out.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                        break;
                    } else {
                        this.out.append(charAt);
                        break;
                    }
            }
        }
        this.out.append("\"");
    }

    public JSONStringer array() throws JSONException {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONStringer close(Scope scope, Scope scope2, String str) throws JSONException {
        Scope peek = peek();
        if (peek == scope2 || peek == scope) {
            this.stack.remove(this.stack.size() - 1);
            if (peek == scope2) {
                newline();
            }
            this.out.append(str);
            return this;
        }
        throw new JSONException("Nesting problem");
    }

    public JSONStringer endArray() throws JSONException {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    public JSONStringer endObject() throws JSONException {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, i.d);
    }

    public JSONStringer key(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Names must be non-null");
        }
        beforeKey();
        string(str);
        return this;
    }

    public JSONStringer object() throws JSONException {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONStringer open(Scope scope, String str) throws JSONException {
        if (!this.stack.isEmpty() || this.out.length() <= 0) {
            beforeValue();
            this.stack.add(scope);
            this.out.append(str);
            return this;
        }
        throw new JSONException("Nesting problem: multiple top-level roots");
    }

    public String toString() {
        if (this.out.length() == 0) {
            return null;
        }
        return this.out.toString();
    }

    public JSONStringer value(double d) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        this.out.append(JSONObject.numberToString(Double.valueOf(d)));
        return this;
    }

    public JSONStringer value(long j) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        this.out.append(j);
        return this;
    }

    public JSONStringer value(Object obj) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        if (obj instanceof JSONArray) {
            ((JSONArray) obj).writeTo(this);
            return this;
        } else if (obj instanceof JSONObject) {
            ((JSONObject) obj).writeTo(this);
            return this;
        } else {
            beforeValue();
            if (obj == null || (obj instanceof Boolean) || obj == JSONObject.NULL) {
                this.out.append(obj);
                return this;
            } else if (obj instanceof Number) {
                this.out.append(JSONObject.numberToString((Number) obj));
                return this;
            } else {
                string(obj.toString());
                return this;
            }
        }
    }

    public JSONStringer value(boolean z) throws JSONException {
        if (this.stack.isEmpty()) {
            throw new JSONException("Nesting problem");
        }
        beforeValue();
        this.out.append(z);
        return this;
    }
}
