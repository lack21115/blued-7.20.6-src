package com.soft.blued.ui.user.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaFormat;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.app.share.ShareUtils;
import com.app.share.model.ShareEntity;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.AuditingProfileModel;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.view.GroupJoinView;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonGuidePop;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.common.view.RotateLayout;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.event.fragment.EventDetailsFragment;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.event.model.EventLogData;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.utils.CommBundleBuilder;
import com.blued.community.view.TextViewFixTouchForDynamic;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import com.blued.track.bytedance.ByteDanceLogUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.igexin.assist.util.AssistUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.TwoLevelHeader;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.customview.CustomViewPager;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.ProfileEventUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.community.view.FeedBubbleProfileView;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.MediaUtils;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.msg.event.UpdateSourceFromEvent;
import com.soft.blued.ui.msg.manager.SubscribeNumberManager;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.setting.fragment.ShowVerifyFragment;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.user.adapter.UserProfileGiftdapter;
import com.soft.blued.ui.user.adapter.UserinfoNewAlbumAdapter;
import com.soft.blued.ui.user.contract.IUserInfoNewContract;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VirtualImageFragment;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import com.soft.blued.ui.user.model.UserGift;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.ui.user.observer.AlbumDataObserver;
import com.soft.blued.ui.user.observer.UserinfoFeedScrollObserver;
import com.soft.blued.ui.user.pop.PopUserRecommend;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.presenter.UserInfoNewPresenter;
import com.soft.blued.ui.user.views.EcologyPopView;
import com.soft.blued.ui.user.views.UserProfileBtmOptions;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.dialog.CommonAlertDialog2;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentNew.class */
public class UserInfoFragmentNew extends BaseFragment implements View.OnClickListener, Observer<FuGiftListEvent>, IUserInfoNewContract.IView, AlbumDataObserver.IAlbumObserver, UserinfoFeedScrollObserver.IUserinFeedScrollObserver {
    public View A;
    public TextView B;
    public TextView C;
    public TextView D;
    public UserBasicModel E;
    public BluedIngSelfFeed F;
    public LiveRoomData G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public MsgSourceEntity M;
    public LogData N;
    public int O;
    public int P;
    public ImageView Q;
    public ImageView R;
    public ImageView S;
    public ImageView T;
    public TextView U;
    public SmartRefreshLayout V;
    private View X;
    private View Y;
    private TextView Z;

    /* renamed from: a  reason: collision with root package name */
    public Context f34016a;
    private View aA;
    private TextView aB;
    private TextView aC;
    private RecyclerView aD;
    private UserinfoNewAlbumAdapter aE;
    private int aF;
    private int aG;
    private boolean aH;
    private LinearLayout aI;
    private UserinfoFragmentProfileTab aJ;
    private UserinfoFragmentFeedTab aK;
    private UserinfoFragmentAlbumTab aL;
    private Fragment aM;
    private LinearLayout aN;
    private String aO;
    private FrameLayout aP;
    private ShapeRelativeLayout aQ;
    private ImageView aR;
    private TextView aS;
    private TwoLevelHeader aT;
    private CustomViewPager aU;
    private LinePageIndicator aV;
    private int aW;
    private LinearLayout aY;
    private FrameLayout aZ;
    private UserProfileBtmOptions aa;
    private View ab;
    private AppBarLayout ac;
    private View ad;
    private ShapeTextView ag;
    private ShapeTextView ah;
    private GroupJoinView ai;
    private LinearLayout aj;
    private View ak;
    private ImageView al;
    private FrameLayout am;
    private View an;
    private View ao;
    private boolean as;
    private boolean at;
    private String au;
    private String av;
    private EcologyPopView aw;
    private FuGiftListEvent ax;
    private LinearLayout ay;
    private View az;
    public View b;
    private VirtualImageFragment ba;
    private ImageView bb;
    private TabPageIndicatorWithDot bc;
    private TextView bd;
    private LinearLayout be;
    private LinearLayout bf;
    private View bi;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f34018c;
    public List<Fragment> d;
    public View e;
    public View f;
    public CustomViewPager g;
    public MyAdapter h;
    public TabPageIndicatorWithDot i;
    public ImageView j;
    public ImageView k;
    public ShapeTextView l;
    public LoadOptions m;
    public UserInfoNewPresenter n;
    public boolean o;
    public RotateLayout p;
    public FeedBubbleProfileView q;
    public ImageView r;
    public ImageView s;
    public ImageView t;
    public ImageView u;
    public Dialog v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;
    private boolean ae = false;
    private boolean af = true;
    private boolean ap = false;
    private boolean aq = false;

    /* renamed from: ar  reason: collision with root package name */
    private boolean f34017ar = false;
    public boolean W = false;
    private List<View> aX = new ArrayList();
    private boolean bg = false;
    private boolean bh = false;
    private boolean bj = false;
    private final int bk = 604800;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.fragment.UserInfoFragmentNew$15  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentNew$15.class */
    public class AnonymousClass15 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f34025a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextViewFixTouchForDynamic f34026c;

