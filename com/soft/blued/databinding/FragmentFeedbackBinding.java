package com.soft.blued.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.view.EditInputNumView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentFeedbackBinding.class */
public final class FragmentFeedbackBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f15129a;
    public final EditInputNumView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f15130c;
    public final CommonTopTitleNoTrans d;
    public final TextView e;
    public final ShapeTextView f;
    public final TextView g;
    private final ConstraintLayout h;

    private FragmentFeedbackBinding(ConstraintLayout constraintLayout, EditText editText, EditInputNumView editInputNumView, RecyclerView recyclerView, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, ShapeTextView shapeTextView, TextView textView2) {
        this.h = constraintLayout;
        this.f15129a = editText;
        this.b = editInputNumView;
        this.f15130c = recyclerView;
        this.d = commonTopTitleNoTrans;
        this.e = textView;
        this.f = shapeTextView;
        this.g = textView2;
    }

    public static FragmentFeedbackBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_feedback, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentFeedbackBinding a(View view) {
        String str;
        EditText editText = (EditText) view.findViewById(R.id.et_question);
        if (editText != null) {
            EditInputNumView editInputNumView = (EditInputNumView) view.findViewById(R.id.inv_word_count);
            if (editInputNumView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_type_list);
                if (recyclerView != null) {
                    CommonTopTitleNoTrans findViewById = view.findViewById(R.id.top_title);
                    if (findViewById != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_question_title);
                        if (textView != null) {
                            ShapeTextView findViewById2 = view.findViewById(R.id.tv_submit);
                            if (findViewById2 != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_type_title);
                                if (textView2 != null) {
                                    return new FragmentFeedbackBinding((ConstraintLayout) view, editText, editInputNumView, recyclerView, findViewById, textView, findViewById2, textView2);
                                }
                                str = "tvTypeTitle";
                            } else {
                                str = "tvSubmit";
                            }
                        } else {
                            str = "tvQuestionTitle";
                        }
                    } else {
                        str = "topTitle";
                    }
                } else {
                    str = "rvTypeList";
                }
            } else {
                str = "invWordCount";
            }
        } else {
            str = "etQuestion";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
