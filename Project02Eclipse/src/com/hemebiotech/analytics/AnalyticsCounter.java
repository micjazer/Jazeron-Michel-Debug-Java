package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsCounter est une classe refactorisée pour séparer les actions en plusieurs méthodes indépendantes.
 */
public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Constructeur qui initialise le lecteur et l'écrivain de symptômes.
     *
     * @param reader Instance de lecture des symptômes
     * @param writer Instance d'écriture des résultats
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Récupère la liste des symptômes depuis le fichier.
     *
     * @return Liste brute des symptômes
     */
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    /**
     * Compte les occurrences de chaque symptôme.
     *
     * @param symptoms Liste brute des symptômes
     * @return Map des symptômes avec leur nombre d'occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new TreeMap<>();
        for (String symptom : symptoms) {
            symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
        }
        return symptomCount;
    }

    /**
     * Trie les symptômes par ordre alphabétique.
     *
     * @param symptoms Map brute des symptômes et occurrences
     * @return Map triée par ordre alphabétique
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms); // TreeMap trie automatiquement par ordre alphabétique
    }

    /**
     * Écrit les résultats dans un fichier de sortie.
     *
     * @param symptoms Map des symptômes et occurrences
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
