package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Email extends Contact{
    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Email(String email, boolean isPrivate) throws IllegalValueException {
    	super("valid@e.mail", "Person emails should be 2 alphanumeric/period strings separated by '@'", "[\\w\\.]+@[\\w\\.]+");
        this.isPrivate = isPrivate;
        email = email.trim();
        if (!isValid(email)) {
            throw new IllegalValueException(this.MESSAGE_CONSTRAINTS);
        }
        this.value = email;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }
}