package com.tencent.txcopyrightedmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/ITXCMMusicTrack.class */
public interface ITXCMMusicTrack {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/ITXCMMusicTrack$OnErrorListener.class */
    public interface OnErrorListener {
        void onError(int i, String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/ITXCMMusicTrack$OnPreparedListener.class */
    public interface OnPreparedListener {
        void onPrepared();
    }

    void destroy();

    int getChannelCount();

    int getDuration();

    int getMinBufferSize();

    <T> T getProxy(Object obj);

    int getSampleRate();

    void prepare();

    int prepareSync();

    int readAudioFrame(TXCMAudioFrameInfo tXCMAudioFrameInfo);

    void seek(int i);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void start();

    void stop();
}
