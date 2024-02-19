package com.example.icm_base_mdp;


//contains all the global variable get from pico
public class MyGlobals {
    private static MyGlobals instance;
    private int global_number;

    //
    public int shutter_time = 0;
    public int max_shutter_time = 60;
    public int motor_time = 0;
    public int max_motor_time = 60;

    private MyGlobals() {
        // Private constructor to prevent instantiation
    }

    public static synchronized MyGlobals getInstance() {
        if (instance == null) {
            instance = new MyGlobals();
        }
        return instance;
    }

    public int get_global_number() {
        return global_number;
    }
    public void set_global_number(int value) {
        this.global_number = value;
    }

}
