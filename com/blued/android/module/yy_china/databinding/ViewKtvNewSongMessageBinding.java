package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewKtvNewSongMessageBinding.class */
public final class ViewKtvNewSongMessageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16864a;
    private final FrameLayout b;

    private ViewKtvNewSongMessageBinding(FrameLayout frameLayout, TextView textView) {
        this.b = frameLayout;
        this.f16864a = textView;
    }

    public static ViewKtvNewSongMessageBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_ktv_new_song_message, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewKtvNewSongMessageBinding a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_add_mess);
        if (textView != null) {
            return new ViewKtvNewSongMessageBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvAddMess"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.b;
    }
}
