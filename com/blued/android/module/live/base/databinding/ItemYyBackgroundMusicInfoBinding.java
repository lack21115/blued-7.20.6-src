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

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f11385a;
    public final Guideline b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f11386c;
    public final ShapeTextView d;
    public final ShapeTextView e;
    public final ShapeTextView f;
    public final ShapeableImageView g;
    public final TextView h;
    public final TextView i;
    private final ConstraintLayout j;

    private ItemYyBackgroundMusicInfoBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, Guideline guideline, ImageView imageView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ShapeTextView shapeTextView3, ShapeableImageView shapeableImageView, TextView textView, TextView textView2) {
        this.j = constraintLayout;
        this.f11385a = frameLayout;
        this.b = guideline;
        this.f11386c = imageView;
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
            Guideline guideline = (Guideline) view.findViewById(R.id.guide_line);
            if (guideline != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_logo);
                if (imageView != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_loading);
                    if (shapeTextView != null) {
                        ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.iv_playing);
                        if (shapeTextView2 != null) {
                            ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.iv_start);
                            if (shapeTextView3 != null) {
                                ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.music_cover);
                                if (shapeableImageView != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_music_name);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_music_writer);
                                        if (textView2 != null) {
                                            return new ItemYyBackgroundMusicInfoBinding((ConstraintLayout) view, frameLayout, guideline, imageView, shapeTextView, shapeTextView2, shapeTextView3, shapeableImageView, textView, textView2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.j;
    }
}
