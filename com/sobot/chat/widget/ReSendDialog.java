package com.sobot.chat.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.utils.ResourceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ReSendDialog.class */
public class ReSendDialog extends Dialog {
    public Button button;
    public Button button2;
    private Context content;
    public OnItemClick mOnItemClick;
    private TextView sobot_message;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/ReSendDialog$OnItemClick.class */
    public interface OnItemClick {
        void OnClick(int i);
    }

    public ReSendDialog(Context context) {
        super(context, ResourceUtils.getIdByName(context, "style", "sobot_noAnimDialogStyle"));
        this.mOnItemClick = null;
        this.content = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResourceUtils.getIdByName(this.content, "layout", "sobot_resend_message_dialog"));
        TextView textView = (TextView) findViewById(ResourceUtils.getIdByName(this.content, "id", "sobot_message"));
        this.sobot_message = textView;
        textView.setText(ResourceUtils.getResString(this.content, "sobot_resendmsg"));
        Button button = (Button) findViewById(ResourceUtils.getIdByName(this.content, "id", "sobot_negativeButton"));
        this.button = button;
        button.setText(ResourceUtils.getResString(this.content, "sobot_button_send"));
        Button button2 = (Button) findViewById(ResourceUtils.getIdByName(this.content, "id", "sobot_positiveButton"));
        this.button2 = button2;
        button2.setText(ResourceUtils.getResString(this.content, "sobot_btn_cancle"));
        this.button.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.ReSendDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ReSendDialog.this.mOnItemClick.OnClick(0);
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.ReSendDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ReSendDialog.this.mOnItemClick.OnClick(1);
            }
        });
    }

    public void setOnClickListener(OnItemClick onItemClick) {
        this.mOnItemClick = onItemClick;
    }
}
