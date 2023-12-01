package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKFirstPayView.class */
public class LivePKFirstPayView extends FrameLayout {
    private Context a;
    private LayoutInflater b;
    private View c;

    public LivePKFirstPayView(Context context) {
        this(context, null);
    }

    public LivePKFirstPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePKFirstPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_pk_first_pay_view, this);
        this.c = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setHorizontallyScrolling(true);
        textView.setMarqueeRepeatLimit(-1);
        textView.requestFocus();
        textView.setSelected(true);
    }

    public void setText(String str) {
        ((TextView) this.c.findViewById(R.id.tv_msg)).setText(str);
    }
}
