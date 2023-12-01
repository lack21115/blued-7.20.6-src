package com.sobot.chat.widget.rich;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.sobot.chat.activity.WebViewActivity;
import com.sobot.chat.api.apiUtils.ZhiChiConstants;
import com.sobot.chat.utils.CommonUtils;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.SobotOption;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/rich/MyURLSpan.class */
public class MyURLSpan extends URLSpan {
    private int color;
    private Context context;
    private boolean isShowLine;

    public MyURLSpan(Context context, String str, int i) {
        this(context, str, i, false);
    }

    public MyURLSpan(Context context, String str, int i, boolean z) {
        super(str);
        this.context = context;
        this.color = context.getResources().getColor(i);
        this.isShowLine = z;
    }

    private String fixUrl(String str) {
        String str2 = str;
        if (!str.startsWith("http://")) {
            str2 = str;
            if (!str.startsWith("https://")) {
                str2 = "https://" + str;
                LogUtils.i("url:" + str2);
            }
        }
        return str2;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        String url = getURL();
        if (url.startsWith("sobot:")) {
            if ("sobot:SobotPostMsgActivity".equals(url)) {
                Intent intent = new Intent();
                intent.setAction(ZhiChiConstants.chat_remind_post_msg);
                CommonUtils.sendLocalBroadcast(this.context, intent);
            } else if ("sobot:SobotTicketInfo".equals(url)) {
                Intent intent2 = new Intent();
                intent2.putExtra("isShowTicket", true);
                intent2.setAction(ZhiChiConstants.chat_remind_post_msg);
                CommonUtils.sendLocalBroadcast(this.context, intent2);
            } else if ("sobot:SobotToCustomer".equals(url)) {
                Intent intent3 = new Intent();
                intent3.setAction(ZhiChiConstants.chat_remind_to_customer);
                CommonUtils.sendLocalBroadcast(this.context, intent3);
            }
        } else if (url.endsWith(".doc") || url.endsWith(".docx") || url.endsWith(".xls") || url.endsWith(".txt") || url.endsWith(".ppt") || url.endsWith(".pptx") || url.endsWith(".xlsx") || url.endsWith(".pdf") || url.endsWith(".rar") || url.endsWith(".zip")) {
            if (SobotOption.hyperlinkListener != null) {
                SobotOption.hyperlinkListener.onUrlClick(url);
            } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(this.context, url)) {
                String fixUrl = fixUrl(url);
                Intent intent4 = new Intent();
                intent4.setAction("android.intent.action.VIEW");
                intent4.addFlags(268435456);
                intent4.setData(Uri.parse(fixUrl));
                this.context.startActivity(intent4);
            }
        } else if (url.startsWith("tel:")) {
            if (SobotOption.hyperlinkListener != null) {
                SobotOption.hyperlinkListener.onPhoneClick(url);
            } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onPhoneClick(this.context, url)) {
                Intent intent5 = new Intent();
                intent5.setAction("android.intent.action.VIEW");
                intent5.addFlags(268435456);
                intent5.setData(Uri.parse(url));
                this.context.startActivity(intent5);
            }
        } else if (SobotOption.hyperlinkListener != null) {
            SobotOption.hyperlinkListener.onUrlClick(url);
        } else if (SobotOption.newHyperlinkListener == null || !SobotOption.newHyperlinkListener.onUrlClick(this.context, url)) {
            String fixUrl2 = fixUrl(url);
            Intent intent6 = new Intent(this.context, WebViewActivity.class);
            intent6.putExtra("url", fixUrl2);
            intent6.addFlags(268435456);
            this.context.startActivity(intent6);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.color);
        textPaint.setUnderlineText(this.isShowLine);
    }
}
