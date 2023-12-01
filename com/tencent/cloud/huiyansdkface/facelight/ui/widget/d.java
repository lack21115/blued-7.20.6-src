package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/d.class */
public class d extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f22099a;
    int b;

    public d(View.OnClickListener onClickListener, int i) {
        this.f22099a = onClickListener;
        this.b = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        this.f22099a.onClick(view);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.b);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
