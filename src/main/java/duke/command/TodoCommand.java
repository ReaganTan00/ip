package duke.command;

import duke.DukeException;
import duke.task.Todo;
import duke.util.TaskList;

/**
 * Handles the command 'todo'.
 */
public class TodoCommand extends Command{
    private String input;

    /**
     * Constructor for a new Todo command.
     *
     * @param input the input
     */
    public TodoCommand(String input) {
        this.input = input;
    }

    /**
     * Runs the command 'todo'.
     * @inheritDoc
     * @param taskList List of current tasks.
     * @throws DukeException Duke Exception for when description is empty.
     */
    @Override
    public void run(TaskList taskList) throws DukeException {
        if (input.strip().length() >= 1) {
            Todo todo = new Todo(input);
            taskList.createTask(todo);
        } else {
            throw new DukeException("Description of a todo cannot be empty");
        }
    };
}
