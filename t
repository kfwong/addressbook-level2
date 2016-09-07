[1mdiff --git a/src/seedu/addressbook/data/person/Name.java b/src/seedu/addressbook/data/person/Name.java[m
[1mindex f8bf605..2db000e 100644[m
[1m--- a/src/seedu/addressbook/data/person/Name.java[m
[1m+++ b/src/seedu/addressbook/data/person/Name.java[m
[36m@@ -40,7 +40,10 @@[m [mpublic class Name {[m
     }[m
 [m
     public boolean isSimilar(Name other){[m
[31m-        Pattern pattern = Pattern.compile("\\b(John|Smith|K)\\b", Pattern.CASE_INSENSITIVE);[m
[32m+[m[32m        String wordList = this.fullName.replaceAll("[\\p{P}\\s]+", "|");[m
[32m+[m[32m        System.out.println(wordList);[m
[32m+[m[41m        [m
[32m+[m[32m        Pattern pattern = Pattern.compile("\\b("+wordList+")\\b", Pattern.CASE_INSENSITIVE);[m
         Matcher matcher = pattern.matcher(other.fullName);[m
         [m
         return matcher.find();[m
[1mdiff --git a/test/java/seedu/addressbook/data/person/NameTest.java b/test/java/seedu/addressbook/data/person/NameTest.java[m
[1mindex 0f7dce8..c182a26 100644[m
[1m--- a/test/java/seedu/addressbook/data/person/NameTest.java[m
[1m+++ b/test/java/seedu/addressbook/data/person/NameTest.java[m
[36m@@ -8,61 +8,70 @@[m [mimport static org.junit.Assert.*;[m
 [m
 public class NameTest {[m
     private Name name;[m
[31m-    [m
[32m+[m
     private Name exactMatch; // John K Smith[m
     private Name onlyFirstName; // John[m
     private Name onlyLastName; // Smith[m
     private Name missingMiddleName; // John Smith[m
[31m-    private Name caseSensitivity; //JoHN SmiTH[m
[32m+[m[32m    private Name caseSensitivity; // JoHN SmiTH[m
[32m+[m[32m    private Name differentOrder; // K Smith John[m
 [m
     @Before[m
[31m-    public void setup() throws IllegalValueException{[m
[32m+[m[32m    public void setup() throws IllegalValueException {[m
         name = new Name("John K Smith");[m
         exactMatch = new Name("John K Smith");[m
         onlyFirstName = new Name("John");[m
         onlyLastName = new Name("Smith");[m
         missingMiddleName = new Name("John Smith");[m
         caseSensitivity = new Name("JoHN SmiTH");[m
[32m+[m[32m        differentOrder = new Name("K Smith John");[m
     }[m
[31m-    [m
[31m-    @Test(expected=NullPointerException.class)[m
[31m-    public void isSimilar_nameIsNull(){[m
[32m+[m
[32m+[m[32m    @Test(expected = NullPointerException.class)[m
[32m+[m[32m    public void isSimilar_nameIsNull() {[m
         boolean result = name.isSimilar(null);[m
[31m-        [m
[32m+[m
     }[m
[31m-    [m
[32m+[m
     @Test[m
[31m-    public void isSimilar_exactMatch(){[m
[32m+[m[32m    public void isSimilar_exactMatch() {[m
         boolean result = name.isSimilar(exactMatch);[m
[31m-        [m
[32m+[m
         assertTrue("isSimilar: Exact match", result);[m
     }[m
[31m-    [m
[32m+[m
     @Test[m
[31m-    public void isSimilar_onlyFirstName(){[m
[32m+[m[32m    public void isSimilar_onlyFirstName() {[m
         boolean result = name.isSimilar(onlyFirstName);[m
[31m-        [m
[32m+[m
         assertTrue("isSimilar: Only first name", result);[m
     }[m
[31m-    [m
[32m+[m
     @Test[m
[31m-    public void isSimilar_onlyLastName(){[m
[32m+[m[32m    public void isSimilar_onlyLastName() {[m
         boolean result = name.isSimilar(onlyLastName);[m
[31m-        [m
[32m+[m
         assertTrue("isSimilar: Only last name", result);[m
     }[m
[31m-    [m
[32m+[m
     @Test[m
[31m-    public void isSimilar_missingMiddleName(){[m
[32m+[m[32m    public void isSimilar_missingMiddleName() {[m
         boolean result = name.isSimilar(missingMiddleName);[m
[31m-        [m
[32m+[m
         assertTrue("isSimilar: Missing middle name", result);[m
     }[m
[31m-    [m
[32m+[m
     @Test[m
[31m-    public void isSimilar_caseSensitivity(){[m
[32m+[m[32m    public void isSimilar_caseSensitivity() {[m
         boolean result = name.isSimilar(caseSensitivity);[m
[31m-        [m
[32m+[m
         assertTrue("isSimilar: Case sensitivity", result);[m
     }[m
[32m+[m
[32m+[m[32m    @Test[m
[32m+[m[32m    public void isSimilar_differentOrder() {[m
[32m+[m[32m        boolean result = name.isSimilar(differentOrder);[m
[32m+[m
[32m+[m[32m        assertTrue("isSimilar: Different order", result);[m
[32m+[m[32m    }[m
 }[m
