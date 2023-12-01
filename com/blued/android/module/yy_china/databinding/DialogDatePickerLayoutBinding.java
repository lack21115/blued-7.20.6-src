package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.scrollpicker.StringScrollPicker;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogDatePickerLayoutBinding.class */
public final class DialogDatePickerLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f16324a;
    public final StringScrollPicker b;

    /* renamed from: c  reason: collision with root package name */
    public final StringScrollPicker f16325c;
    public final StringScrollPicker d;
    public final StringScrollPicker e;
    public final TextView f;
    public final TextView g;
    private final ConstraintLayout h;

    private DialogDatePickerLayoutBinding(ConstraintLayout constraintLayout, View view, StringScrollPicker stringScrollPicker, StringScrollPicker stringScrollPicker2, StringScrollPicker stringScrollPicker3, StringScrollPicker stringScrollPicker4, TextView textView, TextView textView2) {
        this.h = constraintLayout;
        this.f16324a = view;
        this.b = stringScrollPicker;
        this.f16325c = stringScrollPicker2;
        this.d = stringScrollPicker3;
        this.e = stringScrollPicker4;
        this.f = textView;
        this.g = textView2;
    }

    public static DialogDatePickerLayoutBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            StringScrollPicker stringScrollPicker = (StringScrollPicker) view.findViewById(R.id.sp_day);
            if (stringScrollPicker != null) {
                StringScrollPicker stringScrollPicker2 = (StringScrollPicker) view.findViewById(R.id.sp_hour);
                if (stringScrollPicker2 != null) {
                    StringScrollPicker stringScrollPicker3 = (StringScrollPicker) view.findViewById(R.id.sp_min);
                    if (stringScrollPicker3 != null) {
                        StringScrollPicker stringScrollPicker4 = (StringScrollPicker) view.findViewById(R.id.sp_second);
                        if (stringScrollPicker4 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_cancel);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_save);
                                if (textView2 != null) {
                                    return new DialogDatePickerLayoutBinding((ConstraintLayout) view, findViewById, stringScrollPicker, stringScrollPicker2, stringScrollPicker3, stringScrollPicker4, textView, textView2);
                                }
                                str = "tvSave";
                            } else {
                                str = "tvCancel";
                            }
                        } else {
                            str = "spSecond";
                        }
                    } else {
                        str = "spMin";
                    }
                } else {
                    str = "spHour";
                }
            } else {
                str = "spDay";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
