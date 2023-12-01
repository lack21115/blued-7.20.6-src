package com.sobot.chat.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.applog.tracker.Tracker;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ToastUtil.class */
public class ToastUtil {
    private static Handler mHandler = new Handler() { // from class: com.sobot.chat.utils.ToastUtil.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.obj instanceof OnAfterShowListener) {
                ((OnAfterShowListener) message.obj).doAfter();
            }
        }
    };
    private static Toast toast;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/ToastUtil$OnAfterShowListener.class */
    public interface OnAfterShowListener {
        void doAfter();
    }

    public static void doListener(OnAfterShowListener onAfterShowListener) {
        Message obtainMessage = mHandler.obtainMessage();
        obtainMessage.obj = onAfterShowListener;
        mHandler.sendMessage(obtainMessage);
    }

    public static void showCopyPopWindows(final Context context, View view, final String str, int i, int i2) {
        View inflate = LayoutInflater.from(context).inflate(ResourceUtils.getIdByName(context, "layout", "sobot_pop_chat_room_long_press"), (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        inflate.measure(150, 150);
        int measuredWidth = inflate.getMeasuredWidth();
        int measuredHeight = inflate.getMeasuredHeight();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        popupWindow.showAtLocation(view, 0, ((iArr[0] + (view.getWidth() / 2)) - (measuredWidth / 2)) + i, (iArr[1] - (measuredHeight + 20)) + i2);
        popupWindow.update();
        ((TextView) inflate.findViewById(CommonUtils.getResId(context, "sobot_tv_copy_txt"))).setText(ResourceUtils.getResString(context, "sobot_ctrl_copy"));
        inflate.findViewById(CommonUtils.getResId(context, "sobot_tv_copy_txt")).setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.utils.ToastUtil.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (Build.VERSION.SDK_INT >= 11) {
                    LogUtils.i("API是大于11");
                    ClipboardManager clipboardManager = (ClipboardManager) Context.this.getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    if (clipboardManager != null) {
                        clipboardManager.setText(str);
                    }
                } else {
                    LogUtils.i("API是小于11");
                    android.text.ClipboardManager clipboardManager2 = (android.text.ClipboardManager) Context.this.getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    if (clipboardManager2 != null) {
                        clipboardManager2.setText(str);
                    }
                }
                Context context2 = Context.this;
                ToastUtil.showCustomToast(context2, CommonUtils.getResString(context2, "sobot_ctrl_v_success"), CommonUtils.getResDrawableId(Context.this, "sobot_iv_login_right"));
                popupWindow.dismiss();
            }
        });
    }

    public static void showCustomLongToast(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CustomToast.makeText(context, str, 1).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showCustomToast(Context context, String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = CommonUtils.getResString(context, "sobot_server_request_wrong");
        }
        try {
            CustomToast.makeText(context, str2, 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showCustomToast(Context context, String str, int i) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = CommonUtils.getResString(context, "sobot_server_request_wrong");
        }
        try {
            CustomToast.makeText(context, str2, 0, i).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showCustomToastWithListenr(Context context, String str, long j, final OnAfterShowListener onAfterShowListener) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = CommonUtils.getResString(context, "sobot_server_request_wrong");
        }
        try {
            CustomToast.makeText(context, str2, 0).show();
            new Timer().schedule(new TimerTask() { // from class: com.sobot.chat.utils.ToastUtil.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    OnAfterShowListener onAfterShowListener2 = OnAfterShowListener.this;
                    if (onAfterShowListener2 != null) {
                        ToastUtil.doListener(onAfterShowListener2);
                    }
                }
            }, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showLongToast(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Toast toast2 = toast;
        if (toast2 == null) {
            toast = Toast.makeText(applicationContext, str, 1);
        } else {
            toast2.setText(str);
        }
        try {
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showToast(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CustomToast.makeText(context, str, 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
