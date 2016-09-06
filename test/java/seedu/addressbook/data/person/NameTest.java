package seedu.addressbook.data.person;

import org.junit.*;

import seedu.addressbook.data.exception.IllegalValueException;

import static org.junit.Assert.*;

public class NameTest {
    private Name name;
    
    private Name name1; // John Smith

    @Before
    public void setup() throws IllegalValueException{
        name = new Name("John Smith");
        name1 = new Name("John Smith");
    }
    
    @Test(expected=NullPointerException.class)
    public void isSimilar_nameIsNull(){
        boolean result = name.isSimilar(null);
        
    }
    
    @Test
    public void isSimilar_exactMatch(){
        boolean result = name.isSimilar(name1);
        
        assertTrue("isSimilar: Exact match", result);
    }
}
