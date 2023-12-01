package com.oplus.quickgame.sdk.hall.feature;

import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.hall.Constant;
import com.oplus.quickgame.sdk.hall.c.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/feature/OapsFactory.class */
public class OapsFactory {
    public static String linkCardList(String str, String str2) {
        HashMap hashMap = new HashMap();
        c.b(hashMap).a("id", str).a("name", str2);
        return linkPage(Constant.Path.CARD_LIST, hashMap);
    }

    public static String linkCategory() {
        return linkFixedPage(Constant.Path.CATEGORY);
    }

    public static String linkDynamicSnippet(String str, String str2) {
        HashMap hashMap = new HashMap();
        c.b(hashMap).a("id", str).a("type", str2);
        return linkPage(Constant.Path.DYNAMIC_SNIPPET, hashMap);
    }

    public static String linkFavList() {
        return linkFixedPage(Constant.Path.FAV_LIST);
    }

    private static String linkFixedPage(String str) {
        return linkPage(str, null);
    }

    public static String linkGame(String str) {
        HashMap hashMap = new HashMap();
        c.b(hashMap).a("pkgName", str);
        return linkPage(Constant.Path.GAME, hashMap);
    }

    public static String linkGameList(String str, String str2, String str3, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        c.b(hashMap).a(Constant.Param.KEY_DATA_SRC, str).a("id", str2).a(Constant.Param.KEY_TOPIC_TYPE, Integer.valueOf(i)).a(Constant.Param.KEY_SHOW_RANK_NUM, Integer.valueOf(i3)).a(Constant.Param.KEY_SHOW_TYPE, Integer.valueOf(i2)).a("name", str3);
        return linkPage(Constant.Path.GAME_LIST, hashMap);
    }

    public static String linkGoldMarket(String str) {
        HashMap hashMap = new HashMap();
        c.b(hashMap).a(Constant.Param.KEY_URL, str);
        return linkPage(Constant.Path.GOLD_MARKET, hashMap);
    }

    public static String linkHome() {
        return linkFixedPage("/home");
    }

    private static String linkPage(String str, Map<String, Object> map) {
        return QuickGame.createGameHallRouterBuilder().setScheme("oaps").setHost(Constant.Host.QG).setPath(str).setParams(map).build();
    }

    public static String linkProMode() {
        return linkFixedPage(Constant.Path.PRO_MODE);
    }

    public static String linkProfile() {
        return linkFixedPage(Constant.Path.PROFILE);
    }

    public static String linkRank() {
        return linkFixedPage(Constant.Path.RANK);
    }

    public static String linkRecommend() {
        return linkFixedPage(Constant.Path.RECOMMEND);
    }

    public static String linkSearch() {
        return linkFixedPage("/search");
    }

    public static String linkVideoDetail(String str) {
        HashMap hashMap = new HashMap();
        c.b(hashMap).a("id", str);
        return linkPage(Constant.Path.VIDEO_DETAIL, hashMap);
    }

    public static String linkVideoZone() {
        return linkFixedPage(Constant.Path.VIDEO_ZONE);
    }

    public static String linkWeb(String str, String str2) {
        HashMap hashMap = new HashMap();
        c.b(hashMap).a(Constant.Param.KEY_URL, str).a("title", str2);
        return linkPage("/web", hashMap);
    }

    public static String linkWelfare() {
        return linkFixedPage("/welfare");
    }
}
