package duke.command;

import duke.DukeException;
import duke.task.Deadline;
import duke.util.TaskList;

import java.time.LocalDate;

/**
 * Handles the command 'deadline'.
 */
public class DeadlineCommand extends Command{
    private String input;

    /**
     * Constructor for a new Deadline command.
     *
     * @param input the input
     */
    public DeadlineCommand(String input) {
        this.input = input;
    }

    /**
     * Runs the command 'deadline'.
     * @param taskList List of current tasks.
     * @throws DukeException Duke Exception for deadline.
     */
    @Override
    public void run(TaskList taskList) throws DukeException {
        String[] segments = input.split("/by");
        if (segments.length != 2) {
            throw new DukeException("Error with deadline input");
        } else {
            String time = segments[1].strip();
            LocalDate date = LocalDate.parse(time);
            Deadline deadline = new Deadline(segments[0], date);
            taskList.createTask(deadline);
        }
    };
}
