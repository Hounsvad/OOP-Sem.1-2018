/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class BIOSException extends RuntimeException{

    public BIOSException() {
        super("Basic Intelligence Operator Subnormal");
    }

    public BIOSException(String message) {
        super(message);
    }
    
}