package UtilityServices.CustomClassLoader;

import Main.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader {

    public Class<?> loadClass (String name) {

        Class<?> loadedClass = findLoadedClass(name);

        if (loadedClass == null) {
            try {
                return super.loadClass(name, false);
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found by standard ClassLoader.");
                return customLoadClass(name);
            }
        }
        System.out.println(Config.YELLOW_COLOUR + "Class has already been loaded!" + Config.RESET_COLOUR);
        return loadedClass;
    }

    private Class<?> customLoadClass(String name) {

        String folder = "ExternalClasses";
        byte[] classAsBytes;

        try (FileInputStream inputStream = new FileInputStream(folder + File.separator + name + ".class")) {
            classAsBytes = inputStream.readAllBytes();
            Class<?> loadedClass =  defineClass(name, classAsBytes, 0, classAsBytes.length);
            System.out.println(Config.YELLOW_COLOUR + "External class loaded by CustomClassLoader: " + loadedClass.getName() + Config.RESET_COLOUR);
            return loadedClass;

        } catch (IOException e) {
            System.out.println("IO exception caught in customLoadClass of CustomClassLoader.");
        }
        return null;
    }

}
