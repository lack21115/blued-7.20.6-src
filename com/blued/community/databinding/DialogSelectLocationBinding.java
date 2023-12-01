package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.SearchView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogSelectLocationBinding.class */
public final class DialogSelectLocationBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f18807a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f18808c;
    public final FrameLayout d;
    public final SearchView e;
    private final FrameLayout f;

    private DialogSelectLocationBinding(FrameLayout frameLayout, ImageView imageView, ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView, FrameLayout frameLayout2, SearchView searchView) {
        this.f = frameLayout;
        this.f18807a = imageView;
        this.b = shapeLinearLayout;
        this.f18808c = recyclerView;
        this.d = frameLayout2;
        this.e = searchView;
    }

    public static DialogSelectLocationBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogSelectLocationBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_select_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogSelectLocationBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
        if (imageView != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layoutLocation);
            if (shapeLinearLayout != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
                if (recyclerView != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.rootLayout);
                    if (frameLayout != null) {
                        SearchView searchView = (SearchView) view.findViewById(R.id.searchBar);
                        if (searchView != null) {
                            return new DialogSelectLocationBinding((FrameLayout) view, imageView, shapeLinearLayout, recyclerView, frameLayout, searchView);
                        }
                        str = "searchBar";
                    } else {
                        str = "rootLayout";
                    }
                } else {
                    str = "recycleView";
                }
            } else {
                str = "layoutLocation";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f;
    }
}
