package com.blued.android.module.yy_china.trtc_audio.manager;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.music.model.TrtcAudioFrameModel;
import com.blued.android.module.live.base.music.model.TrtcMusicModel;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.model.trtc.TRTCSEIMsg;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManagerForTencent.class */
public class AudioChannelManagerForTencent implements IAudioContract.IAudioControl {
    private TRTCCloud a;
    private TRTCCloud b;
    private IAudioContract.IAudioCallback c;
    private HashMap<Integer, TrtcMusicModel> d;
    private TXAudioEffectManager.AudioMusicParam e;
    private int f = 50;
    private int g = 50;
    private int h = 100;
    private int i = 40;

    private TXAudioEffectManager.TXVoiceReverbType h(int i) {
        TXAudioEffectManager.TXVoiceReverbType tXVoiceReverbType = TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
        switch (i) {
            case 0:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0;
            case 1:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1;
            case 2:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2;
            case 3:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3;
            case 4:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4;
            case 5:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5;
            case 6:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6;
            case 7:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7;
            case 8:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_8;
            case 9:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_9;
            case 10:
                return TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_10;
            default:
                return tXVoiceReverbType;
        }
    }

    private void k() {
        this.a.setAudioFrameListener(new TRTCCloudListener.TRTCAudioFrameListener() { // from class: com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManagerForTencent.1
            public void onCapturedRawAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
                if (AudioChannelManagerForTencent.this.c != null) {
                    TrtcAudioFrameModel trtcAudioFrameModel = new TrtcAudioFrameModel();
                    trtcAudioFrameModel.c = tRTCAudioFrame.channel;
                    trtcAudioFrameModel.a = tRTCAudioFrame.data;
                    trtcAudioFrameModel.e = tRTCAudioFrame.extraData;
                    trtcAudioFrameModel.b = tRTCAudioFrame.sampleRate;
                    trtcAudioFrameModel.d = AudioChannelManagerForTencent.this.a.getAudioEffectManager().getMusicCurrentPosInMS(4443);
                    AudioChannelManagerForTencent.this.c.a(trtcAudioFrameModel);
                }
            }

            public void onLocalProcessedAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            }

            public void onMixedAllAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            }

