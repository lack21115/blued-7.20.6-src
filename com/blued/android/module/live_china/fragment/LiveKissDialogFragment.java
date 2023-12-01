package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.anythink.core.common.l;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.QueueFileDownloader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.click.SingleClickProxy;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveOneKissModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.reflect.TypeToken;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveKissDialogFragment.class */
public class LiveKissDialogFragment extends BaseDialogFragment {
    public static int l;
    public Context a;
    public View b;
    public View c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public int g;
    public int h;
    public int i;
    public String j;
    public String k;
    public EventCallBack p;
    private boolean q;
    private Dialog s;
    private boolean t;
    private LiveOneKissModel r = new LiveOneKissModel();
    BluedUIHttpResponse m = new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.6
        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            LiveKissDialogFragment.a(str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            KeyboardUtils.a((Activity) LiveKissDialogFragment.this.getActivity());
            LiveKissDialogFragment.this.a(i, str);
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            LiveKissDialogFragment.this.s.dismiss();
            super.onUIFinish();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            LiveKissDialogFragment.this.s.show();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
            KeyboardUtils.a((Activity) LiveKissDialogFragment.this.getActivity());
            if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                LiveKissDialogFragment.this.a(0, "");
                return;
            }
            LiveRoomManager.a().p();
            PayRemaining singleData = bluedEntity.getSingleData();
            LiveKissDialogFragment.this.g();
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            if (LiveKissDialogFragment.this.r != null) {
                liveGiftModel.goods_id = LiveKissDialogFragment.this.r.goods_id;
                liveGiftModel.name = LiveKissDialogFragment.this.r.goods_name;
                liveGiftModel.images_static = LiveKissDialogFragment.this.r.goods_icon;
                liveGiftModel.animation = singleData.animation;
                liveGiftModel.beans_current_count = singleData.beans_current;
                liveGiftModel.beans_count = singleData.beans_count;
                liveGiftModel.hit_id = singleData.hit_id;
                liveGiftModel.bonus = singleData.bonus;
                liveGiftModel.beans = singleData.beans;
            }
            LiveMsgSendManager.a().a(liveGiftModel);
            if (!TextUtils.isEmpty(singleData.token)) {
                LiveRoomPreferences.c(singleData.token);
            }
            LiveKissDialogFragment.this.f();
        }
    };
    private boolean u = false;
    ScaleAnimation n = null;
    Runnable o = new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.11
        @Override // java.lang.Runnable
        public void run() {
            LiveRoomManager.a().p();
            LiveKissDialogFragment.this.f();
        }
    };

    /* renamed from: com.blued.android.module.live_china.fragment.LiveKissDialogFragment$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveKissDialogFragment$1.class */
    class AnonymousClass1 implements QueueFileDownloader.QueueFileListener {
        AnonymousClass1() {
        }

        @Override // com.blued.android.core.net.http.QueueFileDownloader.QueueFileListener
        public void a(final int i, int i2, String str, final String str2) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (i >= 0) {
                        ImageLoader.d(LiveKissDialogFragment.this.a(), str2).e(LiveKissDialogFragment.l).g(-1).a(new ImageLoader.OnAnimationStateListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.1.1.1
                            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                            public void a() {
                                LiveKissDialogFragment.this.e.setVisibility(0);
                                LiveKissDialogFragment.this.f.setVisibility(0);
                                LiveKissDialogFragment.this.i();
                            }

                            @Override // com.blued.android.core.image.ImageLoader.OnAnimationStateListener
                            public void b() {
                            }
                        }).a(LiveKissDialogFragment.this.d);
                    } else {
                        LiveKissDialogFragment.this.f();
                    }
                }
            });
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveKissDialogFragment$EventCallBack.class */
    public interface EventCallBack {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        LogUtils.c("buyLiangFail: , errorCode:" + i + ", errorMessage:" + str);
        switch (i) {
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.Live_SendPresent_resetPayPassword));
                bundle.putString(l.y, getString(R.string.live_set_6_num));
                bundle.putString("http_host", LiveRoomInfo.a().m());
                LiveRouteUtil.a((Fragment) this, bundle, i);
                return;
            case 4221003:
            case 4221006:
            case 4221007:
            default:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                AppMethods.a((CharSequence) str);
                return;
            case 4221004:
            case 4221005:
                Bundle bundle2 = new Bundle();
                if (i == 4221005) {
                    bundle2.putString("title", getString(R.string.Live_SendPresent_verifyPassword));
                } else {
                    bundle2.putString("title", str);
                }
                bundle2.putString(l.y, getString(R.string.Live_SendPresent_verifyPasswordText));
                LiveRouteUtil.a((Fragment) this, bundle2, i);
                return;
            case 4221008:
                h();
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.blued.android.module.live_china.fragment.LiveKissDialogFragment$7] */
    public static void a(String str) {
        LogUtils.c("checkSavePayToken: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<PayRemaining>>() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.7
            }.getType());
            if (bluedEntityA.hasData()) {
                String str2 = ((PayRemaining) bluedEntityA.data.get(0)).token;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                LiveRoomPreferences.c(str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str, boolean z) {
        LiveGiftModel liveGiftModel = new LiveGiftModel();
        liveGiftModel.goods_id = this.k;
        LiveRoomHttpUtils.a(LiveRoomManager.a().g(), LiveDataManager.a().c(), liveGiftModel, "", str, TextUtils.isEmpty(str) ? LiveRoomPreferences.b("") : "", z, 1, this.m, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
    }

    private void h() {
        LiveGiftPayTools.b();
        if (this.u) {
            return;
        }
        if (a() == null || !a().isActive()) {
            f();
            return;
        }
        LiveRoomManager.a().p();
        String string = getString(R.string.live_id_charge_tip);
        this.u = true;
        CommonAlertDialog.a((Context) getActivity(), (View) null, "", string, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveKissDialogFragment.this.u = false;
                if (!LiveDataManager.a().f()) {
                    LiveRoomInfo.a().a(LiveKissDialogFragment.this.getContext(), LiveKissDialogFragment.this.getFragmentManager(), 2);
                    return;
                }
                LiveKissDialogFragment.this.f();
                LiveRoomInfo.a().a(LiveKissDialogFragment.this.getContext(), 2);
                if (LiveKissDialogFragment.this.p != null) {
                    LiveKissDialogFragment.this.p.a();
                }
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveKissDialogFragment.this.u = false;
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.10
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                LiveKissDialogFragment.this.u = false;
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        this.n = scaleAnimation;
        scaleAnimation.setDuration(600L);
        this.n.setFillAfter(false);
        this.n.setRepeatMode(2);
        this.n.setRepeatCount(-1);
        this.e.clearAnimation();
        this.e.startAnimation(this.n);
    }

    public void a(EventCallBack eventCallBack) {
        this.p = eventCallBack;
    }

    public void d() {
        if (this.t) {
            this.e.setVisibility(8);
        }
    }

    public void e() {
        if (this.t) {
            this.e.setVisibility(0);
        }
    }

    public void f() {
        Dialog dialog = getDialog();
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        dialog.dismiss();
    }

    public void onActivityCreated(Bundle bundle) {
        getDialog().getWindow().requestFeature(1);
        super.onActivityCreated(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getDialog().getWindow().getDecorView().setSystemUiVisibility(9216);
        }
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setLayout(-1, -1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                a(intent.getStringExtra("password"), intent.getBooleanExtra("remember_me", false));
            } else if (i != 4221002 || intent == null) {
            } else {
                a(intent.getStringExtra("password"), intent.getBooleanExtra("remember_me", false));
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = getActivity();
        if (getArguments() != null) {
            this.r = (LiveOneKissModel) getArguments().getSerializable("kissModel");
        }
        LiveOneKissModel liveOneKissModel = this.r;
        if (liveOneKissModel != null) {
            this.g = liveOneKissModel.pop;
            this.h = this.r.delay;
            this.i = this.r.duration;
            this.j = this.r.animation;
            this.k = this.r.goods_id;
            this.q = this.r.isChargeTo;
        }
        setStyle(0, R.style.Dialog_FullScreen);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LiveRoomHttpUtils.a(LiveDataManager.a().c(), 1);
        this.s = DialogUtils.a(this.a);
        View inflate = layoutInflater.inflate(R.layout.dialog_live_kiss, viewGroup);
        this.b = inflate;
        this.c = inflate.findViewById(R.id.empty_view);
        this.d = (ImageView) this.b.findViewById(R.id.iv_anim);
        this.e = (ImageView) this.b.findViewById(R.id.iv_click);
        this.f = (ImageView) this.b.findViewById(R.id.iv_close);
        this.e.setVisibility(8);
        this.f.setVisibility(8);
        l++;
        String str = this.j;
        QueueFileDownloader.a(new String[]{str}, new String[]{RecyclingUtils.d(str)}, new AnonymousClass1(), a(), true);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.e.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRoomManager.a().p();
                AppInfo.n().removeCallbacks(LiveKissDialogFragment.this.o);
                LiveGiftModel liveGiftModel = new LiveGiftModel();
                liveGiftModel.goods_id = LiveKissDialogFragment.this.k;
                LiveRoomHttpUtils.a(LiveRoomManager.a().g(), LiveDataManager.a().c(), liveGiftModel, "", "", LiveRoomPreferences.b(""), false, 1, LiveKissDialogFragment.this.m, (IRequestHost) LiveKissDialogFragment.this.a());
            }
        }, 2000L, null));
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRoomManager.a().p();
                LiveRoomHttpUtils.a(LiveDataManager.a().c(), 2);
                LiveKissDialogFragment.this.f();
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveKissDialogFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveRoomManager.a().p();
                LiveRoomHttpUtils.a(LiveDataManager.a().c(), 2);
                LiveKissDialogFragment.this.f();
            }
        });
        if (this.i > 0) {
            AppInfo.n().removeCallbacks(this.o);
            AppInfo.n().postDelayed(this.o, this.i * 1000);
        }
        LiveRoomManager.a().p();
        this.t = true;
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        if (this.t) {
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            this.s.dismiss();
            AppInfo.n().removeCallbacks(this.o);
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
