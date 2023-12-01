package com.blued.android.module.common.widget.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.common.R;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/CommonAlertDialog.class */
public class CommonAlertDialog {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/dialog/CommonAlertDialog$TextOnClickListener.class */
    public interface TextOnClickListener {
        void a(String str);
    }

    public static AlertDialog.Builder a(Context context) {
        int i = 2;
        if (((UiModeManager) context.getSystemService("uimode")).getNightMode() != 2) {
            i = 3;
        }
        return new AlertDialog.Builder(context, i);
    }

    public static AlertDialog a(Context context, String str, final int i, String str2, String str3, String str4, String str5, String str6, final TextOnClickListener textOnClickListener, DialogInterface.OnClickListener onClickListener) {
        if (str5 == null) {
            str5 = "";
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, DensityUtils.a(context, 10.0f), 0, DensityUtils.a(context, 10.0f));
        final EditText editText = new EditText(context);
        editText.setText(str5);
        editText.setHint(str6);
        editText.setSelection(str5.length());
        editText.setLayoutParams(layoutParams);
        editText.requestFocus();
        editText.setSingleLine(true);
        final TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, DensityUtils.a(context, 3.0f), 0);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(5);
        textView.setTextColor(context.getResources().getColor(R.color.common_v4_blue_frame_font));
        linearLayout.addView(editText);
        linearLayout.addView(textView);
        linearLayout.setPadding(DensityUtils.a(context, 22.0f), 0, DensityUtils.a(context, 27.0f), 0);
        int c = StringUtils.c(str5);
        textView.setText(c + BridgeUtil.SPLIT_MARK + i);
        editText.setSelection(str5.length());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.common.widget.dialog.CommonAlertDialog.1
            private int d;
            private int e;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    EditText.this.removeTextChangedListener(this);
                    this.d = EditText.this.getSelectionStart();
                    this.e = EditText.this.getSelectionEnd();
                    while (StringUtils.a(editable) > i) {
                        editable.delete(this.d - 1, this.e);
                        this.d--;
                        this.e--;
                    }
                    textView.setText(StringUtils.a(editable) + BridgeUtil.SPLIT_MARK + i);
                    EditText.this.setSelection(this.d);
                    EditText.this.addTextChangedListener(this);
                } catch (Exception e) {
                    e.printStackTrace();
                    textView.setText("");
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        AlertDialog.Builder a = a(context);
        AlertDialog.Builder view = a.setTitle(str).setView(linearLayout);
        if (TextUtils.isEmpty(str4)) {
            str4 = context.getResources().getString(R.string.biao_v4_ok);
        }
        AlertDialog.Builder positiveButton = view.setPositiveButton(str4, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.CommonAlertDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                TextOnClickListener textOnClickListener2 = TextOnClickListener.this;
                textOnClickListener2.a(((Object) editText.getText()) + "");
            }
        });
        if (TextUtils.isEmpty(str3)) {
            str3 = context.getResources().getString(R.string.cancel);
        }
        positiveButton.setNegativeButton(str3, onClickListener).setCancelable(true).setOnCancelListener(null);
        if (!TextUtils.isEmpty(str2)) {
            a.setMessage(str2);
        }
        AlertDialog create = a.create();
        create.getWindow().setSoftInputMode(5);
        create.setCanceledOnTouchOutside(true);
        create.show();
        return create;
    }

    @Deprecated
    public static Dialog a(Context context, View view, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        return a(context, view, str, str2, str3, str4, onClickListener, onClickListener2, onCancelListener, z, true);
    }

    @Deprecated
    public static Dialog a(Context context, View view, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, boolean z, boolean z2) {
        AlertDialog.Builder a = a(context);
        AlertDialog.Builder view2 = a.setTitle(str).setView(view);
        String str5 = str4;
        if (TextUtils.isEmpty(str4)) {
            str5 = context.getResources().getString(R.string.biao_v4_ok);
        }
        AlertDialog.Builder positiveButton = view2.setPositiveButton(str5, onClickListener);
        String str6 = str3;
        if (TextUtils.isEmpty(str3)) {
            str6 = context.getResources().getString(R.string.cancel);
        }
        positiveButton.setNegativeButton(str6, onClickListener2).setCancelable(z).setOnCancelListener(onCancelListener);
        if (!TextUtils.isEmpty(str2)) {
            a.setMessage(str2);
        }
        AlertDialog create = a.create();
        create.setCanceledOnTouchOutside(z2);
        create.show();
        return create;
    }

    public static CustomDialog a(Context context, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final CustomDialog customDialog = new CustomDialog(context, R.style.TranslucentBackground);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_common_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        ((TextView) inflate.findViewById(R.id.tv_des)).setText(str2);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_cancel);
        if (TextUtils.isEmpty(str)) {
            textView2.setVisibility(8);
            inflate.findViewById(R.id.tv_divide).setVisibility(8);
        } else {
            textView2.setText(str4);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.CommonAlertDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CustomDialog customDialog2 = CustomDialog.this;
                    if (customDialog2 != null && customDialog2.isShowing()) {
                        CustomDialog.this.dismiss();
                    }
                    View.OnClickListener onClickListener3 = onClickListener2;
                    if (onClickListener3 != null) {
                        onClickListener3.onClick(view);
                    }
                }
            });
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_ok);
        textView3.setText(str3);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.CommonAlertDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CustomDialog customDialog2 = CustomDialog.this;
                if (customDialog2 != null && customDialog2.isShowing()) {
                    CustomDialog.this.dismiss();
                }
                View.OnClickListener onClickListener3 = onClickListener;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                }
            }
        });
        customDialog.a(inflate, null);
        return customDialog;
    }

    public static BluedAlertDialog a(Context context, int i, String str, String str2, View view, String str3, int i2, DialogInterface.OnClickListener onClickListener, String str4, int i3, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, boolean z, int i4, int i5, boolean z2, boolean z3) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.c(i).a(str).b(str2).a(view).a(str3, onClickListener).b(str4, onClickListener2).a(z).b(z2).a(onDismissListener).a(i4).i(i2).h(i3).b(i5);
        BluedAlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(z3);
        a.show();
        return a;
    }

    public static BluedAlertDialog a(Context context, int i, String str, String str2, View view, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, boolean z, int i2, int i3, boolean z2, boolean z3) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.c(i).a(str).b(str2).a(view).a(str3, onClickListener).b(str4, onClickListener2).a(z).b(z2).a(onDismissListener).a(i2).b(i3);
        BluedAlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(z3);
        a.show();
        return a;
    }

    public static BluedAlertDialog a(Context context, int i, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        return a(context, i, str, str2, null, str3, onClickListener, null, null, onDismissListener, true, 1, 0, true, false);
    }

    public static BluedAlertDialog a(Context context, int i, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, int i2) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        if (str4 == null) {
            str4 = context.getString(R.string.cancel);
        }
        return a(context, i, str, str2, null, str3, onClickListener, str4, onClickListener2, onDismissListener, true, 1, i2, true, false);
    }

    public static BluedAlertDialog a(Context context, View view, String str, DialogInterface.OnClickListener onClickListener, String str2, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        if (str == null) {
            str = context.getString(R.string.biao_v4_ok);
        }
        if (str2 == null) {
            str2 = context.getString(R.string.cancel);
        }
        return a(context, 0, "", "", view, str, onClickListener, str2, onClickListener2, onDismissListener, false, 3, 0, true, false);
    }

    public static BluedAlertDialog a(Context context, String str, DialogInterface.OnClickListener onClickListener) {
        return a(context, 0, "", str, null, context.getString(R.string.biao_v4_ok), onClickListener, context.getString(R.string.cancel), null, null, false, 0, 0, true, false);
    }

    public static BluedAlertDialog a(Context context, String str, String str2, String str3, int i, DialogInterface.OnClickListener onClickListener, String str4, int i2, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        if (str4 == null) {
            str4 = context.getString(R.string.cancel);
        }
        return a(context, 0, str, str2, null, str3, i, onClickListener, str4, i2, onClickListener2, onDismissListener, false, 0, 0, true, false);
    }

    public static BluedAlertDialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener, int i) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        return a(context, 0, str, str2, null, str3, onClickListener, null, null, onDismissListener, true, i, 0, true, false);
    }

    public static BluedAlertDialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        if (str4 == null) {
            str4 = context.getString(R.string.cancel);
        }
        return a(context, 0, str, str2, null, str3, onClickListener, str4, onClickListener2, onDismissListener, false, 0, 0, true, false);
    }

    @Deprecated
    public static void a(Context context, View view, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener, boolean z) {
        AlertDialog.Builder a = a(context);
        AlertDialog.Builder view2 = a.setTitle(str).setView(view);
        String str4 = str3;
        if (TextUtils.isEmpty(str3)) {
            str4 = context.getResources().getString(R.string.biao_v4_ok);
        }
        view2.setPositiveButton(str4, onClickListener).setCancelable(z).setOnCancelListener(onCancelListener);
        if (!TextUtils.isEmpty(str2)) {
            a.setMessage(str2);
        }
        AlertDialog create = a.create();
        if (z) {
            create.setCanceledOnTouchOutside(true);
        }
        create.show();
    }

    public static void a(Context context, String str, String[] strArr, DialogInterface.OnClickListener onClickListener) {
        a(context, str, strArr, onClickListener, null);
    }

    public static void a(Context context, String str, String[] strArr, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        AlertDialog.Builder a = a(context);
        a.setItems(strArr, onClickListener);
        if (!TextUtils.isEmpty(str)) {
            a.setTitle(str);
        }
        AlertDialog create = a.create();
        create.setCanceledOnTouchOutside(true);
        if (onDismissListener != null) {
            create.setOnDismissListener(onDismissListener);
        }
        create.show();
    }

    public static void a(Context context, String str, final String[] strArr, final TextOnClickListener textOnClickListener) {
        a(context, str, strArr, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.common.widget.dialog.CommonAlertDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                textOnClickListener.a(strArr[i]);
            }
        });
    }
}
