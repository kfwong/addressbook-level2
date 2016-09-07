package seedu.addressbook.data.person;

import org.junit.*;

import seedu.addressbook.data.exception.IllegalValueException;

import static org.junit.Assert.*;

public class NameTest {
    private Name name;
    
    private Name exactMatch; // John K Smith
    private Name onlyFirstName; // John
    private Name onlyLastName; // Smith
    private Name missingMiddleName; // John Smith
    private Name caseSensitivity; //JoHN SmiTH

    @Before
    public void setup() throws IllegalValueException{
        name = new Name("John K Smith");
        exactMatch = new Name("John K Smith");
        onlyFirstName = new Name("John");
        onlyLastName = new Name("Smith");
        missingMiddleName = new Name("John Smith");
        caseSensitivity = new Name("JoHN SmiTH");
    }
    
    @Test(expected=NullPointerException.class)
    public void isSimilar_nameIsNull(){
        boolean result = name.isSimilar(null);
        
    }
    
    @Test
    public void isSimilar_exactMatch(){
        boolean result = name.isSimilar(exactMatch);
        
        assertTrue("isSimilar: Exact match", result);
    }
    
    @Test
    public void isSimilar_onlyFirstName(){
        boolean result = name.isSimilar(onlyFirstName);
        
        assertTrue("isSimilar: Only first name", result);
    }
    
    @Test
    public void isSimilar_onlyLastName(){
        boolean result = name.isSimilar(onlyLastName);
        
        assertTrue("isSimilar: Only last name", result);
    }
    
    @Test
    public void isSimilar_missingMiddleName(){
        boolean result = name.isSimilar(missingMiddleName);
        
        assertTrue("isSimilar: Missing middle name", result);
    }
    
    @Test
    public void isSimilar_caseSensitivity(){
        boolean result = name.isSimilar(caseSensitivity);
        
        assertTrue("isSimilar: Case sensitivity", result);
    }
}
