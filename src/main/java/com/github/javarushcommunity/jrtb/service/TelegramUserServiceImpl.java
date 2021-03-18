package com.github.javarushcommunity.jrtb.service;

import com.github.javarushcommunity.jrtb.repository.entity.TelegramUserRepository;
import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link TelegramUserService}.
 */

@Service
@RequiredArgsConstructor
public class TelegramUserServiceImpl implements TelegramUserService{

    private final TelegramUserRepository entityNameRepository;

    @Override
    public void save(TelegramUser telegramUser) {
        entityNameRepository.save(telegramUser);
    }

    @Override
    public List<TelegramUser> retrieveAllActiveUsers() {
        return entityNameRepository.findAllByActiveTrue();
    }

    @Override
    public Optional<TelegramUser> findByChatId(String chatId) {
        return entityNameRepository.findById(chatId);
    }
}
