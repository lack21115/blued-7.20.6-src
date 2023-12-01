package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvGorgeousPrizeDialogBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgKtvPrize;
import com.blued.android.module.yy_china.utils.YYResourcesUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.ItemKtvPrizeView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYKtvGorgeousPrizeDialog.class */
public final class YYKtvGorgeousPrizeDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private YYMsgKtvPrize f17300a;
    private FragmentYyKtvGorgeousPrizeDialogBinding b;

    public YYKtvGorgeousPrizeDialog(YYMsgKtvPrize prize) {
        Intrinsics.e(prize, "prize");
        this.f17300a = prize;
    }

    private final int a(String str) {
        return StringUtils.a(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvGorgeousPrizeDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYKtvGorgeousPrizeDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        ImageView imageView;
        ItemKtvPrizeView itemKtvPrizeView;
        ItemKtvPrizeView itemKtvPrizeView2;
        ItemKtvPrizeView itemKtvPrizeView3;
        View view;
        ItemKtvPrizeView itemKtvPrizeView4;
        ItemKtvPrizeView itemKtvPrizeView5;
        ItemKtvPrizeView itemKtvPrizeView6;
        ItemKtvPrizeView itemKtvPrizeView7;
        ItemKtvPrizeView itemKtvPrizeView8;
        ItemKtvPrizeView itemKtvPrizeView9;
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding != null && (itemKtvPrizeView9 = fragmentYyKtvGorgeousPrizeDialogBinding.h) != null) {
            itemKtvPrizeView9.setGiftName("弯豆");
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding2 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding2 != null && (itemKtvPrizeView8 = fragmentYyKtvGorgeousPrizeDialogBinding2.h) != null) {
            itemKtvPrizeView8.setGiftIcon(R.drawable.icon_yy_pre_pay_smal_bean);
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding3 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding3 != null && (itemKtvPrizeView7 = fragmentYyKtvGorgeousPrizeDialogBinding3.i) != null) {
            itemKtvPrizeView7.setGiftName("礼物");
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding4 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding4 != null && (itemKtvPrizeView6 = fragmentYyKtvGorgeousPrizeDialogBinding4.i) != null) {
            itemKtvPrizeView6.setGiftIcon(R.drawable.icon_yy_ktv_prize);
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding5 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding5 != null && (itemKtvPrizeView5 = fragmentYyKtvGorgeousPrizeDialogBinding5.g) != null) {
            itemKtvPrizeView5.setGiftName("鼓掌");
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding6 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding6 != null && (itemKtvPrizeView4 = fragmentYyKtvGorgeousPrizeDialogBinding6.g) != null) {
            itemKtvPrizeView4.setGiftIcon(R.drawable.icon_yy_ktv_applaud);
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding7 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding7 != null && (view = fragmentYyKtvGorgeousPrizeDialogBinding7.f16515a) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvGorgeousPrizeDialog$cA-WxcVf6vrN3HFvYZDW1QbBHJ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYKtvGorgeousPrizeDialog.a(YYKtvGorgeousPrizeDialog.this, view2);
                }
            });
        }
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYKtvGorgeousPrizeDialog$ZqIpf_sbwV66JoM_ssy0x-mUX2M
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvGorgeousPrizeDialog.a(YYKtvGorgeousPrizeDialog.this);
            }
        }, m.ag);
        YYMsgKtvPrize yYMsgKtvPrize = this.f17300a;
        ImageWrapper b = ImageLoader.a(a(), yYMsgKtvPrize.avatar).b(R.drawable.user_bg_round);
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding8 = this.b;
        b.a(fragmentYyKtvGorgeousPrizeDialogBinding8 == null ? null : fragmentYyKtvGorgeousPrizeDialogBinding8.e);
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding9 = this.b;
        TextView textView = fragmentYyKtvGorgeousPrizeDialogBinding9 == null ? null : fragmentYyKtvGorgeousPrizeDialogBinding9.f;
        if (textView != null) {
            textView.setText(yYMsgKtvPrize.name);
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding10 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding10 != null && (itemKtvPrizeView3 = fragmentYyKtvGorgeousPrizeDialogBinding10.i) != null) {
            String str = yYMsgKtvPrize.gift;
            Intrinsics.c(str, "it.gift");
            itemKtvPrizeView3.setGiftCount(str);
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding11 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding11 != null && (itemKtvPrizeView2 = fragmentYyKtvGorgeousPrizeDialogBinding11.g) != null) {
            String str2 = yYMsgKtvPrize.applause;
            Intrinsics.c(str2, "it.applause");
            itemKtvPrizeView2.setGiftCount(str2);
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding12 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding12 != null && (itemKtvPrizeView = fragmentYyKtvGorgeousPrizeDialogBinding12.h) != null) {
            String str3 = yYMsgKtvPrize.beans;
            Intrinsics.c(str3, "it.beans");
            itemKtvPrizeView.setGiftCount(str3);
        }
        FragmentYyKtvGorgeousPrizeDialogBinding fragmentYyKtvGorgeousPrizeDialogBinding13 = this.b;
        if (fragmentYyKtvGorgeousPrizeDialogBinding13 == null || (imageView = fragmentYyKtvGorgeousPrizeDialogBinding13.d) == null) {
            return;
        }
        imageView.setImageResource(YYResourcesUtils.f17883a.b(StringUtils.a(yYMsgKtvPrize.score, 0)));
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_COOL_STAGE_SING_END_POP_SHOW;
        String str = YYRoomInfoManager.e().b().room_id;
        String str2 = YYRoomInfoManager.e().b().uid;
        String str3 = this.f17300a.score;
        String str4 = this.f17300a.beans;
        Intrinsics.c(str4, "prize.beans");
        int a2 = a(str4);
        String str5 = this.f17300a.gift;
        Intrinsics.c(str5, "prize.gift");
        int a3 = a(str5);
        String str6 = this.f17300a.applause;
        Intrinsics.c(str6, "prize.applause");
        EventTrackYY.a(event, str, str2, str3, a2, a3, a(str6));
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_ktv_gorgeous_prize_dialog, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_dialog, container, true)");
        this.b = FragmentYyKtvGorgeousPrizeDialogBinding.a(inflate);
        f();
        return inflate;
    }
}
