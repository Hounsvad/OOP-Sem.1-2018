/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class PEBCAKException extends RuntimeException{

    public PEBCAKException() {
        super("Problem Existed Between Chair And Keyboard");
    }

    public PEBCAKException(String message) {
        super(message);
    }
    
}
