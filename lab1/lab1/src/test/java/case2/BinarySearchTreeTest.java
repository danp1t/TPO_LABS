package case2;

import com.danp1t.case2.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree();
    }


    @Test
    void testInsertBasic() {
        binarySearchTree.insert("a");
        assertEquals("a", binarySearchTree.print());
    }

    @Test
    void testInsertNumeric() {
        binarySearchTree.insert("1");
        binarySearchTree.insert("12");
        binarySearchTree.insert("123");
        assertEquals("0001 0012 0123", binarySearchTree.print());
    }

    @Test
    void testInsertDuplicate() {
        binarySearchTree.insert("a");
        binarySearchTree.insert("b");
        binarySearchTree.insert("a");
        assertEquals("a a b", binarySearchTree.print());
    }

    @Test
    void testInsertDifferentLength() {
        binarySearchTree.insert("a");
        binarySearchTree.insert("aa");
        binarySearchTree.insert("aaa");
        assertEquals("a aa aaa", binarySearchTree.print());
    }

    @Test
    void testInsertMixedTypes() {
        binarySearchTree.insert("./1,");
        binarySearchTree.insert("abc");
        binarySearchTree.insert("123");
        binarySearchTree.insert("йцу");
        binarySearchTree.insert("中");
        assertEquals("./1, 0123 abc йцу 中", binarySearchTree.print());
    }

    @Test
    void testInsertTooLong() {
        Exception exception = assertThrows(RuntimeException.class, () -> binarySearchTree.insert("12345"));
        assertEquals("Value is too long", exception.getMessage());
    }

    @Test
    void testInsertEmpty() {
        Exception exception = assertThrows(RuntimeException.class, () -> binarySearchTree.insert(""));
        assertEquals("Value is empty", exception.getMessage());
    }

    @Test
    void testFindExisting() {
        binarySearchTree.insert("abc");
        binarySearchTree.insert("help");
        binarySearchTree.insert("123");
        binarySearchTree.insert("he's");
        assertTrue(binarySearchTree.search("help"));
    }

    @Test
    void testFindNonExisting() {
        binarySearchTree.insert("abc");
        binarySearchTree.insert("help");
        binarySearchTree.insert("123");
        binarySearchTree.insert("he's");
        assertFalse(binarySearchTree.search("work"));
    }

    @Test
    void testFindEmptyTree() {
        assertFalse(binarySearchTree.search("sos"));
    }

    @Test
    void testFindNumeric() {
        binarySearchTree.insert("123");
        assertTrue(binarySearchTree.search("123"));
        assertTrue(binarySearchTree.search("0123"));
    }

    @Test
    void testFindAfterDelete() {
        binarySearchTree.insert("a");
        binarySearchTree.insert("b");
        binarySearchTree.delete("a");
        assertFalse(binarySearchTree.search("a"));
        assertTrue(binarySearchTree.search("b"));
    }

    @Test
    void testOnceDelete() {
        binarySearchTree.insert("a");
        binarySearchTree.insert("b");
        binarySearchTree.insert("a");
        binarySearchTree.delete("a");
        assertEquals("a b", binarySearchTree.print());
    }

    @Test
    void testPrintEmpty() {
        assertEquals("", binarySearchTree.print());
    }

    @Test
    void testPrintSorted() {
        binarySearchTree.insert("c");
        binarySearchTree.insert("a");
        binarySearchTree.insert("b");
        assertEquals("a b c", binarySearchTree.print());
    }

    @Test
    void testPrintWithNumbers() {
        binarySearchTree.insert("9");
        binarySearchTree.insert("10");
        binarySearchTree.insert("2");
        assertEquals("0002 0009 0010", binarySearchTree.print());
    }

    @Test
    void testPrintComplex() {
        binarySearchTree.insert("b");
        binarySearchTree.insert("a");
        binarySearchTree.insert("c");
        binarySearchTree.insert("b");
        assertEquals("a b b c", binarySearchTree.print());
    }
}