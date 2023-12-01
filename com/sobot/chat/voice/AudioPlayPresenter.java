package com.sobot.chat.voice;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.sobot.chat.api.model.ZhiChiMessageBase;
import com.sobot.chat.core.HttpUtils;
import com.sobot.chat.utils.AudioTools;
import com.sobot.chat.utils.LogUtils;
import com.sobot.chat.utils.ResourceUtils;
import com.sobot.chat.utils.SobotPathManager;
import com.sobot.chat.utils.ToastUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/voice/AudioPlayPresenter.class */
public class AudioPlayPresenter {
    private AudioPlayCallBack mCallbak;
    private Context mContent;
    private ZhiChiMessageBase mCurrentMsg;

    public AudioPlayPresenter(Context context) {
        this.mContent = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playVoice(final ZhiChiMessageBase zhiChiMessageBase, File file) {
        try {
            AudioTools.getInstance();
            if (AudioTools.getIsPlaying()) {
                AudioTools.stop();
            }
            AudioTools.getInstance().setAudioStreamType(3);
            AudioTools.getInstance().reset();
            AudioTools.getInstance().setDataSource(file.toString());
            AudioTools.getInstance().prepareAsync();
            AudioTools.getInstance().setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.sobot.chat.voice.AudioPlayPresenter.2
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    zhiChiMessageBase.setVoideIsPlaying(true);
                    if (AudioPlayPresenter.this.mCallbak != null) {
                        AudioPlayPresenter.this.mCurrentMsg = zhiChiMessageBase;
                        AudioPlayPresenter.this.mCallbak.onPlayStart(zhiChiMessageBase);
                    }
                }
            });
            AudioTools.getInstance().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.sobot.chat.voice.AudioPlayPresenter.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    zhiChiMessageBase.setVoideIsPlaying(false);
                    AudioTools.getInstance().stop();
                    LogUtils.i("----语音播放完毕----");
                    if (AudioPlayPresenter.this.mCallbak != null) {
                        AudioPlayPresenter.this.mCallbak.onPlayEnd(zhiChiMessageBase);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.i("音频播放失败");
            zhiChiMessageBase.setVoideIsPlaying(false);
            AudioTools.getInstance().stop();
            AudioPlayCallBack audioPlayCallBack = this.mCallbak;
            if (audioPlayCallBack != null) {
                audioPlayCallBack.onPlayEnd(zhiChiMessageBase);
            }
        }
    }

    private void playVoiceByPath(final ZhiChiMessageBase zhiChiMessageBase) {
        String str;
        String msg = zhiChiMessageBase.getAnswer().getMsg();
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        if (zhiChiMessageBase.getSugguestionsFontColor() == 1) {
            String str2 = SobotPathManager.getInstance().getVoiceDir() + msg.substring(msg.lastIndexOf("/") + 1, msg.length());
            File parentFile = new File(str2).getParentFile();
            str = str2;
            if (!parentFile.exists()) {
                str = str2;
                if (!parentFile.mkdirs()) {
                    try {
                        parentFile.createNewFile();
                        str = str2;
                    } catch (IOException e) {
                        e.printStackTrace();
                        str = str2;
                    }
                }
            }
        } else {
            str = msg;
        }
        LogUtils.i("contentPath：" + str);
        File file = new File(str);
        if (file.exists()) {
            playVoice(zhiChiMessageBase, file);
        } else if (!TextUtils.isEmpty(msg) && msg.startsWith("http")) {
            HttpUtils.getInstance().download(msg, file, null, new HttpUtils.FileCallBack() { // from class: com.sobot.chat.voice.AudioPlayPresenter.1
                @Override // com.sobot.chat.core.HttpUtils.FileCallBack
                public void inProgress(int i) {
                }

                @Override // com.sobot.chat.core.HttpUtils.FileCallBack
                public void onError(Exception exc, String str3, int i) {
                }

                @Override // com.sobot.chat.core.HttpUtils.FileCallBack
                public void onResponse(File file2) {
                    AudioPlayPresenter.this.playVoice(zhiChiMessageBase, file2);
                }
            });
        } else {
            Context context = this.mContent;
            ToastUtil.showToast(context, ResourceUtils.getResString(context, "sobot_voice_file_error"));
        }
    }

    public void clickAudio(ZhiChiMessageBase zhiChiMessageBase, AudioPlayCallBack audioPlayCallBack) {
        synchronized (this) {
            if (AudioTools.getInstance().isPlaying()) {
                AudioTools.stop();
            }
            this.mCallbak = audioPlayCallBack;
            if (this.mCurrentMsg != zhiChiMessageBase) {
                if (this.mCurrentMsg != null) {
                    this.mCurrentMsg.setVoideIsPlaying(false);
                    if (this.mCallbak != null) {
                        this.mCallbak.onPlayEnd(this.mCurrentMsg);
                        this.mCurrentMsg = null;
                    }
                }
                playVoiceByPath(zhiChiMessageBase);
            } else {
                AudioTools.stop();
                zhiChiMessageBase.setVoideIsPlaying(false);
                if (this.mCallbak != null) {
                    this.mCallbak.onPlayEnd(zhiChiMessageBase);
                    this.mCurrentMsg = null;
                }
            }
        }
    }
}
