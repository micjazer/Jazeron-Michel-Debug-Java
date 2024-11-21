package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Classe principale pour organiser et exécuter les étapes de l'application.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Lancement de l'application Analytics...");

        try {
            // Étape 1 : Instancier ISymptomReader pour lire les données
            ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

            // Étape 2 : Instancier ISymptomWriter pour écrire les résultats
            ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

            // Étape 3 : Instancier AnalyticsCounter pour organiser les étapes
            AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

            // Étape 4 : Lecture des données
            List<String> symptoms = analytics.getSymptoms();

            // Étape 5 : Comptage des symptômes
            Map<String, Integer> countedSymptoms = analytics.countSymptoms(symptoms);

            // Étape 6 : Tri des symptômes
            Map<String, Integer> sortedSymptoms = analytics.sortSymptoms(countedSymptoms);

            // Étape 7 : Écriture des résultats
            analytics.writeSymptoms(sortedSymptoms);

            System.out.println("Analyse terminée. Résultats écrits dans result.out.");
        } catch (Exception e) {
            System.err.println("Une erreur est survenue lors de l'exécution de l'application : " + e.getMessage());
        }
    }
}

