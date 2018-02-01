package com.faq.match;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Miracle on 2016/7/25.
 */
public class NameMate {
    private static NameMate Instance;
    public final String TAG = "NameMate";

    public NameMate(Context context) {
        Copy(context);
    }

    public void init(Context context, String res) {
        try {
            long time = System.currentTimeMillis();
            Log.i(TAG, "Namemate----" + time + "ms");
            String delimiter = "#";
            int result = TextMatch.textInitial(context.getExternalFilesDir(null).getAbsolutePath()+"/ModelFile", res, delimiter, 0);
            Log.i(TAG, "NameMate init result---" + result);
            if (result == 0) {
                Log.e(TAG, "NameMate lib Init Fail");
            }
            Log.i(TAG, "NameMate init time ---- " + (System.currentTimeMillis() - time) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static NameMate getInstance(Context context) {
        if (Instance == null) {
            synchronized (NameMate.class) {
                if (Instance == null) {
                    Instance = new NameMate(context);
                }
            }
        }
        return Instance;
    }

    /**
     * @param WordStr     the match text
         * @param ShouldScore q
     * @param ReturnLenth the number of result list
     * @return
     */
    public String[] TextScore(String WordStr, int ReturnLenth, int ShouldScore) {

        String[] result = new String[ReturnLenth];
        int ret = TextMatch.textScore(WordStr, result, ShouldScore);
        Log.e("NameMate", "NameMate.textScore---" + ret
                + "\nThreadId---" + Thread.currentThread().getId());
        return result;
    }

    public void setFree() {
        TextMatch.freeInstance();
    }

    /**
     * copy the modelFile in assets
     * @param context
     */
    private void Copy(Context context) {
        String FilePath = context.getExternalFilesDir(null).getAbsolutePath() + "/ModelFile";
        Log.i(TAG, "Copy: " + FilePath);
        File file = new File(FilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            CopyAssestTodir(context, FilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void CopyAssestToFile(Context context, String Filename, String fileDir) throws IOException {
        InputStream is = context.getAssets().open(Filename);
        File file = new File(fileDir + "/" + Filename);
        if (file.exists()) {
            return;
        } else {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] bt = new byte[is.available()];
        is.read(bt);
        fos.write(bt, 0, bt.length);
        is.close();
        fos.close();
    }

    private void CopyAssestTodir(Context context, String dirname) throws IOException {
        String[] childen = new String[]{
        "Dictionary.txt",  "PYDicMap.txt", "VaguePY.txt"
        };
        for (String child : childen) {
            CopyAssestToFile(context, child, dirname);
        }
    }
}
