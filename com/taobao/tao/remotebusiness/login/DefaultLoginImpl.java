package com.taobao.tao.remotebusiness.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.fastjson.JSON;
import com.taobao.tao.remotebusiness.listener.c;
import java.lang.reflect.Method;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKConfig;

/* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/login/DefaultLoginImpl.class */
public final class DefaultLoginImpl implements IRemoteLogin {
    private static final String MTOP_API_REFERENCE = "apiReferer";
    private static final String TAG = "mtop.rb-DefaultLoginImpl";
    private Method checkSessionValidMethod;
    private Method getNickMethod;
    private Method getSidMethod;
    private Method getUserIdMethod;
    private Method isLoginingMethod;
    private Class loginBroadcastHelperCls;
    private Class loginCls;
    private Method loginMethod;
    private Class loginStatusCls;
    private Method registerReceiverMethod;
    private static ThreadLocal threadLocal = new ThreadLocal();
    public static volatile DefaultLoginImpl instance = null;
    private LoginContext loginContext = new LoginContext();
    protected BroadcastReceiver receiver = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/taobao/tao/remotebusiness/login/DefaultLoginImpl$SessionInvalidEvent.class */
    public class SessionInvalidEvent {
        private static final String BUNDLE_KEY = "apiReferer";
        private static final String HEADER_KEY = "S";
        public String S_STATUS;
        public String apiName;
        public String eventName;
        public String long_nick;
        public String msgCode;
        public String v;

        public SessionInvalidEvent(MtopRequest mtopRequest) {
            this.apiName = mtopRequest.a();
            this.v = mtopRequest.b();
        }

        public SessionInvalidEvent(MtopResponse mtopResponse, String str) {
            this.eventName = "SESSION_INVALID";
            this.long_nick = str;
            this.apiName = mtopResponse.b();
            this.v = mtopResponse.c();
            this.msgCode = mtopResponse.a();
            this.S_STATUS = c.a(mtopResponse.e(), "S");
        }

        public String toJSONString() {
            return JSON.toJSONString(this);
        }
    }

    private DefaultLoginImpl() {
        this.loginCls = null;
        this.loginBroadcastHelperCls = null;
        this.loginStatusCls = null;
        try {
            this.loginCls = Class.forName("com.taobao.login4android.Login");
        } catch (ClassNotFoundException e) {
            this.loginCls = Class.forName("com.taobao.login4android.api.Login");
        }
        this.loginMethod = this.loginCls.getDeclaredMethod("login", Boolean.TYPE, Bundle.class);
        this.checkSessionValidMethod = this.loginCls.getDeclaredMethod("checkSessionValid", new Class[0]);
        this.getSidMethod = this.loginCls.getDeclaredMethod("getSid", new Class[0]);
        this.getUserIdMethod = this.loginCls.getDeclaredMethod("getUserId", new Class[0]);
        this.getNickMethod = this.loginCls.getDeclaredMethod("getNick", new Class[0]);
        Class<?> cls = Class.forName("com.taobao.login4android.constants.LoginStatus");
        this.loginStatusCls = cls;
        this.isLoginingMethod = cls.getDeclaredMethod("isLogining", new Class[0]);
        Class<?> cls2 = Class.forName("com.taobao.login4android.broadcast.LoginBroadcastHelper");
        this.loginBroadcastHelperCls = cls2;
        this.registerReceiverMethod = cls2.getMethod("registerLoginReceiver", Context.class, BroadcastReceiver.class);
        registerReceiver();
        TBSdkLog.b(TAG, "register login event receiver");
    }

    public static DefaultLoginImpl getDefaultLoginImpl() {
        if (instance == null) {
            synchronized (DefaultLoginImpl.class) {
                try {
                    if (instance == null) {
                        try {
                            instance = new DefaultLoginImpl();
                        } catch (Exception e) {
                            instance = null;
                            TBSdkLog.b(TAG, "DefaultLoginImpl instance error", e);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private Object invokeMethod(Method method, Object... objArr) {
        if (method != null) {
            try {
                return method.invoke(this.loginCls, objArr);
            } catch (Exception e) {
                TBSdkLog.b(TAG, "invokeMethod error", e);
                return null;
            }
        }
        return null;
    }

    private void registerReceiver() {
        if (this.receiver == null) {
            Object b = SDKConfig.a().b();
            if (b == null) {
                TBSdkLog.c(TAG, "Context is null, register receiver fail.");
                return;
            }
            synchronized (DefaultLoginImpl.class) {
                try {
                    if (this.receiver == null) {
                        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.taobao.tao.remotebusiness.login.DefaultLoginImpl.1
                            @Override // android.content.BroadcastReceiver
                            public void onReceive(Context context, Intent intent) {
                                if (intent == null) {
                                    return;
                                }
                                String action = intent.getAction();
                                if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                                    TBSdkLog.b(DefaultLoginImpl.TAG, "Login Broadcast Received. action=" + action);
                                }
                                if ("NOTIFY_LOGIN_SUCCESS".equals(action)) {
                                    LoginHandler.instance().onLoginSuccess();
                                } else if ("NOTIFY_LOGIN_FAILED".equals(action)) {
                                    LoginHandler.instance().onLoginFail();
                                } else if ("NOTIFY_LOGIN_CANCEL".equals(action)) {
                                    LoginHandler.instance().onLoginCancel();
                                }
                            }
                        };
                        this.receiver = broadcastReceiver;
                        invokeMethod(this.registerReceiverMethod, b, broadcastReceiver);
                    }
                } finally {
                }
            }
        }
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final LoginContext getLoginContext() {
        this.loginContext.sid = (String) invokeMethod(this.getSidMethod, new Object[0]);
        this.loginContext.userId = (String) invokeMethod(this.getUserIdMethod, new Object[0]);
        this.loginContext.nickname = (String) invokeMethod(this.getNickMethod, new Object[0]);
        return this.loginContext;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final boolean isLogining() {
        Boolean bool = (Boolean) invokeMethod(this.isLoginingMethod, new Object[0]);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final boolean isSessionValid() {
        Boolean bool = (Boolean) invokeMethod(this.checkSessionValidMethod, new Object[0]);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.taobao.tao.remotebusiness.login.IRemoteLogin
    public final void login(onLoginListener onloginlistener, boolean z) {
        TBSdkLog.b(TAG, "call login");
        SessionInvalidEvent sessionInvalidEvent = (SessionInvalidEvent) threadLocal.get();
        Bundle bundle = null;
        if (sessionInvalidEvent != null) {
            try {
                try {
                    bundle = new Bundle();
                    try {
                        String jSONString = sessionInvalidEvent.toJSONString();
                        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                            TBSdkLog.b(TAG, "apiRefer=" + jSONString);
                        }
                        bundle.putString(MTOP_API_REFERENCE, jSONString);
                        threadLocal.remove();
                    } catch (Exception e) {
                        registerReceiver();
                        invokeMethod(this.loginMethod, Boolean.valueOf(z), bundle);
                    }
                } catch (Exception e2) {
                    bundle = null;
                }
            } finally {
                threadLocal.remove();
            }
        }
        registerReceiver();
        invokeMethod(this.loginMethod, Boolean.valueOf(z), bundle);
    }

    public final void setSessionInvalid(Object obj) {
        if (obj instanceof MtopResponse) {
            threadLocal.set(new SessionInvalidEvent((MtopResponse) obj, (String) invokeMethod(this.getNickMethod, new Object[0])));
        } else if (obj instanceof MtopRequest) {
            threadLocal.set(new SessionInvalidEvent((MtopRequest) obj));
        }
    }
}
