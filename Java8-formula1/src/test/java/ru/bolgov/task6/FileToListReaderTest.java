package ru.bolgov.task6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import ru.bolgov.task6.model.FileToListReader;

class FileToListReaderTest {

    FileToListReader reader = new FileToListReader();

    @Test
    void testFileReader() {
        FileToListReader reader = new FileToListReader();
        reader.fileReadCreateList("testForReader.txt");
        ArrayList<String> testList = new ArrayList<>();
        assertEquals(testList, reader.getFileLinesList());
    }

}
