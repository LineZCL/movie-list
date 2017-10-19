package com.aline.movielist.helper;

import android.content.Context;
import android.widget.ImageView;

import com.aline.movielist.R;
import com.squareup.picasso.Picasso;

/**
 * This class is responsible for standard image functions.
 *
 * Created by aline on 18/10/2017.
 */
public class ImageHelper {

    // URL PREFIX WHERE IMAGES ARE HOSTED
    private static String URL_IMAGE_DEFAULT = "https://image.tmdb.org/t/p/w185_and_h278_bestv2";


    /**
     * load image by picasso
     * @param imageView
     * @param context
     * @param imageId - Image id coming from service
     */
    public static void loadImage(final ImageView imageView, final Context context, String imageId) {

        String imageUrl = URL_IMAGE_DEFAULT + imageId;
        Picasso.with(context)
                .load(imageUrl)
                .error(R.drawable.no_image_placeholder)
                .placeholder(R.drawable.image_placeholder)
                .into(imageView);
    }
}
