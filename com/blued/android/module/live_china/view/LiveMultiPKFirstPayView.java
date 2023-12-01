package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPKFirstPayView.class */
public class LiveMultiPKFirstPayView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f14632a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f14633c;

    public LiveMultiPKFirstPayView(Context context) {
        this(context, null);
    }

    public LiveMultiPKFirstPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMultiPKFirstPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14632a = context;
        a();
    }

    private void a() {
        LayoutInflater from = LayoutInflater.from(this.f14632a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_multi_pk_first_pay_view, this);
        this.f14633c = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setHorizontallyScrolling(true);
        textView.setMarqueeRepeatLimit(-1);
        textView.requestFocus();
        textView.setSelected(true);
    }

    public void setText(String str) {
        ((TextView) this.f14633c.findViewById(R.id.tv_msg)).setText(str);
    }
}
