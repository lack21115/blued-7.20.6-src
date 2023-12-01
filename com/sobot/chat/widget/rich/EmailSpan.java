package com.sobot.chat.widget.rich;

import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.app.ShareCompat;
import com.sobot.chat.utils.SobotOption;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/rich/EmailSpan.class */
public class EmailSpan extends ClickableSpan {
    private int color;
    private Context context;
    private String email;

    public EmailSpan(Context context, String str, int i) {
        this.email = str;
        this.context = context;
        this.color = context.getResources().getColor(i);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (SobotOption.hyperlinkListener != null) {
            SobotOption.hyperlinkListener.onEmailClick(this.email);
        } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onEmailClick(this.context, this.email)) {
            try {
                ShareCompat.IntentBuilder from = ShareCompat.IntentBuilder.from((Activity) view.getContext());
                from.setType("message/rfc822");
                from.addEmailTo(this.email);
                from.setSubject("");
                from.setChooserTitle("");
                from.startChooser();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.color);
        textPaint.setUnderlineText(false);
    }
}
