package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXImageSprite.class */
public class TXImageSprite {
    private Context mContext;
    private com.tencent.rtmp.a.a mImageSprite;

    public TXImageSprite(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public Bitmap getThumbnail(float f) {
        com.tencent.rtmp.a.a aVar = this.mImageSprite;
        if (aVar != null) {
            return aVar.getThumbnail(f);
        }
        return null;
    }

    public void release() {
        com.tencent.rtmp.a.a aVar = this.mImageSprite;
        if (aVar != null) {
            aVar.release();
            this.mImageSprite = null;
        }
    }

    public void setVTTUrlAndImageUrls(String str, List<String> list) {
        if (this.mImageSprite != null) {
            release();
        }
        if (str == null || list == null || list.size() == 0) {
            return;
        }
        new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1).ReportDau(1555, 0, "");
        com.tencent.rtmp.a.a aVar = new com.tencent.rtmp.a.a(this.mContext);
        this.mImageSprite = aVar;
        aVar.setVTTUrlAndImageUrls(str, list);
    }
}
