package com.opos.mobad.cmn.service.pkginstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/pkginstall/SystemBR.class */
public class SystemBR extends BroadcastReceiver {
    private static final long SEND_PACKAGE_ADDED_OR_REMOVED_MSG_DELAY_TIME = 500;
    private static final Handler SYSTEM_BR_HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.cmn.service.pkginstall.SystemBR.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    if (message.what == 0 || 1 == message.what || 2 == message.what) {
                        c.a().a(message.what, (String) message.obj);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a(SystemBR.TAG, "", (Throwable) e);
                }
            }
        }
    };
    private static final String TAG = "SystemBR";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        Handler handler;
        if (intent != null) {
            try {
                com.opos.cmn.an.f.a.b(TAG, "onReceive intent=" + intent);
                String action = intent.getAction();
                com.opos.cmn.an.f.a.b(TAG, "action=" + action);
                if (Intent.ACTION_PACKAGE_ADDED.equals(action) || Intent.ACTION_PACKAGE_REPLACED.equals(action) || Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
                    Message obtainMessage = SYSTEM_BR_HANDLER.obtainMessage();
                    String substring = intent.getDataString().substring(8);
                    obtainMessage.obj = substring;
                    int hashCode = action.hashCode();
                    if (hashCode == -810471698) {
                        if (action.equals(Intent.ACTION_PACKAGE_REPLACED)) {
                            z = true;
                        }
                        z = true;
                    } else if (hashCode != 525384130) {
                        if (hashCode == 1544582882 && action.equals(Intent.ACTION_PACKAGE_ADDED)) {
                            z = false;
                        }
                        z = true;
                    } else {
                        if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
                            z = true;
                        }
                        z = true;
                    }
                    if (!z) {
                        com.opos.cmn.an.f.a.b(TAG, "ACTION_PACKAGE_ADDED pkgName=" + substring);
                        obtainMessage.what = 0;
                        handler = SYSTEM_BR_HANDLER;
                    } else if (z) {
                        com.opos.cmn.an.f.a.b(TAG, "ACTION_PACKAGE_REPLACED pkgName=" + substring);
                        obtainMessage.what = 1;
                        if (SYSTEM_BR_HANDLER.hasMessages(0)) {
                            SYSTEM_BR_HANDLER.removeMessages(0);
                        }
                        if (SYSTEM_BR_HANDLER.hasMessages(2)) {
                            SYSTEM_BR_HANDLER.removeMessages(2);
                        }
                        SYSTEM_BR_HANDLER.sendMessage(obtainMessage);
                        return;
                    } else if (!z) {
                        return;
                    } else {
                        com.opos.cmn.an.f.a.b(TAG, "ACTION_PACKAGE_REMOVED pkgName=" + substring);
                        obtainMessage.what = 2;
                        handler = SYSTEM_BR_HANDLER;
                    }
                    handler.sendMessageDelayed(obtainMessage, 500L);
                }
            } catch (Exception e) {
                try {
                    com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e2);
                }
            }
        }
    }
}
