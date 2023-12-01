package com.soft.blued.ui.live.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.ImageView;
import com.anythink.expressad.foundation.h.i;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.BluedLiveState;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.live.fragment.LiveApplySimpleFragment;
import com.soft.blued.ui.live.fragment.LiveApplyVerifyFragment;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/utils/LiveUtils.class */
public class LiveUtils {

    /* renamed from: a  reason: collision with root package name */
    public static NearbyLiveSourceModel f31305a;

    public static int a(Context context, ImageView imageView, int i, boolean z) {
        String str;
        if (i < 0) {
            if (imageView != null) {
                imageView.setVisibility(8);
                return -1;
            }
            return -1;
        }
        int i2 = i;
        if (i >= 99) {
            i2 = 99;
        }
        if (i2 < 10) {
            str = "00" + i2;
        } else if (i2 < 100) {
            str = "0" + i2;
        } else {
            str = i2 + "";
        }
        int identifier = context.getResources().getIdentifier("anchor_rich" + str, i.f7952c, context.getPackageName());
        if (imageView != null) {
            imageView.setImageResource(identifier);
            if (i2 == 0 && z) {
                imageView.setVisibility(8);
                return identifier;
            }
            imageView.setVisibility(0);
        }
        return identifier;
    }

    public static String a() {
        NearbyLiveSourceModel nearbyLiveSourceModel = f31305a;
        return nearbyLiveSourceModel == null ? "" : nearbyLiveSourceModel.b;
    }

    public static void a(final Context context, final BluedLiveState bluedLiveState) {
        if (bluedLiveState == null) {
            return;
        }
        int i = bluedLiveState.is_permission;
        int a2 = UserRelationshipUtils.a(bluedLiveState.block, bluedLiveState.vbadge, bluedLiveState.verify, bluedLiveState.mobile);
        if (AudioChannelManager.j().n()) {
            AppMethods.a(context.getResources().getText(2131893031));
        } else if (bluedLiveState.avatar_v_status == 0) {
            CommonAlertDialog.a(context, "", context.getResources().getString(2131891033), context.getResources().getString(2131892413), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    ModifyUserInfoFragment.a(Context.this, 602, true);
                }
            }, context.getResources().getString(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (bluedLiveState.avatar_v_status == 2) {
            CommonAlertDialog.a(context, "", context.getResources().getString(R.string.live_apply_avataring), context.getResources().getString(R.string.dialog_positive), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                }
            }, (DialogInterface.OnDismissListener) null, 1);
        } else if (2 != i && 1 != i) {
            if (bluedLiveState.verify == 0) {
                if (bluedLiveState.has_audited == 0) {
                    LiveApplyVerifyFragment.a(context, bluedLiveState);
                } else {
                    CommonAlertDialog.a(context, "", context.getResources().getString(2131889232), context.getResources().getString(R.string.dialog_positive), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.8
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Tracker.onClick(dialogInterface, i2);
                        }
                    }, (DialogInterface.OnDismissListener) null, 1);
                }
            } else if (bluedLiveState.verify == 2) {
                LiveApplySimpleFragment.a(context, bluedLiveState);
            } else if (bluedLiveState.has_audited == 0) {
                LiveApplyVerifyFragment.a(context, bluedLiveState);
            } else {
                LiveApplySimpleFragment.a(context, bluedLiveState);
            }
        } else if (a2 == 1) {
            CommonAlertDialog.a(context, "", context.getResources().getString(2131886128), context.getResources().getString(R.string.dialog_positive), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                }
            }, (DialogInterface.OnDismissListener) null, 1);
        } else if (a2 == 3) {
            CommonAlertDialog.a(context, "", context.getResources().getString(2131886143), context.getResources().getString(2131886193), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    TerminalActivity.d(Context.this, LinkMobileFragment.class, null);
                }
            }, context.getResources().getString(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else if (a2 == 2) {
            CommonAlertDialog.a(context, "", context.getResources().getString(2131886144), context.getResources().getString(R.string.dialog_positive), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                }
            }, (DialogInterface.OnDismissListener) null, 1);
        } else if (a2 != 4) {
            RecordingOnliveFragment.a(context, bluedLiveState.is_official);
        } else {
            BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
            builder.a(context.getResources().getString(R.string.qr_scan_result_remind_title)).b(context.getResources().getString(2131886115)).a(context.getResources().getString(2131886116), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    LiveApplySimpleFragment.a(Context.this, bluedLiveState);
                }
            }).b(context.getResources().getString(2131886117), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.live.utils.LiveUtils.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Tracker.onClick(dialogInterface, i2);
                    ModifyUserInfoFragment.a(Context.this, 602, true);
                }
            }).a(true).b(true).a((DialogInterface.OnDismissListener) null).a(0);
            builder.a().show();
        }
    }

    public static void a(String str, String str2, int i) {
        NearbyLiveSourceModel nearbyLiveSourceModel = new NearbyLiveSourceModel();
        f31305a = nearbyLiveSourceModel;
        nearbyLiveSourceModel.b = str;
        f31305a.f31310a = str2;
        f31305a.f31311c = i;
    }

    public static String b() {
        NearbyLiveSourceModel nearbyLiveSourceModel = f31305a;
        return nearbyLiveSourceModel == null ? "" : nearbyLiveSourceModel.f31310a;
    }

    public static int c() {
        NearbyLiveSourceModel nearbyLiveSourceModel = f31305a;
        if (nearbyLiveSourceModel == null) {
            return 0;
        }
        return nearbyLiveSourceModel.f31311c;
    }
}
