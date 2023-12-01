package com.soft.blued.ui.welcome.manager;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.model.Bid;
import com.soft.blued.model.ReachMaxResponse;
import com.soft.blued.model.Seatbid;
import com.soft.blued.ui.welcome.model.SplashEntity;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/manager/ReachAdManager.class */
public class ReachAdManager extends PicSplashManager {
    @Override // com.soft.blued.ui.welcome.manager.SplashAdManagerAdapter, com.soft.blued.ui.welcome.manager.SplashAdManager
    public void a(Context context, String str, ViewGroup viewGroup, IRequestHost iRequestHost, final SplashAdListener splashAdListener) {
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<ReachMaxResponse>(iRequestHost) { // from class: com.soft.blued.ui.welcome.manager.ReachAdManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(ReachMaxResponse reachMaxResponse) {
                if (reachMaxResponse.seatbid == null || reachMaxResponse.seatbid.size() <= 0) {
                    return;
                }
                SplashEntity.ShowEntity showEntity = new SplashEntity.ShowEntity();
                Seatbid seatbid = reachMaxResponse.seatbid.get(0);
                if (seatbid.bid == null || seatbid.bid.size() <= 0) {
                    return;
                }
                Bid bid = seatbid.bid.get(0);
                if (bid.adm != null && bid.adm.size() > 0) {
                    String str2 = bid.adm.get(0);
                    Log.v("drb", "百威图片地址：" + str2);
                    showEntity.ads_pics = str2;
                    if (bid.ext != null) {
                        if (bid.ext.cm != null) {
                            if (showEntity.click_url != null) {
                                String[] strArr = showEntity.click_url;
                                int length = strArr.length;
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= length) {
                                        break;
                                    }
                                    bid.ext.cm.add(strArr[i2]);
                                    i = i2 + 1;
                                }
                            }
                            showEntity.click_url = (String[]) bid.ext.cm.toArray(new String[0]);
                        }
                        if (bid.ext.pm != null) {
                            if (showEntity.show_url != null) {
                                String[] strArr2 = showEntity.show_url;
                                int length2 = strArr2.length;
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= length2) {
                                        break;
                                    }
                                    bid.ext.pm.add(strArr2[i4]);
                                    i3 = i4 + 1;
                                }
                            }
                            showEntity.show_url = (String[]) bid.ext.pm.toArray(new String[0]);
                        }
                        showEntity.target_url = bid.ext.ldp;
                    }
                }
                splashAdListener.a(showEntity);
            }
        }, str, "ceshi1012");
    }
}
