package com.blued.android.framework.ui.markdown.atuser;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import org.commonmark.parser.Parser;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/markdown/atuser/AtUserPlugin.class */
public class AtUserPlugin extends AbstractMarkwonPlugin {

    /* renamed from: a  reason: collision with root package name */
    private StyleSpan f9902a = new StyleSpan(1);
    private OnClickAtUserListener b;

    /* renamed from: c  reason: collision with root package name */
    private int f9903c;

    public void a(int i) {
        this.f9903c = i;
    }

    public void a(OnClickAtUserListener onClickAtUserListener) {
        this.b = onClickAtUserListener;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
        builder.a(new AtUserProcessor());
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.on(AtUserNode.class, new MarkwonVisitor.NodeVisitor<AtUserNode>() { // from class: com.blued.android.framework.ui.markdown.atuser.AtUserPlugin.1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            /* renamed from: a */
            public void visit(MarkwonVisitor markwonVisitor, AtUserNode atUserNode) {
                final String a2 = atUserNode.a();
                final String p_ = atUserNode.p_();
                if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(p_)) {
                    return;
                }
                String str = "@" + atUserNode.a();
                int length = markwonVisitor.length();
                int length2 = str.length();
                markwonVisitor.builder().append(str);
                markwonVisitor.builder().setSpan(new ClickableSpan() { // from class: com.blued.android.framework.ui.markdown.atuser.AtUserPlugin.1.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (AtUserPlugin.this.b != null) {
                            AtUserPlugin.this.b.a(a2, p_);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(AtUserPlugin.this.f9903c);
                        textPaint.setAlpha(255);
                        textPaint.setUnderlineText(false);
                        textPaint.clearShadowLayer();
                        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                }, length, length2 + length, 33);
                markwonVisitor.builder().append(' ');
            }
        });
    }
}
