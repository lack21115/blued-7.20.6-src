package com.blued.android.framework.ui.markdown;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.markdown.atuser.AtUserPlugin;
import com.blued.android.framework.ui.markdown.atuser.AtUserProcessor;
import com.blued.android.framework.ui.markdown.atuser.OnClickAtUserListener;
import com.blued.android.framework.ui.markdown.image.MarkdownGlideImagesPlugin;
import com.blued.android.framework.ui.markdown.image.OnClickImageListener;
import com.blued.android.framework.ui.markdown.link.BluedLinkPlugin;
import com.blued.android.framework.ui.markdown.link.OnClickLinkListener;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.Markwon;
import io.noties.markwon.inlineparser.BangInlineProcessor;
import io.noties.markwon.inlineparser.CloseBracketInlineProcessor;
import io.noties.markwon.inlineparser.MarkwonInlineParser;
import io.noties.markwon.inlineparser.OpenBracketInlineProcessor;
import java.util.Collections;
import java.util.regex.Pattern;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.Parser;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/MarkdownView.class */
public class MarkdownView extends AppCompatTextView {
    private static final Pattern b = Pattern.compile("\n *\n");
    private static final Pattern c = Pattern.compile("([^ \n]) *(\\!\\[[^\\]]*\\]\\([^\\)]*)");
    public OnShowTextListener a;
    private Builder d;
    private Markwon e;
    private int f;
    private int g;
    private int h;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/MarkdownView$Builder.class */
    public static final class Builder {
        IRequestHost a;
        int c;
        int d;
        OnClickAtUserListener i;
        OnClickLinkListener j;
        OnClickImageListener k;
        int b = 6;
        int e = 5;
        int f = -14718229;
        int g = -14718229;
        String h = "";

        public Builder a(int i) {
            this.d = i;
            return this;
        }

        public Builder a(IRequestHost iRequestHost) {
            this.a = iRequestHost;
            return this;
        }

        public Builder a(OnClickAtUserListener onClickAtUserListener) {
            this.i = onClickAtUserListener;
            return this;
        }

        public Builder a(OnClickImageListener onClickImageListener) {
            this.k = onClickImageListener;
            return this;
        }

        public Builder a(OnClickLinkListener onClickLinkListener) {
            this.j = onClickLinkListener;
            return this;
        }

        public Builder a(String str) {
            this.h = str;
            return this;
        }

        public Builder b(int i) {
            this.e = i;
            return this;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/MarkdownView$OnShowTextListener.class */
    public interface OnShowTextListener {
        Spanned a(CharSequence charSequence);
    }

    public MarkdownView(Context context) {
        super(context);
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    public MarkdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    public MarkdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    private void a() {
        if (this.e == null) {
            MarkdownGlideImagesPlugin markdownGlideImagesPlugin = new MarkdownGlideImagesPlugin(this.d.a, this.h);
            markdownGlideImagesPlugin.a(this.d.d);
            markdownGlideImagesPlugin.b(this.d.c);
            markdownGlideImagesPlugin.c(this.d.b);
            markdownGlideImagesPlugin.d(this.d.e);
            markdownGlideImagesPlugin.a(this.d.k);
            markdownGlideImagesPlugin.a(this.d.h);
            AtUserPlugin atUserPlugin = new AtUserPlugin();
            atUserPlugin.a(this.d.i);
            atUserPlugin.a(this.d.f);
            BluedLinkPlugin bluedLinkPlugin = new BluedLinkPlugin();
            bluedLinkPlugin.a(this.d.j);
            bluedLinkPlugin.a(this.d.g);
            final InlineParserFactory build = MarkwonInlineParser.factoryBuilderNoDefaults().addInlineProcessor(new OpenBracketInlineProcessor()).addInlineProcessor(new CloseBracketInlineProcessor()).addInlineProcessor(new BangInlineProcessor()).build();
            this.e = Markwon.builder(getContext()).usePlugin(markdownGlideImagesPlugin).usePlugin(atUserPlugin).usePlugin(bluedLinkPlugin).usePlugin(new AbstractMarkwonPlugin() { // from class: com.blued.android.framework.ui.markdown.MarkdownView.2
                @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
                public void configureParser(Parser.Builder builder) {
                    builder.a(Collections.emptySet());
                    builder.a(build);
                }
            }).build();
        }
        this.g = this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str) {
        a();
        String b2 = b(str);
        OnShowTextListener onShowTextListener = this.a;
        if (onShowTextListener == null) {
            this.e.setMarkdown(this, b2);
            return;
        }
        this.e.setParsedMarkdown(this, onShowTextListener.a(this.e.toMarkdown(b2)));
    }

    private String b(String str) {
        return AtUserProcessor.a.matcher(c.matcher(b.matcher(str).replaceAll("\n\u3000\n")).replaceAll("$1\n$2")).replaceAll(" $0");
    }

    public void a(Builder builder, final String str) {
        Builder builder2 = builder;
        if (builder == null) {
            builder2 = new Builder();
        }
        this.d = builder2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.h > 0) {
            a(str);
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.framework.ui.markdown.MarkdownView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    MarkdownView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    MarkdownView markdownView = MarkdownView.this;
                    markdownView.h = (markdownView.getWidth() - MarkdownView.this.getPaddingLeft()) - MarkdownView.this.getPaddingRight();
                    MarkdownView.this.a(str);
                }
            });
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (AppInfo.m()) {
            Log.v("Markdown", "onAttachedToWindow ");
        }
    }

    protected void onDetachedFromWindow() {
        MarkdownGlideImagesPlugin markdownGlideImagesPlugin;
        super.onDetachedFromWindow();
        if (AppInfo.m()) {
            Log.v("Markdown", "onDetachedFromWindow ");
            Markwon markwon = this.e;
            if (markwon == null || (markdownGlideImagesPlugin = (MarkdownGlideImagesPlugin) markwon.getPlugin(MarkdownGlideImagesPlugin.class)) == null) {
                return;
            }
            markdownGlideImagesPlugin.a();
        }
    }

    public void setOnShowTextListener(OnShowTextListener onShowTextListener) {
        this.a = onShowTextListener;
    }
}
