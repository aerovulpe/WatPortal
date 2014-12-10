package me.aerovulpe.watportal.downloaders;

import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import me.aerovulpe.watportal.resources.Resource;
import me.aerovulpe.watportal.resources.WatObjectHandler;

import static me.aerovulpe.watportal.Constants.API_KEY;
import static me.aerovulpe.watportal.Constants.API_KEY_PARAM;
import static me.aerovulpe.watportal.Constants.BASE_URI;


/**
 * Created by Aaron on 17/11/2014.
 */
public class WatDataFetcher {
    private static final WatDataFetcher INSTANCE = new WatDataFetcher();

    private static final String LOG_TAG = WatDataFetcher.class.getSimpleName();

    private List<WatDataDownloader> mDataDownloaders;


    //Restrict instantiation.
    private WatDataFetcher() {
        mDataDownloaders = new ArrayList<>();
    }

    public static WatDataFetcher getInstance() {
        return INSTANCE;
    }

    public void execute(WatObjectHandler watObjectHandler, Resource resource, String... params) {
        String urlStr = buildResourceUri(resource, params).toString();

        WatDataDownloader dataDownloader = new WatDataDownloader(watObjectHandler, resource);
        dataDownloader.execute(urlStr);

        mDataDownloaders.add(dataDownloader);
        Log.v(LOG_TAG, "Built URI = " + urlStr);
    }

    private Uri buildResourceUri(Resource resource, String... params) {
        Uri.Builder uriBuilder = Uri.parse(BASE_URI).buildUpon();
        uriBuilder.appendQueryParameter(API_KEY_PARAM, API_KEY);

        uriBuilder.appendEncodedPath(resource.addParams(params).buildEndpoint());

        return uriBuilder.build();
    }

    public void killDataDownloaders() {
        for (WatDataDownloader mDataDownloader : mDataDownloaders) {
            mDataDownloader.cancel(true);
        }
        mDataDownloaders.clear();
    }

}
