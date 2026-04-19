package module.utils;

import com.danp1t.FunctionInterface;
import com.danp1t.utils.CsvGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CsvGeneratorTest {

    @TempDir
    Path tempDir;

    @Test
    void buildFunctionShouldReturnInstanceForValidNames() {
        assertNotNull(CsvGenerator.buildFunction("sin"));
        assertNotNull(CsvGenerator.buildFunction("cos"));
        assertNotNull(CsvGenerator.buildFunction("tan"));
        assertNotNull(CsvGenerator.buildFunction("cot"));
        assertNotNull(CsvGenerator.buildFunction("csc"));
        assertNotNull(CsvGenerator.buildFunction("ln"));
        assertNotNull(CsvGenerator.buildFunction("log2"));
        assertNotNull(CsvGenerator.buildFunction("log3"));
        assertNotNull(CsvGenerator.buildFunction("log5"));
        assertNotNull(CsvGenerator.buildFunction("log10"));
    }

    @Test
    void buildFunctionShouldReturnNullForUnknownName() {
        assertNull(CsvGenerator.buildFunction("unknown"));
    }

    @Test
    void generateCsvShouldWriteNaNWhenArithmeticExceptionOccurs() throws IOException {
        FunctionInterface tan = CsvGenerator.buildFunction("tan");
        StringWriter sw = new StringWriter();
        double eps = 1e-9;

        CsvGenerator.generateCsv("tan", Math.PI / 2 - 0.1, Math.PI / 2 + 0.1, 0.1, eps, tan, sw);
        String content = sw.toString();
        assertTrue(content.contains("NaN"), "Для разрыва должно быть NaN");
    }

    @Test
    void generateCsvShouldUseLocaleUS() throws IOException {
        FunctionInterface ln = CsvGenerator.buildFunction("ln");
        StringWriter sw = new StringWriter();
        CsvGenerator.generateCsv("ln", 2.0, 2.0, 1.0, 1e-9, ln, sw);
        String content = sw.toString();
        assertTrue(content.contains("2.00000; 0.69315"));
    }

    @Test
    void mainShouldCreateCsvFileWithCorrectContent() throws Exception {
        String[] args = {"sin", "0", "3.14159", "1.570795", "1e-9"};
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));

        String originalUserDir = System.getProperty("user.dir");
        System.setProperty("user.dir", tempDir.toString());


        CsvGenerator.main(args);
        System.setOut(System.out);
        System.setErr(System.err);
        System.setProperty("user.dir", originalUserDir);

        String output = out.toString();
        assertTrue(output.contains("CSV файл успешно создан: sin_values.csv"));
    }

}