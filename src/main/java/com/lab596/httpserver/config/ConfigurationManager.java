package com.lab596.httpserver.config;

public class ConfigurationManager {

    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;
    //default configuration constructor
    private ConfigurationManager(){
    }
    //checks to see if there already is a config manager if not makes one using constructor
    public static ConfigurationManager getInstance(){
        if (myConfigurationManager == null){
            myConfigurationManager = new ConfigurationManager();
        }
        return myConfigurationManager;
    }

    //loading a file based on file given
    public void loadConfigurationFile(String filePath){

    }
    //gets the current configuration requested
    public void getCurrentConfiguration(){

    }


}
