package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsMain {
    public static void main(String[] args) {
        // Étape 1 : Créer les instances de ISymptomReader et ISymptomWriter
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // Étape 2 : Initialiser AnalyticsCounter
        AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

        // Étape 3 : Utiliser les méthodes refactorisées pour exécuter les étapes
        List<String> symptoms = analytics.getSymptoms(); // Lecture des symptômes
        Map<String, Integer> countedSymptoms = analytics.countSymptoms(symptoms); // Comptage
        Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(countedSymptoms); // Tri
        analytics.writeSymptoms(sortedSymptoms); // Écriture

        System.out.println("Analyse terminée. Résultats écrits dans result.out.");
    }
}
