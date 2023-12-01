package com.sobot.chat.widget.rich;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.sobot.chat.listener.HyperlinkListener;
import com.sobot.chat.listener.NewHyperlinkListener;
import com.sobot.chat.utils.ChatUtils;
import com.sobot.chat.utils.SobotOption;
import com.tencent.smtt.sdk.WebView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/rich/PhoneSpan.class */
public class PhoneSpan extends ClickableSpan {
    private int color;
    private Context context;
    private String phone;

    public PhoneSpan(Context context, String str, int i) {
        this.phone = str;
        this.color = context.getResources().getColor(i);
        this.context = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (SobotOption.hyperlinkListener != null) {
            HyperlinkListener hyperlinkListener = SobotOption.hyperlinkListener;
            hyperlinkListener.onPhoneClick(WebView.SCHEME_TEL + this.phone);
            return;
        }
        if (SobotOption.newHyperlinkListener != null) {
            NewHyperlinkListener newHyperlinkListener = SobotOption.newHyperlinkListener;
            Context context = this.context;
            if (newHyperlinkListener.onPhoneClick(context, WebView.SCHEME_TEL + this.phone)) {
                return;
            }
        }
        ChatUtils.callUp(this.phone, this.context);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.color);
        textPaint.setUnderlineText(false);
    }
}
