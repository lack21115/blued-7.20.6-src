package com.sobot.chat.widget.statusbar;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/LightStatusBarCompat.class */
class LightStatusBarCompat {
    private static final ILightStatusBar IMPL;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/LightStatusBarCompat$ILightStatusBar.class */
    interface ILightStatusBar {
        void setLightStatusBar(Window window, boolean z);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/LightStatusBarCompat$MIUILightStatusBarImpl.class */
    static class MIUILightStatusBarImpl implements ILightStatusBar {
        private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";
        private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
        private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

        private MIUILightStatusBarImpl() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
            if (r0.getProperty(com.sobot.chat.widget.statusbar.LightStatusBarCompat.MIUILightStatusBarImpl.KEY_MIUI_INTERNAL_STORAGE) != null) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        static boolean isMe() {
            /*
                r0 = 0
                r7 = r0
                r0 = 0
                r10 = r0
                r0 = 0
                r9 = r0
                java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L6c
                r1 = r0
                java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L6c
                r3 = r2
                java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L6c
                java.lang.String r5 = "build.prop"
                r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L6c
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L6c
                r8 = r0
                java.util.Properties r0 = new java.util.Properties     // Catch: java.lang.Throwable -> L4c java.lang.Throwable -> L57 java.io.IOException -> L6c java.io.IOException -> L72
                r1 = r0
                r1.<init>()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L72
                r9 = r0
                r0 = r9
                r1 = r8
                r0.load(r1)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L72
                r0 = r9
                java.lang.String r1 = "ro.miui.ui.version.code"
                java.lang.String r0 = r0.getProperty(r1)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L72
                if (r0 != 0) goto L44
                r0 = r9
                java.lang.String r1 = "ro.miui.ui.version.name"
                java.lang.String r0 = r0.getProperty(r1)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L72
                if (r0 != 0) goto L44
                r0 = r9
                java.lang.String r1 = "ro.miui.internal.storage"
                java.lang.String r0 = r0.getProperty(r1)     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L72
                r9 = r0
                r0 = r9
                if (r0 == 0) goto L46
            L44:
                r0 = 1
                r7 = r0
            L46:
                r0 = r8
                r0.close()     // Catch: java.io.IOException -> L76
                r0 = r7
                return r0
            L4c:
                r10 = move-exception
                r0 = r8
                r9 = r0
                r0 = r10
                r8 = r0
                goto L58
            L54:
                goto L62
            L57:
                r8 = move-exception
            L58:
                r0 = r9
                if (r0 == 0) goto L60
                r0 = r9
                r0.close()     // Catch: java.io.IOException -> L79
            L60:
                r0 = r8
                throw r0
            L62:
                r0 = r8
                if (r0 == 0) goto L6a
                r0 = r8
                r0.close()     // Catch: java.io.IOException -> L7d
            L6a:
                r0 = 0
                return r0
            L6c:
                r8 = move-exception
                r0 = r10
                r8 = r0
                goto L62
            L72:
                r9 = move-exception
                goto L54
            L76:
                r8 = move-exception
                r0 = r7
                return r0
            L79:
                r9 = move-exception
                goto L60
            L7d:
                r8 = move-exception
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.statusbar.LightStatusBarCompat.MIUILightStatusBarImpl.isMe():boolean");
        }

        @Override // com.sobot.chat.widget.statusbar.LightStatusBarCompat.ILightStatusBar
        public void setLightStatusBar(Window window, boolean z) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(z ? i : 0), Integer.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/LightStatusBarCompat$MLightStatusBarImpl.class */
    static class MLightStatusBarImpl implements ILightStatusBar {
        private MLightStatusBarImpl() {
        }

        @Override // com.sobot.chat.widget.statusbar.LightStatusBarCompat.ILightStatusBar
        public void setLightStatusBar(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/LightStatusBarCompat$MeizuLightStatusBarImpl.class */
    static class MeizuLightStatusBarImpl implements ILightStatusBar {
        private MeizuLightStatusBarImpl() {
        }

        static boolean isMe() {
            return Build.DISPLAY.startsWith("Flyme");
        }

        @Override // com.sobot.chat.widget.statusbar.LightStatusBarCompat.ILightStatusBar
        public void setLightStatusBar(Window window, boolean z) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : i & i2);
                window.setAttributes(attributes);
                declaredField.setAccessible(false);
                declaredField2.setAccessible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        if (MIUILightStatusBarImpl.isMe()) {
            if (Build.VERSION.SDK_INT >= 23) {
                IMPL = new MLightStatusBarImpl() { // from class: com.sobot.chat.widget.statusbar.LightStatusBarCompat.1
                    private final ILightStatusBar DELEGATE = new MIUILightStatusBarImpl();

                    @Override // com.sobot.chat.widget.statusbar.LightStatusBarCompat.MLightStatusBarImpl, com.sobot.chat.widget.statusbar.LightStatusBarCompat.ILightStatusBar
                    public void setLightStatusBar(Window window, boolean z) {
                        super.setLightStatusBar(window, z);
                        this.DELEGATE.setLightStatusBar(window, z);
                    }
                };
            } else {
                IMPL = new MIUILightStatusBarImpl();
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new MLightStatusBarImpl();
        } else if (MeizuLightStatusBarImpl.isMe()) {
            IMPL = new MeizuLightStatusBarImpl();
        } else {
            IMPL = new ILightStatusBar() { // from class: com.sobot.chat.widget.statusbar.LightStatusBarCompat.2
                @Override // com.sobot.chat.widget.statusbar.LightStatusBarCompat.ILightStatusBar
                public void setLightStatusBar(Window window, boolean z) {
                }
            };
        }
    }

    LightStatusBarCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLightStatusBar(Window window, boolean z) {
        IMPL.setLightStatusBar(window, z);
    }
}
