package UtilityServices.CustomExceptions;

import java.io.FileNotFoundException;

public class DataFolderNotFoundException extends FileNotFoundException {

    public DataFolderNotFoundException(String message) {
        super(message);
    }

}
