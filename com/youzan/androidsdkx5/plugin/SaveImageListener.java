package com.youzan.androidsdkx5.plugin;

import android.content.ActivityNotFoundException;
import com.tencent.smtt.sdk.WebView;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdkx5/plugin/SaveImageListener.class */
public interface SaveImageListener {
    boolean onSaveImage(WebView.HitTestResult hitTestResult) throws ActivityNotFoundException;
}
