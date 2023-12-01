package com.sobot.chat.widget.statusbar;

import android.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/StatusBarCompat.class */
public class StatusBarCompat {
    static final IStatusBar IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 23 && !isMeizu()) {
            IMPL = new StatusBarMImpl();
        } else if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new StatusBarKitkatImpl();
        } else {
            IMPL = new IStatusBar() { // from class: com.sobot.chat.widget.statusbar.StatusBarCompat.1
                @Override // com.sobot.chat.widget.statusbar.IStatusBar
                public void setStatusBarColor(Window window, int i) {
                }
            };
        }
    }

    private static void internalResetActionBarContainer(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void internalSetFitsSystemWindows(Window window, boolean z) {
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.FileInputStream] */
    private static boolean isEMUI() {
        FileInputStream fileInputStream;
        Exception e;
        File file = new File(Environment.getRootDirectory(), "build.prop");
        if (!file.exists()) {
            return false;
        }
        Properties properties = new Properties();
        FileInputStream e2 = null;
        try {
        } catch (IOException e3) {
            e2 = e3;
            e2.printStackTrace();
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    fileInputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    e2 = fileInputStream;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return properties.containsKey("ro.build.hw_emui_api_level");
                } catch (Throwable th) {
                    e2 = fileInputStream;
                    th = th;
                    if (e2 != null) {
                        try {
                            e2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                fileInputStream = null;
                e = e6;
            }
            return properties.containsKey("ro.build.hw_emui_api_level");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isMeizu() {
        return Build.DISPLAY.startsWith("Flyme");
    }

    public static void resetActionBarContainerTopMargin(Window window) {
        ViewGroup viewGroup = (ViewGroup) window.findViewById(R.id.content).getParent();
        if (viewGroup.getChildCount() > 1) {
            internalResetActionBarContainer(viewGroup.getChildAt(1));
        }
    }

    public static void resetActionBarContainerTopMargin(Window window, int i) {
        internalResetActionBarContainer(window.findViewById(i));
    }

    public static void setFitsSystemWindows(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            internalSetFitsSystemWindows(window, z);
        }
    }

    public static void setLightStatusBar(Window window, boolean z) {
        LightStatusBarCompat.setLightStatusBar(window, z);
    }

    public static void setNavigationBarColor(Activity activity, int i) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 21) {
            if (Build.VERSION.SDK_INT >= 19) {
                window.addFlags(134217728);
                return;
            }
            return;
        }
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(514);
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i);
    }

    public static void setStatusBarColor(Activity activity, int i) {
        setStatusBarColor(activity, i, toGrey(i) > 225);
    }

    public static void setStatusBarColor(Activity activity, int i, boolean z) {
        setStatusBarColor(activity.getWindow(), i, z);
    }

    public static void setStatusBarColor(Window window, int i, boolean z) {
        if ((window.getAttributes().flags & 1024) > 0 || StatusBarExclude.exclude) {
            return;
        }
        IMPL.setStatusBarColor(window, i);
        LightStatusBarCompat.setLightStatusBar(window, z);
    }

    public static void setStatusNavBarColor(Activity activity, int i, int i2) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 21) {
            if (Build.VERSION.SDK_INT >= 19) {
                window.addFlags(67108864);
                window.addFlags(134217728);
                return;
            }
            return;
        }
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(1792);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
        window.setNavigationBarColor(i2);
    }

    public static void setTranslucent(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (!z) {
                window.clearFlags(67108864);
                return;
            }
            window.addFlags(67108864);
            internalSetFitsSystemWindows(window, false);
        }
    }

    public static int toGrey(int i) {
        int blue = Color.blue(i);
        return (((Color.red(i) * 38) + (Color.green(i) * 75)) + (blue * 15)) >> 7;
    }
}
