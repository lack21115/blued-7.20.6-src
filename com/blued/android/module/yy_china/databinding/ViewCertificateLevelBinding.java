package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewCertificateLevelBinding.class */
public final class ViewCertificateLevelBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16841a;
    public final RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16842c;
    public final TextView d;
    private final RelativeLayout e;

    private ViewCertificateLevelBinding(RelativeLayout relativeLayout, SquareImageView squareImageView, RelativeLayout relativeLayout2, TextView textView, TextView textView2) {
        this.e = relativeLayout;
        this.f16841a = squareImageView;
        this.b = relativeLayout2;
        this.f16842c = textView;
        this.d = textView2;
    }

    public static ViewCertificateLevelBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_certificate_level, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewCertificateLevelBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.img_certificate);
        if (squareImageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_certificate);
            if (relativeLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_certificate_name);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_certificate_num);
                    if (textView2 != null) {
                        return new ViewCertificateLevelBinding((RelativeLayout) view, squareImageView, relativeLayout, textView, textView2);
                    }
                    str = "tvCertificateNum";
                } else {
                    str = "tvCertificateName";
                }
            } else {
                str = "layoutCertificate";
            }
        } else {
            str = "imgCertificate";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.e;
    }
}
