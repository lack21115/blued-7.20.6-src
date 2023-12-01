package io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.MarkwonTheme;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/AbstractMarkwonPlugin.class */
public abstract class AbstractMarkwonPlugin implements MarkwonPlugin {
    @Override // io.noties.markwon.MarkwonPlugin
    public void afterRender(Node node, MarkwonVisitor markwonVisitor) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void beforeRender(Node node) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configure(MarkwonPlugin.Registry registry) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureTheme(MarkwonTheme.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public String processMarkdown(String str) {
        return str;
    }
}
