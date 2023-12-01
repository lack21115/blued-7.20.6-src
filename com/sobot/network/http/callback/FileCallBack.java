package com.sobot.network.http.callback;

import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.utils.L;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/callback/FileCallBack.class */
public abstract class FileCallBack extends Callback<File> {
    private String destFileDir;
    private String destFileName;

    public FileCallBack(String str) {
        File file = new File(str);
        this.destFileDir = file.getParent();
        this.destFileName = file.getName();
    }

    public FileCallBack(String str, String str2) {
        this.destFileDir = str;
        this.destFileName = str2;
    }

    public abstract void inProgress(float f, long j);

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sobot.network.http.callback.Callback
    public File parseNetworkResponse(Response response) throws Exception {
        return saveFile(response);
    }

    public File saveFile(Response response) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        byte[] bArr = new byte[2048];
        try {
            inputStream = response.body().byteStream();
            try {
                final long contentLength = response.body().contentLength();
                final long j = 0;
                L.e(contentLength + "");
                File file = new File(this.destFileDir);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, this.destFileName);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j += read;
                        fileOutputStream2.write(bArr, 0, read);
                        SobotOkHttpUtils.getInstance().getDelivery().post(new Runnable() { // from class: com.sobot.network.http.callback.FileCallBack.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FileCallBack fileCallBack = FileCallBack.this;
                                float f = (float) j;
                                long j2 = contentLength;
                                fileCallBack.inProgress((f * 1.0f) / ((float) j2), j2);
                            }
                        });
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                try {
                    fileOutputStream2.close();
                    return file2;
                } catch (IOException e4) {
                    return file2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            inputStream = null;
        }
    }
}
