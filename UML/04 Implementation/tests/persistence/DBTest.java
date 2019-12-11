package persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBTest {

    @Test
    void connect() {
        assertNotNull(DB.connect());
    }
}