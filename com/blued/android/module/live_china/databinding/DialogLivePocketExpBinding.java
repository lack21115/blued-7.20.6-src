package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLivePocketExpBinding.class */
public final class DialogLivePocketExpBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ListView f11801a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f11802c;

    private DialogLivePocketExpBinding(FrameLayout frameLayout, ListView listView, LinearLayout linearLayout) {
        this.f11802c = frameLayout;
        this.f11801a = listView;
        this.b = linearLayout;
    }

    public static DialogLivePocketExpBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_pocket_exp, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLivePocketExpBinding a(View view) {
        String str;
        ListView listView = (ListView) view.findViewById(R.id.listview);
        if (listView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_default);
            if (linearLayout != null) {
                return new DialogLivePocketExpBinding((FrameLayout) view, listView, linearLayout);
            }
            str = "llDefault";
        } else {
            str = "listview";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f11802c;
    }
}
