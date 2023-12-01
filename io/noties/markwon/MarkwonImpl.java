package io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/MarkwonImpl.class */
class MarkwonImpl extends Markwon {
    private final TextView.BufferType bufferType;
    private final MarkwonConfiguration configuration;
    private final boolean fallbackToRawInputWhenEmpty;
    private final Parser parser;
    private final List<MarkwonPlugin> plugins;
    private final Markwon.TextSetter textSetter;
    private final MarkwonVisitorFactory visitorFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkwonImpl(TextView.BufferType bufferType, Markwon.TextSetter textSetter, Parser parser, MarkwonVisitorFactory markwonVisitorFactory, MarkwonConfiguration markwonConfiguration, List<MarkwonPlugin> list, boolean z) {
        this.bufferType = bufferType;
        this.textSetter = textSetter;
        this.parser = parser;
        this.visitorFactory = markwonVisitorFactory;
        this.configuration = markwonConfiguration;
        this.plugins = list;
        this.fallbackToRawInputWhenEmpty = z;
    }

    @Override // io.noties.markwon.Markwon
    public MarkwonConfiguration configuration() {
        return this.configuration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [io.noties.markwon.MarkwonPlugin, java.lang.Object] */
    @Override // io.noties.markwon.Markwon
    public <P extends MarkwonPlugin> P getPlugin(Class<P> cls) {
        P p = null;
        for (MarkwonPlugin markwonPlugin : this.plugins) {
            if (cls.isAssignableFrom(markwonPlugin.getClass())) {
                p = markwonPlugin;
            }
        }
        return p;
    }

    @Override // io.noties.markwon.Markwon
    public List<? extends MarkwonPlugin> getPlugins() {
        return Collections.unmodifiableList(this.plugins);
    }

    @Override // io.noties.markwon.Markwon
    public boolean hasPlugin(Class<? extends MarkwonPlugin> cls) {
        return getPlugin(cls) != null;
    }

    @Override // io.noties.markwon.Markwon
    public Node parse(String str) {
        for (MarkwonPlugin markwonPlugin : this.plugins) {
            str = markwonPlugin.processMarkdown(str);
        }
        return this.parser.a(str);
    }

    @Override // io.noties.markwon.Markwon
    public Spanned render(Node node) {
        for (MarkwonPlugin markwonPlugin : this.plugins) {
            markwonPlugin.beforeRender(node);
        }
        MarkwonVisitor create = this.visitorFactory.create();
        node.a(create);
        for (MarkwonPlugin markwonPlugin2 : this.plugins) {
            markwonPlugin2.afterRender(node, create);
        }
        return create.builder().spannableStringBuilder();
    }

    @Override // io.noties.markwon.Markwon
    public <P extends MarkwonPlugin> P requirePlugin(Class<P> cls) {
        P p = (P) getPlugin(cls);
        if (p != null) {
            return p;
        }
        throw new IllegalStateException(String.format(Locale.US, "Requested plugin `%s` is not registered with this Markwon instance", cls.getName()));
    }

    @Override // io.noties.markwon.Markwon
    public void setMarkdown(TextView textView, String str) {
        setParsedMarkdown(textView, toMarkdown(str));
    }

    @Override // io.noties.markwon.Markwon
    public void setParsedMarkdown(final TextView textView, Spanned spanned) {
        for (MarkwonPlugin markwonPlugin : this.plugins) {
            markwonPlugin.beforeSetText(textView, spanned);
        }
        Markwon.TextSetter textSetter = this.textSetter;
        if (textSetter != null) {
            textSetter.setText(textView, spanned, this.bufferType, new Runnable() { // from class: io.noties.markwon.MarkwonImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    for (MarkwonPlugin markwonPlugin2 : MarkwonImpl.this.plugins) {
                        markwonPlugin2.afterSetText(textView);
                    }
                }
            });
            return;
        }
        textView.setText(spanned, this.bufferType);
        for (MarkwonPlugin markwonPlugin2 : this.plugins) {
            markwonPlugin2.afterSetText(textView);
        }
    }

    @Override // io.noties.markwon.Markwon
    public Spanned toMarkdown(String str) {
        Spanned render = render(parse(str));
        SpannableStringBuilder spannableStringBuilder = render;
        if (TextUtils.isEmpty(render)) {
            spannableStringBuilder = render;
            if (this.fallbackToRawInputWhenEmpty) {
                spannableStringBuilder = render;
                if (!TextUtils.isEmpty(str)) {
                    spannableStringBuilder = new SpannableStringBuilder(str);
                }
            }
        }
        return spannableStringBuilder;
    }
}
