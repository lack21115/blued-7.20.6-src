package com.blued.android.framework.ui.markdown.link;

import android.text.TextUtils;
import android.view.View;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Link;
import org.commonmark.node.Text;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/link/BluedLinkPlugin.class */
public class BluedLinkPlugin extends AbstractMarkwonPlugin {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f9919a = Pattern.compile("((http[s]{0,1}|blued)://|www\\.)[A-Za-z0-9\\.\\?\\-_~!@#$%^&/:=]+[A-Za-z0-9/#]");
    private OnClickLinkListener b;

    /* renamed from: c  reason: collision with root package name */
    private int f9920c;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MarkwonVisitor markwonVisitor, String str, int i) {
        Matcher matcher = f9919a.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start() + i;
            a(markwonVisitor, group, start, group.length() + start);
        }
    }

    private void a(MarkwonVisitor markwonVisitor, String str, int i, int i2) {
        MarkwonConfiguration configuration = markwonVisitor.configuration();
        RenderProps renderProps = markwonVisitor.renderProps();
        CoreProps.LINK_DESTINATION.set(renderProps, str);
        SpannableBuilder.setSpans(markwonVisitor.builder(), configuration.spansFactory().require(Link.class).getSpans(configuration, renderProps), i, i2);
    }

    public void a(int i) {
        this.f9920c = i;
    }

    public void a(OnClickLinkListener onClickLinkListener) {
        this.b = onClickLinkListener;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        builder.linkResolver(new LinkResolver() { // from class: com.blued.android.framework.ui.markdown.link.BluedLinkPlugin.2
            @Override // io.noties.markwon.LinkResolver
            public void resolve(View view, String str) {
                if (TextUtils.isEmpty(str) || BluedLinkPlugin.this.b == null) {
                    return;
                }
                BluedLinkPlugin.this.b.a(str);
            }
        });
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureTheme(MarkwonTheme.Builder builder) {
        builder.linkColor(this.f9920c);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.on(Text.class, new MarkwonVisitor.NodeVisitor<Text>() { // from class: com.blued.android.framework.ui.markdown.link.BluedLinkPlugin.1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            /* renamed from: a */
            public void visit(MarkwonVisitor markwonVisitor, Text text) {
                String a2 = text.a();
                markwonVisitor.builder().append(a2);
                BluedLinkPlugin.this.a(markwonVisitor, a2, markwonVisitor.length() - a2.length());
            }
        });
    }
}
