package com.youzan.androidsdk.ui;

import android.content.Context;
import android.content.Intent;
import com.youzan.androidsdk.WebViewCompat;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.event.Event;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/ui/YouzanClient.class */
public interface YouzanClient {
    public static final int PAGE_TYPE_HTML5 = 1;
    public static final int PAGE_TYPE_NATIVE_CART = 18;
    public static final int PAGE_TYPE_NATIVE_GOODS = 17;
    public static final int PAGE_TYPE_NATIVE_PAY_RESULT = 19;
    public static final int PAGE_TYPE_NATIVE_TRADE_LIST = 20;
    public static final int PAGE_TYPE_UNKNOWN = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/ui/YouzanClient$PageType.class */
    public @interface PageType {
    }

    Context getContext();

    int getPageType();

    String getTitle();

    String getUrl();

    WebViewCompat getWebViewCompat();

    void loadUrl(String str);

    boolean pageCanGoBack();

    boolean pageGoBack();

    boolean receiveFile(int i, Intent intent);

    void reload();

    void sharePage();

    void subscribe(Event event);

    void sync(YouzanToken youzanToken);

    boolean syncNot();
}
