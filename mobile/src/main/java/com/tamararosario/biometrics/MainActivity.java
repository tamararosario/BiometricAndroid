package com.tamararosario.biometrics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import android.hardware.Sensor;

public class MainActivity extends AppCompatActivity {

    SensorManager sm = null;
    TextView accText = null;
    TextView gyrText = null;
    TextView tempText = null;
    TextView proxText = null;
    TextView lightText = null;
    TextView magText = null;
    TextView gravText = null;
    TextView linAccText = null;
    TextView pressText = null;
    TextView humText = null;
    TextView rotText = null;

    /* This responds to sensor events */
    SensorEventListener sel = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
			/* Isn't required for this example */

        }
        public void onSensorChanged(SensorEvent event) {
			/* Write the accelerometer values to the TextView */
            //float[] values = event.values;
            //accText.setText("x: "+values[0]+"\ny: "+values[1]+"\nz: "+values[2]);
            synchronized (this){
                switch (event.sensor.getType()) {
                    case Sensor.TYPE_ACCELEROMETER:
                    /* Get the Measures the acceleration force in m/s2 that is applied to a device
                    on all three physical axes (x, y, and z), including the force of gravity.*/
                        float xA = event.values[0];
                        float yA = event.values[1];
                        float zA = event.values[2];
                        String accelerationOut = String.format("X: %.2f Y: %.2f Z: %.2f", xA, yA, zA);
                        accText.setText(accelerationOut);
                        break;
                    case Sensor.TYPE_GYROSCOPE:
                        // Measures a device's rate of rotation in rad/s around each of the three physical axes (x, y, and z)
                        float xG = event.values[0];
                        float yG = event.values[1];
                        float zG = event.values[2];
                        String gyroscopeOut = String.format("X: %.2f Y: %.2f Z: %.2f", xG, yG, zG);
                        gyrText.setText(gyroscopeOut);
                        break;
                    case Sensor.TYPE_AMBIENT_TEMPERATURE:
                        float temp = event.values[0];
                        String tempOut = String.format("%.2f C", temp);
                        tempText.setText(tempOut);
                        break;
                    case Sensor.TYPE_PROXIMITY:
                        // Measures the proximity of an object in cm relative to the view screen of a device.
                        float distance = event.values[0];
                        String proximityOut = String.format("%.2f cm", distance);
                        proxText.setText(proximityOut);
                        break;
                    case Sensor.TYPE_LIGHT:
                        // Measures the ambient light level (illumination) in lx.
                        float ligth = event.values[0];
                        String lumninoxityOut = String.format("%.2f lx", ligth);
                        lightText.setText(lumninoxityOut);
                        break;
                    case Sensor.TYPE_MAGNETIC_FIELD:
                        //Measures the ambient geomagnetic field for all three physical axes (x, y, z) in mircoT.
                        float xM = event.values[0];
                        float yM = event.values[1];
                        float zM = event.values[2];
                        String magneticfiedlOut = String.format("X: %.2f Y: %.2f Z: %.2f", xM, yM, zM);
                        magText.setText(magneticfiedlOut);
                        break;
                    case Sensor.TYPE_GRAVITY:
                        //Measures the ambient geomagnetic field for all three physical axes (x, y, z) in mircoT.
                        float xGr = event.values[0];
                        float yGr = event.values[1];
                        float zGr = event.values[2];
                        String gravityOut = String.format("X: %.2f Y: %.2f Z: %.2f", xGr, yGr, zGr);
                        gravText.setText(gravityOut);
                        break;
                    case Sensor.TYPE_LINEAR_ACCELERATION:
                        //Measures the ambient geomagnetic field for all three physical axes (x, y, z) in mircoT.
                        float xL = event.values[0];
                        float yL = event.values[1];
                        float zL = event.values[2];
                        String linAccOut = String.format("X: %.2f Y: %.2f Z: %.2f", xL, yL, zL);
                        linAccText.setText(linAccOut);
                        break;
                    case Sensor.TYPE_PRESSURE:
                        //Measures the ambient geomagnetic field for all three physical axes (x, y, z) in mircoT.
                        float pressure = event.values[0];
                        String pressureOut = String.format("%.2f hPA", pressure);
                        pressText.setText(pressureOut);
                        break;
                    case Sensor.TYPE_RELATIVE_HUMIDITY:
                        //Measures the ambient geomagnetic field for all three physical axes (x, y, z) in mircoT.
                        float humidity = event.values[0];
                        String humidOut = String.format("%.2f%", humidity);
                        humText.setText(humidOut);
                        break;
                    case Sensor.TYPE_ROTATION_VECTOR:
                        //Measures the ambient geomagnetic field for all three physical axes (x, y, z) in mircoT.
                        float xR = event.values[0];
                        float yR = event.values[1];
                        float zR = event.values[2];
                        String rotOut = String.format("X: %.2f Y: %.2f Z: %.2f", xR, yR, zR);
                        rotText.setText(rotOut);
                        break;
                }
            }
        }
    };

    /* Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Get a SensorManager instance */
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        //List<Sensor> deviceSensors = sm.getSensorList(Sensor.TYPE_ALL);


        /* This corresponds to a TextView element in main.xml with android:id="@+id/accText" */
        accText = (TextView)findViewById(R.id.textView1);
        gyrText = (TextView)findViewById(R.id.textView2);
        tempText = (TextView)findViewById(R.id.textView3);
        proxText = (TextView)findViewById(R.id.textView4);
        lightText = (TextView)findViewById(R.id.textView5);
        magText = (TextView)findViewById(R.id.textView6);
        gravText = (TextView)findViewById(R.id.textView7);
        linAccText = (TextView)findViewById(R.id.textView8);
        pressText = (TextView)findViewById(R.id.textView9);
        humText = (TextView)findViewById(R.id.textView10);
        rotText = (TextView)findViewById(R.id.textView11);



        /* Get list of accelerometers */
        //list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        //list.add(sm.getSensorList(Sensor.TYPE_GYROSCOPE));
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_GRAVITY), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_NORMAL);






        /* If there are any accelerometers register a listener to the first else
           print a little error message */
        /*if(list.size()>0){
        	sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
			//sm.registerListener(sel, (Sensor) list.get(1), SensorManager.SENSOR_DELAY_NORMAL);
        }else{
        	Toast.makeText(getBaseContext(), "Error: Missing Sensor.", Toast.LENGTH_LONG);
        }*/
    }

    //@Override
    //protected void onStop() {
		/* Always a good idea to unregister, disconnect, close, etc things */
        //if(list.size()>0){
			/* This actually unregisters a listener for all sensors, but it can be done
			   on a sensor by sensor basis */
        //sm.unregisterListener(sel);
        //}
        //super.onStop();
    //}
}
