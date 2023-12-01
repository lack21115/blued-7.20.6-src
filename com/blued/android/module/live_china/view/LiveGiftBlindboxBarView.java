package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveBlindBoxGiftBarViewBinding;
import com.blued.android.module.live_china.fragment.LiveLuckyBagDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftBlindBoxModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftBlindboxBarView.class */
public final class LiveGiftBlindboxBarView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14469a;
    private PlayingOnliveFragment b;

    /* renamed from: c  reason: collision with root package name */
    private LiveGiftBlindBoxModel f14470c;
    private String d;
    private final Lazy e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftBlindboxBarView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftBlindboxBarView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftBlindboxBarView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.f14469a = mContext;
        this.d = "";
        this.e = LazyKt.a(new Function0<LiveBlindBoxGiftBarViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveGiftBlindboxBarView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveBlindBoxGiftBarViewBinding invoke() {
                LiveBlindBoxGiftBarViewBinding a2 = LiveBlindBoxGiftBarViewBinding.a(LayoutInflater.from(LiveGiftBlindboxBarView.this.getMContext()).inflate(R.layout.live_blind_box_gift_bar_view, LiveGiftBlindboxBarView.this));
                Intrinsics.c(a2, "bind(\n            Layout…bar_view, this)\n        )");
                return a2;
            }
        });
        a();
    }

    public /* synthetic */ LiveGiftBlindboxBarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void a() {
    }

    private final void a(LiveGiftBlindBoxModel liveGiftBlindBoxModel) {
        getVb().f12154c.getRoot().setVisibility(8);
        getVb().b.setVisibility(0);
        getVb().e.setVisibility(0);
        getVb().f12153a.setVisibility(0);
        ImageLoader.a((IRequestHost) null, liveGiftBlindBoxModel.getBlind_goods_image()).a(getVb().e);
        ImageLoader.a((IRequestHost) null, liveGiftBlindBoxModel.getGoods_image()).a(getVb().f);
        getVb().g.setText(liveGiftBlindBoxModel.getDesc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftBlindboxBarView this$0, String goodId, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(goodId, "$goodId");
        EventTrackLive.b(LiveProtos.Event.LIVE_BLIND_BOX_INTRODUCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.d);
        LiveLuckyBagDialogFragment.Companion companion = LiveLuckyBagDialogFragment.f13008a;
        PlayingOnliveFragment playingOnliveFragment = this$0.b;
        PlayingOnliveFragment playingOnliveFragment2 = playingOnliveFragment;
        if (playingOnliveFragment == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment2 = null;
        }
        FragmentManager childFragmentManager = playingOnliveFragment2.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "mFragment.childFragmentManager");
        companion.a(childFragmentManager, Integer.parseInt(goodId));
    }

    private final void b() {
    }

    private final void b(LiveGiftBlindBoxModel liveGiftBlindBoxModel) {
        getVb().f12154c.getRoot().setVisibility(0);
        getVb().b.setVisibility(8);
        getVb().e.setVisibility(8);
        getVb().f12153a.setVisibility(8);
        ImageLoader.a((IRequestHost) null, liveGiftBlindBoxModel.getBlind_goods_image()).a(getVb().e);
        ImageLoader.a((IRequestHost) null, liveGiftBlindBoxModel.getGoods_image()).a(getVb().f12154c.f12152c);
        getVb().f12154c.i.setText(liveGiftBlindBoxModel.getDesc());
        getVb().f12154c.g.setText(liveGiftBlindBoxModel.getGoods_beans());
        getVb().f12154c.h.setText(liveGiftBlindBoxModel.getGoods_name());
        getVb().f12154c.e.setText(String.valueOf(liveGiftBlindBoxModel.getCurrent()));
        getVb().f12154c.f.setText(Intrinsics.a(" / ", (Object) Integer.valueOf(liveGiftBlindBoxModel.getMax())));
        if (liveGiftBlindBoxModel.getMax() != 0) {
            getVb().f12154c.b.a(liveGiftBlindBoxModel.getCurrent() / liveGiftBlindBoxModel.getMax());
        }
    }

    private final LiveBlindBoxGiftBarViewBinding getVb() {
        return (LiveBlindBoxGiftBarViewBinding) this.e.getValue();
    }

    public final void a(int i, int i2) {
        getVb().f12154c.e.setText(String.valueOf(i));
        getVb().f12154c.b.a(i / i2);
    }

    public final void a(PlayingOnliveFragment fragment, final String goodId, LiveGiftBlindBoxModel data) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(goodId, "goodId");
        Intrinsics.e(data, "data");
        this.b = fragment;
        this.f14470c = data;
        this.d = goodId;
        if (data.getShow_type() == 1) {
            b(data);
        } else if (data.getShow_type() == 2) {
            a(data);
        }
        ImageLoader.a((IRequestHost) null, data.getImg()).a(getVb().d);
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftBlindboxBarView$NLO5BTMeDI3z9ikCFZ0TABSwI0A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftBlindboxBarView.a(LiveGiftBlindboxBarView.this, goodId, view);
            }
        });
    }

    public final String getGoodId() {
        return this.d;
    }

    public final Context getMContext() {
        return this.f14469a;
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
    }
}
