package com.richard.lucas.pmugame.Exceptions;

public class NotEnoughPlayerException extends Exception {

    public NotEnoughPlayerException() {
        System.out.println(getText());
    }

    public String getText() {
        return "Il n'y a pas assez de joueur.";
    }
}
