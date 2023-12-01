package com.soft.blued.ui.community.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.a;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.NearbyGuideModel;
import com.blued.community.model.TagModel;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.common.CommFullScreenDialog;
import com.blued.community.ui.feed.fragment.SignFeedListFragment;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.fragment.FeedPostSignBaseFragment;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.CommBundleBuilder;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.UserInfoUtils;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.ui.find.observer.NearbyFindSetSelectedTab;
import com.soft.blued.ui.setting.model.UserInfoPostFeedTextInfo;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/view/NearbyGuideDlgFragment.class */
public final class NearbyGuideDlgFragment extends CommFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f16111a = new Companion(null);
    private LinearLayout A;
    private LinearLayout B;
    private LinearLayout C;
    private FeedPostSignStateItem D;
    private boolean E;
    private NearbyGuideModel F;
    private String G;
    private BluedTopic H;
    private String I = "";
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private CardView f16112c;
    private View d;
    private View e;
    private TextView f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private RecyclerView k;
    private LinearSnapHelper l;
    private ImageView m;
    private CommonMultiItemAdapter<FeedPostSignStateItem> n;
    private LinearLayoutManager o;
    private View p;
    private TextView q;
    private View r;
    private CardView s;
    private View t;
    private ImageView u;
    private ImageView v;
    private View w;
    private ImageView x;
    private ImageView y;
    private FrameLayout z;

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/view/NearbyGuideDlgFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(BaseFragment baseFragment) {
            NearbyGuideModel nearbyGuideModel;
            long b = TimeAndDateUtils.b();
            long a2 = TimeAndDateUtils.a();
            LogUtils.c("模态弹层: curWeek=" + b + ", today=" + a2);
            if (baseFragment == null || baseFragment.getActivity() == null) {
                return;
            }
            if (CommunityPreferences.J() < b) {
                LogUtils.c("所有类型的模态弹层，清零，重新计算");
                CommunityPreferences.d(b);
                CommunityPreferences.L();
            }
            if (CommunityPreferences.H() >= a2) {
                LogUtils.c("同一uid一天只展示一次模态弹层");
            } else if (CommunityPreferences.J() > b) {
                LogUtils.c("当周已显示过模态弹层: " + CommunityPreferences.J() + " > " + b);
            } else {
                LogUtils.c(Intrinsics.a("本周显示过模态弹层次数：", Integer.valueOf(CommunityPreferences.K())));
                if (CommunityPreferences.K() >= 2) {
                    LogUtils.c("所有类型的模态弹层，一周之内总计不能展示超过2次");
                } else if (CommunityPreferences.I() >= a2) {
                    LogUtils.c("若一个uid今日已经看过模态弹层，但是未点击，次日不可再弹出模态弹层");
                } else {
                    LogUtils.c(Intrinsics.a("上次显示的模态弹层时间是", Long.valueOf(CommunityPreferences.H())));
                    LogUtils.c(Intrinsics.a("上次显示的模态弹层类型是", Integer.valueOf(CommunityPreferences.N())));
                    Iterator it = CommunityManager.a.a().g().iterator();
                    while (true) {
                        nearbyGuideModel = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        nearbyGuideModel = (NearbyGuideModel) it.next();
                        if (a2 - CommunityPreferences.H() != 1 || nearbyGuideModel.getType() != CommunityPreferences.N()) {
                            break;
                        }
                        LogUtils.c("同一类型的模态弹层，需求隔天显示");
                    }
                    if (nearbyGuideModel == null) {
                        CommunityManager.a.a().g().clear();
                        return;
                    }
                    LogUtils.c(Intrinsics.a("本次显示的模态弹层类型是", Integer.valueOf(nearbyGuideModel.getType())));
                    FragmentManager fragmentManager = baseFragment.getFragmentManager();
                    if (fragmentManager == null) {
                        return;
                    }
                    NearbyGuideDlgFragment nearbyGuideDlgFragment = new NearbyGuideDlgFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("guide_model", nearbyGuideModel);
                    nearbyGuideDlgFragment.setArguments(bundle);
                    nearbyGuideDlgFragment.setCancelable(false);
                    nearbyGuideDlgFragment.show(fragmentManager, nearbyGuideDlgFragment.b());
                    CommunityPreferences.M();
                    CommunityPreferences.b(a2);
                    CommunityPreferences.b(nearbyGuideModel.getType());
                    CommunityPreferences.c(a2 + 1);
                    CommunityManager.a.a().g().clear();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        NearbyFindSetSelectedTab.a().a(1);
    }

    private final Bitmap a(View view) {
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        Bitmap a2 = ImageUtils.a((int) R.drawable.nearby_guide_no_posted_feed_dlg_bg, FeedMethods.c(232), FeedMethods.c(222));
        Bitmap createBitmap2 = Bitmap.createBitmap(FeedMethods.c(232), FeedMethods.c(232), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawARGB(255, 255, 255, 255);
        canvas.drawBitmap(a2, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(createBitmap, (FeedMethods.c(232) - view.getMeasuredWidth()) / 2.0f, (FeedMethods.c(232) - view.getMeasuredHeight()) / 2.0f, (Paint) null);
        Intrinsics.c(createBitmap2, "newBitmap");
        return createBitmap2;
    }

    private final void a(float f) {
        int i = ((int) f) / (AppInfo.l / 5);
        if (i != 0) {
            dismissAllowingStateLoss();
        }
        CommEventBusUtil.f6855a.a(i);
        LogUtils.c(Intrinsics.a("onClickBottom: ", Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context) {
        Intrinsics.e(context, "$it");
        SignFeedListFragment.b.a(context, "", 9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00df, code lost:
        if (r0.isEmpty() != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(com.blued.community.model.NearbyGuideModel r4) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.community.view.NearbyGuideDlgFragment.a(com.blued.community.model.NearbyGuideModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(FeedPostSignStateItem feedPostSignStateItem) {
        this.D = feedPostSignStateItem;
        if (feedPostSignStateItem != null) {
            this.I = feedPostSignStateItem.getBubble_state_id();
            FeedPostSignStateItem feedPostSignStateItem2 = this.D;
            LogUtils.c(Intrinsics.a("onBubbleSelected:", feedPostSignStateItem2 == null ? null : feedPostSignStateItem2.getName()));
        }
        CommonMultiItemAdapter<FeedPostSignStateItem> commonMultiItemAdapter = this.n;
        if (commonMultiItemAdapter == null) {
            return;
        }
        commonMultiItemAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostSignStateItem feedPostSignStateItem, Context context, NearbyGuideDlgFragment nearbyGuideDlgFragment) {
        Intrinsics.e(feedPostSignStateItem, "$model");
        Intrinsics.e(context, "$it");
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        Bundle bundle = new Bundle();
        bundle.putSerializable("selected_model", (Serializable) feedPostSignStateItem);
        bundle.putInt("page_from", 2);
        FeedPostSignBaseFragment.a(context, bundle);
        nearbyGuideDlgFragment.dismissAllowingStateLoss();
        FeedConstants.c = 1;
    }

    private final void a(CommBundleBuilder commBundleBuilder) {
        String str;
        int c2 = FeedMethods.c(232);
        int c3 = FeedMethods.c(232);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(-1);
        Paint paint2 = new Paint();
        paint2.setDither(true);
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(FeedMethods.c(3));
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setColor(Color.parseColor("#FF9300"));
        textPaint.setTextSize(FeedMethods.c(14));
        LogUtils.c("createBirthdayPicFile. createBmp");
        try {
            Bitmap createBitmap = Bitmap.createBitmap(c2, c3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap a2 = ImageUtils.a((int) R.drawable.nearby_guide_birthday_feed_bg, c2, c3);
            if (a2 != null) {
                canvas.drawBitmap(a2, new Rect(0, 0, a2.getWidth(), a2.getHeight()), new Rect(0, 0, c2, c3), paint);
            }
            int c4 = FeedMethods.c(72);
            int c5 = FeedMethods.c(58);
            ImageView imageView = this.v;
            Drawable drawable = imageView == null ? null : imageView.getDrawable();
            try {
                if (drawable == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    int i = (int) ((c2 - c4) / 2.0f);
                    canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(i, c5, i + c4, c5 + c4), paint);
                }
                float f = c2;
                float f2 = f / 2.0f;
                float f3 = c5;
                float f4 = c4 / 2.0f;
                canvas.drawCircle(f2, f3 + f4, (f4 + (paint2.getStrokeWidth() / 2.0f)) - FeedMethods.c(1), paint2);
                Bitmap a3 = ImageUtils.a((int) R.drawable.nearby_guide_birthday_fg, c2, c3);
                if (a3 != null) {
                    canvas.drawBitmap(a3, (c2 - a3.getWidth()) / 2.0f, FeedMethods.c(45), paint);
                }
                NearbyGuideModel nearbyGuideModel = this.F;
                String birthday = nearbyGuideModel == null ? null : nearbyGuideModel.getBirthday();
                String str2 = birthday;
                if (TextUtils.isEmpty(birthday)) {
                    Date date = new Date(System.currentTimeMillis());
                    StringBuilder sb = new StringBuilder();
                    sb.append(date.getMonth() + 1);
                    sb.append('.');
                    sb.append(date.getDate());
                    str2 = sb.toString();
                }
                String str3 = "今天 " + ((Object) str2) + " 是我的生日";
                canvas.drawText(str3, (f - textPaint.measureText(str3)) / 2.0f, FeedMethods.c(168), textPaint);
                canvas.drawText("小哥哥，求祝福~", (f - textPaint.measureText("小哥哥，求祝福~")) / 2.0f, FeedMethods.c(190), textPaint);
                String a4 = Intrinsics.a(RecyclingUtils.e("photo"), "/GuideBirthdaySendFeed.png");
                String str4 = a4;
                if (!ImageUtils.a(createBitmap, a4, Bitmap.CompressFormat.PNG)) {
                    str4 = "";
                }
                LogUtils.c(Intrinsics.a("createBirthdayPicFile. imgPath: ", str4));
                if (!TextUtils.isEmpty(str4)) {
                    NewFeedModel newFeedModel = new NewFeedModel();
                    newFeedModel.setPics(str4);
                    newFeedModel.dontNeedCompress = true;
                    newFeedModel.tt_type = 5;
                    commBundleBuilder.a(newFeedModel);
                }
                LogUtils.c(Intrinsics.a("createBirthdayPicFile. FeedAddPostFragment.show: ", str4));
            } catch (Exception e) {
                e = e;
                str = "createBirthdayPicFile";
                LogUtils.a(str, e);
            } catch (OutOfMemoryError e2) {
                e = e2;
                LogUtils.a("createBirthdayPicFile", e);
            }
        } catch (Exception e3) {
            e = e3;
            str = "createBirthdayPicFile";
        } catch (OutOfMemoryError e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NearbyGuideDlgFragment nearbyGuideDlgFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        nearbyGuideDlgFragment.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NearbyGuideDlgFragment nearbyGuideDlgFragment, Boolean bool) {
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        nearbyGuideDlgFragment.j();
    }

    private final void a(String str, String str2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setTextSize(17.0f);
        }
        if (this.E) {
            View view = this.d;
            if (view != null) {
                view.setBackgroundResource(R.drawable.nearby_guide_bg_mask_dark);
            }
        } else {
            View view2 = this.d;
            if (view2 != null) {
                view2.setBackgroundResource(R.drawable.nearby_guide_bg_mask);
            }
        }
        View view3 = this.p;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.E) {
                ImageView imageView = this.j;
                if (imageView != null) {
                    imageView.setBackgroundResource(R.drawable.nearby_guide_qa_bg_dark);
                }
            } else {
                ImageView imageView2 = this.j;
                if (imageView2 != null) {
                    imageView2.setBackgroundResource(R.drawable.nearby_guide_qa_bg);
                }
            }
        } else if (str2 != null) {
            ImageLoader.a(a(), str2).a(this.j);
        }
        TextView textView2 = this.q;
        if (textView2 == null) {
            return;
        }
        String str3 = str;
        textView2.setText(str3);
        TextPaint paint = textView2.getPaint();
        StaticLayout a2 = FeedMethods.a(str3, paint, FeedMethods.c(230));
        View view4 = this.r;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) (view4 == null ? null : view4.getLayoutParams());
        CardView cardView = this.s;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) (cardView == null ? null : cardView.getLayoutParams());
        if (a2.getLineCount() > 1) {
            CardView cardView2 = this.s;
            if (cardView2 != null) {
                cardView2.setVisibility(0);
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.width = -1;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = FeedMethods.c(22);
            }
            int lineStart = a2.getLineStart(1) + 1;
            Intrinsics.a(str);
            if (str.length() > lineStart) {
                String substring = str.substring(lineStart);
                Intrinsics.c(substring, "this as java.lang.String).substring(startIndex)");
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.width = ((int) paint.measureText(substring)) + FeedMethods.c(18);
                }
            }
        } else {
            CardView cardView3 = this.s;
            if (cardView3 != null) {
                cardView3.setVisibility(8);
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.width = ((int) paint.measureText(str)) + FeedMethods.c(18);
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = FeedMethods.c(35);
            }
        }
        View view5 = this.r;
        if (view5 == null) {
            return;
        }
        view5.setLayoutParams(marginLayoutParams);
    }

    private final void a(ArrayList<ArrayList<UserInfoPostFeedTextInfo>> arrayList) {
        if (arrayList.size() <= 1) {
            LinearLayout linearLayout = this.C;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            ArrayList<UserInfoPostFeedTextInfo> arrayList2 = arrayList.get(0);
            Intrinsics.c(arrayList2, "list[0]");
            a(arrayList2, this.B);
            return;
        }
        LinearLayout linearLayout2 = this.C;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        LinearLayout linearLayout3 = this.C;
        if (linearLayout3 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, BluedViewExtKt.a(r()), 0, 0);
            linearLayout3.setLayoutParams(layoutParams);
            linearLayout3.getLayoutParams();
        }
        ArrayList<UserInfoPostFeedTextInfo> arrayList3 = arrayList.get(0);
        Intrinsics.c(arrayList3, "list[0]");
        a(arrayList3, this.B);
        ArrayList<UserInfoPostFeedTextInfo> arrayList4 = arrayList.get(1);
        Intrinsics.c(arrayList4, "list[1]");
        a(arrayList4, this.C);
    }

    private final void a(ArrayList<UserInfoPostFeedTextInfo> arrayList, LinearLayout linearLayout) {
        Context context;
        if (linearLayout == null || (context = getContext()) == null) {
            return;
        }
        linearLayout.removeAllViews();
        linearLayout.setGravity(17);
        Iterator<T> it = arrayList.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return;
            }
            Object next = it.next();
            if (i2 < 0) {
                CollectionsKt.c();
            }
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo = (UserInfoPostFeedTextInfo) next;
            ShapeTextView shapeTextView = new ShapeTextView(context);
            shapeTextView.setText(userInfoPostFeedTextInfo.getContentList().get(0));
            shapeTextView.setMaxLines(1);
            shapeTextView.setEllipsize(TextUtils.TruncateAt.END);
            shapeTextView.setTextSize(userInfoPostFeedTextInfo.getRealTextSize());
            shapeTextView.setPadding((int) userInfoPostFeedTextInfo.getOriginLeftRightMargin(), (int) userInfoPostFeedTextInfo.getOriginTopBottomMargin(), (int) userInfoPostFeedTextInfo.getOriginLeftRightMargin(), (int) userInfoPostFeedTextInfo.getOriginTopBottomMargin());
            ShapeModel shapeModel = shapeTextView.getShapeModel();
            shapeModel.k = userInfoPostFeedTextInfo.getBgColor();
            shapeModel.I = userInfoPostFeedTextInfo.getItemOriginBigCorner();
            shapeModel.J = userInfoPostFeedTextInfo.getItemOriginLittleCorner();
            shapeModel.K = userInfoPostFeedTextInfo.getItemOriginLittleCorner();
            shapeModel.L = userInfoPostFeedTextInfo.getItemOriginBigCorner();
            shapeModel.b = context.getResources().getColor(2131101780);
            shapeTextView.setShapeModel(shapeModel);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i2 != 0) {
                layoutParams.setMarginStart(FeedMethods.c(r()));
            }
            linearLayout.addView((View) shapeTextView, layoutParams);
            i = i2 + 1;
        }
    }

    private final void a(List<TagModel> list) {
        String name;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (i2 < 0) {
                CollectionsKt.c();
            }
            TagModel tagModel = (TagModel) next;
            if (tagModel != null && (name = tagModel.getName()) != null) {
                UserInfoPostFeedTextInfo userInfoPostFeedTextInfo = new UserInfoPostFeedTextInfo();
                if (arrayList.size() == 0) {
                    userInfoPostFeedTextInfo.setFactor(1.0f);
                    userInfoPostFeedTextInfo.setBgColor(Color.parseColor("#E67D89FF"));
                    userInfoPostFeedTextInfo.setItemOriginBigCorner(FeedMethods.a(14.1f));
                    userInfoPostFeedTextInfo.setItemOriginLittleCorner(FeedMethods.a(7.9f));
                    userInfoPostFeedTextInfo.setOriginLeftRightMargin(FeedMethods.a(17.6f));
                    userInfoPostFeedTextInfo.setOriginTopBottomMargin(FeedMethods.a(5.7f));
                    userInfoPostFeedTextInfo.setRealTextSize(13.2f);
                    userInfoPostFeedTextInfo.setSort(2);
                    userInfoPostFeedTextInfo.getContentList().addAll(CollectionsKt.c(new String[]{name}));
                    arrayList.add(userInfoPostFeedTextInfo);
                } else if (arrayList.size() == 1) {
                    userInfoPostFeedTextInfo.setFactor(0.9230769f);
                    userInfoPostFeedTextInfo.setBgColor(Color.parseColor("#E67D89FF"));
                    userInfoPostFeedTextInfo.setItemOriginBigCorner(FeedMethods.a(12.6f));
                    userInfoPostFeedTextInfo.setItemOriginLittleCorner(FeedMethods.a(7.2f));
                    userInfoPostFeedTextInfo.setOriginLeftRightMargin(FeedMethods.a(16.1f));
                    userInfoPostFeedTextInfo.setOriginTopBottomMargin(FeedMethods.a(5.2f));
                    userInfoPostFeedTextInfo.setRealTextSize(11.9f);
                    userInfoPostFeedTextInfo.setSort(4);
                    userInfoPostFeedTextInfo.getContentList().addAll(CollectionsKt.c(new String[]{name}));
                    arrayList.add(userInfoPostFeedTextInfo);
                } else if (arrayList.size() == 2) {
                    userInfoPostFeedTextInfo.setFactor(0.7692308f);
                    userInfoPostFeedTextInfo.setBgColor(Color.parseColor("#CC7D89FF"));
                    userInfoPostFeedTextInfo.setItemOriginBigCorner(FeedMethods.a(11.1f));
                    userInfoPostFeedTextInfo.setItemOriginLittleCorner(FeedMethods.a(6.5f));
                    userInfoPostFeedTextInfo.setOriginLeftRightMargin(FeedMethods.a(13.2f));
                    userInfoPostFeedTextInfo.setOriginTopBottomMargin(FeedMethods.a(4.8f));
                    userInfoPostFeedTextInfo.setRealTextSize(10.6f);
                    userInfoPostFeedTextInfo.setSort(6);
                    userInfoPostFeedTextInfo.getContentList().addAll(CollectionsKt.c(new String[]{name}));
                    arrayList.add(userInfoPostFeedTextInfo);
                } else if (arrayList.size() == 3) {
                    userInfoPostFeedTextInfo.setFactor(0.74615383f);
                    userInfoPostFeedTextInfo.setBgColor(Color.parseColor("#B37D89FF"));
                    userInfoPostFeedTextInfo.setItemOriginBigCorner(FeedMethods.a(10.0f));
                    userInfoPostFeedTextInfo.setItemOriginLittleCorner(FeedMethods.a(6.0f));
                    userInfoPostFeedTextInfo.setOriginLeftRightMargin(FeedMethods.a(11.0f));
                    userInfoPostFeedTextInfo.setOriginTopBottomMargin(FeedMethods.a(4.0f));
                    userInfoPostFeedTextInfo.setRealTextSize(9.7f);
                    userInfoPostFeedTextInfo.setSort(5);
                    userInfoPostFeedTextInfo.getContentList().addAll(CollectionsKt.c(new String[]{name}));
                    arrayList.add(userInfoPostFeedTextInfo);
                } else if (arrayList.size() == 4) {
                    userInfoPostFeedTextInfo.setFactor(0.6769231f);
                    userInfoPostFeedTextInfo.setBgColor(Color.parseColor("#997D89FF"));
                    userInfoPostFeedTextInfo.setItemOriginBigCorner(FeedMethods.a(8.9f));
                    userInfoPostFeedTextInfo.setItemOriginLittleCorner(FeedMethods.a(5.5f));
                    userInfoPostFeedTextInfo.setOriginLeftRightMargin(FeedMethods.a(8.5f));
                    userInfoPostFeedTextInfo.setOriginTopBottomMargin(FeedMethods.a(3.7f));
                    userInfoPostFeedTextInfo.setRealTextSize(8.8f);
                    userInfoPostFeedTextInfo.setSort(3);
                    userInfoPostFeedTextInfo.getContentList().addAll(CollectionsKt.c(new String[]{name}));
                    arrayList.add(userInfoPostFeedTextInfo);
                } else if (arrayList.size() == 5) {
                    userInfoPostFeedTextInfo.setFactor(0.6f);
                    userInfoPostFeedTextInfo.setBgColor(Color.parseColor("#807D89FF"));
                    userInfoPostFeedTextInfo.setItemOriginBigCorner(FeedMethods.a(7.8f));
                    userInfoPostFeedTextInfo.setItemOriginLittleCorner(FeedMethods.a(4.5f));
                    userInfoPostFeedTextInfo.setOriginLeftRightMargin(FeedMethods.a(6.9f));
                    userInfoPostFeedTextInfo.setOriginTopBottomMargin(FeedMethods.a(3.5f));
                    userInfoPostFeedTextInfo.setRealTextSize(7.8f);
                    userInfoPostFeedTextInfo.setSort(1);
                    userInfoPostFeedTextInfo.getContentList().addAll(CollectionsKt.c(new String[]{name}));
                    arrayList.add(userInfoPostFeedTextInfo);
                }
            }
            i = i2 + 1;
        }
        Collections.sort(arrayList, new Comparator<UserInfoPostFeedTextInfo>() { // from class: com.soft.blued.ui.community.view.NearbyGuideDlgFragment$sortTagInfo$2
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(UserInfoPostFeedTextInfo userInfoPostFeedTextInfo2, UserInfoPostFeedTextInfo userInfoPostFeedTextInfo3) {
                Intrinsics.e(userInfoPostFeedTextInfo2, "o1");
                Intrinsics.e(userInfoPostFeedTextInfo3, "o2");
                return userInfoPostFeedTextInfo2.getSort() < userInfoPostFeedTextInfo3.getSort() ? -1 : 1;
            }
        });
        ArrayList<ArrayList<UserInfoPostFeedTextInfo>> arrayList2 = new ArrayList<>();
        ArrayList<UserInfoPostFeedTextInfo> arrayList3 = new ArrayList<>();
        ArrayList<UserInfoPostFeedTextInfo> arrayList4 = new ArrayList<>();
        Iterator it2 = arrayList.iterator();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (!it2.hasNext()) {
                arrayList2.add(arrayList3);
                arrayList2.add(arrayList4);
                a(arrayList2);
                return;
            }
            Object next2 = it2.next();
            if (i4 < 0) {
                CollectionsKt.c();
            }
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo2 = (UserInfoPostFeedTextInfo) next2;
            if (userInfoPostFeedTextInfo2.getSort() == 1 || userInfoPostFeedTextInfo2.getSort() == 2 || userInfoPostFeedTextInfo2.getSort() == 3) {
                arrayList3.add(userInfoPostFeedTextInfo2);
            } else {
                arrayList4.add(userInfoPostFeedTextInfo2);
            }
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(NearbyGuideDlgFragment nearbyGuideDlgFragment, View view, MotionEvent motionEvent) {
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        if (motionEvent.getAction() == 1) {
            nearbyGuideDlgFragment.a(motionEvent.getX());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        Tracker.onClick(view);
    }

    private final void b(CommBundleBuilder commBundleBuilder) {
        String str;
        String text;
        int c2 = FeedMethods.c(232);
        int c3 = FeedMethods.c(232);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setColor(Color.parseColor("#FF9300"));
        textPaint.setTextSize(FeedMethods.c(14));
        LogUtils.c("createAnniversaryPicFile. createBmp");
        try {
            Bitmap createBitmap = Bitmap.createBitmap(c2, c3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Bitmap a2 = ImageUtils.a((int) R.drawable.nearby_guide_anniversary_feed_bg, c2, c3);
            if (a2 != null) {
                canvas.drawBitmap(a2, new Rect(0, 0, a2.getWidth(), a2.getHeight()), new Rect(0, 0, c2, c3), paint);
            }
            ImageView imageView = this.x;
            Drawable drawable = imageView == null ? null : imageView.getDrawable();
            try {
                if (drawable == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap != null) {
                    LogUtils.c("createAnniversaryPicFile imgWidth: " + c2 + ", [" + bitmap.getWidth() + ',' + bitmap.getHeight() + ']');
                    float f = 1.0f;
                    int c4 = FeedMethods.c(94);
                    if (bitmap.getHeight() > 0) {
                        f = c4 / bitmap.getHeight();
                    }
                    int width = (int) (f * bitmap.getWidth());
                    LogUtils.c("createAnniversaryPicFile scaledWidth: " + width + ", scaledHeight:" + c4);
                    int i = (c2 - width) / 2;
                    int c5 = FeedMethods.c(45);
                    canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(i, c5, width + i, c4 + c5), paint);
                }
                NearbyGuideModel nearbyGuideModel = this.F;
                if (nearbyGuideModel != null && (text = nearbyGuideModel.getText()) != null) {
                    canvas.drawText(text, (c2 - textPaint.measureText(text)) / 2.0f, c3 - FeedMethods.c(54), textPaint);
                }
                String a3 = Intrinsics.a(RecyclingUtils.e("photo"), "/GuideAnniversarySendFeed.png");
                String str2 = a3;
                if (!ImageUtils.a(createBitmap, a3, Bitmap.CompressFormat.PNG)) {
                    str2 = "";
                }
                LogUtils.c(Intrinsics.a("createAnniversaryPicFile. imgPath: ", str2));
                if (!TextUtils.isEmpty(str2)) {
                    NewFeedModel newFeedModel = new NewFeedModel();
                    newFeedModel.setPics(str2);
                    newFeedModel.dontNeedCompress = true;
                    newFeedModel.tt_type = 6;
                    commBundleBuilder.a(newFeedModel);
                }
                LogUtils.c(Intrinsics.a("createAnniversaryPicFile. FeedAddPostFragment.show: ", str2));
            } catch (Exception e) {
                e = e;
                str = "createAnniversaryPicFile";
                LogUtils.a(str, e);
            } catch (OutOfMemoryError e2) {
                e = e2;
                LogUtils.a("createAnniversaryPicFile", e);
            }
        } catch (Exception e3) {
            e = e3;
            str = "createAnniversaryPicFile";
        } catch (OutOfMemoryError e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NearbyGuideDlgFragment nearbyGuideDlgFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        nearbyGuideDlgFragment.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NearbyGuideDlgFragment nearbyGuideDlgFragment, Boolean bool) {
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        nearbyGuideDlgFragment.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(NearbyGuideDlgFragment nearbyGuideDlgFragment) {
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        NearbyGuideModel nearbyGuideModel = nearbyGuideDlgFragment.F;
        if (nearbyGuideModel != null) {
            WebViewShowInfoFragment.show(nearbyGuideDlgFragment.getContext(), nearbyGuideModel.getUrl());
        }
        nearbyGuideDlgFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(NearbyGuideDlgFragment nearbyGuideDlgFragment) {
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        NearbyGuideModel nearbyGuideModel = nearbyGuideDlgFragment.F;
        if (nearbyGuideModel != null) {
            CommBundleBuilder commBundleBuilder = new CommBundleBuilder();
            commBundleBuilder.b(nearbyGuideModel.getType()).a(nearbyGuideDlgFragment.G);
            BluedTopic bluedTopic = null;
            if (nearbyGuideModel.getType() == 17) {
                nearbyGuideDlgFragment.a(commBundleBuilder);
                NearbyGuideModel nearbyGuideModel2 = nearbyGuideDlgFragment.F;
                if (nearbyGuideModel2 != null) {
                    bluedTopic = nearbyGuideModel2.getTopics_data();
                }
                nearbyGuideDlgFragment.H = bluedTopic;
            } else if (nearbyGuideModel.getType() == 19) {
                nearbyGuideDlgFragment.b(commBundleBuilder);
                NearbyGuideModel nearbyGuideModel3 = nearbyGuideDlgFragment.F;
                nearbyGuideDlgFragment.H = nearbyGuideModel3 == null ? null : nearbyGuideModel3.getTopics_data();
            }
            commBundleBuilder.a(nearbyGuideDlgFragment.H);
            FeedAddPostFragment.a(nearbyGuideDlgFragment.getContext(), commBundleBuilder);
        }
        nearbyGuideDlgFragment.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(NearbyGuideDlgFragment nearbyGuideDlgFragment) {
        Intrinsics.e(nearbyGuideDlgFragment, "this$0");
        View view = nearbyGuideDlgFragment.b;
        if (view != null) {
            view.setVisibility(0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 0f, 1f)");
            ObjectAnimator objectAnimator = ofFloat;
            objectAnimator.setDuration(500L);
            objectAnimator.start();
        }
        CardView cardView = nearbyGuideDlgFragment.f16112c;
        if (cardView == null) {
            return;
        }
        cardView.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(500L);
        cardView.startAnimation(translateAnimation);
    }

    private final void l() {
        View d = d();
        this.b = d == null ? null : d.findViewById(R.id.nearby_common_guide_bg_ly_id);
        View d2 = d();
        this.f16112c = d2 == null ? null : (CardView) d2.findViewById(R.id.nearby_common_guide_content_ly_id);
        View d3 = d();
        this.d = d3 == null ? null : d3.findViewById(R.id.nearby_common_guide_content_bg_id);
        View d4 = d();
        this.e = d4 == null ? null : d4.findViewById(R.id.nearby_common_guide_bottom_ly);
        View d5 = d();
        this.g = d5 == null ? null : (ImageView) d5.findViewById(R.id.nearby_common_guide_close_iv);
        View d6 = d();
        this.f = d6 == null ? null : (TextView) d6.findViewById(R.id.nearby_common_guide_title_tv);
        View d7 = d();
        this.h = d7 == null ? null : (TextView) d7.findViewById(R.id.nearby_common_guide_des_tv);
        View d8 = d();
        this.i = d8 == null ? null : (TextView) d8.findViewById(R.id.nearby_common_guide_confirm_tv);
        View d9 = d();
        this.j = d9 == null ? null : (ImageView) d9.findViewById(R.id.nearby_common_guide_op_iv);
        View d10 = d();
        this.k = d10 == null ? null : (RecyclerView) d10.findViewById(R.id.nearby_common_guide_rv);
        View d11 = d();
        this.m = d11 == null ? null : (ImageView) d11.findViewById(R.id.nearby_common_guide_selected_iv);
        n();
        View d12 = d();
        this.p = d12 == null ? null : d12.findViewById(R.id.nearby_common_guide_qa_layout);
        View d13 = d();
        this.q = d13 == null ? null : (TextView) d13.findViewById(R.id.nearby_common_guide_qa_tv);
        View d14 = d();
        this.r = d14 == null ? null : d14.findViewById(R.id.nearby_common_guide_qa_cv_layout);
        View d15 = d();
        this.s = d15 == null ? null : (CardView) d15.findViewById(R.id.nearby_common_guide_qa_cv_2);
        View view = this.p;
        if (view != null) {
            view.setVisibility(8);
        }
        View d16 = d();
        this.t = d16 == null ? null : d16.findViewById(R.id.guide_layout);
        View d17 = d();
        this.u = d17 == null ? null : (ImageView) d17.findViewById(R.id.pop_guide_iv);
        View d18 = d();
        this.v = d18 == null ? null : (ImageView) d18.findViewById(R.id.nearby_common_guide_birthday_avatar);
        View d19 = d();
        this.w = d19 == null ? null : d19.findViewById(R.id.nearby_common_guide_birthday_avatar_lo);
        View d20 = d();
        this.x = d20 == null ? null : (ImageView) d20.findViewById(R.id.nearby_common_guide_fg_iv);
        View d21 = d();
        this.y = d21 == null ? null : (ImageView) d21.findViewById(R.id.nearby_common_guide_op_iv_big);
        View d22 = d();
        this.z = d22 == null ? null : (FrameLayout) d22.findViewById(R.id.nearby_common_guide_op_view_big);
        View d23 = d();
        this.A = d23 == null ? null : (LinearLayout) d23.findViewById(R.id.no_post_feed_view);
        View d24 = d();
        this.B = d24 == null ? null : (LinearLayout) d24.findViewById(R.id.ll_tag_1);
        View d25 = d();
        this.C = d25 == null ? null : (LinearLayout) d25.findViewById(R.id.ll_tag_2);
        boolean s = CommunityManager.a.a().s();
        this.E = s;
        if (s) {
            CardView cardView = this.f16112c;
            if (cardView != null) {
                cardView.setCardBackgroundColor(getResources().getColor(2131101478));
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.nearby_common_guide_close);
            }
            TextView textView = this.f;
            if (textView == null) {
                return;
            }
            textView.setTextColor(getResources().getColor(2131101681));
            return;
        }
        CardView cardView2 = this.f16112c;
        if (cardView2 != null) {
            cardView2.setCardBackgroundColor(getResources().getColor(2131102478));
        }
        ImageView imageView2 = this.g;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.nearby_common_guide_close_black);
        }
        TextView textView2 = this.f;
        if (textView2 == null) {
            return;
        }
        textView2.setTextColor(getResources().getColor(2131101836));
    }

    private final void m() {
        View view = this.b;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$yf1kZzZ6na4Ky6kw0414JRa7dds
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NearbyGuideDlgFragment.b(view2);
                }
            });
        }
        View view2 = this.b;
        if (view2 != null) {
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$bQo2-duBkZu-SfxDeW6cde00DUo
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean a2;
                    a2 = NearbyGuideDlgFragment.a(view3, motionEvent);
                    return a2;
                }
            });
        }
        View view3 = this.e;
        if (view3 != null) {
            view3.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$YGw14EXEFB_i51KHyTx37K9uzC8
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view4, MotionEvent motionEvent) {
                    boolean a2;
                    a2 = NearbyGuideDlgFragment.a(NearbyGuideDlgFragment.this, view4, motionEvent);
                    return a2;
                }
            });
        }
        CardView cardView = this.f16112c;
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$CYo6d77i_zLfYXVIdeWs6RUSbeo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    NearbyGuideDlgFragment.c(view4);
                }
            });
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$XpqQHvczUoz3Km2UfOHdSKvss0c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    NearbyGuideDlgFragment.a(NearbyGuideDlgFragment.this, view4);
                }
            });
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$N-8Te5WDk-V0crC24uZRt34icIk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    NearbyGuideDlgFragment.b(NearbyGuideDlgFragment.this, view4);
                }
            });
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get("NearbyGuideDlgShowCloseGuide", Boolean.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$b9K6b3JI5OISyX-BAMuC-MPtJzU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyGuideDlgFragment.a(NearbyGuideDlgFragment.this, (Boolean) obj);
            }
        });
        LiveEventBus.get("NearbyGuideDlgHideCloseGuide", Boolean.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$LQlXdSaHuEny4crbOzvfjLkY4a0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NearbyGuideDlgFragment.b(NearbyGuideDlgFragment.this, (Boolean) obj);
            }
        });
    }

    private final void n() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.o = linearLayoutManager;
        RecyclerView recyclerView = this.k;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.k;
        if (recyclerView2 != null) {
            recyclerView2.setHasFixedSize(true);
        }
        if (s()) {
            LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
            this.l = linearSnapHelper;
            if (linearSnapHelper != null) {
                linearSnapHelper.attachToRecyclerView(this.k);
            }
            ImageView imageView = this.m;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            ImageView imageView2 = this.m;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        RecyclerView recyclerView3 = this.k;
        if (recyclerView3 != null) {
            recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.community.view.NearbyGuideDlgFragment$initRecycleView$1
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
                    r0 = r4.f16114a.o;
                 */
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r5, int r6) {
                    /*
                        r4 = this;
                        r0 = r5
                        java.lang.String r1 = "recyclerView"
                        kotlin.jvm.internal.Intrinsics.e(r0, r1)
                        r0 = r4
                        r1 = r5
                        r2 = r6
                        super.onScrollStateChanged(r1, r2)
                        r0 = r6
                        if (r0 != 0) goto L9b
                        r0 = r4
                        com.soft.blued.ui.community.view.NearbyGuideDlgFragment r0 = com.soft.blued.ui.community.view.NearbyGuideDlgFragment.this
                        androidx.recyclerview.widget.LinearLayoutManager r0 = com.soft.blued.ui.community.view.NearbyGuideDlgFragment.a(r0)
                        r5 = r0
                        r0 = r5
                        if (r0 != 0) goto L1d
                        return
                    L1d:
                        r0 = r4
                        com.soft.blued.ui.community.view.NearbyGuideDlgFragment r0 = com.soft.blued.ui.community.view.NearbyGuideDlgFragment.this
                        r8 = r0
                        r0 = r8
                        androidx.recyclerview.widget.LinearSnapHelper r0 = com.soft.blued.ui.community.view.NearbyGuideDlgFragment.d(r0)
                        r9 = r0
                        r0 = 0
                        r7 = r0
                        r0 = r9
                        if (r0 != 0) goto L36
                        r0 = 0
                        r5 = r0
                        goto L40
                    L36:
                        r0 = r9
                        r1 = r5
                        androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
                        android.view.View r0 = r0.findSnapView(r1)
                        r5 = r0
                    L40:
                        r0 = r5
                        if (r0 != 0) goto L45
                        return
                    L45:
                        r0 = r8
                        androidx.recyclerview.widget.RecyclerView r0 = com.soft.blued.ui.community.view.NearbyGuideDlgFragment.c(r0)
                        r9 = r0
                        r0 = r9
                        if (r0 != 0) goto L56
                        r0 = r7
                        r5 = r0
                        goto L60
                    L56:
                        r0 = r9
                        r1 = r5
                        int r0 = r0.getChildAdapterPosition(r1)
                        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                        r5 = r0
                    L60:
                        r0 = r5
                        if (r0 != 0) goto L65
                        return
                    L65:
                        r0 = r5
                        java.lang.Number r0 = (java.lang.Number) r0
                        int r0 = r0.intValue()
                        r6 = r0
                        r0 = r8
                        com.blued.community.model.NearbyGuideModel r0 = com.soft.blued.ui.community.view.NearbyGuideDlgFragment.b(r0)
                        r5 = r0
                        r0 = r5
                        if (r0 != 0) goto L78
                        return
                    L78:
                        r0 = r5
                        java.util.ArrayList r0 = r0.getBubble_data()
                        r5 = r0
                        r0 = r5
                        if (r0 != 0) goto L82
                        return
                    L82:
                        r0 = r6
                        if (r0 < 0) goto L9b
                        r0 = r6
                        r1 = r5
                        int r1 = r1.size()
                        if (r0 >= r1) goto L9b
                        r0 = r8
                        r1 = r5
                        r2 = r6
                        java.lang.Object r1 = r1.get(r2)
                        com.blued.community.ui.send.model.FeedPostSignStateItem r1 = (com.blued.community.ui.send.model.FeedPostSignStateItem) r1
                        com.soft.blued.ui.community.view.NearbyGuideDlgFragment.a(r0, r1)
                    L9b:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.community.view.NearbyGuideDlgFragment$initRecycleView$1.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
                }
            });
        }
        NearbyGuideDlgFragment$initRecycleView$2 nearbyGuideDlgFragment$initRecycleView$2 = new NearbyGuideDlgFragment$initRecycleView$2(this);
        this.n = nearbyGuideDlgFragment$initRecycleView$2;
        RecyclerView recyclerView4 = this.k;
        if (recyclerView4 == null) {
            return;
        }
        recyclerView4.setAdapter(nearbyGuideDlgFragment$initRecycleView$2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:191:0x0523, code lost:
        if (r0 >= r0.size()) goto L187;
     */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0c35  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0c4e  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0c66  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0c9d  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0cb5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void o() {
        /*
            Method dump skipped, instructions count: 3294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.community.view.NearbyGuideDlgFragment.o():void");
    }

    private final void p() {
        View view = this.w;
        if (view != null) {
            view.setVisibility(0);
        }
        NearbyGuideModel nearbyGuideModel = this.F;
        String avatar = nearbyGuideModel == null ? null : nearbyGuideModel.getAvatar();
        String str = avatar;
        if (TextUtils.isEmpty(avatar)) {
            str = UserInfoUtils.e();
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        ImageLoader.a(a(), str2).a(40.0f).b((int) R.drawable.icon_default_user_avatar).d((int) R.drawable.icon_default_user_avatar).a(this.v);
        ImageView imageView = this.j;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(R.drawable.nearby_guide_birthday_bg);
    }

    private final void q() {
        ImageView imageView = this.x;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = FeedMethods.c(203);
            marginLayoutParams.height = FeedMethods.c(94);
            imageView.setLayoutParams(marginLayoutParams);
            imageView.setVisibility(0);
        }
        NearbyGuideModel nearbyGuideModel = this.F;
        if ((nearbyGuideModel == null ? null : nearbyGuideModel.getImage()) != null) {
            IRequestHost a2 = a();
            NearbyGuideModel nearbyGuideModel2 = this.F;
            String image = nearbyGuideModel2 == null ? null : nearbyGuideModel2.getImage();
            Intrinsics.a(image);
            ImageLoader.a(a2, image).a(this.x);
        }
        ImageView imageView2 = this.j;
        if (imageView2 == null) {
            return;
        }
        imageView2.setImageResource(R.drawable.nearby_guide_anniversary_bg);
    }

    private final int r() {
        return new Random().nextInt(4) + 6;
    }

    private final boolean s() {
        NearbyGuideModel nearbyGuideModel = this.F;
        boolean z = false;
        if (nearbyGuideModel == null) {
            return false;
        }
        if (nearbyGuideModel.getType() == 3 || nearbyGuideModel.getType() == 2 || nearbyGuideModel.getType() == 7 || nearbyGuideModel.getType() == 15) {
            z = true;
        }
        return z;
    }

    private final void t() {
        final FeedPostSignStateItem feedPostSignStateItem;
        final Context context = getContext();
        if (context != null && (feedPostSignStateItem = this.D) != null) {
            a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$kMDNSXffDAmPC4YDc8baJrXAUWU
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyGuideDlgFragment.y();
                }
            }, 50L);
            a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$-3OtCXAsiysqA6aR5wiWVi-2FnA
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyGuideDlgFragment.a(Context.this);
                }
            }, 100L);
            a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$dvMrhfVIYtertJDgfy8rJnJV6Ak
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyGuideDlgFragment.a(feedPostSignStateItem, context, this);
                }
            }, 250L);
            this.I = feedPostSignStateItem.getBubble_state_id();
        }
        CommunityPreferences.c(0L);
    }

    private final void u() {
        ArrayList bubble_data;
        int i;
        FeedPostSignStateItem feedPostSignStateItem;
        RecyclerView recyclerView;
        NearbyGuideModel nearbyGuideModel = this.F;
        if (nearbyGuideModel == null || (bubble_data = nearbyGuideModel.getBubble_data()) == null) {
            return;
        }
        int i2 = -1;
        Iterator it = bubble_data.iterator();
        while (true) {
            i = i2;
            feedPostSignStateItem = null;
            if (!it.hasNext()) {
                break;
            }
            feedPostSignStateItem = (FeedPostSignStateItem) it.next();
            i = i2 + 1;
            i2 = i;
            if (feedPostSignStateItem.getCheck() == 1) {
                LogUtils.c(Intrinsics.a("模态弹层冒泡默认选中：", Integer.valueOf(i)));
                break;
            }
        }
        CommonMultiItemAdapter<FeedPostSignStateItem> commonMultiItemAdapter = this.n;
        if (commonMultiItemAdapter != null) {
            commonMultiItemAdapter.setDataAndNotify(bubble_data);
        }
        if (feedPostSignStateItem != null) {
            a(feedPostSignStateItem);
        }
        if (i < 0 || (recyclerView = this.k) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(i);
    }

    private final void v() {
        if (s()) {
            t();
        } else {
            NearbyGuideModel nearbyGuideModel = this.F;
            if (nearbyGuideModel != null) {
                Intrinsics.a(nearbyGuideModel);
                if (!TextUtils.isEmpty(nearbyGuideModel.getUrl())) {
                    a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$kMU7oFANTAt5S6Roak4pbJUIexg
                        @Override // java.lang.Runnable
                        public final void run() {
                            NearbyGuideDlgFragment.z();
                        }
                    }, 20L);
                    a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$ytSVJz9WwY05to2WLfAUUZVXuzY
                        @Override // java.lang.Runnable
                        public final void run() {
                            NearbyGuideDlgFragment.g(NearbyGuideDlgFragment.this);
                        }
                    }, 70L);
                }
            }
            NearbyGuideModel nearbyGuideModel2 = this.F;
            if (nearbyGuideModel2 != null) {
                Intrinsics.a(nearbyGuideModel2);
                if (nearbyGuideModel2.getType() == 18 && this.A != null) {
                    NewFeedModel newFeedModel = new NewFeedModel();
                    newFeedModel.setLoadName(CommonStringUtils.c(UserInfoUtils.c()));
                    String a2 = Intrinsics.a(RecyclingUtils.e("photo"), "/noPostedFeedGuide.png");
                    LinearLayout linearLayout = this.A;
                    Intrinsics.a(linearLayout);
                    if (!ImageUtils.a(a(linearLayout), a2, Bitmap.CompressFormat.PNG)) {
                        return;
                    }
                    newFeedModel.localPath = a2;
                    newFeedModel.setPics(a2);
                    newFeedModel.setSize(1);
                    newFeedModel.setContent("");
                    newFeedModel.setState(1);
                    newFeedModel.setTime(System.currentTimeMillis());
                    newFeedModel.is_label = 1;
                    newFeedModel.tt_type = 4;
                    newFeedModel.is_super_topics = 1;
                    NearbyGuideModel nearbyGuideModel3 = this.F;
                    Intrinsics.a(nearbyGuideModel3);
                    BluedTopic topics_data = nearbyGuideModel3.getTopics_data();
                    if (topics_data != null) {
                        if (!TextUtils.isEmpty(topics_data.super_did)) {
                            newFeedModel.super_did = topics_data.super_did;
                        }
                        if (!TextUtils.isEmpty(topics_data.name)) {
                            newFeedModel.super_topics_name = topics_data.name;
                        }
                    }
                    newFeedModel.feed_pics_width = "696";
                    newFeedModel.feed_pics_height = "696";
                    newFeedModel.showNotificationWhenSend = 1;
                    newFeedModel.dontNeedCompress = true;
                    CommunityServiceManager.e().a(false);
                    FeedSendManager.a().a(newFeedModel);
                    FeedMethods.c();
                    dismissAllowingStateLoss();
                }
            }
            a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$-RmDg3fDF2gnQHwCkV_qwhrdJro
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyGuideDlgFragment.A();
                }
            }, 20L);
            a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$_drF4rIh-L8RNbGIE877MtvOfyw
                @Override // java.lang.Runnable
                public final void run() {
                    NearbyGuideDlgFragment.h(NearbyGuideDlgFragment.this);
                }
            }, 70L);
        }
        CommunityPreferences.c(0L);
        NearbyGuideModel nearbyGuideModel4 = this.F;
        if (nearbyGuideModel4 == null) {
            return;
        }
        EventTrackFeed.a(FeedProtos.Event.CITY_HOME_POP_BTN_CLICK, nearbyGuideModel4.getType(), nearbyGuideModel4.getSubType(), this.I, this.H);
    }

    private final void w() {
        a(new Runnable() { // from class: com.soft.blued.ui.community.view.-$$Lambda$NearbyGuideDlgFragment$LdqnLQC10krgQOXDtOlSROgpbtg
            @Override // java.lang.Runnable
            public final void run() {
                NearbyGuideDlgFragment.i(NearbyGuideDlgFragment.this);
            }
        }, 50L);
    }

    private final void x() {
        View view = this.b;
        if (view != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 0.0f);
            Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 0.5f, 0f)");
            ObjectAnimator objectAnimator = ofFloat;
            objectAnimator.setDuration(500L);
            objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.community.view.NearbyGuideDlgFragment$dismissAnim$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.e(animator, "animation");
                    NearbyGuideDlgFragment.this.dismissAllowingStateLoss();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.e(animator, "animation");
                }
            });
            objectAnimator.start();
        }
        CardView cardView = this.f16112c;
        if (cardView == null) {
            return;
        }
        cardView.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(500L);
        cardView.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y() {
        NearbyFindSetSelectedTab.a().a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z() {
        NearbyFindSetSelectedTab.a().a(1);
    }

    public int e() {
        return R.layout.nearby_common_guide_layout;
    }

    public void f() {
        super.f();
        Bundle arguments = getArguments();
        this.F = arguments == null ? null : arguments.getSerializable("guide_model");
    }

    public void i() {
        x();
    }

    public final void j() {
        LogUtils.c("显示关闭引导");
        View view = this.t;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageLoader.c(a(), "sign_feed_set_guide_update_hand.png").f().g(-1).a(this.u);
        LiveEventBus.get("NearbyGuideDlgHideCloseGuide").postDelay(true, m.ag);
    }

    public final void k() {
        LogUtils.c("隐藏关闭引导");
        View view = this.t;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, a.B);
        super.onViewCreated(view, bundle);
        l();
        m();
        o();
        w();
        LiveEventBus.get("NearbyGuideDlgShowCloseGuide").postDelay(true, 4000L);
    }
}
