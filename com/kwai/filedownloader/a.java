package com.kwai.filedownloader;

import com.kwai.filedownloader.x;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a.class */
public interface a {

    /* renamed from: com.kwai.filedownloader.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a$a.class */
    public interface InterfaceC0413a {
        int GA();

        void GB();

        boolean GC();

        void GD();

        void GE();

        boolean GF();

        a Gy();

        x.a Gz();

        boolean cw(int i);

        void free();

        boolean isOver();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a$b.class */
    public interface b {
        int GG();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/a$c.class */
    public interface c {
        void GH();

        void onBegin();
    }

    b Gh();

    boolean Gi();

    boolean Gj();

    int Gk();

    int Gl();

    boolean Gm();

    i Gn();

    long Go();

    long Gp();

    byte Gq();

    boolean Gr();

    Throwable Gs();

    int Gt();

    int Gu();

    boolean Gv();

    boolean Gw();

    boolean Gx();

    a a(i iVar);

    a al(String str, String str2);

    a bP(boolean z);

    a bQ(boolean z);

    a bR(boolean z);

    boolean cancel();

    a cv(int i);

    a f(String str, boolean z);

    a fj(String str);

    a fk(String str);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    a k(Object obj);

    boolean pause();

    int start();
}
