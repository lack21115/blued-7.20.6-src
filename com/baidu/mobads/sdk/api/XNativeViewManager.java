package com.baidu.mobads.sdk.api;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/XNativeViewManager.class */
public class XNativeViewManager {
    private static XNativeViewManager sInstance;
    private final ArrayList<XNativeView> mViewList = new ArrayList<>();

    private XNativeViewManager() {
    }

    public static XNativeViewManager getInstance() {
        if (sInstance == null) {
            synchronized (XNativeViewManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new XNativeViewManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void addItem(XNativeView xNativeView) {
        this.mViewList.add(xNativeView);
    }

    public void removeNativeView(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        this.mViewList.remove(xNativeView);
    }

    public void resetAllPlayer(XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        Iterator<XNativeView> it = this.mViewList.iterator();
        while (it.hasNext()) {
            XNativeView next = it.next();
            if (next != xNativeView) {
                next.stop();
                next.handleCover();
            }
        }
    }
}
