package com.sobot.chat.widget.zxing.client.result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/ISBNParsedResult.class */
public final class ISBNParsedResult extends ParsedResult {
    private final String isbn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ISBNParsedResult(String str) {
        super(ParsedResultType.ISBN);
        this.isbn = str;
    }

    @Override // com.sobot.chat.widget.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return this.isbn;
    }

    public String getISBN() {
        return this.isbn;
    }
}
