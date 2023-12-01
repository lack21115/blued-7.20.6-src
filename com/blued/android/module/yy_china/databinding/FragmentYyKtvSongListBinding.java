package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvSongListBinding.class */
public final class FragmentYyKtvSongListBinding implements ViewBinding {
    public final View a;
    public final RecyclerView b;
    public final TextView c;
    private final ConstraintLayout d;

    private FragmentYyKtvSongListBinding(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, TextView textView) {
        this.d = constraintLayout;
        this.a = view;
        this.b = recyclerView;
        this.c = textView;
    }

    public static FragmentYyKtvSongListBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            RecyclerView findViewById2 = view.findViewById(R.id.rv_song_list);
            if (findViewById2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_red_envelope_title);
                if (textView != null) {
                    return new FragmentYyKtvSongListBinding((ConstraintLayout) view, findViewById, findViewById2, textView);
                }
                str = "tvRedEnvelopeTitle";
            } else {
                str = "rvSongList";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
