/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class WOCException extends RuntimeException{

    public WOCException() {
        super("Waste Of Carbon");
    }

    public WOCException(String message) {
        super(message);
    }
    
}