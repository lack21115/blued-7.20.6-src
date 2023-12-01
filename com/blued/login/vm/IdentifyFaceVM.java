package com.blued.login.vm;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.base.mvi.MVIBaseViewModel;
import com.blued.android.module.common.base.mvi.MviEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.login.R;
import com.blued.login.model.FaceSignModel;
import com.blued.login.state.IdentifyFaceAction;
import com.blued.login.state.IdentifyFaceState;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceVerifySdk;
import com.tencent.cloud.huiyansdkface.facelight.process.FaceVerifyStatus;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/vm/IdentifyFaceVM.class */
public final class IdentifyFaceVM extends MVIBaseViewModel<IdentifyFaceState, IdentifyFaceAction> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20611a;
    private FragmentActivity b;

    private final int a(String str) {
        String substring;
        String substring2;
        String str2;
        int parseInt;
        int parseInt2;
        if (str.length() == 18) {
            String substring3 = str.substring(6);
            Intrinsics.c(substring3, "this as java.lang.String).substring(startIndex)");
            String substring4 = substring3.substring(0, 4);
            Intrinsics.c(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring5 = str.substring(10);
            Intrinsics.c(substring5, "this as java.lang.String).substring(startIndex)");
            String substring6 = substring5.substring(0, 2);
            Intrinsics.c(substring6, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring7 = str.substring(12);
            Intrinsics.c(substring7, "this as java.lang.String).substring(startIndex)");
            String substring8 = substring7.substring(0, 2);
            Intrinsics.c(substring8, "this as java.lang.String…ing(startIndex, endIndex)");
            str2 = substring4;
            substring = substring6;
            substring2 = substring8;
        } else {
            String substring9 = str.substring(6, 8);
            Intrinsics.c(substring9, "this as java.lang.String…ing(startIndex, endIndex)");
            String a2 = Intrinsics.a("19", (Object) substring9);
            substring = str.substring(8, 10);
            Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            substring2 = str.substring(10, 12);
            Intrinsics.c(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            str2 = a2;
        }
        int i = -1;
        if (TextUtils.isDigitsOnly(str2)) {
            i = -1;
            if (TextUtils.isDigitsOnly(substring)) {
                i = -1;
                if (TextUtils.isDigitsOnly(substring2)) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String format = simpleDateFormat.format(date);
                    Intrinsics.c(format, "format.format(date)");
                    String substring10 = format.substring(0, 4);
                    Intrinsics.c(substring10, "this as java.lang.String…ing(startIndex, endIndex)");
                    String format2 = simpleDateFormat.format(date);
                    Intrinsics.c(format2, "format.format(date)");
                    String substring11 = format2.substring(5, 7);
                    Intrinsics.c(substring11, "this as java.lang.String…ing(startIndex, endIndex)");
                    String format3 = simpleDateFormat.format(date);
                    Intrinsics.c(format3, "format.format(date)");
                    String substring12 = format3.substring(8, 10);
                    Intrinsics.c(substring12, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (Integer.parseInt(substring) == Integer.parseInt(substring11)) {
                        if (Integer.parseInt(substring2) <= Integer.parseInt(substring12)) {
                            parseInt = Integer.parseInt(substring10);
                            parseInt2 = Integer.parseInt(str2);
                        } else {
                            parseInt = Integer.parseInt(substring10);
                            parseInt2 = Integer.parseInt(str2);
                        }
                    } else if (Integer.parseInt(substring) < Integer.parseInt(substring11)) {
                        parseInt = Integer.parseInt(substring10);
                        parseInt2 = Integer.parseInt(str2);
                    } else {
                        i = (Integer.parseInt(substring10) - Integer.parseInt(str2)) - 1;
                    }
                    i = parseInt - parseInt2;
                }
            }
        }
        Logger.c(getTAG(), Intrinsics.a("countAge : ", (Object) Integer.valueOf(i)));
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new IdentifyFaceVM$sendSucceedRequest$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(FaceSignModel faceSignModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(WbCloudFaceContant.INPUT_DATA, new WbCloudFaceVerifySdk.InputData(faceSignModel.getFace_id(), faceSignModel.getOrder_no(), faceSignModel.getApp_id(), faceSignModel.getApi_version(), faceSignModel.getNonce(), EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().uid), faceSignModel.getNonce_sign(), FaceVerifyStatus.Mode.GRADE, faceSignModel.getLicense()));
        bundle.putString(WbCloudFaceContant.LANGUAGE, WbCloudFaceContant.LANGUAGE_ZH_CN);
        bundle.putString(WbCloudFaceContant.COLOR_MODE, WbCloudFaceContant.WHITE);
        bundle.putString(WbCloudFaceContant.COMPARE_TYPE, WbCloudFaceContant.ID_CARD);
        this.f20611a = true;
        WbCloudFaceVerifySdk.getInstance().initSdk(this.b, bundle, new IdentifyFaceVM$openCloudFaceService$1(this));
    }

    private final void a(String str, String str2) {
        IdentifyFaceVM identifyFaceVM = this;
        BluedStructureExtKt.a(identifyFaceVM, MviEvent.LoadStarted.f10685a);
        String str3 = str;
        if (!(str3 == null || str3.length() == 0)) {
            String str4 = str2;
            boolean z = true;
            if (str4 != null) {
                z = str4.length() == 0;
            }
            if (!z) {
                if (str2.length() != 18 && str2.length() != 15) {
                    BluedStructureExtKt.a(identifyFaceVM, new MviEvent.LoadFinished(false, false, 3, null));
                    String string = AppInfo.d().getString(R.string.login_adult_id_length_error);
                    Intrinsics.c(string, "getAppContext().getStrin…in_adult_id_length_error)");
                    BluedStructureExtKt.a(identifyFaceVM, new MviEvent.ToastEvent(string));
                    return;
                }
                int a2 = a(str2);
                if (a2 < 0) {
                    BluedStructureExtKt.a(identifyFaceVM, new MviEvent.LoadFinished(false, false, 3, null));
                    String string2 = AppInfo.d().getString(R.string.login_adult_input_error);
                    Intrinsics.c(string2, "getAppContext().getStrin….login_adult_input_error)");
                    BluedStructureExtKt.a(identifyFaceVM, new MviEvent.ToastEvent(string2));
                    return;
                } else if (a2 < 18) {
                    BluedStructureExtKt.a(identifyFaceVM, new MviEvent.LoadFinished(false, false, 3, null));
                    String string3 = AppInfo.d().getString(R.string.login_adult_lower_18);
                    Intrinsics.c(string3, "getAppContext().getStrin…ing.login_adult_lower_18)");
                    BluedStructureExtKt.a(identifyFaceVM, new MviEvent.ToastEvent(string3));
                    return;
                } else {
                    String str5 = str2;
                    if (StringsKt.c((CharSequence) str4, (CharSequence) "x", false, 2, (Object) null)) {
                        str5 = StringsKt.a(str2, 'x', 'X', false, 4, (Object) null);
                    }
                    b(str, str5);
                    return;
                }
            }
        }
        BluedStructureExtKt.a(identifyFaceVM, new MviEvent.LoadFinished(false, false, 3, null));
        String string4 = AppInfo.d().getString(R.string.login_adult_input_empty);
        Intrinsics.c(string4, "getAppContext().getStrin….login_adult_input_empty)");
        BluedStructureExtKt.a(identifyFaceVM, new MviEvent.ToastEvent(string4));
    }

    private final void b(String str, String str2) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new IdentifyFaceVM$requestSign$1(str, str2, this, null), 3, null);
    }

    public final void a(FragmentActivity fragmentActivity) {
        this.b = fragmentActivity;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseViewModel
    /* renamed from: a */
    public void dispatchAction(IdentifyFaceAction action) {
        Intrinsics.e(action, "action");
        if (action instanceof IdentifyFaceAction.VerifyCard) {
            IdentifyFaceAction.VerifyCard verifyCard = (IdentifyFaceAction.VerifyCard) action;
            a(verifyCard.a(), verifyCard.b());
        }
    }

    public final FragmentActivity getActivity() {
        return this.b;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.b = null;
    }
}
