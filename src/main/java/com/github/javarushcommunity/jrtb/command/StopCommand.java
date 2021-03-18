package com.github.javarushcommunity.jrtb.command;

import com.github.javarushcommunity.jrtb.service.SendBotMessageService;
import com.github.javarushcommunity.jrtb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}
 */

public class StopCommand implements Command {

    private final SendBotMessageService service;
    private final TelegramUserService telegramUserService;

    public final static String STOP_MESSAGE = "Деактивировал все ваши подписки \uD83D\uDE1F.";

    public StopCommand(SendBotMessageService service, TelegramUserService telegramUserService) {
        this.service = service;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        service.sendMessage(chatId, STOP_MESSAGE);
        telegramUserService.findByChatId(chatId)
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
