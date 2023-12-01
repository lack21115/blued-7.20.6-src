package com.tencent.tendinsv.d;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/d/c.class */
public abstract class c {
    private void a() {
    }

    private void a(e eVar) {
    }

    private byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read != -1) {
                            byteArrayOutputStream3.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                byteArrayOutputStream = byteArrayOutputStream3;
                            }
                        }
                    }
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                    byteArrayOutputStream = byteArrayOutputStream3;
                } catch (Exception e2) {
                    byteArrayOutputStream = byteArrayOutputStream3;
                    e = e2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                            byteArrayOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream3;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public abstract void a(int i, String str);

    public void a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                if (httpURLConnection.getResponseCode() < 200 || httpURLConnection.getResponseCode() >= 300) {
                    int responseCode = httpURLConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append(httpURLConnection.getResponseCode());
                    sb.append("");
                    a(responseCode, sb.toString());
                    bufferedInputStream = null;
                } else {
                    a(new e(httpURLConnection.getContentType(), httpURLConnection.getContentLength()));
                    bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    try {
                        a(a(bufferedInputStream));
                    } catch (Exception e) {
                        e = e;
                        a(1007, e.getClass().getSimpleName());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                a();
                            }
                        }
                        a();
                    } catch (Throwable th) {
                        bufferedInputStream2 = bufferedInputStream;
                        th = th;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        a();
                        throw th;
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        a();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                bufferedInputStream = null;
            }
            a();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a(HttpsURLConnection httpsURLConnection) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                if (httpsURLConnection.getResponseCode() < 200 || httpsURLConnection.getResponseCode() >= 300) {
                    int responseCode = httpsURLConnection.getResponseCode();
                    StringBuilder sb = new StringBuilder();
                    sb.append(httpsURLConnection.getResponseCode());
                    sb.append("");
                    a(responseCode, sb.toString());
                    bufferedInputStream = null;
                } else {
                    a(new e(httpsURLConnection.getContentType(), httpsURLConnection.getContentLength()));
                    bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
                    try {
                        a(a(bufferedInputStream));
                    } catch (IOException e) {
                        e = e;
                        a(1007, e.getClass().getSimpleName());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                a();
                            }
                        }
                        a();
                    } catch (Throwable th) {
                        bufferedInputStream2 = bufferedInputStream;
                        th = th;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        a();
                        throw th;
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        a();
                    }
                }
            } catch (IOException e5) {
                e = e5;
                bufferedInputStream = null;
            }
            a();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(byte[] bArr);
}
