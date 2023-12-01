package com.blued.android.framework.utils.upload.qiniu;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/upload/qiniu/BluedToken.class */
public class BluedToken implements Serializable {
    public String callback;
    public String key;
    public String token;
    public List<String> uploading_keys;
}
