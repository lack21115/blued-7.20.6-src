package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/LinkSpan.class */
public class LinkSpan extends URLSpan {
    private final String link;
    private final LinkResolver resolver;
    private final MarkwonTheme theme;

    public LinkSpan(MarkwonTheme markwonTheme, String str, LinkResolver linkResolver) {
        super(str);
        this.theme = markwonTheme;
        this.link = str;
        this.resolver = linkResolver;
    }

    public String getLink() {
        return this.link;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.resolver.resolve(view, this.link);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.theme.applyLinkStyle(textPaint);
    }
}
