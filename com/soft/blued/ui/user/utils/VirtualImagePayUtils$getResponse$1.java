package com.soft.blued.ui.user.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.bytedance.applog.tracker.Tracker;
import com.jungly.gridpasswordview.GridPasswordView;
import com.soft.blued.R;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.utils.VirtualImagePayUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.dialog.CommonAlertDialog2;
import com.soft.blued.view.dialog.DialogWith6PW;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImagePayUtils$getResponse$1.class */
public final class VirtualImagePayUtils$getResponse$1 extends BluedUIHttpResponse<BluedEntityA<VirtualImageModel.PaidResp>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IRequestHost f20646a;
    final /* synthetic */ VirtualImagePayUtils b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ VirtualImagePayUtils.PayResult f20647c;
    final /* synthetic */ Context d;
    final /* synthetic */ List<VirtualImageModel.PayGoodsInfo> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImagePayUtils$getResponse$1(IRequestHost iRequestHost, VirtualImagePayUtils virtualImagePayUtils, VirtualImagePayUtils.PayResult payResult, Context context, List<VirtualImageModel.PayGoodsInfo> list) {
        super(iRequestHost);
        this.f20646a = iRequestHost;
        this.b = virtualImagePayUtils;
        this.f20647c = payResult;
        this.d = context;
        this.e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(context, "$context");
        dialogInterface.dismiss();
        BeansPrePayFragment.a(context, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, IRequestHost iRequestHost) {
        Intrinsics.e(context, "$context");
        Intrinsics.e(iRequestHost, "$requestHost");
        LiveGiftPayTools.a(context, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImagePayUtils.PayResult payResult, VirtualImageModel.PaidResp paidResp) {
        Intrinsics.e(payResult, "$payResult");
        payResult.a(paidResp.getLeft_beans());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImagePayUtils virtualImagePayUtils, Context context, Pair pair) {
        Intrinsics.e(virtualImagePayUtils, "this$0");
        Intrinsics.e(context, "$context");
        DialogWith6PW a2 = virtualImagePayUtils.a();
        if (a2 == null) {
            return;
        }
        TextView textView = a2.f21178c;
        if (textView != null) {
            textView.setTextColor(context.getResources().getColor(2131099765));
            textView.setText((CharSequence) pair.second);
        }
        GridPasswordView gridPasswordView = a2.b;
        if (gridPasswordView == null) {
            return;
        }
        gridPasswordView.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final VirtualImagePayUtils virtualImagePayUtils, final Context context, final IRequestHost iRequestHost, final List list, final VirtualImagePayUtils.PayResult payResult) {
        AlertDialog alertDialog;
        Intrinsics.e(virtualImagePayUtils, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(iRequestHost, "$requestHost");
        Intrinsics.e(list, "$goodsList");
        Intrinsics.e(payResult, "$payResult");
        DialogWith6PW a2 = virtualImagePayUtils.a();
        if (a2 == null || (alertDialog = a2.f21177a) == null || !alertDialog.isShowing()) {
            String string = context.getString(R.string.Live_SendPresent_verifyPassword);
            Intrinsics.c(string, "context.getString(R.stri…ndPresent_verifyPassword)");
            String string2 = context.getString(R.string.Live_SendPresent_verifyPasswordText);
            Intrinsics.c(string2, "context.getString(R.stri…esent_verifyPasswordText)");
            virtualImagePayUtils.a(CommonAlertDialog2.a(context, string, string2, true, false, true, true, new CommonAlertDialog2.PWDListener() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImagePayUtils$getResponse$1$6iiPWJUHud416TJUjp4fS3dXynM
                @Override // com.soft.blued.view.dialog.CommonAlertDialog2.PWDListener
                public final void onClick(String str, boolean z, DialogWith6PW dialogWith6PW) {
                    VirtualImagePayUtils$getResponse$1.a(VirtualImagePayUtils.this, context, iRequestHost, list, payResult, str, z, dialogWith6PW);
                }
            }, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static final void a(VirtualImagePayUtils virtualImagePayUtils, Context context, IRequestHost iRequestHost, List list, VirtualImagePayUtils.PayResult payResult, String str, boolean z, DialogWith6PW dialogWith6PW) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void onUIUpdate(BluedEntityA<VirtualImageModel.PaidResp> bluedEntityA) {
        AlertDialog alertDialog;
        DialogWith6PW a2 = this.b.a();
        if (a2 != null && (alertDialog = a2.f21177a) != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        if (bluedEntityA == null) {
            return;
        }
        final VirtualImagePayUtils.PayResult payResult = this.f20647c;
        if (bluedEntityA.hasData()) {
            final VirtualImageModel.PaidResp paidResp = (VirtualImageModel.PaidResp) bluedEntityA.data.get(0);
            if (!TextUtils.isEmpty(paidResp.getPayment_token())) {
                BluedPreferences.H(paidResp.getPayment_token());
            }
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImagePayUtils$getResponse$1$kvEK1WvRnt6r-t8bo2OwuFWn7U8
                @Override // java.lang.Runnable
                public final void run() {
                    VirtualImagePayUtils$getResponse$1.a(VirtualImagePayUtils.PayResult.this, paidResp);
                }
            }, 500L);
        }
    }

    public boolean onUIFailure(int i, String str, String str2) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        LiveGiftPayTools.a(str2);
        final Pair a2 = BluedHttpUtils.a((Throwable) null, i, str2);
        Integer num = (Integer) a2.first;
        if (num != null && num.intValue() == 0) {
            return super.onUIFailure(i, str, str2);
        }
        if (i == 4221002) {
            Handler n = AppInfo.n();
            final Context context = this.d;
            final IRequestHost iRequestHost = this.f20646a;
            n.post(new Runnable() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImagePayUtils$getResponse$1$acGJntLia2jfI1gpKR-nSWlVp20
                @Override // java.lang.Runnable
                public final void run() {
                    VirtualImagePayUtils$getResponse$1.a(Context.this, iRequestHost);
                }
            });
            return true;
        } else if (i == 4221008) {
            DialogWith6PW a3 = this.b.a();
            if (a3 != null && (alertDialog = a3.f21177a) != null && alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
            Context context2 = this.d;
            String string = context2.getString(R.string.Live_SendPresent_notEnoughWandou);
            String string2 = this.d.getString(R.string.Live_SendPresent_recharge);
            final Context context3 = this.d;
            CommonAlertDialog.a(context2, "", string, string2, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImagePayUtils$getResponse$1$kcjcxF73XzTOaCDaBCwmjFV6mwc
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    VirtualImagePayUtils$getResponse$1.a(Context.this, dialogInterface, i2);
                }
            }, this.d.getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            return true;
        } else {
            switch (i) {
                case 4221004:
                    if (TextUtils.isEmpty((CharSequence) a2.second)) {
                        return true;
                    }
                    Handler n2 = AppInfo.n();
                    final VirtualImagePayUtils virtualImagePayUtils = this.b;
                    final Context context4 = this.d;
                    n2.post(new Runnable() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImagePayUtils$getResponse$1$1sOenkApl4GAUO6rjYGN9W3n6DU
                        @Override // java.lang.Runnable
                        public final void run() {
                            VirtualImagePayUtils$getResponse$1.a(VirtualImagePayUtils.this, context4, a2);
                        }
                    });
                    return true;
                case 4221005:
                    Handler n3 = AppInfo.n();
                    final VirtualImagePayUtils virtualImagePayUtils2 = this.b;
                    final Context context5 = this.d;
                    final IRequestHost iRequestHost2 = this.f20646a;
                    final List<VirtualImageModel.PayGoodsInfo> list = this.e;
                    final VirtualImagePayUtils.PayResult payResult = this.f20647c;
                    n3.post(new Runnable() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImagePayUtils$getResponse$1$2-uuF1xomHkGqda1C0DqySXoT6M
                        @Override // java.lang.Runnable
                        public final void run() {
                            VirtualImagePayUtils$getResponse$1.a(VirtualImagePayUtils.this, context5, iRequestHost2, list, payResult);
                        }
                    });
                    return true;
                default:
                    switch (i) {
                        case 4433003:
                            ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_today_buy_max_hint));
                            return true;
                        case 4433004:
                            ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_buy_max_hint));
                            return true;
                        case 4433005:
                            ToastUtils.a(AppInfo.d().getString(R.string.msg_stop_selling));
                            return true;
                        case 4433006:
                            ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_send_failed));
                            return true;
                        case 4433007:
                            ToastUtils.a(AppInfo.d().getString(R.string.msg_gift_send_expired));
                            return true;
                        default:
                            DialogWith6PW a4 = this.b.a();
                            if (a4 != null && (alertDialog2 = a4.f21177a) != null && alertDialog2.isShowing()) {
                                alertDialog2.dismiss();
                            }
                            this.f20647c.a(i, str);
                            return true;
                    }
            }
        }
    }
}