        AnonymousClass15(TextView textView, int i, TextViewFixTouchForDynamic textViewFixTouchForDynamic) {
            this.f34025a = textView;
            this.b = i;
            this.f34026c = textViewFixTouchForDynamic;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(TextViewFixTouchForDynamic textViewFixTouchForDynamic, TextView textView, View view) {
            Tracker.onClick(view);
            if (textViewFixTouchForDynamic.getVisibility() == 0) {
                textViewFixTouchForDynamic.setVisibility(8);
                textView.setVisibility(0);
                return;
            }
            textViewFixTouchForDynamic.setVisibility(0);
            textView.setVisibility(8);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f34025a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f34025a.getLineCount() <= this.b) {
                this.f34025a.setVisibility(0);
                this.f34026c.setVisibility(8);
                return;
            }
            this.f34025a.setVisibility(8);
            View view = UserInfoFragmentNew.this.ab;
            final TextViewFixTouchForDynamic textViewFixTouchForDynamic = this.f34026c;
            final TextView textView = this.f34025a;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$15$K9NXdZlSDC-Yn5msH-SpYQdJXm4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UserInfoFragmentNew.AnonymousClass15.a(TextViewFixTouchForDynamic.this, textView, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.fragment.UserInfoFragmentNew$18  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentNew$18.class */
    public class AnonymousClass18 extends BluedUIHttpResponse<BluedEntityA<UserGift>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UserInfoEntity f34029a;
        final /* synthetic */ TextView b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ImageView f34030c;
        final /* synthetic */ RecyclerView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass18(IRequestHost iRequestHost, UserInfoEntity userInfoEntity, TextView textView, ImageView imageView, RecyclerView recyclerView) {
            super(iRequestHost);
            this.f34029a = userInfoEntity;
            this.b = textView;
            this.f34030c = imageView;
            this.d = recyclerView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ImageView imageView, UserInfoEntity userInfoEntity, View view, int i) {
            imageView.setVisibility(8);
            if (!BluedPreferences.aR() && UserInfo.getInstance().getLoginUserInfo().uid.equals(userInfoEntity.uid)) {
                BluedPreferences.aS();
            }
            if (!userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
                UserGiftDialogFragment.a(UserInfoFragmentNew.this.getActivity(), UserInfoFragmentNew.this.getFragmentActive(), userInfoEntity.uid, "user_page_gift", new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.18.1
                    @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
                    public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                        userGiftDialogFragment.dismiss();
                        UserInfoFragmentNew.this.a(giftGivingOptionForJsonParse);
                    }
                }, userInfoEntity.relationship, userInfoEntity.name, new int[0]);
                return;
            }
            WebViewShowInfoFragment.show(UserInfoFragmentNew.this.f34016a, H5Url.a(44), 0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UserGift> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                this.d.setVisibility(8);
                return;
            }
            if (bluedEntityA.getSingleData().number != 0) {
                this.b.setText(StringUtils.a(bluedEntityA.getSingleData().number + ""));
            } else if (TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, this.f34029a.uid)) {
                this.b.setText(UserInfoFragmentNew.this.f34016a.getResources().getString(R.string.you_no_gift_yet));
            } else {
                this.b.setText(UserInfoFragmentNew.this.f34016a.getResources().getString(R.string.he_no_gift_yet));
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(bluedEntityA.getSingleData().gift_list);
            UserProfileGiftdapter userProfileGiftdapter = new UserProfileGiftdapter(UserInfoFragmentNew.this.getFragmentActive(), UserInfoFragmentNew.this.f34016a, arrayList);
            final ImageView imageView = this.f34030c;
            final UserInfoEntity userInfoEntity = this.f34029a;
            userProfileGiftdapter.a(new UserProfileGiftdapter.RecyclerViewItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$18$ETztGgjAuEdOb4ogExZpn4_DVgo
                @Override // com.soft.blued.ui.user.adapter.UserProfileGiftdapter.RecyclerViewItemClickListener
                public final void onItemClick(View view, int i) {
                    UserInfoFragmentNew.AnonymousClass18.this.a(imageView, userInfoEntity, view, i);
                }
            });
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(UserInfoFragmentNew.this.f34016a);
            linearLayoutManager.setStackFromEnd(true);
            linearLayoutManager.setOrientation(0);
            linearLayoutManager.scrollToPosition(0);
            this.d.setLayoutManager(linearLayoutManager);
            this.d.setHasFixedSize(true);
            this.d.setAdapter(userProfileGiftdapter);
            userProfileGiftdapter.notifyDataSetChanged();
            if (userProfileGiftdapter.getItemCount() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.d.setVisibility(8);
            return super.onUIFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.user.fragment.UserInfoFragmentNew$7  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentNew$7.class */
    public class AnonymousClass7 implements Animator.AnimatorListener {
        AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            UserInfoFragmentNew.this.a(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            UserInfoFragmentNew.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$7$fB8w5HRweNb2sAX84hA5DXSq9Rk
                @Override // java.lang.Runnable
                public final void run() {
                    UserInfoFragmentNew.AnonymousClass7.this.a();
                }
            }, 50L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            UserInfoFragmentNew.this.a(true);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentNew$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public void a() {
            if (UserInfoFragmentNew.this.aL != null) {
                UserInfoFragmentNew.this.aL.c();
            }
        }

        public void a(Fragment fragment) {
            if (UserInfoFragmentNew.this.d.contains(fragment)) {
                return;
            }
            UserInfoFragmentNew.this.d.add(fragment);
            notifyDataSetChanged();
        }

        public void a(UserInfoEntity userInfoEntity) {
            if (UserInfoFragmentNew.this.aJ != null) {
                UserInfoFragmentNew.this.aJ.a(userInfoEntity);
            }
        }

        public void a(boolean z) {
            if (UserInfoFragmentNew.this.aL != null) {
                UserInfoFragmentNew.this.aL.a(z);
            }
        }

        public void b(Fragment fragment) {
            if (UserInfoFragmentNew.this.d.contains(fragment)) {
                UserInfoFragmentNew.this.d.remove(fragment);
                notifyDataSetChanged();
            }
        }

        public void b(UserInfoEntity userInfoEntity) {
            if (UserInfoFragmentNew.this.aL != null) {
                UserInfoFragmentNew.this.aL.a(userInfoEntity);
            }
        }

        public void b(boolean z) {
            if (UserInfoFragmentNew.this.aK != null) {
                UserInfoFragmentNew.this.aK.a(z);
            }
        }

        public void c(UserInfoEntity userInfoEntity) {
            if (UserInfoFragmentNew.this.aK != null) {
                UserInfoFragmentNew.this.aK.b(userInfoEntity);
            }
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return UserInfoFragmentNew.this.f34018c.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return UserInfoFragmentNew.this.d.get(i);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int i) {
            return UserInfoFragmentNew.this.d.get(i).hashCode();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            if (obj instanceof Fragment) {
                int indexOf = UserInfoFragmentNew.this.d.indexOf(obj);
                if (indexOf != -1) {
                    return indexOf;
                }
                return -2;
            }
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return UserInfoFragmentNew.this.f34018c.get(i);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentNew$UserBgPagerAdapter.class */
    public class UserBgPagerAdapter extends PagerAdapter {
        public UserBgPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (UserInfoFragmentNew.this.aX != null) {
                return UserInfoFragmentNew.this.aX.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) UserInfoFragmentNew.this.aX.get(i));
            return UserInfoFragmentNew.this.aX.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private Animation A() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    private void B() {
        View findViewById = this.b.findViewById(R.id.v_blank_cover);
        this.bi = findViewById;
        findViewById.setVisibility(C() ? 0 : 8);
    }

    private boolean C() {
        UserBasicModel userBasicModel = this.E;
        boolean z = false;
        if (userBasicModel != null) {
            z = false;
            if (userBasicModel.uid != null) {
                z = false;
                if (this.E.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
                    String str = this.av;
                    z = false;
                    if (str != null) {
                        z = false;
                        if (str.equalsIgnoreCase("profile_avatar")) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    private void D() {
        if (C()) {
            if (this.ba != null) {
                g(false);
                postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$_VkkfjWzGvKJMp2aOxLWvlgw0Jk
                    @Override // java.lang.Runnable
                    public final void run() {
                        UserInfoFragmentNew.this.E();
                    }
                }, 200L);
            }
            View view = this.bi;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.ba.a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.Y.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.X.setVisibility(0);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$x5akf5E9GFGnxceW9AWcH8I3jw4
            @Override // java.lang.Runnable
            public final void run() {
                UserInfoFragmentNew.this.H();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        this.X.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        this.bc.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.i.postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.bc.postInvalidate();
    }

    private void a(int i, final String str) {
        if (i == 1) {
            this.aN.setVisibility(0);
            this.aN.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.30
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    WebViewShowInfoFragment.show(UserInfoFragmentNew.this.f34016a, str, -1);
                }
            });
        }
    }

    private void a(final int i, final String str, final VipProtos.FromType fromType) {
        PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipUpgradeModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.32
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipUpgradeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    PayUtils.a(UserInfoFragmentNew.this.f34016a, i, str, fromType);
                } else {
                    VipUpgradeDialogFragment.f34178a.a(UserInfoFragmentNew.this.getContext(), UserInfoFragmentNew.this.getParentFragmentManager(), bluedEntityA.data, 2, str, i);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2, String str3) {
                PayUtils.a(UserInfoFragmentNew.this.f34016a, i, str, fromType);
                return true;
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AlertDialog alertDialog, View view) {
        Tracker.onClick(view);
        alertDialog.cancel();
    }

    private static void a(Context context) {
        if (Build.MANUFACTURER.toLowerCase().equals(AssistUtils.BRAND_HW) && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(R.anim.activity_in_from_right_even_speed, R.anim.no_anim);
        }
    }

    public static void a(Context context, UserBasicModel userBasicModel, LiveRoomData liveRoomData, String str, boolean z, MsgSourceEntity msgSourceEntity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        bundle.putSerializable("live", liveRoomData);
        bundle.putString("userfrom", str);
        bundle.putBoolean("is_living", z);
        bundle.putSerializable("MSG_SOURCE_ENTITY", msgSourceEntity);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    public static void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, View view) {
        a(context, userBasicModel, bluedIngSelfFeed, str, false, view, (LogData) null, (MsgSourceEntity) null);
    }

    public static void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, boolean z, View view, LogData logData, MsgSourceEntity msgSourceEntity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        bundle.putSerializable(IAdInterListener.AdProdType.PRODUCT_FEEDS, bluedIngSelfFeed);
        bundle.putString("userfrom", str);
        bundle.putBoolean("is_living", z);
        bundle.putBoolean("is_shadow", userBasicModel.is_shadow == 1);
        bundle.putBoolean("is_reactive_recommend", userBasicModel.is_reactive_recommend == 1);
        boolean z2 = false;
        if (userBasicModel.is_call == 1) {
            z2 = true;
        }
        bundle.putBoolean("is_call", z2);
        bundle.putSerializable("LOG_DATA", logData);
        bundle.putSerializable("MSG_SOURCE_ENTITY", msgSourceEntity);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    public static void a(Context context, UserBasicModel userBasicModel, BluedIngSelfFeed bluedIngSelfFeed, String str, boolean z, MsgSourceEntity msgSourceEntity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        bundle.putSerializable(IAdInterListener.AdProdType.PRODUCT_FEEDS, bluedIngSelfFeed);
        bundle.putString("userfrom", str);
        bundle.putBoolean("is_living", z);
        bundle.putSerializable("MSG_SOURCE_ENTITY", msgSourceEntity);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    public static void a(Context context, UserBasicModel userBasicModel, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        bundle.putString("userfrom", str);
        bundle.putInt("tab", 0);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    public static void a(Context context, UserBasicModel userBasicModel, String str, View view) {
        a(context, userBasicModel, str, false, view, null, null);
    }

    public static void a(Context context, UserBasicModel userBasicModel, String str, View view, LogData logData, MsgSourceEntity msgSourceEntity) {
        a(context, userBasicModel, str, false, view, logData, msgSourceEntity);
    }

    public static void a(Context context, UserBasicModel userBasicModel, String str, boolean z, View view, LogData logData, MsgSourceEntity msgSourceEntity) {
        a(context, userBasicModel, (BluedIngSelfFeed) null, str, z, view, logData, msgSourceEntity);
    }

    public static void a(Context context, UserBasicModel userBasicModel, String str, boolean z, MsgSourceEntity msgSourceEntity) {
        a(context, userBasicModel, (BluedIngSelfFeed) null, str, z, msgSourceEntity);
    }

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", new UserBasicModel(str));
        bundle.putBoolean("IF_SHOW_WITH_ECOLOGY_VIEW", true);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    public static void a(Context context, String str, BluedIngSelfFeed bluedIngSelfFeed, String str2) {
        UserBasicModel userBasicModel = new UserBasicModel();
        String str3 = str;
        if (StringUtils.d(str)) {
            str3 = UserInfo.getInstance().getLoginUserInfo().uid;
        }
        userBasicModel.uid = str3;
        a(context, userBasicModel, bluedIngSelfFeed, str2, false, (MsgSourceEntity) null);
    }

    public static void a(Context context, String str, String str2) {
        UserBasicModel userBasicModel = new UserBasicModel();
        String str3 = str;
        if (StringUtils.d(str)) {
            str3 = UserInfo.getInstance().getLoginUserInfo().uid;
        }
        userBasicModel.uid = str3;
        a(context, userBasicModel, str2, false, (MsgSourceEntity) null);
    }

    public static void a(Context context, String str, String str2, MsgSourceEntity msgSourceEntity) {
        UserBasicModel userBasicModel = new UserBasicModel();
        String str3 = str;
        if (StringUtils.d(str)) {
            str3 = UserInfo.getInstance().getLoginUserInfo().uid;
        }
        userBasicModel.uid = str3;
        a(context, userBasicModel, str2, false, msgSourceEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        this.n.k();
        this.N.isAddFollow = false;
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FOLLOWED_BTN_CLICK, this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.setScaleX(floatValue);
        view.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, AlertDialog alertDialog, View view2) {
        Tracker.onClick(view2);
        ImageUtils.a(c(view));
        alertDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FrameLayout.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2, ValueAnimator valueAnimator) {
        float intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 100.0f;
        float f = 1.0f - intValue;
        this.ad.setAlpha(f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams3.topMargin = (int) (this.aG - ((DensityUtils.a(this.f34016a, 44.0f) + this.aG) * intValue));
        this.e.setLayoutParams(layoutParams3);
        if (this.I) {
            this.aw.setAlpha(f);
        }
        int i = AppInfo.l / 4;
        int i2 = (int) ((-i) * f);
        layoutParams.topMargin = i2;
        this.bb.setLayoutParams(layoutParams);
        layoutParams2.topMargin = i2;
        this.l.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.aY.getLayoutParams();
        layoutParams4.topMargin = (int) ((this.aF + ((int) Math.abs(i * intValue * 2.0f)) + 130) * 2.2f);
        Log.e("xxxx", "getVIPBgClickAnim: topmargin=" + layoutParams4.topMargin);
        this.aY.setLayoutParams(layoutParams4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ImageView imageView, View view) {
        Tracker.onClick(view);
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PROFILE_GIFT_LIST_CLICK);
        WebViewShowInfoFragment.show(this.f34016a, H5Url.a(44), 0);
        imageView.setVisibility(8);
        if (BluedPreferences.aR()) {
            return;
        }
        BluedPreferences.aS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(TextView textView, AppBarLayout appBarLayout, int i) {
        int a2 = DensityUtils.a(this.f34016a, 100.0f);
        int a3 = DensityUtils.a(this.f34016a, 50.0f);
        int abs = Math.abs(i);
        if (abs > 0) {
            if (!this.n.h()) {
                this.s.setVisibility(0);
                this.r.setVisibility(0);
            }
            this.p.setVisibility(8);
        }
        float min = (Math.min(abs, a2) - a3) / (a2 - a3);
        this.f.setAlpha(min);
        this.am.setAlpha(min);
        textView.setAlpha(min);
        float f = 1.0f - min;
        this.e.setAlpha(f);
        if (f <= 0.5f) {
            this.e.setClickable(false);
        }
        int[] iArr = new int[2];
        this.i.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        this.bc.getLocationOnScreen(iArr2);
        if (iArr[1] < iArr2[1]) {
            this.bc.setBackgroundColor(BluedSkinUtils.a(AppInfo.d(), 2131101780));
            this.bc.setVisibility(0);
        } else {
            this.bc.setVisibility(8);
        }
        LinePageIndicator linePageIndicator = this.aV;
        if (linePageIndicator != null && linePageIndicator.getVisibility() == 0) {
            this.aV.setAlpha(f);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (!BluedSkinUtils.c()) {
                StatusBarHelper.a((Activity) activity, false);
            } else if (f > 0.5f) {
                StatusBarHelper.a((Activity) activity, false);
            } else {
                StatusBarHelper.a((Activity) activity, true);
            }
        }
        this.P = i;
    }

    public static void a(Fragment fragment, UserBasicModel userBasicModel, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        bundle.putString("userfrom", str);
        TerminalActivity.a(bundle);
        TerminalActivity.a(fragment, UserInfoFragmentNew.class, bundle, i);
        a(fragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ImageSize imageSize, ImageView imageView, UserInfoEntity userInfoEntity, File file, Exception exc) {
        int a2 = (int) ((imageSize.a() / imageSize.b()) * DensityUtils.a(this.f34016a, 35.0f));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = a2;
        layoutParams.height = DensityUtils.a(this.f34016a, 35.0f);
        imageView.setLayoutParams(layoutParams);
        ImageLoader.a(getFragmentActive(), userInfoEntity.match_activity.icon).a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        FindHttpUtils.b(userInfoEntity.match_activity.click_url);
        if (StringUtils.d(userInfoEntity.match_activity.url)) {
            return;
        }
        if (userInfoEntity.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
            InstantLog.g("event_access", "1");
        } else {
            InstantLog.g("event_access", "2");
        }
        WebViewShowInfoFragment.show(this.f34016a, userInfoEntity.match_activity.url, -1);
        ChatHelperV4.a().a(12L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(UserInfoEntity userInfoEntity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        UserinfoNewAlbumAdapter userinfoNewAlbumAdapter = this.aE;
        if (userinfoNewAlbumAdapter == null || i >= userinfoNewAlbumAdapter.getData().size() || this.aE.getData().get(i) == null) {
            return;
        }
        BluedAlbum item = this.aE.getItem(i);
        int i2 = item.applyStatus;
        int i3 = 1;
        if (i2 == 1) {
            k();
            EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_PROFILE_PAGE_APPLY_PHOTO_CLICK, this.E.uid);
        } else if (i2 == 2) {
            AppMethods.d((int) R.string.apply_has_been_set);
        } else {
            if (!this.n.e ? item.applyStatus != 0 : userInfoEntity.access_private_photos != 2) {
                i3 = 0;
            }
            AlbumForDataTrans albumForDataTrans = new AlbumForDataTrans();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.aE.getData().size()) {
                    break;
                }
                AlbumFlow albumFlow = new AlbumFlow();
                albumFlow.isSelf = this.n.e;
                albumFlow.isFeed = 0;
                albumFlow.album_status = i3;
                albumFlow.album_pics_num = this.aE.getData().size();
                albumFlow.album_pic = this.aE.getData().get(i5).getUrl();
                albumFlow.pid = this.aE.getData().get(i5).getPid();
                albumForDataTrans.data.add(albumFlow);
                i4 = i5 + 1;
            }
            BasePhotoFragment.a(this.f34016a, albumForDataTrans, i, 15, TextUtils.equals(userInfoEntity.uid, UserInfo.getInstance().getLoginUserInfo().uid) ? null : userInfoEntity.name, userInfoEntity.uid, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(UserInfoEntity userInfoEntity, String str, View view) {
        Tracker.onClick(view);
        Long l = (userInfoEntity.liveshow == null || userInfoEntity.liveshow.session_id == null) ? null : userInfoEntity.liveshow.session_id;
        PersonalProfileProtos.Event event = PersonalProfileProtos.Event.PERSONAL_PHOTO_CLICK;
        String str2 = userInfoEntity.uid;
        EventTrackPersonalProfile.b(event, str2, l + "");
        if (userInfoEntity.liveshow != null && userInfoEntity.liveshow.session_id != null) {
            l(userInfoEntity);
        } else if (userInfoEntity.voice_broadcast != null && userInfoEntity.voice_broadcast.room_id != null && userInfoEntity.voice_broadcast.uid != null) {
            EventTrackYY.f(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_ENTER_CLICK, userInfoEntity.voice_broadcast.room_id, userInfoEntity.voice_broadcast.uid, userInfoEntity.voice_broadcast.room_type);
            this.n.e(userInfoEntity.voice_broadcast.room_id);
        } else {
            if (this.W && UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                this.U.setVisibility(8);
                BluedPreferences.cU();
            }
            BasePhotoFragment.a(this.f34016a, new String[]{str}, 0, 1, userInfoEntity.uid, TextUtils.equals(userInfoEntity.uid, UserInfo.getInstance().getLoginUserInfo().uid) ? null : userInfoEntity.name, userInfoEntity.theme_pendant);
        }
    }

    private void a(String str) {
        if (Build.VERSION.SDK_INT != 18) {
            ClipboardManager clipboardManager = (ClipboardManager) this.f34016a.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData newPlainText = ClipData.newPlainText("simple text", RegExpUtils.a(str));
            if (clipboardManager != null) {
                try {
                    clipboardManager.setPrimaryClip(newPlainText);
                } catch (Exception e) {
                }
            }
        } else {
            ((android.text.ClipboardManager) this.f34016a.getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(str));
        }
        AppMethods.a((CharSequence) this.f34016a.getResources().getString(2131887353));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, String str5, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener, File file, Exception exc) {
        ShareEntity a2 = ShareUtils.a().a(this.f34016a, str, this.Q, (file == null || !file.exists()) ? BitmapFactory.decodeResource(this.f34016a.getResources(), 2131237314) : BitmapFactory.decodeFile(file.getPath()), str2, str3, str4, str4, this.n.e());
        a2.r = str5;
        Log.v("drb", "outShareContent:" + str5);
        UserProfileBtmOptions userProfileBtmOptions = this.aa;
        if (userProfileBtmOptions != null) {
            userProfileBtmOptions.a(a2, this.n.e(), shareOptionsItemClickListener);
            InstantLog.a("user_page_option_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, int i) {
        if (i == 1) {
            ServiceMenuDialogFragment.b.a(getFragmentManager(), list, TextUtils.isEmpty(this.E.uid) ? this.n.e().uid : this.E.uid);
            this.g.setCurrentItem(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, View view) {
        Tracker.onClick(view);
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PROFILE_ACTIVITY_CLICK, this.n.e().uid, ((EventDetailsModel) list.get(1)).id);
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(((EventDetailsModel) list.get(1)).id);
        eventLogData.setSourcePage(FeedProtos.SourcePage.FEED_PERSONAL_FEED);
        EventDetailsFragment.f19534a.a(this.f34016a, ((EventDetailsModel) list.get(1)).id, eventLogData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(LinearLayout linearLayout, View view) {
        b(linearLayout);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(String str, View view) {
        a(str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Log.v("drb", "个人主页 setAvatarWidget：" + i);
        ImageLoader.a(getFragmentActive(), AvatarWidgetManager.a().a(i)).a(this.S);
        ImageLoader.a(getFragmentActive(), AvatarWidgetManager.a().a(i)).a(this.T);
    }

    public static void b(Context context, String str, String str2) {
        UserBasicModel userBasicModel = new UserBasicModel();
        String str3 = str;
        if (StringUtils.d(str)) {
            str3 = UserInfo.getInstance().getLoginUserInfo().uid;
        }
        userBasicModel.uid = str3;
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        bundle.putString("userfrom", str2);
        bundle.putInt("tab", 0);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        this.n.o();
    }

    private void b(final View view) {
        final AlertDialog create = new AlertDialog.Builder(getActivity()).create();
        create.setCanceledOnTouchOutside(true);
        Window window = create.getWindow();
        window.setGravity(80);
        window.setBackgroundDrawable(new ColorDrawable(0));
        create.show();
        window.setContentView(R.layout.dialog_qr_save);
        window.findViewById(R.id.qr_dialog_view).startAnimation(A());
        ((TextView) window.findViewById(R.id.cancel_agree)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$g_cCyLCfKgOPfQS5BlwaQMnUWjc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserInfoFragmentNew.a(AlertDialog.this, view2);
            }
        });
        ((TextView) window.findViewById(R.id.qr_dialog_save)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$roLCpO9zgbCzziI1NCukHrmuhuk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserInfoFragmentNew.this.a(view, create, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        view.setScaleX(floatValue);
        view.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        Context context = this.f34016a;
        String str = userInfoEntity.uid;
        String str2 = userInfoEntity.name;
        boolean z = true;
        if (userInfoEntity.is_official == 1) {
            z = false;
        }
        ReportUserFragment.a(context, str, str2, z);
    }

    private void b(final List<EventDetailsModel> list) {
        if (list == null || list.size() <= 0) {
            this.ay.setVisibility(8);
            return;
        }
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PROFILE_ACTIVITY_SHOW, this.n.e().uid, list.get(0).id);
        this.ay.setVisibility(0);
        TextView textView = this.aB;
        textView.setText(list.get(0).name + "活动");
        this.az.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$F3V9DBsZ_D8p5iIa8fgtujiYP3c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.b(list, view);
            }
        });
        if (list.size() <= 1) {
            this.aA.setVisibility(8);
            return;
        }
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PROFILE_ACTIVITY_SHOW, this.n.e().uid, list.get(1).id);
        this.aA.setVisibility(0);
        TextView textView2 = this.aC;
        textView2.setText(list.get(1).name + "活动");
        this.aA.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$GkUIgLbf1NLOsfneFzeFUcqnnNI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.a(list, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list, int i) {
        if (i == 1) {
            ServiceMenuDialogFragment.b.a(getFragmentManager(), list, TextUtils.isEmpty(this.E.uid) ? this.n.e().uid : this.E.uid);
            this.g.setCurrentItem(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list, View view) {
        Tracker.onClick(view);
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PROFILE_ACTIVITY_CLICK, this.n.e().uid, ((EventDetailsModel) list.get(0)).id);
        EventLogData eventLogData = new EventLogData();
        eventLogData.setEventId(((EventDetailsModel) list.get(0)).id);
        eventLogData.setSourcePage(FeedProtos.SourcePage.FEED_PERSONAL_FEED);
        EventDetailsFragment.f19534a.a(this.f34016a, ((EventDetailsModel) list.get(0)).id, eventLogData);
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return SubscribeNumberManager.f32449a.a(str, (Short) 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(String str, View view) {
        a(str);
        return true;
    }

    private Bitmap c(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i) {
        boolean z = false;
        switch (i) {
            case R.string.add_comment /* 2131886306 */:
                InstantLog.b("user_page_options_click", 2);
                EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, this.E.uid, 2);
                this.n.f();
                return;
            case R.string.add_to_black /* 2131886308 */:
            case R.string.remove_from_black /* 2131891486 */:
                InstantLog.b("user_page_options_click", 3);
                EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, this.E.uid, 3);
                this.n.l();
                return;
            case R.string.allow_visit_privacy_photo_album /* 2131886406 */:
            case R.string.no_access_privacy_photo_album /* 2131891052 */:
                if (this.n.e().access_private_photos == 1) {
                    InstantLog.b("user_page_options_click", 1);
                    EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, this.E.uid, 1);
                    this.n.m();
                    return;
                }
                InstantLog.b("user_page_options_click", 0);
                EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, this.E.uid, 0);
                this.n.n();
                return;
            case R.string.cancel_invisible_to_he /* 2131886889 */:
                this.n.a(true);
                EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_MORE_HIDE_CANCEL_CLICK, this.n.e().uid);
                return;
            case R.string.follow_secretly /* 2131888168 */:
                EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_PROFILE_MORE_FOLLOW_CLICK, this.n.e().uid);
                InstantLog.b("user_page_options_click", 6);
                EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, this.E.uid, 6);
                if (BluedConfig.a().g().is_secretly_followed == 1 || UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) {
                    this.n.p();
                    return;
                } else {
                    a(22, "user_follow_secret", VipProtos.FromType.UNKNOWN_FROM);
                    return;
                }
            case 2131888173:
                EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_PROFILE_MORE_UNFOLLOW_CLICK, this.n.e().uid);
                Context context = this.f34016a;
                CommonAlertDialog.a(context, (String) null, context.getResources().getString(2131886888), this.f34016a.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$w4F76YXIIgz21iW-dltynqkZ5ns
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        UserInfoFragmentNew.this.b(dialogInterface, i2);
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                return;
            case R.string.invisible_to_he /* 2131889033 */:
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) {
                    this.n.a(false);
                } else {
                    a(10002, "vip_hide_for", VipProtos.FromType.VIP_HIDE_FOR);
                }
                EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_MORE_HIDE_CLICK, this.n.e().uid);
                return;
            case R.string.qr_code /* 2131891384 */:
                z();
                return;
            case 2131891497:
                InstantLog.b("user_page_options_click", 4);
                EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, this.E.uid, 4);
                Context context2 = this.f34016a;
                String str = this.n.e().uid;
                String str2 = this.n.e().name;
                if (this.n.e().is_official != 1) {
                    z = true;
                }
                ReportUserFragment.a(context2, str, str2, z);
                return;
            default:
                return;
        }
    }

    public static void c(Context context, String str, String str2) {
        UserBasicModel userBasicModel = new UserBasicModel();
        String str3 = str;
        if (StringUtils.d(str)) {
            str3 = UserInfo.getInstance().getLoginUserInfo().uid;
        }
        userBasicModel.uid = str3;
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", userBasicModel);
        bundle.putString("userfrom", str2);
        bundle.putInt("tab", 1);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        this.n.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        UserGiftDialogFragment.a(getActivity(), getFragmentActive(), userInfoEntity.uid, "user_page_gift", new UserGiftDialogFragment.BuySucceedListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.17
            @Override // com.soft.blued.ui.msg.pop.UserGiftDialogFragment.BuySucceedListener
            public void a(UserGiftDialogFragment userGiftDialogFragment, GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
                userGiftDialogFragment.dismiss();
                UserInfoFragmentNew.this.a(giftGivingOptionForJsonParse);
            }
        }, userInfoEntity.relationship, userInfoEntity.name, new int[0]);
    }

    public static void d(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.name = str;
        bundle.putSerializable("user", userBasicModel);
        bundle.putString("userfrom", str2);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, UserInfoFragmentNew.class, bundle);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public /* synthetic */ void d(UserInfoEntity userInfoEntity, View view) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        m(userInfoEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        f(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        w(userInfoEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        this.N.is_super_call = this.n.e().super_call_status == 1;
        if (!"1".equals(this.n.e().relationship) && !"3".equals(this.n.e().relationship)) {
            this.n.k();
            this.N.isAddFollow = true;
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FOLLOWED_BTN_CLICK, this.N);
            this.aQ.performClick();
        } else if (this.aH) {
            Context context = this.f34016a;
            CommonAlertDialog.a(context, context.getResources().getString(R.string.group_notice_title), this.f34016a.getResources().getString(R.string.group_quit_attention_notice), this.f34016a.getResources().getString(R.string.group_dialog_not_attention_confirm), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.34
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    UserInfoFragmentNew.this.n.k();
                    UserInfoFragmentNew.this.N.isAddFollow = false;
                    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_FOLLOWED_BTN_CLICK, UserInfoFragmentNew.this.N);
                }
            }, this.f34016a.getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.35
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                }
            }, (DialogInterface.OnDismissListener) null);
        } else {
            Context context2 = this.f34016a;
            CommonAlertDialog.a(context2, context2.getResources().getString(R.string.common_string_notice), this.f34016a.getResources().getString(2131886888), this.f34016a.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$XNYg4z6DdZQ5w-MbDsu2S6PNSEM
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UserInfoFragmentNew.this.a(dialogInterface, i);
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
        if (TextUtils.equals(this.au, "msg_hello") || TextUtils.equals(this.au, "msg_hello_detail")) {
            String str = TextUtils.equals(this.au, "msg_hello") ? "APPRECIATE_CALL_SHORT" : "APPRECIATE_CALL_TOTAL";
            ProfileEventUtils.a(str, this.N.target_uid, this.N.isAddFollow + "", this.N.is_hello, this.N.is_feed_super_exposure + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        w(userInfoEntity);
    }

    private void g(boolean z) {
        if (this.bg) {
            return;
        }
        this.ba.a(z);
        this.bj = true;
        this.f.setVisibility(8);
        if (z) {
            MediaUtils.a().a(80L);
        }
        this.aV.setVisibility(8);
        this.aT.b(true);
        a(false);
        this.bf.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aZ.getLayoutParams();
        layoutParams.topMargin = 0;
        this.aZ.setLayoutParams(layoutParams);
        this.bg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        v(userInfoEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        Tracker.onClick(view);
        this.n.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        v(userInfoEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        Tracker.onClick(view);
        this.n.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        Tracker.onClick(view);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        Tracker.onClick(view);
        if (this.f.getAlpha() > 0.5f) {
            this.Q.callOnClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(this.f34016a, H5Url.a(46), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        Tracker.onClick(view);
        l();
    }

    private void n(UserInfoEntity userInfoEntity) {
        ShapeTextView shapeTextView = (ShapeTextView) this.b.findViewById(R.id.stv_audited_status);
        if (!this.n.e) {
            shapeTextView.setVisibility(8);
            return;
        }
        BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
        if (loginUserInfo.is_audited == 0) {
            shapeTextView.setVisibility(0);
            if (loginUserInfo.avatar_audited == 0) {
                shapeTextView.setText(R.string.audited_picture_profile_in_review);
            } else {
                shapeTextView.setText(R.string.audited_profile_in_review);
            }
        } else if (loginUserInfo.avatar_audited != 0) {
            shapeTextView.setVisibility(8);
        } else {
            shapeTextView.setVisibility(0);
            shapeTextView.setText(R.string.audited_picture_in_review);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        Tracker.onClick(view);
        l();
    }

    private void o(UserInfoEntity userInfoEntity) {
        if (this.ba != null) {
            return;
        }
        List<View> list = this.aX;
        if (list == null || list.size() <= 1) {
            this.aX.clear();
            this.V.c(this.n.s());
            this.bd = (TextView) this.b.findViewById(R.id.tv_user_face_guide);
            this.be = (LinearLayout) this.b.findViewById(R.id.ll_user_face_guide);
            int i = 8;
            if (this.n.s()) {
                this.aZ.setVisibility(0);
                FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putString(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY, userInfoEntity.uid);
                bundle.putInt("saved_face", userInfoEntity.users_face);
                VirtualImageFragment virtualImageFragment = new VirtualImageFragment();
                this.ba = virtualImageFragment;
                virtualImageFragment.setArguments(bundle);
                this.ba.a(new VirtualImageFragment.BackListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.20
                    @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.BackListener
                    public void a() {
                        if (!UserInfoFragmentNew.this.bj) {
                            UserInfoFragmentNew.this.x();
                            return;
                        }
                        if (UserInfoFragmentNew.this.bh) {
                            UserInfoFragmentNew.this.bh = false;
                        }
                        UserInfoFragmentNew.this.ba.a(8);
                        UserInfoFragmentNew.this.f.setVisibility(0);
                        UserInfoFragmentNew.this.bf.setVisibility(0);
                        UserInfoFragmentNew.this.bj = false;
                        UserInfoFragmentNew.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.20.1
                            @Override // java.lang.Runnable
                            public void run() {
                                UserInfoFragmentNew.this.aV.setVisibility(0);
                                UserInfoFragmentNew.this.aT.c();
                                UserInfoFragmentNew.this.a(true);
                            }
                        }, 200L);
                        UserInfoFragmentNew.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.20.2
                            @Override // java.lang.Runnable
                            public void run() {
                                UserInfoFragmentNew.this.bg = false;
                            }
                        }, 1200L);
                    }
                });
                supportFragmentManager.beginTransaction().add(R.id.bg_frame_layout, this.ba, "virtualImage").commitAllowingStateLoss();
            } else {
                this.aZ.setVisibility(8);
                this.bf.setVisibility(0);
            }
            if (this.n.s()) {
                View inflate = View.inflate(this.f34016a, R.layout.userinfo_vip_bg, null);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.21
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        UserInfoFragmentNew.this.bh = true;
                        UserInfoFragmentNew.this.t();
                    }
                });
                this.aX.add(inflate);
            }
            View inflate2 = View.inflate(this.f34016a, R.layout.userinfo_vip_bg, null);
            this.aX.add(inflate2);
            inflate2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    UserInfoFragmentNew.this.aZ.setVisibility(8);
                    UserInfoFragmentNew.this.bf.setVisibility(0);
                    UserInfoFragmentNew.this.f();
                }
            });
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aU.getLayoutParams();
            layoutParams.height = (int) ((this.aF + 130) * 3.0f);
            this.aU.setLayoutParams(layoutParams);
            final UserBgPagerAdapter userBgPagerAdapter = new UserBgPagerAdapter();
            this.aU.setAdapter(userBgPagerAdapter);
            this.aU.setCurrentItem(1 ^ this.n.t());
            this.aV.setViewPager(this.aU);
            LinePageIndicator linePageIndicator = this.aV;
            if (this.n.s()) {
                i = 0;
            }
            linePageIndicator.setVisibility(i);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.23
                @Override // java.lang.Runnable
                public void run() {
                    userBgPagerAdapter.notifyDataSetChanged();
                    UserInfoFragmentNew.this.aU.requestLayout();
                }
            }, 100L);
            this.aU.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.24
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f, int i3) {
                    if (2.0f * f >= 1.0f || !UserInfoFragmentNew.this.n.s()) {
                        return;
                    }
                    if (i2 == 0) {
                        float f2 = f * 3.0f;
                        UserInfoFragmentNew.this.aZ.setAlpha(1.0f - f2);
                        UserInfoFragmentNew.this.bf.setAlpha(f2);
                        return;
                    }
                    float f3 = f * 3.0f;
                    UserInfoFragmentNew.this.aZ.setAlpha(f3);
                    UserInfoFragmentNew.this.bf.setAlpha(1.0f - f3);
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    UserInfoFragmentNew.this.aW = i2;
                    SmartRefreshLayout smartRefreshLayout = UserInfoFragmentNew.this.V;
                    boolean z = true;
                    if (!UserInfoFragmentNew.this.n.s() || UserInfoFragmentNew.this.aW == 1) {
                        z = false;
                    }
                    smartRefreshLayout.c(z);
                    if (UserInfoFragmentNew.this.n.s() && i2 == 0) {
                        UserInfoFragmentNew.this.w();
                    }
                }
            });
            if (this.n.t()) {
                w();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        Tracker.onClick(view);
        m();
    }

    private void p(UserInfoEntity userInfoEntity) {
        long fD = BluedPreferences.fD();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - fD <= 604800 || TextUtils.isEmpty(userInfoEntity.recommendation) || !this.n.e) {
            return;
        }
        CommonGuidePop commonGuidePop = new CommonGuidePop(this.f34016a, userInfoEntity.recommendation, NinePatchUtils.GuideArrowPosition.RIGHT, 2131232900);
        final BasePopupView h = new XPopup.Builder(getContext()).a(this.ak).d((Boolean) false).b(DensityUtils.a(this.f34016a, 10.0f)).c(DensityUtils.a(this.f34016a, 5.0f)).a(PopupPosition.Bottom).a(PopupAnimation.ScaleAlphaFromCenter).a((BasePopupView) commonGuidePop).h();
        commonGuidePop.setOnClick(new CommonGuidePop.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.28
            @Override // com.blued.android.module.common.view.CommonGuidePop.OnClickListener
            public void a() {
                FeedAddPostFragment.a(UserInfoFragmentNew.this.f34016a);
                if (h.s()) {
                    h.p();
                }
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.29
            @Override // java.lang.Runnable
            public void run() {
                if (h.s()) {
                    h.p();
                }
            }
        }, 5000L);
        BluedPreferences.E(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        Tracker.onClick(view);
        m();
    }

    private void q(UserInfoEntity userInfoEntity) {
        if (userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid) || !ByteDanceLogUtils.f20624a.c()) {
            return;
        }
        this.aQ.setVisibility(0);
        this.aQ.setOnClickListener(this);
    }

    private void r() {
        LiveEventBus.get("remove_album", String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                UserInfoFragmentNew.this.aE.a(false, str);
            }
        });
        LiveEventBus.get("feed_avatar_widget", Integer.class).observe(this, new Observer<Integer>() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Integer num) {
                if (TextUtils.equals(UserInfoFragmentNew.this.n.e().uid, UserInfo.getInstance().getLoginUserInfo().uid)) {
                    UserInfoFragmentNew.this.b(num.intValue());
                }
            }
        });
        LiveEventBus.get("common_clear_group_member_state", String.class).observe(this, new Observer<String>() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.3
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.equals(str, UserInfoFragmentNew.this.n.e().uid)) {
                    UserInfoFragmentNew.this.aH = false;
                    GroupUtil.b(UserInfoFragmentNew.this.n.e().fans_group);
                }
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_MENU_TO_MSG, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                if (bool.booleanValue()) {
                    UserInfoFragmentNew.this.q();
                }
            }
        });
        ProfileEventUtils.a("PROFILE_WRITE_PAGE_SHOW");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        Tracker.onClick(view);
        if (YYRoomInfoManager.e().y()) {
            AppMethods.a(this.f34016a.getResources().getText(2131893032));
        } else if (PopMenuUtils.a(this.f34016a)) {
        } else {
            InstantLog.a("modify_user_profile", (Object) 1);
            ModifyUserInfoFragment.a(this, 601);
        }
    }

    private void r(UserInfoEntity userInfoEntity) {
        if (StringUtils.d(userInfoEntity.dirty_notice)) {
            this.aS.setVisibility(8);
            return;
        }
        this.aS.setText(userInfoEntity.dirty_notice);
        this.aS.setVisibility(0);
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PUNISH_TOAST_SHOW);
    }

    private void s() {
        this.ay = (LinearLayout) this.b.findViewById(R.id.ll_event_all);
        this.az = this.b.findViewById(R.id.ll_event_1);
        this.aA = this.b.findViewById(R.id.ll_event_2);
        this.aB = (TextView) this.b.findViewById(R.id.tv_event_1);
        this.aC = (TextView) this.b.findViewById(R.id.tv_event_2);
        View findViewById = this.b.findViewById(R.id.img_vip_bg_top_shadow);
        this.ad = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (UserInfoFragmentNew.this.aW != 0) {
                    UserInfoFragmentNew.this.f();
                } else if (!UserInfoFragmentNew.this.n.s()) {
                    UserInfoFragmentNew.this.f();
                } else {
                    UserInfoFragmentNew.this.bh = true;
                    UserInfoFragmentNew.this.t();
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R.id.recycler_list_albums);
        this.aD = recyclerView;
        recyclerView.setBackgroundColor(BluedSkinUtils.a(this.f34016a, 2131101780));
        this.am = (FrameLayout) this.b.findViewById(R.id.btm_btn);
        this.al = (ImageView) this.b.findViewById(R.id.img_btm_btn);
        this.am.setOnClickListener(this);
        this.am.setAlpha(0.0f);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.btn_chat);
        this.aj = linearLayout;
        linearLayout.setOnClickListener(this);
        View findViewById2 = this.b.findViewById(2131362623);
        this.ak = findViewById2;
        findViewById2.setOnClickListener(this);
        ShapeTextView shapeTextView = (ShapeTextView) this.b.findViewById(R.id.btn_follow);
        this.ag = shapeTextView;
        shapeTextView.setOnClickListener(this);
        GroupJoinView groupJoinView = (GroupJoinView) this.b.findViewById(R.id.btn_group);
        this.ai = groupJoinView;
        groupJoinView.setTextSize(14.0f);
        this.ai.setText(getString(R.string.group_fans_club));
        this.ai.setIconVisibility(8);
        this.ai.setStrokeColor(2131101766);
        ShapeTextView shapeTextView2 = (ShapeTextView) this.b.findViewById(R.id.btn_bar_follow);
        this.ah = shapeTextView2;
        shapeTextView2.setOnClickListener(this);
        this.aY = (LinearLayout) this.b.findViewById(2131363785);
        this.aT = (TwoLevelHeader) this.b.findViewById(R.id.two_level_header);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.b.findViewById(2131369119);
        this.V = smartRefreshLayout;
        smartRefreshLayout.k(false);
        this.V.f(0.0f);
        a(this.V);
        this.l = (ShapeTextView) this.b.findViewById(R.id.tv_auditing);
        CustomViewPager customViewPager = (CustomViewPager) this.b.findViewById(2131373100);
        this.g = customViewPager;
        customViewPager.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        this.g.setOffscreenPageLimit(3);
        this.v = DialogUtils.a(this.f34016a);
        RotateLayout rotateLayout = (RotateLayout) this.b.findViewById(R.id.rotateLayout);
        this.p = rotateLayout;
        rotateLayout.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams.topMargin = this.aG;
        this.p.setLayoutParams(layoutParams);
        LoadOptions loadOptions = new LoadOptions();
        this.m = loadOptions;
        loadOptions.d = R.drawable.vip_userpage_default;
        this.m.b = R.drawable.vip_userpage_default;
        this.aZ = (FrameLayout) this.b.findViewById(R.id.bg_frame_layout);
        this.aU = (CustomViewPager) this.b.findViewById(R.id.vp_bg);
        this.aV = (LinePageIndicator) this.b.findViewById(2131364744);
        this.bf = (LinearLayout) this.b.findViewById(R.id.view_multi_avatars);
        ImageView imageView = (ImageView) this.b.findViewById(R.id.img_vip_bg);
        this.bb = imageView;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = AppInfo.l;
        layoutParams2.height = layoutParams2.width;
        layoutParams2.topMargin = (-AppInfo.l) / 3;
        this.bb.setLayoutParams(layoutParams2);
        this.bb.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$M4bR3gbhu8pOv4_CUEAUUoRGRL8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.w(view);
            }
        });
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams3.width = AppInfo.l;
        layoutParams3.height = layoutParams3.width;
        layoutParams3.topMargin = (-AppInfo.l) / 4;
        this.l.setLayoutParams(layoutParams3);
        this.j = (ImageView) this.b.findViewById(R.id.img_edit_white);
        this.k = (ImageView) this.b.findViewById(R.id.img_edit_black);
        a(this.j);
        a(this.k);
        FeedBubbleProfileView feedBubbleProfileView = (FeedBubbleProfileView) this.b.findViewById(R.id.feed_bubble_profile_view_id);
        this.q = feedBubbleProfileView;
        feedBubbleProfileView.setFragment(this);
        this.X = this.b.findViewById(R.id.feed_bubble_profile_guest_guide);
        this.Y = this.b.findViewById(R.id.feed_bubble_profile_guest_poke_guide);
        this.Z = (TextView) this.b.findViewById(R.id.feed_bubble_poke_guide_tv);
        this.A = this.b.findViewById(R.id.ll_in_black);
        this.B = (TextView) this.b.findViewById(2131372428);
        this.C = (TextView) this.b.findViewById(R.id.tv_black_him);
        this.D = (TextView) this.b.findViewById(R.id.tv_add_comment);
        this.w = (TextView) this.b.findViewById(2131372876);
        this.S = (ImageView) this.b.findViewById(2131365108);
        this.T = (ImageView) this.b.findViewById(R.id.img_bar_avatar_widget);
        ((AppBarLayout.Behavior) ((CoordinatorLayout.LayoutParams) ((AppBarLayout) this.b.findViewById(2131362292)).getLayoutParams()).getBehavior()).setDragCallback(new AppBarLayout.Behavior.DragCallback() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.6
            @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior.BaseDragCallback
            public boolean canDrag(AppBarLayout appBarLayout) {
                return true;
            }
        });
        this.an = this.b.findViewById(2131364391);
        this.ao = this.b.findViewById(R.id.icon_btm_red_dot);
        this.aI = (LinearLayout) this.b.findViewById(R.id.ll_user_gift);
        this.aN = (LinearLayout) this.b.findViewById(R.id.ll_number_collection);
        this.aP = (FrameLayout) this.b.findViewById(R.id.fm_poke);
        this.aQ = (ShapeRelativeLayout) this.b.findViewById(R.id.btn_recommend_list);
        this.aR = (ImageView) this.b.findViewById(R.id.iv_recommend_arrow);
        this.aS = (TextView) this.b.findViewById(2131372124);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        Tracker.onClick(view);
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BACKGROUND_CHANGE_CLICK);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            PayUtils.a(this.f34016a, "personal_background_change", 25, VipProtos.FromType.UNKNOWN_FROM);
        } else {
            PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.11
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    PhotoSelectFragment.a(UserInfoFragmentNew.this, 14, 178);
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                }
            });
        }
    }

    private void s(UserInfoEntity userInfoEntity) {
        if (userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().getUid())) {
            return;
        }
        if (userInfoEntity.poke_days <= 0) {
            this.aP.setVisibility(8);
            return;
        }
        this.aP.setVisibility(0);
        this.aP.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        g(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        Tracker.onClick(view);
        this.n.j();
    }

    private void t(UserInfoEntity userInfoEntity) {
        View findViewById = this.b.findViewById(R.id.ll_user_kol);
        if (TextUtils.isEmpty(userInfoEntity.kol_name)) {
            findViewById.setVisibility(8);
            return;
        }
        findViewById.setVisibility(0);
        ((TextView) this.b.findViewById(2131372877)).setText(userInfoEntity.kol_name);
    }

    private void u() {
        this.ac = (AppBarLayout) this.b.findViewById(2131362292);
        View findViewById = this.b.findViewById(2131370717);
        this.e = findViewById;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = StatusBarHelper.a(this.f34016a);
        this.e.setLayoutParams(layoutParams);
        this.f = this.b.findViewById(R.id.title_scroll);
        this.e.setAlpha(1.0f);
        this.r = (ImageView) this.e.findViewById(2131363128);
        this.s = (ImageView) this.f.findViewById(R.id.ctt_bar_right_img);
        ImageView imageView = (ImageView) this.e.findViewById(2131363123);
        this.t = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$SM4ClZWYhXxf8VRNtjmfpdwR0MU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.q(view);
            }
        });
        ImageView imageView2 = (ImageView) this.f.findViewById(R.id.ctt_bar_left_img);
        this.u = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$TlqfTCuYGUS2x8vz0Xo7AQvPtmU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.p(view);
            }
        });
        this.f.setAlpha(0.0f);
        final TextView textView = (TextView) this.b.findViewById(2131372815);
        textView.setAlpha(0.0f);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.height = StatusBarHelper.a(this.f34016a);
        textView.setLayoutParams(layoutParams2);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$wCsHwYqTxX6aOXuEt0nvCQ8vti8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.o(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$z7pPxQud-M6ok7qbDv7CIRe3bBo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.n(view);
            }
        });
        this.ac.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$gjHjuBTrbs_D_e86ou75wYp-RK4
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                UserInfoFragmentNew.this.a(textView, appBarLayout, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        Tracker.onClick(view);
        h();
    }

    private void u(final UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid) || (b(userInfoEntity.uid) && !this.n.e)) {
            this.aD.setVisibility(8);
        } else if (userInfoEntity.photos_count == 0) {
            this.aD.setVisibility(8);
        } else {
            int i = 0;
            this.aD.setVisibility(0);
            UserinfoNewAlbumAdapter userinfoNewAlbumAdapter = this.aE;
            if (userinfoNewAlbumAdapter == null) {
                this.aE = new UserinfoNewAlbumAdapter(getFragmentActive(), this.f34016a, this.E.name, TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, this.E.uid), userInfoEntity.access_private_photos);
            } else {
                userinfoNewAlbumAdapter.a(userInfoEntity.access_private_photos);
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f34016a);
            linearLayoutManager.setOrientation(0);
            this.aD.setLayoutManager(linearLayoutManager);
            this.aD.setNestedScrollingEnabled(false);
            this.aD.setAdapter(this.aE);
            this.aE.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$pYsiuQtR4Re-2H596snA8G8dhBI
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                    UserInfoFragmentNew.this.a(userInfoEntity, baseQuickAdapter, view, i2);
                }
            });
            List<BluedAlbum> list = userInfoEntity.album;
            if (userInfoEntity.vip_grade == 0 && list.size() > 6) {
                while (i < list.size()) {
                    int i2 = i;
                    if (i > 5) {
                        list.remove(list.get(i));
                        i2 = i - 1;
                    }
                    i = i2 + 1;
                }
            }
            Log.v("drb", "userInfo.album:" + userInfoEntity.photos_count);
            if (userInfoEntity.privacy_photos_has_locked == 1) {
                this.aE.setNewData(list);
            } else if (userInfoEntity.photos_count > 0) {
                BluedAlbum bluedAlbum = new BluedAlbum();
                int i3 = 1;
                if (userInfoEntity.privacy_photos_has_locked == 2) {
                    i3 = 2;
                }
                bluedAlbum.applyStatus = i3;
                ArrayList arrayList = new ArrayList();
                arrayList.add(bluedAlbum);
                this.aE.setNewData(arrayList);
                Log.v("drb", "albumFlow add showApply");
            }
        }
    }

    private void v() {
        MyAdapter myAdapter = new MyAdapter(getChildFragmentManager());
        this.h = myAdapter;
        this.g.setAdapter(myAdapter);
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) this.b.findViewById(2131370555);
        this.i = tabPageIndicatorWithDot;
        tabPageIndicatorWithDot.setIndicatorColor(2131101766);
        this.i.setViewPager(this.g);
        TabPageIndicatorWithDot tabPageIndicatorWithDot2 = (TabPageIndicatorWithDot) this.b.findViewById(R.id.top_tablayout);
        this.bc = tabPageIndicatorWithDot2;
        tabPageIndicatorWithDot2.setIndicatorColor(2131101766);
        this.bc.setViewPager(this.g);
        this.bc.setVisibility(0);
        this.bc.post(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$4bT2YtW5TXvZMWEDjpwf3Aq8Ayk
            @Override // java.lang.Runnable
            public final void run() {
                UserInfoFragmentNew.this.K();
            }
        });
        this.g.setCurrentItem(0);
        this.g.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.14
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (!UserInfoFragmentNew.this.af) {
                    PersonalProfileProtos.TabType tabType = PersonalProfileProtos.TabType.UNKNOWN_TAB_TYPE;
                    LogData logData = new LogData();
                    logData.logService = "userpage_shift_tab";
                    if (i == 0) {
                        logData.from = "0";
                        tabType = PersonalProfileProtos.TabType.PHOTO_LOAD;
                    } else if (i == 1) {
                        logData.from = "1";
                        tabType = PersonalProfileProtos.TabType.FEED_LOAD;
                    } else if (i == 2) {
                        logData.from = "2";
                        tabType = PersonalProfileProtos.TabType.PROFILE_LOAD;
                    }
                    logData.uid = UserInfoFragmentNew.this.n.e().uid;
                    InstantLog.a(logData);
                    EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_SHIFT_TAB, tabType, logData.uid);
                }
                if (i == 0) {
                    EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_PHOTO_PAGE_SHOW, UserInfoFragmentNew.this.n.e().uid);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(View view) {
        Tracker.onClick(view);
        g();
    }

    private void v(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || this.n.g()) {
            return;
        }
        if (!"1".equals(userInfoEntity.is_access_follows) && !userInfoEntity.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.fans_list_hidden));
            return;
        }
        BluedConstant.d = 0;
        Bundle bundle = new Bundle();
        bundle.putString("followed_or_fan", "followed");
        bundle.putString("uid", userInfoEntity.uid);
        TerminalActivity.d(this.f34016a, FollowedAndFansFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.n.e) {
            if (BluedPreferences.fA()) {
                BluedPreferences.fB();
                this.be.setVisibility(0);
                this.bd.setText(this.f34016a.getString(R.string.self_user_virtual_image_guide));
                this.V.a(1500, 700, 1.0f, true);
            }
        } else if (BluedPreferences.fy() && this.n.s()) {
            BluedPreferences.fz();
            this.be.setVisibility(0);
            this.bd.setText(this.f34016a.getString(R.string.user_virtual_image_guide));
            this.V.a(1500, 700, 1.0f, true);
        }
        if (this.be.getVisibility() == 0) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.25
                @Override // java.lang.Runnable
                public void run() {
                    UserInfoFragmentNew.this.be.setVisibility(8);
                }
            }, 3500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        Tracker.onClick(view);
        g();
    }

    private void w(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || this.n.g()) {
            return;
        }
        if (!"1".equals(userInfoEntity.is_access_followers) && !userInfoEntity.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
            AppMethods.d((int) R.string.fans_list_hidden);
            return;
        }
        BluedConstant.d = 1;
        Bundle bundle = new Bundle();
        bundle.putString("followed_or_fan", "fans");
        bundle.putString("uid", userInfoEntity.uid);
        TerminalActivity.d(this.f34016a, FollowedAndFansFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.V.getVisibility() == 8) {
            g();
        } else {
            y();
        }
    }

    private void y() {
        UserInfoNewPresenter userInfoNewPresenter = this.n;
        if (userInfoNewPresenter != null && userInfoNewPresenter.e() != null && getActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra("passby_is_in_blacklist", this.n.e().in_blacklist);
            getActivity().setResult(-1, intent);
        }
        if (getActivity() != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                getActivity().finishAfterTransition();
            } else {
                getActivity().finish();
            }
        }
    }

    private void z() {
        AlertDialog create = new AlertDialog.Builder(getActivity()).create();
        create.setCanceledOnTouchOutside(true);
        Window window = create.getWindow();
        window.setGravity(17);
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = window.getAttributes();
        create.show();
        window.setContentView(R.layout.dialog_my_qr);
        final LinearLayout linearLayout = (LinearLayout) window.findViewById(R.id.sava_view);
        UserInfoHelper.a((ImageView) window.findViewById(2131364720), this.n.e().vbadge, 3);
        final ImageView imageView = (ImageView) window.findViewById(R.id.my_qr_img);
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$bJF5aa3oQqp-EuHFWN8xu_mp2Lc
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean a2;
                a2 = UserInfoFragmentNew.this.a(linearLayout, view);
                return a2;
            }
        });
        attributes.width = -2;
        attributes.height = -2;
        window.setAttributes(attributes);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, this.n.e().avatar)).c().a((ImageView) window.findViewById(R.id.dialog_header_view));
        TextView textView = (TextView) window.findViewById(R.id.dialog_tv_my_name);
        textView.setText(this.n.e().name);
        UserRelationshipUtils.a(this.f34016a, textView, this.n.e());
        UserRelationshipUtils.a((ImageView) window.findViewById(2131364726), this.n.e());
        if (this.n.g()) {
            return;
        }
        UserHttpUtils.a(this.f34016a, this.n.e().uid, new BinaryHttpResponseHandler(true) { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.33
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onFailure(Throwable th, int i, byte[] bArr) {
                super.onFailure(th, i, bArr);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(byte[] bArr) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                BitmapUtils.a(UserInfoFragmentNew.this.f34016a.getFilesDir() + BridgeUtil.SPLIT_MARK + UserInfo.getInstance().getLoginUserInfo().getUid() + ".bmp", decodeByteArray, 100, true);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFinish() {
                DialogUtils.b(UserInfoFragmentNew.this.v);
                super.onFinish();
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onStart() {
                super.onStart();
                DialogUtils.a(UserInfoFragmentNew.this.v);
            }
        }, getFragmentActive());
    }

    public void a(int i) {
        if (i > FeedMethods.c(100)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Y.getLayoutParams();
            marginLayoutParams.leftMargin = i - (FeedMethods.c((this.Z.getText().length() * 14) + 30) / 2);
            this.Y.setLayoutParams(marginLayoutParams);
            this.Y.setVisibility(0);
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$-k_Ik1z9ON7Z3yBjxhQQ8D19t0o
                @Override // java.lang.Runnable
                public final void run() {
                    UserInfoFragmentNew.this.F();
                }
            }, 1000L);
        }
    }

    public void a(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$D7tdCK0r-b48a_fvv4c2vl8GWDs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserInfoFragmentNew.this.r(view2);
            }
        });
    }

    public void a(final View view, final View.OnClickListener onClickListener) {
        Logger.c("hover_btns", " playImageButtonClickAnimator()");
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(1.0f, 0.7f);
        ofFloat.setDuration(50L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$UWo8nvwzyVVjiCTGP0EVK6xIEfU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                UserInfoFragmentNew.b(View.this, valueAnimator);
            }
        });
        ValueAnimator ofFloat2 = ObjectAnimator.ofFloat(0.7f, 1.0f);
        ofFloat2.setDuration(50L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$UhiUuKYTHGXOfcS3jQiRSnvz-38
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                UserInfoFragmentNew.a(View.this, valueAnimator);
            }
        });
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.36
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                onClickListener.onClick(view);
                view.setOnClickListener(UserInfoFragmentNew.this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setOnClickListener(null);
            }
        });
        animatorSet.start();
    }

    @Override // com.soft.blued.ui.user.observer.UserinfoFeedScrollObserver.IUserinFeedScrollObserver
    public void a(RecyclerView recyclerView, int i, int i2) {
    }

    public void a(SmartRefreshLayout smartRefreshLayout) {
        smartRefreshLayout.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.12
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void a(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
                if (i >= 240 || UserInfoFragmentNew.this.bh) {
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) UserInfoFragmentNew.this.aZ.getLayoutParams();
                layoutParams.topMargin = (-DensityUtils.a(UserInfoFragmentNew.this.f34016a, 30.0f)) + (i / 4);
                UserInfoFragmentNew.this.aZ.setLayoutParams(layoutParams);
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
            public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
                if (refreshState2 == RefreshState.ReleaseToRefresh) {
                    if ((!UserInfoFragmentNew.this.n.e || BluedPreferences.fA()) && (!UserInfoFragmentNew.this.n.s() || UserInfoFragmentNew.this.n.e || BluedPreferences.fy())) {
                        return;
                    }
                    UserInfoFragmentNew.this.t();
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                UserInfoFragmentNew.this.o();
            }
        });
        this.aT.a(new OnTwoLevelListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.13
            @Override // com.scwang.smartrefresh.layout.api.OnTwoLevelListener
            public boolean onTwoLevel(RefreshLayout refreshLayout) {
                UserInfoFragmentNew.this.ba.a(0);
                if (UserInfoFragmentNew.this.bh) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) UserInfoFragmentNew.this.aZ.getLayoutParams();
                    layoutParams.topMargin = 0;
                    UserInfoFragmentNew.this.aZ.setLayoutParams(layoutParams);
                    return true;
                }
                return true;
            }
        });
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: a */
    public void onChanged(FuGiftListEvent fuGiftListEvent) {
        if (fuGiftListEvent.f32324a == null) {
            return;
        }
        this.ax = fuGiftListEvent;
        q();
    }

    public void a(GiftGivingOptionForJsonParse giftGivingOptionForJsonParse) {
        if (giftGivingOptionForJsonParse == null || giftGivingOptionForJsonParse.type == -1) {
            return;
        }
        UserInfoNewPresenter userInfoNewPresenter = this.n;
        if (userInfoNewPresenter != null) {
            userInfoNewPresenter.a(giftGivingOptionForJsonParse);
        }
        UserPagerGiftManager.a().f32451a = giftGivingOptionForJsonParse;
        if (!"chat_setting".equalsIgnoreCase(this.au) && !"private_chatting".equalsIgnoreCase(this.au)) {
            q();
        } else if (getActivity() != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putBoolean("chat_setting", true);
            intent.putExtras(bundle);
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void a(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        if (userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.al.setImageResource(R.drawable.icon_profile_btm_feed_post);
            boolean b = FeedMethods.b();
            this.an.setVisibility(b ? 0 : 8);
            this.ao.setVisibility(b ? 0 : 8);
        } else {
            this.al.setImageResource(R.drawable.icon_profile_btm_chat);
        }
        ImageView imageView = (ImageView) this.b.findViewById(R.id.iv_chat);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_super_call_guide);
        if (userInfoEntity.super_call_status != 1 || this.n.e) {
            imageView.setImageDrawable(this.f34016a.getResources().getDrawable(R.drawable.icon_profile_chat));
            this.aj.setBackground(this.f34016a.getResources().getDrawable(R.drawable.shape_send_msg_btn));
            textView.setVisibility(8);
        } else {
            ImageLoader.c(getFragmentActive(), "icon_to_chat_privilege.png").f().g(-1).a(imageView);
            this.aj.setBackground(this.f34016a.getResources().getDrawable(R.drawable.shape_send_msg_super_call_btn));
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    UserInfoFragmentNew.this.q();
                }
            });
        }
        EcologyPopView ecologyPopView = (EcologyPopView) this.b.findViewById(R.id.ecology_view);
        this.aw = ecologyPopView;
        if (this.I) {
            ecologyPopView.setVisibility(0);
            this.aw.a(userInfoEntity.uid, getFragmentActive(), new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$IhkDXbrKGcfxdolgQoQ4HWQwtWE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoFragmentNew.this.k(view);
                }
            });
        } else {
            ecologyPopView.setVisibility(8);
        }
        if (userInfoEntity.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.k.setVisibility(0);
            this.j.setVisibility(0);
        } else {
            this.k.setVisibility(8);
            this.j.setVisibility(8);
        }
        if (userInfoEntity != null) {
            if (SubscribeNumberManager.f32449a.a(userInfoEntity.uid, (Short) 2)) {
                g(userInfoEntity);
            }
            c(userInfoEntity);
            e(userInfoEntity);
            f(userInfoEntity);
            u(userInfoEntity);
            h(userInfoEntity);
            o(userInfoEntity);
            k(userInfoEntity);
            j(userInfoEntity);
            t(userInfoEntity);
            i(userInfoEntity);
            d(userInfoEntity);
            b(userInfoEntity.theme_pendant);
            a(userInfoEntity.is_show_collection_enter, userInfoEntity.collection_enter_url);
            b(userInfoEntity.activity_list);
            s(userInfoEntity);
            r(userInfoEntity);
            q(userInfoEntity);
            p(userInfoEntity);
            n(userInfoEntity);
            this.q.a(userInfoEntity.bubble, userInfoEntity.uid);
            D();
        }
        this.aa = new UserProfileBtmOptions(this.f34016a, TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, userInfoEntity.uid), this.n.e().is_official == 1, b(userInfoEntity.uid), new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                InstantLog.b("user_page_options_click", 5);
                EventTrackPersonalProfile.b(PersonalProfileProtos.Event.USER_PAGE_OPTIONS_CLICK, UserInfoFragmentNew.this.E.uid, 5);
            }
        });
        this.ae = true;
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void a(UserInfoEntity userInfoEntity, int i) {
        if (i == 404) {
            getActivity().finish();
            return;
        }
        this.ap = true;
        this.h.a(userInfoEntity);
        this.h.b(userInfoEntity);
        this.h.a(true);
        UserBasicModel userBasicModel = this.E;
        if (userBasicModel == null || StringUtils.d(userBasicModel.uid)) {
            this.h.c(userInfoEntity);
        }
        if (userInfoEntity != null && userInfoEntity.fans_group != null) {
            Iterator<GroupInfoModel> it = userInfoEntity.fans_group.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().group_role != 0) {
                    this.aH = true;
                    break;
                }
            }
        }
        if (userInfoEntity != null) {
            GroupUtil.a(this.ai, userInfoEntity.show_groups, 2, userInfoEntity.fans_group, getFragmentActive());
        }
        o();
    }

    public void a(String str, ImageView imageView, ShapeTextView shapeTextView) {
        if (StringUtils.d(str)) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_userinfo_hover_attention);
            }
            shapeTextView.setText(2131888165);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131101766);
            ShapeHelper.d(shapeTextView, 2131101766);
        } else if ("0".equals(str)) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_userinfo_hover_attention);
            }
            shapeTextView.setText(2131888165);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131101766);
            ShapeHelper.d(shapeTextView, 2131101766);
        } else if ("1".equals(str)) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_userinfo_hover_followed);
            }
            shapeTextView.setText(2131888173);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131102263);
            ShapeHelper.d(shapeTextView, 2131102272);
        } else if ("2".equals(str)) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_userinfo_hover_been_followed);
            }
            shapeTextView.setText(2131886577);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131101766);
            ShapeHelper.d(shapeTextView, 2131101766);
        } else if ("3".equals(str)) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_userinfo_hover_follow_each);
            }
            shapeTextView.setText(2131888166);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131102263);
            ShapeHelper.d(shapeTextView, 2131101796);
        } else {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.icon_userinfo_hover_attention);
            }
            shapeTextView.setText(2131888165);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, 2131101766);
            ShapeHelper.d(shapeTextView, 2131101766);
        }
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void a(final List<ServiceMenuModel> list) {
        ((ImageView) this.b.findViewById(R.id.iv_chat)).setVisibility(8);
        ((TextView) this.b.findViewById(2131371080)).setText(this.f34016a.getString(R.string.to_message));
        if (this.f34018c.contains(this.f34016a.getResources().getString(R.string.album)) && this.f34018c.contains(this.f34016a.getResources().getString(R.string.user_profile))) {
            this.f34018c.remove(this.f34016a.getResources().getString(R.string.album));
            this.f34018c.remove(this.f34016a.getResources().getString(R.string.user_profile));
        }
        this.h.b(this.aL);
        this.h.b(this.aJ);
        boolean z = true;
        if (list == null || list.size() <= 0) {
            this.i.setVisibility(8);
            this.bc.setVisibility(8);
            z = false;
        } else {
            if (!this.f34018c.contains(this.f34016a.getResources().getString(R.string.service_tab))) {
                this.f34018c.add(this.f34016a.getResources().getString(R.string.service_tab));
            }
            Fragment fragment = new Fragment();
            this.aM = fragment;
            this.h.a(fragment);
            this.g.setScrollEnable(false);
            this.i.b();
            this.i.post(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$kzgydnKgN2tkqTCixGc8lxy46fk
                @Override // java.lang.Runnable
                public final void run() {
                    UserInfoFragmentNew.this.J();
                }
            });
            this.bc.b();
            this.bc.post(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$F704izZnkeoSgT2Q9xwGpIpwLRE
                @Override // java.lang.Runnable
                public final void run() {
                    UserInfoFragmentNew.this.I();
                }
            });
            Drawable drawable = this.f34016a.getResources().getDrawable(R.drawable.icon_service_menu);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.i.e(1).setCompoundDrawables(null, null, drawable, null);
            this.bc.e(1).setCompoundDrawables(null, null, drawable, null);
            this.i.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$WeL8dB1mdPDqE7GivnZkmbMNoq4
                @Override // com.soft.blued.customview.TabPageIndicatorWithDot.OnTitleClickListener
                public final void onClick(int i) {
                    UserInfoFragmentNew.this.b(list, i);
                }
            });
            this.bc.setOnTitleClickListener(new TabPageIndicatorWithDot.OnTitleClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$NdCBkl_qoEKgE91d0DLMOcVQF-c
                @Override // com.soft.blued.customview.TabPageIndicatorWithDot.OnTitleClickListener
                public final void onClick(int i) {
                    UserInfoFragmentNew.this.a(list, i);
                }
            });
        }
        EventTrackPersonalProfile.b(PersonalProfileProtos.Event.SERVICE_PROFILE_PAGE_SHOW, TextUtils.isEmpty(this.E.uid) ? this.n.e().uid : this.E.uid, z);
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void a(List<UserFindResult> list, boolean z) {
        new XPopup.Builder(getContext()).a(new SimpleCallback() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.16
            @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void c(BasePopupView basePopupView) {
                super.c(basePopupView);
                UserInfoFragmentNew.this.aR.setImageResource(R.drawable.icon_arrow_down_half_transparent);
            }

            @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void d(BasePopupView basePopupView) {
                super.d(basePopupView);
                UserInfoFragmentNew.this.aR.setImageResource(R.drawable.icon_arrow_up_half_transparent);
            }
        }).a((BasePopupView) new PopUserRecommend(getContext(), n().uid, list, z, this.N, getFragmentActive())).h();
    }

    public void a(boolean z) {
        this.ad.setVisibility(z ? 0 : 8);
        this.V.setVisibility(z ? 0 : 8);
        this.e.setVisibility(z ? 0 : 8);
        if (this.I) {
            this.aw.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.soft.blued.ui.user.observer.AlbumDataObserver.IAlbumObserver
    public void a(boolean z, String str) {
        UserinfoNewAlbumAdapter userinfoNewAlbumAdapter = this.aE;
        if (userinfoNewAlbumAdapter != null) {
            userinfoNewAlbumAdapter.a(z, str);
        }
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public boolean a() {
        return this.o;
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void b() {
        getActivity().finish();
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void b(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        this.q.a(userInfoEntity.bubble, userInfoEntity.uid);
    }

    public void b(boolean z) {
        this.p.setVisibility(0);
        this.p.d();
        this.p.a(-15.0f);
        this.p.b();
        this.r.setVisibility(4);
        this.s.setVisibility(4);
        this.n.a(this.E);
        this.aq = false;
        this.ap = false;
        this.f34017ar = false;
        UserBasicModel userBasicModel = this.E;
        if (userBasicModel == null || StringUtils.d(userBasicModel.uid)) {
            return;
        }
        this.h.a(true);
        this.h.b(true);
        if (SubscribeNumberManager.f32449a.a(this.E.uid, (Short) 2)) {
            this.n.c(this.E.uid);
        }
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public /* synthetic */ IRequestHost c() {
        return super.getFragmentActive();
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void c(final UserInfoEntity userInfoEntity) {
        String str;
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        TextView textView = (TextView) this.b.findViewById(2131372046);
        ImageView imageView = (ImageView) this.b.findViewById(2131364613);
        ImageView imageView2 = (ImageView) this.b.findViewById(2131364726);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_note_name);
        this.x = (TextView) this.b.findViewById(2131371285);
        this.y = (TextView) this.b.findViewById(R.id.tv_last_operate);
        this.z = (TextView) this.b.findViewById(R.id.user_info_ip_location_tv);
        TextView textView3 = (TextView) this.b.findViewById(R.id.tv_follow_num);
        TextView textView4 = (TextView) this.b.findViewById(2131371411);
        TextView textView5 = (TextView) this.b.findViewById(R.id.tv_follow_title);
        TextView textView6 = (TextView) this.b.findViewById(2131371415);
        View findViewById = this.b.findViewById(R.id.ll_using_shadow);
        if (userInfoEntity.is_shadow == 1) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$4KgkSBgkyIYFnuaO5xiRMZGR33c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoFragmentNew.this.m(view);
                }
            });
        } else {
            findViewById.setVisibility(8);
        }
        textView3.setText(StringUtils.b(userInfoEntity.followed_count));
        textView4.setText(StringUtils.b(userInfoEntity.followers_count));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$t1IsdSMogodTWVCsle-ONiP7SMc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.i(userInfoEntity, view);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$_2h6ix6ui6a6aKqZkibUvqG3QzY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.h(userInfoEntity, view);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$SX6O84m_kqv1-NZ7EGZP9Z-Eye4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.g(userInfoEntity, view);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$lf3pJiNHVqUMFvv955iulwXo3fk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.f(userInfoEntity, view);
            }
        });
        TextView textView7 = (TextView) this.f.findViewById(R.id.tv_bar_username);
        UserInfoHelper.a(this.f34016a, textView7, userInfoEntity, 2131102254);
        UserInfoHelper.a(this.f34016a, textView, userInfoEntity, 2131102254);
        UserInfoHelper.a(imageView, userInfoEntity.vbadge, 2);
        if (imageView.getVisibility() == 4 || imageView.getVisibility() == 8) {
            if (userInfoEntity.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
                imageView.setVisibility(0);
                imageView.setImageResource(2131237327);
            } else {
                imageView.setVisibility(8);
            }
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$BcnmhKGIMEVDk0x873XD1ZUOtVA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.e(userInfoEntity, view);
            }
        });
        UserRelationshipUtils.a(imageView2, userInfoEntity);
        if (StringUtils.d(userInfoEntity.vip_url)) {
            imageView2.setOnClickListener(null);
        } else {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_VIP_ICON_SHOW, userInfoEntity.uid, userInfoEntity.vip_grade);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$VMbb3_vSbcIHF4lw5MJIcozsyIc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoFragmentNew.this.d(userInfoEntity, view);
                }
            });
        }
        if (UserInfo.getInstance().getLoginUserInfo().getUid().equals(userInfoEntity.uid)) {
            this.W = true;
        }
        String str2 = userInfoEntity.name;
        String str3 = str2;
        if (this.W) {
            str3 = str2;
            if (userInfoEntity.auditing_profile != null) {
                str3 = str2;
                if (userInfoEntity.is_audited == 0) {
                    str3 = str2;
                    if (!TextUtils.isEmpty(userInfoEntity.auditing_profile.name)) {
                        str3 = userInfoEntity.auditing_profile.name;
                    }
                }
            }
        }
        if (StringUtils.d(userInfoEntity.note)) {
            textView.setText(str3);
            textView7.setText(str3);
            textView2.setVisibility(8);
        } else {
            textView.setText(userInfoEntity.note);
            textView7.setText(userInfoEntity.note);
            textView2.setVisibility(0);
            textView2.setText("(" + str3 + ")");
        }
        final String str4 = str3;
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$RJxGT7VD5k-NF-NRUjrNrqA-li0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean b;
                b = UserInfoFragmentNew.this.b(str4, view);
                return b;
            }
        });
        if (userInfoEntity.vbadge_hide_profile == 1 || ((UserInfoHelper.c(userInfoEntity.vbadge) || b(userInfoEntity.uid)) && !this.W)) {
            this.w.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            if (StringUtils.d(userInfoEntity.age)) {
                str = "-";
            } else {
                str = userInfoEntity.age + this.f34016a.getResources().getString(2131886374);
            }
            String a2 = StringUtils.a(userInfoEntity.height, BlueAppLocal.c(), true);
            String str5 = a2;
            if (StringUtils.d(a2)) {
                str5 = "- cm";
            }
            String b = StringUtils.b(userInfoEntity.weight, BlueAppLocal.c(), true);
            String str6 = b;
            if (StringUtils.d(b)) {
                str6 = "- kg";
            }
            userInfoEntity.role = "-1".equalsIgnoreCase(userInfoEntity.role) ? Constants.WAVE_SEPARATOR : userInfoEntity.role;
            String b2 = UserInfoHelper.b(this.f34016a, userInfoEntity.role);
            this.w.setText(str + " • " + str5 + " • " + str6 + " • " + b2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" • ");
            sb.append(str5);
            sb.append(" • ");
            sb.append(str6);
            this.aO = sb.toString();
        }
        if ((userInfoEntity.vbadge == 3 || b(userInfoEntity.uid)) && !this.W) {
            this.x.setVisibility(8);
        } else {
            if (!StringUtils.d(userInfoEntity.location)) {
                this.x.setText(userInfoEntity.location);
                this.x.setVisibility(0);
            } else if (StringUtils.d(userInfoEntity.distance)) {
                this.x.setText("            ");
            } else {
                this.x.setText(DistanceUtils.a(userInfoEntity.distance, BlueAppLocal.c(), true));
                this.x.setVisibility(0);
            }
            DistanceUtils.a(this.f34016a, this.x, userInfoEntity, 1);
        }
        if ((userInfoEntity.vbadge == 3 || userInfoEntity.vbadge == 8 || b(userInfoEntity.uid)) && !this.W) {
            this.y.setVisibility(8);
        } else {
            if (StringUtils.d(userInfoEntity.last_operate)) {
                this.y.setText("            ");
            } else {
                this.y.setVisibility(0);
                this.y.setText(TimeAndDateUtils.f(getActivity(), TimeAndDateUtils.c(userInfoEntity.last_operate)));
            }
            TypefaceUtils.a(this.f34016a, this.y, userInfoEntity.is_hide_last_operate, 1);
        }
        if (TextUtils.isEmpty(userInfoEntity.ip_location)) {
            this.z.setVisibility(8);
            return;
        }
        this.z.setText(String.format(getString(2131889045), userInfoEntity.ip_location));
        this.z.setVisibility(0);
    }

    public void c(boolean z) {
        if (z) {
            this.aE.a();
        } else {
            this.aE.b();
        }
    }

    @Override // com.soft.blued.ui.user.contract.IUserInfoNewContract.IView
    public void d() {
        ToastUtils.a(getString(R.string.msg_poke_received));
        this.aP.setVisibility(8);
    }

    public void d(UserInfoEntity userInfoEntity) {
        View findViewById = this.b.findViewById(R.id.btn_vip_bg_delete);
        View findViewById2 = this.b.findViewById(R.id.btn_vip_bg_save);
        View findViewById3 = this.b.findViewById(R.id.btn_vip_bg_modify);
        this.b.findViewById(R.id.btn_vip_bg_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$Z4wRgPO-NJHa_3g3p_eYgv2JIcY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.v(view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$38NQCjCxWZXTG4jgfeGlVa358Fs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.u(view);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$06_N9Wc01njTwFdQcwBL9qlMVKg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.t(view);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$GBHFZBvFRLqdIeqH5eBigW0a7QM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.s(view);
            }
        });
        if (StringUtils.d(userInfoEntity.background_photo)) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
        }
        if (!this.n.e) {
            findViewById.setVisibility(8);
            findViewById3.setVisibility(8);
            return;
        }
        findViewById3.setVisibility(0);
        if (StringUtils.d(userInfoEntity.background_photo)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    public void d(boolean z) {
        this.f34017ar = true;
        this.at = z;
        o();
    }

    public void e() {
        if (getArguments() != null) {
            this.au = getArguments().getString("userfrom");
            this.av = getArguments().getString("user_to");
            try {
                this.E = (UserBasicModel) getArguments().getSerializable("user");
                this.F = (BluedIngSelfFeed) getArguments().getSerializable(IAdInterListener.AdProdType.PRODUCT_FEEDS);
                this.G = (LiveRoomData) getArguments().getSerializable("live");
                this.M = (MsgSourceEntity) getArguments().getSerializable("MSG_SOURCE_ENTITY");
            } catch (Exception e) {
            }
            this.H = getArguments().getBoolean("is_living");
            this.J = getArguments().getBoolean("is_shadow");
            this.L = getArguments().getBoolean("is_reactive_recommend");
            this.K = getArguments().getBoolean("is_call");
            this.N = (LogData) getArguments().getSerializable("LOG_DATA");
            this.O = getArguments().getInt("tab", -1);
            this.I = getArguments().getBoolean("IF_SHOW_WITH_ECOLOGY_VIEW", false);
        }
        if (this.N == null) {
            this.N = new LogData();
        }
    }

    public void e(UserInfoEntity userInfoEntity) {
        ImageView imageView = (ImageView) this.b.findViewById(R.id.img_avatar_border);
        ShapeTextView shapeTextView = (ShapeTextView) this.b.findViewById(R.id.img_bar_live_border);
        ImageView imageView2 = (ImageView) this.b.findViewById(2131364591);
        ImageView imageView3 = (ImageView) this.b.findViewById(R.id.img_bar_live_anim);
        imageView.setImageResource(R.drawable.bg_profile_header_border);
        shapeTextView.setVisibility(8);
        imageView2.setVisibility(8);
        imageView3.setVisibility(8);
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        if (userInfoEntity.liveshow != null && userInfoEntity.liveshow.session_id != null && !userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
            EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PROFILE_LIVING_SHOW, userInfoEntity.uid);
            imageView.setImageResource(R.drawable.bg_profile_living_border);
            shapeTextView.setVisibility(0);
            ShapeHelper.d(shapeTextView, 2131099651);
            imageView2.setVisibility(0);
            imageView3.setVisibility(0);
            String str = "anim_live_en";
            if (BlueAppLocal.d()) {
                str = "anim_live_en";
                if (BlueAppLocal.d()) {
                    str = "anim_live_zh";
                }
            }
            String str2 = str;
            if (!BluedSkinUtils.c()) {
                str2 = str + "_dark";
            }
            ImageLoader.c(getFragmentActive(), str2 + ".png").f().g(-1).a(imageView2);
            ImageLoader.c(getFragmentActive(), "anim_user_bar_living.png").f().g(-1).a(imageView3);
            Log.v("drb", "满足直播");
        } else if (userInfoEntity.voice_broadcast == null || TextUtils.isEmpty(userInfoEntity.voice_broadcast.room_id)) {
        } else {
            EventTrackYY.f(ChatRoomProtos.Event.CHAT_ROOM_PROFILE_ENTER_SHOW, userInfoEntity.voice_broadcast.room_id, userInfoEntity.voice_broadcast.uid, userInfoEntity.voice_broadcast.room_type);
            imageView.setImageResource(R.drawable.bg_profile_chat_border);
            shapeTextView.setVisibility(0);
            ShapeHelper.d(shapeTextView, 2131101446);
            imageView2.setVisibility(0);
            imageView3.setVisibility(0);
            String str3 = "anim_chat_en";
            if (BlueAppLocal.d()) {
                str3 = "anim_chat_en";
                if (BlueAppLocal.d()) {
                    str3 = "anim_chat_zh";
                }
            }
            String str4 = str3;
            if (!BluedSkinUtils.c()) {
                str4 = str3 + "_dark";
            }
            ImageLoader.c(getFragmentActive(), str4 + ".png").f().g(-1).a(imageView2);
            ImageLoader.c(getFragmentActive(), "anim_user_bar_chat.png").f().g(-1).a(imageView3);
            Log.v("drb", "满足聊天");
        }
    }

    public void e(boolean z) {
        this.aq = true;
        this.as = z;
        o();
    }

    public void f() {
        if (this.p.getVisibility() == 0) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BACKGROUND_CLICK);
        ValueAnimator i = i();
        i.addListener(new AnonymousClass7());
        i.start();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.8
            @Override // java.lang.Runnable
            public void run() {
                UserInfoFragmentNew.this.aZ.setVisibility(8);
                UserInfoFragmentNew.this.aV.setVisibility(8);
            }
        }, 500L);
    }

    public void f(UserInfoEntity userInfoEntity) {
        this.ab = this.b.findViewById(R.id.ll_sign_text);
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            this.ab.setVisibility(8);
            return;
        }
        String str = userInfoEntity.description;
        String str2 = str;
        if (!StringUtils.d(userInfoEntity.uid)) {
            str2 = str;
            if (userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
                AuditingProfileModel auditingProfileModel = userInfoEntity.auditing_profile;
                str2 = str;
                if (auditingProfileModel != null) {
                    str2 = str;
                    if (userInfoEntity.is_audited == 0) {
                        str2 = str;
                        if (auditingProfileModel.description != null) {
                            str2 = auditingProfileModel.description;
                        }
                    }
                }
            }
        }
        if (StringUtils.d(str2)) {
            this.ab.setVisibility(8);
            return;
        }
        this.ab.setVisibility(0);
        final String str3 = str2;
        this.ab.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$KG_ch8S9jqg0itpx6U1gpCB9SV4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean a2;
                a2 = UserInfoFragmentNew.this.a(str3, view);
                return a2;
            }
        });
        TextViewFixTouchForDynamic textViewFixTouchForDynamic = (TextViewFixTouchForDynamic) this.b.findViewById(R.id.tv_sign_limited);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_sign_multi_line);
        if (str2.equalsIgnoreCase(textView.getText().toString())) {
            return;
        }
        textViewFixTouchForDynamic.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = textViewFixTouchForDynamic.getLayoutParams();
        layoutParams.width = AppInfo.l - DensityUtils.a(this.f34016a, 20.0f);
        textViewFixTouchForDynamic.setLayoutParams(layoutParams);
        textViewFixTouchForDynamic.setMaxWidth(layoutParams.width);
        textViewFixTouchForDynamic.setMaxLines(3);
        textViewFixTouchForDynamic.setMovementMethod(LinkMovementClickMethod.a());
        textViewFixTouchForDynamic.setMoreText(this.f34016a.getResources().getString(2131892582));
        textViewFixTouchForDynamic.setMoeTextColor(BluedSkinUtils.a(this.f34016a, 2131102254));
        textViewFixTouchForDynamic.setExpandText(str2);
        textView.setVisibility(4);
        textView.setText(str2);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass15(textView, 3, textViewFixTouchForDynamic));
    }

    public void f(boolean z) {
        boolean z2 = false;
        this.N.isAddFollow = false;
        LogData logData = this.N;
        if (this.n.e().super_call_status == 1) {
            z2 = true;
        }
        logData.is_super_call = z2;
        if (z) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_CHAT_BTN_CLICK, this.N);
        }
        LogData logData2 = new LogData("user_profile_chat_btn_click");
        logData2.from = this.au;
        logData2.target_uid = this.n.e().uid;
        LogData logData3 = this.N;
        if (logData3 != null && ("0".equals(logData3.type) || "1".equals(this.N.type))) {
            logData2.type = this.N.type;
        }
        InstantLog.a(logData2);
        if (!"chat_setting".equalsIgnoreCase(this.au) && !"private_chatting".equalsIgnoreCase(this.au)) {
            q();
            return;
        }
        if ("chat_setting".equalsIgnoreCase(this.au)) {
            LiveEventBus.get("group_update_chat_source_from", UpdateSourceFromEvent.class).post(new UpdateSourceFromEvent("chat_setting"));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean("chat_setting", true);
        intent.putExtras(bundle);
        if (getActivity() != null) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        Log.v("finalize", "Userinfo finalize");
    }

    public void g() {
        if (this.n.s() && this.aW == 0) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_BACKGROUND_CLICK);
        ValueAnimator i = i();
        i.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                UserInfoFragmentNew.this.a(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                UserInfoFragmentNew.this.a(true);
            }
        });
        i.reverse();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.10
            @Override // java.lang.Runnable
            public void run() {
                if (UserInfoFragmentNew.this.n.s()) {
                    UserInfoFragmentNew.this.aZ.setVisibility(0);
                    UserInfoFragmentNew.this.aV.setVisibility(0);
                }
            }
        }, 500L);
    }

    public void g(final UserInfoEntity userInfoEntity) {
        TextView textView = (TextView) this.b.findViewById(R.id.tv_user_gift_title);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_user_gift_count);
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R.id.lv_user_gift);
        final ImageView imageView = (ImageView) this.b.findViewById(R.id.img_his_gift_red_dot);
        this.aI.setVisibility(0);
        if (!userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid) || BluedPreferences.aR()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
        if (UserInfo.getInstance().getLoginUserInfo().uid.equals(userInfoEntity.uid)) {
            textView.setText(this.f34016a.getResources().getString(R.string.my_gift));
            this.aI.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$1_HRDjoOXjJfcHul1nlZMpktpJc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoFragmentNew.this.a(imageView, view);
                }
            });
        } else {
            textView.setText(this.f34016a.getResources().getString(R.string.his_gift));
            this.aI.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$Ncc-jRA9J9HxkZyvN0hkJSerY8w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoFragmentNew.this.c(userInfoEntity, view);
                }
            });
        }
        UserHttpUtils.b(new AnonymousClass18(getFragmentActive(), userInfoEntity, textView2, imageView, recyclerView), userInfoEntity.uid, getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        UserBasicModel userBasicModel = (UserBasicModel) getArguments().getSerializable("user");
        return (userBasicModel == null || !userBasicModel.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) ? "A57" : "A56";
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public String getSimpleRouterName() {
        UserBasicModel userBasicModel = (UserBasicModel) getArguments().getSerializable("user");
        return (userBasicModel == null || !userBasicModel.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) ? "A57" : "A56";
    }

    public void h() {
        Context context = this.f34016a;
        CommonAlertDialog.a(context, context.getResources().getString(R.string.profile_background_del), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$k3_TbMLQ4x1IBoAeDFttGHRo5sE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UserInfoFragmentNew.this.c(dialogInterface, i);
            }
        });
    }

    public void h(final UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        ImageLoader.a(getFragmentActive(), (int) R.drawable.shadow_vip_top).a((ImageView) this.b.findViewById(R.id.img_vip_bg_top_shadow));
        BluedAlbum bluedAlbum = new BluedAlbum();
        bluedAlbum.setUrl(userInfoEntity.avatar);
        if (!this.ae) {
            ImageFileLoader.a((IRequestHost) null).a(AvatarUtils.b(userInfoEntity.avatar)).a();
        }
        this.Q = (ImageView) this.b.findViewById(R.id.img_single_avatar);
        this.R = (ImageView) this.b.findViewById(R.id.img_bar_avatar);
        String str = userInfoEntity.avatar;
        String str2 = str;
        if (UserInfo.getInstance().getLoginUserInfo().getUid().equals(userInfoEntity.uid)) {
            str2 = str;
            if (userInfoEntity.auditing_profile != null) {
                str2 = str;
                if (userInfoEntity.avatar_audited == 0) {
                    str2 = str;
                    if (!TextUtils.isEmpty(userInfoEntity.auditing_profile.latest_avatar)) {
                        str2 = userInfoEntity.auditing_profile.latest_avatar;
                    }
                }
            }
        }
        String a2 = AvatarUtils.a(2, str2);
        ImageLoader.a(getFragmentActive(), a2).b(2131237310).a(50.0f).a(this.Q);
        ImageLoader.a(getFragmentActive(), a2).b(2131237310).a(50.0f).a(this.R);
        final String str3 = str2;
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$wDkp6R2lYLrhCnuADaUdXuELgbw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.a(userInfoEntity, str3, view);
            }
        });
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$h6AtbSh5gX2rUuNuaQUuSvUZnTQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.l(view);
            }
        });
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.aY.getLayoutParams();
        layoutParams.topMargin = (int) ((this.aF + 130) * 2.2f);
        this.aY.setLayoutParams(layoutParams);
        new ArrayList().add(0, bluedAlbum);
        if (this.n.e && userInfoEntity.background_photo_auditing == 1) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(3, userInfoEntity.background_photo)).b(R.drawable.bg_vip_bg_default).d(R.drawable.bg_vip_bg_default).a(this.bb);
        this.U = (TextView) this.b.findViewById(R.id.tv_avatar_widget);
        if (!this.W || UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 || BluedPreferences.cT()) {
            return;
        }
        this.U.setVisibility(0);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.19
            @Override // java.lang.Runnable
            public void run() {
                UserInfoFragmentNew.this.U.setVisibility(8);
                BluedPreferences.cU();
            }
        }, 5000L);
    }

    public ValueAnimator i() {
        this.ac.scrollTo(0, 0);
        new ObjectAnimator();
        ValueAnimator ofInt = ObjectAnimator.ofInt(0, 100);
        ofInt.setDuration(250L);
        ofInt.setInterpolator(new LinearInterpolator());
        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bb.getLayoutParams();
        final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$9NEehy73D2TxZ2hZAEO3OCMUTY4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                UserInfoFragmentNew.this.a(layoutParams, layoutParams2, valueAnimator);
            }
        });
        return ofInt;
    }

    public void i(final UserInfoEntity userInfoEntity) {
        View findViewById = this.b.findViewById(2131363933);
        View findViewById2 = this.b.findViewById(R.id.ll_distance_row);
        View findViewById3 = this.b.findViewById(R.id.ll_followed_and_fans);
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid) || !this.n.h()) {
            this.A.setVisibility(8);
            findViewById.setVisibility(0);
            this.g.setVisibility(0);
            findViewById2.setVisibility(0);
            findViewById3.setVisibility(0);
            return;
        }
        userInfoEntity.is_show_vip_page = 0;
        h(userInfoEntity);
        findViewById2.setVisibility(8);
        findViewById3.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.A.getLayoutParams();
        layoutParams.height = (AppInfo.m - StatusBarHelper.a(this.f34016a)) - DensityUtils.a(this.f34016a, 44.0f);
        this.A.setLayoutParams(layoutParams);
        this.A.setVisibility(0);
        this.w.setText(this.f34016a.getResources().getString(2131889158));
        this.aO = this.f34016a.getResources().getString(2131889158);
        this.ab.setVisibility(8);
        findViewById.setVisibility(8);
        this.g.setVisibility(8);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$77zVTBqH4bx6DXDnj8iB0AXzERc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.b(userInfoEntity, view);
            }
        });
        if ("4".equals(userInfoEntity.relationship) || "12".equals(userInfoEntity.relationship)) {
            this.C.setText(this.f34016a.getResources().getString(R.string.remove_from_black));
        } else {
            this.C.setText(this.f34016a.getResources().getString(R.string.add_to_black));
        }
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$b18_RdUw7YZpM_NH5_bkAbZw_9c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.j(view);
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$Ha6bqExnZFFxEDjbOEvKnqO-Yno
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserInfoFragmentNew.this.i(view);
            }
        });
        this.s.setVisibility(4);
        this.r.setVisibility(4);
    }

    public void j() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$0U_izrAlxF8OTgsOkRm0hUs_l1g
            @Override // java.lang.Runnable
            public final void run() {
                UserInfoFragmentNew.this.G();
            }
        }, 1000L);
    }

    public void j(UserInfoEntity userInfoEntity) {
        if (userInfoEntity == null || StringUtils.d(userInfoEntity.uid)) {
            return;
        }
        if (userInfoEntity.uid.equalsIgnoreCase(UserInfo.getInstance().getLoginUserInfo().uid)) {
            this.aj.setVisibility(8);
            this.ag.setVisibility(8);
            this.ah.setVisibility(8);
            this.ak.setVisibility(0);
            return;
        }
        a(userInfoEntity.relationship, (ImageView) null, this.ag);
        a(userInfoEntity.relationship, (ImageView) null, this.ah);
        this.ah.setVisibility(0);
        this.aj.setVisibility(0);
        this.ag.setVisibility(0);
        this.ak.setVisibility(8);
    }

    public void k() {
        Context context = this.f34016a;
        CommonAlertDialog.a(context, context.getResources().getString(R.string.confirm_apply_album), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.31
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                MineHttpUtils.a(UserInfoFragmentNew.this.n.e().uid, new BluedUIHttpResponse(UserInfoFragmentNew.this.getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentNew.31.1
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIFinish() {
                        super.onUIFinish();
                        DialogUtils.b(UserInfoFragmentNew.this.v);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIStart() {
                        super.onUIStart();
                        DialogUtils.a(UserInfoFragmentNew.this.v);
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIUpdate(BluedEntity bluedEntity) {
                        UserInfoFragmentNew.this.c(true);
                        AppMethods.d((int) R.string.apply_has_been_set);
                        ChatHelperV4.a().b(UserInfoFragmentNew.this.n.e().uid, UserInfoFragmentNew.this.n.e().name, UserInfoFragmentNew.this.n.e().avatar, UserInfoFragmentNew.this.n.e().vbadge, UserInfoFragmentNew.this.n.e().vip_grade, UserInfoFragmentNew.this.n.e().is_vip_annual, UserInfoFragmentNew.this.n.e().vip_exp_lvl, UserInfoFragmentNew.this.n.e().is_hide_vip_look);
                    }
                }, UserInfoFragmentNew.this.getFragmentActive());
            }
        });
    }

    public void k(final UserInfoEntity userInfoEntity) {
        View findViewById = this.b.findViewById(R.id.fl_match_entrance);
        if (userInfoEntity == null) {
            findViewById.setVisibility(8);
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.rightMargin = 0;
        findViewById.setLayoutParams(layoutParams);
        final ImageView imageView = (ImageView) this.b.findViewById(R.id.img_match_bg);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_match_text);
        if (userInfoEntity.match_activity == null || StringUtils.d(userInfoEntity.match_activity.icon)) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            FindHttpUtils.b(userInfoEntity.match_activity.show_url);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$GN9eeUse0aBUKH9wyWHmY1iuks0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserInfoFragmentNew.this.a(userInfoEntity, view);
                }
            });
            final ImageSize imageSize = new ImageSize();
            ImageFileLoader.a(getFragmentActive()).a(userInfoEntity.match_activity.icon).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$GxMqQDEmQMZlpSStXWARev23VW8
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    UserInfoFragmentNew.this.a(imageSize, imageView, userInfoEntity, file, exc);
                }
            }).a();
            textView.setText(userInfoEntity.match_activity.match_activity_text);
        }
        BluedADConstraintLayout bluedADConstraintLayout = (BluedADConstraintLayout) this.b.findViewById(R.id.ad_view_layout);
        if (userInfoEntity.ads_activity == null || StringUtils.d(userInfoEntity.ads_activity.ads_pics)) {
            bluedADConstraintLayout.setVisibility(8);
            return;
        }
        bluedADConstraintLayout.setVisibility(0);
        bluedADConstraintLayout.setADData(userInfoEntity.ads_activity);
        ImageView imageView2 = (ImageView) this.b.findViewById(R.id.img_benefit);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_benefit);
        if (StringUtils.d(userInfoEntity.ads_activity.ads_pics)) {
            imageView2.setImageResource(R.drawable.icon_profile_benefit_default);
        } else {
            ImageLoader.a(getFragmentActive(), userInfoEntity.ads_activity.ads_pics).a(imageView2);
        }
        textView2.setText(userInfoEntity.ads_activity.title);
    }

    public void l() {
        if (TextUtils.isEmpty(this.n.e().uid)) {
            return;
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_PROFILE_MORE_BTN_CLICK, this.n.e().uid, this.n.e().vip_grade);
        final ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$z5Mx0n3NacK1tj-WVpL_JhABmss
            @Override // com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.ShareOptionsItemClickListener
            public final void onItemClick(int i) {
                UserInfoFragmentNew.this.c(i);
            }
        };
        String charSequence = this.w.getText().toString();
        while (true) {
            String str = charSequence;
            if (!str.contains(" ")) {
                final String a2 = BluedHttpUrl.a(this.n.e().uid);
                final String str2 = this.f34016a.getResources().getString(2131891701) + this.n.e().name + this.f34016a.getResources().getString(2131891702);
                String str3 = this.n.e().location;
                Log.v("drb", "citySettled:" + str3);
                final String str4 = str3 + "\n" + str;
                final String str5 = str3 + "\n" + this.aO;
                final String a3 = AvatarUtils.a(0, this.n.e().avatar);
                ImageFileLoader.a(getFragmentActive()).b(a3).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$cboyANl1iSbfdir3O5xJ8DpTiF8
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public final void onUIFinish(File file, Exception exc) {
                        UserInfoFragmentNew.this.a(a3, a2, str2, str4, str5, shareOptionsItemClickListener, file, exc);
                    }
                }).a();
                return;
            }
            charSequence = str.replace(" ", "");
        }
    }

    public void l(UserInfoEntity userInfoEntity) {
        if (userInfoEntity != null) {
            if (userInfoEntity.liveshow == null || userInfoEntity.liveshow.session_id == null) {
                if (StringUtils.d(userInfoEntity.game_url) || StringUtils.d(userInfoEntity.game_url)) {
                    return;
                }
                InstantLog.a(1, userInfoEntity.game_url);
                WebViewShowInfoFragment.show(this.f34016a, userInfoEntity.game_url, -1);
            } else if (this.n.g()) {
            } else {
                EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_PROFILE_PAGE_LIVE_ENTER_CLICK, userInfoEntity.uid);
                InstantLog.a("live_view_from_userinfo", (Object) this.au);
                UserRelationshipUtils.a(this.f34016a, userInfoEntity, userInfoEntity.liveshow.session_id.longValue(), MediaFormat.KEY_PROFILE);
            }
        }
    }

    public void m(UserInfoEntity userInfoEntity) {
        if (this.n.g()) {
            return;
        }
        if (userInfoEntity.vbadge != 4 || !userInfoEntity.uid.equals(UserInfo.getInstance().getLoginUserInfo().uid)) {
            if (UserInfo.getInstance().getLoginUserInfo().uid.equalsIgnoreCase(userInfoEntity.uid) && userInfoEntity.vbadge == 0) {
                PersonalVerifyFragment.a(this.f34016a, 1);
            } else {
                CommonAlertDialog2.a(this.f34016a, userInfoEntity.vbadge);
            }
        } else if (userInfoEntity.verify == null) {
            ShowVerifyFragment.a(this.f34016a, userInfoEntity.name, userInfoEntity.avatar, "", userInfoEntity.uid, true);
        } else if (userInfoEntity.verify.length > 0) {
            ShowVerifyFragment.a(this.f34016a, userInfoEntity.name, userInfoEntity.avatar, userInfoEntity.verify[0].verified_time, userInfoEntity.uid, true);
        } else {
            ShowVerifyFragment.a(this.f34016a, userInfoEntity.name, userInfoEntity.avatar, "", userInfoEntity.uid, true);
        }
    }

    public boolean m() {
        LiveRoomData liveRoomData = this.G;
        if (liveRoomData == null || liveRoomData.lid <= 0) {
            x();
            return false;
        }
        LiveRoomInfoChannel.a(this.f34016a, this.G);
        x();
        ActivityChangeAnimationUtils.g(getActivity());
        return true;
    }

    public UserInfoEntity n() {
        return this.n.e();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void o() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            b(false);
            if (i == 178 && intent != null) {
                String stringExtra = intent.getStringExtra("photo_path");
                if (StringUtils.d(stringExtra)) {
                    return;
                }
                this.n.d(stringExtra);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        x();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        this.N.userFrom = this.au;
        this.N.target_uid = this.n.e().uid;
        switch (view.getId()) {
            case R.id.btm_btn /* 2131362522 */:
                if (this.am.getAlpha() < 0.5f) {
                    return;
                }
                if (this.n.e) {
                    a(this.am, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$0HFhXhfvZnP2L9n6DQJTn5KdVtE
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            UserInfoFragmentNew.this.e(view2);
                        }
                    });
                    return;
                } else {
                    a(this.am, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$7rFMCqnLlZrZhfDtJmbGMW5mv_A
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            UserInfoFragmentNew.this.d(view2);
                        }
                    });
                    return;
                }
            case R.id.btn_bar_follow /* 2131362541 */:
            case R.id.btn_follow /* 2131362571 */:
                a(this.ag, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$ve910mK0UaTVJbJxgYy4WLnYdcU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UserInfoFragmentNew.this.g(view2);
                    }
                });
                return;
            case R.id.btn_chat /* 2131362551 */:
                a(this.aj, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$T5z-IDaL3kQbfY-pWGJtXZDw4EU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UserInfoFragmentNew.this.f(view2);
                    }
                });
                return;
            case 2131362623:
                a(this.ak, new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$UserInfoFragmentNew$e4IkozQWs3OM--kGjCRGwICvIW8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        UserInfoFragmentNew.this.h(view2);
                    }
                });
                return;
            case R.id.btn_recommend_list /* 2131362631 */:
                this.n.d();
                return;
            case R.id.fm_poke /* 2131364003 */:
                this.n.r();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f34016a = getActivity();
        getActivity().getWindow().setBackgroundDrawable(this.f34016a.getResources().getDrawable(2131237272));
        this.aG = StatusBarHelper.a(this.f34016a);
        this.aF = (((int) (AppInfo.l / 2.0f)) - DensityUtils.a(this.f34016a, 74.0f)) - this.aG;
        View view = this.b;
        if (view == null) {
            e();
            this.n = new UserInfoNewPresenter(this.f34016a, this, this.au, this.H, this.J, this.K, getFragmentActive(), this.M, this.E);
            this.b = layoutInflater.inflate(R.layout.fragment_userinfo_new, viewGroup, false);
            this.f34018c = new ArrayList();
            this.d = new ArrayList();
            this.f34018c.add(this.f34016a.getResources().getString(R.string.album));
            this.f34018c.add(this.f34016a.getResources().getString(2131887934));
            this.f34018c.add(this.f34016a.getResources().getString(R.string.user_profile));
            this.aJ = new UserinfoFragmentProfileTab();
            this.aK = UserinfoFragmentFeedTab.a(this.E);
            UserinfoFragmentAlbumTab a2 = UserinfoFragmentAlbumTab.a(this.E);
            this.aL = a2;
            this.d.add(a2);
            this.d.add(this.aK);
            this.d.add(this.aJ);
            u();
            s();
            v();
            UserinfoFeedScrollObserver.a().a(this);
            AlbumDataObserver.a().a(this);
            a(new UserInfoEntity(this.E));
            B();
            b(true);
            r();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Log.v("finalize", "Userinfo onDestroy");
        UserinfoFeedScrollObserver.a().b(this);
        AlbumDataObserver.a().b(this);
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_BUY_FU, FuGiftListEvent.class).removeObserver(this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_BUY_FU, FuGiftListEvent.class).observeForever(this);
        if (this.n.e) {
            boolean b = FeedMethods.b();
            this.an.setVisibility(b ? 0 : 8);
            this.ao.setVisibility(b ? 0 : 8);
        }
    }

    public void p() {
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PERSONAL, FeedMethods.b(), "");
        InstantLog.b("feed_post_btn_click", 2);
        FeedAddPostFragment.a(this.f34016a, new CommBundleBuilder().a(11));
    }

    public void q() {
        if (this.n.e().uid == null || this.n.g()) {
            return;
        }
        LogData logData = new LogData();
        LogData logData2 = this.N;
        if (logData2 != null) {
            ReflectionUtils.a(logData2, logData);
        }
        logData.from = this.au;
        logData.userFrom = this.au;
        logData.target_uid = this.n.e().uid;
        logData.virtual = this.n.e().users_face;
        if (this.M == null) {
            this.M = new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, "");
        }
        ChatBundleExtra chatBundleExtra = new ChatBundleExtra();
        FuGiftListEvent fuGiftListEvent = this.ax;
        if (fuGiftListEvent != null) {
            chatBundleExtra.fuGiftListEvent = fuGiftListEvent;
            this.ax = null;
        }
        BluedIngSelfFeed bluedIngSelfFeed = this.F;
        if (bluedIngSelfFeed != null) {
            chatBundleExtra.feed = bluedIngSelfFeed;
            this.F = null;
        }
        if (StringUtils.d(this.n.e().uid)) {
            return;
        }
        try {
            ChatHelperV4.a().a(this.f34016a, Long.parseLong(this.n.e().uid), this.n.e().name, this.n.e().avatar, this.n.e().vbadge, this.n.e().vip_grade, this.n.e().is_vip_annual, this.n.e().vip_exp_lvl, this.n.e().distance, false, 0, this.n.e().is_hide_vip_look, logData, this.M, chatBundleExtra);
        } catch (Exception e) {
        }
    }
}
