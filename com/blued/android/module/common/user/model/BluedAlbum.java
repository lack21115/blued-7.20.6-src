package com.blued.android.module.common.user.model;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/model/BluedAlbum.class */
public class BluedAlbum implements Serializable {
    private static final long serialVersionUID = 1;
    public int applyStatus;
    public int audit_status;
    public String id;
    public String image;
    public boolean isUpdate;
    public String key;
    private String pid;
    public int position;
    public String progress = "";
    public String token;
    private String url;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/model/BluedAlbum$PRIVATE_ALBUM_APPLYSTATUS.class */
    public interface PRIVATE_ALBUM_APPLYSTATUS {
        public static final int SHOW_APPLY = 1;
        public static final int SHOW_NONE = 0;
        public static final int SHOW_WAITING = 2;
    }

    public String getPid() {
        return this.pid;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setProgress(String str) {
        this.progress = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
