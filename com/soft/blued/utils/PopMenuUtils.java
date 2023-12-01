package com.soft.blued.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.user.fragment.VIPCenterNewFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/PopMenuUtils.class */
public class PopMenuUtils {
    private static void a(Context context, int i, int i2, int i3, final View.OnClickListener onClickListener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hint_with_image_and_btn, (ViewGroup) null);
        final PopMenuFromCenter popMenuFromCenter = new PopMenuFromCenter(context, inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131367999);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_btn);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_head);
        textView.setText(i3);
        ((TextView) inflate.findViewById(2131371186)).setText(i2);
        ImageLoader.a((IRequestHost) null, i).a(5.0f).a(imageView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.PopMenuUtils.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.PopMenuUtils.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                onClickListener.onClick(view);
                popMenuFromCenter.d();
            }
        });
        popMenuFromCenter.e();
    }

    public static void a(final Context context, PopMenuFromCenter.DismissListner dismissListner) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_pay_result_dialog, (ViewGroup) null);
        final PopMenuFromCenter popMenuFromCenter = new PopMenuFromCenter(context, inflate);
        popMenuFromCenter.a(dismissListner);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131367999);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_close);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.img_status);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_btn);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.-$$Lambda$PopMenuUtils$bj4aUTxjux6n2YyPdOn4b_YdUdU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopMenuUtils.a(PopMenuFromCenter.this, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.-$$Lambda$PopMenuUtils$kA7Fs4mwBOvtigrRHqMAaZOl8VM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.-$$Lambda$PopMenuUtils$HFu4vjPVGMvhHzFYSKwjZ4c9l50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        imageView2.setImageResource(R.drawable.icon_pay_result_success);
        ((TextView) inflate.findViewById(R.id.tv_status)).setText(R.string.purchase_complete);
        textView.setText(R.string.go_setting);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.utils.-$$Lambda$PopMenuUtils$cJSqLkNnLDffp_eWu_KTpye_NPY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopMenuUtils.a(PopMenuFromCenter.this, context, view);
            }
        });
        popMenuFromCenter.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(PopMenuFromCenter popMenuFromCenter, Context context, View view) {
        Tracker.onClick(view);
        popMenuFromCenter.a(true);
        InstantLog.a("vip_buy_go_setting_click");
        if (BluedConfig.a().b) {
            return;
        }
        VIPCenterNewFragment.a(context, -1, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(PopMenuFromCenter popMenuFromCenter, View view) {
        Tracker.onClick(view);
        popMenuFromCenter.d();
    }

    public static boolean a() {
        return UserInfo.getInstance().getLoginUserInfo().getNeed_auth() == 1;
    }

    public static boolean a(Context context) {
        return a(context, (View.OnClickListener) null);
    }

    public static boolean a(final Context context, final View.OnClickListener onClickListener) {
        if (a()) {
            Activity activity = null;
            if (context instanceof Activity) {
                activity = context;
            } else if (BluedApplicationLike.getForeActivity() != null) {
                activity = BluedApplicationLike.getForeActivity();
            }
            if (activity == null) {
                AppMethods.a(context.getResources().getString(R.string.need_cellphone_asap));
                return true;
            }
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PHONE_BIND_SHOW);
            a(activity, R.drawable.bg_center_hint_bind_cellphone, R.string.need_cellphone_asap, R.string.go_to_fill, new View.OnClickListener() { // from class: com.soft.blued.utils.PopMenuUtils.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_PHONE_BIND_CONFIRM_CLICK);
                    View.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(view);
                    }
                    String is_auth_url = UserInfo.getInstance().getLoginUserInfo().getIs_auth_url();
                    if (StringUtils.d(is_auth_url)) {
                        return;
                    }
                    WebViewShowInfoFragment.show(context, is_auth_url, -1);
                }
            });
            return true;
        }
        return false;
    }
}
