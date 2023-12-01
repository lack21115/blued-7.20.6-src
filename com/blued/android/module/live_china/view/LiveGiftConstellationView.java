package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveConstellationGiftBarViewBinding;
import com.blued.android.module.live_china.fragment.LiveConstellationDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GiftConstellationBuyInfoModel;
import com.blued.android.module.live_china.model.LiveGiftConstellationModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftConstellationView.class */
public final class LiveGiftConstellationView extends RelativeLayout {
    private final Context a;
    private PlayingOnliveFragment b;
    private LiveGiftConstellationModel c;
    private String d;
    private String e;
    private String f;
    private final Observer<LiveGiftConstellationModel> g;
    private final Lazy h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftConstellationView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftConstellationView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftConstellationView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.d = "";
        this.e = "";
        this.f = "https://web.bldimg.com/image-manager/1688543781_46784.webp";
        this.g = new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftConstellationView$yJ6pEd1ldOHqPahxa42JuhPiAYk
            public final void onChanged(Object obj) {
                LiveGiftConstellationView.a(LiveGiftConstellationView.this, (LiveGiftConstellationModel) obj);
            }
        };
        this.h = LazyKt.a(new Function0<LiveConstellationGiftBarViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveGiftConstellationView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveConstellationGiftBarViewBinding invoke() {
                LiveConstellationGiftBarViewBinding a = LiveConstellationGiftBarViewBinding.a(LayoutInflater.from(LiveGiftConstellationView.this.getMContext()).inflate(R.layout.live_constellation_gift_bar_view, LiveGiftConstellationView.this));
                Intrinsics.c(a, "bind(\n            Layout…bar_view, this)\n        )");
                return a;
            }
        });
    }

    public /* synthetic */ LiveGiftConstellationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
        Observable observable = LiveEventBus.get(LiveEventBusUtil.X, LiveGiftConstellationModel.class);
        LifecycleOwner lifecycleOwner = this.b;
        PlayingOnliveFragment playingOnliveFragment = lifecycleOwner;
        if (lifecycleOwner == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment = null;
        }
        observable.observe(playingOnliveFragment, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final GiftConstellationBuyInfoModel giftConstellationBuyInfoModel, final boolean z) {
        String format;
        if (giftConstellationBuyInfoModel == null) {
            return;
        }
        if (z) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String string = this.a.getString(R.string.live_constellation_onekey_to_top_title, giftConstellationBuyInfoModel.getBeans(), giftConstellationBuyInfoModel.getCount(), giftConstellationBuyInfoModel.getGoods_name(), LiveRoomManager.a().h());
            Intrinsics.c(string, "mContext.getString(\n    …orName,\n                )");
            format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.c(format, "format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.a;
            String string2 = this.a.getString(R.string.live_constellation_onekey_to_unlock_title, giftConstellationBuyInfoModel.getBeans(), giftConstellationBuyInfoModel.getCount(), giftConstellationBuyInfoModel.getGoods_name());
            Intrinsics.c(string2, "mContext.getString(\n    …ds_name\n                )");
            format = String.format(string2, Arrays.copyOf(new Object[0], 0));
            Intrinsics.c(format, "format(format, *args)");
        }
        CommonAlertDialog.a(this.a, format, (String) null, "确认", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftConstellationView$PQ1y9vSxxjp463t7FrURKqASBaQ
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveGiftConstellationView.a(z, this, giftConstellationBuyInfoModel, dialogInterface, i);
            }
        }, "取消", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftConstellationView$Uqv5N8witXDioTPcsNUSPUwbHkw
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveGiftConstellationView.a(dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    private final void a(LiveGiftConstellationModel liveGiftConstellationModel) {
        if (liveGiftConstellationModel == null) {
            return;
        }
        if (!TextUtils.isEmpty(liveGiftConstellationModel.getAnchor_avatar())) {
            ImageLoader.a((IRequestHost) null, liveGiftConstellationModel.getAnchor_avatar()).c().a(getVb().a);
        }
        if (!TextUtils.isEmpty(liveGiftConstellationModel.getAvatar())) {
            ImageLoader.a((IRequestHost) null, liveGiftConstellationModel.getAvatar()).c().a(getVb().b);
        }
        if (liveGiftConstellationModel.getBasic_remain() == -1) {
            return;
        }
        if (liveGiftConstellationModel.getBasic_remain() == 0) {
            getVb().l.setVisibility(8);
            getVb().h.setImageResource(R.drawable.live_constellation_one_key_to_peak);
        } else {
            getVb().h.setImageResource(R.drawable.live_constellation_unlock_to_peak);
            getVb().l.setVisibility(0);
            TextView textView = getVb().l;
            textView.setText("还有" + liveGiftConstellationModel.getBasic_remain() + "个可解锁");
        }
        SharedPreferencesUtils.b().edit().putInt("constellation", liveGiftConstellationModel.getBasic_remain()).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftConstellationModel data, LiveGiftConstellationView this$0, View view) {
        Intrinsics.e(data, "$data");
        Intrinsics.e(this$0, "this$0");
        int basic_remain = data.getBasic_remain();
        if (SharedPreferencesUtils.b().getInt("constellation", -1) != -1) {
            basic_remain = SharedPreferencesUtils.b().getInt("constellation", -1);
        }
        this$0.a(basic_remain == 0);
        EventTrackLive.b(data.getBasic_remain() == 0 ? LiveProtos.Event.LIVE_STAR_INTRODUCE_ONE_TOP_CLICK : LiveProtos.Event.LIVE_STAR_INTRODUCE_UNLOCK_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), data.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftConstellationView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveConstellationDialogFragment.Companion companion = LiveConstellationDialogFragment.a;
        PlayingOnliveFragment playingOnliveFragment = this$0.b;
        PlayingOnliveFragment playingOnliveFragment2 = playingOnliveFragment;
        if (playingOnliveFragment == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment2 = null;
        }
        FragmentManager childFragmentManager = playingOnliveFragment2.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "mFragment.childFragmentManager");
        companion.a(childFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftConstellationView this$0, LiveGiftConstellationModel liveGiftConstellationModel) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(liveGiftConstellationModel);
    }

    private final void a(final boolean z) {
        int i = z ? 1 : 2;
        String g = LiveRoomManager.a().g();
        PlayingOnliveFragment playingOnliveFragment = this.b;
        PlayingOnliveFragment playingOnliveFragment2 = playingOnliveFragment;
        if (playingOnliveFragment == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment2 = null;
        }
        final ActivityFragmentActive fragmentActive = playingOnliveFragment2.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<GiftConstellationBuyInfoModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<GiftConstellationBuyInfoModel>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LiveGiftConstellationView$getAlertDialogInfo$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<GiftConstellationBuyInfoModel> bluedEntityA) {
                if ((bluedEntityA == null ? null : bluedEntityA.data) == null || bluedEntityA.data.isEmpty()) {
                    return;
                }
                LiveGiftConstellationView liveGiftConstellationView = LiveGiftConstellationView.this;
                List<GiftConstellationBuyInfoModel> list = bluedEntityA.data;
                Intrinsics.c(list, "entity.data");
                liveGiftConstellationView.a((GiftConstellationBuyInfoModel) CollectionsKt.c((List<? extends Object>) list, 0), z);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str, String str2) {
                return super.onUIFailure(i2, str, str2);
            }
        };
        PlayingOnliveFragment playingOnliveFragment3 = this.b;
        if (playingOnliveFragment3 == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment3 = null;
        }
        LiveRoomHttpUtils.c(g, i, bluedUIHttpResponse, playingOnliveFragment3.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(boolean z, LiveGiftConstellationView this$0, GiftConstellationBuyInfoModel giftConstellationBuyInfoModel, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.b(z ? LiveProtos.Event.LIVE_STAR_INTRODUCE_ONE_TOP_SUCCESS : LiveProtos.Event.LIVE_STAR_INTRODUCE_UNLOCK_SUCCESS, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.e);
        LiveEventBusUtil.a(giftConstellationBuyInfoModel);
    }

    private final void b() {
        LiveEventBus.get(LiveEventBusUtil.X, LiveGiftConstellationModel.class).removeObserver(this.g);
    }

    private final LiveConstellationGiftBarViewBinding getVb() {
        return (LiveConstellationGiftBarViewBinding) this.h.getValue();
    }

    public final void a(PlayingOnliveFragment fragment, String goodId, final LiveGiftConstellationModel data) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(goodId, "goodId");
        Intrinsics.e(data, "data");
        this.b = fragment;
        this.c = data;
        this.d = goodId;
        this.e = data.getId();
        a();
        String anchor_avatar = data.getAnchor_avatar();
        if (anchor_avatar == null || anchor_avatar.length() == 0) {
            data.setAnchor_avatar(this.f);
        }
        String avatar = data.getAvatar();
        boolean z = true;
        if (avatar != null) {
            z = avatar.length() == 0;
        }
        if (z) {
            data.setAvatar(this.f);
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_STAR_INTRODUCE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), data.getId());
        getVb().l.setVisibility(8);
        ImageLoader.a((IRequestHost) null, data.getImage()).a(getVb().e);
        getVb().k.setText(data.getDesc());
        ImageLoader.a((IRequestHost) null, data.getAnchor_avatar()).a("https://web.bldimg.com/image-manager/1688612005_75792.png").c().a(getVb().a);
        ImageLoader.a((IRequestHost) null, data.getAvatar()).a("https://web.bldimg.com/image-manager/1688612005_75792.png").c().a(getVb().b);
        if (data.getBasic_remain() == 0) {
            getVb().h.setImageResource(R.drawable.live_constellation_one_key_to_peak);
            EventTrackLive.b(LiveProtos.Event.LIVE_STAR_INTRODUCE_ONE_TOP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), data.getId());
        } else {
            EventTrackLive.b(LiveProtos.Event.LIVE_STAR_INTRODUCE_UNLOCK_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), data.getId());
            getVb().h.setImageResource(R.drawable.live_constellation_unlock_to_peak);
            getVb().l.setVisibility(0);
            if (SharedPreferencesUtils.b().getInt("constellation", -1) != -1) {
                getVb().l.setText("还有" + SharedPreferencesUtils.b().getInt("constellation", -1) + "个可解锁");
            } else {
                getVb().l.setText("还有" + data.getBasic_remain() + "个可解锁");
            }
        }
        getVb().f.setText(Intrinsics.a(data.getName(), (Object) "之巅"));
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftConstellationView$v2Z9wEGui3bOoFqa9BGe4HhIBOw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftConstellationView.a(LiveGiftConstellationView.this, view);
            }
        });
        getVb().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftConstellationView$xjZBPPwO9ZG7yxwBou3LHVAKHnM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftConstellationView.a(LiveGiftConstellationModel.this, this, view);
            }
        });
    }

    public final String getGoodId() {
        return this.d;
    }

    public final Context getMContext() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        SharedPreferencesUtils.b().edit().putInt("constellation", -1).apply();
    }
}
