package com.blued.login.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.CommonGuidePop;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.R;
import com.blued.login.auto.LoginServiceManager;
import com.blued.login.databinding.FmLoginMainBinding;
import com.blued.login.log.EventTrackLogin;
import com.blued.login.model.LoginSplashModel;
import com.blued.login.pop.OtherLoginPop;
import com.blued.login.utils.ConstraintUtil;
import com.blued.login.utils.LoginHelper;
import com.blued.login.utils.LoginPreferences;
import com.blued.login.view.LoginIndicator;
import com.blued.login.view.TagViewPager;
import com.blued.login.view.ViewPagerAdapter;
import com.blued.login.vm.LoginMainVM;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.tendinsv.OneKeyLoginManager;
import com.tencent.tendinsv.listener.GetPhoneInfoListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/fragment/LoginMainFragment.class */
public final class LoginMainFragment extends MVVMBaseFragment<LoginMainVM> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f20553a = {Reflection.a(new PropertyReference1Impl(LoginMainFragment.class, "vb", "getVb()Lcom/blued/login/databinding/FmLoginMainBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private CheckBox f20554c;
    private CommonGuidePop d;
    private String e;
    private String f;
    private Bundle g;
    private TXVodPlayer h;
    private final AtomicBoolean i;

    public LoginMainFragment() {
        super(R.layout.fm_login_main);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LoginMainFragment, FmLoginMainBinding>() { // from class: com.blued.login.fragment.LoginMainFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmLoginMainBinding invoke(LoginMainFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmLoginMainBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LoginMainFragment, FmLoginMainBinding>() { // from class: com.blued.login.fragment.LoginMainFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmLoginMainBinding invoke(LoginMainFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmLoginMainBinding.a(fragment.requireView());
            }
        });
        this.e = "";
        this.f = "";
        this.i = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        LoginPreferences.a("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMainFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.i.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMainFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        LoginServiceManager.a().b(this$0.getContext(), this$0.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMainFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LoginServiceManager.a().a(this$0.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMainFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z) {
            LoginServiceManager.a().a("check_term", this$0.getContext(), this$0.f20554c);
            this$0.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r0.isEmpty() != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.blued.login.fragment.LoginMainFragment r3, com.blued.login.model.LoginSplashModel r4) {
        /*
            r0 = r3
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r4
            if (r0 != 0) goto Lb
            return
        Lb:
            r0 = r4
            java.lang.String r0 = r0.getVideo()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r7
            if (r0 == 0) goto L2d
            r0 = r7
            int r0 = r0.length()
            if (r0 != 0) goto L28
            goto L2d
        L28:
            r0 = 0
            r5 = r0
            goto L2f
        L2d:
            r0 = 1
            r5 = r0
        L2f:
            r0 = r5
            if (r0 != 0) goto L3c
            r0 = r3
            r1 = r4
            java.lang.String r1 = r1.getVideo()
            r0.a(r1)
            return
        L3c:
            r0 = r4
            java.util.ArrayList r0 = r0.getImages()
            java.util.Collection r0 = (java.util.Collection) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L56
            r0 = r6
            r5 = r0
            r0 = r7
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L58
        L56:
            r0 = 1
            r5 = r0
        L58:
            r0 = r5
            if (r0 != 0) goto L6e
            r0 = r4
            java.util.ArrayList r0 = r0.getImages()
            r4 = r0
            r0 = r4
            if (r0 != 0) goto L66
            return
        L66:
            r0 = r3
            r1 = r4
            java.util.List r1 = (java.util.List) r1
            r0.a(r1)
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.login.fragment.LoginMainFragment.a(com.blued.login.fragment.LoginMainFragment, com.blued.login.model.LoginSplashModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMainFragment this$0, Boolean bool) {
        Intrinsics.e(this$0, "this$0");
        if (bool == null) {
            return;
        }
        boolean booleanValue = bool.booleanValue();
        CheckBox checkBox = this$0.f20554c;
        if (checkBox == null) {
            return;
        }
        checkBox.setChecked(booleanValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LoginMainFragment this$0, Void r5) {
        TagViewPager tagViewPager;
        Intrinsics.e(this$0, "this$0");
        FmLoginMainBinding p = this$0.p();
        if (p == null || (tagViewPager = p.m) == null) {
            return;
        }
        PagerAdapter adapter = tagViewPager.getAdapter();
        if (tagViewPager.getCurrentItem() == (adapter == null ? 0 : adapter.getCount()) - 1) {
            tagViewPager.setCurrentItem(0);
        } else {
            tagViewPager.setCurrentItem(tagViewPager.getCurrentItem() + 1);
        }
    }

    private final void a(String str) {
        TXCloudVideoView tXCloudVideoView;
        File externalCacheDir;
        FmLoginMainBinding p = p();
        if (p == null || (tXCloudVideoView = p.l) == null) {
            return;
        }
        tXCloudVideoView.setVisibility(0);
        TXVodPlayer tXVodPlayer = new TXVodPlayer(getContext());
        this.h = tXVodPlayer;
        if (tXVodPlayer != null) {
            tXVodPlayer.setAudioPlayoutVolume(0);
        }
        TXVodPlayer tXVodPlayer2 = this.h;
        if (tXVodPlayer2 != null) {
            tXVodPlayer2.setRequestAudioFocus(false);
        }
        TXVodPlayer tXVodPlayer3 = this.h;
        if (tXVodPlayer3 != null) {
            tXVodPlayer3.setLoop(true);
        }
        TXVodPlayer tXVodPlayer4 = this.h;
        if (tXVodPlayer4 != null) {
            tXVodPlayer4.setPlayerView(tXCloudVideoView);
        }
        TXVodPlayer tXVodPlayer5 = this.h;
        if (tXVodPlayer5 != null) {
            TXVodPlayConfig tXVodPlayConfig = new TXVodPlayConfig();
            Context context = getContext();
            String str2 = null;
            if (context != null && (externalCacheDir = context.getExternalCacheDir()) != null) {
                str2 = externalCacheDir.toString();
            }
            tXVodPlayConfig.setCacheFolderPath(Intrinsics.a(str2, (Object) "/TX/PLDroidPlayer"));
            tXVodPlayConfig.setMaxCacheItems(30);
            tXVodPlayer5.setConfig(tXVodPlayConfig);
        }
        TXVodPlayer tXVodPlayer6 = this.h;
        if (tXVodPlayer6 == null) {
            return;
        }
        tXVodPlayer6.startPlay(str);
    }

    private final void a(List<String> list) {
        LoginIndicator loginIndicator;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageLoader.a(getFragmentActive(), str).a(imageView);
            arrayList.add(imageView);
        }
        FmLoginMainBinding p = p();
        TagViewPager tagViewPager = p == null ? null : p.m;
        if (tagViewPager != null) {
            tagViewPager.setEnableScroll(false);
        }
        FmLoginMainBinding p2 = p();
        TagViewPager tagViewPager2 = p2 == null ? null : p2.m;
        if (tagViewPager2 != null) {
            tagViewPager2.setAdapter(new ViewPagerAdapter(arrayList));
        }
        FmLoginMainBinding p3 = p();
        if (p3 != null && (loginIndicator = p3.g) != null) {
            int size = list.size();
            FmLoginMainBinding p4 = p();
            TagViewPager tagViewPager3 = p4 == null ? null : p4.m;
            if (tagViewPager3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
            }
            loginIndicator.a(size, tagViewPager3);
        }
        j().g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LoginMainFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        Bundle bundle = this$0.g;
        String string = bundle == null ? null : bundle.getString("aliasUserId");
        if ((string == null || string.length() == 0) && !UserInfo.getInstance().isLogin()) {
            LoginServiceManager.a().d(this$0.getContext());
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LoginMainFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLogin.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.PHONE);
        CheckBox checkBox = this$0.f20554c;
        if (checkBox != null && checkBox.isChecked()) {
            String str = this$0.f;
            if (str == null || str.length() == 0) {
                LoginServiceManager.a().a(this$0.getContext(), this$0.g);
            } else {
                if (this$0.g == null) {
                    this$0.g = new Bundle();
                }
                Bundle bundle = this$0.g;
                if (bundle != null) {
                    bundle.putString("login_one_num", this$0.f);
                }
                LoginServiceManager.a().c(this$0.getContext(), this$0.g);
            }
        }
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final LoginMainFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.i.get()) {
            return;
        }
        this$0.i.compareAndSet(false, true);
        EventTrackLogin.a(LoginAndRegisterProtos.Event.LOGIN_BTN_CLICK, LoginAndRegisterProtos.Source.WECHAT);
        CheckBox checkBox = this$0.f20554c;
        if (checkBox != null) {
            if (checkBox.isChecked()) {
                this$0.q();
            }
            this$0.s();
        }
        this$0.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$iWlbCG5wsz0zPh6DsGBMpGegkTk
            @Override // java.lang.Runnable
            public final void run() {
                LoginMainFragment.a(LoginMainFragment.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LoginMainFragment this$0, View view) {
        Context context;
        Intrinsics.e(this$0, "this$0");
        CheckBox checkBox = this$0.f20554c;
        if (checkBox == null) {
            return;
        }
        if (checkBox.isChecked() && (context = this$0.getContext()) != null) {
            new XPopup.Builder(context).a((BasePopupView) new OtherLoginPop(context, this$0.g)).h();
        }
        this$0.s();
    }

    private final FmLoginMainBinding p() {
        return (FmLoginMainBinding) this.b.b(this, f20553a[0]);
    }

    private final void q() {
        Resources resources;
        Resources resources2;
        Resources resources3;
        Context context = getContext();
        Context context2 = getContext();
        String str = null;
        String string = (context2 == null || (resources = context2.getResources()) == null) ? null : resources.getString(R.string.hint);
        Context context3 = getContext();
        String string2 = (context3 == null || (resources2 = context3.getResources()) == null) ? null : resources2.getString(R.string.login_third_bind_phone_hint);
        Context context4 = getContext();
        if (context4 != null && (resources3 = context4.getResources()) != null) {
            str = resources3.getString(R.string.common_ok);
        }
        CommonAlertDialog.a(context, string, string2, str, new DialogInterface.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$DIbpyDgc2-YAfu63SPLC7VR4FO0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LoginMainFragment.a(LoginMainFragment.this, dialogInterface, i);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final void r() {
        ConstraintLayout constraintLayout;
        ConstraintUtil.ConstraintModify b;
        ConstraintUtil.ConstraintModify a2;
        if (StatusBarHelper.a()) {
            int a3 = StatusBarHelper.a(getContext());
            FmLoginMainBinding p = p();
            if (p == null || (constraintLayout = p.f20519a) == null || (b = new ConstraintUtil(constraintLayout).b()) == null || (a2 = b.a(R.id.fm_top, a3)) == null) {
                return;
            }
            a2.a();
        }
    }

    private final void s() {
        FrameLayout frameLayout;
        CheckBox checkBox = this.f20554c;
        if (checkBox == null) {
            return;
        }
        CommonGuidePop commonGuidePop = null;
        if (checkBox.isChecked()) {
            CommonGuidePop commonGuidePop2 = this.d;
            if (commonGuidePop2 == null) {
                Intrinsics.c("guidePop");
            } else {
                commonGuidePop = commonGuidePop2;
            }
            commonGuidePop.p();
            return;
        }
        CommonGuidePop.Companion companion = CommonGuidePop.t;
        CommonGuidePop commonGuidePop3 = this.d;
        CommonGuidePop commonGuidePop4 = commonGuidePop3;
        if (commonGuidePop3 == null) {
            Intrinsics.c("guidePop");
            commonGuidePop4 = null;
        }
        companion.a(commonGuidePop4, new SimpleCallback() { // from class: com.blued.login.fragment.LoginMainFragment$checkGuidePopBubble$1$1
        }, checkBox, 0L);
        FmLoginMainBinding p = p();
        if (p == null || (frameLayout = p.f20520c) == null) {
            return;
        }
        frameLayout.startAnimation(LoginHelper.f20590a.a(3));
    }

    private final void t() {
        OneKeyLoginManager.getInstance().getPhoneInfo(new GetPhoneInfoListener() { // from class: com.blued.login.fragment.LoginMainFragment$getPhoneNumber$1
            @Override // com.tencent.tendinsv.listener.GetPhoneInfoListener
            public void getPhoneInfoStatus(int i, String result) {
                Intrinsics.e(result, "result");
                Log.v("drb", "预取号结果 code：" + i + "  result:" + result);
                if (i == 1022) {
                    LoginMainFragment.this.f = result;
                }
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FragmentActivity activity;
        Window window;
        TextView textView;
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        ImageView imageView;
        FmLoginMainBinding p;
        ImageView imageView2;
        CheckBox checkBox;
        TextView textView2;
        if (AppInfo.m()) {
            FmLoginMainBinding p2 = p();
            TextView textView3 = p2 == null ? null : p2.h;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            FmLoginMainBinding p3 = p();
            if (p3 != null && (textView2 = p3.h) != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$SdR0iYpWjeip8S0N5kAUGzrC9mQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LoginMainFragment.a(LoginMainFragment.this, view);
                    }
                });
            }
        } else {
            FmLoginMainBinding p4 = p();
            TextView textView4 = p4 == null ? null : p4.h;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        r();
        if (!TextUtils.isEmpty(LoginPreferences.d())) {
            CommonAlertDialog.a(getActivity(), "", LoginPreferences.d(), getResources().getString(R.string.biao_v1_lr_confirm), new DialogInterface.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$it2wQFKHW1cSq7FRcfasBOCYQYg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LoginMainFragment.a(dialogInterface, i);
                }
            }, (DialogInterface.OnDismissListener) null, 0).a(false);
        }
        FmLoginMainBinding p5 = p();
        TextView textView5 = (p5 == null || (frameLayout = p5.f20520c) == null) ? null : (TextView) frameLayout.findViewById(R.id.tv_terms);
        FmLoginMainBinding p6 = p();
        TextView textView6 = (p6 == null || (frameLayout2 = p6.f20520c) == null) ? null : (TextView) frameLayout2.findViewById(R.id.tv_terms_en);
        if (textView5 != null && textView6 != null) {
            Context context = getContext();
            if (context != null) {
                textView5.setTextColor(ContextCompat.getColor(context, R.color.syc_dark_b));
                textView6.setTextColor(ContextCompat.getColor(context, R.color.syc_dark_b));
            }
            LoginServiceManager.a().a(textView5, textView6, true);
        }
        FmLoginMainBinding p7 = p();
        this.f20554c = (p7 == null || (frameLayout3 = p7.f20520c) == null) ? null : (CheckBox) frameLayout3.findViewById(R.id.cb_terms);
        Context context2 = getContext();
        if (context2 != null && (checkBox = this.f20554c) != null) {
            checkBox.setButtonDrawable(ContextCompat.getDrawable(context2, R.drawable.login_selector_checkbox));
        }
        CheckBox checkBox2 = this.f20554c;
        if (checkBox2 != null) {
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$afBi0AbZgezaoyc19OhAS_PVciY
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LoginMainFragment.a(LoginMainFragment.this, compoundButton, z);
                }
            });
        }
        Bundle arguments = getArguments();
        this.g = arguments;
        if (arguments != null) {
            arguments.putBoolean("arg_without_fitui", false);
        }
        Bundle bundle = this.g;
        if (bundle != null && bundle.containsKey("aliasUserId") && (p = p()) != null && (imageView2 = p.e) != null) {
            imageView2.setImageResource(R.drawable.icon_title_back_white);
        }
        FmLoginMainBinding p8 = p();
        ImageView imageView3 = p8 == null ? null : p8.e;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
        FmLoginMainBinding p9 = p();
        if (p9 != null && (imageView = p9.e) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$l1seVnYyVkaMyq6bNM3o17VxumE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginMainFragment.b(LoginMainFragment.this, view);
                }
            });
        }
        FmLoginMainBinding p10 = p();
        if (p10 != null && (shapeTextView2 = p10.i) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$hbChX1-JgOCcjopnQEfZhurDJD4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginMainFragment.c(LoginMainFragment.this, view);
                }
            });
        }
        FmLoginMainBinding p11 = p();
        if (p11 != null && (shapeTextView = p11.k) != null) {
            shapeTextView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$dN3mr69QRmFmrdkDIiYBtlhpLkM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginMainFragment.d(LoginMainFragment.this, view);
                }
            }));
        }
        FmLoginMainBinding p12 = p();
        if (p12 != null && (textView = p12.j) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$9mIPXZ-WszKQ-4gZenZbgBk33Ys
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoginMainFragment.e(LoginMainFragment.this, view);
                }
            });
        }
        Context context3 = getContext();
        if (context3 != null) {
            String string = getString(R.string.login_check_argument);
            Intrinsics.c(string, "getString(R.string.login_check_argument)");
            CommonGuidePop commonGuidePop = new CommonGuidePop(context3, string, NinePatchUtils.GuideArrowPosition.LEFT, R.drawable.guide_black_bubble_down);
            this.d = commonGuidePop;
            CommonGuidePop commonGuidePop2 = commonGuidePop;
            if (commonGuidePop == null) {
                Intrinsics.c("guidePop");
                commonGuidePop2 = null;
            }
            commonGuidePop2.setClickThrough(true);
            CommonGuidePop commonGuidePop3 = this.d;
            CommonGuidePop commonGuidePop4 = commonGuidePop3;
            if (commonGuidePop3 == null) {
                Intrinsics.c("guidePop");
                commonGuidePop4 = null;
            }
            commonGuidePop4.setDismissOnTouchOutside(false);
            CommonGuidePop commonGuidePop5 = this.d;
            if (commonGuidePop5 == null) {
                Intrinsics.c("guidePop");
                commonGuidePop5 = null;
            }
            commonGuidePop5.setOffsetX(BluedViewExtKt.a(-15));
        }
        Context context4 = getContext();
        if (context4 != null && (activity = getActivity()) != null && (window = activity.getWindow()) != null) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(context4, R.drawable.transparent));
        }
        if (LoginPreferences.f()) {
            j().f();
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LoginMainFragment loginMainFragment = this;
        j().d().observe(loginMainFragment, new Observer() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$UcUTCGezWrNEAEnKCOwfZ5akhlc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginMainFragment.a(LoginMainFragment.this, (LoginSplashModel) obj);
            }
        });
        j().e().observe(loginMainFragment, new Observer() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$5AZcinQHu8BEjLSxguNVqRTGVzY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginMainFragment.a(LoginMainFragment.this, (Void) obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LOGIN_CHECK, Boolean.TYPE).observe(loginMainFragment, new Observer() { // from class: com.blued.login.fragment.-$$Lambda$LoginMainFragment$amUKql3gxSb_DyTjQeEZsijY-zg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LoginMainFragment.a(LoginMainFragment.this, (Boolean) obj);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        TXCloudVideoView tXCloudVideoView;
        super.onDestroy();
        TXVodPlayer tXVodPlayer = this.h;
        if (tXVodPlayer != null) {
            tXVodPlayer.stopPlay(true);
        }
        FmLoginMainBinding p = p();
        if (p == null || (tXCloudVideoView = p.l) == null) {
            return;
        }
        tXCloudVideoView.onDestroy();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (LoginPreferences.f()) {
            t();
        }
    }
}
