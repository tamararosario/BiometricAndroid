package com.tamararosario.biometrics;

import com.parse.Parse;
/**
 * Created by tamararosario on 6/2/17.
 */


public class Application extends android.app.Application {

    @Override
    public void onCreate (){
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hTiW0gYLeqtDSL3KajUJg50DkR2E0SndTWUQpYj9")
                .clientKey("eOthtIZP5t5SX6yO0Mqw5wA7fCCu0IWdf21dz0t7")
                .server("https://parseapi.back4app.com/")
                .build());
    }

}
