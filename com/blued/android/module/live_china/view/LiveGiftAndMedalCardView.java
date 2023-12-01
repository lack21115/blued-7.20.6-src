package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LayoutLiveUserCardAwardWallBinding;
import com.blued.android.module.live_china.model.LiveUserCardGalleryItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftAndMedalCardView.class */
public final class LiveGiftAndMedalCardView extends FrameLayout {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private ArrayList<String> f;
    private ArrayList<String> g;
    private CardArrowClickListener h;
    private final Lazy i;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveGiftAndMedalCardView$CardArrowClickListener.class */
    public interface CardArrowClickListener {
        void a();

        void b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftAndMedalCardView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveGiftAndMedalCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftAndMedalCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.i = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LayoutLiveUserCardAwardWallBinding>() { // from class: com.blued.android.module.live_china.view.LiveGiftAndMedalCardView$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutLiveUserCardAwardWallBinding invoke() {
                return LayoutLiveUserCardAwardWallBinding.a(LayoutInflater.from(LiveGiftAndMedalCardView.this.getMContext()), LiveGiftAndMedalCardView.this, true);
            }
        });
        this.a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftAndMedalCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CardArrowClickListener cardArrowClickListener = this$0.h;
        if (cardArrowClickListener == null) {
            return;
        }
        cardArrowClickListener.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGiftAndMedalCardView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        CardArrowClickListener cardArrowClickListener = this$0.h;
        if (cardArrowClickListener == null) {
            return;
        }
        cardArrowClickListener.b();
    }

    public final void a() {
        LayoutLiveUserCardAwardWallBinding viewBinding = getViewBinding();
        viewBinding.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftAndMedalCardView$lEhJTEpQ--uUdJ8jcBDkekDnVSY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftAndMedalCardView.a(LiveGiftAndMedalCardView.this, view);
            }
        });
        viewBinding.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveGiftAndMedalCardView$O5DefFpdIXUW99XQgBXMyAG6-Kk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGiftAndMedalCardView.b(LiveGiftAndMedalCardView.this, view);
            }
        });
    }

    public final void a(IRequestHost requestHost, String str, String str2, String str3, String str4, ArrayList<LiveUserCardGalleryItemModel> arrayList, ArrayList<LiveUserCardGalleryItemModel> arrayList2, boolean z, boolean z2, CardArrowClickListener onCardArrowClick) {
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(onCardArrowClick, "onCardArrowClick");
        this.b = str;
        this.c = str2;
        this.e = str3;
        this.d = str4;
        this.h = onCardArrowClick;
        LayoutLiveUserCardAwardWallBinding viewBinding = getViewBinding();
        if (z2) {
            RelativeLayout relativeLayout = viewBinding.m;
            Intrinsics.c(relativeLayout, "it.rvMedalContent");
            BluedViewExKt.b(relativeLayout);
        } else {
            RelativeLayout relativeLayout2 = viewBinding.m;
            Intrinsics.c(relativeLayout2, "it.rvMedalContent");
            BluedViewExKt.a(relativeLayout2);
        }
        if (z) {
            RelativeLayout relativeLayout3 = viewBinding.l;
            Intrinsics.c(relativeLayout3, "it.rvGiftContent");
            BluedViewExKt.b(relativeLayout3);
        } else {
            RelativeLayout relativeLayout4 = viewBinding.l;
            Intrinsics.c(relativeLayout4, "it.rvGiftContent");
            BluedViewExKt.a(relativeLayout4);
        }
        if (z2 && z) {
            View view = viewBinding.r;
            Intrinsics.c(view, "it.viewDividingLine");
            BluedViewExKt.b(view);
        } else {
            View view2 = viewBinding.r;
            Intrinsics.c(view2, "it.viewDividingLine");
            BluedViewExKt.a(view2);
        }
        viewBinding.o.setText(str);
        viewBinding.q.setText(str2);
        viewBinding.n.setText(str3);
        viewBinding.p.setText(str4);
        ArrayList<LiveUserCardGalleryItemModel> arrayList3 = arrayList;
        if (!(arrayList3 == null || arrayList3.isEmpty())) {
            Iterator<LiveUserCardGalleryItemModel> it = arrayList.iterator();
            int i = 0;
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                LiveUserCardGalleryItemModel next = it.next();
                if (i2 == 0) {
                    ImageView imageView = viewBinding.a;
                    Intrinsics.c(imageView, "it.ivGift0");
                    BluedViewExKt.b(imageView);
                    String icon = next.getIcon();
                    if (icon != null) {
                        ImageLoader.a(requestHost, icon).g().g(-1).b(R.drawable.anchor_badge_default).a(viewBinding.a);
                        String mask = next.getMask();
                        if (!(mask == null || mask.length() == 0)) {
                            ImageView imageView2 = viewBinding.i;
                            Intrinsics.c(imageView2, "it.ivTag0");
                            BluedViewExKt.b(imageView2);
                            String mask2 = next.getMask();
                            Intrinsics.a((Object) mask2);
                            ImageLoader.a(requestHost, mask2).g().g(-1).a(viewBinding.i);
                        }
                    }
                } else if (i2 == 1) {
                    ImageView imageView3 = viewBinding.b;
                    Intrinsics.c(imageView3, "it.ivGift1");
                    BluedViewExKt.b(imageView3);
                    String icon2 = next.getIcon();
                    if (icon2 != null) {
                        ImageLoader.a(requestHost, icon2).g().g(-1).b(R.drawable.anchor_badge_default).a(viewBinding.b);
                        String mask3 = next.getMask();
                        if (!(mask3 == null || mask3.length() == 0)) {
                            ImageView imageView4 = viewBinding.j;
                            Intrinsics.c(imageView4, "it.ivTag1");
                            BluedViewExKt.b(imageView4);
                            String mask4 = next.getMask();
                            Intrinsics.a((Object) mask4);
                            ImageLoader.a(requestHost, mask4).g().g(-1).a(viewBinding.j);
                        }
                    }
                } else if (i2 == 2) {
                    ImageView imageView5 = viewBinding.c;
                    Intrinsics.c(imageView5, "it.ivGift2");
                    BluedViewExKt.b(imageView5);
                    String icon3 = next.getIcon();
                    if (icon3 != null) {
                        ImageLoader.a(requestHost, icon3).g().g(-1).b(R.drawable.anchor_badge_default).a(viewBinding.c);
                        String mask5 = next.getMask();
                        if (!(mask5 == null || mask5.length() == 0)) {
                            ImageView imageView6 = viewBinding.k;
                            Intrinsics.c(imageView6, "it.ivTag2");
                            BluedViewExKt.b(imageView6);
                            String mask6 = next.getMask();
                            Intrinsics.a((Object) mask6);
                            ImageLoader.a(requestHost, mask6).g().g(-1).a(viewBinding.k);
                        }
                    }
                }
                i = i2 + 1;
            }
        }
        ArrayList<LiveUserCardGalleryItemModel> arrayList4 = arrayList2;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            return;
        }
        Iterator<LiveUserCardGalleryItemModel> it2 = arrayList2.iterator();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (!it2.hasNext()) {
                return;
            }
            LiveUserCardGalleryItemModel next2 = it2.next();
            if (i4 == 0) {
                ImageView imageView7 = viewBinding.e;
                Intrinsics.c(imageView7, "it.ivMedal0");
                BluedViewExKt.b(imageView7);
                String icon4 = next2.getIcon();
                if (icon4 != null) {
                    ImageLoader.a(requestHost, icon4).g().g(-1).b(R.drawable.anchor_badge_default).a(viewBinding.e);
                }
            } else if (i4 == 1) {
                ImageView imageView8 = viewBinding.f;
                Intrinsics.c(imageView8, "it.ivMedal1");
                BluedViewExKt.b(imageView8);
                String icon5 = next2.getIcon();
                if (icon5 != null) {
                    ImageLoader.a(requestHost, icon5).g().g(-1).b(R.drawable.anchor_badge_default).a(viewBinding.f);
                }
            } else if (i4 == 2) {
                ImageView imageView9 = viewBinding.g;
                Intrinsics.c(imageView9, "it.ivMedal2");
                BluedViewExKt.b(imageView9);
                String icon6 = next2.getIcon();
                if (icon6 != null) {
                    ImageLoader.a(requestHost, icon6).g().g(-1).b(R.drawable.anchor_badge_default).a(viewBinding.g);
                }
            }
            i3 = i4 + 1;
        }
    }

    public final CardArrowClickListener getCardArrowClickListener() {
        return this.h;
    }

    public final String getGiftCountDesc() {
        return this.e;
    }

    public final ArrayList<String> getGiftList() {
        return this.f;
    }

    public final String getGiftTilte() {
        return this.b;
    }

    public final Context getMContext() {
        return this.a;
    }

    public final String getMedalCountDesc() {
        return this.d;
    }

    public final ArrayList<String> getMedalList() {
        return this.g;
    }

    public final String getMedalTilte() {
        return this.c;
    }

    public final LayoutLiveUserCardAwardWallBinding getViewBinding() {
        return (LayoutLiveUserCardAwardWallBinding) this.i.getValue();
    }

    public final void setCardArrowClickListener(CardArrowClickListener cardArrowClickListener) {
        this.h = cardArrowClickListener;
    }

    public final void setGiftCountDesc(String str) {
        this.e = str;
    }

    public final void setGiftList(ArrayList<String> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.f = arrayList;
    }

    public final void setGiftTilte(String str) {
        this.b = str;
    }

    public final void setMContext(Context context) {
        this.a = context;
    }

    public final void setMedalCountDesc(String str) {
        this.d = str;
    }

    public final void setMedalList(ArrayList<String> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.g = arrayList;
    }

    public final void setMedalTilte(String str) {
        this.c = str;
    }
}
