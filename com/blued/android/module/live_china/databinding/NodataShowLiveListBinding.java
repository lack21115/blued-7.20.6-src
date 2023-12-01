package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/NodataShowLiveListBinding.class */
public final class NodataShowLiveListBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f12443a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12444c;
    private final LinearLayout d;

    private NodataShowLiveListBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.d = linearLayout;
        this.f12443a = textView;
        this.b = textView2;
        this.f12444c = textView3;
    }

    public static NodataShowLiveListBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_live_detail_txt);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.tv_live_start_btn);
            if (textView2 != null) {
                TextView textView3 = (TextView) view.findViewById(R.id.tv_live_start_txt);
                if (textView3 != null) {
                    return new NodataShowLiveListBinding((LinearLayout) view, textView, textView2, textView3);
                }
                str = "tvLiveStartTxt";
            } else {
                str = "tvLiveStartBtn";
            }
        } else {
            str = "tvLiveDetailTxt";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
