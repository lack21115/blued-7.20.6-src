package com.blued.android.module.common.url;

import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.urlmanager.UrlFormatUtil;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/url/H5Url.class */
public final class H5Url {
    private static final String[] a = {"0/biaoqing%s", "0/livereports%s", "0/liveorders%s", "0/liverank%s", "0/liverank/game%s", "0/hotpk/index%s", "0/liverank/fansdevote%s", "0/livereports/card%s", "0/livereports/card?fromtype=1%s", "0/msg/phone%s", "0/home/user/logout%s", "0/medal%s", "0/app%s", "0/home/article/recharge%s", "0/vip/deadline%s", "0/map%s", "0/user?id=%s", "0/home/group/web-info?groupId=%s", "0/standpoint?id=%s", "0/redirect?is_sobot=1&usource=%s", "1/redirect?is_sobot=1&usource=%s&uid=%s", "0/term/userterm%s", "0/term/privacyclause%s", "0/term/conductterm%s", "0/term/liveterm%s", "0/user/wealth?uid=%s", "0/home/anchor/level%s", "0/term/groupterm%s", "0/feed?id=%s", "1/post?postid=%s&feedid=%s", "0/home/base/detail?baseId=%s", "1/home/activity-details/index?activityId=%s&uid=%s", "0/msg/migrate%s", "0/player/auth?appkey=%s", "0/term/vipprotocol%s", "0/term/vipterm%s", "0/msg/order%s", "0/blued/faq%s", "0/home/fans/huhuan%s", "3/vip/info?id=%s&detail=%s&page_grade=%s&user_grade=%s", "0/home/vip/help%s", "0/msg/order?source=1%s", "0/recordshare?lid=%s", "0/home/user/supertopic?id=%s", "0/home/live/gift%s", "0/home/coupon/intro%s", "1/home/vip/shadow?uid=%s&detail=%s", "0/home/call/serviceprotocol%s", "0/home/call/promotionclaim%s", "0/home/version-info%s", "0/home/anchor/fans%s", "0/livereports/agreement%s", "0/home/call/popularize?uid=%s", "0/msg/phone/addphone/1/?source=1%s", "0/home/lover%s", "1/home/fans/orderdetail?detail=%s&orderid=%s", "0/home/cool/index%s", "0/home/base/rank?circle_id=%s", "0/home/base/hotlist?is_goback=%s", "0/chat/agreement%s", "0/chat/gift-wall/info%s", "0/chat/gift/wall/home%s", "0/chat/first/charge%s", "0/chat/norm%s", "0/home/live/pk%s", "0/chat/live%s", "0/chat/room-hot-list?%s", "0/home/credit/index%s", "0/home/anchor/level%s", "0/user/wealth?uid=%s", "0/chat/detail%s", "0/livereports%s", "0/term/safety-tips%s", "0/term/risk-plan%s", "0/live%s", "0/home/live/pk-winning-streak%s", "0/chat/anchor/level%s", "0/chat/prop/city%s", "0/chat/honor/level?uid=%s", "0/chat/anchor/level?uid=%s", "0/chat/prop/city/myself%s", "0/chat/ktv/ranking%s", "0/chat/treasure/chest/explain%s", "0/term/privacy-brief%s", "0/home/live-college%s", "0/term/sdk?lan=cn%s", "0/term/sdk?lan=en%s", "0/term/sdk?lan=tw%s", "2/home/shop?uid=%s&access=%s&wid=%s", "0/activity-blued/work/hnaaydgt%s", "0/customerservices%s", "0/home/nobility?live%s", "0/term/information-collection-checklist%s", "0/chat/car/info?screen=70%s", "0/chat/car/record?screen=70%s", "0/term/vip-upgrade%s", "0/chat/room-rule%s", "0/chat/theme-rule%s", "0/chat/explain/nesting%s", "0/chat/love-rule%s", "0/chat/explain/romantic%s"};

    private static String a() {
        return HostConfig.a("H5") + "";
    }

    public static String a(int i) {
        return UrlFormatUtil.a(a[i], a(), new Object[0]);
    }

    public static String a(int i, Object... objArr) {
        return UrlFormatUtil.a(a[i], a(), objArr);
    }
}
