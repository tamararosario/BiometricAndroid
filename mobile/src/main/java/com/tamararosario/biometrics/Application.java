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
       Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("hTiW0gYLeqtDSL3KajUJg50DkR2E0SndTWUQpYj9")
                .clientKey("eOthtIZP5t5SX6yO0Mqw5wA7fCCu0IWdf21dz0t7")
                .server("https://parseapi.back4app.com/")
                .build());

        /*Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("8pZECwtWG6qa38VmXtbikMCjjKErnO60Do7sVgpF")
                .clientKey("ktfyRwFsNhN7vb0NMf3xO1NEpLJaEfBk3louo6lo")
                .server("https://parseapi.back4app.com/")
                .build());*/
    }

    public void putAcc(float xA, float yA, float zA){
        ParseObject accelerometer = new ParseObject("Accelerometer");
        accelerometer.put("X", xA);
        accelerometer.put("Y", yA);
        accelerometer.put("Z", zA);
        accelerometer.saveInBackground();
    }

    public void putGyr(float xG, float yG, float zG) {
        ParseObject gyroscope = new ParseObject("Gyroscope");
        gyroscope.put("X", xG);
        gyroscope.put("Y", yG);
        gyroscope.put("Z", zG);
        gyroscope.saveInBackground();
    }

    public void putAmbTemp(float temp) {
        ParseObject temperature = new ParseObject("AmbientTemperature");
        temperature.put("temp", temp);
        temperature.saveInBackground();
    }

    public void putProx(float distance) {
        ParseObject proximity = new ParseObject("Proximity");
        proximity.put("distance", distance);
        proximity.saveInBackground();
    }

    public void putLight(float light) {
        ParseObject luminosity = new ParseObject("Light");
        luminosity.put("luminosity", light);
        luminosity.saveInBackground();
    }

    public void putMagnetic(float xM, float yM, float zM) {
        ParseObject magnetic = new ParseObject("MagneticField");
        magnetic.put("X", xM);
        magnetic.put("Y", yM);
        magnetic.put("Z", zM);
        magnetic.saveInBackground();
    }

    public void putGravity(float xGr, float yGr, float zGr) {
        ParseObject gravity = new ParseObject("Gravity");
        gravity.put("X", xGr);
        gravity.put("Y", yGr);
        gravity.put("Z", zGr);
        gravity.saveInBackground();
    }

    public void putLinearAcc(float xL, float yL, float zL) {
        ParseObject linAcc = new ParseObject("LinearAcceleration");
        linAcc.put("X", xL);
        linAcc.put("Y", yL);
        linAcc.put("Z", zL);
        linAcc.saveInBackground();
    }

    public void putPressure(float pressure) {
        ParseObject barometer = new ParseObject("Pressure");
        barometer.put("pressure", pressure);
        barometer.saveInBackground();
    }

    public void putRelativeHumidity(float humidity) {
        ParseObject humid = new ParseObject("Humidity");
        humid.put("humidity", humidity);
        humid.saveInBackground();
    }

    public void putRotationVector(float xR, float yR, float zR) {
        ParseObject rotation = new ParseObject("RotationVector");
        rotation.put("X", xR);
        rotation.put("Y", yR);
        rotation.put("Z", zR);
        rotation.saveInBackground();
    }
}
