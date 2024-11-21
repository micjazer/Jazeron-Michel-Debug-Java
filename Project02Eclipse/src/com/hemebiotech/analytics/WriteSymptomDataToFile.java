package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémente ISymptomWriter pour écrire les symptômes et leurs occurrences dans un fichier.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    /**
     * Constructeur pour initialiser le chemin du fichier de sortie.
     *
     * @param filepath Chemin complet ou relatif du fichier de sortie
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (symptoms == null || symptoms.isEmpty()) {
            System.err.println("Aucune donnée à écrire.");
            return;
        }

        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            System.out.println("Données écrites avec succès dans le fichier : " + filepath);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
