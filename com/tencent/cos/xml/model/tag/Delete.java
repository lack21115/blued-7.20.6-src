package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Delete.class */
public class Delete {
    public List<DeleteObject> deleteObjects;
    public boolean quiet;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/Delete$DeleteObject.class */
    public static class DeleteObject {
        public String key;
        public String versionId;
    }
}
