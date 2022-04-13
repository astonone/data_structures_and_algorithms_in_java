package utils;

import com.kulygin.utils.ArrayIns;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArrayInsTest {

    @Test
    void medianForOddArrSize() {
        int maxSize = 10;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        arr.insert(5);
        arr.insert(9);
        arr.insert(2);
        arr.insert(15);
        arr.insert(21);

        final long median = arr.median();

        assertThat(median).isEqualTo(9);
    }

    @Test
    void medianForEvenArrSize() {
        int maxSize = 10;
        ArrayIns arr;
        arr = new ArrayIns(maxSize);
        arr.insert(5);
        arr.insert(4);
        arr.insert(11);
        arr.insert(7);
        arr.insert(13);
        arr.insert(19);

        final long median = arr.median();

        assertThat(median).isEqualTo(9);
    }
}