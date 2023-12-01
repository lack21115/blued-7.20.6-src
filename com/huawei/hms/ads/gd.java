package com.huawei.hms.ads;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/gd.class */
public final class gd extends gc {
    private static final long I = 4194304;
    private static final String V = "FileLogNode";
    private File Z;

    private gd() {
    }

    public static gj Code() {
        return new gh(new gd());
    }

    private static void Code(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.w(V, "Exception when closing the closeable.");
            }
        }
    }

    private void Code(String str) {
        if (str == null || this.Z == null) {
            return;
        }
        String str2 = str + '\n';
        if (V(str2)) {
            I(str2);
        }
    }

    private void I(String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.Z, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                outputStreamWriter2 = null;
                OutputStream outputStream2 = fileOutputStream;
                OutputStream outputStream3 = bufferedOutputStream;
                try {
                    try {
                        outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                        try {
                            outputStreamWriter.write(str);
                            outputStreamWriter.flush();
                            Code(outputStreamWriter);
                            outputStream = bufferedOutputStream;
                        } catch (FileNotFoundException e) {
                            outputStream = bufferedOutputStream;
                            outputStreamWriter2 = outputStreamWriter;
                            outputStream2 = fileOutputStream;
                            outputStream3 = outputStream;
                            Log.w(V, "Exception when writing the log file.");
                            Code(outputStreamWriter);
                            Code(outputStream);
                            Code(fileOutputStream);
                        } catch (IOException e2) {
                            outputStream = bufferedOutputStream;
                            outputStreamWriter2 = outputStreamWriter;
                            outputStream2 = fileOutputStream;
                            outputStream3 = outputStream;
                            Log.w(V, "Exception when writing the log file.");
                            Code(outputStreamWriter);
                            Code(outputStream);
                            Code(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            outputStreamWriter2 = outputStreamWriter;
                            Code(outputStreamWriter2);
                            Code(bufferedOutputStream);
                            Code(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = outputStream3;
                        fileOutputStream = outputStream2;
                    }
                } catch (FileNotFoundException | IOException e3) {
                    outputStreamWriter = null;
                    outputStream = bufferedOutputStream;
                }
            } catch (FileNotFoundException e4) {
                outputStream = null;
                outputStreamWriter = null;
            } catch (IOException e5) {
                outputStream = null;
                outputStreamWriter = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (FileNotFoundException e6) {
            fileOutputStream = null;
            outputStream = null;
            outputStreamWriter = null;
        } catch (IOException e7) {
            fileOutputStream = null;
            outputStream = null;
            outputStreamWriter = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        Code(outputStream);
        Code(fileOutputStream);
    }

    private boolean V(String str) {
        String str2;
        if (this.Z.length() + str.length() > 4194304) {
            File file = new File(this.Z.getPath() + ".bak");
            if (!(file.exists() ? file.delete() : true)) {
                str2 = "Cannot rename log file to bak.";
            } else if (this.Z.renameTo(file)) {
                return true;
            } else {
                str2 = "Failed to backup the log file.";
            }
            Log.w(V, str2);
            return false;
        }
        return true;
    }

    @Override // com.huawei.hms.ads.gj
    public gj Code(String str, String str2) {
        String str3;
        if (str2 == null || str2.isEmpty()) {
            Log.e(V, "Failed to initialize the file logger, parameter error.");
            return this;
        }
        if (this.Z == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    File canonicalFile = new File(str, "Log").getCanonicalFile();
                    if (canonicalFile.isDirectory() || com.huawei.openalliance.ad.utils.p.Code(canonicalFile)) {
                        File file = new File(canonicalFile, str2 + ".log");
                        this.Z = file;
                        file.setReadable(true);
                        this.Z.setWritable(true);
                        this.Z.setExecutable(false, false);
                        return this;
                    }
                }
            } catch (IOException e) {
                str3 = "file path error. ioex";
                Log.e(V, str3);
                Log.w(V, "the file logger has been created already.");
                return this;
            } catch (Throwable th) {
                str3 = "file path error. " + th.getClass().getSimpleName();
                Log.e(V, str3);
                Log.w(V, "the file logger has been created already.");
                return this;
            }
        }
        Log.w(V, "the file logger has been created already.");
        return this;
    }

    @Override // com.huawei.hms.ads.gj
    public void Code(gl glVar, int i, String str) {
        if (glVar == null) {
            return;
        }
        Code(glVar.Code() + glVar.V());
        if (this.Code != null) {
            this.Code.Code(glVar, i, str);
        }
    }
}
