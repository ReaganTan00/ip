package duke.command;

import duke.DukeException;
import duke.util.TaskList;
import duke.util.Ui;

/**
 * Handles the command 'unmark'.
 */
public class UnmarkCommand extends Command{
    private String input;

    /**
     * Constructor for a new unmark command.
     *
     * @param input the input
     */
    public UnmarkCommand(String input) {
        this.input = input;
    }

    /**
     * Runs the command 'unmark'.
     * @inheritDoc
     * @param taskList List of current tasks.
     * @throws DukeException Duke Exception for unmarking out of bounds.
     */
    @Override
    public void run(TaskList taskList) throws DukeException {
        int index = Integer.parseInt(input) - 1;
        try {
            taskList.getTask(index).setUndone();
            Ui.formatMessage("I've marked this duke.task as not done.. \n  "
                    + taskList.getTask(index).toString());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Index is out of bounds!");
        }
    }
}
