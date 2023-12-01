package skin.support.load;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import skin.support.utils.SkinFileUtils;

/* loaded from: source-3503164-dex2jar.jar:skin/support/load/SkinAssetsLoader.class */
public class SkinAssetsLoader extends SkinSDCardLoader {
    private String c(Context context, String str) {
        String absolutePath = new File(SkinFileUtils.a(context), str).getAbsolutePath();
        try {
            AssetManager assets = context.getAssets();
            InputStream open = assets.open("skins" + File.separator + str);
            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read == -1) {
                    fileOutputStream.close();
                    open.close();
                    return absolutePath;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return absolutePath;
        }
    }

    @Override // skin.support.load.SkinSDCardLoader, skin.support.SkinCompatManager.SkinLoaderStrategy
    public String a(Context context, String str, int i) {
        return null;
    }

    @Override // skin.support.load.SkinSDCardLoader
    protected String b(Context context, String str) {
        return c(context, str);
    }

    @Override // skin.support.SkinCompatManager.SkinLoaderStrategy
    public int getType() {
        return 0;
    }
}
