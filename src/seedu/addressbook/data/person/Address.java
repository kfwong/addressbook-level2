package seedu.addressbook.data.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact{    

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
	
	public Address(String address, boolean isPrivate)throws IllegalValueException{
		super("123, Clementi Ave 3, #12-34, 231534", "Person addresses must be in format: BLOCK, STREET, UNIT, POSTAL_CODE", "(\\w+)(, ([^,]+)?(, ([^,]+)?(, (\\d+))?)?)?");
		
		Pattern r = Pattern.compile(VALIDATION_REGEX);
		Matcher m = r.matcher(address);
		
		
		if(m.find()){
			// m.group(0) is the original string
			this.block = new Block(m.group(1)); 
			this.street = new Street(m.group(3));
			this.unit = new Unit(m.group(5));
			this.postalCode = new PostalCode(m.group(7));
			
			this.isPrivate = isPrivate;
			
		}else{
			throw new IllegalValueException(MESSAGE_CONSTRAINTS);
		}
		
	}
	
	public Address(Block block, Street street, Unit unit, PostalCode postalCode){
		super("123, Clementi Ave 3, #12-34, 231534", "Person addresses must be in format: BLOCK, STREET, UNIT, POSTAL_CODE", "(\\w+)(, ([^,]+)?(, ([^,]+)?(, (\\d+))?)?)?");
		this.block = block;
		this.street = street;
		this.unit = unit;
		this.postalCode = postalCode;
	}

	/**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(Block block, Street street, Unit unit, PostalCode postalCode, boolean isPrivate) throws IllegalValueException {
    	this(block, street, unit, postalCode);
        this.isPrivate = isPrivate;
        
        if (!isValid(this.toString())) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }
    }

    @Override
    public String toString() {
    	String result = block.getValue();
    	
    	result += street.getValue() == null? "": ", "+street.getValue();
    	result += unit.getValue()==null?"":", "+unit.getValue();
    	result += postalCode.getValue()== null? "": ", "+postalCode.getValue();   
    	
        return result;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public Block getBlock() {
		return block;
	}

	public Street getStreet() {
		return street;
	}

	public Unit getUnit() {
		return unit;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}
}