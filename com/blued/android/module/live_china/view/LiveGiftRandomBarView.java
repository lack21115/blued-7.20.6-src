package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveRandomGiftBarViewBinding;
import com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftBar;
import com.blued.android.module.live_china.fragment.LiveRandomGiftDialog;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.model.LiveGiftRandomBarItemModel;
import com.blued.android.module.live_china.model.LiveGiftRandomBarModel;
import java.util.ArrayList;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftRandomBarView.class */
public final class LiveGiftRandomBarView extends RelativeLayout implements OnClickCallback {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14476a;
    private PlayingOnliveFragment b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f14477c;
    private LiveGiftRandomBarModel d;
    private String e;
    private final Lazy f;
    private final ArrayList<FitemRandomGiftBar> g;
    private FreedomAdapter h;
    private final String i;
    private Pattern j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftRandomBarView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftRandomBarView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftRandomBarView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.f14476a = mContext;
        this.e = "";
        this.f = LazyKt.a(new Function0<LiveRandomGiftBarViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveGiftRandomBarView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveRandomGiftBarViewBinding invoke() {
                LiveRandomGiftBarViewBinding a2 = LiveRandomGiftBarViewBinding.a(LayoutInflater.from(LiveGiftRandomBarView.this.getMContext()).inflate(R.layout.live_random_gift_bar_view, LiveGiftRandomBarView.this));
                Intrinsics.c(a2, "bind(\n            Layout…bar_view, this)\n        )");
                return a2;
            }
        });
        this.g = new ArrayList<>();
        this.i = "@\\(word:([\\s\\S]*?)\\)";
        this.j = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");
    }

    public /* synthetic */ LiveGiftRandomBarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final CharSequence a(CharSequence charSequence, String str, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private final void a() {
        FreedomAdapter freedomAdapter = this.h;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        getVb().f12391c.setLayoutManager(linearLayoutManager);
        Context context = getContext();
        IRequestHost iRequestHost = this.f14477c;
        IRequestHost iRequestHost2 = iRequestHost;
        if (iRequestHost == null) {
            Intrinsics.c("mRequestHost");
            iRequestHost2 = null;
        }
        this.h = new FreedomAdapter(context, iRequestHost2, this.g, this);
        getVb().f12391c.setItemAnimator(new DefaultItemAnimator());
        getVb().f12391c.setAdapter(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(String goodId, LiveGiftRandomBarView this$0, View view) {
        Intrinsics.e(goodId, "$goodId");
        Intrinsics.e(this$0, "this$0");
        LiveRandomGiftDialog.Companion companion = LiveRandomGiftDialog.f13167a;
        PlayingOnliveFragment playingOnliveFragment = this$0.b;
        PlayingOnliveFragment playingOnliveFragment2 = playingOnliveFragment;
        if (playingOnliveFragment == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment2 = null;
        }
        companion.a(goodId, playingOnliveFragment2);
        PlayingOnliveFragment playingOnliveFragment3 = this$0.b;
        if (playingOnliveFragment3 == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment3 = null;
        }
        playingOnliveFragment3.aJ();
    }

    private final LiveRandomGiftBarViewBinding getVb() {
        return (LiveRandomGiftBarViewBinding) this.f.getValue();
    }

    public final void a(PlayingOnliveFragment fragment, final String goodId, LiveGiftRandomBarModel data) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(goodId, "goodId");
        Intrinsics.e(data, "data");
        this.b = fragment;
        ActivityFragmentActive fragmentActive = fragment.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragment.fragmentActive");
        this.f14477c = fragmentActive;
        this.d = data;
        this.e = goodId;
        ImageLoader.a((IRequestHost) null, data.getFront_img()).a(getVb().b);
        ImageLoader.a((IRequestHost) null, data.getImg()).a(getVb().f12390a);
        if (data.getRemain_reward_count() > 0) {
            ShapeTextView shapeTextView = getVb().e;
            Intrinsics.c(shapeTextView, "vb.tvRandomGiftBtnLottery");
            BluedViewExKt.b(shapeTextView);
        } else {
            ShapeTextView shapeTextView2 = getVb().e;
            Intrinsics.c(shapeTextView2, "vb.tvRandomGiftBtnLottery");
            BluedViewExKt.a(shapeTextView2);
        }
        boolean z = false;
        if (data.getLight_times() > 0) {
            ShapeTextView shapeTextView3 = getVb().d;
            Intrinsics.c(shapeTextView3, "vb.tvRandomGiftBtnLighten");
            BluedViewExKt.b(shapeTextView3);
            getVb().d.setText(AppInfo.d().getString(R.string.live_random_gift_bar_lighten, Integer.valueOf(data.getLight_times())));
            ShapeTextView shapeTextView4 = getVb().d;
            CharSequence text = getVb().d.getText();
            Intrinsics.c(text, "vb.tvRandomGiftBtnLighten.text");
            shapeTextView4.setText(a(text, "#FFCD57", true));
        } else {
            ShapeTextView shapeTextView5 = getVb().d;
            Intrinsics.c(shapeTextView5, "vb.tvRandomGiftBtnLighten");
            BluedViewExKt.a(shapeTextView5);
        }
        ArrayList<LiveGiftRandomBarItemModel> goods = data.getGoods();
        if ((goods == null || goods.isEmpty()) ? true : true) {
            RecyclerView recyclerView = getVb().f12391c;
            Intrinsics.c(recyclerView, "vb.rvList");
            BluedViewExKt.a(recyclerView);
        } else {
            this.g.clear();
            ArrayList<LiveGiftRandomBarItemModel> goods2 = data.getGoods();
            if (goods2 != null) {
                for (LiveGiftRandomBarItemModel liveGiftRandomBarItemModel : goods2) {
                    this.g.add(new FitemRandomGiftBar(liveGiftRandomBarItemModel));
                }
            }
            a();
        }
        getVb().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftRandomBarView$3FMHvgPiM5FKH9fQO1_mSOBuZkU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftRandomBarView.a(String.this, this, view);
            }
        });
    }

    public final String getGoodId() {
        return this.e;
    }

    public final Context getMContext() {
        return this.f14476a;
    }

    public final Pattern getPattern() {
        return this.j;
    }

    public final String getWORD_PATTERN() {
        return this.i;
    }

    @Override // com.blued.android.module.common.utils.freedom.clickcallback.OnClickCallback
    public void onClick(View view, int i, BaseViewHolder baseViewHolder) {
        LiveRandomGiftDialog.Companion companion = LiveRandomGiftDialog.f13167a;
        String str = this.e;
        PlayingOnliveFragment playingOnliveFragment = this.b;
        PlayingOnliveFragment playingOnliveFragment2 = playingOnliveFragment;
        if (playingOnliveFragment == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment2 = null;
        }
        companion.a(str, playingOnliveFragment2);
        PlayingOnliveFragment playingOnliveFragment3 = this.b;
        if (playingOnliveFragment3 == null) {
            Intrinsics.c("mFragment");
            playingOnliveFragment3 = null;
        }
        playingOnliveFragment3.aJ();
    }

    public final void setPattern(Pattern pattern) {
        this.j = pattern;
    }
}
