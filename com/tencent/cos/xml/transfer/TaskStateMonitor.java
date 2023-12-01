package com.tencent.cos.xml.transfer;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tencent.cos.xml.BeaconService;
import com.tencent.cos.xml.model.CosXmlResult;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/TaskStateMonitor.class */
public final class TaskStateMonitor implements Runnable {
    public static final int MESSAGE_RELEASE_LOOP = 3;
    public static final int MESSAGE_TASK_CONSTRAINT = 5;
    public static final int MESSAGE_TASK_INIT = 4;
    public static final int MESSAGE_TASK_MANUAL = 2;
    public static final int MESSAGE_TASK_RESULT = 1;
    private static final String TAG = "TaskStateMonitor";
    private static TaskStateMonitor monitor;
    private static Handler taskHandler;
    private Looper looper;
    private volatile boolean isRunning = false;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/TaskStateMonitor$StructMsg.class */
    class StructMsg {
        COSXMLTask cosxmlTask;
        Exception exception;
        CosXmlResult result;
        volatile TransferState transferState;

        private StructMsg() {
        }
    }

    private TaskStateMonitor() {
    }

    public static TaskStateMonitor getInstance() {
        synchronized (TaskStateMonitor.class) {
            try {
                if (monitor == null) {
                    monitor = new TaskStateMonitor();
                }
                monitor.monitor();
            } catch (Throwable th) {
                throw th;
            }
        }
        return monitor;
    }

    private void monitor() {
        if (this.isRunning) {
            return;
        }
        this.executorService.submit(this);
        this.isRunning = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseLooper() {
        quitSafely();
    }

    private void setMessageQueue() throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, InstantiationException {
        Field declaredField = Looper.class.getDeclaredField("mQueue");
        declaredField.setAccessible(true);
        Constructor<?>[] declaredConstructors = Class.forName("android.os.MessageQueue").getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Constructor<?> constructor = declaredConstructors[i2];
            constructor.setAccessible(true);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    break;
                } else if (parameterTypes[i4].getName().equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
                    declaredField.set(this.looper, constructor.newInstance(true));
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public Looper getLooper() {
        if (Thread.currentThread().isAlive()) {
            synchronized (this) {
                while (Thread.currentThread().isAlive() && this.looper == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            return this.looper;
        }
        return null;
    }

    public void quitSafely() {
        taskHandler.removeCallbacksAndMessages(null);
        Looper looper = getLooper();
        if (looper != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                looper.quitSafely();
            } else {
                looper.quit();
            }
        }
        this.isRunning = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this) {
            Looper myLooper = Looper.myLooper();
            this.looper = myLooper;
            if (myLooper != null) {
                notifyAll();
            }
        }
        if (this.looper == null) {
            Looper.prepare();
            synchronized (this) {
                this.looper = Looper.myLooper();
                notifyAll();
            }
        }
        try {
            setMessageQueue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            BeaconService.getInstance().reportError(TAG, e);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            BeaconService.getInstance().reportError(TAG, e2);
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            BeaconService.getInstance().reportError(TAG, e3);
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            BeaconService.getInstance().reportError(TAG, e4);
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            BeaconService.getInstance().reportError(TAG, e5);
        }
        taskHandler = new Handler(getLooper()) { // from class: com.tencent.cos.xml.transfer.TaskStateMonitor.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    StructMsg structMsg = (StructMsg) message.obj;
                    TaskStateMonitor.this.stateTransform(structMsg.cosxmlTask, structMsg.transferState, structMsg.exception, structMsg.result, false);
                } else if (i == 2) {
                    StructMsg structMsg2 = (StructMsg) message.obj;
                    TaskStateMonitor.this.stateTransform(structMsg2.cosxmlTask, structMsg2.transferState, structMsg2.exception, null, false);
                } else if (i == 3) {
                    TaskStateMonitor.this.releaseLooper();
                } else if (i == 4) {
                    StructMsg structMsg3 = (StructMsg) message.obj;
                    TaskStateMonitor.this.stateTransform(structMsg3.cosxmlTask, structMsg3.transferState, structMsg3.exception, structMsg3.result, true);
                } else if (i != 5) {
                } else {
                    StructMsg structMsg4 = (StructMsg) message.obj;
                    TaskStateMonitor.this.stateTransform(structMsg4.cosxmlTask, structMsg4.transferState, structMsg4.exception, structMsg4.result, false);
                }
            }
        };
        Looper.loop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendStateMessage(COSXMLTask cOSXMLTask, TransferState transferState, Exception exc, CosXmlResult cosXmlResult, int i) {
        Handler handler = taskHandler;
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i;
        StructMsg structMsg = new StructMsg();
        structMsg.cosxmlTask = cOSXMLTask;
        structMsg.transferState = transferState;
        structMsg.exception = exc;
        structMsg.result = cosXmlResult;
        obtainMessage.obj = structMsg;
        taskHandler.sendMessage(obtainMessage);
    }

    protected void stateTransform(COSXMLTask cOSXMLTask, TransferState transferState, Exception exc, CosXmlResult cosXmlResult, boolean z) {
        cOSXMLTask.updateState(transferState, exc, cosXmlResult, z);
    }
}
