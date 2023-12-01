package com.blued.android.module.live_china.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.anythink.core.common.l;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/BuyGiftUtil.class */
public class BuyGiftUtil {
    private BaseDialogFragment a;
    private String b;
    private int c;
    private boolean d;
    private View e;
    private CallBack f;
    private boolean g = false;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/BuyGiftUtil$CallBack.class */
    public interface CallBack {
        void a(int i, String str);

        void a(long j);
    }

    public BuyGiftUtil(String str, int i, boolean z, View view, BaseDialogFragment baseDialogFragment, CallBack callBack) {
        this.b = str;
        this.c = i;
        this.d = z;
        this.e = view;
        this.a = baseDialogFragment;
        this.f = callBack;
        a("", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        LogUtils.c("buyGiftFail: , errorCode:" + i + ", errorMessage:" + str);
        switch (i) {
            case 4221002:
                Bundle bundle = new Bundle();
                bundle.putString("title", AppUtils.a(R.string.Live_SendPresent_resetPayPassword));
                bundle.putString(l.y, AppUtils.a(R.string.live_set_6_num));
                bundle.putString("http_host", LiveRoomInfo.a().m());
                LiveRouteUtil.a((Fragment) this.a, bundle, i);
                break;
            case 4221003:
            case 4221006:
            case 4221007:
            default:
                if (!TextUtils.isEmpty(str)) {
                    AppMethods.a((CharSequence) str);
                    break;
                }
                break;
            case 4221004:
            case 4221005:
                Bundle bundle2 = new Bundle();
                if (i == 4221005) {
                    bundle2.putString("title", AppUtils.a(R.string.Live_SendPresent_verifyPassword));
                } else {
                    bundle2.putString("title", str);
                }
                bundle2.putString(l.y, AppUtils.a(R.string.Live_SendPresent_verifyPasswordText));
                LiveRouteUtil.a((Fragment) this.a, bundle2, i);
                break;
            case 4221008:
                b();
                break;
        }
        CallBack callBack = this.f;
        if (callBack != null) {
            callBack.a(i, str);
        }
    }

    private void b() {
        LiveGiftPayTools.b();
        if (this.g || this.a.getActivity() == null || this.a.getActivity().isFinishing()) {
            return;
        }
        String a = AppUtils.a(R.string.live_id_charge_tip);
        this.g = true;
        CommonAlertDialog.a((Context) this.a.getActivity(), (View) null, "", a, AppUtils.a(R.string.cancel), AppUtils.a(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.utils.BuyGiftUtil.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_INSUFFICIENT_CONFIRM_CLICK);
                BuyGiftUtil.this.g = false;
                if (LiveDataManager.a().f()) {
                    LiveRoomInfo.a().a((Context) BuyGiftUtil.this.a.getActivity(), 2);
                } else {
                    LiveRoomInfo.a().a((Context) BuyGiftUtil.this.a.getActivity(), BuyGiftUtil.this.a.getFragmentManager(), 2);
                }
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.utils.BuyGiftUtil.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                EventTrackLive.a(LiveProtos.Event.BETTER_ID_RENEW_INSUFFICIENT_CANCEL_CLICK);
                BuyGiftUtil.this.g = false;
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.utils.BuyGiftUtil.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                BuyGiftUtil.this.g = false;
            }
        }, true);
    }

    public void a(String str, boolean z) {
        LiveRoomHttpUtils.a(this.b, this.c, this.d, str, TextUtils.isEmpty(str) ? LiveRoomPreferences.b("") : "", z, new BluedUIHttpResponse<BluedEntity<PayRemaining, LiveZanExtraModel>>(this.a.a()) { // from class: com.blued.android.module.live_china.utils.BuyGiftUtil.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str2) {
                super.onFailure(th, i, str2);
                LiveGiftPayTools.a(str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                if (!BuyGiftUtil.this.a()) {
                    BuyGiftUtil.this.a.getActivity().finish();
                    return false;
                }
                KeyboardUtils.a((Activity) BuyGiftUtil.this.a.getActivity());
                BuyGiftUtil.this.a(i, str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                BuyGiftUtil.this.e.setVisibility(8);
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                BuyGiftUtil.this.e.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<PayRemaining, LiveZanExtraModel> bluedEntity) {
                if (!BuyGiftUtil.this.a()) {
                    BuyGiftUtil.this.a.getActivity().finish();
                    return;
                }
                KeyboardUtils.a((Activity) BuyGiftUtil.this.a.getActivity());
                if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                    BuyGiftUtil.this.a(0, "");
                    return;
                }
                PayRemaining singleData = bluedEntity.getSingleData();
                if (!TextUtils.isEmpty(singleData.token)) {
                    LiveRoomPreferences.c(singleData.token);
                }
                if (BuyGiftUtil.this.f != null) {
                    long j = 0;
                    if (bluedEntity.data != null) {
                        j = 0;
                        if (bluedEntity.data.size() > 0) {
                            j = bluedEntity.data.get(0).beans_current;
                        }
                    }
                    BuyGiftUtil.this.f.a(j);
                }
            }
        }, this.a.a());
    }

    protected boolean a() {
        return this.a.a() != null;
    }
}
