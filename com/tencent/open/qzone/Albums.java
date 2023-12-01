package com.tencent.open.qzone;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.IUiListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/qzone/Albums.class */
public class Albums extends BaseApi {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/open/qzone/Albums$AlbumSecurity.class */
    public enum AlbumSecurity {
        publicToAll("1"),
        privateOnly("2"),
        friendsOnly("4"),
        needQuestion("5");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f38267a;

        AlbumSecurity(String str) {
            this.f38267a = str;
        }

        public String getSecurity() {
            return this.f38267a;
        }
    }

    public Albums(Context context, QQAuth qQAuth, QQToken qQToken) {
        super(qQAuth, qQToken);
    }

    public Albums(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void addAlbum(String str, String str2, AlbumSecurity albumSecurity, String str3, String str4, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        String str5 = str;
        if (str == null) {
            str5 = "";
        }
        composeCGIParams.putString("albumname", str5);
        String str6 = str2;
        if (str2 == null) {
            str6 = "";
        }
        composeCGIParams.putString("albumdesc", str6);
        composeCGIParams.putString("priv", albumSecurity == null ? AlbumSecurity.publicToAll.getSecurity() : albumSecurity.getSecurity());
        String str7 = str3;
        if (str3 == null) {
            str7 = "";
        }
        composeCGIParams.putString("question", str7);
        String str8 = str4;
        if (str4 == null) {
            str8 = "";
        }
        composeCGIParams.putString("answer", str8);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/add_album", composeCGIParams, "POST", new BaseApi.TempRequestListener(iUiListener));
    }

    public void listAlbum(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/list_album", composeCGIParams(), "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    public void listPhotos(String str, IUiListener iUiListener) {
        Bundle composeCGIParams = composeCGIParams();
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        composeCGIParams.putString("albumid", str2);
        HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/list_photo", composeCGIParams, "GET", new BaseApi.TempRequestListener(iUiListener));
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x014f: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:62:0x014f */
    public void uploadPicture(String str, String str2, String str3, String str4, String str5, IUiListener iUiListener) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2;
        BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream3.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream3.toByteArray();
                        try {
                            byteArrayOutputStream3.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        Bundle composeCGIParams = composeCGIParams();
                        File file = new File(str);
                        composeCGIParams.putByteArray("picture", byteArray);
                        String str6 = str2;
                        if (str2 == null) {
                            str6 = "";
                        }
                        composeCGIParams.putString("photodesc", str6);
                        composeCGIParams.putString("title", file.getName());
                        if (str3 != null) {
                            String str7 = str3;
                            if (str3 == null) {
                                str7 = "";
                            }
                            composeCGIParams.putString("albumid", str7);
                        }
                        String str8 = str4;
                        if (str4 == null) {
                            str8 = "";
                        }
                        composeCGIParams.putString("x", str8);
                        String str9 = str5;
                        if (str5 == null) {
                            str9 = "";
                        }
                        composeCGIParams.putString("y", str9);
                        HttpUtils.requestAsync(this.mToken, Global.getContext(), "photo/upload_pic", composeCGIParams, "POST", tempRequestListener);
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream = byteArrayOutputStream3;
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
                        byteArrayOutputStream2 = byteArrayOutputStream3;
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
                } catch (IOException e8) {
                    e = e8;
                    byteArrayOutputStream = null;
                }
            } catch (IOException e9) {
                e = e9;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
        }
    }
}
