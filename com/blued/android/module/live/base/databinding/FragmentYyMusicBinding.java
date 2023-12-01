package com.blued.android.module.live.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.live.base.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/FragmentYyMusicBinding.class */
public final class FragmentYyMusicBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f11378a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeLinearLayout f11379c;
    public final YyBaseMusicMainViewBinding d;
    public final YyMusicSearchViewBinding e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    private final LinearLayout i;

    private FragmentYyMusicBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, ShapeLinearLayout shapeLinearLayout, YyBaseMusicMainViewBinding yyBaseMusicMainViewBinding, YyMusicSearchViewBinding yyMusicSearchViewBinding, ImageView imageView2, TextView textView, TextView textView2) {
        this.i = linearLayout;
        this.f11378a = imageView;
        this.b = linearLayout2;
        this.f11379c = shapeLinearLayout;
        this.d = yyBaseMusicMainViewBinding;
        this.e = yyMusicSearchViewBinding;
        this.f = imageView2;
        this.g = textView;
        this.h = textView2;
    }

    public static FragmentYyMusicBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_yy_music, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentYyMusicBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.empty_view);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fl_make_lover_dialog);
            if (linearLayout != null) {
                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.fl_player);
                if (shapeLinearLayout != null) {
                    View findViewById = view.findViewById(R.id.inc_main);
                    if (findViewById != null) {
                        YyBaseMusicMainViewBinding a2 = YyBaseMusicMainViewBinding.a(findViewById);
                        View findViewById2 = view.findViewById(R.id.inv_search);
                        if (findViewById2 != null) {
                            YyMusicSearchViewBinding a3 = YyMusicSearchViewBinding.a(findViewById2);
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_start);
                            if (imageView2 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_exit);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_time);
                                    if (textView2 != null) {
                                        return new FragmentYyMusicBinding((LinearLayout) view, imageView, linearLayout, shapeLinearLayout, a2, a3, imageView2, textView, textView2);
                                    }
                                    str = "tvTime";
                                } else {
                                    str = "tvExit";
                                }
                            } else {
                                str = "ivStart";
                            }
                        } else {
                            str = "invSearch";
                        }
                    } else {
                        str = "incMain";
                    }
                } else {
                    str = "flPlayer";
                }
            } else {
                str = "flMakeLoverDialog";
            }
        } else {
            str = "emptyView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.i;
    }
}
