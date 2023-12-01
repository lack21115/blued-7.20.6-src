package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.android.module.live_china.databinding.FragmentLiveGiftSetViewBinding;
import com.blued.android.module.live_china.fragment.LiveGiftSetDialogFragment;
import com.blued.android.module.live_china.model.LiveGiftSetModel;
import com.blued.android.module.live_china.model.LiveGiftSetTabModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetDialogFragment$getAll$1.class */
public final class LiveGiftSetDialogFragment$getAll$1 extends BluedUIHttpResponse<BluedEntityA<LiveGiftSetModel>> {
    final /* synthetic */ LiveGiftSetDialogFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetDialogFragment$getAll$1(LiveGiftSetDialogFragment liveGiftSetDialogFragment, ActivityFragmentActive activityFragmentActive) {
        super(activityFragmentActive);
        this.a = liveGiftSetDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetDialogFragment this$0, Ref.IntRef position) {
        FragmentLiveGiftSetViewBinding g;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(position, "$position");
        g = this$0.g();
        g.h.setCurrentItem(position.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef model, LiveGiftSetDialogFragment this$0, View view) {
        FragmentLiveGiftSetViewBinding g;
        Intrinsics.e(model, "$model");
        Intrinsics.e(this$0, "this$0");
        if (TextUtils.isEmpty(((LiveGiftSetModel) model.a).getLink())) {
            return;
        }
        LiveHalfWebDialogFragment liveHalfWebDialogFragment = new LiveHalfWebDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", ((LiveGiftSetModel) model.a).getLink());
        g = this$0.g();
        bundle.putInt("height", g.h.getHeight());
        bundle.putBoolean("fullScreen", false);
        liveHalfWebDialogFragment.setArguments(bundle);
        liveHalfWebDialogFragment.show(this$0.getChildFragmentManager(), "showLiveHalfWebDialog");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<LiveGiftSetModel> bluedEntity) {
        FragmentLiveGiftSetViewBinding g;
        FragmentLiveGiftSetViewBinding g2;
        FragmentLiveGiftSetViewBinding g3;
        FragmentLiveGiftSetViewBinding g4;
        FragmentLiveGiftSetViewBinding g5;
        FragmentLiveGiftSetViewBinding g6;
        FragmentLiveGiftSetViewBinding g7;
        FragmentLiveGiftSetViewBinding g8;
        FragmentLiveGiftSetViewBinding g9;
        FragmentLiveGiftSetViewBinding g10;
        FragmentLiveGiftSetViewBinding g11;
        FragmentLiveGiftSetViewBinding g12;
        Intrinsics.e(bluedEntity, "bluedEntity");
        if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = bluedEntity.data.get(0);
        if (objectRef.a != 0) {
            ((LiveGiftSetModel) objectRef.a).setId(StringUtils.a(this.a.d(), 0));
            LiveGiftSetDialogFragment liveGiftSetDialogFragment = this.a;
            T model = objectRef.a;
            Intrinsics.c(model, "model");
            liveGiftSetDialogFragment.a((LiveGiftSetModel) model);
            T t = objectRef.a;
            Intrinsics.a(t);
            ArrayList<LiveGiftSetTabModel> all_name = ((LiveGiftSetModel) t).getAll_name();
            if (all_name != null) {
                final LiveGiftSetDialogFragment liveGiftSetDialogFragment2 = this.a;
                final Ref.IntRef intRef = new Ref.IntRef();
                Iterator<LiveGiftSetTabModel> it = all_name.iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    LiveGiftSetTabModel next = it.next();
                    if (next != null && TextUtils.equals(next.getId(), liveGiftSetDialogFragment2.d())) {
                        intRef.a = i2;
                        break;
                    }
                    i = i2 + 1;
                }
                if (intRef.a >= 0) {
                    g12 = liveGiftSetDialogFragment2.g();
                    g12.h.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftSetDialogFragment$getAll$1$hI25yhMJklv_QTtl--9u2r39weE
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveGiftSetDialogFragment$getAll$1.a(LiveGiftSetDialogFragment.this, intRef);
                        }
                    });
                }
                Context context = liveGiftSetDialogFragment2.getContext();
                FragmentManager childFragmentManager = liveGiftSetDialogFragment2.getChildFragmentManager();
                Intrinsics.c(childFragmentManager, "childFragmentManager");
                PagerAdapter myAdapter = new LiveGiftSetDialogFragment.MyAdapter(context, childFragmentManager);
                T t2 = objectRef.a;
                Intrinsics.a(t2);
                ArrayList<LiveGiftSetTabModel> all_name2 = ((LiveGiftSetModel) t2).getAll_name();
                T model2 = objectRef.a;
                Intrinsics.c(model2, "model");
                myAdapter.a(all_name2, (LiveGiftSetModel) model2, intRef.a);
                g2 = liveGiftSetDialogFragment2.g();
                ViewPager viewPager = g2.h;
                T t3 = objectRef.a;
                Intrinsics.a(t3);
                ArrayList<LiveGiftSetTabModel> all_name3 = ((LiveGiftSetModel) t3).getAll_name();
                Intrinsics.a(all_name3);
                viewPager.setOffscreenPageLimit(all_name3.size());
                g3 = liveGiftSetDialogFragment2.g();
                g3.h.setAdapter(myAdapter);
                if (bluedEntity.data.size() >= 4) {
                    g8 = liveGiftSetDialogFragment2.g();
                    g8.f.setVisibility(8);
                    g9 = liveGiftSetDialogFragment2.g();
                    g9.g.setVisibility(0);
                    g10 = liveGiftSetDialogFragment2.g();
                    PageTabLayout pageTabLayout = g10.g;
                    g11 = liveGiftSetDialogFragment2.g();
                    pageTabLayout.setupWithViewPager(g11.h);
                } else {
                    g4 = liveGiftSetDialogFragment2.g();
                    g4.f.setVisibility(0);
                    g5 = liveGiftSetDialogFragment2.g();
                    g5.g.setVisibility(8);
                    g6 = liveGiftSetDialogFragment2.g();
                    PageTabLayout pageTabLayout2 = g6.f;
                    g7 = liveGiftSetDialogFragment2.g();
                    pageTabLayout2.setupWithViewPager(g7.h);
                }
            }
            g = this.a.g();
            ImageView imageView = g.e;
            final LiveGiftSetDialogFragment liveGiftSetDialogFragment3 = this.a;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftSetDialogFragment$getAll$1$ZYwS3EGJqyVh3R34TFk0uVT08_4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftSetDialogFragment$getAll$1.a(Ref.ObjectRef.this, liveGiftSetDialogFragment3, view);
                }
            });
        }
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIFinish() {
        super.onUIFinish();
    }

    @Override // com.blued.android.framework.http.BluedUIHttpResponse
    public void onUIStart() {
        super.onUIStart();
    }
}
