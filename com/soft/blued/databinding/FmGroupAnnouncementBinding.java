package com.soft.blued.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmGroupAnnouncementBinding.class */
public final class FmGroupAnnouncementBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f28747a;
    public final FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f28748c;
    public final CommonTopTitleNoTrans d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    private final LinearLayout h;

    private FmGroupAnnouncementBinding(LinearLayout linearLayout, EditText editText, FrameLayout frameLayout, RelativeLayout relativeLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2, TextView textView3) {
        this.h = linearLayout;
        this.f28747a = editText;
        this.b = frameLayout;
        this.f28748c = relativeLayout;
        this.d = commonTopTitleNoTrans;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    public static FmGroupAnnouncementBinding a(View view) {
        String str;
        EditText editText = (EditText) view.findViewById(R.id.et);
        if (editText != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fm_bg);
            if (frameLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_edit);
                if (relativeLayout != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370694);
                    if (commonTopTitleNoTrans != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_default);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(2131371322);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(2131372144);
                                if (textView3 != null) {
                                    return new FmGroupAnnouncementBinding((LinearLayout) view, editText, frameLayout, relativeLayout, commonTopTitleNoTrans, textView, textView2, textView3);
                                }
                                str = "tvNum";
                            } else {
                                str = "tvEmpty";
                            }
                        } else {
                            str = "tvDefault";
                        }
                    } else {
                        str = "title";
                    }
                } else {
                    str = "rlEdit";
                }
            } else {
                str = "fmBg";
            }
        } else {
            str = "et";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
