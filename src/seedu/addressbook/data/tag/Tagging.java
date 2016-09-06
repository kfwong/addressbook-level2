package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {

    private static final String IS_DELETED = "-";
    private static final String IS_NOT_DELETED = "+";
    
    private Person person;
    private Tag tag;
    private boolean isDeleted;

    public Tagging(Person person, Tag tag) {
        this.person = person;
        this.tag = tag;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public boolean isDeleted(){
        return isDeleted;
    }
    
    public void setDeleted(boolean isDeleted){
        this.isDeleted = isDeleted;
    }
    
    @Override
    public String toString(){
        String deletedSign = isDeleted? IS_DELETED: IS_NOT_DELETED;
        
        return deletedSign + " " + this.getPerson().getName().fullName + " ["+this.getTag().tagName+"]";
    }

}
