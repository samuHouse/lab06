package it.unibo.exceptions.fakenetwork.impl;

import java.io.IOException;

public class NetworkException extends IOException {

    NetworkException (String message) {
        System.out.println("Network error: "+message);
    }

    NetworkException () {
        this("no reponse");
    }
    
}
