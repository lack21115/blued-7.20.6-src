package com.soft.blued.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.find.fragment.VisitHistoryFragment;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg_group.fragment.GroupNoticeNewFragment;
import com.soft.blued.ui.notify.fragment.MsgAttentionNotifyFragment;
import com.soft.blued.ui.setting.fragment.SettingFragment;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomeArgumentHelper.class */
public class HomeArgumentHelper {
    public static Bundle a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getBundleExtra("arg_subfragment_args");
    }

    public static String a(Intent intent, String str) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra("arg_subfragment_args")) == null) {
            return null;
        }
        return bundleExtra.getString(str);
    }

    public static void a(Context context) {
        a(context, (Bundle) null, (Bundle) null);
    }

    public static void a(Context context, Intent intent) {
        Bundle a2 = a(intent);
        if (a2 != null) {
            String string = a2.getString("arg_open_homeactivity_ope");
            if ("ope_liveplay".equals(string)) {
                LiveRoomInfoChannel.a(context, (LiveRoomData) a2.getSerializable("live_anchor_model"));
                ChatHelperV4.a().a(6L);
                ChatHelperV4.a().a(7L);
            } else if ("ope_livelist".equals(string)) {
            } else {
                if ("ope_setting".equals(string)) {
                    TerminalActivity.d(context, SettingFragment.class, null);
                } else if ("ope_notifications".equals(string)) {
                    TerminalActivity.d(context, MsgAttentionNotifyFragment.class, a2);
                } else if ("ope_visitors".equals(string)) {
                    TerminalActivity.d(context, VisitHistoryFragment.class, null);
                } else if ("ope_group_notification".equals(string)) {
                    TerminalActivity.d(context, GroupNoticeNewFragment.class, null);
                }
            }
        }
    }

    public static void a(Context context, Bundle bundle, Bundle bundle2) {
        context.startActivity(b(context, bundle, bundle2));
    }

    public static void a(Context context, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle2.putString("arg_select_tab_tag", str);
        }
        a(context, bundle2, bundle);
    }

    public static Intent b(Context context, Bundle bundle, Bundle bundle2) {
        Intent intent = new Intent(context, HomeActivity.class);
        if (bundle != null) {
            intent.putExtra("arg_activity_args", bundle);
        }
        if (bundle2 != null) {
            intent.putExtra("arg_subfragment_args", bundle2);
        }
        if (context instanceof Activity) {
            intent.setFlags(67108864);
            return intent;
        }
        intent.setFlags(268435456);
        return intent;
    }

    public static Intent b(Context context, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle2.putString("arg_select_tab_tag", str);
        }
        return b(context, bundle2, bundle);
    }

    public static String b(Intent intent, String str) {
        Bundle bundleExtra;
        if (intent == null || (bundleExtra = intent.getBundleExtra("arg_activity_args")) == null) {
            return null;
        }
        return bundleExtra.getString(str);
    }

    public static void b(Context context, Intent intent) {
        String a2 = a(intent, "from_tag_page");
        if (TextUtils.equals("from_notification_attention", a2)) {
            InstantLog.a("inner_push_click_follow_attention");
        } else if (TextUtils.equals("from_notification_feed", a2)) {
            InstantLog.a("inner_push_click_feed_notice");
        }
    }
}
