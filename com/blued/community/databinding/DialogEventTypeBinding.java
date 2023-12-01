package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogEventTypeBinding.class */
public final class DialogEventTypeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f18799a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f18800c;
    public final FrameLayout d;
    private final FrameLayout e;

    private DialogEventTypeBinding(FrameLayout frameLayout, ImageView imageView, ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView, FrameLayout frameLayout2) {
        this.e = frameLayout;
        this.f18799a = imageView;
        this.b = shapeLinearLayout;
        this.f18800c = recyclerView;
        this.d = frameLayout2;
    }

    public static DialogEventTypeBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogEventTypeBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_event_type, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogEventTypeBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
        if (imageView != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layout_event_type);
            if (shapeLinearLayout != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
                if (recyclerView != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rootLayout);
                    if (frameLayout != null) {
                        return new DialogEventTypeBinding((FrameLayout) view, imageView, shapeLinearLayout, recyclerView, frameLayout);
                    }
                    str = "rootLayout";
                } else {
                    str = "recycleView";
                }
            } else {
                str = "layoutEventType";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
