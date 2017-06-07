package com.tamararosario.biometrics;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by tamararosario on 6/2/17.
 */


public class Application extends android.app.Application {

    @Override
    public void onCreate (){
        super.onCreate();

    //public Application(){
       /* Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hTiW0gYLeqtDSL3KajUJg50DkR2E0SndTWUQpYj9")
                .clientKey("eOthtIZP5t5SX6yO0Mqw5wA7fCCu0IWdf21dz0t7")
                .server("https://parseapi.back4app.com/")
                .build());*/

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("8pZECwtWG6qa38VmXtbikMCjjKErnO60Do7sVgpF")
                .clientKey("ktfyRwFsNhN7vb0NMf3xO1NEpLJaEfBk3louo6lo")
                .server("https://parseapi.back4app.com/")
                .build());

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

    }

    public void putAcc(float xA, float yA, float zA){
        ///put("x", xA);
        //put("y", yA);
        //put("z", zA);
    }

}
