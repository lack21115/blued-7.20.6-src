package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/ScrollTextViewNew.class */
public class ScrollTextViewNew extends LinearLayout {
    public static Pattern a = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");
    public boolean b;
    private Context c;
    private LayoutInflater d;
    private TextView e;
    private float f;
    private float g;
    private float h;
    private OnScrollListener i;
    private LiveHornModelNew j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/ScrollTextViewNew$OnScrollListener.class */
    public interface OnScrollListener {
        void a();
    }

    public ScrollTextViewNew(Context context) {
        super(context);
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.b = false;
        this.c = context;
        c();
    }

    public ScrollTextViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.b = false;
        this.c = context;
        c();
    }

    public ScrollTextViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.b = false;
        this.c = context;
        c();
    }

    public static CharSequence a(CharSequence charSequence, String str) {
        boolean z;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = null;
        Matcher matcher = a.matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
            if (spannableStringBuilder == null) {
                spannableStringBuilder2 = new SpannableStringBuilder();
            }
            String group = matcher.group(1);
            spannableStringBuilder2.append(charSequence.subSequence(i, matcher.start()));
            int length = spannableStringBuilder2.length();
            int length2 = group.length() + length;
            spannableStringBuilder2.append((CharSequence) group);
            try {
                Color.parseColor(str);
                z = true;
            } catch (Exception e) {
                z = false;
            }
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(Color.parseColor(z ? str : "#ffef5f")), length, length2, 33);
            spannableStringBuilder2.setSpan(new StyleSpan(1), length, length2, 33);
            i = matcher.end();
            spannableStringBuilder = spannableStringBuilder2;
        }
        if (spannableStringBuilder != null && i < charSequence.length() - 1) {
            spannableStringBuilder.append(charSequence.subSequence(i, charSequence.length()));
        }
        return spannableStringBuilder != null ? spannableStringBuilder : charSequence;
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.c);
        this.d = from;
        View inflate = from.inflate(R.layout.scroll_text_layout_new, (ViewGroup) null);
        this.e = (TextView) inflate.findViewById(R.id.scroll_text);
        setWillNotDraw(false);
        addView(inflate);
    }

    public void a() {
        this.b = true;
        invalidate();
    }

    public void a(LiveHornModelNew liveHornModelNew) {
        if (liveHornModelNew == null) {
            return;
        }
        this.j = liveHornModelNew;
        TextPaint paint = this.e.getPaint();
        this.e.setText(liveHornModelNew.contents);
        try {
            this.e.setTextColor(Color.parseColor(liveHornModelNew.color));
        } catch (Exception e) {
            this.e.setTextColor(-1);
        }
        if (TextUtils.isEmpty(liveHornModelNew.contents)) {
            return;
        }
        CharSequence a2 = a(new SpannableString(liveHornModelNew.contents), liveHornModelNew.highlight_color);
        this.e.setText(a2);
        this.f = paint.measureText(a2.toString()) + AppMethods.a(8);
    }

    public void b() {
        this.b = false;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.translate(this.g, 0.0f);
        if (!this.b) {
            super.onDraw(canvas);
            return;
        }
        float f = this.g - 3.0f;
        this.g = f;
        if (f <= (-this.f)) {
            this.g = 0.0f;
            b();
            OnScrollListener onScrollListener = this.i;
            if (onScrollListener != null) {
                onScrollListener.a();
            }
        }
        invalidate();
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure((int) this.f, i2);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.i = onScrollListener;
    }
}
