package com.blued.android.module.live_china.same.tip;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.bytedance.applog.tracker.Tracker;
import com.jungly.gridpasswordview.GridPasswordView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/tip/CommonAlertDialog.class */
public class CommonAlertDialog {

    /* renamed from: com.blued.android.module.live_china.same.tip.CommonAlertDialog$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/tip/CommonAlertDialog$4.class */
    class AnonymousClass4 implements DialogInterface.OnClickListener {
        final /* synthetic */ String[] a;
        final /* synthetic */ TextOnClickListener b;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            this.b.a(this.a[i]);
        }
    }

    /* renamed from: com.blued.android.module.live_china.same.tip.CommonAlertDialog$5  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/tip/CommonAlertDialog$5.class */
    class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ CustomDialog a;
        final /* synthetic */ View.OnClickListener b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            CustomDialog customDialog = this.a;
            if (customDialog != null && customDialog.isShowing()) {
                this.a.dismiss();
            }
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* renamed from: com.blued.android.module.live_china.same.tip.CommonAlertDialog$6  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/tip/CommonAlertDialog$6.class */
    class AnonymousClass6 implements View.OnClickListener {
        final /* synthetic */ CustomDialog a;
        final /* synthetic */ View.OnClickListener b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            CustomDialog customDialog = this.a;
            if (customDialog != null && customDialog.isShowing()) {
                this.a.dismiss();
            }
            View.OnClickListener onClickListener = this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/tip/CommonAlertDialog$PWDListener.class */
    public interface PWDListener {
        void a(String str, boolean z, DialogWith6PW dialogWith6PW);
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/same/tip/CommonAlertDialog$TextOnClickListener.class */
    public interface TextOnClickListener {
        void a(String str);
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
        int e = CommonStringUtils.e(str5);
        textView.setText(e + BridgeUtil.SPLIT_MARK + i);
        editText.setSelection(str5.length());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.blued.android.module.live_china.same.tip.CommonAlertDialog.1
            private int d;
            private int e;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    EditText.this.removeTextChangedListener(this);
                    this.d = EditText.this.getSelectionStart();
                    this.e = EditText.this.getSelectionEnd();
                    while (CommonStringUtils.a(editable) > i) {
                        editable.delete(this.d - 1, this.e);
                        this.d--;
                        this.e--;
                    }
                    textView.setText(CommonStringUtils.a(editable) + BridgeUtil.SPLIT_MARK + i);
                    EditText.this.setSelection(this.d);
                    EditText.this.addTextChangedListener(this);
                } catch (Exception e2) {
                    e2.printStackTrace();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog.Builder view = builder.setTitle(str).setView(linearLayout);
        if (TextUtils.isEmpty(str4)) {
            str4 = context.getResources().getString(R.string.biao_v4_ok);
        }
        AlertDialog.Builder positiveButton = view.setPositiveButton(str4, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.same.tip.CommonAlertDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                TextOnClickListener textOnClickListener2 = TextOnClickListener.this;
                textOnClickListener2.a(((Object) editText.getText()) + "");
            }
        });
        if (TextUtils.isEmpty(str3)) {
            str3 = context.getResources().getString(R.string.biao_v4_cancel);
        }
        positiveButton.setNegativeButton(str3, onClickListener).setCancelable(true).setOnCancelListener(null);
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        AlertDialog create = builder.create();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog.Builder view2 = builder.setTitle(str).setView(view);
        String str5 = str4;
        if (TextUtils.isEmpty(str4)) {
            str5 = context.getResources().getString(R.string.biao_v4_ok);
        }
        AlertDialog.Builder positiveButton = view2.setPositiveButton(str5, onClickListener);
        String str6 = str3;
        if (TextUtils.isEmpty(str3)) {
            str6 = context.getResources().getString(R.string.biao_v4_cancel);
        }
        positiveButton.setNegativeButton(str6, onClickListener2).setCancelable(z).setOnCancelListener(onCancelListener);
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(z2);
        create.show();
        return create;
    }

    public static BluedAlertDialog a(Context context, int i, String str, String str2, View view, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener, boolean z, int i2, int i3, boolean z2, boolean z3) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.c(i).a(str).b(str2).a(view).a(str3, onClickListener).b(str4, onClickListener2).a(z).b(z2).a(onDismissListener).a(i2).b(i3);
        BluedAlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(z3);
        a.show();
        return a;
    }

    public static BluedAlertDialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener, int i) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        return a(context, 0, str, str2, null, str3, onClickListener, null, null, onDismissListener, true, i, 0, true, false);
    }

    public static BluedAlertDialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener, int i, boolean z) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        return a(context, 0, str, str2, null, str3, onClickListener, null, null, onDismissListener, true, i, 0, true, true);
    }

    public static BluedAlertDialog a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnDismissListener onDismissListener) {
        if (str3 == null) {
            str3 = context.getString(R.string.biao_v4_ok);
        }
        if (str4 == null) {
            str4 = context.getString(R.string.biao_v4_cancel);
        }
        return a(context, 0, str, str2, null, str3, onClickListener, str4, onClickListener2, onDismissListener, false, 0, 0, true, false);
    }

    public static DialogWith6PW a(Context context, String str, String str2, boolean z, PWDListener pWDListener, DialogInterface.OnCancelListener onCancelListener) {
        return a(context, str, str2, z, true, true, true, pWDListener, onCancelListener);
    }

    public static DialogWith6PW a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, PWDListener pWDListener, DialogInterface.OnCancelListener onCancelListener) {
        return a(context, str, str2, z, z2, z3, z4, true, pWDListener, onCancelListener);
    }

    public static DialogWith6PW a(Context context, String str, String str2, boolean z, final boolean z2, boolean z3, boolean z4, boolean z5, final PWDListener pWDListener, DialogInterface.OnCancelListener onCancelListener) {
        final DialogWith6PW dialogWith6PW = new DialogWith6PW();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.item_dialog_6numpw, (ViewGroup) null);
        final TextView textView = (TextView) inflate.findViewById(R.id.tv_confirm);
        GridPasswordView findViewById = inflate.findViewById(R.id.gpv_customUi);
        findViewById.findViewById(cn.blued.blued_third_library.R.id.inputView).setImeOptions(33554432);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.vg_remember_check);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.cbx_need_next);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_title);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_title_cutline);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_msg);
        if (TextUtils.isEmpty(str)) {
            textView2.setVisibility(8);
            textView3.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView3.setVisibility(0);
            textView2.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            textView4.setVisibility(8);
        } else {
            textView4.setVisibility(0);
            textView4.setText(str2);
        }
        if (z) {
            findViewById.setPasswordVisibility(true);
        } else {
            findViewById.setPasswordVisibility(false);
        }
        if (z4) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        textView.setOnClickListener(null);
        findViewById.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() { // from class: com.blued.android.module.live_china.same.tip.CommonAlertDialog.3
            public void a(String str3) {
                if (str3.length() < 6) {
                    TextView.this.setOnClickListener(null);
                    TextView.this.setTextColor(Color.parseColor("#c0c0c0"));
                }
            }

            public void b(final String str3) {
                TextView.this.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.same.tip.CommonAlertDialog.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        pWDListener.a(str3, checkBox.isChecked(), dialogWith6PW);
                        if (z2 && dialogWith6PW.a != null && dialogWith6PW.a.isShowing()) {
                            dialogWith6PW.a.dismiss();
                        }
                    }
                });
                TextView.this.setTextColor(Color.parseColor("#3494f4"));
            }
        });
        textView.requestFocus();
        textView.setTextColor(Color.parseColor("#c0c0c0"));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(inflate).setCancelable(true).setOnCancelListener(onCancelListener);
        AlertDialog create = builder.create();
        if (z3) {
            create.getWindow().setSoftInputMode(5);
        } else {
            create.getWindow().setSoftInputMode(19);
        }
        create.setCanceledOnTouchOutside(z5);
        create.show();
        dialogWith6PW.a = create;
        dialogWith6PW.b = findViewById;
        dialogWith6PW.d = textView4;
        dialogWith6PW.c = textView2;
        dialogWith6PW.e = (ScrollView) inflate.findViewById(R.id.scrollView);
        return dialogWith6PW;
    }
}
