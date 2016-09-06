package seedu.addressbook.common;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UtilsTest {

    @Test
    public void isAnyNull_noArgs() {
        boolean result = Utils.isAnyNull();

        assertFalse("isAnyNull: No arguments", result);
    }

    @Test
    public void isAnyNull_nonNull() {
        boolean result = Utils.isAnyNull(new Object(), new Object(), new Object());

        assertFalse("isAnyNull: All args are non-null", result);
    }

    @Test
    public void isAnyNull_containsNull() {
        boolean result = Utils.isAnyNull(new Object(), new Object(), null);

        assertTrue("isAnyNull: Contains null", result);
    }

    @Test
    public void elementsAreUnique_emptyCollection() {
        Collection<Object> items = new ArrayList<>();

        boolean result = Utils.elementsAreUnique(items);

        assertTrue("elementsAreUnique: Empty collection", result);
    }

    @Test
    public void elementsAreUnique_containsOneItem() {
        Collection<Object> items = new ArrayList<>();

        items.add(new Object());

        boolean result = Utils.elementsAreUnique(items);

        assertTrue("elementsAreUnique: Contains one item only", result);
    }

    @Test
    public void elementsAreUnique_containsDuplicates() {
        Collection<Object> items = new ArrayList<>();

        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = object1;

        items.add(object1);
        items.add(object2);
        items.add(object3);

        boolean result = Utils.elementsAreUnique(items);

        assertFalse("elementsAreUnique: Contains duplicates", result);
    }

    @Test
    public void elementsAreUnique_containsNoDuplicates() {
        Collection<Object> items = new ArrayList<>();

        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();

        items.add(object1);
        items.add(object2);
        items.add(object3);

        boolean result = Utils.elementsAreUnique(items);

        assertTrue("elementsAreUnique: Contains duplicates", result);
    }

}
