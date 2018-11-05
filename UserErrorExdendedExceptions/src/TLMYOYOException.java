/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class TLMYOYOException extends RuntimeException{

    public TLMYOYOException() {
        super("Tough Luck Mate, You're On Your Own");
    }

    public TLMYOYOException(String message) {
        super(message);
    }
    
}