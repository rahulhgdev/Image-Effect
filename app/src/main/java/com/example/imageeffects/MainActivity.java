package com.example.imageeffects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView myImageView;
    Drawable myFruit;
    Bitmap bitmapImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -- FOR INVERTING IMAGE


        myImageView =  (ImageView) findViewById(R.id.myImageView);
        myFruit = ResourcesCompat.getDrawable(getResources(),R.drawable.appleone,null);   // to save image in myFruit variable
        bitmapImg = ((BitmapDrawable) myFruit).getBitmap();
        Bitmap newPhoto = invertImage(bitmapImg);
        myImageView.setImageBitmap(newPhoto);

       //-- FOR LAYERS
        /*
        Drawable [] layers = new Drawable[2];
        layers[0] = ResourcesCompat.getDrawable(getResources(), R.drawable.appleone,null);
        layers[1] = ResourcesCompat.getDrawable(getResources(),R.drawable.transparents,null);
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        myImageView.setImageDrawable(layerDrawable);  // it is setImageDrawable not setImageBitMap */
    }

// Function for Inverting Image

    public static Bitmap invertImage(Bitmap orignal) {

        Bitmap finalImage = Bitmap.createBitmap(orignal.getWidth(), orignal.getHeight(), orignal.getConfig());

        int A, R, G, B;
        int pixelcolor;
        int height = orignal.getHeight();
        int width = orignal.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixelcolor = orignal.getPixel(x, y);
                A = Color.alpha(pixelcolor);
                R = 255 - Color.red(pixelcolor);
                G = 255 - Color.green(pixelcolor);
                B = 255 - Color.blue(pixelcolor);

                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }
        return finalImage;
    }

}