package com.blued.android.module.live.base.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/YyMusicSearchViewBinding.class */
public final class YyMusicSearchViewBinding implements ViewBinding {
    public final EditText a;
    public final ImageView b;
    public final FrameLayout c;
    public final LinearLayout d;
    public final FlowLayout e;
    public final TextView f;
    public final TextView g;
    private final LinearLayout h;

    private YyMusicSearchViewBinding(LinearLayout linearLayout, EditText editText, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout2, FlowLayout flowLayout, TextView textView, TextView textView2) {
        this.h = linearLayout;
        this.a = editText;
        this.b = imageView;
        this.c = frameLayout;
        this.d = linearLayout2;
        this.e = flowLayout;
        this.f = textView;
        this.g = textView2;
    }

    public static YyMusicSearchViewBinding a(View view) {
        String str;
        EditText editText = (EditText) view.findViewById(R.id.edit_view);
        if (editText != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_search_clear);
            if (imageView != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.live_music_search_container_layout_id);
                if (frameLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_search_history);
                    if (linearLayout != null) {
                        FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.music_history);
                        if (flowLayout != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_history_clear);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_search_close);
                                if (textView2 != null) {
                                    return new YyMusicSearchViewBinding((LinearLayout) view, editText, imageView, frameLayout, linearLayout, flowLayout, textView, textView2);
                                }
                                str = "tvSearchClose";
                            } else {
                                str = "tvHistoryClear";
                            }
                        } else {
                            str = "musicHistory";
                        }
                    } else {
                        str = "llSearchHistory";
                    }
                } else {
                    str = "liveMusicSearchContainerLayoutId";
                }
            } else {
                str = "ivSearchClear";
            }
        } else {
            str = "editView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
