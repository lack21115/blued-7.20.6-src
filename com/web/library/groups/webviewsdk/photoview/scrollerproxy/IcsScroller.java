package com.web.library.groups.webviewsdk.photoview.scrollerproxy;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photoview/scrollerproxy/IcsScroller.class */
public class IcsScroller extends GingerScroller {
    public IcsScroller(Context context) {
        super(context);
    }

    @Override // com.web.library.groups.webviewsdk.photoview.scrollerproxy.GingerScroller, com.web.library.groups.webviewsdk.photoview.scrollerproxy.ScrollerProxy
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }
}
