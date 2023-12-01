package com.blued.community.ui.circle.manager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.view.CenterAlignImageSpan;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.manager.ChildPhotoManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.ApplyJoinCircleDialogFragment;
import com.blued.community.ui.circle.fragment.ApplyJoinCircleFragment;
import com.blued.community.ui.circle.model.CircleDetailsModel;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.model.MyCircleTalkModel;
import com.blued.community.ui.circle.observer.ICircleDataObserver;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.utils.UserInfoUtils;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Locale;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/manager/CircleMethods.class */
public class CircleMethods {

    /* renamed from: com.blued.community.ui.circle.manager.CircleMethods$6  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/manager/CircleMethods$6.class */
    class AnonymousClass6 extends BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>> {
        final /* synthetic */ CircleJoinState a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<CircleDetailsModel> bluedEntityA) {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish(boolean z) {
            super.onUIFinish(z);
            if (z) {
                return;
            }
            CircleMethods.a(this.a);
        }
    }

    /* renamed from: com.blued.community.ui.circle.manager.CircleMethods$8  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/manager/CircleMethods$8.class */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[FeedProtos.NoteSource.values().length];
            a = iArr;
            try {
                iArr[FeedProtos.NoteSource.CITY_NOTE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[FeedProtos.NoteSource.CITY_TIME_NOTE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[FeedProtos.NoteSource.FEED_RECOMMEND_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[FeedProtos.NoteSource.CIRCLE_RECOMMEND_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/manager/CircleMethods$JoinViewChangeListener.class */
    public interface JoinViewChangeListener {
        void joinViewChange(CircleJoinState circleJoinState);
    }

    public static int a(Context context) {
        if (context != null) {
            TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.circle_anonymous_header);
            int random = (int) (Math.random() * (obtainTypedArray.length() - 1));
            obtainTypedArray.recycle();
            return random;
        }
        return 0;
    }

    public static int a(Context context, int i) {
        int i2 = R.drawable.circle_anonymous_header_default;
        int i3 = i2;
        if (context != null) {
            i3 = i2;
            if (i >= 0) {
                TypedArray obtainTypedArray = context.getResources().obtainTypedArray(R.array.circle_anonymous_header);
                i3 = i2;
                if (obtainTypedArray.length() > i) {
                    i3 = obtainTypedArray.getResourceId(i, R.drawable.circle_anonymous_header_default);
                }
            }
        }
        return i3;
    }

    public static SpannableStringBuilder a(BluedIngSelfFeed bluedIngSelfFeed, CharSequence charSequence) {
        if (bluedIngSelfFeed.is_posts_vote == 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  " + ((Object) charSequence));
            Drawable drawable = AppInfo.d().getResources().getDrawable(R.drawable.icon_vote);
            drawable.setBounds(0, 0, DensityUtils.a(AppInfo.d(), 18.0f), DensityUtils.a(AppInfo.d(), 17.0f));
            spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 1, 1);
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder(charSequence);
    }

    public static SpannableStringBuilder a(BluedIngSelfFeed bluedIngSelfFeed, CharSequence charSequence, boolean z) {
        SpannableStringBuilder spannableStringBuilder;
        if (bluedIngSelfFeed.is_essence == 1) {
            if (z) {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            } else {
                spannableStringBuilder = new SpannableStringBuilder("精" + ((Object) charSequence));
            }
            Drawable drawable = AppInfo.d().getResources().getDrawable(R.drawable.icon_circle_feed_essence);
            drawable.setBounds(0, 0, AppMethods.a(21), AppMethods.a(17));
            spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 1, 33);
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder(charSequence);
    }

    public static SpannableStringBuilder a(MyCircleTalkModel myCircleTalkModel, CharSequence charSequence) {
        if (myCircleTalkModel.is_auditing == 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("auditing " + ((Object) charSequence));
            Drawable drawable = AppInfo.d().getResources().getDrawable(R.drawable.circle_under_review);
            if ("en".equals(BlueAppLocal.a())) {
                drawable.setBounds(0, 0, AppMethods.a(60), AppMethods.a(16));
            } else {
                drawable.setBounds(0, 0, AppMethods.a(34), AppMethods.a(16));
            }
            spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), 0, 8, 33);
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder(charSequence);
    }

    public static String a(FeedProtos.NoteSource noteSource) {
        int i = AnonymousClass8.a[noteSource.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return "feed_square";
                }
                return null;
            }
            return "feed_city_time";
        }
        return "feed_nearby";
    }

    protected static void a() {
        SelectPhotoManager.a().d();
        ChildPhotoManager.a().d();
    }

    public static void a(Context context, JoinViewChangeListener joinViewChangeListener, CircleJoinState circleJoinState, IRequestHost iRequestHost, FragmentManager fragmentManager, boolean z, boolean z2) {
        a(context, joinViewChangeListener, circleJoinState, iRequestHost, fragmentManager, z, z2, true);
    }

    public static void a(final Context context, final JoinViewChangeListener joinViewChangeListener, final CircleJoinState circleJoinState, IRequestHost iRequestHost, FragmentManager fragmentManager, final boolean z, final boolean z2, final boolean z3) {
        if (circleJoinState.is_applied == 1) {
            return;
        }
        if (circleJoinState.is_applied == 2) {
            AppMethods.d(R.string.circle_comment_denied_tip);
        } else if (circleJoinState.allow_join == 1) {
            circleJoinState.setJoin();
            if (joinViewChangeListener != null) {
                joinViewChangeListener.joinViewChange(circleJoinState);
            }
            a(circleJoinState);
            CircleHttpUtils.a(circleJoinState.circle_id, new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(iRequestHost) { // from class: com.blued.community.ui.circle.manager.CircleMethods.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<MyCircleModel> bluedEntityA) {
                    if (bluedEntityA.hasData()) {
                        LiveEventBus.get("common_refresh_circle_group_enter", Integer.class).post(Integer.valueOf(bluedEntityA.data.get(0).show_groups));
                    }
                    if (z) {
                        EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_FEED_POP_SHOW);
                        CommonAlertDialog.a(context, AppUtils.a(R.string.join_circle_dialog_title), CircleMethods.b(circleJoinState.title), AppUtils.a(R.string.join_circle_dialog_button_content), new DialogInterface.OnClickListener() { // from class: com.blued.community.ui.circle.manager.CircleMethods.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Tracker.onClick(dialogInterface, i);
                                CircleMethods.a(circleJoinState.title, "", circleJoinState.circle_id);
                                EventTrackFeed.a(FeedProtos.Event.CIRCLE_JOIN_FEED_POP_CLICK);
                            }
                        }, (DialogInterface.OnDismissListener) null, 1);
                    } else if (z3) {
                        AppMethods.d(R.string.circle_post_detail_joined_toast);
                    }
                    if (z2) {
                        CommunityPreferences.a(circleJoinState.circle_id, true);
                        CommunityPreferences.b(circleJoinState.circle_id, true);
                    }
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish(boolean z4) {
                    super.onUIFinish(z4);
                    if (z4) {
                        return;
                    }
                    circleJoinState.setExitJoin();
                    JoinViewChangeListener joinViewChangeListener2 = joinViewChangeListener;
                    if (joinViewChangeListener2 != null) {
                        joinViewChangeListener2.joinViewChange(circleJoinState);
                    }
                    CircleMethods.a(circleJoinState);
                }
            }, iRequestHost);
        } else {
            circleJoinState.setExitJoin();
            if (joinViewChangeListener != null) {
                joinViewChangeListener.joinViewChange(circleJoinState);
            }
            a(circleJoinState);
            a(joinViewChangeListener, circleJoinState, fragmentManager);
        }
    }

    public static void a(Context context, final String str, String str2, String str3, boolean z, final boolean z2) {
        if (z) {
            ApplyJoinCircleFragment.a(context, str, str2, str3);
            return;
        }
        a(new CircleJoinState(str, str2, str3, 0, 0, 0));
        CircleHttpUtils.a(str, new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(null) { // from class: com.blued.community.ui.circle.manager.CircleMethods.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MyCircleModel> bluedEntityA) {
                AppMethods.d(R.string.circle_post_detail_joined_toast);
                if (bluedEntityA.hasData()) {
                    LiveEventBus.get("common_refresh_circle_group_enter", Integer.class).post(Integer.valueOf(bluedEntityA.data.get(0).show_groups));
                }
                if (z2) {
                    CommunityPreferences.a(str, true);
                    CommunityPreferences.b(str, true);
                }
            }
        }, (IRequestHost) null);
    }

    public static void a(ImageView imageView, int i) {
        a(imageView, i, 0);
    }

    public static void a(ImageView imageView, int i, int i2) {
        if (imageView == null) {
            return;
        }
        if (i == 1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.circle_member_owner_icon);
        } else if (i == 2) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.circle_member_manager_icon);
        } else if (i2 != 1) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.circle_member_author_icon);
        }
    }

    public static void a(LifecycleOwner lifecycleOwner, final ICircleDataObserver iCircleDataObserver) {
        LiveEventBus.get("circle_join_state", CircleJoinState.class).observe(lifecycleOwner, new Observer<CircleJoinState>() { // from class: com.blued.community.ui.circle.manager.CircleMethods.1
            /* renamed from: a */
            public void onChanged(CircleJoinState circleJoinState) {
                if (circleJoinState == null) {
                    return;
                }
                ICircleDataObserver.this.a(circleJoinState);
            }
        });
    }

    public static void a(IRequestHost iRequestHost, String str, String str2, final boolean z) {
        CircleHttpUtils.b(new BluedUIHttpResponse(iRequestHost) { // from class: com.blued.community.ui.circle.manager.CircleMethods.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (z) {
                    AppMethods.d(R.string.circle_member_invitation_toast);
                }
            }
        }, str, str2, iRequestHost);
    }

    public static void a(final JoinViewChangeListener joinViewChangeListener, final CircleJoinState circleJoinState, FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            ApplyJoinCircleDialogFragment.a(fragmentManager, circleJoinState, new ApplyJoinCircleDialogFragment.ApplyJoinCircleListener() { // from class: com.blued.community.ui.circle.manager.CircleMethods.3
                @Override // com.blued.community.ui.circle.fragment.ApplyJoinCircleDialogFragment.ApplyJoinCircleListener
                public void a() {
                    CircleJoinState.this.is_applied = 1;
                    JoinViewChangeListener joinViewChangeListener2 = joinViewChangeListener;
                    if (joinViewChangeListener2 != null) {
                        joinViewChangeListener2.joinViewChange(CircleJoinState.this);
                    }
                    CircleMethods.a(CircleJoinState.this);
                    CommunityPreferences.a(CircleJoinState.this.circle_id, true);
                    CommunityPreferences.b(CircleJoinState.this.circle_id, true);
                }
            });
        }
    }

    public static void a(CircleJoinState circleJoinState) {
        LiveEventBus.get("circle_join_state").post(circleJoinState);
    }

    public static void a(final MyCircleModel myCircleModel, IRequestHost iRequestHost) {
        final CircleJoinState joinState = myCircleModel.getJoinState();
        CircleHttpUtils.b(myCircleModel.circle_id, new BluedUIHttpResponse<BluedEntityA<CircleDetailsModel>>(iRequestHost) { // from class: com.blued.community.ui.circle.manager.CircleMethods.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CircleDetailsModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    LiveEventBus.get("common_refresh_circle_group_enter", Integer.class).post(Integer.valueOf(bluedEntityA.data.get(0).show_groups));
                    LiveEventBus.get("common_clear_group_member_state", String.class).post(myCircleModel.circle_id);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                CircleMethods.a(joinState);
            }
        }, iRequestHost);
        myCircleModel.setExitJoin();
        a(myCircleModel.getJoinState());
    }

    public static void a(String str, String str2, String str3) {
        NewFeedModel newFeedModel = new NewFeedModel();
        newFeedModel.setLoadName(Long.parseLong(UserInfoUtils.c()));
        newFeedModel.setState(1);
        newFeedModel.setTime(System.currentTimeMillis());
        newFeedModel.setIsJoinCircle(1);
        newFeedModel.setJoinCircleId(Integer.parseInt(str3));
        newFeedModel.setJoinCircleTitle(str);
        if (!TextUtils.isEmpty(str2)) {
            newFeedModel.feed_id = str2;
        }
        newFeedModel.is_anonym = 0;
        FeedSendManager.a().d(newFeedModel);
        a();
    }

    public static boolean a(NewFeedModel newFeedModel) {
        return !TextUtils.isEmpty(newFeedModel.circle_id) && Long.valueOf(newFeedModel.circle_id).longValue() > 0;
    }

    public static boolean a(BluedIngSelfFeed bluedIngSelfFeed) {
        return !TextUtils.isEmpty(bluedIngSelfFeed.circle_id) && Long.valueOf(bluedIngSelfFeed.circle_id).longValue() > 0;
    }

    public static boolean a(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a = EncryptTool.a(str);
        String c = UserInfoUtils.c();
        if (str.equals(c) || a.equals(c)) {
            z = true;
        }
        return z;
    }

    public static SpannableStringBuilder b(BluedIngSelfFeed bluedIngSelfFeed, CharSequence charSequence) {
        if (TextUtils.equals(bluedIngSelfFeed.note_from, "top")) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("top " + ((Object) charSequence));
            Drawable drawable = AppInfo.d().getResources().getDrawable(R.drawable.circle_top_icon);
            drawable.setBounds(0, 0, AppMethods.a(32), AppMethods.a(18));
            spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 3, 33);
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder(charSequence);
    }

    public static MessageProtos.StrangerSource b(FeedProtos.NoteSource noteSource) {
        int i = AnonymousClass8.a[noteSource.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? MessageProtos.StrangerSource.CIRCLE_NOTE_DETAIL : MessageProtos.StrangerSource.FIND_PLAZA_RECOMMEND : MessageProtos.StrangerSource.FEED_FIND_PLAZA : MessageProtos.StrangerSource.CITY_TIME : MessageProtos.StrangerSource.FIND_PLAZA_NEARBY;
    }

    public static String b(String str) {
        if (Locale.getDefault().getLanguage().equals("en")) {
            return "" + str + " " + AppUtils.a(R.string.join_circle_dialog_content);
        }
        return "「" + str + AppUtils.a(R.string.join_circle_dialog_content);
    }
}
