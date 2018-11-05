/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hounsvad
 */
public class CU_NTException extends RuntimeException{

    public CU_NTException() {
        super("Computer User – Non Technical");
    }

    public CU_NTException(String message) {
        super(message);
    }
    
}