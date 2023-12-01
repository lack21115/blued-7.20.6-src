package com.omes.scorpion;

import android.util.Log;
import com.heytap.nearx.cloudconfig.stat.TrackApi_20246;
import com.heytap.nearx.track.NearxTrackHelper;
import com.heytap.nearx.track.TrackContext;

/* loaded from: source-8303388-dex2jar.jar:com/omes/scorpion/OmasStub.class */
public class OmasStub {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f10593a = false;

    static {
        System.loadLibrary("scorpion");
        a();
    }

    public static void a() {
        new Thread(new Runnable() { // from class: com.omes.scorpion.OmasStub.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(5000L);
                    OmasStub.b();
                    boolean z = OmasStub.f10593a;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void b() {
        try {
            Class.forName("com.heytap.nearx.track.NearxTrackHelper");
            if (!NearxTrackHelper.hasInit) {
                Log.d("SCORPION", "NearxTrackHelper has not init");
                return;
            }
            TrackApi_20246.NearxTrack obtain = TrackApi_20246.NearxTrack.obtain("8888", "1234");
            obtain.add("scorpion", "1");
            obtain.commit(TrackContext.get(103900L));
            f10593a = true;
        } catch (ClassNotFoundException e) {
            f10593a = true;
            Log.d("SCORPION", "NearxTrackHelper not found");
        }
    }

    public static native boolean omasBoolean(int i, Object[] objArr);

    public static native byte omasByte(int i, Object[] objArr);

    public static native char omasChar(int i, Object[] objArr);

    public static native double omasDouble(int i, Object[] objArr);

    public static native float omasFloat(int i, Object[] objArr);

    public static native int omasInt(int i, Object[] objArr);

    public static native long omasLong(int i, Object[] objArr);

    public static native Object omasObject(int i, Object[] objArr);

    public static native short omasShort(int i, Object[] objArr);

    public static native void omasVoid(int i, Object[] objArr);
}
