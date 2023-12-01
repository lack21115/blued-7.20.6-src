package mtopsdk.mtop.antiattack;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.global.SDKConfig;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/antiattack/DefaultCheckCodeValidateListener.class */
public class DefaultCheckCodeValidateListener implements CheckCodeValidateListener {
    @Override // mtopsdk.mtop.antiattack.CheckCodeValidateListener
    public void a(CheckCodeDO checkCodeDO) {
        try {
            Context b = SDKConfig.a().b();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("checkcode", checkCodeDO);
            intent.putExtras(bundle);
            intent.setAction("mtopsdk.mtop.antiattack.checkcode.validate.activity_action");
            intent.setPackage(b.getPackageName());
            intent.setFlags(268435456);
            b.startActivity(intent);
        } catch (Throwable th) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.a("mtopsdk.DefaultCheckCodeValidateListener", "[doValidate]notify AntiAttack MtopSDKCheckCodeValidateActivity error ---", th);
            }
        }
    }
}
