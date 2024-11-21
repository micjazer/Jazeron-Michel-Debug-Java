package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsMain {
    public static void main(String[] args) {
        // Lire les symptômes depuis un fichier
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> symptoms = symptomReader.GetSymptoms();

        // Compter les occurrences des symptômes
        Map<String, Integer> symptomCount = countSymptoms(symptoms);

        // Écrire les données dans un fichier avec ISymptomWriter
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");
        symptomWriter.writeSymptoms(symptomCount);
    }

    /**
     * Compte le nombre d'occurrences de chaque symptôme dans une liste.
     *
     * @param symptoms Liste brute des symptômes
     * @return Map avec le nom du symptôme et son nombre d'occurrences
     */
    private static Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new TreeMap<>();

        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }

        return symptomCount;
    }
}
