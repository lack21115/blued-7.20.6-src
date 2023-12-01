package com.google.zxing.client.result;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/client/result/ParsedResult.class */
public abstract class ParsedResult {
    private final ParsedResultType type;

    /* JADX INFO: Access modifiers changed from: protected */
    public ParsedResult(ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    public static void maybeAppend(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public static void maybeAppend(String[] strArr, StringBuilder sb) {
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            maybeAppend(strArr[i2], sb);
            i = i2 + 1;
        }
    }

    public abstract String getDisplayResult();

    public final ParsedResultType getType() {
        return this.type;
    }

    public final String toString() {
        return getDisplayResult();
    }
}
