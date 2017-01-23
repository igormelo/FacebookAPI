package com.igormelo.myfbapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by root on 23/01/17.
 */

public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    public DownloadImage(ImageView bmImage){
        this.bmImage = bmImage;
    }
    @Override
    protected Bitmap doInBackground(String... params) {
        String urldisplay = params[0];
        Bitmap mIcon11 = null;
        try{
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e){
            Log.e("Error",e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }
    protected void onPostExecute(Bitmap result){
        bmImage.setImageBitmap(result);
    }
}
