package ru.warpreaktor.practicum;

import ru.warpreaktor.util.fabric.ComparatorFabric;
import ru.warpreaktor.util.fabric.MapComparatorFabric;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Мы проводим онлайн-конкурс работ молодых художников. Всего представлено NN работ, которые идентифицируются числами от 00 до N-1N−1 включительно. Нужно поддержать 3 типа запроса:
 * Лайк работы с идентификатором id.
 * Дизлайк работы с идентификатором id.
 * Вернуть лучшие KK работ. Оценку работы будем считать просто: число лайков минус число дизлайков.
 */
public class BestWork {
    private ArrayList<Integer> scores;
    private ComparatorFabric comparatorFabric;

    void changeScore(int participantId, int change) {
        scores.add(participantId, scores.get(participantId) + change);
    }

    public BestWork(int participantCount) {
        scores.add(participantCount, 0);
    }

    void like(int participantId) {
        changeScore(participantId, 1);
    }

    void dislike(int participantId) {
        changeScore(participantId, -1);
    }

    ArrayList<Integer> getBestWorks(int k) {
        // Отсортируем работы в порядке убывания числа лайков
        comparatorFabric = new MapComparatorFabric();
        TreeMap<Integer, Integer> scoresIds = new TreeMap<>(comparatorFabric.createComparator());
        for (int i = 0; i < scores.size(); ++i) {
            scoresIds.put(i, scores.get(i));
        }

        // Теперь, когда работы отсортированы, выберем k лучших
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, scoresIds.size()); ++i) {
            result.add(scoresIds.get(i));
        }
        return result;
    }
}
