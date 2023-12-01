package com.soft.blued.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.fragment.CircleDetailsFragment;
import com.blued.community.ui.circle.fragment.CircleNewFragment;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.community.fragment.AttentionFeedHomeFragment;
import com.soft.blued.ui.discover.view.FeedPromotionDlg;
import com.soft.blued.ui.discover.view.SendFeedGuideDlg;
import com.soft.blued.ui.live.activity.SendFeedDialogActivity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.UserinfoFragmentAlbumTab;
import com.soft.blued.ui.user.fragment.UserinfoFragmentFeedTab;
import com.soft.blued.ui.user.fragment.UserinfoFragmentProfileTab;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/SendNotificationManager.class */
public class SendNotificationManager {

    /* renamed from: c  reason: collision with root package name */
    private static volatile SendNotificationManager f29711c;
    private String d;
    private WeakReference<Activity> e;
    private float h;
    private final SparseArray<ViewState> f = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    Handler f29712a = new Handler(Looper.getMainLooper());
    public boolean b = false;
    private boolean g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/SendNotificationManager$RemoveRunnable.class */
    public class RemoveRunnable implements Runnable {
        private FrameLayout b;

        /* renamed from: c  reason: collision with root package name */
        private View f29720c;
        private BluedIngSelfFeed d;
        private boolean e;

