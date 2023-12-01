package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.model.LiveFansLevelModel;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.ItemLiveOnlineUserBinding;
import com.blued.android.module.live_china.dialog.LiveBehalfSendGiftDialogTip;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveOnLineBehalfExtra;
import com.blued.android.module.live_china.model.LiveOnlineUserEntity;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveOnlineUserAdapter.class */
public final class LiveOnlineUserAdapter extends BaseQuickAdapter<LiveOnlineUserEntity, BaseViewHolder> {
    private Context a;
    private IRequestHost b;
    private boolean c;
    private LiveOnLineBehalfExtra d;
    private LiveOnlineUserEntity e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveOnlineUserAdapter(Context context, IRequestHost fragmentActive, boolean z) {
        super(R.layout.item_live_online_user);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = context;
        this.b = fragmentActive;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveOnlineUserEntity liveOnlineUserEntity, final LiveOnlineUserAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = liveOnlineUserEntity.getBehalf_status() == 1 ? 0 : 1;
        EventTrackLive.y(this$0.c ? LiveProtos.Event.LIVE_ONLINE_NOBLE_PAGE_SUBSTITUTE_CLICK : LiveProtos.Event.LIVE_ONLINE_USER_PAGE_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(intRef.a));
        if (intRef.a != 1) {
            this$0.a(liveOnlineUserEntity, intRef.a);
            return;
        }
        Context context = this$0.mContext;
        LiveOnLineBehalfExtra liveOnLineBehalfExtra = this$0.d;
        new LiveBehalfSendGiftDialogTip(context, liveOnLineBehalfExtra == null ? null : liveOnLineBehalfExtra.getPopover_title(), liveOnlineUserEntity.getName(), new LiveBehalfSendGiftDialogTip.IEventCallback() { // from class: com.blued.android.module.live_china.adapter.LiveOnlineUserAdapter$convert$1$1$1
            @Override // com.blued.android.module.live_china.dialog.LiveBehalfSendGiftDialogTip.IEventCallback
            public void a() {
                LiveOnlineUserAdapter.this.a(liveOnlineUserEntity, intRef.a);
            }
        }).show();
    }

