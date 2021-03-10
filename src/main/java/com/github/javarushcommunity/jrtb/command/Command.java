package com.github.javarushcommunity.jrtb.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command interface for handling telegram-bot commands.
 */
public interface Command {

    /**
     * Main method to execute commands.
     *
     * @param update provided {@link Update} object with all needed data for command.
     */
    void execute(Update update);
}
