package com.soft.blued.push;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.module.common.view.TranslationAnimHintView;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.heytap.msp.push.HeytapPushManager;
import com.igexin.assist.util.AssistUtils;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.pop.PopPushSwitch;
import com.soft.blued.ui.setting.fragment.RemindSettingFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushChecker.class */
public class PushChecker {

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushChecker$PushCheckerHolder.class */
    public static class PushCheckerHolder {

        /* renamed from: a  reason: collision with root package name */
        public static PushChecker f16043a = new PushChecker();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/PushChecker$RemindDialog.class */
    public class RemindDialog extends Dialog {
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private int f16045c;
        private MessageProtos.WarnTime d;
        private View.OnClickListener e;

        public RemindDialog(Context context, int i, MessageProtos.WarnTime warnTime) {
            super(context);
            this.b = context;
            this.f16045c = i;
            this.d = warnTime;
        }

        private void a(View view, int i, final MessageProtos.WarnTime warnTime) {
            view.findViewById(2131365207).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.push.PushChecker.RemindDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.POP_PUSH, warnTime);
                    RemindDialog.this.dismiss();
                }
            });
            TextView textView = (TextView) view.findViewById(R.id.tv_desc);
            TextView textView2 = (TextView) view.findViewById(2131372754);
            TextView textView3 = (TextView) view.findViewById(R.id.btn_open);
            if (i == 0) {
                textView2.setText(this.b.getString(R.string.allow_msg_title));
                textView.setText(this.b.getString(R.string.allow_msg_desc));
                textView3.setText(this.b.getString(R.string.allow_msg_btn));
            } else if (i == 1) {
                textView2.setText(this.b.getString(R.string.allow_chat_title));
                textView.setText(this.b.getString(R.string.allow_chat_desc));
                textView3.setText(this.b.getString(R.string.allow_chat_btn));
            } else if (i == 2) {
                textView2.setText(this.b.getString(R.string.allow_live_title));
                textView.setText(this.b.getString(R.string.allow_live_desc));
                textView3.setText(this.b.getString(R.string.allow_live_btn));
            }
            View.OnClickListener onClickListener = this.e;
            if (onClickListener != null) {
                textView3.setOnClickListener(onClickListener);
            }
        }

        public void a(View.OnClickListener onClickListener) {
            this.e = onClickListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.dialog_push_check, (ViewGroup) null);
            setContentView(inflate);
            a(inflate, this.f16045c, this.d);
            Window window = getWindow();
            if (window != null) {
                window.setBackgroundDrawableResource(android.R.color.transparent);
            }
        }
    }

    public static PushChecker a() {
        return PushCheckerHolder.f16043a;
    }

    private String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : AppInfo.d().getString(R.string.allow_msg_toast_permanent) : AppInfo.d().getString(R.string.allow_live_toast) : AppInfo.d().getString(R.string.allow_msg_toast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else if (Build.VERSION.SDK_INT >= 21) {
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.getPackageName());
            intent.putExtra(Settings.EXTRA_APP_UID, context.getApplicationInfo().uid);
        } else {
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void b(final Context context, int i, final MessageProtos.WarnTime warnTime) {
        BluedPreferences.g(System.currentTimeMillis() + (BluedConfig.a().b().message_push_box * BaseConstants.Time.DAY));
        if (Build.MANUFACTURER.toLowerCase().equals(AssistUtils.BRAND_OPPO) && !BluedPreferences.cI()) {
            HeytapPushManager.requestNotificationPermission();
            BluedPreferences.cJ();
            return;
        }
        final RemindDialog remindDialog = new RemindDialog(context, i, warnTime);
        remindDialog.a(new View.OnClickListener() { // from class: com.soft.blued.push.PushChecker.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                remindDialog.dismiss();
                EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.POP_PUSH, warnTime);
                PushChecker.this.a(context);
            }
        });
        remindDialog.show();
    }

    private boolean b() {
        return System.currentTimeMillis() < BluedPreferences.cu();
    }

    private boolean b(Context context) {
        try {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c(Context context) {
        new XPopup.Builder(context).a(new SimpleCallback() { // from class: com.soft.blued.push.PushChecker.4
            public void c(BasePopupView basePopupView) {
                super.c(basePopupView);
                BluedPreferences.j(System.currentTimeMillis() + 604800000);
                EventTrackMessage.a(MessageProtos.Event.MSG_OPEN_PUSH_POP_SHOW);
            }
        }).a(new PopPushSwitch(context)).h();
    }

    private boolean c() {
        return System.currentTimeMillis() < BluedPreferences.cv();
    }

    private boolean d() {
        return System.currentTimeMillis() < BluedPreferences.cw();
    }

    private boolean e() {
        return System.currentTimeMillis() < BluedPreferences.cx();
    }

    private boolean f() {
        return BluedPreferences.aj() && BluedPreferences.ak() && BluedPreferences.am() && BluedPreferences.ao() && BluedPreferences.an() && BluedPreferences.ap() && BluedPreferences.ai() && BluedPreferences.al();
    }

    public void a(Context context, int i, MessageProtos.WarnTime warnTime) {
        if (BluedConfig.a().b().message_push_box == 0 || b(context) || b()) {
            return;
        }
        b(context, i, warnTime);
    }

    public void a(final View view, final int i, final MessageProtos.WarnTime warnTime) {
        if (view == null || BluedConfig.a().b().message_push_box == 0) {
            return;
        }
        if (i == 2) {
            if (b(view.getContext()) || c()) {
                return;
            }
        } else if (i == 0) {
            if (f() || e()) {
                return;
            }
        } else if (i == 1 && (BluedPreferences.ai() || d())) {
            return;
        }
        view.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(2131365207);
        ((TextView) view.findViewById(2131371675)).setText(a(i));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.push.PushChecker.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (i == 2) {
                    PushChecker.this.a(view2.getContext());
                    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, warnTime);
                    return;
                }
                InstantLog.b("my_model", 6);
                TerminalActivity.d(view.getContext(), RemindSettingFragment.class, (Bundle) null);
                EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH, warnTime);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.push.PushChecker.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (i == 2) {
                    BluedPreferences.h(System.currentTimeMillis() + (BluedConfig.a().b().message_push_box * BaseConstants.Time.DAY));
                    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, warnTime);
                } else {
                    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH, warnTime);
                }
                if (i == 1) {
                    BluedPreferences.i(System.currentTimeMillis() + (BluedConfig.a().b().message_push_box * BaseConstants.Time.DAY));
                }
                view.setVisibility(8);
            }
        });
    }

    public void a(final TranslationAnimHintView translationAnimHintView, final int i, final MessageProtos.WarnTime warnTime) {
        if (translationAnimHintView == null || BluedConfig.a().b().message_push_box == 0) {
            return;
        }
        int i2 = 1;
        if (i == 2) {
            if (b(translationAnimHintView.getContext()) || c()) {
                return;
            }
        } else if (i == 0) {
            if (!b(translationAnimHintView.getContext()) || e() || f()) {
                return;
            }
            c(translationAnimHintView.getContext());
            return;
        } else if (i == 1 && (BluedPreferences.ai() || d())) {
            return;
        }
        final TranslationAnimHintView.HintInfo hintInfo = new TranslationAnimHintView.HintInfo();
        if (i == 2) {
            i2 = 2;
        }
        hintInfo.a = i2;
        hintInfo.b = a(i);
        hintInfo.d = new View.OnClickListener() { // from class: com.soft.blued.push.PushChecker.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (i == 2) {
                    PushChecker.this.a(view.getContext());
                    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, warnTime);
                    return;
                }
                InstantLog.b("my_model", 6);
                EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLICK, MessageProtos.WarnType.TOAST_PUSH, warnTime);
            }
        };
        hintInfo.c = new View.OnClickListener() { // from class: com.soft.blued.push.PushChecker.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (i == 2) {
                    BluedPreferences.h(System.currentTimeMillis() + (BluedConfig.a().b().message_push_box * BaseConstants.Time.DAY));
                    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH_PERMANENT, warnTime);
                } else {
                    EventTrackMessage.a(MessageProtos.Event.MSG_PUSH_WARN_CLOSE, MessageProtos.WarnType.TOAST_PUSH, warnTime);
                }
                if (i == 1) {
                    BluedPreferences.i(System.currentTimeMillis() + (BluedConfig.a().b().message_push_box * BaseConstants.Time.DAY));
                }
                translationAnimHintView.a(hintInfo.a);
            }
        };
        translationAnimHintView.a(hintInfo);
    }
}
