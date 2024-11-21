package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Définit une méthode pour écrire les symptômes et leurs occurrences dans un fichier.
 */
public interface ISymptomWriter {
    /**
     * Écrit les symptômes et leurs quantités dans un fichier.
     *
     * @param symptoms Une Map contenant les symptômes (clé) et leurs occurrences (valeur)
     */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
