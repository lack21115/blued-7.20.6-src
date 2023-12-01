package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogKtvCommonLayoutBinding.class */
public final class DialogKtvCommonLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16357a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16358c;
    public final TextView d;
    public final TextView e;
    private final FrameLayout f;

    private DialogKtvCommonLayoutBinding(FrameLayout frameLayout, TextView textView, View view, TextView textView2, TextView textView3, TextView textView4) {
        this.f = frameLayout;
        this.f16357a = textView;
        this.b = view;
        this.f16358c = textView2;
        this.d = textView3;
        this.e = textView4;
    }

    public static DialogKtvCommonLayoutBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.close);
        if (textView != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.dialog_content);
                if (textView2 != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.dialog_title);
                    if (textView3 != null) {
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_ok);
                        if (textView4 != null) {
                            return new DialogKtvCommonLayoutBinding((FrameLayout) view, textView, findViewById, textView2, textView3, textView4);
                        }
                        str = "tvOk";
                    } else {
                        str = WbCloudFaceContant.DIALOG_TITLE;
                    }
                } else {
                    str = "dialogContent";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "close";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
