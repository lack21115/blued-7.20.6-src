package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmMsgBackupBinding.class */
public final class FmMsgBackupBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f15061a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final CommonTopTitleNoTrans f15062c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    private final LinearLayout g;

    private FmMsgBackupBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2, TextView textView3) {
        this.g = linearLayout;
        this.f15061a = linearLayout2;
        this.b = linearLayout3;
        this.f15062c = commonTopTitleNoTrans;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static FmMsgBackupBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_backup_chat_record);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_restore_chat_record);
            if (linearLayout2 != null) {
                CommonTopTitleNoTrans findViewById = view.findViewById(R.id.top_title);
                if (findViewById != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_date);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_delete);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_link);
                            if (textView3 != null) {
                                return new FmMsgBackupBinding((LinearLayout) view, linearLayout, linearLayout2, findViewById, textView, textView2, textView3);
                            }
                            str = "tvLink";
                        } else {
                            str = "tvDelete";
                        }
                    } else {
                        str = "tvDate";
                    }
                } else {
                    str = "topTitle";
                }
            } else {
                str = "llRestoreChatRecord";
            }
        } else {
            str = "llBackupChatRecord";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
