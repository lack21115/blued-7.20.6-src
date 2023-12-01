package com.tencent.tinker.loader.shareutil;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/TinkerLogInlineFence.class */
final class TinkerLogInlineFence extends Handler {
    private static final String TAG = "Tinker.TinkerLogInlineFence";
    private static final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private static final List<Object[]> pendingLogs = new ArrayList();

    TinkerLogInlineFence() {
    }

    private static void dummyThrowExceptionMethod() {
        if (TinkerLogInlineFence.class.isPrimitive()) {
            throw new RuntimeException();
        }
    }

    private void handleMessageImpl(Message message) {
        ShareTinkerLog.TinkerLogImp defaultImpl = ShareTinkerLog.getDefaultImpl();
        ShareTinkerLog.TinkerLogImp impl = ShareTinkerLog.getImpl();
        int i = message.what;
        if (i == 2) {
            Object[] objArr = (Object[]) message.obj;
            if (impl != null) {
                impl.v((String) objArr[2], (String) objArr[3], (Object[]) objArr[4]);
            }
            if (impl == null || impl == defaultImpl) {
                synchronized (pendingLogs) {
                    pendingLogs.add(objArr);
                }
            }
        } else if (i == 3) {
            Object[] objArr2 = (Object[]) message.obj;
            if (impl != null) {
                impl.d((String) objArr2[2], (String) objArr2[3], (Object[]) objArr2[4]);
            }
            if (impl == null || impl == defaultImpl) {
                synchronized (pendingLogs) {
                    pendingLogs.add(objArr2);
                }
            }
        } else if (i == 4) {
            Object[] objArr3 = (Object[]) message.obj;
            if (impl != null) {
                impl.i((String) objArr3[2], (String) objArr3[3], (Object[]) objArr3[4]);
            }
            if (impl == null || impl == defaultImpl) {
                synchronized (pendingLogs) {
                    pendingLogs.add(objArr3);
                }
            }
        } else if (i == 5) {
            Object[] objArr4 = (Object[]) message.obj;
            if (impl != null) {
                impl.w((String) objArr4[2], (String) objArr4[3], (Object[]) objArr4[4]);
            }
            if (impl == null || impl == defaultImpl) {
                synchronized (pendingLogs) {
                    pendingLogs.add(objArr4);
                }
            }
        } else if (i == 6) {
            Object[] objArr5 = (Object[]) message.obj;
            if (impl != null) {
                impl.e((String) objArr5[2], (String) objArr5[3], (Object[]) objArr5[4]);
            }
            if (impl == null || impl == defaultImpl) {
                synchronized (pendingLogs) {
                    pendingLogs.add(objArr5);
                }
            }
        } else if (i != 4001) {
            if (i == 4002) {
                printPendingLogs(impl);
                return;
            }
            impl.e(TAG, "[-] Bad msg id: " + message.what, new Object[0]);
        } else {
            Object[] objArr6 = (Object[]) message.obj;
            if (impl != null) {
                impl.printErrStackTrace((String) objArr6[2], (Throwable) objArr6[3], (String) objArr6[4], (Object[]) objArr6[5]);
            }
            if (impl == null || impl == defaultImpl) {
                synchronized (pendingLogs) {
                    pendingLogs.add(objArr6);
                }
            }
        }
    }

    private void handleMessage_$noinline$(Message message) {
        try {
            dummyThrowExceptionMethod();
        } finally {
            handleMessageImpl(message);
        }
    }

    private static void printPendingLogs(final ShareTinkerLog.TinkerLogImp tinkerLogImp) {
        synchronized (pendingLogs) {
            if (tinkerLogImp != null) {
                if (!pendingLogs.isEmpty()) {
                    new Thread(new Runnable() { // from class: com.tencent.tinker.loader.shareutil.TinkerLogInlineFence.1
                        @Override // java.lang.Runnable
                        public void run() {
                            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
                            synchronized (TinkerLogInlineFence.pendingLogs) {
                                for (final Object[] objArr : TinkerLogInlineFence.pendingLogs) {
                                    TinkerLogInlineFence.mainThreadHandler.post(new Runnable() { // from class: com.tencent.tinker.loader.shareutil.TinkerLogInlineFence.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            String str = "[PendingLog @ " + simpleDateFormat.format(new Date(((Long) objArr[1]).longValue())) + "] ";
                                            int intValue = ((Integer) objArr[0]).intValue();
                                            if (intValue == 2) {
                                                ShareTinkerLog.TinkerLogImp.this.v((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                            } else if (intValue == 3) {
                                                ShareTinkerLog.TinkerLogImp.this.d((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                            } else if (intValue == 4) {
                                                ShareTinkerLog.TinkerLogImp.this.i((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                            } else if (intValue == 5) {
                                                ShareTinkerLog.TinkerLogImp.this.w((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                            } else if (intValue == 6) {
                                                ShareTinkerLog.TinkerLogImp.this.e((String) objArr[2], str + ((String) objArr[3]), (Object[]) objArr[4]);
                                            } else if (intValue != 4001) {
                                            } else {
                                                ShareTinkerLog.TinkerLogImp tinkerLogImp2 = ShareTinkerLog.TinkerLogImp.this;
                                                Object[] objArr2 = objArr;
                                                tinkerLogImp2.printErrStackTrace((String) objArr2[2], (Throwable) objArr2[3], str + ((String) objArr[4]), (Object[]) objArr[5]);
                                            }
                                        }
                                    });
                                }
                                TinkerLogInlineFence.pendingLogs.clear();
                            }
                        }
                    }, "tinker_log_printer").start();
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        handleMessage_$noinline$(message);
    }
}
