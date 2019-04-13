package Model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class XMLParserTest {
    XMLParser parser = null;

    @Before
    public void initialize(){
        Model model= new Model();
        parser = new XMLParser(model);
    }

    @Test
    public void parseFile() {
//        fail();
    }

    @Test
    public void writeFile() {
//        fail();
    }
}
