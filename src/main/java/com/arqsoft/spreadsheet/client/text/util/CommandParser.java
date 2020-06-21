package com.arqsoft.spreadsheet.client.text.util;

import com.arqsoft.spreadsheet.client.text.Command;

public class CommandParser {
    public Command parseCommand(String command) throws IllegalCommandException {
        Command res;
        switch (command.toLowerCase()) {
            case "add":
            case "a":
                res = Command.ADD_CELL;
                break;
            case "load":
            case "l":
                res = Command.LOAD;
                break;
            case "save":
            case "s":
                res = Command.SAVE;
                break;
            case "saveas":
            case "sa":
                res = Command.SAVE_AS;
                break;
            case "quit":
            case "q":
                res = Command.QUIT;
                break;
            case "help":
            case "h":
                res = Command.HELP;
                break;
            default:
                throw new IllegalCommandException(command + "command not known.");
        }
        return res;
    }
}
