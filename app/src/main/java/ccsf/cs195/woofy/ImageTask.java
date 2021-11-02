package ccsf.cs195.woofy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.io.IOException;
import java.net.URL;

class ImageTask extends AsyncTask<URL, Void, Bitmap> {
    ImageView imageView;
    public ImageTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {
        Bitmap returnValue = null;
        URL urlAddress = urls[0];
        try {
            returnValue = BitmapFactory.decodeStream(
                    urlAddress.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}