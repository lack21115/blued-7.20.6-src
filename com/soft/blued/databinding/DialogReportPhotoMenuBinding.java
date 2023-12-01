package com.soft.blued.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/DialogReportPhotoMenuBinding.class */
public final class DialogReportPhotoMenuBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f15030a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f15031c;
    public final TextView d;
    public final TextView e;
    private final FrameLayout f;

    private DialogReportPhotoMenuBinding(FrameLayout frameLayout, ShapeLinearLayout shapeLinearLayout, LinearLayout linearLayout, FrameLayout frameLayout2, TextView textView, TextView textView2) {
        this.f = frameLayout;
        this.f15030a = shapeLinearLayout;
        this.b = linearLayout;
        this.f15031c = frameLayout2;
        this.d = textView;
        this.e = textView2;
    }

    public static DialogReportPhotoMenuBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogReportPhotoMenuBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_report_photo_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogReportPhotoMenuBinding a(View view) {
        String str;
        ShapeLinearLayout findViewById = view.findViewById(R.id.layout_event_type);
        if (findViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_camera);
            if (linearLayout != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rootLayout);
                if (frameLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_album);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(2131371051);
                        if (textView2 != null) {
                            return new DialogReportPhotoMenuBinding((FrameLayout) view, findViewById, linearLayout, frameLayout, textView, textView2);
                        }
                        str = "tvCancel";
                    } else {
                        str = "tvAlbum";
                    }
                } else {
                    str = "rootLayout";
                }
            } else {
                str = "llCamera";
            }
        } else {
            str = "layoutEventType";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
