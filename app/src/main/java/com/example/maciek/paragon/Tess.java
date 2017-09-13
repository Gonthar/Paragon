package com.example.maciek.paragon;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Maciek on 12.09.2017.
 */

public class Tess {
    private String datapath;
    private TessBaseAPI mTess;
    Context context;

    public Tess(Context context) {
        this.context = context;
        datapath = Environment.getExternalStorageDirectory() + "/ocrctz/";
        File dir = new File(datapath + "/tessdata/");
        File file = new File(datapath + "/tessdata/" + "eng.traineddata");
        if (!file.exists()) {
            Log.d("mylog", "in file doesn't exist");
            dir.mkdirs();
            copyFile(context);
        }
        mTess = new TessBaseAPI();
        String language = "eng";
        mTess.init(datapath, language);
        mTess.setPageSegMode(TessBaseAPI.PageSegMode.PSM_AUTO_ONLY);
    }

    public void stopRecognition() {
        mTess.stop();
    }

    public String getOCRResult(Bitmap bitmap) {
        mTess.setImage(bitmap);
        String result = mTess.getUTF8Text();
        return result;
    }

    public void onDestroy() {
        if (mTess != null) mTess.end();
    }

    private void copyFile(Context context) {
        AssetManager assetManager = context.getAssets();
        try {
            InputStream in = assetManager.open("eng.traineddata");
            OutputStream out = new FileOutputStream(datapath + "/tessdata/" + "eng.traineddata");
            byte[] buffer = new byte[1024];
            int read = in.read(buffer);
            while (read != -1) {
                out.write(buffer, 0, read);
                read = in.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("mylog", "couldn't copy with the following error : "+e.toString());
        }
    }
}
