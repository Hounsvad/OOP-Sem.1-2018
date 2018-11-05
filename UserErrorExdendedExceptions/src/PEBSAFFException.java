/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class PEBSAFFException extends RuntimeException{

    public PEBSAFFException() {
        super("Problem Exists Between Screen And Fat Fingers!");
    }

    public PEBSAFFException(String message) {
        super(message);
    }
    
}
