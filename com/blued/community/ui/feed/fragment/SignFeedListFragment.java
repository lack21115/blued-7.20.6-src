package com.blued.community.ui.feed.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ims.ImsReasonInfo;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedBubbleSignModel;
import com.blued.community.model.FeedBubbleSignTextModel;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedBubbleListGuideExtra;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.blued.community.ui.send.fragment.FeedPostSignStateFragment;
import com.blued.community.ui.send.viewmodel.SignFeedListViewModel;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.view.CommonFloatBottomView;
import com.blued.community.widget.FeedGuidePop;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment.class */
public final class SignFeedListFragment extends BaseListFragment<SignFeedListViewModel, BluedIngSelfFeed> {
    public static final Companion b = new Companion(null);
    private int A;
    private boolean B;
    private boolean C;
    private FeedBubbleSignModel D;
    private CoroutineScope E;
    private boolean F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private CommonFloatBottomView c;
    private View d;
    private ImageView e;
    private ImageView f;
    private View g;
    private View h;
    private View i;
    private View j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private TextView p;
    private TextView q;
    private View r;
    private TextView s;
    private View t;
    private TextView u;
    private ImageView v;
    private TextView w;
    private View x;
    private final ValueAnimator y;
    private FeedGuidePop z;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignFeedListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String str, int i) {
            Intrinsics.e(context, "context");
            a(context, str, i, null);
        }

        public final void a(Context context, String str, int i, BluedIngSelfFeed bluedIngSelfFeed) {
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString("feed_ids", str);
                bundle.putString("bubble_state", bluedIngSelfFeed == null ? null : bluedIngSelfFeed.bubble_state);
            }
            bundle.putInt("from", i);
            TerminalActivity.d(context, SignFeedListFragment.class, bundle);
            boolean z = true;
            FeedProtos.SourcePage sourcePage = i != 1 ? i != 2 ? i != 4 ? i != 5 ? i != 6 ? i != 7 ? i != 9 ? FeedProtos.SourcePage.FEED_PLAZA_NEARBY : FeedProtos.SourcePage.GUIDE_PUNCH : FeedProtos.SourcePage.FEED_CITY_TIME : FeedProtos.SourcePage.FEED_PLAZA_FOLLOW : FeedProtos.SourcePage.ACTIVE_USER_PUSH : FeedProtos.SourcePage.NEW_USER_PUSH : FeedProtos.SourcePage.FEED_PERSONAL_FEED : FeedProtos.SourcePage.CITY_PUNCH_FEED_ENTER;
            String str7 = "";
            if (bluedIngSelfFeed == null) {
                str6 = "";
                str4 = str6;
                z = false;
                str5 = str6;
            } else {
                if (TextUtils.isEmpty(bluedIngSelfFeed.feed_id)) {
                    str2 = "";
                } else {
                    str2 = bluedIngSelfFeed.feed_id;
                    Intrinsics.c(str2, "it.feed_id");
                }
                if (TextUtils.isEmpty(bluedIngSelfFeed.feed_uid)) {
                    str3 = "";
                } else {
                    str3 = bluedIngSelfFeed.feed_uid;
                    Intrinsics.c(str3, "it.feed_uid");
                }
                if (bluedIngSelfFeed.is_new_face != 1) {
                    z = false;
                }
                if (!TextUtils.isEmpty(bluedIngSelfFeed.strong_insert_data)) {
                    str7 = bluedIngSelfFeed.strong_insert_data;
                    Intrinsics.c(str7, "it.strong_insert_data");
                }
                str4 = str7;
                str5 = str3;
                str6 = str2;
            }
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_ALL_PAGE_SHOW, str6, str5, sourcePage, z, str4, false);
        }
    }

    public SignFeedListFragment() {
        super(R.layout.fragment_sign_feed_list);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 24);
        Intrinsics.c(ofInt, "ofInt(0, 24)");
        this.y = ofInt;
        this.G = FeedMethods.c(228);
    }

    private final void F() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.feed_bubble_list_header_view, (ViewGroup) null);
        this.j = inflate;
        this.k = inflate == null ? null : (ImageView) inflate.findViewById(R.id.bubble_list_header_bg);
        View view = this.j;
        this.l = view == null ? null : (ImageView) view.findViewById(R.id.bubble_list_header_title_iv);
        View view2 = this.j;
        this.m = view2 == null ? null : (TextView) view2.findViewById(R.id.bubble_list_header_title_tv);
        View view3 = this.j;
        this.n = view3 == null ? null : (TextView) view3.findViewById(R.id.bubble_list_header_des_tv);
        View view4 = this.j;
        this.o = view4 == null ? null : (LinearLayout) view4.findViewById(R.id.bubble_list_header_date_layout);
        View view5 = this.j;
        this.p = view5 == null ? null : (TextView) view5.findViewById(R.id.bubble_list_header_not_start_tv);
        View view6 = this.j;
        this.r = view6 == null ? null : view6.findViewById(R.id.bubble_list_header_progress_layout);
        View view7 = this.j;
        this.s = view7 == null ? null : (TextView) view7.findViewById(R.id.bubble_list_header_progress_date);
        View view8 = this.j;
        this.t = view8 == null ? null : view8.findViewById(R.id.bubble_list_header_finish_layout);
        View view9 = this.j;
        this.u = view9 == null ? null : (TextView) view9.findViewById(R.id.bubble_list_header_finish_time_tv);
        View view10 = this.j;
        this.w = view10 == null ? null : (TextView) view10.findViewById(R.id.bubble_list_header_finish_des_tv);
        View view11 = this.j;
        this.v = view11 == null ? null : (ImageView) view11.findViewById(R.id.bubble_list_header_finish_icon_iv);
        View view12 = this.j;
        this.q = view12 == null ? null : (TextView) view12.findViewById(R.id.bubble_list_header_confirm_tv);
        f().addHeaderView(this.j);
        View view13 = this.j;
        if (view13 != null) {
            view13.setVisibility(this.F ? 0 : 8);
        }
        TextView textView = this.q;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignFeedListFragment$hXRrZXWStlt0ewrWRFYp5bIF5fY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view14) {
                SignFeedListFragment.b(SignFeedListFragment.this, view14);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        FeedBubbleSignModel feedBubbleSignModel = this.D;
        if (feedBubbleSignModel == null) {
            View view = this.j;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        } else if (feedBubbleSignModel == null) {
        } else {
            String bgImg = feedBubbleSignModel.getBgImg();
            if (bgImg != null) {
                List b2 = StringsKt.b((CharSequence) bgImg, new String[]{","}, false, 0, 6, (Object) null);
                if (!b2.isEmpty()) {
                    String str = (String) b2.get(0);
                    String str2 = str;
                    if (CommunityManager.a.a().s()) {
                        str2 = str;
                        if (b2.size() > 1) {
                            str2 = (String) b2.get(1);
                        }
                    }
                    ImageLoader.a(getFragmentActive(), str2).d(R.drawable.bubble_list_header_bg).a(this.k);
                } else {
                    ImageView imageView = this.k;
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.bubble_list_header_bg);
                    }
                }
            }
            TextView textView = this.m;
            if (textView != null) {
                String title = feedBubbleSignModel.getTitle();
                String str3 = title;
                if (title == null) {
                    str3 = "打卡";
                }
                textView.setText(str3);
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                String subtitle = feedBubbleSignModel.getSubtitle();
                String str4 = subtitle;
                if (subtitle == null) {
                    str4 = "完成 5 天打卡即可获得成就标识，还会增加曝光哦~";
                }
                textView2.setText(str4);
            }
            TextView textView3 = this.p;
            if (textView3 != null) {
                textView3.setText(getString(R.string.feed_bubble_sign_tips));
            }
            float c = (AppInfo.l - FeedMethods.c(24)) / FeedMethods.c(ImsReasonInfo.CODE_SIP_SERVER_INTERNAL_ERROR);
            TextView textView4 = this.q;
            if (textView4 != null) {
                ViewGroup.LayoutParams layoutParams = textView4.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.width = (int) (FeedMethods.c(72) * c);
                textView4.setLayoutParams(marginLayoutParams);
                textView4.setText(feedBubbleSignModel.getToday_complete() == 1 ? R.string.feed_bubble_sign_continue_post_bubble : R.string.feed_bubble_sign_now);
            }
            int finishNum = feedBubbleSignModel.getFinishNum();
            if (finishNum == -1) {
                TextView textView5 = this.p;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
                View view2 = this.r;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                View view3 = this.t;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                if (feedBubbleSignModel.getExposureTime() <= 0) {
                    TextView textView6 = this.w;
                    if (textView6 != null) {
                        textView6.setText("本期已达成！");
                    }
                    TextView textView7 = this.u;
                    if (textView7 != null) {
                        textView7.setVisibility(8);
                    }
                } else {
                    TextView textView8 = this.w;
                    if (textView8 != null) {
                        textView8.setText(getString(R.string.feed_bubble_sign_finish));
                    }
                    TextView textView9 = this.u;
                    if (textView9 != null) {
                        textView9.setText(Intrinsics.a(getString(R.string.feed_bubble_reward_time_pre), (Object) a(feedBubbleSignModel.getExposureTime())));
                    }
                    TextView textView10 = this.u;
                    if (textView10 != null) {
                        textView10.setVisibility(0);
                    }
                }
            } else if (finishNum != 0) {
                TextView textView11 = this.p;
                if (textView11 != null) {
                    textView11.setVisibility(8);
                }
                View view4 = this.r;
                if (view4 != null) {
                    view4.setVisibility(0);
                }
                View view5 = this.t;
                if (view5 != null) {
                    view5.setVisibility(8);
                }
                TextView textView12 = this.s;
                if (textView12 != null) {
                    textView12.setText(String.valueOf(feedBubbleSignModel.getFinishNum()));
                }
            } else {
                TextView textView13 = this.p;
                if (textView13 != null) {
                    textView13.setVisibility(0);
                }
                View view6 = this.r;
                if (view6 != null) {
                    view6.setVisibility(8);
                }
                View view7 = this.t;
                if (view7 != null) {
                    view7.setVisibility(8);
                }
            }
            if (CommunityManager.a.a().s()) {
                ImageView imageView2 = this.l;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.bubble_list_header_title_dark);
                }
                TextView textView14 = this.n;
                if (textView14 != null) {
                    textView14.setTextColor(Color.parseColor("#9087A1"));
                }
                TextView textView15 = this.u;
                if (textView15 != null) {
                    textView15.setTextColor(Color.parseColor("#9087A1"));
                }
                ImageView imageView3 = this.v;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.bubble_list_header_finish_icon_dark);
                }
            } else {
                ImageView imageView4 = this.l;
                if (imageView4 != null) {
                    imageView4.setImageResource(R.drawable.bubble_list_header_title);
                }
                TextView textView16 = this.n;
                if (textView16 != null) {
                    textView16.setTextColor(Color.parseColor("#806BAA"));
                }
                TextView textView17 = this.u;
                if (textView17 != null) {
                    textView17.setTextColor(Color.parseColor("#806BAA"));
                }
                ImageView imageView5 = this.v;
                if (imageView5 != null) {
                    imageView5.setImageResource(R.drawable.bubble_list_header_finish_icon);
                }
            }
            List<FeedBubbleSignTextModel> timeList = feedBubbleSignModel.getTimeList();
            if (timeList != null) {
                LinearLayout linearLayout = this.o;
                if (linearLayout != null) {
                    linearLayout.removeAllViews();
                }
                int c2 = timeList.isEmpty() ^ true ? timeList.size() > 6 ? (AppInfo.l - FeedMethods.c(44)) / timeList.size() : FeedMethods.c(49) : FeedMethods.c(49);
                Iterator<FeedBubbleSignTextModel> it = timeList.iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    FeedBubbleSignTextModel next = it.next();
                    if (i2 < 0) {
                        CollectionsKt.c();
                    }
                    FeedBubbleSignTextModel feedBubbleSignTextModel = next;
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.feed_bubble_list_header_item_layout, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.feed_bubble_list_header_item_parent);
                    ImageView imageView6 = (ImageView) inflate.findViewById(R.id.feed_bubble_list_header_item_bg);
                    ImageView imageView7 = (ImageView) inflate.findViewById(R.id.feed_bubble_list_header_item_iv);
                    TextView textView18 = (TextView) inflate.findViewById(R.id.bubble_list_header_state_tv);
                    TextView textView19 = (TextView) inflate.findViewById(R.id.bubble_list_header_confirm_tv);
                    ImageView imageView8 = inflate == null ? null : (ImageView) inflate.findViewById(R.id.bubble_list_header_indicator_iv);
                    if (TextUtils.isEmpty(feedBubbleSignTextModel.getState_icon())) {
                        imageView7.setVisibility(8);
                        textView18.setVisibility(0);
                    } else {
                        imageView7.setVisibility(0);
                        textView18.setVisibility(8);
                        String state_icon = feedBubbleSignTextModel.getState_icon();
                        if (state_icon != null) {
                            ImageLoader.a(getFragmentActive(), state_icon).a(imageView7);
                        }
                    }
                    textView19.setText(feedBubbleSignTextModel.getDate());
                    ViewGroup.LayoutParams layoutParams2 = imageView6.getLayoutParams();
                    if (layoutParams2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    if (CommunityManager.a.a().s()) {
                        if (feedBubbleSignTextModel.is_today() == 1) {
                            imageView6.setImageResource(R.drawable.feed_bubble_list_header_item_today_dark);
                        } else {
                            imageView6.setImageResource(R.drawable.feed_bubble_list_header_item_not_today_dark);
                        }
                        if (imageView8 != null) {
                            imageView8.setImageResource(R.drawable.bubble_list_header_indicator_dark);
                        }
                    } else {
                        if (feedBubbleSignTextModel.is_today() == 1) {
                            imageView6.setImageResource(R.drawable.feed_bubble_list_header_item_today);
                        } else {
                            imageView6.setImageResource(R.drawable.feed_bubble_list_header_item_not_today);
                        }
                        if (imageView8 != null) {
                            imageView8.setImageResource(R.drawable.bubble_list_header_indicator);
                        }
                    }
                    marginLayoutParams2.width = c2;
                    if (feedBubbleSignTextModel.is_today() == 1) {
                        if (imageView8 != null) {
                            imageView8.setVisibility(0);
                        }
                    } else if (imageView8 != null) {
                        imageView8.setVisibility(4);
                    }
                    imageView6.setLayoutParams(marginLayoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
                    if (layoutParams3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.width = c2;
                    findViewById.setLayoutParams(marginLayoutParams3);
                    LinearLayout linearLayout2 = this.o;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(inflate, -2, -1);
                    }
                    i = i2 + 1;
                }
            }
            if (this.I) {
                return;
            }
            EventTrackFeed.n(FeedProtos.Event.PUNCH_FEED_GUIDE_SHOW, feedBubbleSignModel.getId());
            this.I = true;
        }
    }

    private final void H() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get("feed_post_sign_data", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignFeedListFragment$s6pCd1XvENe71cdheX5HPMkOrYA
            public final void onChanged(Object obj) {
                SignFeedListFragment.a(SignFeedListFragment.this, (BluedIngSelfFeed) obj);
            }
        });
        LiveEventBus.get("send_feed_success", BluedIngSelfFeed.class).observe(lifecycleOwner, new Observer() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignFeedListFragment$QZ7XGcdPPlCMUg5mxiBqIEJ-2Fg
            public final void onChanged(Object obj) {
                SignFeedListFragment.b(SignFeedListFragment.this, (BluedIngSelfFeed) obj);
            }
        });
    }

    private final void I() {
        if (CommunityPreferences.o()) {
            this.B = true;
            CommonFloatBottomView commonFloatBottomView = this.c;
            if (commonFloatBottomView != null) {
                commonFloatBottomView.setVisibility(0);
            }
            Context activity = getActivity();
            if (activity != null) {
                Context context = activity;
                String string = getString(R.string.sign_feed_set_guide_post);
                Intrinsics.c(string, "getString(R.string.sign_feed_set_guide_post)");
                FeedGuidePop feedGuidePop = new FeedGuidePop(context, string, NinePatchUtils.GuideArrowPosition.CENTER, false, 0, "sign_feed_set_guide_update_hand.png", 18, 30, 180);
                this.z = feedGuidePop;
                if (feedGuidePop != null) {
                    feedGuidePop.setOffsetX(DisplayUtil.a(getContext(), 10.0f));
                    feedGuidePop.setDismissOnTouchOutside(true);
                    View view = this.c;
                    if (view != null) {
                        FeedGuidePop.t.b(feedGuidePop, new SimpleCallback() { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$showPostGuide$2$1$1$1
                        }, view, 0L);
                    }
                }
            }
            CommunityPreferences.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J() {
        return !this.B && TimeAndDateUtils.a() >= CommunityPreferences.v() && CommunityPreferences.x() < 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        final ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f);
            ofFloat.setDuration(250L);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$startBtnEmotionAnim$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ImageWrapper c = ImageLoader.c(SignFeedListFragment.this.getFragmentActive(), "sign_feed_list_frg_guide.png");
                    final SignFeedListFragment signFeedListFragment = SignFeedListFragment.this;
                    c.a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$startBtnEmotionAnim$1$1$onAnimationEnd$1
                        @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                        public void a() {
                        }

                        @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                        public void b() {
                            SignFeedListFragment.this.L();
                        }
                    }).g().g(1).a(imageView);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            ofFloat.start();
        }
        final ImageView imageView2 = this.e;
        if (imageView2 == null) {
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "alpha", 1.0f, 0.1f);
        ofFloat2.setDuration(250L);
        ofFloat2.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$startBtnEmotionAnim$2$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageView.this.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        final ImageView imageView = this.f;
        if (imageView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", 1.0f, 0.1f);
            ofFloat.setDuration(250L);
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$startIvStaticShowAnim$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ImageView.this.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            ofFloat.start();
        }
        ImageView imageView2 = this.e;
        if (imageView2 == null) {
            return;
        }
        imageView2.setImageResource(R.drawable.sign_feed_list_btn_icon);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = FeedMethods.c(3);
        layoutParams2.gravity = 53;
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setVisibility(0);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(250L);
        ofFloat2.start();
    }

    private final void M() {
        CoroutineScope coroutineScope = this.E;
        if (coroutineScope == null) {
            return;
        }
        BuildersKt__Builders_commonKt.a(coroutineScope, null, null, new SignFeedListFragment$onLoadData$1(this, null), 3, null);
    }

    private final void N() {
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        bluedIngSelfFeed.feed_type = 30;
        bluedIngSelfFeed.bubbleInsertGuideExtra = ((SignFeedListViewModel) y()).c();
        bluedIngSelfFeed.playAnimType = 5;
        if (f().getData().size() < 13) {
            f().addData(bluedIngSelfFeed);
        } else {
            f().addData(12, bluedIngSelfFeed);
        }
        f().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Continuation<? super FeedBubbleSignModel> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.a(continuation), 1);
        cancellableContinuationImpl.e();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        FeedHttpUtils.h(new BluedUIHttpResponse<BluedEntityA<FeedBubbleSignModel>>(fragmentActive) { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$getBubbleSignInfo$2$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedBubbleSignModel> bluedEntityA) {
                boolean z = false;
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    z = true;
                }
                if (z) {
                    CancellableContinuation<FeedBubbleSignModel> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.a;
                    cancellableContinuation.resumeWith(Result.f(bluedEntityA.getSingleData()));
                    return;
                }
                CancellableContinuation<FeedBubbleSignModel> cancellableContinuation2 = cancellableContinuationImpl2;
                Result.Companion companion2 = Result.a;
                cancellableContinuation2.resumeWith(Result.f(null));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    CancellableContinuation<FeedBubbleSignModel> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.a;
                    cancellableContinuation.resumeWith(Result.f(null));
                }
                LogUtils.c(Intrinsics.a("getSignFeedSet end, ", (Object) Long.valueOf(Thread.currentThread().getId())));
            }
        }, "classify", getFragmentActive());
        Object h = cancellableContinuationImpl.h();
        if (h == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return h;
    }

    private final String a(long j) {
        if (j < 3600) {
            return ((int) ((((float) j) / 60.0f) + 0.5f)) + getString(R.string.feed_bubble_reward_minute);
        }
        return ((int) ((((float) j) / 3600.0f) + 0.5f)) + getString(R.string.feed_bubble_reward_hour);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        Context context = getContext();
        if (context != null) {
            Bundle bundle = new Bundle();
            FeedBubbleSignModel feedBubbleSignModel = this.D;
            bundle.putString("classify_id", feedBubbleSignModel == null ? null : feedBubbleSignModel.getId());
            FeedPostSignStateFragment.a.a(context, bundle, i);
        }
        if (this.C) {
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_PNG_GUIDE_CLICK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SignFeedListFragment this$0, int i, int i2, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) animatedValue).intValue();
        float f = 1;
        float f2 = intValue;
        float f3 = f2 / 24;
        View view = this$0.g;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i + DensityUtils.a(AppInfo.d(), f2);
        layoutParams.height = i2 + DensityUtils.a(AppInfo.d(), f2);
        view.setLayoutParams(layoutParams);
        view.setAlpha(f - f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SignFeedListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SignFeedListFragment this$0, BluedIngSelfFeed bluedIngSelfFeed) {
        Intrinsics.e(this$0, "this$0");
        this$0.f().addData(0, bluedIngSelfFeed);
        RecyclerView a = this$0.a();
        if (a == null) {
            return;
        }
        a.smoothScrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SignFeedListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(9);
        FeedProtos.Event event = FeedProtos.Event.PUNCH_FEED_GUIDE_CLICK;
        FeedBubbleSignModel feedBubbleSignModel = this$0.D;
        EventTrackFeed.n(event, feedBubbleSignModel == null ? null : feedBubbleSignModel.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SignFeedListFragment this$0, BluedIngSelfFeed bluedIngSelfFeed) {
        BluedIngSelfFeed bluedIngSelfFeed2;
        Intrinsics.e(this$0, "this$0");
        if (bluedIngSelfFeed != null && bluedIngSelfFeed.is_bubble_ticktock == 1) {
            ((SignFeedListViewModel) this$0.y()).a(true);
        }
        if (this$0.f().getData().size() > 0 && (bluedIngSelfFeed2 = (BluedIngSelfFeed) this$0.f().getData().get(0)) != null && bluedIngSelfFeed != null && bluedIngSelfFeed.is_bubble_ticktock == 1 && !TextUtils.isEmpty(bluedIngSelfFeed.feed_uid) && TextUtils.equals(bluedIngSelfFeed.feed_uid, UserInfoUtils.c()) && !TextUtils.isEmpty(bluedIngSelfFeed.feed_content) && TextUtils.equals(bluedIngSelfFeed.feed_content, bluedIngSelfFeed2.feed_content) && !TextUtils.isEmpty(bluedIngSelfFeed.bubble_state_id) && TextUtils.equals(bluedIngSelfFeed.bubble_state_id, bluedIngSelfFeed2.bubble_state_id)) {
            this$0.f().setData(0, bluedIngSelfFeed);
        }
        this$0.M();
        if (bluedIngSelfFeed.bubbleSignComplete == 1) {
            CommRouteUtil.a(this$0, bluedIngSelfFeed.complete_image, bluedIngSelfFeed.complete_title, bluedIngSelfFeed.complete_subtitle, bluedIngSelfFeed.complete_bubble);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public FeedListAdapterForRecyclerView i() {
        return new FeedListAdapterForRecyclerView(getContext(), this, null, 26);
    }

    public final void D() {
        this.J = true;
        LogUtils.c("冒泡三期 setBubblePoked：true");
    }

    public final void E() {
        this.L = true;
        LogUtils.c("冒泡三期 setChatClicked：true");
    }

    public void a(RecyclerView recyclerView, int i) {
        View view;
        Intrinsics.e(recyclerView, "recyclerView");
        if (this.F && i == 0 && !recyclerView.canScrollVertically(-1) && (view = this.x) != null) {
            view.setVisibility(8);
        }
        if (i == 0) {
            int i2 = f().q;
            int i3 = f().r;
            StringBuilder sb = new StringBuilder();
            sb.append("冒泡三期 feedBubblePostGuideGroup:");
            sb.append(this.K);
            sb.append(", isBubblePoked:");
            sb.append(this.J);
            sb.append(", isChatClicked:");
            sb.append(this.L);
            sb.append(", isBubblePostGuideShowed:");
            sb.append(this.M);
            sb.append(", isSendToday:");
            sb.append(((SignFeedListViewModel) y()).a());
            sb.append(", insertGuideExtra:");
            FeedBubbleListGuideExtra c = ((SignFeedListViewModel) y()).c();
            sb.append((Object) (c == null ? null : c.toString()));
            LogUtils.c(sb.toString());
            LogUtils.c("冒泡三期 firstPosition:" + i2 + ", lastPosition:" + i3);
            int i4 = this.K;
            if (i4 == 3) {
                int min = Math.min(12, f().getData().size());
                LogUtils.c(Intrinsics.a("冒泡三期 min:", (Object) Integer.valueOf(min)));
                if (!this.J || this.L || this.M || ((SignFeedListViewModel) y()).a() || i3 < min) {
                    return;
                }
                K();
                this.M = true;
                this.C = true;
                EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_PNG_GUIDE_SHOW);
                return;
            }
            if (i4 == 2) {
                int min2 = Math.min(12, f().getData().size() - 1);
                LogUtils.c(Intrinsics.a("冒泡三期 max:", (Object) Integer.valueOf(min2)));
                if (this.J && !this.L && !this.M && !((SignFeedListViewModel) y()).a() && i2 <= min2 && i3 >= min2 && ((SignFeedListViewModel) y()).c() != null) {
                    N();
                    this.M = true;
                }
            }
            if (this.C || i3 < 9) {
                return;
            }
            K();
            this.C = true;
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_PNG_GUIDE_SHOW);
        }
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        View view;
        Intrinsics.e(recyclerView, "recyclerView");
        int i3 = this.H + i2;
        this.H = i3;
        if (!this.F || i3 <= this.G || (view = this.x) == null) {
            return;
        }
        view.setVisibility(0);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void a(boolean z, boolean z2) {
        super.a(z, z2);
        final CommonFloatBottomView commonFloatBottomView = this.c;
        if (commonFloatBottomView == null || commonFloatBottomView.getVisibility() == 0) {
            return;
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (J()) {
                imageView.setImageResource(R.drawable.sign_feed_list_frg_guide_static);
                layoutParams2.topMargin = 0;
                layoutParams2.gravity = 21;
            } else {
                imageView.setImageResource(R.drawable.sign_feed_list_btn_icon);
                layoutParams2.topMargin = FeedMethods.c(3);
                layoutParams2.gravity = 53;
            }
            imageView.setLayoutParams(layoutParams2);
            imageView.setVisibility(0);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(commonFloatBottomView, "translationY", BluedViewExtKt.a(60), 0.0f);
        ofFloat.setDuration(450L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$loadFinished$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                boolean J;
                J = this.J();
                if (J) {
                    this.K();
                    CommunityPreferences.w();
                    CommunityPreferences.z();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                commonFloatBottomView.setVisibility(0);
            }
        });
        ofFloat.setStartDelay(500L);
        ofFloat.start();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().e(true).a(20).a(ListConfig.LoadMoreModel.PULL_UP).b(true).c(true).d(true).a(true).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void l() {
        StringBuilder sb = new StringBuilder();
        sb.append("冒泡三期 onClickTitleLeft isBubblePoked:");
        sb.append(this.J);
        sb.append(", isChatClicked:");
        sb.append(this.L);
        sb.append(", isBubblePostGuideShowed:");
        sb.append(this.M);
        sb.append(", isSendToday:");
        sb.append(((SignFeedListViewModel) y()).a());
        sb.append(", popGuideExtra:");
        FeedBubbleListGuideExtra b2 = ((SignFeedListViewModel) y()).b();
        sb.append((Object) (b2 == null ? null : b2.toString()));
        LogUtils.c(sb.toString());
        if (!this.J || this.L || this.K != 1 || this.M || ((SignFeedListViewModel) y()).a() || ((SignFeedListViewModel) y()).b() == null) {
            super.l();
            return;
        }
        CommRouteUtil.a(this, ((SignFeedListViewModel) y()).b());
        this.M = true;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        View view;
        super.m();
        if (CommunityManager.a.a().s()) {
            RecyclerView a = a();
            if (a != null) {
                a.setBackgroundResource(R.color.syc_0E0E0E);
            }
        } else {
            RecyclerView a2 = a();
            if (a2 != null) {
                a2.setBackgroundResource(R.color.syc_c);
            }
        }
        ((SignFeedListViewModel) y()).a(getArguments());
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.A = arguments.getInt("from");
        }
        CommonTopTitleNoTrans b2 = b();
        if (b2 != null) {
            b2.setCenterText(R.string.feed_list_item_title);
        }
        View findViewById = requireView().findViewById(R.id.title_right_btn);
        this.x = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignFeedListFragment$8CCLOaHf9YzIUn-_86-YkH5hu8A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SignFeedListFragment.a(SignFeedListFragment.this, view2);
                }
            });
        }
        NoDataAndLoadFailView c = c();
        if (c != null) {
            c.setNoDataImg(R.drawable.icon_no_data_common);
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataStr(R.string.sign_feed_no_data_str);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 != null) {
            c3.setNoDataBtnVisibility(8);
        }
        NoDataAndLoadFailView c4 = c();
        ShapeTextView btn = c4 == null ? null : c4.getBtn();
        if (btn != null) {
            btn.setVisibility(8);
        }
        CommonFloatBottomView findViewById2 = requireView().findViewById(R.id.sign_feed_list_send_float_view);
        this.c = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnBtnClickListener(new CommonFloatBottomView.OnBtnClickListener() { // from class: com.blued.community.ui.feed.fragment.SignFeedListFragment$initView$3
                public void onClick() {
                    SignFeedListFragment.this.a(1);
                }
            });
        }
        View inflate = getLayoutInflater().inflate(R.layout.sign_feed_list_send_btn_layout, (ViewGroup) null);
        this.d = inflate;
        CommonFloatBottomView commonFloatBottomView = this.c;
        if (commonFloatBottomView != null) {
            commonFloatBottomView.addChildView(inflate);
        }
        View view2 = this.d;
        this.e = view2 == null ? null : (ImageView) view2.findViewById(R.id.sign_feed_list_btn_icon);
        View view3 = this.d;
        this.f = view3 == null ? null : (ImageView) view3.findViewById(R.id.sign_feed_list_btn_apng);
        View view4 = this.d;
        View findViewById3 = view4 == null ? null : view4.findViewById(R.id.sign_feed_list_send_bg);
        this.g = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
        CommonFloatBottomView commonFloatBottomView2 = this.c;
        if (commonFloatBottomView2 != null) {
            commonFloatBottomView2.setVisibility(8);
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        RecyclerView a3 = a();
        RecyclerView.Adapter adapter = a3 == null ? null : a3.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView");
        }
        FeedMethods.a(lifecycleOwner, (IFeedDataObserver) adapter);
        View inflate2 = View.inflate(getContext(), R.layout.layout_load_more_end_footer, null);
        this.h = inflate2;
        View findViewById4 = inflate2 == null ? null : inflate2.findViewById(R.id.load_more_footer_bottom_view);
        this.i = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setVisibility(0);
        }
        View view5 = this.h;
        if (view5 != null) {
            view5.setVisibility(8);
            f().addFooterView(view5);
        }
        if ((this.A == 8 || CommunityPreferences.m()) && (view = this.g) != null) {
            view.setVisibility(0);
            final int a4 = DisplayUtil.a(AppInfo.d(), 154.0f);
            final int a5 = DisplayUtil.a(AppInfo.d(), 44.0f);
            this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignFeedListFragment$_MlkewJzkJUHcQw7kV_RmAc6b_Y
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SignFeedListFragment.a(SignFeedListFragment.this, a4, a5, valueAnimator);
                }
            });
            this.y.setRepeatCount(1);
            this.y.setDuration(1500L);
            this.y.setStartDelay(300L);
            this.y.start();
            CommunityPreferences.n();
        }
        if (TimeAndDateUtils.a() > CommunityPreferences.v()) {
            CommunityPreferences.y();
        }
        boolean P = CommunityServiceManager.a().P();
        this.F = P;
        if (P) {
            this.E = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
        }
        F();
        int Q = CommunityServiceManager.a().Q();
        this.K = Q;
        LogUtils.c(Intrinsics.a("冒泡三期 实验组：", (Object) Integer.valueOf(Q)));
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void n() {
        super.n();
        M();
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        l();
        return true;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        EventTrackFeed.a(FeedProtos.Event.MINE_COMMENT_TAB_SHOW);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        H();
        I();
        M();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void p() {
        super.p();
        if (!e().c() && f().getData().size() > 0) {
            View view = this.h;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
        } else if (e().f() == ListConfig.LoadMoreModel.PULL_UP) {
            f().setEnableLoadMore(true);
            View view2 = this.h;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
        } else {
            f().setUpFetchEnable(true);
            View view3 = this.h;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void q() {
        super.q();
        if (!e().c()) {
            View view = this.h;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
        } else if (e().f() == ListConfig.LoadMoreModel.PULL_UP) {
            View view2 = this.h;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(0);
        } else {
            f().setUpFetchEnable(false);
            View view3 = this.h;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void s() {
        if (this.F) {
            return;
        }
        super.s();
    }
}
