package br.edu.univas.ed.domino;

import br.edu.univas.ed.domino.views.Input;
import br.edu.univas.ed.domino.views.Menu;
import br.edu.univas.ed.domino.views.Output;

public class StartApp {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        Menu menu = new Menu(input, output);

        menu.start();
    }
}