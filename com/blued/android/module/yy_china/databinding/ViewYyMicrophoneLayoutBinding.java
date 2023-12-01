package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyMicrophoneLayoutBinding.class */
public final class ViewYyMicrophoneLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16939a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f16940c;

    private ViewYyMicrophoneLayoutBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2) {
        this.f16940c = frameLayout;
        this.f16939a = imageView;
        this.b = imageView2;
    }

    public static ViewYyMicrophoneLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_microphone_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyMicrophoneLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_audio);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.tv_up_seat);
            if (imageView2 != null) {
                return new ViewYyMicrophoneLayoutBinding((FrameLayout) view, imageView, imageView2);
            }
            str = "tvUpSeat";
        } else {
            str = "ivAudio";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f16940c;
    }
}
