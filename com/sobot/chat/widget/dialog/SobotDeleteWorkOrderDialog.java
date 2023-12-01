package com.sobot.chat.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sobot.chat.SobotApi;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.ScreenUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/dialog/SobotDeleteWorkOrderDialog.class */
public class SobotDeleteWorkOrderDialog extends Dialog {
    private Button btn_cancel;
    private Button btn_pick_photo;
    private LinearLayout coustom_pop_layout;
    private View.OnClickListener itemsOnClick;
    private int position;
    private final int screenHeight;
    private String title;
    private TextView tv_photo_hint;

    public SobotDeleteWorkOrderDialog(Activity activity, String str, View.OnClickListener onClickListener) {
        super(activity, ResourceUtils.getIdByName(activity, "style", "sobot_noAnimDialogStyle"));
        this.itemsOnClick = onClickListener;
        this.title = str;
        this.screenHeight = ScreenUtils.getScreenHeight(activity);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            if (SobotApi.getSwitchMarkStatus(4) && SobotApi.getSwitchMarkStatus(1)) {
                attributes.flags = 8;
            }
            setParams(activity, attributes);
            window.setAttributes(attributes);
        }
    }

    private void initView() {
        TextView textView = (TextView) findViewById(ResourceUtils.getIdByName(getContext(), "id", "tv_photo_hint"));
        this.tv_photo_hint = textView;
        textView.setText(ResourceUtils.getResString(getContext(), "sobot_title"));
        Button button = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "btn_pick_photo"));
        this.btn_pick_photo = button;
        button.setText(ResourceUtils.getResString(getContext(), "sobot_delete"));
        Button button2 = (Button) findViewById(ResourceUtils.getIdByName(getContext(), "id", "btn_cancel"));
        this.btn_cancel = button2;
        button2.setText(ResourceUtils.getResString(getContext(), "sobot_btn_cancle"));
        this.coustom_pop_layout = (LinearLayout) findViewById(ResourceUtils.getIdByName(getContext(), "id", "pop_layout"));
        this.btn_pick_photo.setOnClickListener(this.itemsOnClick);
        this.btn_cancel.setOnClickListener(this.itemsOnClick);
        this.tv_photo_hint.setText(this.title);
    }

    private void setParams(Context context, WindowManager.LayoutParams layoutParams) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        layoutParams.width = displayMetrics.widthPixels;
    }

    public int getPosition() {
        return this.position;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceUtils.getIdByName(getContext(), "layout", "sobot_delete_picture_popup"));
        initView();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (motionEvent.getX() < -10.0f || motionEvent.getY() < -10.0f || motionEvent.getY() <= (this.screenHeight - this.coustom_pop_layout.getHeight()) - 20) {
                dismiss();
                return true;
            }
            return true;
        }
        return true;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
