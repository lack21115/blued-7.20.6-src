package a.a.a.a.a.k.d;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/b.class */
public final class b {
    public Context e;

    /* renamed from: a  reason: collision with root package name */
    public long f1357a = 0;
    public long b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f1358c = 0;
    public long d = 0;
    public boolean f = false;
    public String g = null;

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(Context context, String str, long j) {
        FileInputStream fileInputStream;
        Closeable closeable;
        BufferedReader bufferedReader;
        OutOfMemoryError e;
        IOException e2;
        try {
            try {
                fileInputStream = context.openFileInput(str);
            } catch (FileNotFoundException e3) {
                fileInputStream = null;
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
            } catch (OutOfMemoryError e5) {
                e = e5;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                closeable = null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            } catch (FileNotFoundException e6) {
                bufferedReader = null;
                a(fileInputStream);
                a(bufferedReader);
                return null;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
                e2 = e;
                e2.printStackTrace();
                a(fileInputStream);
                a(bufferedReader);
                return null;
            } catch (OutOfMemoryError e8) {
                e = e8;
                bufferedReader = null;
                e = e;
                e.printStackTrace();
                a(fileInputStream);
                a(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                a(fileInputStream);
                a(closeable);
                throw th;
            }
            try {
                bufferedReader.skip(j);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
                String sb2 = sb.toString();
                if ("".equals(sb2)) {
                    a(fileInputStream);
                    a(bufferedReader);
                    return null;
                }
                a(fileInputStream);
                a(bufferedReader);
                return sb2;
            } catch (FileNotFoundException e9) {
                a(fileInputStream);
                a(bufferedReader);
                return null;
            } catch (IOException e10) {
                e2 = e10;
                e2.printStackTrace();
                a(fileInputStream);
                a(bufferedReader);
                return null;
            } catch (OutOfMemoryError e11) {
                e = e11;
                e.printStackTrace();
                a(fileInputStream);
                a(bufferedReader);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = str;
            closeable = null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, String str2, int i) {
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = context.openFileOutput(str, i);
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                    try {
                        bufferedWriter.write(str2);
                        bufferedWriter.close();
                        a(fileOutputStream);
                        a(bufferedWriter);
                        return true;
                    } catch (FileNotFoundException e) {
                        a(fileOutputStream);
                        a(bufferedWriter);
                        return false;
                    } catch (IOException e2) {
                        e = e2;
                        str2 = bufferedWriter;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        a(fileOutputStream);
                        a(bufferedWriter);
                        return false;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        str2 = bufferedWriter;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        a(fileOutputStream);
                        a(bufferedWriter);
                        return false;
                    } catch (Throwable th) {
                        str2 = bufferedWriter;
                        fileOutputStream2 = fileOutputStream;
                        th = th;
                        a(fileOutputStream2);
                        a(str2);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    bufferedWriter = null;
                } catch (IOException e5) {
                    e = e5;
                    bufferedWriter = null;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    bufferedWriter = null;
                } catch (Throwable th2) {
                    str2 = null;
                    fileOutputStream2 = fileOutputStream;
                    th = th2;
                }
            } catch (FileNotFoundException e7) {
                fileOutputStream = null;
                bufferedWriter = null;
            } catch (IOException e8) {
                e = e8;
                fileOutputStream = null;
                bufferedWriter = null;
            } catch (OutOfMemoryError e9) {
                e = e9;
                fileOutputStream = null;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = null;
                str2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public void a() {
        if (this.f) {
            String str = this.g;
            if (str != null) {
                a(this.e, "pili_qos_cache", str, 0);
                this.g = null;
            }
            this.f = false;
        }
    }

    public void a(Context context) {
        if (this.f) {
            return;
        }
        this.e = context.getApplicationContext();
        f();
        if (d()) {
            this.g = a(context, "pili_qos_cache", 0L);
        }
        this.f = true;
    }

    public boolean a(String str) {
        if (this.f && this.f1358c - this.f1357a <= 100) {
            synchronized (this) {
                if (a(this.e, "pili_qos_log." + this.f1358c, str, 32768)) {
                    long length = this.d + str.length();
                    this.d = length;
                    if (length >= 65536) {
                        this.f1358c++;
                        this.d = 0L;
                    }
                    g();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void b() {
        this.g = null;
        if (d()) {
            this.e.deleteFile("pili_qos_cache");
        }
    }

    public String c() {
        if (this.f) {
            String str = this.g;
            if (str != null) {
                return str;
            }
            if (this.f1357a == this.f1358c && this.b == this.d) {
                return null;
            }
            synchronized (this) {
                boolean z = this.f1357a < this.f1358c;
                String a2 = a(this.e, "pili_qos_log." + this.f1357a, this.b);
                this.g = a2;
                if (a2 == null) {
                    return null;
                }
                this.b += a2.length();
                if (this.f1357a < this.f1358c) {
                    this.f1357a++;
                    this.b = 0L;
                }
                g();
                if (z) {
                    long j = this.f1357a;
                    this.e.deleteFile("pili_qos_log." + (j - 1));
                }
                return this.g;
            }
        }
        return null;
    }

    public final boolean d() {
        return new File(this.e.getFilesDir().getAbsolutePath() + "/pili_qos_cache").exists();
    }

    public final void e() {
        String[] fileList = this.e.fileList();
        int length = fileList.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = fileList[i2];
            if (str.startsWith("pili_qos_")) {
                this.e.deleteFile(str);
            }
            i = i2 + 1;
        }
    }

    public final boolean f() {
        try {
            String a2 = a(this.e, "pili_qos_index.json", 0L);
            if (a2 == null) {
                e();
                return false;
            }
            JSONObject jSONObject = new JSONObject(String.valueOf(a2));
            this.f1357a = jSONObject.getLong("read_file_index");
            this.b = jSONObject.getLong("read_file_position");
            this.f1358c = jSONObject.getLong("write_file_index");
            this.d = jSONObject.getLong("write_file_position");
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            e();
            return false;
        }
    }

    public final boolean g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("read_file_index", this.f1357a);
            jSONObject.put("read_file_position", this.b);
            jSONObject.put("write_file_index", this.f1358c);
            jSONObject.put("write_file_position", this.d);
            return a(this.e, "pili_qos_index.json", jSONObject.toString(), 0);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
