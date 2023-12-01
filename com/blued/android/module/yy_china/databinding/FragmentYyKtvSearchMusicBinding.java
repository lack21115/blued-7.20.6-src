package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.android.module.yy_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyKtvSearchMusicBinding.class */
public final class FragmentYyKtvSearchMusicBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final TextView c;
    public final EditText d;
    public final LinearLayout e;
    public final ShapeLinearLayout f;
    public final FlowLayout g;
    public final RecyclerView h;
    public final SmartRefreshLayout i;
    public final TextView j;
    private final FrameLayout k;

    private FragmentYyKtvSearchMusicBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, View view, TextView textView, EditText editText, LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, FlowLayout flowLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView2) {
        this.k = frameLayout;
        this.a = constraintLayout;
        this.b = view;
        this.c = textView;
        this.d = editText;
        this.e = linearLayout;
        this.f = shapeLinearLayout;
        this.g = flowLayout;
        this.h = recyclerView;
        this.i = smartRefreshLayout;
        this.j = textView2;
    }

    public static FragmentYyKtvSearchMusicBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.con_cont);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(R.id.cover_view);
            if (findViewById2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.dialog_title);
                if (textView != null) {
                    EditText editText = (EditText) view.findViewById(R.id.et_keyword);
                    if (editText != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_history);
                        if (linearLayout != null) {
                            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_search_music);
                            if (shapeLinearLayout != null) {
                                FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.rv_historical_record);
                                if (flowLayout != null) {
                                    RecyclerView findViewById3 = view.findViewById(R.id.rv_music_list);
                                    if (findViewById3 != null) {
                                        SmartRefreshLayout findViewById4 = view.findViewById(R.id.srl_layout);
                                        if (findViewById4 != null) {
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_cancel);
                                            if (textView2 != null) {
                                                return new FragmentYyKtvSearchMusicBinding((FrameLayout) view, findViewById, findViewById2, textView, editText, linearLayout, shapeLinearLayout, flowLayout, findViewById3, findViewById4, textView2);
                                            }
                                            str = "tvCancel";
                                        } else {
                                            str = "srlLayout";
                                        }
                                    } else {
                                        str = "rvMusicList";
                                    }
                                } else {
                                    str = "rvHistoricalRecord";
                                }
                            } else {
                                str = "llSearchMusic";
                            }
                        } else {
                            str = "llHistory";
                        }
                    } else {
                        str = "etKeyword";
                    }
                } else {
                    str = "dialogTitle";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "conCont";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.k;
    }
}
