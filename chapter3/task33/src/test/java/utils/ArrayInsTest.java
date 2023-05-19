package utils;

import com.kulygin.utils.ArrayIns;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArrayInsTest {

    @Test
    void noDups() {
        int maxSize = 100;
        ArrayIns initialArr;
        initialArr = new ArrayIns(maxSize);
        initialArr.insert(1);
        initialArr.insert(1);
        initialArr.insert(1);
        initialArr.insert(2);
        initialArr.insert(2);
        initialArr.insert(3);
        initialArr.insert(6);
        initialArr.insert(7);
        initialArr.insert(9);
        initialArr.insert(9);

        ArrayIns expectedArr;
        expectedArr = new ArrayIns(maxSize);
        expectedArr.insert(1);
        expectedArr.insert(2);
        expectedArr.insert(3);
        expectedArr.insert(6);
        expectedArr.insert(7);
        expectedArr.insert(9);

        initialArr.noDups();

        assertThat(initialArr).isEqualTo(expectedArr);
    }

    @Test
    void noDups_1ElemArr() {
        int maxSize = 100;
        ArrayIns initialArr;
        initialArr = new ArrayIns(maxSize);
        initialArr.insert(1);

        ArrayIns expectedArr;
        expectedArr = new ArrayIns(maxSize);
        expectedArr.insert(1);

        initialArr.noDups();

        assertThat(initialArr).isEqualTo(expectedArr);
    }

    @Test
    void noDups_SmallArr() {
        int maxSize = 100;
        ArrayIns initialArr;
        initialArr = new ArrayIns(maxSize);
        initialArr.insert(1);
        initialArr.insert(1);

        ArrayIns expectedArr;
        expectedArr = new ArrayIns(maxSize);
        expectedArr.insert(1);

        initialArr.noDups();

        assertThat(initialArr).isEqualTo(expectedArr);
    }
}