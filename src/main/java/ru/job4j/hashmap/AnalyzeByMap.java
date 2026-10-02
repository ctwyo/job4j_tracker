package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double total = 0;
        int quantity = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                total += subject.score();
                quantity++;
            }
        }
        return total / quantity;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double total = 0;
            for (Subject subject : pupil.subjects()) {
                total += subject.score();
            }
            double averageScore = total / pupil.subjects().size();
            result.add(new Label(pupil.name(), averageScore));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int oldValue = map.getOrDefault(subject.name(), 0);
                int newValue = oldValue + subject.score();
                map.put(subject.name(), newValue);
            }
        }
        for (String key : map.keySet()) {
            int value = map.get(key);
            double score = (double) value / pupils.size();
            result.add(new Label(key, score));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }

    public static void main(String[] args) {
        double average = AnalyzeByMap.averageScore(
                List.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 70),
                                        new Subject("Philosophy", 80)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 80),
                                        new Subject("Lang", 90),
                                        new Subject("Philosophy", 70)
                                )
                        ),
                        new Pupil("Sidorov",
                                List.of(
                                        new Subject("Math", 70),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 50)
                                )
                        )
                )
        );
        System.out.println(average);
    }
}