    private final boolean b(LiveOnlineUserEntity liveOnlineUserEntity) {
        if (liveOnlineUserEntity == null) {
            return false;
        }
        boolean z = false;
        if (liveOnlineUserEntity.getFans_status() == 0) {
            z = false;
            if (liveOnlineUserEntity.getRich_level() == 0) {
                String chat_badge_url = liveOnlineUserEntity.getChat_badge_url();
                z = false;
                if (chat_badge_url == null || chat_badge_url.length() == 0) {
                    String nameplate_img = liveOnlineUserEntity.getNameplate_img();
                    z = false;
                    if (nameplate_img == null || nameplate_img.length() == 0) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final void a(LiveOnLineBehalfExtra liveOnLineBehalfExtra) {
        this.d = liveOnLineBehalfExtra;
    }

    public final void a(LiveOnlineUserEntity liveOnlineUserEntity) {
        this.e = liveOnlineUserEntity;
    }

    public final void a(final LiveOnlineUserEntity item, final int i) {
        Intrinsics.e(item, "item");
        String valueOf = String.valueOf(item.getUid());
        String g = LiveRoomManager.a().g();
        String e = LiveRoomManager.a().e();
        final IRequestHost iRequestHost = this.b;
        LiveRoomHttpUtils.a(valueOf, g, e, i, new BluedUIHttpResponse<BluedEntityA<Object>>(iRequestHost) { // from class: com.blued.android.module.live_china.adapter.LiveOnlineUserAdapter$bindBehalf$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                LiveOnlineUserEntity c = LiveOnlineUserAdapter.this.c();
                if (c != null) {
                    c.setBehalf_status(0);
                }
                item.setBehalf_status(i);
                LiveOnlineUserAdapter.this.notifyDataSetChanged();
                LiveOnlineUserAdapter.this.a(item);
                if (i == 1) {
                    LiveEventBus.get("close_online_user_dialog", Boolean.TYPE).post(true);
                    LiveRefreshUIObserver.a().k();
                }
            }
        }, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final LiveOnlineUserEntity liveOnlineUserEntity) {
        Intrinsics.e(helper, "helper");
        ItemLiveOnlineUserBinding a = ItemLiveOnlineUserBinding.a(helper.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        ShapeModel shapeModel = a.a.getShapeModel();
        if (liveOnlineUserEntity == null) {
            return;
        }
        int weight = liveOnlineUserEntity.getWeight();
        if (weight == 0) {
            ImageView imageView = a.h;
            Intrinsics.c(imageView, "liveOnlineUserBinding.ivOnlineUserWeight");
            BluedViewExKt.b(imageView);
            shapeModel.t = getContext().getResources().getColor(R.color.syc_FFEED4);
            shapeModel.v = getContext().getResources().getColor(R.color.syc_FFFFFE);
            a.h.setImageResource(R.drawable.icon_live_online_user_no1);
        } else if (weight == 1) {
            ImageView imageView2 = a.h;
            Intrinsics.c(imageView2, "liveOnlineUserBinding.ivOnlineUserWeight");
            BluedViewExKt.b(imageView2);
            shapeModel.t = getContext().getResources().getColor(R.color.syc_E1F0FA);
            shapeModel.v = getContext().getResources().getColor(R.color.syc_FFFFFE);
            a.h.setImageResource(R.drawable.icon_live_online_user_no2);
        } else if (weight != 2) {
            ImageView imageView3 = a.h;
            Intrinsics.c(imageView3, "liveOnlineUserBinding.ivOnlineUserWeight");
            BluedViewExKt.a(imageView3);
            shapeModel.t = getContext().getResources().getColor(R.color.white);
            shapeModel.v = getContext().getResources().getColor(R.color.white);
        } else {
            ImageView imageView4 = a.h;
            Intrinsics.c(imageView4, "liveOnlineUserBinding.ivOnlineUserWeight");
            BluedViewExKt.b(imageView4);
            shapeModel.t = getContext().getResources().getColor(R.color.syc_FFEBE6);
            shapeModel.v = getContext().getResources().getColor(R.color.syc_FFFFFE);
            a.h.setImageResource(R.drawable.icon_live_online_user_no3);
        }
        a.d.setVisibility(liveOnlineUserEntity.is_manager() == 1 ? 0 : 8);
        a.a.setShapeModel(shapeModel);
        a.k.setText(liveOnlineUserEntity.getName());
        ViewGroup.LayoutParams layoutParams = a.k.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ConstraintLayout.LayoutParams) layoutParams2).bottomToBottom = b(liveOnlineUserEntity) ? R.id.iv_online_user_avatar : -1;
        a.k.setLayoutParams(layoutParams2);
        ImageLoader.a((IRequestHost) null, liveOnlineUserEntity.getAvatar()).c().b(R.drawable.user_bg_round).a(a.f);
        if (liveOnlineUserEntity.getAvatar_frame().length() > 0) {
            ImageView imageView5 = a.g;
            Intrinsics.c(imageView5, "liveOnlineUserBinding.ivOnlineUserAvatarFrame");
            BluedViewExKt.b(imageView5);
            ImageLoader.a((IRequestHost) null, liveOnlineUserEntity.getAvatar_frame()).g().g(-1).a(a.g);
        } else {
            ImageView imageView6 = a.g;
            Intrinsics.c(imageView6, "liveOnlineUserBinding.ivOnlineUserAvatarFrame");
            BluedViewExKt.a(imageView6);
        }
        int a2 = AppMethods.a(15);
        ViewGroup.LayoutParams layoutParams3 = a.e.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        String chat_badge_url = liveOnlineUserEntity.getChat_badge_url();
        if (chat_badge_url == null || chat_badge_url.length() == 0) {
            ImageView imageView7 = a.b;
            Intrinsics.c(imageView7, "liveOnlineUserBinding.ivChatMarker");
            BluedViewExKt.a(imageView7);
            int i = layoutParams4.width;
            layoutParams4.height = 0;
        } else {
            ImageView imageView8 = a.b;
            Intrinsics.c(imageView8, "liveOnlineUserBinding.ivChatMarker");
            BluedViewExKt.b(imageView8);
            int chat_badge_length = (int) ((a2 * liveOnlineUserEntity.getChat_badge_length()) / liveOnlineUserEntity.getChat_badge_height());
            ImageLoader.a((IRequestHost) null, liveOnlineUserEntity.getChat_badge_url()).a(chat_badge_length, a2).g().g(-1).a(a.b);
            layoutParams4.width = chat_badge_length;
            layoutParams4.height = a2;
        }
        a.b.setLayoutParams(layoutParams4);
        if (liveOnlineUserEntity.getRich_level() != 0) {
            ImageView imageView9 = a.i;
            Intrinsics.c(imageView9, "liveOnlineUserBinding.ivRichLevel");
            BluedViewExKt.b(imageView9);
            a.i.setImageDrawable(LiveBitmapUtils.a(AppInfo.d(), liveOnlineUserEntity.getRich_level()));
        } else {
            ImageView imageView10 = a.i;
            Intrinsics.c(imageView10, "liveOnlineUserBinding.ivRichLevel");
            BluedViewExKt.a(imageView10);
        }
        ShapeModel shapeModel2 = a.j.getShapeModel();
        EventTrackLive.y(a() ? LiveProtos.Event.LIVE_ONLINE_NOBLE_PAGE_USER_SHOW : LiveProtos.Event.LIVE_PK_MORE_START_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(liveOnlineUserEntity.getBehalf_status()));
        if (LiveRoomInfo.a().f().equals(String.valueOf(liveOnlineUserEntity.getUid())) || b() == null) {
            ShapeTextView shapeTextView = a.j;
            Intrinsics.c(shapeTextView, "liveOnlineUserBinding.tvGiveGiftsBehalf");
            BluedViewExKt.a((View) shapeTextView);
        } else {
            int behalf_status = liveOnlineUserEntity.getBehalf_status();
            if (behalf_status == 0) {
                a(liveOnlineUserEntity);
                ShapeTextView shapeTextView2 = a.j;
                Intrinsics.c(shapeTextView2, "liveOnlineUserBinding.tvGiveGiftsBehalf");
                BluedViewExKt.b((View) shapeTextView2);
                ShapeTextView shapeTextView3 = a.j;
                LiveOnLineBehalfExtra b = b();
                shapeTextView3.setText(b == null ? null : b.getSwitch_enable_name());
                shapeModel2.t = getContext().getResources().getColor(R.color.syc_dark_922CEE);
                shapeModel2.v = getContext().getResources().getColor(R.color.syc_dark_FF3AAA);
                shapeModel2.n = 0;
                ShapeHelper.a((ShapeHelper.ShapeView) a.j, R.color.white);
                shapeModel2.q = DensityUtils.a(this.mContext, 0.0f);
            } else if (behalf_status == 1) {
                ShapeTextView shapeTextView4 = a.j;
                Intrinsics.c(shapeTextView4, "liveOnlineUserBinding.tvGiveGiftsBehalf");
                BluedViewExKt.b((View) shapeTextView4);
                ShapeTextView shapeTextView5 = a.j;
                LiveOnLineBehalfExtra b2 = b();
                shapeTextView5.setText(b2 == null ? null : b2.getSwitch_disable_name());
                shapeModel2.t = 0;
                shapeModel2.v = 0;
                shapeModel2.n = getContext().getResources().getColor(R.color.syc_dark_C933CC);
                shapeModel2.k = getContext().getResources().getColor(R.color.syc_FEF2FF);
                ShapeHelper.a((ShapeHelper.ShapeView) a.j, R.color.syc_dark_C933CC);
                shapeModel2.q = DensityUtils.a(this.mContext, 1.0f);
            } else if (behalf_status != 2) {
                ShapeTextView shapeTextView6 = a.j;
                Intrinsics.c(shapeTextView6, "liveOnlineUserBinding.tvGiveGiftsBehalf");
                BluedViewExKt.a((View) shapeTextView6);
            } else {
                ShapeTextView shapeTextView7 = a.j;
                Intrinsics.c(shapeTextView7, "liveOnlineUserBinding.tvGiveGiftsBehalf");
                BluedViewExKt.a((View) shapeTextView7);
            }
            a.j.setShapeModel(shapeModel2);
            a.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveOnlineUserAdapter$YHLWC_UnlT9wQabTcSIo030se0I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveOnlineUserAdapter.a(LiveOnlineUserEntity.this, this, view);
                }
            });
        }
        ViewGroup.LayoutParams layoutParams5 = a.e.getLayoutParams();
        if (layoutParams5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) layoutParams5;
        String nameplate_img = liveOnlineUserEntity.getNameplate_img();
        if (nameplate_img == null || nameplate_img.length() == 0) {
            ImageView imageView11 = a.e;
            Intrinsics.c(imageView11, "liveOnlineUserBinding.ivNobleMarker");
            BluedViewExKt.a(imageView11);
            layoutParams6.width = 0;
            layoutParams6.height = 0;
        } else {
            ImageView imageView12 = a.e;
            Intrinsics.c(imageView12, "liveOnlineUserBinding.ivNobleMarker");
            BluedViewExKt.b(imageView12);
            int nameplate_img_width = (liveOnlineUserEntity.getNameplate_img_width() * a2) / liveOnlineUserEntity.getNameplate_img_height();
            ImageLoader.a((IRequestHost) null, liveOnlineUserEntity.getNameplate_img()).a(nameplate_img_width, a2).g().g(-1).a(a.e);
            layoutParams6.width = nameplate_img_width;
            layoutParams6.height = a2;
        }
        a.e.setLayoutParams(layoutParams6);
        if (liveOnlineUserEntity.getFans_status() == 0) {
            LiveFansLevelView liveFansLevelView = a.c;
            Intrinsics.c(liveFansLevelView, "liveOnlineUserBinding.ivFansLevel");
            BluedViewExKt.a(liveFansLevelView);
            return;
        }
        LiveFansLevelModel liveFansLevelModel = new LiveFansLevelModel();
        liveFansLevelModel.fan_club_level = liveOnlineUserEntity.getClub_level();
        liveFansLevelModel.fans_status = liveOnlineUserEntity.getFans_status();
        liveFansLevelModel.fan_club_name = liveOnlineUserEntity.getClub_name();
        liveFansLevelModel.in_fan_club = 1;
        a.c.setFansLevel(liveFansLevelModel);
        LiveFansLevelView liveFansLevelView2 = a.c;
        Intrinsics.c(liveFansLevelView2, "liveOnlineUserBinding.ivFansLevel");
        BluedViewExKt.b(liveFansLevelView2);
    }

    public final boolean a() {
        return this.c;
    }

    public final LiveOnLineBehalfExtra b() {
        return this.d;
    }

    public final LiveOnlineUserEntity c() {
        return this.e;
    }

    public final Context getContext() {
        return this.a;
    }
}
