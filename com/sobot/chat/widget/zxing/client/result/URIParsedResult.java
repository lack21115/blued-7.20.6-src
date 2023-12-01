package com.sobot.chat.widget.zxing.client.result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/URIParsedResult.class */
public final class URIParsedResult extends ParsedResult {
    private final String title;
    private final String uri;

    public URIParsedResult(String str, String str2) {
        super(ParsedResultType.URI);
        this.uri = massageURI(str);
        this.title = str2;
    }

    private static boolean isColonFollowedByPortNumber(String str, int i) {
        int i2 = i + 1;
        int indexOf = str.indexOf(47, i2);
        int i3 = indexOf;
        if (indexOf < 0) {
            i3 = str.length();
        }
        return ResultParser.isSubstringOfDigits(str, i2, i3 - i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (isColonFollowedByPortNumber(r0, r0) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String massageURI(java.lang.String r3) {
        /*
            r0 = r3
            java.lang.String r0 = r0.trim()
            r5 = r0
            r0 = r5
            r1 = 58
            int r0 = r0.indexOf(r1)
            r4 = r0
            r0 = r4
            if (r0 < 0) goto L1a
            r0 = r5
            r3 = r0
            r0 = r5
            r1 = r4
            boolean r0 = isColonFollowedByPortNumber(r0, r1)
            if (r0 == 0) goto L34
        L1a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r3 = r0
            r0 = r3
            java.lang.String r1 = "http://"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            java.lang.String r0 = r0.toString()
            r3 = r0
        L34:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.zxing.client.result.URIParsedResult.massageURI(java.lang.String):java.lang.String");
    }

    @Override // com.sobot.chat.widget.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(30);
        maybeAppend(this.title, sb);
        maybeAppend(this.uri, sb);
        return sb.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public String getURI() {
        return this.uri;
    }

    @Deprecated
    public boolean isPossiblyMaliciousURI() {
        return URIResultParser.isPossiblyMaliciousURI(this.uri);
    }
}
