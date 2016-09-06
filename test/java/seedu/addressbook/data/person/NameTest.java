package seedu.addressbook.data.person;

import org.junit.*;

import seedu.addressbook.data.exception.IllegalValueException;

import static org.junit.Assert.*;

public class NameTest {
    private Name name;

    @Before
    public void setup() throws IllegalValueException{
        name = new Name("John Smith");
    }
    
    @Test(expected=NullPointerException.class)
    public void isSimilar_nameIsNull(){
        boolean result = name.isSimilar(null);
        
    }
}
