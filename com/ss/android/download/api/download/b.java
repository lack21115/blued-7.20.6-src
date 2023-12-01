package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/download/b.class */
public class b implements DownloadEventConfig {
    private String b;
    private String e;
    private String h;
    private String hj;

    /* renamed from: io  reason: collision with root package name */
    private String f21190io;
    private String jb;
    private Object je;
    private String ko;
    private boolean lc;
    private String lz;
    private String mb;
    private boolean nk;
    private boolean o;
    private boolean ox;
    private String u;
    private String ww;
    private String x;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/download/b$mb.class */
    public static final class mb {
        private String b;
        private String e;
        private String h;
        private String hj;

        /* renamed from: io  reason: collision with root package name */
        private String f21191io;
        private String jb;
        private Object je;
        private String ko;
        private boolean lc;
        private String lz;
        private String mb;
        private boolean nk;
        private boolean o;
        private boolean ox;
        private String u;
        private String ww;
        private String x;

        public b mb() {
            return new b(this);
        }
    }

    public b() {
    }

    private b(mb mbVar) {
        this.mb = mbVar.mb;
        this.ox = mbVar.ox;
        this.b = mbVar.b;
        this.hj = mbVar.hj;
        this.h = mbVar.h;
        this.u = mbVar.u;
        this.ko = mbVar.ko;
        this.ww = mbVar.ww;
        this.lz = mbVar.lz;
        this.x = mbVar.x;
        this.jb = mbVar.jb;
        this.je = mbVar.je;
        this.nk = mbVar.nk;
        this.o = mbVar.o;
        this.lc = mbVar.lc;
        this.f21190io = mbVar.f21191io;
        this.e = mbVar.e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.mb;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.u;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.ko;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.h;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.hj;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.je;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.x;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.ox;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.nk;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }
}
