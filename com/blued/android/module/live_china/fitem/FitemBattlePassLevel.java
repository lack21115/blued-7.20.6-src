package com.blued.android.module.live_china.fitem;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment;
import com.blued.android.module.live_china.fragment.LiveBattleRandomAwardDialog;
import com.blued.android.module.live_china.fragment.LiveBattleShopDialog;
import com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel;
import com.blued.android.module.live_china.model.BattlePassLevelDataModel;
import com.blued.android.module.live_china.pop.LiveBattlePassAwardTipPop;
import com.blued.das.live.LiveProtos;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/FitemBattlePassLevel.class */
public final class FitemBattlePassLevel extends FreedomItem {
    private Fragment b;

    /* renamed from: c  reason: collision with root package name */
    private BattlePassLevelDataModel f12525c;

    public FitemBattlePassLevel(Fragment fragment, BattlePassLevelDataModel model) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(model, "model");
        this.b = fragment;
        this.f12525c = model;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View topRoot, FitemBattlePassLevel this$0) {
        Intrinsics.e(this$0, "this$0");
        topRoot.setPivotX(topRoot.getWidth() / 2);
        topRoot.setPivotY(topRoot.getHeight());
        Intrinsics.c(topRoot, "topRoot");
        this$0.a(topRoot, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View it, final FitemBattlePassLevel this$0, final BaseViewHolder vh) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        if (it.getTag() != null && (it.getTag() instanceof ObjectAnimator)) {
            Object tag = it.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
            }
            ((ObjectAnimator) tag).pause();
        }
        it.setRotation(0.0f);
        it.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$CA1xwhwpTgSmb8mN_dblXOxEPDA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemBattlePassLevel.b(FitemBattlePassLevel.this, vh, view);
            }
        });
        this$0.c(vh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof ObjectAnimator)) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
            }
            ((ObjectAnimator) tag).pause();
            view.setRotation(0.0f);
        }
        Object tag2 = this.f10935a.itemView.getTag();
        if (tag2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.BattlePassLevelDataModel");
        }
        BattlePassLevelDataModel battlePassLevelDataModel = (BattlePassLevelDataModel) tag2;
        if (LiveBattlePassDialogFragment.f12728a.a()) {
            BattlePassLevelAwardDataModel top = battlePassLevelDataModel.getTop();
            boolean z2 = false;
            if (top != null && top.getState() == 2) {
                z2 = true;
            }
            if (z2) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -5.0f, 5.0f, -5.0f, 0.0f);
                if (ofFloat != null) {
                    ofFloat.setDuration(720L);
                }
                if (ofFloat != null) {
                    ofFloat.setStartDelay(z ? 0L : ofFloat.getDuration() + ((long) LiveProtos.Event.LIVE_PK_CALL_END_VALUE));
                }
                if (ofFloat != null) {
                    ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.fitem.FitemBattlePassLevel$startAnimToTop$$inlined$addListener$default$1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            Intrinsics.e(animator, "animator");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Intrinsics.e(animator, "animator");
                            FitemBattlePassLevel.this.a(view, false);
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
                }
                view.setTag(ofFloat);
                if (ofFloat == null) {
                    return;
                }
                ofFloat.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemBattlePassLevel this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveBattleRandomAwardDialog.f12735a.a(this$0.b, this$0.f12525c.getLevel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00be, code lost:
        if (r0.length() == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.blued.android.module.live_china.fitem.FitemBattlePassLevel r5, com.blued.android.module.common.utils.freedom.BaseViewHolder r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemBattlePassLevel.a(com.blued.android.module.live_china.fitem.FitemBattlePassLevel, com.blued.android.module.common.utils.freedom.BaseViewHolder, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View bottomRoot, FitemBattlePassLevel this$0) {
        Intrinsics.e(this$0, "this$0");
        bottomRoot.setPivotX(bottomRoot.getWidth() / 2);
        bottomRoot.setPivotY(0.0f);
        Intrinsics.c(bottomRoot, "bottomRoot");
        this$0.b(bottomRoot, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View it, final FitemBattlePassLevel this$0, final BaseViewHolder vh) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        if (it.getTag() != null && (it.getTag() instanceof ObjectAnimator)) {
            Object tag = it.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
            }
            ((ObjectAnimator) tag).pause();
        }
        it.setRotation(0.0f);
        it.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$um3F323-CEHAkAk4GRPbNsrBzxY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemBattlePassLevel.c(FitemBattlePassLevel.this, vh, view);
            }
        });
        this$0.d(vh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final View view, boolean z) {
        if (view.getTag() != null && (view.getTag() instanceof ObjectAnimator)) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
            }
            ((ObjectAnimator) tag).pause();
            view.setRotation(0.0f);
        }
        Object tag2 = this.f10935a.itemView.getTag();
        if (tag2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.BattlePassLevelDataModel");
        }
        BattlePassLevelAwardDataModel basic = ((BattlePassLevelDataModel) tag2).getBasic();
        boolean z2 = false;
        if (basic != null && basic.getState() == 2) {
            z2 = true;
        }
        if (z2) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 5.0f, -5.0f, 5.0f, 0.0f);
            if (ofFloat != null) {
                ofFloat.setDuration(720L);
            }
            if (ofFloat != null) {
                ofFloat.setStartDelay(z ? 0L : ofFloat.getDuration() + ((long) LiveProtos.Event.LIVE_PK_CALL_END_VALUE));
            }
            if (ofFloat != null) {
                ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.fitem.FitemBattlePassLevel$startAnimToBottom$$inlined$addListener$default$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        Intrinsics.e(animator, "animator");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Intrinsics.e(animator, "animator");
                        FitemBattlePassLevel.this.b(view, false);
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
            }
            view.setTag(ofFloat);
            if (ofFloat == null) {
                return;
            }
            ofFloat.start();
        }
    }

    private final void b(final BaseViewHolder baseViewHolder) {
        baseViewHolder.a(R.id.tv_exp, (CharSequence) String.valueOf(this.f12525c.getExp()));
        baseViewHolder.a(R.id.iv_random_tag, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$KOwxZ85gJwAFdIz7wpWzc0GpD3I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemBattlePassLevel.a(FitemBattlePassLevel.this, view);
            }
        });
        baseViewHolder.a(R.id.rl_top_award_item_root, new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$3CnKXFTJxBVZNqgQzjXFJq_nyBc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemBattlePassLevel.a(FitemBattlePassLevel.this, baseViewHolder, view);
            }
        });
        final View a2 = baseViewHolder.a(R.id.rl_top_award_root);
        if (a2 != null) {
            a2.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$SUxgtRZ45_SIbEa-jI9NUpItYPI
                @Override // java.lang.Runnable
                public final void run() {
                    FitemBattlePassLevel.a(View.this, this, baseViewHolder);
                }
            });
        }
        final View a3 = baseViewHolder.a(R.id.rl_bottom_award_root);
        if (a3 == null) {
            return;
        }
        a3.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$qXOBBY7Hr8kU4yk_x4QeX6G9y1w
            @Override // java.lang.Runnable
            public final void run() {
                FitemBattlePassLevel.b(View.this, this, baseViewHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00be, code lost:
        if (r0.length() == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(com.blued.android.module.live_china.fitem.FitemBattlePassLevel r5, com.blued.android.module.common.utils.freedom.BaseViewHolder r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.FitemBattlePassLevel.b(com.blued.android.module.live_china.fitem.FitemBattlePassLevel, com.blued.android.module.common.utils.freedom.BaseViewHolder, android.view.View):void");
    }

    private final void c(BaseViewHolder baseViewHolder) {
        BattlePassLevelAwardDataModel top = this.f12525c.getTop();
        if (top == null) {
            return;
        }
        boolean z = false;
        BaseViewHolder b = baseViewHolder.a(R.id.iv_top_award, top.getIcon()).b(R.id.iv_highlight_border, top.getBonus() == 1).b(R.id.iv_random_tag, top.getBonus() == 1);
        int i = R.id.tv_top_num;
        String label = top.getLabel();
        if (label == null || label.length() == 0) {
            z = true;
        }
        b.b(i, !z).a(R.id.tv_top_num, (CharSequence) top.getLabel());
        final View a2 = baseViewHolder.a(R.id.rl_top_award_root);
        View a3 = baseViewHolder.a(R.id.rl_top_award_item_root);
        int state = top.getState();
        if (state == 1) {
            baseViewHolder.a(a2, 1.0f).c(R.id.iv_top_lighting).b(R.id.iv_top_lock, !LiveBattlePassDialogFragment.f12728a.a()).c(R.id.iv_top_lock, R.drawable.live_battle_award_item_lock);
            a3.setBackgroundResource(R.drawable.live_battle_award_item_top_back);
        } else if (state != 2) {
            if (state != 3) {
                return;
            }
            baseViewHolder.a(a2, 0.4f).c(R.id.iv_top_lighting).d(R.id.iv_top_lock).c(R.id.iv_top_lock, R.drawable.live_battle_award_item_lock_un);
            a3.setBackgroundResource(R.drawable.live_battle_award_item_top_back);
        } else {
            baseViewHolder.a(a2, 1.0f);
            a3.setBackgroundResource(R.drawable.live_battle_award_item_top_back_light);
            if (!LiveBattlePassDialogFragment.f12728a.a()) {
                baseViewHolder.c(R.id.iv_top_lighting).d(R.id.iv_top_lock).c(R.id.iv_top_lock, R.drawable.live_battle_award_item_lock);
                return;
            }
            baseViewHolder.d(R.id.iv_top_lighting).c(R.id.iv_top_lock);
            ImageWrapper g = ImageLoader.c(baseViewHolder.b, "live_battle_award_item_lighting.png").g().g(-1);
            View a4 = baseViewHolder.a(R.id.iv_top_lighting);
            if (a4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            g.a((ImageView) a4);
            a2.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$7fdAVzj0n4WBqouKz9479DW6a5U
                @Override // java.lang.Runnable
                public final void run() {
                    FitemBattlePassLevel.a(View.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FitemBattlePassLevel this$0, BaseViewHolder vh, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(vh, "$vh");
        BattlePassLevelAwardDataModel basic = this$0.f12525c.getBasic();
        if (basic == null) {
            return;
        }
        if (basic.getState() == 2) {
            LiveBattleShopDialog.f12741a.a(this$0.e(), 1, this$0.f().getLevel());
            return;
        }
        String bubble_url = basic.getBubble_url();
        if (bubble_url == null || bubble_url.length() == 0) {
            return;
        }
        String bubble_title = basic.getBubble_title();
        if (bubble_title == null || bubble_title.length() == 0) {
            return;
        }
        String bubble_desc = basic.getBubble_desc();
        boolean z = true;
        if (bubble_desc != null) {
            z = bubble_desc.length() == 0;
        }
        if (z) {
            return;
        }
        Context context = vh.f10931a.b;
        Intrinsics.c(context, "vh.adapter.mContext");
        new LiveBattlePassAwardTipPop(context, basic).a(view, "home_basic");
    }

    private final void d(BaseViewHolder baseViewHolder) {
        BattlePassLevelAwardDataModel basic = this.f12525c.getBasic();
        if (basic == null) {
            return;
        }
        BaseViewHolder a2 = baseViewHolder.a(R.id.iv_bottom_award, basic.getIcon());
        int i = R.id.tv_bottom_num;
        String label = basic.getLabel();
        a2.b(i, !(label == null || label.length() == 0)).a(R.id.tv_bottom_num, (CharSequence) basic.getLabel());
        final View a3 = baseViewHolder.a(R.id.rl_bottom_award_root);
        int state = basic.getState();
        if (state == 1) {
            baseViewHolder.a(a3, 1.0f).c(R.id.iv_bottom_lighting).c(R.id.iv_bottom_lock);
            a3.setBackgroundResource(R.drawable.live_battle_award_item_bottom_back);
        } else if (state != 2) {
            if (state != 3) {
                return;
            }
            baseViewHolder.a(a3, 0.4f).c(R.id.iv_bottom_lighting).d(R.id.iv_bottom_lock).c(R.id.iv_bottom_lock, R.drawable.live_battle_award_item_lock_un);
            a3.setBackgroundResource(R.drawable.live_battle_award_item_bottom_back);
        } else {
            baseViewHolder.a(a3, 1.0f).d(R.id.iv_bottom_lighting).c(R.id.iv_bottom_lock);
            ImageWrapper g = ImageLoader.c(baseViewHolder.b, "live_battle_award_item_lighting.png").g().g(-1);
            View a4 = baseViewHolder.a(R.id.iv_bottom_lighting);
            if (a4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            }
            g.a((ImageView) a4);
            a3.setBackgroundResource(R.drawable.live_battle_award_item_bottom_back_light);
            a3.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.-$$Lambda$FitemBattlePassLevel$I6Q5aaDdIQADbyeF99grIEsFrH4
                @Override // java.lang.Runnable
                public final void run() {
                    FitemBattlePassLevel.b(View.this, this);
                }
            });
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_battle_pass_level;
    }

    public final void a(int i, int i2) {
        BattlePassLevelAwardDataModel basic;
        View view;
        Object tag;
        BattlePassLevelAwardDataModel top;
        View view2;
        Object tag2;
        if (LiveBattlePassDialogFragment.f12728a.a() && ((i2 == 0 || i2 == 2) && (top = this.f12525c.getTop()) != null && top.getState() == 2)) {
            top.setState(3);
            BaseViewHolder baseViewHolder = this.f10935a;
            if (baseViewHolder != null) {
                View a2 = baseViewHolder.a(R.id.rl_top_award_root);
                if (a2.getTag() != null && (a2.getTag() instanceof ObjectAnimator)) {
                    Object tag3 = a2.getTag();
                    if (tag3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
                    }
                    ((ObjectAnimator) tag3).pause();
                }
                a2.setRotation(0.0f);
                BaseViewHolder baseViewHolder2 = this.f10935a;
                if (baseViewHolder2 != null && (view2 = baseViewHolder2.itemView) != null && (tag2 = view2.getTag()) != null && ((BattlePassLevelDataModel) tag2).getLevel() == i) {
                    BaseViewHolder viewHolder = this.f10935a;
                    Intrinsics.c(viewHolder, "viewHolder");
                    c(viewHolder);
                }
            }
        }
        if ((i2 == 0 || i2 == 1) && (basic = this.f12525c.getBasic()) != null && basic.getState() == 2) {
            basic.setState(3);
            BaseViewHolder baseViewHolder3 = this.f10935a;
            if (baseViewHolder3 == null) {
                return;
            }
            View a3 = baseViewHolder3.a(R.id.rl_bottom_award_root);
            if (a3.getTag() != null && (a3.getTag() instanceof ObjectAnimator)) {
                Object tag4 = a3.getTag();
                if (tag4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
                }
                ((ObjectAnimator) tag4).pause();
            }
            a3.setRotation(0.0f);
            BaseViewHolder baseViewHolder4 = this.f10935a;
            if (baseViewHolder4 == null || (view = baseViewHolder4.itemView) == null || (tag = view.getTag()) == null || ((BattlePassLevelDataModel) tag).getLevel() != i) {
                return;
            }
            BaseViewHolder viewHolder2 = this.f10935a;
            Intrinsics.c(viewHolder2, "viewHolder");
            b(viewHolder2);
        }
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        vh.itemView.setTag(this.f12525c);
        b(vh);
    }

    public final void b(int i) {
        BattlePassLevelAwardDataModel top;
        BaseViewHolder baseViewHolder;
        View view;
        Object tag;
        if (!LiveBattlePassDialogFragment.f12728a.a() || (top = this.f12525c.getTop()) == null || top.getState() != 2 || (baseViewHolder = this.f10935a) == null || (view = baseViewHolder.itemView) == null || (tag = view.getTag()) == null || ((BattlePassLevelDataModel) tag).getLevel() > i) {
            return;
        }
        BaseViewHolder viewHolder = this.f10935a;
        Intrinsics.c(viewHolder, "viewHolder");
        c(viewHolder);
    }

    public final void b(int i, int i2) {
        View view;
        Object tag;
        this.f12525c.setCurrentExp(i2);
        BattlePassLevelAwardDataModel basic = this.f12525c.getBasic();
        if (basic != null && basic.getState() == 1) {
            basic.setState(2);
        }
        BattlePassLevelAwardDataModel top = this.f12525c.getTop();
        if (top != null && top.getState() == 1) {
            top.setState(2);
        }
        BaseViewHolder baseViewHolder = this.f10935a;
        if (baseViewHolder == null || (view = baseViewHolder.itemView) == null || (tag = view.getTag()) == null || ((BattlePassLevelDataModel) tag).getLevel() != i) {
            return;
        }
        BaseViewHolder viewHolder = this.f10935a;
        Intrinsics.c(viewHolder, "viewHolder");
        b(viewHolder);
    }

    public final void c(int i) {
        BaseViewHolder baseViewHolder;
        View view;
        Object tag;
        BattlePassLevelAwardDataModel top = this.f12525c.getTop();
        boolean z = false;
        if (top != null && top.getState() == 1) {
            z = true;
        }
        if (!z || (baseViewHolder = this.f10935a) == null || (view = baseViewHolder.itemView) == null || (tag = view.getTag()) == null || ((BattlePassLevelDataModel) tag).getLevel() != i) {
            return;
        }
        this.f10935a.c(R.id.iv_top_lock);
    }

    public final void d(int i) {
        a(i, 0);
    }

    public final Fragment e() {
        return this.b;
    }

    public final BattlePassLevelDataModel f() {
        return this.f12525c;
    }

    public final boolean g() {
        BattlePassLevelAwardDataModel top = this.f12525c.getTop();
        return top != null && LiveBattlePassDialogFragment.f12728a.a() && top.getState() == 2;
    }

    public final boolean h() {
        BattlePassLevelAwardDataModel top = this.f12525c.getTop();
        if (top == null || !LiveBattlePassDialogFragment.f12728a.a() || top.getState() == 3) {
            BattlePassLevelAwardDataModel basic = this.f12525c.getBasic();
            return (basic == null || basic.getState() == 3) ? false : true;
        }
        return true;
    }

    public final boolean i() {
        BattlePassLevelAwardDataModel top = this.f12525c.getTop();
        return top != null && LiveBattlePassDialogFragment.f12728a.a() && top.getState() == 1;
    }

    public final boolean j() {
        BattlePassLevelAwardDataModel top = this.f12525c.getTop();
        if (top != null && LiveBattlePassDialogFragment.f12728a.a() && top.getState() == 2) {
            return true;
        }
        BattlePassLevelAwardDataModel basic = this.f12525c.getBasic();
        return basic != null && basic.getState() == 2;
    }

    public final View k() {
        View view;
        BaseViewHolder baseViewHolder = this.f10935a;
        if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
            return null;
        }
        return view.findViewById(R.id.rl_bottom_award_root);
    }
}
