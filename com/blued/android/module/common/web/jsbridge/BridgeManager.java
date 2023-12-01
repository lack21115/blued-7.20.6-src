package com.blued.android.module.common.web.jsbridge;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.web.LoaderConstants;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/jsbridge/BridgeManager.class */
public class BridgeManager implements WebViewJavascriptBridge {
    public static final String toLoadJs = "WebViewJavascriptBridge.js";
    private BluedWebView bluedWebView;
    Map<String, CallBackFunction> responseCallbacks = new HashMap();
    Map<String, BridgeHandler> messageHandlers = new HashMap();
    BridgeHandler defaultHandler = new DefaultHandler();
    private List<Message> startupMessage = new ArrayList();
    private long uniqueId = 0;
    private boolean isFirstLoadFinished = false;

    public BridgeManager() {
    }

    public BridgeManager(BluedWebView bluedWebView) {
        this.bluedWebView = bluedWebView;
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

    void dispatchMessage(Message message) {
        BluedWebView bluedWebView;
        String format = String.format(BridgeUtil.JS_HANDLE_MESSAGE_FROM_JAVA, message.toJson().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\""));
        if (Thread.currentThread() != Looper.getMainLooper().getThread() || (bluedWebView = this.bluedWebView) == null) {
            return;
        }
        bluedWebView.a(format);
    }

    void flushMessageQueue() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(BridgeUtil.JS_FETCH_QUEUE_FROM_JAVA, new CallBackFunction() { // from class: com.blued.android.module.common.web.jsbridge.BridgeManager.2
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
                                CallBackFunction callBackFunction = !TextUtils.isEmpty(callbackId) ? new CallBackFunction() { // from class: com.blued.android.module.common.web.jsbridge.BridgeManager.2.1
                                    @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                                    public void onCallBack(String str2) {
                                        Message message2 = new Message();
                                        message2.setResponseId(callbackId);
                                        message2.setResponseData(str2);
                                        BridgeManager.this.queueMessage(message2);
                                    }
                                } : new CallBackFunction() { // from class: com.blued.android.module.common.web.jsbridge.BridgeManager.2.2
                                    @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                                    public void onCallBack(String str2) {
                                    }
                                };
                                BridgeHandler bridgeHandler = !TextUtils.isEmpty(message.getHandlerName()) ? BridgeManager.this.messageHandlers.get(message.getHandlerName()) : BridgeManager.this.defaultHandler;
                                if (bridgeHandler != null) {
                                    bridgeHandler.handler(message.getData(), callBackFunction);
                                }
                            } else {
                                CallBackFunction callBackFunction2 = BridgeManager.this.responseCallbacks.get(responseId);
                                String responseData = message.getResponseData();
                                Log.v("drb", "flushMessageQueue responseData:" + responseData);
                                callBackFunction2.onCallBack(responseData);
                                BridgeManager.this.responseCallbacks.remove(responseId);
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

    public List<Message> getStartupMessage() {
        return this.startupMessage;
    }

    void handlerReturnData(String str) {
        String functionFromReturnUrl = BridgeUtil.getFunctionFromReturnUrl(str);
        CallBackFunction callBackFunction = this.responseCallbacks.get(functionFromReturnUrl);
        String dataFromReturnUrl = BridgeUtil.getDataFromReturnUrl(str);
        Log.v("drb", "handlerReturnData f:" + callBackFunction + " -- data:" + dataFromReturnUrl);
        if (callBackFunction != null) {
            callBackFunction.onCallBack(dataFromReturnUrl);
            this.responseCallbacks.remove(functionFromReturnUrl);
        }
    }

    public boolean hasJSUrl(String str) {
        List<String> data = BridgeWhiteListManager.getInstance().getData();
        if (data != null) {
            for (String str2 : data) {
                if (str.contains(str2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void loadUrl(String str, CallBackFunction callBackFunction) {
        this.bluedWebView.a(str);
        this.responseCallbacks.put(BridgeUtil.parseFunctionName(str), callBackFunction);
    }

    public void onLoadPageFinished(BluedWebView bluedWebView, String str) {
        Log.v("drb", "onLoadPageFinished");
        BridgeUtil.webViewLoadLocalJs(bluedWebView.c(), "WebViewJavascriptBridge.js");
        if (getStartupMessage() != null) {
            for (Message message : getStartupMessage()) {
                dispatchMessage(message);
            }
            setStartupMessage(null);
            if (this.isFirstLoadFinished) {
                return;
            }
            if (hasJSUrl(str)) {
                sendToJsForInit();
            }
            this.isFirstLoadFinished = true;
        }
    }

    public void onLoadPageOverrideLoad(BluedWebView bluedWebView, String str, boolean z) {
        Log.v("drb", "onLoadPageOverrideLoad:" + str);
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str.startsWith(BridgeUtil.YY_RETURN_DATA)) {
            handlerReturnData(str);
        } else if (str.startsWith(BridgeUtil.YY_OVERRIDE_SCHEMA)) {
            flushMessageQueue();
        }
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

    public void sendToJsForInit() {
        Log.v("drb", "sendToJsForInit");
        callHandler(LoaderConstants.NATIVE_TO_JS, AppInfo.f().toJson(new CallJsModel(LoaderConstants.ON_INIT)), new CallBackFunction() { // from class: com.blued.android.module.common.web.jsbridge.BridgeManager.1
            @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
            public void onCallBack(String str) {
                Log.v("drb", "NATIVE_TO_JS onCallBack:" + str);
            }
        });
    }

    public void setBluedWebView(BluedWebView bluedWebView) {
        this.bluedWebView = bluedWebView;
    }

    public void setDefaultHandler(BridgeHandler bridgeHandler) {
        this.defaultHandler = bridgeHandler;
    }

    public void setStartupMessage(List<Message> list) {
        this.startupMessage = list;
    }
}