            public void onMixedPlayAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            }

            public void onRemoteUserAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame, String str) {
            }
        });
    }

    private TRTCCloudListener l() {
        return new TRTCCloudListener() { // from class: com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManagerForTencent.3
            public void onConnectOtherRoom(String str, int i, String str2) {
                super.onConnectOtherRoom(str, i, str2);
                LiveLogUtils.a("AudioChannelManagerForTencent --> TRTCCloudListener --> onConnectOtherRoom：（s：" + str + ", i：" + i + ", s1：" + str2 + ")");
                StringBuilder sb = new StringBuilder();
                sb.append("onConnectOtherRoom: ");
                sb.append(str);
                sb.append("    ");
                sb.append(i);
                sb.append("     ");
                sb.append(str2);
                Log.e("ulog", sb.toString());
            }

            public void onConnectionLost() {
                LiveLogUtils.a("AudioChannelManagerForTencent --> TRTCCloudListener --> onConnectionLost...");
                Logger.d("ulog", " -- onConnectionLost ");
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a();
                }
            }

            public void onConnectionRecovery() {
                super.onConnectionRecovery();
                LiveLogUtils.a("AudioChannelManagerForTencent --> TRTCCloudListener --> onConnectionRecovery...");
                Logger.d("ulog", " -- onConnectionRecovery ");
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.b();
                }
            }

            public void onDisConnectOtherRoom(int i, String str) {
                super.onDisConnectOtherRoom(i, str);
                LiveLogUtils.a("AudioChannelManagerForTencent --> TRTCCloudListener --> onDisConnectOtherRoom：（i：" + i + ", s：" + str + ")");
                StringBuilder sb = new StringBuilder();
                sb.append(" -- 远端断开房间 返回码 i: ");
                sb.append(i);
                sb.append("; s: ");
                sb.append(str);
                Logger.d("ulog", sb.toString());
            }

            public void onEnterRoom(long j) {
                Logger.d("ulog", " -- 自己进入房间 返回码 " + j);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a(j);
                }
            }

            public void onError(int i, String str, Bundle bundle) {
                LiveLogUtils.a("AudioChannelManagerForTencent --> TRTCCloudListener --> onError：" + str);
                Logger.d("ulog", " -- onError " + str);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.c(str);
                }
            }

            public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
                super.onNetworkQuality(tRTCQuality, arrayList);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a(tRTCQuality);
                }
            }

            public void onRecvCustomCmdMsg(String str, int i, int i2, byte[] bArr) {
                super.onRecvCustomCmdMsg(str, i, i2, bArr);
                Logger.d("ulog", " -- onRecvCustomCmdMsg userId: " + str + "; cmdID: " + i);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a(str, i, i2, bArr == null ? "" : new String(bArr));
                }
            }

            public void onRecvSEIMsg(String str, byte[] bArr) {
                super.onRecvSEIMsg(str, bArr);
                if (AudioChannelManagerForTencent.this.c != null) {
                    TRTCSEIMsg tRTCSEIMsg = null;
                    try {
                        tRTCSEIMsg = (TRTCSEIMsg) AppInfo.f().fromJson(new String(bArr), TRTCSEIMsg.class);
                    } catch (Exception e) {
                    }
                    TRTCSEIMsg tRTCSEIMsg2 = tRTCSEIMsg;
                    if (tRTCSEIMsg == null) {
                        tRTCSEIMsg2 = new TRTCSEIMsg();
                        tRTCSEIMsg2.cmdID = -1;
                    }
                    Logger.d("ulog", " -- onRecvSEIMsg userId: " + str + "; cmdID: " + tRTCSEIMsg2.cmdID);
                    AudioChannelManagerForTencent.this.c.a(str, tRTCSEIMsg2.cmdID, new String(bArr));
                }
            }

            public void onRemoteUserEnterRoom(String str) {
                Logger.d("ulog", " -- 远端进入房间 返回码 " + str);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a(str);
                }
            }

            public void onRemoteUserLeaveRoom(String str, int i) {
                Logger.d("ulog", " -- 远端离开房间 返回码 s: " + str + "; code： " + i);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.b(str);
                }
            }

            public void onSendFirstLocalAudioFrame() {
                super.onSendFirstLocalAudioFrame();
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.c();
                }
            }

            public void onStartPublishCDNStream(int i, String str) {
                Logger.d("cdn_stream", " -- onStartPublishCDNStream  errCode: " + i + "; errMsg: " + str);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a(i, str);
                }
            }

            public void onStatistics(TRTCStatistics tRTCStatistics) {
                super.onStatistics(tRTCStatistics);
                if (AudioChannelManagerForTencent.this.c == null || tRTCStatistics == null) {
                    return;
                }
                AudioChannelManagerForTencent.this.c.b(tRTCStatistics.rtt);
            }

            public void onStopPublishCDNStream(int i, String str) {
                Logger.d("cdn_stream", " -- onStopPublishCDNStream  errCode: " + i + "; errMsg: " + str);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.b(i, str);
                }
            }

            public void onSwitchRole(int i, String str) {
                Logger.d("ulog", " -- 切换角色 i: " + i + " ; s: " + str);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a(i);
                }
            }

            public void onTryToReconnect() {
                super.onTryToReconnect();
                LiveLogUtils.a("AudioChannelManagerForTencent --> TRTCCloudListener --> onTryToReconnect...");
                Logger.d("ulog", " -- onTryToReconnect ");
            }

            public void onUserAudioAvailable(String str, boolean z) {
                Logger.d("ulog", " -- " + z + " onUserAudioAvailable  " + str);
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a(str, z);
                }
            }

            public void onUserVideoAvailable(String str, boolean z) {
                super.onUserVideoAvailable(str, z);
                if (z) {
                    AudioChannelManagerForTencent.this.a.startRemoteView(str, 1, (TXCloudVideoView) null);
                } else {
                    AudioChannelManagerForTencent.this.a.stopRemoteView(str, 1);
                }
            }

            public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i) {
                if (arrayList.isEmpty()) {
                    return;
                }
                TreeSet treeSet = new TreeSet();
                Iterator<TRTCCloudDef.TRTCVolumeInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    TRTCCloudDef.TRTCVolumeInfo next = it.next();
                    if (next.volume >= AudioChannelManagerForTencent.this.i) {
                        treeSet.add(next.userId);
                    }
                }
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a((Set<String>) treeSet, false);
                }
            }
        };
    }

    private TRTCCloudListener m() {
        return new TRTCCloudListener() { // from class: com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManagerForTencent.4
            public void onEnterRoom(long j) {
                Logger.d("ulog", " --  房间PK 自己进入房间 返回码 " + j);
            }

            public void onRemoteUserEnterRoom(String str) {
                Logger.d("ulog", " -- 房间PK 远端进入房间 返回码 " + str);
            }

            public void onRemoteUserLeaveRoom(String str, int i) {
                Logger.d("ulog", " -- 房间PK 远端离开房间 返回码 s: " + str + "; code： " + i);
            }

            public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i) {
                if (arrayList.isEmpty()) {
                    return;
                }
                TreeSet treeSet = new TreeSet();
                Iterator<TRTCCloudDef.TRTCVolumeInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    TRTCCloudDef.TRTCVolumeInfo next = it.next();
                    if (next.volume >= AudioChannelManagerForTencent.this.i) {
                        treeSet.add(next.userId);
                    }
                }
                if (AudioChannelManagerForTencent.this.c != null) {
                    AudioChannelManagerForTencent.this.c.a((Set<String>) treeSet, true);
                }
            }
        };
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a() {
        if (this.a == null) {
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.switchRole(i);
        if (i == 20) {
            k();
            a(false);
            this.a.startLocalAudio(3);
            return;
        }
        this.a.setAudioFrameListener((TRTCCloudListener.TRTCAudioFrameListener) null);
        a(true);
        this.a.stopLocalAudio();
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, float f) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.getAudioEffectManager().setMusicPitch(i, f);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, int i2) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.getAudioEffectManager().seekMusicToPosInMS(i, i2);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, int i2, boolean z) {
        if (z) {
            if (this.f <= 0) {
                this.f = this.g;
                this.g = 0;
            }
            this.a.getAudioEffectManager().setMusicPitch(i, 0.0f);
            this.a.getAudioEffectManager().setMusicPublishVolume(i, this.f);
            this.a.getAudioEffectManager().setMusicPlayoutVolume(i, this.f);
            this.a.getAudioEffectManager().setMusicPitch(i2, 0.0f);
            this.a.getAudioEffectManager().setMusicPublishVolume(i2, 0);
            this.a.getAudioEffectManager().setMusicPlayoutVolume(i2, 0);
            return;
        }
        if (this.g <= 0) {
            this.g = this.f;
            this.f = 0;
        }
        this.a.getAudioEffectManager().setMusicPitch(i, 0.0f);
        this.a.getAudioEffectManager().setMusicPublishVolume(i, 0);
        this.a.getAudioEffectManager().setMusicPlayoutVolume(i, 0);
        this.a.getAudioEffectManager().setMusicPitch(i2, 0.0f);
        this.a.getAudioEffectManager().setMusicPublishVolume(i2, this.g);
        this.a.getAudioEffectManager().setMusicPlayoutVolume(i2, this.g);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(final int i, final IAudioContract.IMusicCallback iMusicCallback) {
        this.a.getAudioEffectManager().setMusicObserver(i, new TXAudioEffectManager.TXMusicPlayObserver() { // from class: com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManagerForTencent.2
            public void onComplete(int i2, int i3) {
                Logger.d("ulog", " -- onComplete id:" + i2 + ", errCode:" + i3);
                if (AudioChannelManagerForTencent.this.d != null) {
                    AudioChannelManagerForTencent.this.d.remove(Integer.valueOf(i2));
                }
                IAudioContract.IMusicCallback iMusicCallback2 = iMusicCallback;
                if (iMusicCallback2 != null) {
                    iMusicCallback2.b(i2, i3);
                }
            }

            public void onPlayProgress(int i2, long j, long j2) {
                TrtcMusicModel trtcMusicModel;
                if (AudioChannelManagerForTencent.this.d == null || (trtcMusicModel = (TrtcMusicModel) AudioChannelManagerForTencent.this.d.get(Integer.valueOf(i2))) == null) {
                    return;
                }
                trtcMusicModel.curPtsMS = j;
                trtcMusicModel.durationMS = j2;
                IAudioContract.IMusicCallback iMusicCallback2 = iMusicCallback;
                if (iMusicCallback2 != null) {
                    iMusicCallback2.a(trtcMusicModel);
                }
            }

            public void onStart(int i2, int i3) {
                if (AudioChannelManagerForTencent.this.d == null) {
                    AudioChannelManagerForTencent.this.d = new HashMap();
                }
                TrtcMusicModel trtcMusicModel = (TrtcMusicModel) AudioChannelManagerForTencent.this.d.get(Integer.valueOf(i2));
                TrtcMusicModel trtcMusicModel2 = trtcMusicModel;
                if (trtcMusicModel == null) {
                    trtcMusicModel2 = new TrtcMusicModel();
                }
                trtcMusicModel2.musicId = i2;
                trtcMusicModel2.errCode = i3;
                AudioChannelManagerForTencent.this.d.put(Integer.valueOf(i), trtcMusicModel2);
                IAudioContract.IMusicCallback iMusicCallback2 = iMusicCallback;
                if (iMusicCallback2 != null) {
                    iMusicCallback2.a(i2, i3);
                }
            }
        });
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, String str) {
        if (this.a == null) {
            return;
        }
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i, str);
        this.e = audioMusicParam;
        audioMusicParam.loopCount = 0;
        this.e.publish = true;
        this.a.getAudioEffectManager().setMusicPublishVolume(1, 10);
        this.a.getAudioEffectManager().setMusicPlayoutVolume(1, 10);
        this.a.getAudioEffectManager().setMusicPublishVolume(2, 70);
        this.a.getAudioEffectManager().setMusicPlayoutVolume(2, 70);
        this.a.getAudioEffectManager().startPlayMusic(this.e);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, String str, int i2, String str2, long j) {
        if (this.a == null) {
            return;
        }
        a(i, i2, true);
        if (!TextUtils.isEmpty(str)) {
            TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i, str);
            audioMusicParam.publish = true;
            audioMusicParam.startTimeMS = j;
            this.a.callExperimentalAPI("{\"api\":\"setBgmPublishDelay\", \"params\": {\"delay\":150}}");
            this.a.getAudioEffectManager().startPlayMusic(audioMusicParam);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        TXAudioEffectManager.AudioMusicParam audioMusicParam2 = new TXAudioEffectManager.AudioMusicParam(i2, str2);
        audioMusicParam2.publish = true;
        audioMusicParam2.startTimeMS = j;
        this.a.callExperimentalAPI("{\"api\":\"setBgmPublishDelay\", \"params\": {\"delay\":150}}");
        this.a.getAudioEffectManager().startPlayMusic(audioMusicParam2);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(int i, boolean z, String str, int i2, String str2, long j) {
        if (this.a == null) {
            return;
        }
        if (z) {
            a(i, i2, true);
        } else {
            a(i, i2, false);
        }
        if (!TextUtils.isEmpty(str)) {
            TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i, str);
            audioMusicParam.publish = true;
            audioMusicParam.startTimeMS = j;
            this.a.callExperimentalAPI("{\"api\":\"setBgmPublishDelay\", \"params\": {\"delay\":150}}");
            this.a.getAudioEffectManager().startPlayMusic(audioMusicParam);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        TXAudioEffectManager.AudioMusicParam audioMusicParam2 = new TXAudioEffectManager.AudioMusicParam(i2, str2);
        audioMusicParam2.publish = true;
        audioMusicParam2.startTimeMS = j;
        this.a.callExperimentalAPI("{\"api\":\"setBgmPublishDelay\", \"params\": {\"delay\":150}}");
        this.a.getAudioEffectManager().startPlayMusic(audioMusicParam2);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(TRTCSEIMsg tRTCSEIMsg) {
        if (this.a == null) {
            return;
        }
        Logger.d("ulog", " -- sendSEIMsg: " + tRTCSEIMsg.cmdID);
        this.a.sendSEIMsg(AppInfo.f().toJson(tRTCSEIMsg).getBytes(), 1);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(IAudioContract.IAudioCallback iAudioCallback) {
        this.c = iAudioCallback;
        TRTCCloud sharedInstance = TRTCCloud.sharedInstance(AppInfo.d());
        this.a = sharedInstance;
        sharedInstance.setListener(l());
        this.a.enableAudioVolumeEvaluation(2000, true);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(YYAudioConfig yYAudioConfig) {
        if (this.a == null) {
            return;
        }
        Logger.d("ulog", " setupChannel--  腾讯云 开房");
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.sdkAppId = GenerateTestUserSig.a();
        tRTCParams.userId = yYAudioConfig.c;
        tRTCParams.roomId = 0;
        tRTCParams.strRoomId = yYAudioConfig.b;
        if (TextUtils.isEmpty(yYAudioConfig.a)) {
            tRTCParams.userSig = GenerateTestUserSig.a(tRTCParams.userId);
        } else {
            tRTCParams.userSig = yYAudioConfig.a;
        }
        tRTCParams.role = yYAudioConfig.d;
        Logger.d("ulog", "加入角色  20主播 21普通：   " + yYAudioConfig.d);
        this.a.callExperimentalAPI("{\"api\":\"enableBlackStream\",\"params\": {\"enable\":true}}");
        if (yYAudioConfig.d == 20) {
            k();
            this.a.startLocalAudio(3);
            a(false);
        }
        TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat = new TRTCCloudDef.TRTCAudioFrameCallbackFormat();
        tRTCAudioFrameCallbackFormat.channel = GenerateTestUserSig.d();
        tRTCAudioFrameCallbackFormat.sampleRate = GenerateTestUserSig.e();
        tRTCAudioFrameCallbackFormat.samplesPerCall = (tRTCAudioFrameCallbackFormat.sampleRate * 20) / 1000;
        this.a.setCapturedRawAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat);
        this.a.enterRoom(tRTCParams, 3);
        this.a.getDeviceManager().setSystemVolumeType(TXDeviceManager.TXSystemVolumeType.TXSystemVolumeTypeMedia);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.startPublishCDNStream(tRTCPublishCDNParam);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(String str, int i) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.setRemoteAudioVolume(str, i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(boolean z) {
        if (this.a == null) {
            return;
        }
        LiveLogUtils.a("AudioChannelManagerForTencent --> setVoiceNotIn --> mute：" + z);
        if (z) {
            this.a.setAudioCaptureVolume(0);
        } else {
            this.a.setAudioCaptureVolume(100);
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void a(boolean z, int i) {
        if (z) {
            this.f = i;
            this.a.getAudioEffectManager().setMusicPitch(4443, 0.0f);
            this.a.getAudioEffectManager().setMusicPublishVolume(4443, i);
            this.a.getAudioEffectManager().setMusicPlayoutVolume(4443, i);
            this.g = 0;
            this.a.getAudioEffectManager().setMusicPitch(4444, 0.0f);
            this.a.getAudioEffectManager().setMusicPublishVolume(4444, 0);
            this.a.getAudioEffectManager().setMusicPlayoutVolume(4444, 0);
            return;
        }
        this.f = 0;
        this.a.getAudioEffectManager().setMusicPitch(4443, 0.0f);
        this.a.getAudioEffectManager().setMusicPublishVolume(4443, 0);
        this.a.getAudioEffectManager().setMusicPlayoutVolume(4443, 0);
        this.g = i;
        this.a.getAudioEffectManager().setMusicPitch(4444, 0.0f);
        this.a.getAudioEffectManager().setMusicPublishVolume(4444, i);
        this.a.getAudioEffectManager().setMusicPlayoutVolume(4444, i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b() {
        if (this.a == null) {
        }
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(int i) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.getAudioEffectManager().resumePlayMusic(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(int i, String str) {
        this.a.sendCustomCmdMsg(i, str.getBytes(), true, true);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(IAudioContract.IAudioCallback iAudioCallback) {
        if (this.a == null || iAudioCallback == null) {
            return;
        }
        this.c = iAudioCallback;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(YYAudioConfig yYAudioConfig) {
        TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
        tRTCParams.sdkAppId = GenerateTestUserSig.a();
        tRTCParams.userId = yYAudioConfig.c;
        tRTCParams.roomId = -1;
        tRTCParams.strRoomId = yYAudioConfig.b;
        if (TextUtils.isEmpty(yYAudioConfig.a)) {
            tRTCParams.userSig = GenerateTestUserSig.a(tRTCParams.userId);
        } else {
            tRTCParams.userSig = yYAudioConfig.a;
        }
        tRTCParams.role = 21;
        Logger.e("sdk", "subCloud params ==> " + AppInfo.f().toJson(tRTCParams));
        TRTCCloud createSubCloud = this.a.createSubCloud();
        this.b = createSubCloud;
        createSubCloud.enableAudioVolumeEvaluation(2000, true);
        this.b.setListener(m());
        this.b.enterRoom(tRTCParams, 3);
        this.b.muteLocalAudio(true);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void b(boolean z) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.getAudioEffectManager().enableVoiceEarMonitor(z);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void c() {
        HashMap<Integer, TrtcMusicModel> hashMap = this.d;
        if (hashMap != null) {
            for (Integer num : hashMap.keySet()) {
                d(num.intValue());
            }
            this.d.clear();
        }
        LiveLogUtils.a("AudioChannelManagerForTencent --> onDestroy ...");
        j();
        TRTCCloud.destroySharedInstance();
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void c(int i) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.getAudioEffectManager().pausePlayMusic(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void d() {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.stopPublishCDNStream();
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void d(int i) {
        this.a.getAudioEffectManager().stopPlayMusic(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void e() {
        if (this.b == null) {
            return;
        }
        LiveLogUtils.a("AudioChannelManagerForTencent --> exitOtherRoom ...");
        this.b.exitRoom();
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.destroySubCloud(this.b);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void e(int i) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        this.h = i;
        tRTCCloud.getAudioEffectManager().setVoiceCaptureVolume(i);
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public int f() {
        return this.f;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void f(int i) {
        this.h = i;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public int g() {
        return this.g;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void g(int i) {
        TRTCCloud tRTCCloud = this.a;
        if (tRTCCloud == null) {
            return;
        }
        tRTCCloud.getAudioEffectManager().setVoiceReverbType(h(i));
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public int h() {
        return this.h;
    }

    @Override // com.blued.android.module.yy_china.trtc_audio.IAudioContract.IAudioControl
    public void i() {
        IAudioContract.IAudioCallback iAudioCallback = this.c;
        if (iAudioCallback != null) {
            iAudioCallback.b();
        }
    }

    public void j() {
        if (this.a == null) {
            return;
        }
        LiveLogUtils.a("AudioChannelManagerForTencent --> leaveChannel --> stopLocalAudio、exitRoom");
        d();
        this.a.enableAudioVolumeEvaluation(0, false);
        this.a.stopLocalAudio();
        this.a.exitRoom();
        Logger.d("ulog", "腾讯云 leaveChannel  ");
    }
}
