package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvVoiceBinding.class */
public final class FragmentYyKtvVoiceBinding implements ViewBinding {
    public final SeekBar a;
    public final SeekBar b;
    public final ImageView c;
    public final ToggleButton d;
    public final ShapeTextView e;
    public final ImageView f;
    public final View g;
    public final TextView h;
    public final FrameLayout i;
    public final FrameLayout j;
    public final RecyclerView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    private final ConstraintLayout s;

    private FragmentYyKtvVoiceBinding(ConstraintLayout constraintLayout, SeekBar seekBar, SeekBar seekBar2, ImageView imageView, ToggleButton toggleButton, ShapeTextView shapeTextView, ImageView imageView2, View view, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.s = constraintLayout;
        this.a = seekBar;
        this.b = seekBar2;
        this.c = imageView;
        this.d = toggleButton;
        this.e = shapeTextView;
        this.f = imageView2;
        this.g = view;
        this.h = textView;
        this.i = frameLayout;
        this.j = frameLayout2;
        this.k = recyclerView;
        this.l = textView2;
        this.m = textView3;
        this.n = textView4;
        this.o = textView5;
        this.p = textView6;
        this.q = textView7;
        this.r = textView8;
    }

    public static FragmentYyKtvVoiceBinding a(View view) {
        String str;
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.bar_accompany);
        if (seekBar != null) {
            SeekBar seekBar2 = (SeekBar) view.findViewById(R.id.bar_voice);
            if (seekBar2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.btn_down_tone);
                if (imageView != null) {
                    ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.btn_earphone_toggle);
                    if (toggleButton != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_normal);
                        if (shapeTextView != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_up_tone);
                            if (imageView2 != null) {
                                View findViewById = view.findViewById(R.id.cover_view);
                                if (findViewById != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.dialog_title);
                                    if (textView != null) {
                                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_bar_voice);
                                        if (frameLayout != null) {
                                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_companion);
                                            if (frameLayout2 != null) {
                                                RecyclerView findViewById2 = view.findViewById(R.id.rv_effect_list);
                                                if (findViewById2 != null) {
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_audio_effect);
                                                    if (textView2 != null) {
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_accompany);
                                                        if (textView3 != null) {
                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_music);
                                                            if (textView4 != null) {
                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_earphone_effect);
                                                                if (textView5 != null) {
                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_earphone_notice);
                                                                    if (textView6 != null) {
                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_tone_num);
                                                                        if (textView7 != null) {
                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_up_down_tone);
                                                                            if (textView8 != null) {
                                                                                return new FragmentYyKtvVoiceBinding((ConstraintLayout) view, seekBar, seekBar2, imageView, toggleButton, shapeTextView, imageView2, findViewById, textView, frameLayout, frameLayout2, findViewById2, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                                                            }
                                                                            str = "tvUpDownTone";
                                                                        } else {
                                                                            str = "tvToneNum";
                                                                        }
                                                                    } else {
                                                                        str = "tvEarphoneNotice";
                                                                    }
                                                                } else {
                                                                    str = "tvEarphoneEffect";
                                                                }
                                                            } else {
                                                                str = "tvDialogMusic";
                                                            }
                                                        } else {
                                                            str = "tvDialogAccompany";
                                                        }
                                                    } else {
                                                        str = "tvAudioEffect";
                                                    }
                                                } else {
                                                    str = "rvEffectList";
                                                }
                                            } else {
                                                str = "flCompanion";
                                            }
                                        } else {
                                            str = "flBarVoice";
                                        }
                                    } else {
                                        str = "dialogTitle";
                                    }
                                } else {
                                    str = "coverView";
                                }
                            } else {
                                str = "btnUpTone";
                            }
                        } else {
                            str = "btnNormal";
                        }
                    } else {
                        str = "btnEarphoneToggle";
                    }
                } else {
                    str = "btnDownTone";
                }
            } else {
                str = "barVoice";
            }
        } else {
            str = "barAccompany";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.s;
    }
}
