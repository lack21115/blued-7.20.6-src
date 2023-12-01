package com.android.internal.backup;

import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupTransport;
import android.app.backup.RestoreDescription;
import android.app.backup.RestoreSet;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.SELinux;
import android.util.Log;
import com.android.org.bouncycastle.util.encoders.Base64;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import libcore.io.IoUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/backup/LocalTransport.class */
public class LocalTransport extends BackupTransport {
    private static final long CURRENT_SET_TOKEN = 1;
    private static final boolean DEBUG = false;
    private static final String FULL_DATA_DIR = "_full";
    private static final String INCREMENTAL_DIR = "_delta";
    static final long[] POSSIBLE_SETS = {2, 3, 4, 5, 6, 7, 8, 9};
    private static final String TAG = "LocalTransport";
    private static final String TRANSPORT_DATA_MANAGEMENT_LABEL = "";
    private static final String TRANSPORT_DESTINATION_STRING = "Backing up to debug-only private cache";
    private static final String TRANSPORT_DIR_NAME = "com.android.internal.backup.LocalTransport";
    private Context mContext;
    private FileInputStream mCurFullRestoreStream;
    private byte[] mFullBackupBuffer;
    private BufferedOutputStream mFullBackupOutputStream;
    private byte[] mFullRestoreBuffer;
    private HashSet<String> mFullRestorePackages;
    private File mFullRestoreSetDir;
    private FileOutputStream mFullRestoreSocketStream;
    private String mFullTargetPackage;
    private File mRestoreSetDir;
    private File mRestoreSetFullDir;
    private File mRestoreSetIncrementalDir;
    private long mRestoreToken;
    private int mRestoreType;
    private ParcelFileDescriptor mSocket;
    private FileInputStream mSocketInputStream;
    private File mDataDir = new File(Environment.getDownloadCacheDirectory(), Context.BACKUP_SERVICE);
    private File mCurrentSetDir = new File(this.mDataDir, Long.toString(1));
    private File mCurrentSetIncrementalDir = new File(this.mCurrentSetDir, INCREMENTAL_DIR);
    private File mCurrentSetFullDir = new File(this.mCurrentSetDir, FULL_DATA_DIR);
    private PackageInfo[] mRestorePackages = null;
    private int mRestorePackage = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/backup/LocalTransport$DecodedFilename.class */
    public static class DecodedFilename implements Comparable<DecodedFilename> {
        public File file;
        public String key;

        public DecodedFilename(File file) {
            this.file = file;
            this.key = new String(Base64.decode(file.getName()));
        }

        @Override // java.lang.Comparable
        public int compareTo(DecodedFilename decodedFilename) {
            return this.key.compareTo(decodedFilename.key);
        }
    }

    public LocalTransport(Context context) {
        this.mContext = context;
        this.mCurrentSetDir.mkdirs();
        this.mCurrentSetFullDir.mkdir();
        this.mCurrentSetIncrementalDir.mkdir();
        if (SELinux.restorecon(this.mCurrentSetDir)) {
            return;
        }
        Log.e(TAG, "SELinux restorecon failed for " + this.mCurrentSetDir);
    }

