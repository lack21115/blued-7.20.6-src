package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveLiangOrderModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.pop.LiveLiangPayedPop;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.gson.reflect.TypeToken;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLiangPayFragment.class */
public class LiveLiangPayFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public Context f12992a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f12993c;
    private Dialog d;
    private String e;
    private int f;
    private long g;
    private boolean h = false;
    private boolean i = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        LogUtils.c("buyLiangFail: , errorCode:" + i + ", errorMessage:" + str);
        switch (i) {
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putString("title", getString(R.string.Live_SendPresent_resetPayPassword));
                bundle.putString("content", getString(R.string.live_set_6_num));
                bundle.putString("http_host", LiveRoomInfo.a().m());
                LiveRouteUtil.a(this, bundle, i);
                return;
            case 4221003:
            case 4221006:
            case 4221007:
            default:
                getActivity().finish();
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
                bundle2.putString("content", getString(R.string.Live_SendPresent_verifyPasswordText));
                LiveRouteUtil.a(this, bundle2, i);
                return;
            case 4221008:
                c();
                return;
        }
    }

    public static void a(Context context, String str, int i, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("liang_id", str);
        bundle.putInt("reNew", i);
        bundle.putLong("expire_time", j);
        TransparentActivity.a(bundle);
        TransparentActivity.b(context, LiveLiangPayFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveLiangOrderModel liveLiangOrderModel) {
        if (liveLiangOrderModel == null) {
            getActivity().finish();
            return;
        }
        LogUtils.c("buyLiangSuccess: " + liveLiangOrderModel.liang_id);
        LiveLiangModel liveLiangModel = new LiveLiangModel();
        liveLiangModel.liang_id = liveLiangOrderModel.liang_id;
        liveLiangModel.liang_type = liveLiangOrderModel.liang_type;
        LiveRoomManager.a().a(liveLiangModel);
        LiveRoomPreferences.d(false);
        LiveLiangPayedPop.a(this, liveLiangOrderModel.liang_id, liveLiangOrderModel.expire_seconds, this.f);
    }

    public static void a(String str) {
        LogUtils.c("checkSavePayToken: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BluedEntityA bluedEntityA = (BluedEntityA) AppInfo.f().fromJson(str, new TypeToken<BluedEntityA<PayRemaining>>() { // from class: com.blued.android.module.live_china.fragment.LiveLiangPayFragment.3
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
        if (!b()) {
            getActivity().finish();
            return;
        }
        LogUtils.c("buyLiang: , payCode:" + str + ", payToken:" + LiveRoomPreferences.b(""));
        BluedUIHttpResponse<BluedEntityA<LiveLiangOrderModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveLiangOrderModel>>(getFragmentActive()) { // from class: com.blued.android.module.live_china.fragment.LiveLiangPayFragment.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveLiangOrderModel> bluedEntityA) {
                if (!LiveLiangPayFragment.this.b()) {
                    LiveLiangPayFragment.this.getActivity().finish();
                    return;
                }
                KeyboardUtils.a(LiveLiangPayFragment.this.getActivity());
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    LiveLiangPayFragment.this.a(0, "");
                    return;
                }
                LiveLiangOrderModel singleData = bluedEntityA.getSingleData();
                LiveLiangPayFragment.this.a(singleData);
                if (TextUtils.isEmpty(singleData.token)) {
                    return;
                }
                LiveRoomPreferences.c(singleData.token);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str2) {
                super.onFailure(th, i, str2);
                LiveLiangPayFragment.a(str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                if (!LiveLiangPayFragment.this.b()) {
                    LiveLiangPayFragment.this.getActivity().finish();
                    return false;
                }
                KeyboardUtils.a(LiveLiangPayFragment.this.getActivity());
                LiveLiangPayFragment.this.a(i, str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LiveLiangPayFragment.this.d.dismiss();
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveLiangPayFragment.this.d.show();
            }
        };
        if (this.f == 0) {
            LiveRoomHttpUtils.a(this.e, str, LiveRoomPreferences.b(""), z, bluedUIHttpResponse, getFragmentActive());
        } else {
            LiveRoomHttpUtils.a(this.e, this.g, str, LiveRoomPreferences.b(""), z, bluedUIHttpResponse, getFragmentActive());
        }
    }

    private void c() {
        LiveGiftPayTools.b();
        if (this.i) {
            return;
        }
        if (getFragmentActive() == null || !getFragmentActive().isActive()) {
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        String string = getString(R.string.live_id_charge_tip);
        this.i = true;
        CommonAlertDialog.a((Context) getActivity(), (View) null, "", string, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveLiangPayFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK);
                LiveLiangPayFragment.this.i = false;
                if (LiveDataManager.a().f()) {
                    LiveLiangPayFragment.this.getActivity().finish();
                    LiveRoomInfo.a().a(LiveLiangPayFragment.this.getContext(), 2);
                    return;
                }
                LiveLiangPayFragment.this.h = true;
                LiveRoomInfo.a().a(LiveLiangPayFragment.this.getContext(), LiveLiangPayFragment.this.getFragmentManager(), 2);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveLiangPayFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK);
                LiveLiangPayFragment.this.i = false;
                LiveLiangPayFragment.this.getActivity().finish();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.fragment.LiveLiangPayFragment.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                LiveLiangPayFragment.this.i = false;
                LiveLiangPayFragment.this.getActivity().finish();
            }
        }, true);
    }

    public void a() {
        this.d = DialogUtils.a(this.f12992a);
        a("", false);
    }

    protected boolean b() {
        return getFragmentActive() != null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            getActivity().finish();
        } else if ((i != 4221005 && i != 4221004) || intent == null) {
            if (i != 4221002 || intent == null) {
                return;
            }
            EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_SET_KEYWORD_CONFIRM_CLICK);
            a(intent.getStringExtra("password"), intent.getBooleanExtra("remember_me", false));
        } else {
            EventTrackLive.a(this.f == 1 ? LiveProtos.Event.BETTER_ID_RENEW_SUCCESS_CONFIRM_CLICK : LiveProtos.Event.BETTER_ID_RENEW_KEYWORD_CONFIRM_CLICK);
            String stringExtra = intent.getStringExtra("password");
            boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            a(stringExtra, booleanExtra);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.e = getArguments().getString("liang_id");
            this.f = getArguments().getInt("reNew");
            this.g = getArguments().getLong("expire_time");
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.f12992a = activity;
        this.f12993c = LayoutInflater.from(activity);
        if (this.b == null) {
            this.b = new FrameLayout(this.f12992a);
            StatusBarHelper.a((Activity) getActivity(), false);
            a();
            LiveEventBus.get("live_tans_activity", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.blued.android.module.live_china.fragment.LiveLiangPayFragment.1
                @Override // androidx.lifecycle.Observer
                /* renamed from: a */
                public void onChanged(final Boolean bool) {
                    AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.LiveLiangPayFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!bool.booleanValue() || !LiveLiangPayFragment.this.h || LiveLiangPayFragment.this.getActivity() == null || LiveLiangPayFragment.this.getActivity().isDestroyed()) {
                                return;
                            }
                            Log.i("==xpz", "show:" + bool);
                            LiveLiangPayFragment.this.h = false;
                            LiveLiangPayFragment.this.getActivity().finish();
                        }
                    }, 300L);
                }
            });
        }
        return this.b;
    }
}
