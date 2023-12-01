package com.tencent.open.t;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/t/Weibo.class */
public class Weibo extends BaseApi {
    public Weibo(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public Weibo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void atFriends(int i, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        composeCGIParams.putString("reqnum", i + "");
        HttpUtils.requestAsync(this.mToken, Global.getContext(), Constants.GRAPH_INTIMATE_FRIENDS, composeCGIParams, "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void deleteText(String str, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        composeCGIParams.putString("id", str);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "t/del_t", composeCGIParams, "POST", new BaseApi.TempRequestListener(iUiListener));
    }

    public void getWeiboInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/get_info", composeCGIParams(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void nickTips(String str, int i, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        composeCGIParams.putString("match", str2);
        composeCGIParams.putString("reqnum", i + "");
        HttpUtils.requestAsync(this.mToken, Global.getContext(), Constants.GRAPH_NICK_TIPS, composeCGIParams, "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void sendPicText(String str, String str2, IUiListener iUiListener) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str2);
            FileInputStream fileInputStream2 = fileInputStream;
            byteArrayOutputStream2 = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        Bundle composeCGIParams = composeCGIParams();
                        String str3 = str;
                        if (str == null) {
                            str3 = "";
                        }
                        composeCGIParams.putString("content", str3);
                        composeCGIParams.putByteArray("pic", byteArray);
                        HttpUtils.requestAsync(this.mToken, Global.getContext(), "t/add_pic_t", composeCGIParams, "POST", tempRequestListener);
                    } catch (IOException e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        tempRequestListener.onIOException(e);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                }
            } catch (IOException e8) {
                e = e8;
                byteArrayOutputStream = null;
            }
        } catch (IOException e9) {
            e = e9;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public void sendText(String str, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        composeCGIParams.putString("content", str2);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "t/add_t", composeCGIParams, "POST", new BaseApi.TempRequestListener(iUiListener));
    }
}
