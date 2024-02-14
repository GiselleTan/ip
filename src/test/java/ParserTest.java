package test.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import main.java.emis.exceptions.EmisException;
import main.java.emis.Parser;
import main.java.emis.task.Task;
import main.java.emis.task.ToDo;
import main.java.emis.TaskList;
import main.java.emis.command.ToDoCommand;
import main.java.emis.command.*;

/**
 * The ParserTest class contains JUnit tests for the Parser class.
 */
public class ParserTest {

    /**
     * Tests the parse method of the Parser class for successful parsing.
     */
    @Test
    public void parse_success() {
        ArrayList<Task> testTasks = new ArrayList<>();
        TaskList testTasklist = new TaskList(testTasks);
        try {
            assertTrue(Parser.parse("todo test1") instanceof ToDoCommand);
        } catch (EmisException e) {
            fail("Unexpected EmisException: " + e.getMessage());
        }
    }

    /**
     * Tests the parse method of the Parser class for failed parsing.
     */
    @Test
    public void parse_fail() {
        ArrayList<Task> testTasks = new ArrayList<>();
        TaskList testTasklist = new TaskList(testTasks);
        try {
            Parser.parse("screaming crying");
            fail("Expected EmisException to be thrown"); // the test should not reach this line
        } catch (EmisException e) {
            assertEquals("Invalid command!", e.getMessage());
        }
    }
}
