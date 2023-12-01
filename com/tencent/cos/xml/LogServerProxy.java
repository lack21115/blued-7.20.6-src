package com.tencent.cos.xml;

import android.content.Context;
import com.tencent.qcloud.core.logger.FileLogAdapter;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/LogServerProxy.class */
public class LogServerProxy {
    private static final String TAG = "LogServerProxy";
    private static LogServerProxy instance;
    private Context applicationContext;
    private Method destroyResourceMethod;
    private FileLogAdapter fileLogAdapter;
    private Object logServer;
    private Method setOnLogListenerMethod;
    private final String className = "com.tencent.qcloud.logutils.LogServer";
    private final String interfaceName = "com.tencent.qcloud.logutils.OnLogListener";
    private final String interfaceMethodName = "onLoad";

    private LogServerProxy(Context context, final FileLogAdapter fileLogAdapter) {
        this.applicationContext = context;
        this.fileLogAdapter = fileLogAdapter;
        try {
            Class<?> cls = Class.forName("com.tencent.qcloud.logutils.LogServer");
            Constructor<?> constructor = cls.getConstructor(Context.class);
            if (constructor != null) {
                this.logServer = constructor.newInstance(this.applicationContext);
            }
            Method declaredMethod = cls.getDeclaredMethod("destroy", new Class[0]);
            this.destroyResourceMethod = declaredMethod;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
            Class<?> cls2 = Class.forName("com.tencent.qcloud.logutils.OnLogListener");
            Object newProxyInstance = Proxy.newProxyInstance(LogServerProxy.class.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.tencent.cos.xml.LogServerProxy.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if ("onLoad".equals(method.getName())) {
                        return fileLogAdapter.getLogFilesDesc(30);
                    }
                    return null;
                }
            });
            Method declaredMethod2 = cls.getDeclaredMethod("setOnLogListener", cls2);
            this.setOnLogListenerMethod = declaredMethod2;
            if (declaredMethod2 != null) {
                declaredMethod2.setAccessible(true);
                this.setOnLogListenerMethod.invoke(this.logServer, newProxyInstance);
            }
        } catch (ClassNotFoundException e) {
            QCloudLogger.d(TAG, "com.tencent.qcloud.logutils.LogServer : not found", new Object[0]);
        } catch (IllegalAccessException e2) {
            QCloudLogger.d(TAG, e2.getMessage() + " : not found", new Object[0]);
        } catch (InstantiationException e3) {
            QCloudLogger.d(TAG, e3.getMessage() + " : not found", new Object[0]);
        } catch (NoSuchMethodException e4) {
            QCloudLogger.d(TAG, e4.getMessage() + " : not found", new Object[0]);
        } catch (InvocationTargetException e5) {
            QCloudLogger.d(TAG, e5.getMessage() + " : not found", new Object[0]);
        }
    }

    public static LogServerProxy getInstance() {
        return instance;
    }

    public static void init(Context context, FileLogAdapter fileLogAdapter) {
        synchronized (LogServerProxy.class) {
            try {
                if (instance == null) {
                    instance = new LogServerProxy(context, fileLogAdapter);
                }
            } finally {
            }
        }
    }

    public void destroy() {
        Method method;
        Object obj = this.logServer;
        if (obj == null || (method = this.destroyResourceMethod) == null) {
            return;
        }
        try {
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            QCloudLogger.d(TAG, e.getMessage(), new Object[0]);
        } catch (InvocationTargetException e2) {
            QCloudLogger.d(TAG, e2.getMessage(), new Object[0]);
        }
    }

    public FileLogAdapter getFileLogAdapter() {
        return this.fileLogAdapter;
    }
}
