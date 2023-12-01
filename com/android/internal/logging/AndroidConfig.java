package com.android.internal.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/logging/AndroidConfig.class */
public class AndroidConfig {
    public AndroidConfig() {
        try {
            Logger logger = Logger.getLogger("");
            logger.addHandler(new AndroidHandler());
            logger.setLevel(Level.INFO);
            Logger.getLogger("org.apache").setLevel(Level.WARNING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
