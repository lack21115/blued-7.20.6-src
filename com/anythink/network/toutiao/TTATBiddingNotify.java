package com.anythink.network.toutiao;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATSDK;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.opos.acs.st.utils.ErrorContants;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATBiddingNotify.class */
public class TTATBiddingNotify implements ATBiddingNotice {

    /* renamed from: a  reason: collision with root package name */
    TTClientBidding f6257a;

    /* JADX INFO: Access modifiers changed from: protected */
    public TTATBiddingNotify(TTClientBidding tTClientBidding) {
        this.f6257a = tTClientBidding;
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    public void notifyBidDisplay(boolean z, double d) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TTATBiddingNotify", "notifyBidDisplay :  price:" + d + ",isWinner:" + z);
        }
        try {
            this.f6257a.setPrice(Double.valueOf(d));
        } catch (Throwable th) {
        }
        this.f6257a = null;
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        String str2;
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TTATBiddingNotify", "notifyBidLoss :  price:" + d + ",lossCode:" + str);
        }
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != 50) {
            if (hashCode != 53) {
                switch (hashCode) {
                    case 48627:
                        if (str.equals("102")) {
                            z = true;
                            break;
                        }
                        break;
                    case 48628:
                        if (str.equals("103")) {
                            z = true;
                            break;
                        }
                        break;
                }
            } else if (str.equals("5")) {
                z = true;
            }
        } else if (str.equals("2")) {
            z = false;
        }
        if (z) {
            str2 = "102";
            if (!z) {
                str2 = "102";
                if (!z) {
                    str2 = ErrorContants.REALTIME_LOADAD_ERROR;
                }
            }
        } else {
            str2 = "2";
        }
        try {
            this.f6257a.loss(Double.valueOf(d), str2, null);
        } catch (Throwable th) {
        }
        this.f6257a = null;
    }

    public void notifyBidWin(double d) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.i("TTATBiddingNotify", "notifyBidWin : second price:".concat(String.valueOf(d)));
        }
        try {
            this.f6257a.win(Double.valueOf(d));
        } catch (Throwable th) {
        }
    }
}
