package com.oplus.quickgame.sdk.hall.feature;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.oplus.quickgame.sdk.hall.Constant;
import com.oplus.quickgame.sdk.hall.a.b;
import com.oplus.quickgame.sdk.hall.b.a;
import com.oplus.quickgame.sdk.hall.exception.HallRouterException;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/feature/GameHallRouter.class */
public class GameHallRouter {
    private b requestImpl = new b();

    private void requestWithUrl(Context context, String str, boolean z) throws HallRouterException {
        this.requestImpl.a(a.a(str));
        this.requestImpl.request(context);
    }

    public void requestWithUrl(Context context, String str) throws HallRouterException {
        if (TextUtils.isEmpty(str)) {
            throw new HallRouterException(HallRouterException.ErrorEnum.NULL_ERROR);
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (TextUtils.isEmpty(scheme) || !scheme.equals("oaps")) {
            throw new HallRouterException(HallRouterException.ErrorEnum.SCHEME_ERROR);
        }
        if (TextUtils.isEmpty(host) || !host.equals(Constant.Host.QG)) {
            throw new HallRouterException(HallRouterException.ErrorEnum.HOST_ERROR);
        }
        requestWithUrl(context, str, true);
    }

    public void startCardList(Context context, String str, String str2) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkCardList(str, str2), false);
    }

    public void startCategory(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkCategory(), false);
    }

    public void startDynamicSnippet(Context context, String str, String str2) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkDynamicSnippet(str, str2), false);
    }

    public void startFavList(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkFavList(), false);
    }

    public void startGame(Context context, String str) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkGame(str), false);
    }

    public void startGameList(Context context, String str, String str2, String str3) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkGameList(str, str2, str3, 1, 2, 0), false);
    }

    public void startGoldMarket(Context context, String str) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkGoldMarket(str), false);
    }

    public void startHome(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkHome(), false);
    }

    public void startProMode(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkProMode(), false);
    }

    public void startProfile(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkProfile(), false);
    }

    public void startRank(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkRank(), false);
    }

    public void startRecommend(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkRecommend(), false);
    }

    public void startSearch(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkSearch(), false);
    }

    public void startVideoDetail(Context context, String str) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkVideoDetail(str), false);
    }

    public void startVideoZone(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkVideoZone(), false);
    }

    public void startWeb(Context context, String str, String str2) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkWeb(str, str2), false);
    }

    public void startWelfare(Context context) throws HallRouterException {
        requestWithUrl(context, OapsFactory.linkWelfare(), false);
    }
}
