package com.blued.android.module.live_china.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.zego.zegoavkit2.mediarecorder.IZegoMediaRecordCallback;
import com.zego.zegoavkit2.mediarecorder.ZegoMediaRecordChannelIndex;
import com.zego.zegoavkit2.mediarecorder.ZegoMediaRecordFormat;
import com.zego.zegoavkit2.mediarecorder.ZegoMediaRecordType;
import com.zego.zegoavkit2.mediarecorder.ZegoMediaRecorder;
import java.io.File;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/service/LiveScreenRecorderService.class */
public class LiveScreenRecorderService extends Service {

    /* renamed from: a  reason: collision with root package name */
    String f14130a;
    private ZegoMediaRecorder b = null;

    /* renamed from: c  reason: collision with root package name */
    private NotificationManager f14131c = null;
    private Observer<Boolean> d = new Observer<Boolean>() { // from class: com.blued.android.module.live_china.service.LiveScreenRecorderService.2
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(Boolean bool) {
            Log.i("ScreenRecorderService", "KEY_EVENT_LIVE_SCREEN_RECORD_STOP");
            if (LiveScreenRecorderService.this.b != null) {
                LiveScreenRecorderService liveScreenRecorderService = LiveScreenRecorderService.this;
                liveScreenRecorderService.f14130a = LiveScreenRecorderService.this.getExternalCacheDir().getPath() + System.currentTimeMillis() + "_record.mp4";
                StringBuilder sb = new StringBuilder();
                sb.append("recordPath:");
                sb.append(LiveScreenRecorderService.this.f14130a);
                Log.i("ScreenRecorderService", sb.toString());
                LiveScreenRecorderService.this.b.startRecord(ZegoMediaRecordChannelIndex.AUX, ZegoMediaRecordType.BOTH, LiveScreenRecorderService.this.f14130a, true, 3000, ZegoMediaRecordFormat.MP4);
            }
        }
    };
    private Observer<Boolean> e = new Observer<Boolean>() { // from class: com.blued.android.module.live_china.service.LiveScreenRecorderService.3
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(Boolean bool) {
            Log.i("ScreenRecorderService", "KEY_EVENT_LIVE_SCREEN_RECORD_STOP");
            if (LiveScreenRecorderService.this.b != null) {
                if (LiveScreenRecorderService.this.b.stopRecord(ZegoMediaRecordChannelIndex.AUX)) {
                    Log.i("ScreenRecorderService", "stop record success");
                    if (bool.booleanValue()) {
                        LiveEventBus.get(LiveEventBusUtil.o).post(LiveScreenRecorderService.this.f14130a);
                    } else {
                        File file = new File(LiveScreenRecorderService.this.f14130a);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                } else {
                    Log.i("ScreenRecorderService", "stop record fail");
                }
                LiveScreenRecorderService.this.stopSelf();
            }
        }
    };

    private Notification a() {
        Notification.Builder contentTitle = new Notification.Builder(this).setSmallIcon(R.drawable.live_launcher_alpha).setTicker("正在录屏").setContentText("blued录屏").setContentTitle("正在运行");
        if (Build.VERSION.SDK_INT >= 26) {
            contentTitle.setChannelId("channedId");
        }
        return contentTitle.build();
    }

    private void a(int i, Intent intent) {
        MediaProjection mediaProjection = ((MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE)).getMediaProjection(i, intent);
        if (RecordingOnliveManager.f != null) {
            RecordingOnliveManager.f.setMediaProjection(mediaProjection);
        }
        ZegoCommonHelper.b().h();
        ZegoCommonHelper.b().c().startPreview(1);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ZegoMediaRecorder zegoMediaRecorder = new ZegoMediaRecorder();
        this.b = zegoMediaRecorder;
        zegoMediaRecorder.setZegoMediaRecordCallback(new IZegoMediaRecordCallback() { // from class: com.blued.android.module.live_china.service.LiveScreenRecorderService.1
            @Override // com.zego.zegoavkit2.mediarecorder.IZegoMediaRecordCallbackBase
            public void onMediaRecord(int i, ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, String str) {
                Log.i("ScreenRecorderService", "errCode:" + i);
            }

            @Override // com.zego.zegoavkit2.mediarecorder.IZegoMediaRecordCallback
            public void onRecordStatusUpdate(ZegoMediaRecordChannelIndex zegoMediaRecordChannelIndex, String str, long j, long j2) {
            }
        });
        LiveEventBus.get(LiveEventBusUtil.m, Boolean.class).observeForever(this.d);
        LiveEventBus.get(LiveEventBusUtil.n, Boolean.class).observeForever(this.e);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i("ScreenRecorderService", "onDestroy");
        super.onDestroy();
        LiveEventBus.get(LiveEventBusUtil.m, Boolean.class).removeObserver(this.d);
        LiveEventBus.get(LiveEventBusUtil.n, Boolean.class).removeObserver(this.e);
        this.b.setZegoMediaRecordCallback((IZegoMediaRecordCallback) null);
        this.b = null;
        NotificationManager notificationManager = this.f14131c;
        if (notificationManager != null) {
            notificationManager.cancel(1);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i("ScreenRecorderService", "onStartCommand");
        if (Build.VERSION.SDK_INT >= 26) {
            Log.i("ScreenRecorderService", "send notify");
            this.f14131c = (NotificationManager) getSystemService("notification");
            this.f14131c.createNotificationChannel(new NotificationChannel("channedId", "channedId", 4));
            startForeground(1, a());
        } else {
            startForeground(1, a());
        }
        if (intent != null) {
            int intExtra = intent.getIntExtra(ProcessBridgeProvider.KEY_RESULT_CODE, -1);
            Intent intent2 = (Intent) intent.getParcelableExtra("data");
            Log.i("ScreenRecorderService", "resultCode:" + intExtra);
            a(intExtra, intent2);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
