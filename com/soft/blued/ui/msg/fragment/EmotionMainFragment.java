package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.fragment.BaseViewPagerParentFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.model.EmotionListItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionMainFragment.class */
public class EmotionMainFragment extends BaseViewPagerParentFragment {

    /* renamed from: a  reason: collision with root package name */
    private CommonTopTitleNoTrans f32350a;
    private CardView b;

    /* renamed from: c  reason: collision with root package name */
    private CardView f32351c;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private List<EmotionListItemModel> g = new ArrayList();

    public static void a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", i);
        TerminalActivity.d(context, EmotionMainFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        this.h.setCurrentItem(1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d == 0) {
            this.b.setCardBackgroundColor(BluedSkinUtils.a(getActivity(), 2131102361));
            this.f32351c.setCardBackgroundColor(0);
            return;
        }
        this.b.setCardBackgroundColor(0);
        this.f32351c.setCardBackgroundColor(BluedSkinUtils.a(getActivity(), 2131102361));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        this.h.setCurrentItem(0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void a() {
        this.j.add(new EmotionMallListFragment());
        this.j.add(new EmotionMineListFragment());
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public BaseFragment b(int i) {
        return i == 1 ? new EmotionMineListFragment() : new EmotionMallListFragment();
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(R.id.emotion_mall_title);
        this.f32350a = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionMainFragment$QFVO20coHA_2Tp8b4O_PX3OiyJo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionMainFragment.this.c(view);
            }
        });
        this.b = (CardView) this.rootView.findViewById(R.id.emotion_mall_tab_mall);
        this.f32351c = (CardView) this.rootView.findViewById(2131363348);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionMainFragment$Em7Q1eJlPykhBWCu916mjS0hnKo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionMainFragment.this.b(view);
            }
        });
        this.f32351c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionMainFragment$HiAfed4tkIkFo0oIFpgLX7tjh0M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmotionMainFragment.this.a(view);
            }
        });
        this.h.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.msg.fragment.EmotionMainFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                EmotionMainFragment.this.d = i;
                EmotionMainFragment.this.b();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }
        });
        b();
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitViewFinished() {
        super.onInitViewFinished();
        this.h.setCurrentItem(this.d, false);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        super.onLoadData();
        EmotionDataManager.a().d();
        showLoading();
        ChatHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<EmotionListItemModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.EmotionMainFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmotionListItemModel> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    for (EmotionListItemModel emotionListItemModel : bluedEntityA.data) {
                        if (EmotionDataManager.a().a(emotionListItemModel.code)) {
                            emotionListItemModel.downloadState = 3;
                        } else {
                            emotionListItemModel.downloadState = 1;
                        }
                    }
                    if (EmotionMainFragment.this.f) {
                        for (EmotionListItemModel emotionListItemModel2 : EmotionDataManager.a().c()) {
                            Iterator<EmotionListItemModel> it = bluedEntityA.data.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    EmotionListItemModel next = it.next();
                                    if (StringUtils.a(next.code, emotionListItemModel2.code)) {
                                        emotionListItemModel2.downloadState = next.downloadState;
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        EmotionMainFragment.this.g.clear();
                        EmotionMainFragment.this.g.addAll(bluedEntityA.data);
                    }
                }
                EmotionMainFragment.this.e = true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                EmotionMainFragment.this.e = true;
                if (EmotionMainFragment.this.f) {
                    EmotionMainFragment.this.hideLoading();
                    LiveEventBus.get("EMOTION_RELOAD_DATA").post(true);
                }
            }
        });
        ChatHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<EmotionListItemModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.EmotionMainFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmotionListItemModel> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.data != null) {
                    if (EmotionMainFragment.this.e) {
                        for (EmotionListItemModel emotionListItemModel : bluedEntityA.data) {
                            Iterator it = EmotionMainFragment.this.g.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    EmotionListItemModel emotionListItemModel2 = (EmotionListItemModel) it.next();
                                    if (StringUtils.a(emotionListItemModel2.code, emotionListItemModel.code)) {
                                        emotionListItemModel.downloadState = emotionListItemModel2.downloadState;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    EmotionDataManager.a().a(bluedEntityA.data);
                }
                EmotionMainFragment.this.f = true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                EmotionMainFragment.this.f = true;
                if (EmotionMainFragment.this.e) {
                    EmotionMainFragment.this.hideLoading();
                    LiveEventBus.get("EMOTION_RELOAD_DATA").post(true);
                }
            }
        });
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        this.d = this.args.getInt("index");
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_emotion_main;
    }
}
