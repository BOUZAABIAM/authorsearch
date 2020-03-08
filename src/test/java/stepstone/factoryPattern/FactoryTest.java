package stepstone.factoryPattern;

import org.junit.Test;
import stepstone.Author;

import static org.junit.Assert.*;

public class FactoryTest {

    @Test
    public void getInstance() throws Exception{
        String FIRST_NAME = "FIRST_NAME";
        String LAST_NAME = "LAST_NAME";


        Factory factory = new Factory();

        AbstractFactoryPattern abstractFactoryPattern1 = new Author(FIRST_NAME,LAST_NAME);
        String[] input1 = {"FIRST_NAME","LAST_NAME"};
        assertEquals(abstractFactoryPattern1.getClass(),factory.getInstance(input1).getClass());
    }
}