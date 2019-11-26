package com.exceptions;

import net.bytebuddy.implementation.bytecode.Throw;

import java.io.IOException;

public class propertiesFileAccessException extends IOException {

    public propertiesFileAccessException(String path, Throwable reason) {
        super("Error accessing properties file location: "+path, reason);
    }

    public propertiesFileAccessException(Throwable reason) {
        super("Error accessing properties file location. ", reason);
    }
}
