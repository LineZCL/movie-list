package com.aline.movielist.helper;

import android.content.Context;
import android.widget.ImageView;

import com.aline.movielist.R;
import com.squareup.picasso.Picasso;

/**
 * Created by aline on 18/10/2017.
 */
public class ImageHelper {

    private static String URL_IMAGE_DEFAULT = "https://image.tmdb.org/t/p/w185_and_h278_bestv2";

    public static void loadOriginalImage(final ImageView imageView, final Context context, String imageId) {

        String imageUrl = URL_IMAGE_DEFAULT + imageId;
        Picasso.with(context)
                .load(imageUrl)
                .error(R.drawable.no_image_placeholder)
                .placeholder(R.drawable.image_placeholder)
                .into(imageView);
    }
}
