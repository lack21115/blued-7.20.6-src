package com.soft.blued.ui.setting.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.common.CommFullScreenDialog;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.model.FeedIntroduceExtra;
import com.blued.community.ui.send.model.FeedIntroduceModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.UserInfoUtils;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentUserInfoPostFeedBinding;
import com.soft.blued.ui.setting.model.UserInfoPostFeedItemLayoutInfo;
import com.soft.blued.ui.setting.model.UserInfoPostFeedTextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/UserInfoPostFeedDlgFragment.class */
public final class UserInfoPostFeedDlgFragment extends CommFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private FragmentUserInfoPostFeedBinding f33624a;
    private Bitmap b;
    private int f;
    private int g;
    private BluedTopic l;
    private float n;
    private float o;

    /* renamed from: c  reason: collision with root package name */
    private Paint f33625c = new Paint();
    private TextPaint d = new TextPaint();
    private float e = FeedMethods.a(11.0f);
    private final int h = FeedMethods.c(247);
    private final int i = FeedMethods.c(249);
    private final int j = FeedMethods.c(170);
    private int k = FeedMethods.a(6.0f);
    private final ArrayList<UserInfoPostFeedTextInfo> m = new ArrayList<>();
    private float p = 1.0f;

    public UserInfoPostFeedDlgFragment() {
        this.f = FeedMethods.c(335);
        this.g = FeedMethods.c(321);
        this.f33625c.setDither(true);
        this.f33625c.setAntiAlias(true);
        this.f33625c.setStyle(Paint.Style.FILL_AND_STROKE);
        this.d.setAntiAlias(true);
        this.d.setColor(-1);
        int c2 = AppInfo.l - FeedMethods.c(40);
        this.f = c2;
        this.g = (int) ((c2 * 321) / 335.0f);
    }

    private final void a(Canvas canvas, UserInfoPostFeedTextInfo userInfoPostFeedTextInfo, UserInfoPostFeedItemLayoutInfo userInfoPostFeedItemLayoutInfo) {
        float width = userInfoPostFeedItemLayoutInfo.getWidth();
        float height = userInfoPostFeedItemLayoutInfo.getHeight();
        Path path = new Path();
        float itemBigCorner = userInfoPostFeedTextInfo.getItemBigCorner();
        float itemLittleCorner = userInfoPostFeedTextInfo.getItemLittleCorner();
        path.lineTo(0.0f, itemBigCorner);
        float f = 2;
        float f2 = itemBigCorner * f;
        path.arcTo(new RectF(0.0f, 0.0f, f2, f2), 180.0f, 90.0f, true);
        path.lineTo(0.0f, 0.0f);
        path.moveTo(width, 0.0f);
        path.lineTo(width, itemLittleCorner);
        float f3 = f * itemLittleCorner;
        path.arcTo(new RectF(width - f3, 0.0f, width, f3), 270.0f, 90.0f, true);
        path.lineTo(width, 0.0f);
        path.moveTo(width, height);
        path.lineTo(width - itemBigCorner, itemLittleCorner);
        path.arcTo(new RectF(width - f2, height - f2, width, height), 0.0f, 90.0f, true);
        path.lineTo(width, height);
        path.moveTo(0.0f, height);
        path.lineTo(0.0f, height - itemLittleCorner);
        path.arcTo(new RectF(0.0f, height - f3, f3, height), 90.0f, 90.0f, true);
        path.lineTo(0.0f, height);
        path.close();
        Path path2 = new Path();
        path2.addRect(new RectF(0.0f, 0.0f, width, height), Path.Direction.CW);
        path2.close();
        path2.op(path, Path.Op.DIFFERENCE);
        canvas.save();
        canvas.translate(userInfoPostFeedItemLayoutInfo.getStartX(), userInfoPostFeedItemLayoutInfo.getStartY());
        canvas.drawPath(path2, this.f33625c);
        canvas.drawText(userInfoPostFeedItemLayoutInfo.getContent(), userInfoPostFeedTextInfo.getLeftRightMargin(), (height - userInfoPostFeedTextInfo.getTopBottomMargin()) - ((FeedMethods.a(1.2f) * userInfoPostFeedTextInfo.getFactor()) * this.p), this.d);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserInfoPostFeedDlgFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.i();
        EventTrackFeed.c(FeedProtos.Event.FEED_GUIDE_EDIT_PROFILE_POP_NO_CLICK);
    }

    private final void a(UserInfoPostFeedTextInfo userInfoPostFeedTextInfo) {
        ArrayList<String> contentList = userInfoPostFeedTextInfo.getContentList();
        userInfoPostFeedTextInfo.setArrayTextWidth(new float[contentList.size()]);
        userInfoPostFeedTextInfo.setArrayItemWidth(new float[contentList.size()]);
        int size = userInfoPostFeedTextInfo.getContentList().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            userInfoPostFeedTextInfo.setRealTextSize(this.e * userInfoPostFeedTextInfo.getFactor() * this.p);
            userInfoPostFeedTextInfo.setItemBigCorner(userInfoPostFeedTextInfo.getItemOriginBigCorner() * this.p);
            userInfoPostFeedTextInfo.setItemLittleCorner(userInfoPostFeedTextInfo.getItemOriginLittleCorner() * this.p);
            userInfoPostFeedTextInfo.setTopBottomMargin(userInfoPostFeedTextInfo.getOriginTopBottomMargin() * this.p);
            userInfoPostFeedTextInfo.setLeftRightMargin(userInfoPostFeedTextInfo.getOriginLeftRightMargin() * this.p);
            float f = 2;
            userInfoPostFeedTextInfo.setArrayItemHeight(userInfoPostFeedTextInfo.getRealTextSize() + (userInfoPostFeedTextInfo.getTopBottomMargin() * f));
            this.d.setTextSize(userInfoPostFeedTextInfo.getRealTextSize());
            userInfoPostFeedTextInfo.getArrayTextWidth()[i2] = this.d.measureText(userInfoPostFeedTextInfo.getContentList().get(i2));
            userInfoPostFeedTextInfo.getArrayItemWidth()[i2] = RangesKt.b(userInfoPostFeedTextInfo.getArrayTextWidth()[i2] + (userInfoPostFeedTextInfo.getLeftRightMargin() * f), this.j);
            i = i2 + 1;
        }
    }

    private final void a(ArrayList<UserInfoPostFeedTextInfo> arrayList) {
        float f;
        int size = arrayList.size();
        float f2 = 0.0f;
        for (int i = 0; i < size; i++) {
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo = arrayList.get(i);
            Intrinsics.c(userInfoPostFeedTextInfo, "infoList[index]");
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo2 = userInfoPostFeedTextInfo;
            this.n += f2;
            if (i > 0 && (!userInfoPostFeedTextInfo2.getContentList().isEmpty())) {
                this.n += this.k;
            }
            userInfoPostFeedTextInfo2.getLayoutInfo().clear();
            int size2 = userInfoPostFeedTextInfo2.getContentList().size();
            int i2 = 0;
            int i3 = 0;
            float f3 = 0.0f;
            while (i2 < size2) {
                float a2 = FeedMethods.a((((int) (SystemClock.elapsedRealtime() % 13)) / 2.0f) + 6);
                if (i2 == 0) {
                    a2 = 0.0f;
                }
                int i4 = i3;
                float f4 = f3;
                if (i2 > 0) {
                    i4 = i3;
                    f4 = f3;
                    if (i2 % 3 == 0) {
                        i4 = i3 + 1;
                        this.n += f2 + this.k;
                        f4 = 0.0f;
                    }
                }
                if (userInfoPostFeedTextInfo2.getLayoutInfo().size() <= i4) {
                    userInfoPostFeedTextInfo2.getLayoutInfo().add(new ArrayList<>());
                }
                UserInfoPostFeedItemLayoutInfo userInfoPostFeedItemLayoutInfo = new UserInfoPostFeedItemLayoutInfo();
                String str = userInfoPostFeedTextInfo2.getContentList().get(i2);
                Intrinsics.c(str, "info.contentList[i]");
                userInfoPostFeedItemLayoutInfo.setContent(str);
                userInfoPostFeedItemLayoutInfo.setWidth(userInfoPostFeedTextInfo2.getArrayItemWidth()[i2]);
                userInfoPostFeedItemLayoutInfo.setHeight(userInfoPostFeedTextInfo2.getArrayItemHeight());
                if (f4 == 0.0f) {
                    a2 = 0.0f;
                }
                userInfoPostFeedItemLayoutInfo.setStartX(f4 + a2);
                userInfoPostFeedItemLayoutInfo.setStartY(this.n);
                userInfoPostFeedItemLayoutInfo.setArrayDivider(a2);
                f3 = f4 + userInfoPostFeedItemLayoutInfo.getWidth() + a2;
                userInfoPostFeedTextInfo2.getLayoutInfo().get(i4).add(userInfoPostFeedItemLayoutInfo);
                this.o = RangesKt.a(this.o, f3);
                f2 = userInfoPostFeedTextInfo2.getArrayItemHeight();
                i2++;
                i3 = i4;
            }
        }
        this.n += f2;
        Iterator<UserInfoPostFeedTextInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<ArrayList<UserInfoPostFeedItemLayoutInfo>> it2 = it.next().getLayoutInfo().iterator();
            while (it2.hasNext()) {
                ArrayList<UserInfoPostFeedItemLayoutInfo> next = it2.next();
                Iterator<UserInfoPostFeedItemLayoutInfo> it3 = next.iterator();
                float f5 = 0.0f;
                while (true) {
                    f = f5;
                    if (!it3.hasNext()) {
                        break;
                    }
                    UserInfoPostFeedItemLayoutInfo next2 = it3.next();
                    f5 = f + next2.getWidth() + next2.getArrayDivider();
                }
                float f6 = 2;
                float f7 = (this.f - f) / f6;
                float f8 = (this.g - this.n) / f6;
                Iterator<UserInfoPostFeedItemLayoutInfo> it4 = next.iterator();
                while (it4.hasNext()) {
                    UserInfoPostFeedItemLayoutInfo next3 = it4.next();
                    next3.setStartX(next3.getStartX() + f7);
                    next3.setStartY(next3.getStartY() + f8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UserInfoPostFeedDlgFragment this$0) {
        final ShapeFrameLayout shapeFrameLayout;
        ShapeFrameLayout shapeFrameLayout2;
        Intrinsics.e(this$0, "this$0");
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding = this$0.f33624a;
        if (fragmentUserInfoPostFeedBinding != null && (shapeFrameLayout2 = fragmentUserInfoPostFeedBinding.f28995a) != null) {
            shapeFrameLayout2.setVisibility(0);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(200L);
            shapeFrameLayout2.startAnimation(scaleAnimation);
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding2 = this$0.f33624a;
        if (fragmentUserInfoPostFeedBinding2 == null || (shapeFrameLayout = fragmentUserInfoPostFeedBinding2.f28995a) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(shapeFrameLayout, "alpha", 0.1f, 1.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 0.1f, 1f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.setting.fragment.UserInfoPostFeedDlgFragment$showAnim$1$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ShapeFrameLayout.this.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UserInfoPostFeedDlgFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.q();
    }

    private final void m() {
        ImageView imageView;
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        ShapeLinearLayout shapeLinearLayout;
        ShapeFrameLayout shapeFrameLayout;
        boolean s = CommunityManager.f19086a.a().s();
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding = this.f33624a;
        if (fragmentUserInfoPostFeedBinding != null && (shapeFrameLayout = fragmentUserInfoPostFeedBinding.f28995a) != null) {
            ShapeModel shapeModel = shapeFrameLayout.getShapeModel();
            ShapeModel shapeModel2 = shapeModel;
            if (shapeModel == null) {
                shapeModel2 = new ShapeModel();
            }
            shapeModel2.t = Color.parseColor(s ? "#222326" : "#F1F2FF");
            shapeModel2.v = Color.parseColor(s ? "#151515" : "#FFFFFF");
            shapeFrameLayout.setShapeModel(shapeModel2);
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding2 = this.f33624a;
        if (fragmentUserInfoPostFeedBinding2 != null && (shapeLinearLayout = fragmentUserInfoPostFeedBinding2.f) != null) {
            ShapeModel shapeModel3 = shapeLinearLayout.getShapeModel();
            ShapeModel shapeModel4 = shapeModel3;
            if (shapeModel3 == null) {
                shapeModel4 = new ShapeModel();
            }
            shapeModel4.n = Color.parseColor(s ? "#4C4C4C" : "#C1C1C1");
            shapeLinearLayout.setShapeModel(shapeModel4);
        }
        p();
        View d = d();
        if (d != null) {
            d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$UserInfoPostFeedDlgFragment$OZHquHV3pkwcOimCO3d82nIg6q8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoPostFeedDlgFragment.a(view);
                }
            });
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding3 = this.f33624a;
        if (fragmentUserInfoPostFeedBinding3 != null && (shapeTextView2 = fragmentUserInfoPostFeedBinding3.b) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$UserInfoPostFeedDlgFragment$EPQeZ5Kx9LnJOVcT2cWWZIBs0jA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoPostFeedDlgFragment.a(UserInfoPostFeedDlgFragment.this, view);
                }
            });
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding4 = this.f33624a;
        if (fragmentUserInfoPostFeedBinding4 != null && (shapeTextView = fragmentUserInfoPostFeedBinding4.g) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$UserInfoPostFeedDlgFragment$RwTkZSPM2ekfaxP3t8ka_5tQlV0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoPostFeedDlgFragment.b(UserInfoPostFeedDlgFragment.this, view);
                }
            });
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding5 = this.f33624a;
        if (fragmentUserInfoPostFeedBinding5 == null || (imageView = fragmentUserInfoPostFeedBinding5.f28996c) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = this.g;
        imageView.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        ImageView imageView;
        ImageView imageView2;
        BluedTopic bluedTopic = this.l;
        if (bluedTopic == null) {
            return;
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding = this.f33624a;
        ShapeLinearLayout shapeLinearLayout = fragmentUserInfoPostFeedBinding == null ? null : fragmentUserInfoPostFeedBinding.f;
        if (shapeLinearLayout != null) {
            shapeLinearLayout.setVisibility(0);
        }
        if (bluedTopic.is_anonym == 1) {
            FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding2 = this.f33624a;
            if (fragmentUserInfoPostFeedBinding2 != null && (imageView2 = fragmentUserInfoPostFeedBinding2.d) != null) {
                imageView2.setImageResource(2131233033);
            }
        } else {
            FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding3 = this.f33624a;
            if (fragmentUserInfoPostFeedBinding3 != null && (imageView = fragmentUserInfoPostFeedBinding3.d) != null) {
                imageView.setImageResource(2131232711);
            }
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding4 = this.f33624a;
        TextView textView = fragmentUserInfoPostFeedBinding4 == null ? null : fragmentUserInfoPostFeedBinding4.h;
        if (textView == null) {
            return;
        }
        textView.setText(bluedTopic.name);
    }

    private final void o() {
        ShapeFrameLayout shapeFrameLayout;
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding = this.f33624a;
        if (fragmentUserInfoPostFeedBinding == null || (shapeFrameLayout = fragmentUserInfoPostFeedBinding.f28995a) == null) {
            return;
        }
        shapeFrameLayout.postDelayed(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$UserInfoPostFeedDlgFragment$VVLb4IY1LjEVbjAFKl4Cr6FU-Mg
            @Override // java.lang.Runnable
            public final void run() {
                UserInfoPostFeedDlgFragment.b(UserInfoPostFeedDlgFragment.this);
            }
        }, 50L);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0098 A[LOOP:0: B:22:0x0098->B:31:0x0100, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018f A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void p() {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.setting.fragment.UserInfoPostFeedDlgFragment.p():void");
    }

    private final void q() {
        NewFeedModel newFeedModel = new NewFeedModel();
        newFeedModel.setLoadName(CommonStringUtils.c(UserInfoUtils.c()));
        String a2 = Intrinsics.a(RecyclingUtils.e("photo"), (Object) "/userInfoPostFeed.png");
        if (ImageUtils.a(this.b, a2, Bitmap.CompressFormat.PNG)) {
            newFeedModel.localPath = a2;
            newFeedModel.setPics(a2);
            newFeedModel.setSize(1);
            newFeedModel.setContent("");
            newFeedModel.setState(1);
            newFeedModel.setTime(System.currentTimeMillis());
            newFeedModel.is_label = 1;
            newFeedModel.tt_type = 4;
            newFeedModel.showNotificationWhenSend = 1;
            newFeedModel.dontNeedCompress = true;
            BluedTopic bluedTopic = this.l;
            if (bluedTopic != null) {
                newFeedModel.is_super_topics = 1;
                String str = bluedTopic.super_did;
                String str2 = str;
                if (!TextUtils.isEmpty(bluedTopic.name)) {
                    String str3 = str;
                    if (TextUtils.isEmpty(str)) {
                        str3 = "0";
                    }
                    str2 = str3;
                    if (bluedTopic.is_anonym == 1) {
                        str2 = Intrinsics.a(str3, (Object) "&");
                    }
                }
                newFeedModel.super_did = Intrinsics.a(str2, (Object) ",");
                newFeedModel.super_topics_name = Intrinsics.a(bluedTopic.name, (Object) ",");
            }
            CommunityServiceManager.e().a(false);
            FeedSendManager.a().a(newFeedModel);
            FeedMethods.c();
            i();
            EventTrackFeed.c(FeedProtos.Event.FEED_GUIDE_EDIT_PROFILE_POP_YES_CLICK);
        }
    }

    private final void r() {
        final ActivityFragmentActive a2 = a();
        FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntity<FeedIntroduceModel, FeedIntroduceExtra>>(a2) { // from class: com.soft.blued.ui.setting.fragment.UserInfoPostFeedDlgFragment$onLoadData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<FeedIntroduceModel, FeedIntroduceExtra> bluedEntity) {
                BluedTopic label_topics;
                UserInfoPostFeedDlgFragment userInfoPostFeedDlgFragment = UserInfoPostFeedDlgFragment.this;
                if (bluedEntity == null) {
                    label_topics = null;
                } else {
                    FeedIntroduceExtra feedIntroduceExtra = bluedEntity.extra;
                    label_topics = feedIntroduceExtra == null ? null : feedIntroduceExtra.getLabel_topics();
                }
                userInfoPostFeedDlgFragment.l = label_topics;
                UserInfoPostFeedDlgFragment.this.n();
            }
        });
    }

    public final void a(float f) {
        this.n = f;
    }

    public final void b(float f) {
        this.o = f;
    }

    public final void c(float f) {
        this.p = f;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public int e() {
        return R.layout.fragment_user_info_post_feed;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public void f() {
        super.f();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Bundle arguments = getArguments();
        String str = (String) (arguments == null ? null : arguments.getSerializable("user_role"));
        if (str != null) {
            arrayList.add(str);
        }
        Bundle arguments2 = getArguments();
        String str2 = (String) (arguments2 == null ? null : arguments2.getSerializable("user_character"));
        if (str2 != null) {
            LogUtils.c(Intrinsics.a("strCharacter: ", (Object) str2));
            List b = StringsKt.b((CharSequence) str2, new String[]{","}, false, 6, 2, (Object) null);
            ArrayList arrayList5 = new ArrayList();
            for (Object obj : b) {
                if (!TextUtils.isEmpty(StringsKt.b((CharSequence) ((String) obj)).toString())) {
                    arrayList5.add(obj);
                }
            }
            arrayList2.addAll(arrayList5);
        }
        Bundle arguments3 = getArguments();
        String str3 = (String) (arguments3 == null ? null : arguments3.getSerializable("user_purpose"));
        if (str3 != null) {
            LogUtils.c(Intrinsics.a("strPurpose: ", (Object) str3));
            for (String str4 : StringsKt.b((CharSequence) str3, new String[]{","}, false, 6, 2, (Object) null)) {
                if (!TextUtils.isEmpty(StringsKt.b((CharSequence) str4).toString())) {
                    arrayList3.add(StringsKt.b((CharSequence) str4).toString());
                }
            }
        }
        Bundle arguments4 = getArguments();
        String str5 = (String) (arguments4 == null ? null : arguments4.getSerializable("user_hobby"));
        if (str5 != null) {
            LogUtils.c(Intrinsics.a("strHobby: ", (Object) str5));
            for (String str6 : StringsKt.b((CharSequence) str5, new String[]{","}, false, 6, 2, (Object) null)) {
                if (!TextUtils.isEmpty(StringsKt.b((CharSequence) str6).toString())) {
                    arrayList4.add(StringsKt.b((CharSequence) str6).toString());
                }
            }
        }
        ArrayList arrayList6 = arrayList2;
        if (!arrayList6.isEmpty()) {
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo = new UserInfoPostFeedTextInfo();
            userInfoPostFeedTextInfo.setFactor(1.0f);
            userInfoPostFeedTextInfo.setBgColor(Color.parseColor("#CC7D89FF"));
            userInfoPostFeedTextInfo.setItemOriginBigCorner(FeedMethods.a(14.5f));
            userInfoPostFeedTextInfo.setItemOriginLittleCorner(FeedMethods.a(8.5f));
            userInfoPostFeedTextInfo.setOriginLeftRightMargin(FeedMethods.a(15.0f));
            userInfoPostFeedTextInfo.setOriginTopBottomMargin(FeedMethods.a(7.5f));
            userInfoPostFeedTextInfo.getContentList().addAll(arrayList6);
            this.m.add(userInfoPostFeedTextInfo);
        }
        ArrayList arrayList7 = arrayList;
        if (!arrayList7.isEmpty()) {
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo2 = new UserInfoPostFeedTextInfo();
            userInfoPostFeedTextInfo2.setFactor(1.6363636f);
            userInfoPostFeedTextInfo2.setBgColor(Color.parseColor("#7D89FF"));
            userInfoPostFeedTextInfo2.setItemOriginBigCorner(FeedMethods.a(19.5f));
            userInfoPostFeedTextInfo2.setItemOriginLittleCorner(FeedMethods.c(11));
            userInfoPostFeedTextInfo2.setOriginLeftRightMargin(FeedMethods.a(25.0f));
            userInfoPostFeedTextInfo2.setOriginTopBottomMargin(FeedMethods.a(10.5f));
            userInfoPostFeedTextInfo2.getContentList().addAll(arrayList7);
            this.m.add(userInfoPostFeedTextInfo2);
        }
        ArrayList arrayList8 = arrayList3;
        if (!arrayList8.isEmpty()) {
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo3 = new UserInfoPostFeedTextInfo();
            userInfoPostFeedTextInfo3.setFactor(1.3636364f);
            userInfoPostFeedTextInfo3.setBgColor(Color.parseColor("#D67D89FF"));
            userInfoPostFeedTextInfo3.setItemOriginBigCorner(FeedMethods.a(16.0f));
            userInfoPostFeedTextInfo3.setItemOriginLittleCorner(FeedMethods.a(9.5f));
            userInfoPostFeedTextInfo3.setOriginLeftRightMargin(FeedMethods.a(20.0f));
            userInfoPostFeedTextInfo3.setOriginTopBottomMargin(FeedMethods.a(10.0f));
            userInfoPostFeedTextInfo3.getContentList().addAll(arrayList8);
            this.m.add(userInfoPostFeedTextInfo3);
        }
        ArrayList arrayList9 = arrayList4;
        if (!arrayList9.isEmpty()) {
            UserInfoPostFeedTextInfo userInfoPostFeedTextInfo4 = new UserInfoPostFeedTextInfo();
            userInfoPostFeedTextInfo4.setFactor(0.8636364f);
            userInfoPostFeedTextInfo4.setBgColor(Color.parseColor("#B47D89FF"));
            userInfoPostFeedTextInfo4.setItemOriginBigCorner(FeedMethods.a(12.5f));
            userInfoPostFeedTextInfo4.setItemOriginLittleCorner(FeedMethods.a(6.5f));
            userInfoPostFeedTextInfo4.setOriginLeftRightMargin(FeedMethods.a(10.0f));
            userInfoPostFeedTextInfo4.setOriginTopBottomMargin(FeedMethods.a(7.0f));
            userInfoPostFeedTextInfo4.getContentList().addAll(arrayList9);
            this.m.add(userInfoPostFeedTextInfo4);
        }
        EventTrackFeed.c(FeedProtos.Event.FEED_GUIDE_EDIT_PROFILE_POP_SHOW);
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public void i() {
        ShapeFrameLayout shapeFrameLayout;
        ShapeFrameLayout shapeFrameLayout2;
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding = this.f33624a;
        if (fragmentUserInfoPostFeedBinding != null && (shapeFrameLayout2 = fragmentUserInfoPostFeedBinding.f28995a) != null) {
            shapeFrameLayout2.setVisibility(0);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation.setDuration(200L);
            shapeFrameLayout2.startAnimation(translateAnimation);
        }
        FragmentUserInfoPostFeedBinding fragmentUserInfoPostFeedBinding2 = this.f33624a;
        if (fragmentUserInfoPostFeedBinding2 == null || (shapeFrameLayout = fragmentUserInfoPostFeedBinding2.f28995a) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(shapeFrameLayout, "alpha", 1.0f, 0.0f);
        Intrinsics.c(ofFloat, "ofFloat(it, \"alpha\", 1f, 0f)");
        ObjectAnimator objectAnimator = ofFloat;
        objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.setting.fragment.UserInfoPostFeedDlgFragment$onClickClose$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                UserInfoPostFeedDlgFragment.this.dismissAllowingStateLoss();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    public final float j() {
        return this.n;
    }

    public final float k() {
        return this.o;
    }

    public final float l() {
        return this.p;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        this.f33624a = FragmentUserInfoPostFeedBinding.a(onCreateView);
        return onCreateView;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        m();
        o();
        r();
    }
}
