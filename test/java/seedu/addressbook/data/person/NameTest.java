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
}
