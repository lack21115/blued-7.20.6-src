package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogChorusPlaylistBinding.class */
public final class DialogChorusPlaylistBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16307a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    public final SmartRefreshLayout f16308c;
    public final TextView d;
    public final ShapeTextView e;
    private final ConstraintLayout f;

    private DialogChorusPlaylistBinding(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, ShapeTextView shapeTextView) {
        this.f = constraintLayout;
        this.f16307a = view;
        this.b = recyclerView;
        this.f16308c = smartRefreshLayout;
        this.d = textView;
        this.e = shapeTextView;
    }

    public static DialogChorusPlaylistBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_playlist_view);
            if (recyclerView != null) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.srl_layout);
                if (smartRefreshLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_dialog_title);
                    if (textView != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_playlist_amount);
                        if (shapeTextView != null) {
                            return new DialogChorusPlaylistBinding((ConstraintLayout) view, findViewById, recyclerView, smartRefreshLayout, textView, shapeTextView);
                        }
                        str = "tvPlaylistAmount";
                    } else {
                        str = "tvDialogTitle";
                    }
                } else {
                    str = "srlLayout";
                }
            } else {
                str = "rvPlaylistView";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
