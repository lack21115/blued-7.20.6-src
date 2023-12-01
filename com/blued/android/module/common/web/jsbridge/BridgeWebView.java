package com.blued.android.module.common.web.jsbridge;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/jsbridge/BridgeWebView.class */
public class BridgeWebView extends WebView implements WebViewJavascriptBridge {
    public static final String toLoadJs = "WebViewJavascriptBridge.js";
    private final String TAG;
    BridgeHandler defaultHandler;
    Map<String, BridgeHandler> messageHandlers;
    Map<String, CallBackFunction> responseCallbacks;
    private List<Message> startupMessage;
    private long uniqueId;

    public BridgeWebView(Context context) {
        super(context);
        this.TAG = "BridgeWebView";
        this.responseCallbacks = new HashMap();
        this.messageHandlers = new HashMap();
        this.defaultHandler = new DefaultHandler();
        this.startupMessage = new ArrayList();
        this.uniqueId = 0L;
        init();
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "BridgeWebView";
        this.responseCallbacks = new HashMap();
        this.messageHandlers = new HashMap();
        this.defaultHandler = new DefaultHandler();
        this.startupMessage = new ArrayList();
        this.uniqueId = 0L;
        init();
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "BridgeWebView";
        this.responseCallbacks = new HashMap();
        this.messageHandlers = new HashMap();
        this.defaultHandler = new DefaultHandler();
        this.startupMessage = new ArrayList();
        this.uniqueId = 0L;
        init();
    }

    private void doSend(String str, String str2, CallBackFunction callBackFunction) {
        Message message = new Message();
        if (!TextUtils.isEmpty(str2)) {
            message.setData(str2);
        }
        if (callBackFunction != null) {
            StringBuilder sb = new StringBuilder();
            long j = this.uniqueId + 1;
            this.uniqueId = j;
            sb.append(j);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(SystemClock.currentThreadTimeMillis());
            String format = String.format(BridgeUtil.CALLBACK_ID_FORMAT, sb.toString());
            this.responseCallbacks.put(format, callBackFunction);
            message.setCallbackId(format);
        }
        if (!TextUtils.isEmpty(str)) {
            message.setHandlerName(str);
        }
        queueMessage(message);
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        setWebViewClient(generateBridgeWebViewClient());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queueMessage(Message message) {
        List<Message> list = this.startupMessage;
        if (list != null) {
            list.add(message);
        } else {
            dispatchMessage(message);
        }
    }

    public void callHandler(String str, String str2, CallBackFunction callBackFunction) {
        doSend(str, str2, callBackFunction);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchMessage(Message message) {
        String format = String.format(BridgeUtil.JS_HANDLE_MESSAGE_FROM_JAVA, message.toJson().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\""));
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushMessageQueue() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(BridgeUtil.JS_FETCH_QUEUE_FROM_JAVA, new CallBackFunction() { // from class: com.blued.android.module.common.web.jsbridge.BridgeWebView.1
                @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                public void onCallBack(String str) {
                    try {
                        List<Message> arrayList = Message.toArrayList(str);
                        if (arrayList == null || arrayList.size() == 0) {
                            return;
                        }
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= arrayList.size()) {
                                return;
                            }
                            Message message = arrayList.get(i2);
                            String responseId = message.getResponseId();
                            if (TextUtils.isEmpty(responseId)) {
                                final String callbackId = message.getCallbackId();
                                CallBackFunction callBackFunction = !TextUtils.isEmpty(callbackId) ? new CallBackFunction() { // from class: com.blued.android.module.common.web.jsbridge.BridgeWebView.1.1
                                    @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                                    public void onCallBack(String str2) {
                                        Message message2 = new Message();
                                        message2.setResponseId(callbackId);
                                        message2.setResponseData(str2);
                                        BridgeWebView.this.queueMessage(message2);
                                    }
                                } : new CallBackFunction() { // from class: com.blued.android.module.common.web.jsbridge.BridgeWebView.1.2
                                    @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                                    public void onCallBack(String str2) {
                                    }
                                };
                                BridgeHandler bridgeHandler = !TextUtils.isEmpty(message.getHandlerName()) ? BridgeWebView.this.messageHandlers.get(message.getHandlerName()) : BridgeWebView.this.defaultHandler;
                                if (bridgeHandler != null) {
                                    bridgeHandler.handler(message.getData(), callBackFunction);
                                }
                            } else {
                                BridgeWebView.this.responseCallbacks.get(responseId).onCallBack(message.getResponseData());
                                BridgeWebView.this.responseCallbacks.remove(responseId);
                            }
                            i = i2 + 1;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    protected BridgeWebViewClient generateBridgeWebViewClient() {
        return new BridgeWebViewClient(this);
    }

    public List<Message> getStartupMessage() {
        return this.startupMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handlerReturnData(String str) {
        String functionFromReturnUrl = BridgeUtil.getFunctionFromReturnUrl(str);
        CallBackFunction callBackFunction = this.responseCallbacks.get(functionFromReturnUrl);
        String dataFromReturnUrl = BridgeUtil.getDataFromReturnUrl(str);
        if (callBackFunction != null) {
            callBackFunction.onCallBack(dataFromReturnUrl);
            this.responseCallbacks.remove(functionFromReturnUrl);
        }
    }

    public void loadUrl(String str, CallBackFunction callBackFunction) {
        loadUrl(str);
        this.responseCallbacks.put(BridgeUtil.parseFunctionName(str), callBackFunction);
    }

    public void registerHandler(String str, BridgeHandler bridgeHandler) {
        if (bridgeHandler != null) {
            this.messageHandlers.put(str, bridgeHandler);
        }
    }

    @Override // com.blued.android.module.common.web.jsbridge.WebViewJavascriptBridge
    public void send(String str) {
        send(str, null);
    }

    @Override // com.blued.android.module.common.web.jsbridge.WebViewJavascriptBridge
    public void send(String str, CallBackFunction callBackFunction) {
        doSend(null, str, callBackFunction);
    }

    public void setDefaultHandler(BridgeHandler bridgeHandler) {
        this.defaultHandler = bridgeHandler;
    }

    public void setStartupMessage(List<Message> list) {
        this.startupMessage = list;
    }
}
