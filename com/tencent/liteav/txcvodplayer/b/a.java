package com.tencent.liteav.txcvodplayer.b;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/a.class */
public final class a {

    /* renamed from: com.tencent.liteav.txcvodplayer.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/a$a.class */
    public static final class C0761a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22825a = new a((byte) 0);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/b/a$b.class */
    public interface b {
        void a();

        void a(String str);
    }

    private a() {
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public final void a(final String str, final b bVar) {
        AsyncTask.execute(new Runnable() { // from class: com.tencent.liteav.txcvodplayer.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                BufferedReader bufferedReader;
                BufferedReader bufferedReader2 = null;
                try {
                    try {
                        URLConnection openConnection = new URL(str).openConnection();
                        openConnection.setConnectTimeout(15000);
                        openConnection.setReadTimeout(15000);
                        openConnection.connect();
                        InputStream inputStream = openConnection.getInputStream();
                        if (inputStream == null) {
                            if (bVar != null) {
                                bVar.a();
                                return;
                            }
                            return;
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                                sb.append("\n");
                            }
                            if (bVar != null) {
                                bVar.a(sb.toString());
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                            }
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            BufferedReader bufferedReader3 = bufferedReader;
                            if (bVar != null) {
                                BufferedReader bufferedReader4 = bufferedReader;
                                bVar.a();
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                }
                            }
                        } catch (Throwable th) {
                            bufferedReader2 = bufferedReader;
                            th = th;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        });
    }
}
