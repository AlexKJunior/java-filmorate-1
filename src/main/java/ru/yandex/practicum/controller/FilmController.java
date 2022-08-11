package ru.yandex.practicum.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.exceptions.ValidationException;
import ru.yandex.practicum.model.Film;
import ru.yandex.practicum.service.FilmService;
import ru.yandex.practicum.storage.FilmStorage;
import ru.yandex.practicum.storage.Storages;

import java.util.*;


@Slf4j
@RestController
public class FilmController {
    private final FilmStorage filmStorage = Storages.getDefaultInMemoryFilmStorage();
    private final FilmService filmService = new FilmService();

    @GetMapping("/films")
    public List<Film> findAll() {
        log.info("Получен запрос на получение списка всех фильмов");
        return filmStorage.findAll();
    }

    @PostMapping("/films")
    public Film crete(@RequestBody Film film) {
        log.info("Получен запрос на добавление фильма");
        Film newFilm = filmStorage.addFilm(film);
        log.info("Фильм добавлен c ID " + newFilm.getId());
        return newFilm;
    }

    @PutMapping("/films")
    public Film update(@RequestBody Film film) {
        log.info("Получен запрос на обновление фильма");
        Film newFilm = filmStorage.updateFilm(film);
        log.info("Фильм c ID " + newFilm.getId() + " обновлен");
        return film;
    }

    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable int id) {
        log.info("Получен запрос на получение вильма с ID " + id);
        Film film = filmStorage.getFilmById(id);
        log.info("Фильм c ID " + id + " успешно получен");
        return film;
    }

    @PutMapping("/films/{id}/like/{userId}")
    public Film addLikeFilm(@PathVariable int id, @PathVariable int userId) {
        log.info("Получен запрос на дабавление лайка");
        Film film = filmService.addLike(id, userId);
        log.info("Количество лайков для фильма с ID " + id + " успешно увеличено");
        return film;
    }

    @DeleteMapping("/films/{id}/like/{userId}")
    public Film deleteLikeFilm(@PathVariable int id, @PathVariable int userId) {
        log.info("Получен запрос на удаление лайка");
        Film film = filmService.removeLike(id, userId);
        log.info("Лайк успешно удален");
        return film;
    }

    @GetMapping("/films/popular")
    public List<Film> returnMostPopularFilm(@RequestParam(defaultValue = "10") int count) {
        log.info("Получен запрос на получение " + count);
        List<Film> mostPopularFilms = filmService.returnMostPopularFilm(count);
        log.info("Список самых популярных фильмов сформирован");
        return mostPopularFilms;
    }
}
