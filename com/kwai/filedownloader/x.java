package com.kwai.filedownloader;

import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/x.class */
public interface x extends s.a {

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/x$a.class */
    public interface a {
        t GO();

        boolean a(MessageSnapshot messageSnapshot);

        boolean b(MessageSnapshot messageSnapshot);

        boolean c(MessageSnapshot messageSnapshot);

        boolean d(MessageSnapshot messageSnapshot);

        MessageSnapshot n(Throwable th);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/x$b.class */
    public interface b {
        void start();
    }

    void GP();

    long GQ();

    byte Gq();

    Throwable Gs();

    int Gu();

    boolean Gw();

    void free();

    long getStatusUpdateTime();

    long getTotalBytes();

    boolean pause();

    void reset();
}
