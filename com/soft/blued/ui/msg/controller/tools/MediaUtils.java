package com.soft.blued.ui.msg.controller.tools;

import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.provider.Settings;
import com.blued.android.core.AppInfo;
import com.soft.blued.R;
import java.lang.ref.SoftReference;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/MediaUtils.class */
public class MediaUtils implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private static MediaUtils f18571a;
    private SoundPool d;
    private final Handler e = new MyHandler(this);
    private Vibrator b = (Vibrator) AppInfo.d().getSystemService(Context.VIBRATOR_SERVICE);

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f18572c = new MediaPlayer();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/controller/tools/MediaUtils$MyHandler.class */
    static class MyHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private SoftReference<MediaUtils> f18574a;

        public MyHandler(MediaUtils mediaUtils) {
            this.f18574a = new SoftReference<>(mediaUtils);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaUtils mediaUtils;
            if (message.what != 10 || (mediaUtils = this.f18574a.get()) == null || mediaUtils.d == null) {
                return;
            }
            mediaUtils.d.play(message.arg1, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    public MediaUtils() {
        SoundPool soundPool = new SoundPool(1, 3, 0);
        this.d = soundPool;
        soundPool.setOnLoadCompleteListener(this);
    }

    public static MediaUtils a() {
        if (f18571a == null) {
            f18571a = new MediaUtils();
        }
        return f18571a;
    }

    public static String a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
                return null;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private int c() {
        if (((AudioManager) AppInfo.d().getSystemService("audio")).getRingerMode() == 2) {
            return 2;
        }
        if (((AudioManager) AppInfo.d().getSystemService("audio")).getRingerMode() == 0) {
            return 0;
        }
        return ((AudioManager) AppInfo.d().getSystemService("audio")).getRingerMode() == 1 ? 1 : 2;
    }

    public String a(String str) {
        Uri parse = Uri.parse(str);
        if ("content".equalsIgnoreCase(parse.getScheme())) {
            str = a(AppInfo.d(), parse, null, null);
        }
        String str2 = str;
        if (!str.toLowerCase().startsWith("file://")) {
            str2 = "file://" + str;
        }
        return str2;
    }

    public void a(int i) {
        SoundPool soundPool;
        if (c() == 0 || c() == 1 || (soundPool = this.d) == null) {
            return;
        }
        if (i == 1) {
            soundPool.load(AppInfo.d(), R.raw.ringtone_get, 1);
        } else if (i != 2) {
        } else {
            soundPool.load(AppInfo.d(), R.raw.msg_voice_play_done, 1);
        }
    }

    public void a(long j) {
        this.b.vibrate(j);
    }

    public void b() {
        try {
            this.f18572c.reset();
            this.f18572c.setLooping(false);
            this.f18572c.setDataSource(a(Settings.System.getString(AppInfo.d().getContentResolver(), Settings.System.NOTIFICATION_SOUND)));
            this.f18572c.setAudioStreamType(2);
            this.f18572c.prepare();
            this.f18572c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.soft.blued.ui.msg.controller.tools.MediaUtils.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    MediaUtils.this.f18572c.start();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        Message obtainMessage = this.e.obtainMessage(10);
        obtainMessage.arg1 = i;
        this.e.sendMessage(obtainMessage);
    }
}
