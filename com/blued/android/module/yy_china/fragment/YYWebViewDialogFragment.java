package com.blued.android.module.yy_china.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.urlroute.BluedUrlUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.ModelLoaderRegistry;
import com.blued.android.module.common.web.jsbridge.BridgeHandler;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.common.web.modelloader.utils.ResponseUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.listener.YYSimpleWebCallback;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYPayGoodsModel;
import com.blued.android.module.yy_china.model.YYPayRequestModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYPayUtils;
import com.blued.android.module.yy_china.web.modelloader.loader.WebNativeChargeLoader;
import com.blued.android.module.yy_china.web.modelloader.loader.WebPayLoader;
import com.blued.android.module.yy_china.web.modelloader.model.WebBuyGiftModel;
import com.blued.android.module.yy_china.web.modelloader.model.WebPayResponseModel;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Map;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYWebViewDialogFragment.class */
public class YYWebViewDialogFragment extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f17469a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private BridgeManager f17470c;
    private BluedWebView d;
    private YYSeatMemberModel e;
    private CallBackFunction f;
    private ConstraintLayout g;
    private TextView h;
    private ImageView i;
    private ImageView j;
    private boolean k = false;
    private float l = 0.4f;
    private WebView m;
    private RelativeLayout n;

    private void a(View view) {
        this.n = (RelativeLayout) view.findViewById(R.id.root_layout);
        this.g = (ConstraintLayout) view.findViewById(R.id.ll_title);
        this.h = (TextView) view.findViewById(R.id.tv_title);
        this.i = (ImageView) view.findViewById(R.id.img_back);
        this.j = (ImageView) view.findViewById(R.id.iv_top);
        WebView webView = (WebView) view.findViewById(R.id.dialog_web);
        this.m = webView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) webView.getLayoutParams();
        Map<String, String> a2 = !TextUtils.isEmpty(this.b) ? BluedUrlUtils.a(this.b) : null;
        if (a2 != null) {
            String str = a2.get("screen");
            if (!StringUtils.b(str) && str.matches("\\d+")) {
                Integer num = new Integer(str);
                if (num.intValue() > 0 && num.intValue() <= 100) {
                    layoutParams.height = (int) (AppInfo.m * (num.intValue() / 100.0f));
                }
            }
        }
        layoutParams.addRule(12);
        this.m.setBackgroundColor(getResources().getColor(R.color.transparent));
        this.m.getSettings().setTextZoom(100);
        if (this.k) {
            if (StatusBarHelper.a()) {
                ((ConstraintLayout.LayoutParams) this.h.getLayoutParams()).topMargin = StatusBarHelper.a(getContext());
            }
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                }
            });
            this.g.setVisibility(0);
        }
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYWebViewDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYWebViewDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        this.d = new BluedWebView(this, this.m, null, new YYSimpleWebCallback() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.4
            @Override // com.blued.android.module.yy_china.listener.YYSimpleWebCallback, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, String str2) {
                super.a(bluedWebView, str2);
                YYWebViewDialogFragment.this.h.setText(str2);
            }

            @Override // com.blued.android.module.yy_china.listener.YYSimpleWebCallback, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, String str2, boolean z) {
                String queryParameter = Uri.parse(str2).getQueryParameter("action");
                if (!TextUtils.isEmpty(queryParameter) && (TextUtils.equals(queryParameter, "webbrowse") || TextUtils.equals(queryParameter, "native_show_yy_room_list"))) {
                    YYWebViewDialogFragment.this.f17469a.onBackPressed();
                    YYWebViewDialogFragment.this.f17469a.getActivity().finish();
                }
                super.a(bluedWebView, str2, z);
                if (YYWebViewDialogFragment.this.f17470c != null) {
                    YYWebViewDialogFragment.this.f17470c.onLoadPageOverrideLoad(bluedWebView, str2, z);
                }
            }

            @Override // com.blued.android.module.yy_china.listener.YYSimpleWebCallback, com.blued.android.framework.web.BluedWebView.WebCallback
            public boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser) {
                if ("yy_close" == bluedUrlParser.a()) {
                    YYWebViewDialogFragment.this.g();
                    return false;
                } else if ("yy_read_norm_agree" == bluedUrlParser.a()) {
                    YYWebViewDialogFragment.this.h();
                    return false;
                } else {
                    return false;
                }
            }

            @Override // com.blued.android.module.yy_china.listener.YYSimpleWebCallback, com.blued.android.framework.web.BluedWebView.WebCallback
            public void b(BluedWebView bluedWebView, String str2, boolean z) {
                super.b(bluedWebView, str2, z);
                if (YYWebViewDialogFragment.this.f17470c != null) {
                    YYWebViewDialogFragment.this.f17470c.onLoadPageFinished(bluedWebView, str2);
                }
            }
        });
        this.m.getSettings().setTextZoom(100);
        f();
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        this.d.a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYGiftModel yYGiftModel, String str, boolean z, boolean z2) {
        if (yYGiftModel == null) {
            return;
        }
        YYPayRequestModel yYPayRequestModel = new YYPayRequestModel();
        yYGiftModel.hit_id = System.currentTimeMillis();
        if (yYGiftModel == null || this.e == null || YYRoomInfoManager.e().b() == null) {
            return;
        }
        yYPayRequestModel.gift = yYGiftModel;
        yYPayRequestModel.beans = yYGiftModel.beans;
        yYPayRequestModel.giftCount = yYGiftModel.count;
        yYPayRequestModel.goods_id = yYGiftModel.goods_id;
        yYPayRequestModel.goods_type = yYGiftModel.goods_type;
        yYPayRequestModel.hit_id = yYGiftModel.hit_id;
        yYPayRequestModel.payCode = str;
        yYPayRequestModel.remember_me = z;
        yYPayRequestModel.room_id = YYRoomInfoManager.e().b().room_id;
        yYPayRequestModel.target_uid = this.e.getUid();
        yYPayRequestModel.needFailDialog = z2;
        YYPayUtils.a(yYPayRequestModel, YYConstants.PayFromSource.Pay_Gift, this, a(), new YYPayUtils.PayGiftStatusListener() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.9
            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(int i, String str2) {
                if (YYWebViewDialogFragment.this.f != null) {
                    WebPayResponseModel webPayResponseModel = new WebPayResponseModel();
                    webPayResponseModel.result = i;
                    webPayResponseModel.message = str2;
                    YYWebViewDialogFragment.this.f.onCallBack(ResponseUtil.makeResponse(0, "抽卡支付失败", AppInfo.f().toJson(webPayResponseModel)));
                }
            }

            @Override // com.blued.android.module.yy_china.utils.YYPayUtils.PayGiftStatusListener
            public void a(YYPayGoodsModel yYPayGoodsModel) {
                YYGiftModel yYGiftModel2 = yYGiftModel;
                yYGiftModel2.hit_count = yYGiftModel2.count;
                YYImMsgManager.a().a(yYGiftModel, YYWebViewDialogFragment.this.e, yYPayGoodsModel, false);
                if (YYWebViewDialogFragment.this.f != null) {
                    WebPayResponseModel webPayResponseModel = new WebPayResponseModel();
                    webPayResponseModel.result = 200;
                    YYWebViewDialogFragment.this.f.onCallBack(ResponseUtil.makeResponse(1, "抽卡支付成功", AppInfo.f().toJson(webPayResponseModel)));
                }
            }
        });
    }

    private void f() {
        this.f17470c = new BridgeManager(this.d);
        ModelLoaderRegistry modelLoaderRegistry = new ModelLoaderRegistry();
        modelLoaderRegistry.add(LoaderConstants.YY_BUY_GIFT, new WebPayLoader.Factory());
        modelLoaderRegistry.add(LoaderConstants.YY_NATIVE_CHARGE, new WebNativeChargeLoader.Factory());
        modelLoaderRegistry.add("close", new WebNativeChargeLoader.Factory());
        modelLoaderRegistry.add(LoaderConstants.GO_BACK, new WebNativeChargeLoader.Factory());
        this.f17470c.registerHandler(LoaderConstants.YY_BUY_GIFT, new BridgeHandler() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.5
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                Logger.a("收到js data:" + str, new Object[0]);
                YYWebViewDialogFragment.this.f = callBackFunction;
                WebBuyGiftModel webBuyGiftModel = (WebBuyGiftModel) AppInfo.f().fromJson(str, (Class<Object>) WebBuyGiftModel.class);
                YYWebViewDialogFragment.this.e = webBuyGiftModel.user_info;
                YYWebViewDialogFragment.this.a(webBuyGiftModel.goods_info, "", false, !TextUtils.equals("2", webBuyGiftModel.recharge_toast));
            }
        });
        this.f17470c.registerHandler(LoaderConstants.YY_NATIVE_CHARGE, new BridgeHandler() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.6
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                LiveEventBus.get("event_to_charge").post("");
                YYWebViewDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        this.f17470c.registerHandler(LoaderConstants.YY_OPEN_MAGIC_LIST, new BridgeHandler() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.7
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                YYRoomInfoManager.e().c().a(YYWebViewDialogFragment.this.getContext(), "", 0);
                YYWebViewDialogFragment.this.f17469a.onBackPressed();
                YYWebViewDialogFragment.this.f17469a.getActivity().finish();
            }
        });
        this.f17470c.registerHandler("close", new BridgeHandler() { // from class: com.blued.android.module.yy_china.fragment.YYWebViewDialogFragment.8
            @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
            public void handler(String str, CallBackFunction callBackFunction) {
                YYWebViewDialogFragment.this.dismissAllowingStateLoss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        g();
    }

    public YYWebViewDialogFragment a(BaseFragment baseFragment, String str) {
        this.b = str;
        this.f17469a = baseFragment;
        return this;
    }

    public void a(boolean z) {
        this.k = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Logger.a("web dialog onActivityResult: " + i, new Object[0]);
        if (i2 == -1) {
            if ((i != 4221005 && i != 4221004) || intent == null) {
                if (i != 4221002 || intent == null) {
                    return;
                }
                YYGiftModel yYGiftModel = (YYGiftModel) intent.getSerializableExtra("selected_model");
                intent.getIntExtra("gift_count", 1);
                a(yYGiftModel, intent.getStringExtra("password"), intent.getBooleanExtra("remember_me", false), intent.getBooleanExtra("need_charge_dialog", true));
                return;
            }
            YYGiftModel yYGiftModel2 = (YYGiftModel) intent.getSerializableExtra("selected_model");
            String stringExtra = intent.getStringExtra("password");
            boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
            intent.getIntExtra("gift_count", 1);
            boolean booleanExtra2 = intent.getBooleanExtra("need_charge_dialog", true);
            if (TextUtils.isEmpty(stringExtra) || yYGiftModel2 == null) {
                return;
            }
            a(yYGiftModel2, stringExtra, booleanExtra, booleanExtra2);
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_yy_webview_dialog, viewGroup, true);
        a(inflate);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.n.removeView(this.m);
            this.m.removeAllViews();
            this.d.h();
        }
    }
}