    private ArrayList<DecodedFilename> contentsByKey(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        ArrayList<DecodedFilename> arrayList = new ArrayList<>();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Collections.sort(arrayList);
                return arrayList;
            }
            arrayList.add(new DecodedFilename(listFiles[i2]));
            i = i2 + 1;
        }
    }

    private void deleteContents(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file2 = listFiles[i2];
            if (file2.isDirectory()) {
                deleteContents(file2);
            }
            file2.delete();
            i = i2 + 1;
        }
    }

    private void resetFullRestoreState() {
        IoUtils.closeQuietly(this.mCurFullRestoreStream);
        this.mCurFullRestoreStream = null;
        this.mFullRestoreSocketStream = null;
        this.mFullRestoreBuffer = null;
    }

    private File tarballFile(String str) {
        return new File(this.mCurrentSetFullDir, str);
    }

    private int tearDownFullBackup() {
        if (this.mSocket != null) {
            try {
                this.mFullBackupOutputStream.flush();
                this.mFullBackupOutputStream.close();
                this.mSocketInputStream = null;
                this.mFullTargetPackage = null;
                this.mSocket.close();
                this.mSocket = null;
                return 0;
            } catch (IOException e) {
                this.mSocket = null;
                return -1000;
            } catch (Throwable th) {
                this.mSocket = null;
                throw th;
            }
        }
        return 0;
    }

    @Override // android.app.backup.BackupTransport
    public int abortFullRestore() {
        if (this.mRestoreType != 2) {
            throw new IllegalStateException("abortFullRestore() but not currently restoring");
        }
        resetFullRestoreState();
        this.mRestoreType = 0;
        return 0;
    }

    @Override // android.app.backup.BackupTransport
    public void cancelFullBackup() {
        File tarballFile = tarballFile(this.mFullTargetPackage);
        tearDownFullBackup();
        if (tarballFile.exists()) {
            tarballFile.delete();
        }
    }

    @Override // android.app.backup.BackupTransport
    public int clearBackupData(PackageInfo packageInfo) {
        File file = new File(this.mCurrentSetIncrementalDir, packageInfo.packageName);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                listFiles[i2].delete();
                i = i2 + 1;
            }
            file.delete();
        }
        File file2 = new File(this.mCurrentSetFullDir, packageInfo.packageName);
        File[] listFiles2 = file2.listFiles();
        if (listFiles2 == null) {
            return 0;
        }
        int length2 = listFiles2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                file2.delete();
                return 0;
            }
            listFiles2[i4].delete();
            i3 = i4 + 1;
        }
    }

    @Override // android.app.backup.BackupTransport
    public Intent configurationIntent() {
        return null;
    }

    @Override // android.app.backup.BackupTransport
    public String currentDestinationString() {
        return TRANSPORT_DESTINATION_STRING;
    }

    @Override // android.app.backup.BackupTransport
    public Intent dataManagementIntent() {
        return null;
    }

    @Override // android.app.backup.BackupTransport
    public String dataManagementLabel() {
        return "";
    }

    @Override // android.app.backup.BackupTransport
    public int finishBackup() {
        return tearDownFullBackup();
    }

    @Override // android.app.backup.BackupTransport
    public void finishRestore() {
        if (this.mRestoreType == 2) {
            resetFullRestoreState();
        }
        this.mRestoreType = 0;
    }

    @Override // android.app.backup.BackupTransport
    public RestoreSet[] getAvailableRestoreSets() {
        long[] jArr;
        long[] jArr2 = new long[POSSIBLE_SETS.length + 1];
        int i = 0;
        for (long j : POSSIBLE_SETS) {
            if (new File(this.mDataDir, Long.toString(j)).exists()) {
                jArr2[i] = j;
                i++;
            }
        }
        jArr2[i] = 1;
        RestoreSet[] restoreSetArr = new RestoreSet[i + 1];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= restoreSetArr.length) {
                return restoreSetArr;
            }
            restoreSetArr[i3] = new RestoreSet("Local disk image", "flash", jArr2[i3]);
            i2 = i3 + 1;
        }
    }

    @Override // android.app.backup.BackupTransport
    public long getCurrentRestoreSet() {
        return 1L;
    }

    @Override // android.app.backup.BackupTransport
    public int getNextFullRestoreDataChunk(ParcelFileDescriptor parcelFileDescriptor) {
        if (this.mRestoreType != 2) {
            throw new IllegalStateException("Asked for full restore data for non-stream package");
        }
        if (this.mCurFullRestoreStream == null) {
            String str = this.mRestorePackages[this.mRestorePackage].packageName;
            try {
                this.mCurFullRestoreStream = new FileInputStream(new File(this.mRestoreSetFullDir, str));
                this.mFullRestoreSocketStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                this.mFullRestoreBuffer = new byte[2048];
            } catch (IOException e) {
                Log.e(TAG, "Unable to read archive for " + str);
                return -1002;
            }
        }
        try {
            int read = this.mCurFullRestoreStream.read(this.mFullRestoreBuffer);
            if (read < 0) {
                return -1;
            }
            if (read == 0) {
                Log.w(TAG, "read() of archive file returned 0; treating as EOF");
                return -1;
            }
            this.mFullRestoreSocketStream.write(this.mFullRestoreBuffer, 0, read);
            return read;
        } catch (IOException e2) {
            return -1000;
        }
    }

    @Override // android.app.backup.BackupTransport
    public int getRestoreData(ParcelFileDescriptor parcelFileDescriptor) {
        if (this.mRestorePackages == null) {
            throw new IllegalStateException("startRestore not called");
        }
        if (this.mRestorePackage < 0) {
            throw new IllegalStateException("nextRestorePackage not called");
        }
        if (this.mRestoreType != 1) {
            throw new IllegalStateException("getRestoreData(fd) for non-key/value dataset");
        }
        File file = new File(this.mRestoreSetIncrementalDir, this.mRestorePackages[this.mRestorePackage].packageName);
        ArrayList<DecodedFilename> contentsByKey = contentsByKey(file);
        if (contentsByKey == null) {
            Log.e(TAG, "No keys for package: " + file);
            return -1000;
        }
        BackupDataOutput backupDataOutput = new BackupDataOutput(parcelFileDescriptor.getFileDescriptor());
        try {
            Iterator<DecodedFilename> it = contentsByKey.iterator();
            while (it.hasNext()) {
                DecodedFilename next = it.next();
                File file2 = next.file;
                FileInputStream fileInputStream = new FileInputStream(file2);
                int length = (int) file2.length();
                byte[] bArr = new byte[length];
                fileInputStream.read(bArr);
                backupDataOutput.writeEntityHeader(next.key, length);
                backupDataOutput.writeEntityData(bArr, length);
                fileInputStream.close();
            }
            return 0;
        } catch (IOException e) {
            Log.e(TAG, "Unable to read backup records", e);
            return -1000;
        }
    }

    @Override // android.app.backup.BackupTransport
    public int initializeDevice() {
        deleteContents(this.mCurrentSetDir);
        return 0;
    }

    @Override // android.app.backup.BackupTransport
    public String name() {
        return new ComponentName(this.mContext, getClass()).flattenToShortString();
    }

    @Override // android.app.backup.BackupTransport
    public RestoreDescription nextRestorePackage() {
        String str;
        boolean z;
        if (this.mRestorePackages == null) {
            throw new IllegalStateException("startRestore not called");
        }
        boolean z2 = false;
        do {
            int i = this.mRestorePackage + 1;
            this.mRestorePackage = i;
            if (i >= this.mRestorePackages.length) {
                return RestoreDescription.NO_MORE_PACKAGES;
            }
            str = this.mRestorePackages[this.mRestorePackage].packageName;
            String[] list = new File(this.mRestoreSetIncrementalDir, str).list();
            boolean z3 = z2;
            if (list != null) {
                z3 = z2;
                if (list.length > 0) {
                    this.mRestoreType = 1;
                    z3 = true;
                }
            }
            z = z3;
            if (!z3) {
                z = z3;
                if (new File(this.mRestoreSetFullDir, str).length() > 0) {
                    this.mRestoreType = 2;
                    this.mCurFullRestoreStream = null;
                    z = true;
                }
            }
            z2 = z;
        } while (!z);
        return new RestoreDescription(str, this.mRestoreType);
    }

    @Override // android.app.backup.BackupTransport
    public int performBackup(PackageInfo packageInfo, ParcelFileDescriptor parcelFileDescriptor) {
        File file = new File(this.mCurrentSetIncrementalDir, packageInfo.packageName);
        file.mkdirs();
        BackupDataInput backupDataInput = new BackupDataInput(parcelFileDescriptor.getFileDescriptor());
        int i = 512;
        try {
            byte[] bArr = new byte[512];
            while (backupDataInput.readNextHeader()) {
                File file2 = new File(file, new String(Base64.encode(backupDataInput.getKey().getBytes())));
                int dataSize = backupDataInput.getDataSize();
                if (dataSize >= 0) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    int i2 = i;
                    if (dataSize > i) {
                        i2 = dataSize;
                        bArr = new byte[i2];
                    }
                    backupDataInput.readEntityData(bArr, 0, dataSize);
                    try {
                        fileOutputStream.write(bArr, 0, dataSize);
                        fileOutputStream.close();
                        i = i2;
                    } catch (IOException e) {
                        Log.e(TAG, "Unable to update key file " + file2.getAbsolutePath());
                        fileOutputStream.close();
                        return -1000;
                    }
                } else {
                    file2.delete();
                }
            }
            return 0;
        } catch (IOException e2) {
            Log.v(TAG, "Exception reading backup input:", e2);
            return -1000;
        }
    }

    @Override // android.app.backup.BackupTransport
    public int performFullBackup(PackageInfo packageInfo, ParcelFileDescriptor parcelFileDescriptor) {
        if (this.mSocket != null) {
            Log.e(TAG, "Attempt to initiate full backup while one is in progress");
            return -1000;
        }
        try {
            this.mSocket = ParcelFileDescriptor.dup(parcelFileDescriptor.getFileDescriptor());
            this.mSocketInputStream = new FileInputStream(this.mSocket.getFileDescriptor());
            this.mFullTargetPackage = packageInfo.packageName;
            try {
                this.mFullBackupOutputStream = new BufferedOutputStream(new FileOutputStream(tarballFile(this.mFullTargetPackage)));
                this.mFullBackupBuffer = new byte[4096];
                return 0;
            } catch (FileNotFoundException e) {
                return -1000;
            }
        } catch (IOException e2) {
            Log.e(TAG, "Unable to process socket for full backup");
            return -1000;
        }
    }

    @Override // android.app.backup.BackupTransport
    public long requestBackupTime() {
        return 0L;
    }

    @Override // android.app.backup.BackupTransport
    public long requestFullBackupTime() {
        return 0L;
    }

    @Override // android.app.backup.BackupTransport
    public int sendBackupData(int i) {
        if (this.mFullBackupBuffer == null) {
            Log.w(TAG, "Attempted sendBackupData before performFullBackup");
            return -1000;
        }
        int i2 = i;
        if (i > this.mFullBackupBuffer.length) {
            this.mFullBackupBuffer = new byte[i];
            i2 = i;
        }
        while (i2 > 0) {
            try {
                int read = this.mSocketInputStream.read(this.mFullBackupBuffer, 0, i2);
                if (read < 0) {
                    Log.w(TAG, "Unexpected EOD; failing backup");
                    return -1000;
                }
                this.mFullBackupOutputStream.write(this.mFullBackupBuffer, 0, read);
                i2 -= read;
            } catch (IOException e) {
                Log.e(TAG, "Error handling backup data for " + this.mFullTargetPackage);
                return -1000;
            }
        }
        return 0;
    }

    @Override // android.app.backup.BackupTransport
    public int startRestore(long j, PackageInfo[] packageInfoArr) {
        this.mRestorePackages = packageInfoArr;
        this.mRestorePackage = -1;
        this.mRestoreToken = j;
        this.mRestoreSetDir = new File(this.mDataDir, Long.toString(j));
        this.mRestoreSetIncrementalDir = new File(this.mRestoreSetDir, INCREMENTAL_DIR);
        this.mRestoreSetFullDir = new File(this.mRestoreSetDir, FULL_DATA_DIR);
        return 0;
    }

    @Override // android.app.backup.BackupTransport
    public String transportDirName() {
        return TRANSPORT_DIR_NAME;
    }
}
