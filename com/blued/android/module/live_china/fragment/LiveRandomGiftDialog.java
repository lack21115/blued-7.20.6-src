package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveRandomGiftBinding;
import com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftDrawLottery;
import com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftHostDrawLottery;
import com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftHostLottery;
import com.blued.android.module.live_china.fragment.LiveRandomGiftInfoDialog;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.RandomGiftDialogDataModel;
import com.blued.android.module.live_china.model.RandomGiftDialogRewardModel;
import com.blued.android.module.live_china.model.RandomGiftHostDialogDataModel;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftDialog.class */
public final class LiveRandomGiftDialog extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private FreedomAdapter e;
    private LinearLayoutManager f;
    private RandomGiftDialogDataModel g;
    private boolean h;
    private RandomGiftHostDialogDataModel i;
    private final Lazy b = LazyKt.a(new Function0<DialogLiveRandomGiftBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveRandomGiftBinding invoke() {
            return DialogLiveRandomGiftBinding.a(LayoutInflater.from(LiveRandomGiftDialog.this.getContext()));
        }
    });
    private String c = "";
    private final ArrayList<FreedomItem> d = new ArrayList<>();
    private final String j = "@\\(word:([\\s\\S]*?)\\)";
    private Pattern k = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveRandomGiftDialog a(BaseFragment fragment) {
            Intrinsics.e(fragment, "fragment");
            return a("", fragment);
        }

        public final LiveRandomGiftDialog a(String goods_id, BaseFragment fragment) {
            Intrinsics.e(goods_id, "goods_id");
            Intrinsics.e(fragment, "fragment");
            LiveRandomGiftDialog liveRandomGiftDialog = new LiveRandomGiftDialog();
            Bundle bundle = new Bundle();
            bundle.putString("goods_id", goods_id);
            liveRandomGiftDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            liveRandomGiftDialog.show(childFragmentManager, LiveRandomGiftDialog.class.getSimpleName());
            return liveRandomGiftDialog;
        }
    }

    private final CharSequence a(CharSequence charSequence, int i) {
        int i2;
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Matcher matcher = this.k.matcher(charSequence);
        int i3 = 0;
        while (true) {
            i2 = i3;
            if (!matcher.find()) {
                break;
            }
            String group = matcher.group(1);
            spannableStringBuilder.append(charSequence.subSequence(i2, matcher.start()));
            int length = spannableStringBuilder.length();
            int length2 = group.length() + length;
            spannableStringBuilder.append((CharSequence) group);
            spannableStringBuilder.setSpan(new StyleSpan(0), length, length2, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i, true), length, length2, 33);
            i3 = matcher.end();
        }
        if (i2 < charSequence.length()) {
            spannableStringBuilder.append(charSequence.subSequence(i2, charSequence.length()));
        }
        return spannableStringBuilder;
    }

    private final void a(int i) {
        d().e.setText(AppInfo.d().getString(R.string.live_random_gift_float_lottery_btn, Integer.valueOf(i)));
        ShapeTextView shapeTextView = d().e;
        CharSequence text = d().e.getText();
        Intrinsics.c(text, "vb.tvDrawLottery.text");
        shapeTextView.setText(a(text, 13));
        if (i <= 0) {
            a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRandomGiftDialog this$0, int i, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_LOTTERY_FAST_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        if (this$0.h) {
            this$0.d().c.smoothScrollToPosition(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRandomGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRandomGiftDialog this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        if (num == null) {
            return;
        }
        this$0.b(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015c, code lost:
        if (r0.length() == 0) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.blued.android.module.live_china.model.RandomGiftDialogDataModel r7) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveRandomGiftDialog.a(com.blued.android.module.live_china.model.RandomGiftDialogDataModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(RandomGiftHostDialogDataModel randomGiftHostDialogDataModel) {
        this.i = randomGiftHostDialogDataModel;
        ArrayList<FreedomItem> arrayList = this.d;
        if (arrayList == null) {
            Intrinsics.a(arrayList, new ArrayList());
        } else {
            arrayList.clear();
        }
        ArrayList<RandomGiftItemModel> rewards = randomGiftHostDialogDataModel.getRewards();
        if (rewards != null && !rewards.isEmpty()) {
            this.d.add(new FitemRandomGiftHostDrawLottery(rewards));
        }
        this.d.add(new FitemRandomGiftHostLottery(randomGiftHostDialogDataModel));
        String alert_url = randomGiftHostDialogDataModel.getAlert_url();
        if (alert_url == null || alert_url.length() == 0) {
            ImageView imageView = d().a;
            Intrinsics.c(imageView, "vb.ivInfo");
            BluedViewExKt.a(imageView);
        } else {
            ImageView imageView2 = d().a;
            Intrinsics.c(imageView2, "vb.ivInfo");
            BluedViewExKt.b(imageView2);
            d().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftDialog$J5Sb5MNEpPBwOqgZ4Xz7dpVbUSc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveRandomGiftDialog.c(LiveRandomGiftDialog.this, view);
                }
            });
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        if (this.h == z || d().b.getVisibility() == 8) {
            return;
        }
        RandomGiftDialogDataModel randomGiftDialogDataModel = this.g;
        RandomGiftDialogDataModel randomGiftDialogDataModel2 = randomGiftDialogDataModel;
        if (randomGiftDialogDataModel == null) {
            Intrinsics.c("mDataPlaying");
            randomGiftDialogDataModel2 = null;
        }
        RandomGiftDialogRewardModel reward = randomGiftDialogDataModel2.getReward();
        Intrinsics.a(reward);
        if (reward.getRemain_count() == 0) {
            z = false;
        }
        if (z) {
            EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_LOTTERY_FAST_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        this.h = z;
        float width = z ? 0.0f : d().b.getWidth() * 1.1f;
        if (z) {
            d().b.animate().setInterpolator(new OvershootInterpolator());
        } else {
            d().b.animate().setInterpolator(new AnticipateInterpolator());
        }
        d().b.animate().translationX(width).setDuration(450L).start();
    }

    private final void b(int i) {
        a(i);
        for (FreedomItem freedomItem : this.d) {
            if (freedomItem instanceof FitemRandomGiftDrawLottery) {
                ((FitemRandomGiftDrawLottery) freedomItem).b(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveRandomGiftDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveRandomGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRandomGiftInfoDialog.Companion companion = LiveRandomGiftInfoDialog.a;
        RandomGiftDialogDataModel randomGiftDialogDataModel = this$0.g;
        RandomGiftDialogDataModel randomGiftDialogDataModel2 = randomGiftDialogDataModel;
        if (randomGiftDialogDataModel == null) {
            Intrinsics.c("mDataPlaying");
            randomGiftDialogDataModel2 = null;
        }
        String alert_url = randomGiftDialogDataModel2.getAlert_url();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(alert_url, childFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveRandomGiftDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRandomGiftInfoDialog.Companion companion = LiveRandomGiftInfoDialog.a;
        RandomGiftHostDialogDataModel randomGiftHostDialogDataModel = this$0.i;
        RandomGiftHostDialogDataModel randomGiftHostDialogDataModel2 = randomGiftHostDialogDataModel;
        if (randomGiftHostDialogDataModel == null) {
            Intrinsics.c("mDataHost");
            randomGiftHostDialogDataModel2 = null;
        }
        String alert_url = randomGiftHostDialogDataModel2.getAlert_url();
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(alert_url, childFragmentManager);
    }

    private final DialogLiveRandomGiftBinding d() {
        return (DialogLiveRandomGiftBinding) this.b.getValue();
    }

    private final void e() {
        FreedomAdapter freedomAdapter = this.e;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.e = new FreedomAdapter(getContext(), a(), this.d);
        this.f = new LinearLayoutManager(getContext());
        DialogLiveRandomGiftBinding d = d();
        RecyclerView recyclerView = d == null ? null : d.c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(this.f);
        }
        DialogLiveRandomGiftBinding d2 = d();
        RecyclerView recyclerView2 = d2 == null ? null : d2.c;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        FreedomAdapter freedomAdapter2 = this.e;
        if (freedomAdapter2 != null) {
            freedomAdapter2.b("FragmentManager", getChildFragmentManager());
        }
        DialogLiveRandomGiftBinding d3 = d();
        RecyclerView recyclerView3 = d3 == null ? null : d3.c;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.e);
    }

    private final void f() {
        String str = this.c;
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.r(str, new BluedUIHttpResponse<BluedEntityA<RandomGiftDialogDataModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftDialog$getDataToPlaying$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RandomGiftDialogDataModel> entity) {
                Intrinsics.e(entity, "entity");
                RandomGiftDialogDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveRandomGiftDialog.this.a(singleData);
            }
        }, a());
    }

    private final int g() {
        RandomGiftDialogDataModel randomGiftDialogDataModel = this.g;
        RandomGiftDialogDataModel randomGiftDialogDataModel2 = randomGiftDialogDataModel;
        if (randomGiftDialogDataModel == null) {
            Intrinsics.c("mDataPlaying");
            randomGiftDialogDataModel2 = null;
        }
        if (randomGiftDialogDataModel2.getReward() != null) {
            RandomGiftDialogDataModel randomGiftDialogDataModel3 = this.g;
            RandomGiftDialogDataModel randomGiftDialogDataModel4 = randomGiftDialogDataModel3;
            if (randomGiftDialogDataModel3 == null) {
                Intrinsics.c("mDataPlaying");
                randomGiftDialogDataModel4 = null;
            }
            RandomGiftDialogRewardModel reward = randomGiftDialogDataModel4.getReward();
            Integer valueOf = reward == null ? null : Integer.valueOf(reward.getRemain_count());
            Intrinsics.a(valueOf);
            if (valueOf.intValue() <= 0) {
                return -1;
            }
            int i = 0;
            FreedomItem freedomItem = null;
            int i2 = -1;
            for (FreedomItem freedomItem2 : this.d) {
                if (freedomItem2 instanceof FitemRandomGiftDrawLottery) {
                    i2 = i;
                    freedomItem = freedomItem2;
                }
                i++;
            }
            if (freedomItem == null) {
                return -1;
            }
            RandomGiftDialogDataModel randomGiftDialogDataModel5 = this.g;
            if (randomGiftDialogDataModel5 == null) {
                Intrinsics.c("mDataPlaying");
                randomGiftDialogDataModel5 = null;
            }
            RandomGiftDialogRewardModel reward2 = randomGiftDialogDataModel5.getReward();
            Intrinsics.a(reward2);
            a(reward2.getRemain_count());
            if (d().b.getVisibility() == 8) {
                d().b.setAlpha(0.0f);
                RelativeLayout relativeLayout = d().b;
                Intrinsics.c(relativeLayout, "vb.rlDrawLotteryFloat");
                BluedViewExKt.b(relativeLayout);
                d().b.setTranslationX(d().b.getWidth() * 1.1f);
                d().b.setAlpha(1.0f);
                d().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftDialog$DAkMTLVAC7T_V1U7A5ECJQC7_Jg
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveRandomGiftDialog.b(LiveRandomGiftDialog.this);
                    }
                });
            }
            return i2;
        }
        return -1;
    }

    private final void h() {
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.D(new BluedUIHttpResponse<BluedEntityA<RandomGiftHostDialogDataModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveRandomGiftDialog$getDataToHost$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<RandomGiftHostDialogDataModel> entity) {
                Intrinsics.e(entity, "entity");
                RandomGiftHostDialogDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveRandomGiftDialog.this.a(singleData);
            }
        }, a());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 626.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
            EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_RANDOM_GIFT_PAGE_SHOW, LiveRoomManager.a().e());
            return dialog;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_USER_RANDOM_GIFT_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        return dialog;
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(d().getRoot());
        Window window = dialog.getWindow();
        boolean z = false;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("goods_id", "");
            Intrinsics.c(string, "it.getString(\"goods_id\", \"\")");
            this.c = string;
        }
        d().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftDialog$vk2YAjza4JZQbBpfAvQsoHAmJ2o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRandomGiftDialog.a(LiveRandomGiftDialog.this, view);
            }
        });
        String str = this.c;
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (z) {
            h();
            return;
        }
        LiveEventBus.get(LiveEventBusUtil.Q, Integer.TYPE).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftDialog$OeYzeWIAAMzwno99TbGaNUbd-i0
            public final void onChanged(Object obj) {
                LiveRandomGiftDialog.a(LiveRandomGiftDialog.this, (Integer) obj);
            }
        });
        f();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
