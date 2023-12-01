package com.blued.android.module.live_china.fitem.randomgift;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RandomGiftDialogTopModel;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/randomgift/FitemRandomGiftLove.class */
public final class FitemRandomGiftLove extends FreedomItem {
    private RandomGiftDialogTopModel b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<FitemRandomGiftLoveItem> f12688c;
    private FreedomAdapter d;

    public FitemRandomGiftLove(RandomGiftDialogTopModel model) {
        Intrinsics.e(model, "model");
        this.b = model;
        this.f12688c = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecyclerView recyclerView, ValueAnimator animation) {
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        recyclerView.getLayoutParams().height = ((Integer) animatedValue).intValue();
        recyclerView.setLayoutParams(recyclerView.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemRandomGiftLove this$0, BaseViewHolder vh, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        RandomGiftDialogTopModel randomGiftDialogTopModel = this$0.b;
        randomGiftDialogTopModel.setExpand(!randomGiftDialogTopModel.isExpand());
        View a2 = vh.a(R.id.iv_expand);
        if (this$0.b.isExpand()) {
            EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_OPEN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            a2.setRotation(0.0f);
            a2.animate().rotation(180.0f).setDuration(150L).start();
            vh.a(R.id.tv_expand, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_love_close));
        } else {
            EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_CLOSE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            a2.setRotation(180.0f);
            a2.animate().rotation(360.0f).setDuration(150L).start();
            vh.a(R.id.tv_expand, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_love_expand));
        }
        this$0.f();
    }

    private final void f() {
        int i;
        final RecyclerView recyclerView = (RecyclerView) this.f10935a.a(R.id.rv_list);
        recyclerView.animate().alpha(0.0f).setDuration(150L).setStartDelay(100L).start();
        if (this.b.isExpand()) {
            int size = this.f12688c.size() / 4;
            i = size;
            if (this.f12688c.size() % 4 > 0) {
                i = size + 1;
            }
        } else {
            i = 1;
        }
        ValueAnimator animLiveActivityLp = ValueAnimator.ofInt(recyclerView.getLayoutParams().height, DisplayUtil.a(AppInfo.d(), 116.0f) * i);
        animLiveActivityLp.setDuration(250L);
        animLiveActivityLp.setInterpolator(new DecelerateInterpolator(1.5f));
        animLiveActivityLp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.-$$Lambda$FitemRandomGiftLove$ApSaK2lFkAWIzikepa1N1GDJqh8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FitemRandomGiftLove.a(RecyclerView.this, valueAnimator);
            }
        });
        Intrinsics.c(animLiveActivityLp, "animLiveActivityLp");
        animLiveActivityLp.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftLove$notifyList$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.e(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ArrayList arrayList;
                FreedomAdapter freedomAdapter;
                FreedomAdapter freedomAdapter2;
                FreedomAdapter freedomAdapter3;
                FreedomAdapter freedomAdapter4;
                Intrinsics.e(animator, "animator");
                int a2 = DisplayUtil.a(AppInfo.d(), FitemRandomGiftLove.this.e().isExpand() ? 6.5f : 14.5f);
                recyclerView.setPadding(a2, 0, a2, 0);
                if (FitemRandomGiftLove.this.e().isExpand()) {
                    recyclerView.setLayoutManager(new GridLayoutManager(FitemRandomGiftLove.this.f10935a.f10931a.b, 4));
                } else {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FitemRandomGiftLove.this.f10935a.f10931a.b);
                    linearLayoutManager.setOrientation(0);
                    recyclerView.setLayoutManager(linearLayoutManager);
                }
                FitemRandomGiftLove fitemRandomGiftLove = FitemRandomGiftLove.this;
                Context context = fitemRandomGiftLove.f10935a.f10931a.b;
                IRequestHost iRequestHost = FitemRandomGiftLove.this.f10935a.b;
                arrayList = FitemRandomGiftLove.this.f12688c;
                fitemRandomGiftLove.d = new FreedomAdapter(context, iRequestHost, arrayList);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                freedomAdapter = FitemRandomGiftLove.this.d;
                if (freedomAdapter != null) {
                    freedomAdapter.b("highlight", FitemRandomGiftLove.this.e().getLight_apng());
                }
                freedomAdapter2 = FitemRandomGiftLove.this.d;
                if (freedomAdapter2 != null) {
                    freedomAdapter2.b("is_horizontal", Boolean.valueOf(FitemRandomGiftLove.this.e().isExpand()));
                }
                freedomAdapter3 = FitemRandomGiftLove.this.d;
                if (freedomAdapter3 != null) {
                    freedomAdapter3.b("full_times", Integer.valueOf(FitemRandomGiftLove.this.e().getFull_times()));
                }
                RecyclerView recyclerView2 = recyclerView;
                freedomAdapter4 = FitemRandomGiftLove.this.d;
                recyclerView2.setAdapter(freedomAdapter4);
                recyclerView.animate().alpha(1.0f).setDuration(150L).setStartDelay(0L).start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.e(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.e(animator, "animator");
            }
        });
        animLiveActivityLp.start();
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_random_gift_love;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, final BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(vh, "vh");
        vh.a(R.id.tv_title, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_love_title, Integer.valueOf(this.b.getCurrent_count()), Integer.valueOf(this.b.getFull_count()))).a(R.id.tv_title, true).a(R.id.tv_subtitle, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_love_subtitle, LiveRoomManager.a().h(), String.valueOf(this.b.getFull_times()))).a(R.id.tv_subtitle, true).b(R.id.tv_subtitle, this.b.getFull_times() >= 1).a(R.id.tv_subtitle, LiveUtils.a(vh.b(R.id.tv_subtitle), "#FF7B00", false));
        ArrayList<RandomGiftItemModel> list2 = this.b.getList();
        if (list2 == null) {
            return;
        }
        this.f12688c.clear();
        ArrayList<RandomGiftItemModel> list3 = e().getList();
        if (list3 != null) {
            for (RandomGiftItemModel randomGiftItemModel : list3) {
                this.f12688c.add(new FitemRandomGiftLoveItem(randomGiftItemModel));
            }
        }
        f();
        if (list2.size() <= 4) {
            vh.c(R.id.ll_expand);
            return;
        }
        if (e().isExpand()) {
            vh.a(R.id.tv_expand, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_love_close));
            vh.a(R.id.iv_expand).setRotation(180.0f);
        } else {
            vh.a(R.id.tv_expand, (CharSequence) AppInfo.d().getString(R.string.live_random_gift_love_expand));
            vh.a(R.id.iv_expand).setRotation(0.0f);
        }
        vh.a(R.id.ll_expand, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.randomgift.-$$Lambda$FitemRandomGiftLove$HszgbrB7ZrYVpzJPDq3P4bWKOC8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemRandomGiftLove.a(FitemRandomGiftLove.this, vh, view);
            }
        });
    }

    public final RandomGiftDialogTopModel e() {
        return this.b;
    }
}
