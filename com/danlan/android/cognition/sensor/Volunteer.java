package com.danlan.android.cognition.sensor;

import com.danlan.android.cognition.StringFog;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/sensor/Volunteer.class */
public class Volunteer {
    private static String TAG = StringFog.decrypt("d0xIVk9XQURT");
    private static Volunteer instance = null;
    private final ArrayList<CognitionDataOpt> volunteers = new ArrayList<>(Arrays.asList(CognitionDataOpt.SENSOR_ACCELEROMETER));

    public static Volunteer getInstance() {
        if (instance == null) {
            instance = new Volunteer();
        }
        return instance;
    }

    public void add(CognitionDataOpt cognitionDataOpt) {
        if (this.volunteers.contains(cognitionDataOpt)) {
            return;
        }
        this.volunteers.add(cognitionDataOpt);
    }

    public boolean ready(CognitionDataOpt cognitionDataOpt) {
        if (cognitionDataOpt != null) {
            return this.volunteers.contains(cognitionDataOpt);
        }
        return false;
    }

    public void remove(CognitionDataOpt cognitionDataOpt) {
        int indexOf = this.volunteers.indexOf(cognitionDataOpt);
        if (indexOf >= 0) {
            this.volunteers.remove(indexOf);
        }
    }
}
