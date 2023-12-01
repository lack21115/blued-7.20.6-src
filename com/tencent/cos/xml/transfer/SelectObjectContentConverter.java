package com.tencent.cos.xml.transfer;

import android.text.TextUtils;
import com.tencent.cos.xml.listener.SelectObjectContentListener;
import com.tencent.cos.xml.model.object.SelectObjectContentResult;
import com.tencent.cos.xml.model.tag.eventstreaming.MessageDecoder;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.ResponseBodyConverter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/SelectObjectContentConverter.class */
public class SelectObjectContentConverter<T> extends ResponseBodyConverter<T> {
    private SelectObjectContentListener contentListener;
    private String localPath;
    private MessageDecoder messageDecoder = new MessageDecoder();
    private SelectObjectContentResult selectObjectContentResult;

    public SelectObjectContentConverter(SelectObjectContentResult selectObjectContentResult, String str) {
        this.selectObjectContentResult = selectObjectContentResult;
        this.localPath = str;
    }

    private void closeFileOutputStream(FileOutputStream fileOutputStream) throws QCloudClientException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new QCloudClientException(e);
            }
        }
    }

    private FileOutputStream newFileOutputStream(String str) throws QCloudClientException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            if (file.createNewFile()) {
                return new FileOutputStream(file);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new QCloudClientException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0073 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0023 A[Catch: IOException -> 0x007e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x007e, blocks: (B:3:0x0019, B:5:0x0023, B:7:0x0034, B:9:0x003e, B:11:0x0047, B:13:0x004f, B:15:0x0065, B:16:0x0073), top: B:22:0x0019 }] */
    @Override // com.tencent.qcloud.core.http.ResponseBodyConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T convert(com.tencent.qcloud.core.http.HttpResponse<T> r6) throws com.tencent.qcloud.core.common.QCloudClientException, com.tencent.qcloud.core.common.QCloudServiceException {
        /*
            r5 = this;
            r0 = r6
            com.tencent.qcloud.core.http.HttpResponse.checkResponseSuccessful(r0)
            r0 = r6
            java.io.InputStream r0 = r0.byteStream()
            r6 = r0
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r8 = r0
            r0 = r5
            r1 = r5
            java.lang.String r1 = r1.localPath
            java.io.FileOutputStream r0 = r0.newFileOutputStream(r1)
            r9 = r0
        L19:
            r0 = r6
            r1 = r8
            int r0 = r0.read(r1)     // Catch: java.io.IOException -> L7e
            r7 = r0
            r0 = r7
            if (r0 <= 0) goto L73
            r0 = r5
            com.tencent.cos.xml.model.tag.eventstreaming.MessageDecoder r0 = r0.messageDecoder     // Catch: java.io.IOException -> L7e
            r1 = r8
            r2 = 0
            r3 = r7
            java.util.List r0 = r0.feed(r1, r2, r3)     // Catch: java.io.IOException -> L7e
            r10 = r0
            r0 = r9
            if (r0 == 0) goto L3c
            r0 = r9
            r1 = r8
            r2 = 0
            r3 = r7
            r0.write(r1, r2, r3)     // Catch: java.io.IOException -> L7e
        L3c:
            r0 = r10
            java.util.Iterator r0 = r0.iterator()     // Catch: java.io.IOException -> L7e
            r10 = r0
        L45:
            r0 = r10
            boolean r0 = r0.hasNext()     // Catch: java.io.IOException -> L7e
            if (r0 == 0) goto L19
            r0 = r10
            java.lang.Object r0 = r0.next()     // Catch: java.io.IOException -> L7e
            com.tencent.cos.xml.model.tag.eventstreaming.Message r0 = (com.tencent.cos.xml.model.tag.eventstreaming.Message) r0     // Catch: java.io.IOException -> L7e
            com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEvent r0 = com.tencent.cos.xml.model.tag.eventstreaming.SelectObjectContentEventUnmarshaller.unmarshalMessage(r0)     // Catch: java.io.IOException -> L7e
            r11 = r0
            r0 = r5
            com.tencent.cos.xml.listener.SelectObjectContentListener r0 = r0.contentListener     // Catch: java.io.IOException -> L7e
            if (r0 == 0) goto L45
            r0 = r5
            com.tencent.cos.xml.listener.SelectObjectContentListener r0 = r0.contentListener     // Catch: java.io.IOException -> L7e
            r1 = r11
            r0.onProcess(r1)     // Catch: java.io.IOException -> L7e
            goto L45
        L73:
            r0 = r5
            r1 = r9
            r0.closeFileOutputStream(r1)     // Catch: java.io.IOException -> L7e
            r0 = r5
            com.tencent.cos.xml.model.object.SelectObjectContentResult r0 = r0.selectObjectContentResult
            return r0
        L7e:
            r6 = move-exception
            r0 = r6
            r0.printStackTrace()
            com.tencent.qcloud.core.common.QCloudClientException r0 = new com.tencent.qcloud.core.common.QCloudClientException
            r1 = r0
            r2 = r6
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.SelectObjectContentConverter.convert(com.tencent.qcloud.core.http.HttpResponse):java.lang.Object");
    }

    public void setContentListener(SelectObjectContentListener selectObjectContentListener) {
        this.contentListener = selectObjectContentListener;
    }
}
