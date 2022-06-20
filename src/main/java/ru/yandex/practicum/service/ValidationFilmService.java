package ru.yandex.practicum.service;

import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.exceptions.ValidationException;
import ru.yandex.practicum.model.Film;

import java.time.LocalDate;

@Slf4j
public class ValidationFilmService {
    public static void checkFilmName (Film film) {
        if (film.getName() == null) {
            log.debug("Получен запрос на добаление фильма без названия");
            throw new ValidationException("Имя фильма не указано");
        }

        if (film.getName().isBlank()) {
            log.debug("Получен запрос на добаление фильма без названия");
            throw new ValidationException("Имя фильма не указано");
        }
    }

    public static void checkLengthDescription(Film film) {
        if (film.getDescription().length() > 200) {
            log.debug("Получен запрос на добавление фильма, описание которого больше 200 символов. Всего символов " +
                    film.getDescription().length());
            throw new ValidationException("Превышена длина описания");
        }
    }

    public static void checkDateCreationFilm(Film film) {
        LocalDate localDate = LocalDate.of(1895, 12, 28);
        if (film.getReleaseDate().isBefore(localDate) || film.getReleaseDate() == null) {
            log.debug("Получен запрос на добавление фильма раньше 28 декабря 1895 года. Дата " + film.getReleaseDate());
            throw new ValidationException("Не верная дата выпуска фильма");
        }
    }

    public static void CheckFilmDuration(Film film) {
        if (film.getDuration() <= 0) {
            log.debug("Получен запрос на добавление фильма с отрицательной продолжительностью. Продолжительность " +
                    film.getDuration());
            throw new ValidationException("Продолжительность должна быть больше нуля");
        }
    }
}
