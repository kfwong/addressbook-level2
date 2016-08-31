package seedu.addressbook.data.person;

public class Contact {
	public final String EXAMPLE;
	public final String MESSAGE_CONSTRAINTS;
	public final String VALIDATION_REGEX;
	
	public String value;
	protected boolean isPrivate;
	
	public Contact(String example, String messageConstraints, String validationRegex){
		EXAMPLE = example;
		MESSAGE_CONSTRAINTS = messageConstraints;
		VALIDATION_REGEX = validationRegex;
	}
	
	public boolean isValid(String test){
		return test.matches(VALIDATION_REGEX);
	}
	
	public boolean isPrivate(){
		return isPrivate;
	}
	
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
	
	
}
