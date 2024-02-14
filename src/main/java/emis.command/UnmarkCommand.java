package main.java.emis.command;
import main.java.emis.*;
import main.java.emis.exceptions.EmisException;

/**
 * The UnmarkCommand class represents a command to mark a task as undone in the EMIS application.
 * When executed, it marks the specified task as undone and updates the storage.
 */
public class UnmarkCommand extends Command {
    /** The index of the task to mark as undone. */
    private int taskNo;

    /**
     * Constructs a new UnmarkCommand object with the specified task index.
     * 
     * @param taskNo The index of the task to mark as undone.
     */
    public UnmarkCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * Executes the unmark command by marking the specified task as undone and updating the storage.
     * 
     * @param t The TaskList object representing the list of tasks.
     * @param ui The Ui object handling interactions with the user.
     * @param s The Storage object handling loading and saving of tasks.
     */
    @Override
    public void execute(TaskList t, Ui ui, Storage s) {
        try {
            t.markAsUndone(this.taskNo);
            s.updateStorage();
        } catch (EmisException e) {
            ui.showError(e.getMessage());
        }
    }

    /**
     * Indicates whether the command is an exit command.
     * 
     * @return false, as the unmark command does not represent an exit command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}