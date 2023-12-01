package com.blued.android.core.utils.toast.config;

import android.view.View;
import android.widget.TextView;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/config/IToast.class */
public interface IToast {

    /* renamed from: com.blued.android.core.utils.toast.config.IToast$-CC  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/config/IToast$-CC.class */
    public final /* synthetic */ class CC {
        public static TextView $default$a(IToast iToast, View view) {
            if (!(view instanceof TextView)) {
                View findViewById = view.findViewById(16908299);
                if (findViewById instanceof TextView) {
                    return (TextView) findViewById;
                }
                throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
            }
            if (view.getId() == -1) {
                view.setId(16908299);
            } else if (view.getId() != 16908299) {
                throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
            }
            return (TextView) view;
        }
    }

    TextView a(View view);

    void cancel();

    void setDuration(int i);

    void setGravity(int i, int i2, int i3);

    void setMargin(float f, float f2);

    void setText(CharSequence charSequence);

    void setView(View view);

    void show();
}
