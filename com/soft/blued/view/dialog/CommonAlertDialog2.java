package com.soft.blued.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.jungly.gridpasswordview.GridPasswordView;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/view/dialog/CommonAlertDialog2.class */
public class CommonAlertDialog2 {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/view/dialog/CommonAlertDialog2$PWDListener.class */
    public interface PWDListener {
        void onClick(String str, boolean z, DialogWith6PW dialogWith6PW);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/view/dialog/CommonAlertDialog2$TextOnClickListener.class */
    public interface TextOnClickListener {
        void a(String str);
    }

    public static DialogWith6PW a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, PWDListener pWDListener, DialogInterface.OnCancelListener onCancelListener) {
        return a(context, str, str2, z, z2, z3, z4, true, pWDListener, onCancelListener);
    }

    public static DialogWith6PW a(Context context, String str, String str2, boolean z, final boolean z2, boolean z3, boolean z4, boolean z5, final PWDListener pWDListener, DialogInterface.OnCancelListener onCancelListener) {
        final DialogWith6PW dialogWith6PW = new DialogWith6PW();
        View inflate = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_dialog_6numpw, (ViewGroup) null);
        final TextView textView = (TextView) inflate.findViewById(2131371164);
        GridPasswordView gridPasswordView = (GridPasswordView) inflate.findViewById(R.id.gpv_customUi);
        ((ImeDelBugFixedEditText) gridPasswordView.findViewById(2131364751)).setImeOptions(33554432);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.vg_remember_check);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.cbx_need_next);
        TextView textView2 = (TextView) inflate.findViewById(2131372754);
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
            gridPasswordView.setPasswordVisibility(true);
        } else {
            gridPasswordView.setPasswordVisibility(false);
        }
        if (z4) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        textView.setOnClickListener(null);
        gridPasswordView.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() { // from class: com.soft.blued.view.dialog.CommonAlertDialog2.3
            @Override // com.jungly.gridpasswordview.GridPasswordView.OnPasswordChangedListener
            public void a(String str3) {
                if (str3.length() < 6) {
                    textView.setOnClickListener(null);
                    textView.setTextColor(Color.parseColor("#c0c0c0"));
                }
            }

            @Override // com.jungly.gridpasswordview.GridPasswordView.OnPasswordChangedListener
            public void b(final String str3) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.view.dialog.CommonAlertDialog2.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        pWDListener.onClick(str3, checkBox.isChecked(), dialogWith6PW);
                        if (z2 && dialogWith6PW.f21177a != null && dialogWith6PW.f21177a.isShowing()) {
                            dialogWith6PW.f21177a.dismiss();
                        }
                    }
                });
                textView.setTextColor(Color.parseColor("#3494f4"));
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
        dialogWith6PW.f21177a = create;
        dialogWith6PW.b = gridPasswordView;
        dialogWith6PW.d = textView4;
        dialogWith6PW.f21178c = textView2;
        dialogWith6PW.e = (ScrollView) inflate.findViewById(2131369639);
        return dialogWith6PW;
    }

    public static void a(final Activity activity, String str, String str2, final TextOnClickListener textOnClickListener, DialogInterface.OnClickListener onClickListener) {
        String string = activity.getResources().getString(2131886752);
        String string2 = activity.getResources().getString(2131886885);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.item_edit_nickname, (ViewGroup) null);
        final TextView textView = (TextView) inflate.findViewById(2131371196);
        final EditText editText = (EditText) inflate.findViewById(R.id.edit_text);
        editText.requestFocus();
        editText.setSingleLine(true);
        ((TextView) inflate.findViewById(R.id.tv_description)).setText(str2);
        int i = StringUtils.i(str);
        textView.setText(i + "/20");
        editText.setText(str);
        editText.setHint(R.string.max_input_20_char);
        editText.setSelection(str.length());
        editText.post(new Runnable() { // from class: com.soft.blued.view.dialog.-$$Lambda$CommonAlertDialog2$CKkMSsumAPsI65dyeSTKGNDqLx4
            @Override // java.lang.Runnable
            public final void run() {
                KeyboardUtils.c(Activity.this);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.view.dialog.CommonAlertDialog2.1

            /* renamed from: c  reason: collision with root package name */
            private int f21166c;
            private int d;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                try {
                    editText.removeTextChangedListener(this);
                    this.f21166c = editText.getSelectionStart();
                    this.d = editText.getSelectionEnd();
                    while (StringUtils.a(editable) > 20) {
                        editable.delete(this.f21166c - 1, this.d);
                        this.f21166c--;
                        this.d--;
                    }
                    textView.setText(StringUtils.a(editable) + "/20");
                    editText.setSelection(this.f21166c);
                    editText.addTextChangedListener(this);
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
        CommonAlertDialog.a(activity, inflate, string, new DialogInterface.OnClickListener() { // from class: com.soft.blued.view.dialog.CommonAlertDialog2.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                TextOnClickListener textOnClickListener2 = TextOnClickListener.this;
                textOnClickListener2.a(((Object) editText.getText()) + "");
            }
        }, string2, onClickListener, (DialogInterface.OnDismissListener) null);
    }

    private static void a(Dialog dialog) {
        Window window;
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = window.getAttributes();
        WindowManager.LayoutParams layoutParams = attributes;
        if (attributes == null) {
            layoutParams = new WindowManager.LayoutParams();
        }
        layoutParams.width = DensityUtils.a(window.getContext(), 185.0f);
        layoutParams.height = DensityUtils.a(window.getContext(), 70.0f);
        layoutParams.gravity = 17;
        window.setAttributes(layoutParams);
    }

    public static void a(Context context, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_verify_hint_dialog, (ViewGroup) null);
        UserInfoHelper.a((ImageView) inflate.findViewById(R.id.img_hint_img), i);
        ((TextView) inflate.findViewById(R.id.tv_hint_text)).setText(StringUtils.a(i));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        create.show();
        a(create);
    }
}
