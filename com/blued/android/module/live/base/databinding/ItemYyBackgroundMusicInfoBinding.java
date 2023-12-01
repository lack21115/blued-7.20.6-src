package com.blued.android.module.live.base.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/databinding/ItemYyBackgroundMusicInfoBinding.class */
public final class ItemYyBackgroundMusicInfoBinding implements ViewBinding {
    public final FrameLayout a;
    public final Guideline b;
    public final ImageView c;
    public final ShapeTextView d;
    public final ShapeTextView e;
    public final ShapeTextView f;
    public final ShapeableImageView g;
    public final TextView h;
    public final TextView i;
    private final ConstraintLayout j;

    private ItemYyBackgroundMusicInfoBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, Guideline guideline, ImageView imageView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ShapeTextView shapeTextView3, ShapeableImageView shapeableImageView, TextView textView, TextView textView2) {
        this.j = constraintLayout;
        this.a = frameLayout;
        this.b = guideline;
        this.c = imageView;
        this.d = shapeTextView;
        this.e = shapeTextView2;
        this.f = shapeTextView3;
        this.g = shapeableImageView;
        this.h = textView;
        this.i = textView2;
    }

    public static ItemYyBackgroundMusicInfoBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl);
        if (frameLayout != null) {
            Guideline findViewById = view.findViewById(R.id.guide_line);
            if (findViewById != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
                if (imageView != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_loading);
                    if (shapeTextView != null) {
                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.iv_playing);
                        if (shapeTextView2 != null) {
                            ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.iv_start);
                            if (shapeTextView3 != null) {
                                ShapeableImageView findViewById2 = view.findViewById(R.id.music_cover);
                                if (findViewById2 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_music_name);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_music_writer);
                                        if (textView2 != null) {
                                            return new ItemYyBackgroundMusicInfoBinding((ConstraintLayout) view, frameLayout, findViewById, imageView, shapeTextView, shapeTextView2, shapeTextView3, findViewById2, textView, textView2);
                                        }
                                        str = "tvMusicWriter";
                                    } else {
                                        str = "tvMusicName";
                                    }
                                } else {
                                    str = "musicCover";
                                }
                            } else {
                                str = "ivStart";
                            }
                        } else {
                            str = "ivPlaying";
                        }
                    } else {
                        str = "ivLoading";
                    }
                } else {
                    str = "imgLogo";
                }
            } else {
                str = "guideLine";
            }
        } else {
            str = "fl";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.j;
    }
}
