package com.blued.android.module.yy_china.view;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogGiftwallInfoBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftEven;
import com.blued.android.module.yy_china.model.YYGoodsWallMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftWallInfoDialog.class */
public final class YYGiftWallInfoDialog extends BaseFullScreenDialog {
    private DialogGiftwallInfoBinding a;
    private YYUserInfo b;
    private YYGoodsWallMode c;
    private boolean d;
    private View.OnClickListener e;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYGiftWallInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYGiftWallInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYGiftWallInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.e;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this$0.dismissAllowingStateLoss();
        YYGoodsWallMode yYGoodsWallMode = this$0.c;
        Intrinsics.a(yYGoodsWallMode);
        String goods_id = yYGoodsWallMode.getGoods_id();
        YYUserInfo yYUserInfo = this$0.b;
        Intrinsics.a(yYUserInfo);
        YYGiftEven yYGiftEven = new YYGiftEven("", goods_id, yYUserInfo.getUid());
        LiveEventBus.get("show_gift_view").post(yYGiftEven);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_GIFT_POP_SEND_CLICK, b.room_id, b.uid, yYGiftEven.b);
    }

    private final DialogGiftwallInfoBinding h() {
        DialogGiftwallInfoBinding dialogGiftwallInfoBinding = this.a;
        Intrinsics.a(dialogGiftwallInfoBinding);
        return dialogGiftwallInfoBinding;
    }

    private final void i() {
        h().p.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallInfoDialog$5LJi1s_ZMWX-nB1djUKWRLTkkUA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallInfoDialog.a(view);
            }
        });
        h().o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallInfoDialog$7z9sp9eSIjTTJ5mM2XCqHVJ1Twc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallInfoDialog.a(YYGiftWallInfoDialog.this, view);
            }
        });
        h().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallInfoDialog$4mAZulq_gqMjKc03p_QHM9sjgkE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYGiftWallInfoDialog.b(YYGiftWallInfoDialog.this, view);
            }
        });
        YYGoodsWallMode yYGoodsWallMode = this.c;
        if (yYGoodsWallMode == null) {
            return;
        }
        ImageLoader.a(a(), yYGoodsWallMode.getImages_static()).a(h().g);
        h().w.setText(yYGoodsWallMode.getName());
        String k = YYRoomInfoManager.e().k();
        YYUserInfo f = f();
        Intrinsics.a(f);
        if (Intrinsics.a((Object) k, (Object) f.getUid())) {
            h().r.setVisibility(8);
            h().x.setText("榜单暂时无人占领，快去号召粉丝来点亮冲榜吧~");
        } else {
            h().x.setText("榜单暂时无人占领，快去点亮冲榜吧~");
            h().r.setVisibility(0);
            h().r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftWallInfoDialog$f2nYeM7dJ6OS4bPbtFmn3jkJZ2g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftWallInfoDialog.c(YYGiftWallInfoDialog.this, view);
                }
            });
        }
        if (g()) {
            h().u.setVisibility(8);
            h().t.setVisibility(0);
            h().q.setVisibility(0);
            if (yYGoodsWallMode.getLight() == yYGoodsWallMode.getMax_light()) {
                TextView textView = h().t;
                textView.setText("该礼物总计可收集" + yYGoodsWallMode.getJewel() + "钻石，已达上限");
                h().r.setText("去送礼夺赞助");
                h().v.setVisibility(8);
                h().y.setVisibility(8);
                h().n.setVisibility(8);
            } else {
                if (yYGoodsWallMode.getJewel() > 0 && yYGoodsWallMode.getLight() > 0) {
                    TextView textView2 = h().t;
                    textView2.setText("点亮1个可收集" + (yYGoodsWallMode.getJewel() / yYGoodsWallMode.getLight()) + "钻石，上限为" + ((yYGoodsWallMode.getJewel() / yYGoodsWallMode.getLight()) * yYGoodsWallMode.getMax_light()) + "钻石");
                }
                h().r.setText("去送礼集钻石");
                h().v.setVisibility(0);
                h().y.setVisibility(0);
                h().n.setVisibility(0);
                h().a.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(String.valueOf(yYGoodsWallMode.getLight()));
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00E0AB")), 0, spannableString.length(), 0);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) Long.valueOf(yYGoodsWallMode.getMax_light())));
                h().v.setText(spannableStringBuilder);
                h().n.setMax((int) yYGoodsWallMode.getMax_light());
                h().n.setProgress((int) yYGoodsWallMode.getLight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                SpannableString spannableString2 = new SpannableString(Intrinsics.a("+", (Object) Long.valueOf(yYGoodsWallMode.getBeans() * yYGoodsWallMode.getLight())));
                spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB930")), 0, spannableString2.length(), 0);
                spannableStringBuilder2.append((CharSequence) spannableString2);
                spannableStringBuilder2.append((CharSequence) "钻石");
                h().y.setText(spannableStringBuilder2);
            }
        } else {
            h().u.setVisibility(0);
            h().t.setVisibility(8);
            h().q.setVisibility(8);
            h().r.setText("去点亮夺赞助");
        }
        h().x.setVisibility(0);
        h().i.setVisibility(0);
        ArrayList<YYGoodsWallMode.SponsorMode> sponsor = yYGoodsWallMode.getSponsor();
        if (sponsor != null && sponsor.size() > 0) {
            h().x.setVisibility(8);
            h().i.setVisibility(8);
            h().b.setVisibility(0);
            YYGoodsWallMode.SponsorMode sponsorMode = sponsor.get(0);
            YYRoomInfoManager.e().a(a(), h().j, sponsorMode.getUid(), sponsorMode.getAvatar());
            h().z.setText(YYRoomInfoManager.e().a(sponsorMode.getUid(), sponsorMode.getName()));
            if (sponsor.size() > 1) {
                YYGoodsWallMode.SponsorMode sponsorMode2 = sponsor.get(1);
                YYRoomInfoManager.e().a(a(), h().k, sponsorMode2.getUid(), sponsorMode2.getAvatar());
                h().A.setText(YYRoomInfoManager.e().a(sponsorMode2.getUid(), sponsorMode2.getName()));
                h().A.setTextColor(getResources().getColor(R.color.white));
            } else {
                ImageLoader.a(a(), R.color.white_alpha10).c().a(h().k);
                h().A.setText("虚位以待");
                h().A.setTextColor(getResources().getColor(R.color.syc_989898));
            }
            if (sponsor.size() > 2) {
                YYGoodsWallMode.SponsorMode sponsorMode3 = sponsor.get(2);
                YYRoomInfoManager.e().a(a(), h().l, sponsorMode3.getUid(), sponsorMode3.getAvatar());
                h().B.setText(YYRoomInfoManager.e().a(sponsorMode3.getUid(), sponsorMode3.getName()));
                h().B.setTextColor(getResources().getColor(R.color.white));
            } else {
                ImageLoader.a(a(), R.color.white_alpha10).c().a(h().l);
                h().B.setText("虚位以待");
                h().B.setTextColor(getResources().getColor(R.color.syc_989898));
            }
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.d(ChatRoomProtos.Event.YY_GIFT_WALL_PAGE_GIFT_POP_SHOW, b.room_id, b.uid, yYGoodsWallMode.getGoods_id());
    }

    public final void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public final void a(YYGoodsWallMode yYGoodsWallMode) {
        this.c = yYGoodsWallMode;
    }

    public final void a(YYUserInfo yYUserInfo) {
        this.b = yYUserInfo;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final YYUserInfo f() {
        return this.b;
    }

    public final boolean g() {
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogGiftwallInfoBinding.a(inflater.inflate(R.layout.dialog_giftwall_info, viewGroup, true));
        i();
        return h().getRoot();
    }
}
