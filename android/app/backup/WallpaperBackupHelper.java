package android.app.backup;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Slog;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;

/* loaded from: source-9557208-dex2jar.jar:android/app/backup/WallpaperBackupHelper.class */
public class WallpaperBackupHelper extends FileBackupHelperBase implements BackupHelper {
    private static final boolean DEBUG = false;
    private static final double MAX_HEIGHT_RATIO = 1.35d;
    private static final double MIN_HEIGHT_RATIO = 0.0d;
    private static final boolean REJECT_OUTSIZED_RESTORE = true;
    private static final String TAG = "WallpaperBackupHelper";
    public static final String WALLPAPER_IMAGE_KEY = "/data/data/com.android.settings/files/wallpaper";
    public static final String WALLPAPER_INFO_KEY = "/data/system/wallpaper_info.xml";
    Context mContext;
    double mDesiredMinHeight;
    double mDesiredMinWidth;
    String[] mFiles;
    String[] mKeys;
    public static final String WALLPAPER_IMAGE = new File(Environment.getUserSystemDirectory(0), Context.WALLPAPER_SERVICE).getAbsolutePath();
    public static final String WALLPAPER_INFO = new File(Environment.getUserSystemDirectory(0), "wallpaper_info.xml").getAbsolutePath();
    private static final String STAGE_FILE = new File(Environment.getUserSystemDirectory(0), "wallpaper-tmp").getAbsolutePath();

    public WallpaperBackupHelper(Context context, String[] strArr, String[] strArr2) {
        super(context);
        this.mContext = context;
        this.mFiles = strArr;
        this.mKeys = strArr2;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WallpaperManager wallpaperManager = (WallpaperManager) context.getSystemService(Context.WALLPAPER_SERVICE);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.mDesiredMinWidth = Math.min(point.x, point.y);
        this.mDesiredMinHeight = wallpaperManager.getDesiredMinimumHeight();
        if (this.mDesiredMinHeight <= MIN_HEIGHT_RATIO) {
            this.mDesiredMinHeight = point.y;
        }
    }

    @Override // android.app.backup.BackupHelper
    public void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        performBackup_checked(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2, this.mFiles, this.mKeys);
    }

    @Override // android.app.backup.BackupHelper
    public void restoreEntity(BackupDataInputStream backupDataInputStream) {
        String key = backupDataInputStream.getKey();
        if (isKeyInList(key, this.mKeys)) {
            if (!key.equals(WALLPAPER_IMAGE_KEY)) {
                if (key.equals(WALLPAPER_INFO_KEY)) {
                    writeFile(new File(WALLPAPER_INFO), backupDataInputStream);
                    return;
                }
                return;
            }
            File file = new File(STAGE_FILE);
            if (writeFile(file, backupDataInputStream)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(STAGE_FILE, options);
                double d = this.mDesiredMinHeight / options.outHeight;
                if (options.outWidth < this.mDesiredMinWidth || options.outHeight < this.mDesiredMinWidth || d >= MAX_HEIGHT_RATIO || d <= MIN_HEIGHT_RATIO) {
                    Slog.i(TAG, "Restored image dimensions (w=" + options.outWidth + ", h=" + options.outHeight + ") too far off target (tw=" + this.mDesiredMinWidth + ", th=" + this.mDesiredMinHeight + "); falling back to default wallpaper.");
                    file.delete();
                    return;
                }
                Slog.d(TAG, "Applying restored wallpaper image.");
                file.renameTo(new File(WALLPAPER_IMAGE));
            }
        }
    }

    @Override // android.app.backup.FileBackupHelperBase, android.app.backup.BackupHelper
    public /* bridge */ /* synthetic */ void writeNewStateDescription(ParcelFileDescriptor parcelFileDescriptor) {
        super.writeNewStateDescription(parcelFileDescriptor);
    }
}
