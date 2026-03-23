package case2;

import com.danp1t.case2.MyHashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void testInsertAndFindLong() {
        MyHashMap map = new MyHashMap();
        assertTrue(map.insert(123L));
        assertTrue(map.find(123L));
        assertFalse(map.find(456L));
    }

    @Test
    void testInsertDuplicateLong() {
        MyHashMap map = new MyHashMap();
        assertTrue(map.insert(123L));
        assertFalse(map.insert(123L));
        assertTrue(map.find(123L));
    }

    @Test
    void testInsertAndFindString() {
        MyHashMap map = new MyHashMap();
        assertTrue(map.insert("hello"));
        assertTrue(map.find("hello"));
        assertFalse(map.find("world"));
    }

    @Test
    void testInsertDuplicateString() {
        MyHashMap map = new MyHashMap();
        assertTrue(map.insert("test"));
        assertFalse(map.insert("test"));
        assertTrue(map.find("test"));
    }

    @Test
    void testDeleteLong() {
        MyHashMap map = new MyHashMap();
        map.insert(100L);
        map.insert(200L);
        assertTrue(map.delete(100L));
        assertFalse(map.find(100L));
        assertTrue(map.find(200L));
        assertFalse(map.delete(100L));
    }

    @Test
    void testDeleteString() {
        MyHashMap map = new MyHashMap();
        map.insert("abc");
        map.insert("def");
        assertTrue(map.delete("abc"));
        assertFalse(map.find("abc"));
        assertTrue(map.find("def"));
        assertFalse(map.delete("abc"));
    }

    @Test
    void testCollision() {
        MyHashMap map = new MyHashMap();
        long a = 0L;
        long b = 13L;
        assertTrue(map.insert(a));
        assertTrue(map.insert(b));
        assertTrue(map.find(a));
        assertTrue(map.find(b));
        assertTrue(map.delete(a));
        assertFalse(map.find(a));
        assertTrue(map.find(b));
    }

    @Test
    void testStringCollision() {
        MyHashMap map = new MyHashMap();
        String s1 = "aa";
        String s2 = "bb";
        assertTrue(map.insert(s1));
        assertTrue(map.insert(s2));
        assertTrue(map.find(s1));
        assertTrue(map.find(s2));
        assertTrue(map.delete(s1));
        assertFalse(map.find(s1));
        assertTrue(map.find(s2));
    }

    @Test
    void testMixedTypes() {
        MyHashMap map = new MyHashMap();
        assertTrue(map.insert(123L));
        assertTrue(map.insert("123"));
        assertTrue(map.find(123L));
        assertTrue(map.find("123"));
        assertTrue(map.delete(123L));
        assertFalse(map.find(123L));
        assertTrue(map.find("123"));
    }

    @Test
    void testBoundaryValues() {
        MyHashMap map = new MyHashMap();
        long maxValue = 9999999999L;
        long minValue = 0L;
        assertTrue(map.insert(maxValue));
        assertTrue(map.insert(minValue));
        assertTrue(map.find(maxValue));
        assertTrue(map.find(minValue));
        assertTrue(map.delete(maxValue));
        assertFalse(map.find(maxValue));
        assertTrue(map.find(minValue));
    }

    @Test
    void testEmptyFind() {
        MyHashMap map = new MyHashMap();
        assertFalse(map.find(42L));
        assertFalse(map.find("anything"));
    }

    @Test
    void testInsertAndFindMultiple() {
        MyHashMap map = new MyHashMap();
        for (long i = 0; i < 100; i++) {
            assertTrue(map.insert(i));
        }
        for (long i = 0; i < 100; i++) {
            assertTrue(map.find(i));
        }
        assertFalse(map.find(100L));

        for (long i = 0; i < 100; i += 2) {
            assertTrue(map.delete(i));
        }
        for (long i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                assertFalse(map.find(i));
            } else {
                assertTrue(map.find(i));
            }
        }
    }
}