        public RemoveRunnable(FrameLayout frameLayout, View view, BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
            this.b = frameLayout;
            this.f29720c = view;
            this.d = bluedIngSelfFeed;
            this.e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = this.f29720c;
            if (view == null || view.getParent() == null) {
                return;
            }
            SendNotificationManager.this.a(this.b, this.f29720c, (BluedIngSelfFeed) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/manager/SendNotificationManager$ViewState.class */
    public static class ViewState {

        /* renamed from: a  reason: collision with root package name */
        View f29721a;
        RemoveRunnable b;

        public ViewState(View view) {
            this.f29721a = view;
        }
    }

    private SendNotificationManager() {
    }

    public static SendNotificationManager a() {
        if (f29711c == null) {
            synchronized (SendNotificationManager.class) {
                try {
                    if (f29711c == null) {
                        f29711c = new SendNotificationManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f29711c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, String str, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK);
        WebViewShowInfoFragment.show(activity, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, View view) {
        if (view == null || viewGroup == null) {
            return;
        }
        try {
            viewGroup.removeView(view);
            ViewState viewState = this.f.get(viewGroup.hashCode());
            if (viewState != null && viewState.b != null) {
                this.f29712a.removeCallbacks(viewState.b);
            }
            this.f.remove(viewGroup.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(final FrameLayout frameLayout, final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new OvershootInterpolator(1.15f));
        translateAnimation.setDuration(500L);
        translateAnimation.setFillBefore(true);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.manager.SendNotificationManager.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RemoveRunnable removeRunnable = new RemoveRunnable(frameLayout, view, null, false);
                ViewState viewState = (ViewState) SendNotificationManager.this.f.get(frameLayout.hashCode());
                ViewState viewState2 = viewState;
                if (viewState == null) {
                    viewState2 = new ViewState(view);
                }
                viewState2.b = removeRunnable;
                SendNotificationManager.this.f29712a.postDelayed(removeRunnable, 4000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final FrameLayout frameLayout, final View view, final BluedIngSelfFeed bluedIngSelfFeed, final boolean z) {
        if (view == null || view.getParent() == null) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(400L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.manager.SendNotificationManager.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SendNotificationManager.this.a((ViewGroup) frameLayout, view);
                if (bluedIngSelfFeed != null) {
                    SendNotificationManager.this.f29712a.postDelayed(new Runnable() { // from class: com.soft.blued.manager.SendNotificationManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SendNotificationManager.this.a(frameLayout, bluedIngSelfFeed, z);
                        }
                    }, 50L);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout, final BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        final View inflate = LayoutInflater.from(AppInfo.d()).inflate(R.layout.send_feed_notification_state_layout, (ViewGroup) null);
        CardView cardView = (CardView) inflate.findViewById(R.id.send_feed_notification_card);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.send_feed_notification_img);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.send_feed_notification_state_iv);
        TextView textView = (TextView) inflate.findViewById(R.id.send_feed_notification_state_tv);
        TextView textView2 = (TextView) inflate.findViewById(R.id.send_feed_notification_state_tips_tv);
        String str = (!"1".equalsIgnoreCase(bluedIngSelfFeed.is_videos) || bluedIngSelfFeed.feed_videos == null || bluedIngSelfFeed.feed_videos.length <= 0) ? (bluedIngSelfFeed.feed_pics == null || bluedIngSelfFeed.feed_pics.length <= 0) ? null : bluedIngSelfFeed.feed_pics[0] : bluedIngSelfFeed.feed_videos[0];
        if (BluedPreferences.cK()) {
            textView.setTextColor(AppInfo.d().getResources().getColor(2131102478));
            textView2.setTextColor(AppInfo.d().getResources().getColor(2131102479));
            cardView.setCardBackgroundColor(AppInfo.d().getResources().getColor(2131101539));
        } else {
            textView.setTextColor(AppInfo.d().getResources().getColor(2131101514));
            textView2.setTextColor(AppInfo.d().getResources().getColor(2131101625));
            cardView.setCardBackgroundColor(AppInfo.d().getResources().getColor(2131101796));
        }
        if (!TextUtils.isEmpty(str)) {
            ImageLoader.a((IRequestHost) null, str).a(imageView);
        }
        Fragment c2 = c(b());
        if (z) {
            imageView2.setImageResource(2131236294);
            if (bluedIngSelfFeed.dataType <= 1 && CircleMethods.a(bluedIngSelfFeed)) {
                textView.setText(2131891617);
            } else if (c2 != null && c2.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedHomeFragment.class.getSimpleName())) {
                textView.setText(2131891606);
            } else if ("1".equals(bluedIngSelfFeed.is_videos)) {
                textView.setText(2131891620);
            } else {
                textView.setText(2131891606);
            }
            String charSequence = AppInfo.d().getResources().getText(2131892268).toString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            String charSequence2 = AppInfo.d().getResources().getText(2131892270).toString();
            if (c2 != null && c2.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedHomeFragment.class.getSimpleName())) {
                textView2.setVisibility(8);
            } else if (c2 != null && c2.getClass().getSimpleName().equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName())) {
                textView2.setVisibility(8);
            } else if (c2 != null && (c2.getClass().getSimpleName().equalsIgnoreCase(UserinfoFragmentFeedTab.class.getSimpleName()) || c2.getClass().getSimpleName().equalsIgnoreCase(UserinfoFragmentAlbumTab.class.getSimpleName()) || c2.getClass().getSimpleName().equalsIgnoreCase(UserinfoFragmentAlbumTab.class.getSimpleName()))) {
                textView2.setVisibility(8);
            } else if (c2 == null || !(c2 instanceof WebViewShowInfoFragment)) {
                if (charSequence.contains(charSequence2)) {
                    int indexOf = charSequence.indexOf(charSequence2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#2069EB")), indexOf, charSequence2.length() + indexOf, 33);
                    textView2.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                    textView2.setVisibility(0);
                } else {
                    textView2.setText(charSequence);
                    textView2.setVisibility(0);
                }
            } else if (((WebViewShowInfoFragment) c2).e().contains("home/fans/feed")) {
                textView2.setVisibility(8);
            }
        } else {
            imageView2.setImageResource(2131236293);
            if (bluedIngSelfFeed.dataType <= 1 && CircleMethods.a(bluedIngSelfFeed)) {
                textView.setText(2131891616);
            } else if (c2 != null && c2.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedHomeFragment.class.getSimpleName())) {
                textView.setText(2131891605);
            } else if (c2 != null && c2.getClass().getSimpleName().equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName())) {
                textView.setText(2131891616);
            } else if ("1".equals(bluedIngSelfFeed.is_videos)) {
                textView.setText(2131891619);
            } else {
                textView.setText(2131891605);
            }
            String charSequence3 = AppInfo.d().getResources().getText(2131892269).toString();
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence3);
            String charSequence4 = AppInfo.d().getResources().getText(2131892270).toString();
            if (c2 != null && c2.getClass().getSimpleName().equalsIgnoreCase(AttentionFeedHomeFragment.class.getSimpleName())) {
                textView2.setVisibility(8);
            } else if (charSequence3.contains(charSequence4)) {
                int indexOf2 = charSequence3.indexOf(charSequence4);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(Color.parseColor("#2069EB")), indexOf2, charSequence4.length() + indexOf2, 33);
                textView2.setText(spannableStringBuilder2, TextView.BufferType.SPANNABLE);
                textView2.setVisibility(0);
            } else {
                textView2.setText(charSequence3);
                textView2.setVisibility(0);
            }
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.manager.-$$Lambda$SendNotificationManager$3Ip6ScrwDKwarOOq9aXeLnOaM0M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendNotificationManager.a(BluedIngSelfFeed.this, view);
            }
        });
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.manager.-$$Lambda$SendNotificationManager$Z2itgWr9iCTpHYgE6pMG24ijq4Q
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = SendNotificationManager.this.a(inflate, view, motionEvent);
                return a2;
            }
        });
        inflate.setTag(bluedIngSelfFeed);
        frameLayout.addView(inflate, new FrameLayout.LayoutParams(-1, -2));
        this.f.put(frameLayout.hashCode(), new ViewState(inflate));
        a(frameLayout, inflate);
        a(bluedIngSelfFeed, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(BluedIngSelfFeed bluedIngSelfFeed, View view) {
        Tracker.onClick(view);
        EventTrackFeed.b(FeedProtos.Event.FEED_PUBLISH_STATUS_NOTIFICATION_CLICK, bluedIngSelfFeed.feed_id);
        BluedURIRouterAdapter.openDiscoveryPage(AppInfo.d(), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, View view2, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.h = motionEvent.getY();
            return false;
        } else if (motionEvent.getAction() != 2 && motionEvent.getAction() == 1 && Math.abs(motionEvent.getY() - this.h) > DisplayUtil.a(view.getContext(), 10.0f)) {
            a((FrameLayout) view.getParent(), view, (BluedIngSelfFeed) null, false);
            this.h = 0.0f;
            return true;
        } else {
            return false;
        }
    }

    private void b(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        Activity b = b();
        if (UiUtils.a(b)) {
            FrameLayout frameLayout = (FrameLayout) b.getWindow().getDecorView();
            FrameLayout frameLayout2 = (FrameLayout) b.findViewById(16908290);
            ViewState viewState = this.f.get(frameLayout.hashCode());
            if (viewState == null || viewState.f29721a == null) {
                a(frameLayout, bluedIngSelfFeed, z);
            } else {
                a(frameLayout, viewState.f29721a, bluedIngSelfFeed, z);
            }
            EventTrackFeed.b(FeedProtos.Event.FEED_PUBLISH_STATUS_NOTIFICATION_SHOW, bluedIngSelfFeed.feed_id);
        }
    }

    private boolean c() {
        Activity b = b();
        if (b == null) {
            return false;
        }
        Fragment c2 = c(b);
        if (c2 != null) {
            String simpleName = c2.getClass().getSimpleName();
            LogUtils.c("curFragment: " + simpleName);
            return (simpleName.equalsIgnoreCase(AttentionFeedHomeFragment.class.getSimpleName()) || simpleName.equalsIgnoreCase(UserInfoFragmentNew.class.getSimpleName()) || simpleName.equalsIgnoreCase(CircleNewFragment.class.getSimpleName()) || simpleName.equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName()) || simpleName.equalsIgnoreCase(FeedAddPostFragment.class.getSimpleName()) || simpleName.equalsIgnoreCase(UserinfoFragmentAlbumTab.class.getSimpleName()) || simpleName.equalsIgnoreCase(UserinfoFragmentFeedTab.class.getSimpleName()) || simpleName.equalsIgnoreCase(UserinfoFragmentProfileTab.class.getSimpleName())) ? false : true;
        }
        return true;
    }

    private boolean d() {
        Activity b = b();
        if (b == null) {
            return false;
        }
        Fragment c2 = c(b);
        if (c2 != null) {
            String simpleName = c2.getClass().getSimpleName();
            LogUtils.c("curFragment: " + simpleName);
            return (simpleName.equalsIgnoreCase(CircleNewFragment.class.getSimpleName()) || simpleName.equalsIgnoreCase(CircleDetailsFragment.class.getSimpleName())) ? false : true;
        }
        return true;
    }

    public void a(Activity activity) {
        if (activity != null) {
            FrameLayout frameLayout = (FrameLayout) activity.getWindow().getDecorView();
            ViewState viewState = this.f.get(frameLayout.hashCode());
            if (viewState == null || viewState.f29721a == null) {
                return;
            }
            a((ViewGroup) frameLayout, viewState.f29721a);
        }
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        b(bluedIngSelfFeed, false);
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z) {
        Activity b;
        if (bluedIngSelfFeed == null || !z || (b = b()) == null) {
            return;
        }
        if (!BluedPreferences.eb() || !c()) {
            a((Object) bluedIngSelfFeed);
            return;
        }
        BluedPreferences.ec();
        SendFeedGuideDlg sendFeedGuideDlg = new SendFeedGuideDlg(b, 2131951924);
        sendFeedGuideDlg.a(bluedIngSelfFeed);
        DialogUtils.a(sendFeedGuideDlg);
    }

    public void a(Object obj) {
        if (obj != null && (obj instanceof BluedIngSelfFeed)) {
            BluedIngSelfFeed bluedIngSelfFeed = (BluedIngSelfFeed) obj;
            if (bluedIngSelfFeed.circle_active_posting > 0) {
                AppMethods.a((CharSequence) ("发布成功，积分+" + bluedIngSelfFeed.circle_active_posting));
            } else if (bluedIngSelfFeed.circle_active_shared_posting > 0) {
                AppMethods.a((CharSequence) ("分享成功，积分+" + bluedIngSelfFeed.circle_active_shared_posting));
            }
        }
        if (obj == null || !d()) {
            return;
        }
        if (obj instanceof BluedIngSelfFeed) {
            BluedIngSelfFeed bluedIngSelfFeed2 = (BluedIngSelfFeed) obj;
            boolean z = (StringUtils.d(bluedIngSelfFeed2.activity_id) && bluedIngSelfFeed2.activity_data == null) ? false : true;
            if (bluedIngSelfFeed2.is_join_circle == 0 && !z) {
                final Activity b = b();
                if (b == null) {
                    return;
                }
                String str = bluedIngSelfFeed2.promotion_url;
                if (this.b) {
                    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_SHOW);
                    final String str2 = str + "&detail=feed_success_go_hot";
                    CommonAlertDialog.a(b, b.getString(2131891358), b.getString(2131891357), b.getString(2131887976), new DialogInterface.OnClickListener() { // from class: com.soft.blued.manager.-$$Lambda$SendNotificationManager$p0zxCoqLBQfN2y5KD9gRKdc-IiM
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SendNotificationManager.a(Activity.this, str2, dialogInterface, i);
                        }
                    }, b.getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                } else if (this.g || bluedIngSelfFeed2.is_feed_anonym == 1) {
                    return;
                } else {
                    AppConfigModel.FeedPromotion k = BluedConfig.a().k();
                    if (k != null && k.open == 1) {
                        long j = k.duration;
                        long time = new Date().getTime();
                        if (time - BluedPreferences.bA() > j * 60 * 60 * 1000) {
                            String str3 = str + "&detail=after_publish_guide_window";
                            BluedPreferences.f(time);
                            FeedPromotionDlg feedPromotionDlg = new FeedPromotionDlg(b, 2131951924, k);
                            feedPromotionDlg.a(str3);
                            DialogUtils.a(feedPromotionDlg);
                            this.g = true;
                            feedPromotionDlg.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.soft.blued.manager.SendNotificationManager.3
                                @Override // android.content.DialogInterface.OnDismissListener
                                public void onDismiss(DialogInterface dialogInterface) {
                                    SendNotificationManager.this.g = false;
                                }
                            });
                        }
                    }
                }
            }
        }
        this.b = false;
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void b(Activity activity) {
        if (activity == null || (activity instanceof SendFeedDialogActivity)) {
            return;
        }
        this.e = new WeakReference<>(activity);
        this.d = activity.getClass().getSimpleName();
        Fragment c2 = c(activity);
        if (c2 != null) {
            c2.getClass().getSimpleName();
        }
    }

    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        b(bluedIngSelfFeed, true);
    }

    public Fragment c(Activity activity) {
        if (activity == null) {
            return null;
        }
        Fragment fragment = null;
        if (activity instanceof FragmentActivity) {
            List<Fragment> fragments = ((FragmentActivity) activity).getSupportFragmentManager().getFragments();
            fragment = null;
            if (fragments.size() > 0) {
                int size = fragments.size();
                while (true) {
                    int i = size - 1;
                    fragment = null;
                    if (i < 0) {
                        break;
                    } else if (fragments.get(i) instanceof BaseFragment) {
                        Fragment fragment2 = fragments.get(i);
                        Fragment fragment3 = null;
                        if (fragment2.isAdded()) {
                            fragment3 = null;
                            if (!fragment2.isHidden()) {
                                fragment3 = null;
                                if (!fragment2.isDetached()) {
                                    List<Fragment> fragments2 = fragment2.getChildFragmentManager().getFragments();
                                    fragment3 = null;
                                    if (fragments2.size() > 0) {
                                        int size2 = fragments2.size();
                                        while (true) {
                                            int i2 = size2 - 1;
                                            fragment3 = null;
                                            if (i2 >= 0) {
                                                if ((fragments2.get(i2) instanceof BaseFragment) && fragments2.get(i2).getUserVisibleHint()) {
                                                    fragment3 = fragments2.get(i2);
                                                    break;
                                                }
                                                size2 = i2;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        fragment = fragment3;
                        if (fragment3 == null) {
                            return fragment2;
                        }
                    } else {
                        size = i;
                    }
                }
            }
        }
        return fragment;
    }
}
