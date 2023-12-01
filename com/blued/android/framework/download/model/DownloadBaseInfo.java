package com.blued.android.framework.download.model;

import java.io.Serializable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/download/model/DownloadBaseInfo.class */
public class DownloadBaseInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String description;
    public int times;
    public String title;
    public String type;
    public String version;
    public String version_code;
    public String download_url = "";
    public String name = "";
    public String md5 = "";
}
