package com.sobot.chat.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;
import com.sobot.chat.R;
import com.sobot.chat.SobotApi;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotLoadingDialog.class */
public class SobotLoadingDialog extends Dialog {
    private static final String TAG = "SobotLoadingDialog";
    private boolean mCancelable;
    private String mMessage;
    private TextView tv_loading;

    public SobotLoadingDialog(Context context, int i, String str, boolean z) {
        super(context, i);
        this.mMessage = str;
        this.mCancelable = z;
    }

    public SobotLoadingDialog(Context context, String str) {
        this(context, R.style.sobot_dialog_Progress, str, false);
    }

    private void initView() {
        setContentView(R.layout.sobot_progress_dialog);
        getWindow().getWindowManager().getDefaultDisplay().getWidth();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        if (SobotApi.getSwitchMarkStatus(4) && SobotApi.getSwitchMarkStatus(1)) {
            attributes.flags = 8;
        }
        getWindow().setAttributes(attributes);
        setCancelable(this.mCancelable);
        TextView textView = (TextView) findViewById(ResourceUtils.getResId(getContext(), "tv_loading"));
        this.tv_loading = textView;
        textView.setText(this.mMessage);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    public String getmMessage() {
        return this.mMessage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "onCreate: ");
        initView();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return i == 4 ? this.mCancelable : super.onKeyDown(i, keyEvent);
    }

    public void setmMessage(String str) {
        this.mMessage = str;
        this.tv_loading.setText(str);
    }
}
