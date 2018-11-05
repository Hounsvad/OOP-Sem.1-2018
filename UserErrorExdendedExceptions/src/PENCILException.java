/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class PENCILException extends RuntimeException{

    public PENCILException() {
        super("Patient Exists, Not Considered Intelligent Life");
    }

    public PENCILException(String message) {
        super(message);
    }
    
}