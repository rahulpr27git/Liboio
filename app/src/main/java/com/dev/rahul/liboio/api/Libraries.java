package com.dev.rahul.liboio.api;

/**
 * Created by rahul on 7/1/18.
 */

public abstract class Libraries {

    private static final String API_KEY = "c548696ba93b4cd359c3d2bd1d235d3a";

    public static String getAPIKey() {
        return API_KEY;
    }

    public static final String MAIN_URL = "https://libraries.io/api/";

    public static final String PLATFORMS = "platforms";

    public static final String SEARCH = "search";

    public static final String DEPENDENCIES = "{platform}/{name}/latest/dependencies";
}
