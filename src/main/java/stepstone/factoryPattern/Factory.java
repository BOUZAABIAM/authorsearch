package stepstone.factoryPattern;


import stepstone.Author;

import java.io.IOException;

public class Factory {
    private AbstractFactoryPattern instance;


    public AbstractFactoryPattern getInstance(String[] args) throws IOException {


        if (args.length == 2){

            instance = new Author(args[0], args[1]);

        }

        return instance;
    }
}
