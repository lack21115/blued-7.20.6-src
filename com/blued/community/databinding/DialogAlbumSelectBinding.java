package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogAlbumSelectBinding.class */
public final class DialogAlbumSelectBinding implements ViewBinding {
    public final FrameLayout a;
    public final ShapeLinearLayout b;
    public final FrameLayout c;
    public final View d;
    public final ShapeFrameLayout e;
    public final View f;
    private final FrameLayout g;

    private DialogAlbumSelectBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ShapeLinearLayout shapeLinearLayout, FrameLayout frameLayout3, View view, ShapeFrameLayout shapeFrameLayout, View view2) {
        this.g = frameLayout;
        this.a = frameLayout2;
        this.b = shapeLinearLayout;
        this.c = frameLayout3;
        this.d = view;
        this.e = shapeFrameLayout;
        this.f = view2;
    }

    public static DialogAlbumSelectBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_album_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogAlbumSelectBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fragment_layout);
        if (frameLayout != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layoutReadAuth);
            if (shapeLinearLayout != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.rootLayout);
                if (frameLayout2 != null) {
                    View findViewById = view.findViewById(R.id.titleBarTouch);
                    if (findViewById != null) {
                        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.titleTouch);
                        if (shapeFrameLayout != null) {
                            View findViewById2 = view.findViewById(R.id.viewTitleBg);
                            if (findViewById2 != null) {
                                return new DialogAlbumSelectBinding((FrameLayout) view, frameLayout, shapeLinearLayout, frameLayout2, findViewById, shapeFrameLayout, findViewById2);
                            }
                            str = "viewTitleBg";
                        } else {
                            str = "titleTouch";
                        }
                    } else {
                        str = "titleBarTouch";
                    }
                } else {
                    str = "rootLayout";
                }
            } else {
                str = "layoutReadAuth";
            }
        } else {
            str = "fragmentLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.g;
    }
}
