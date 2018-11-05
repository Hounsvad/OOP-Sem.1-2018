/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class OTAKEException extends RuntimeException{

    public OTAKEException() {
        super("Opinionated Twat. Always Knows Everything");
    }

    public OTAKEException(String message) {
        super(message);
    }
    
}