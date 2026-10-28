package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void testStore_InitialState() {
        TorpedoStore store = new TorpedoStore(5);
        assertEquals(5, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void testStore_FireWhenEmpty() {
        TorpedoStore store = new TorpedoStore(0);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
        assertTrue(store.isEmpty());
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void testStore_InvalidFireArgument() {
        TorpedoStore store = new TorpedoStore(5);
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(6);
        });
    }
}