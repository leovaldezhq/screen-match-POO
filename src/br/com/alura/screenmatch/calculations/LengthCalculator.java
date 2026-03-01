package br.com.alura.screenmatch.calculations;

import br.com.alura.screenmatch.models.Title;

public class LengthCalculator {
    private int totalLength = 0;

    public void includes(Title title) {
        System.out.println("Adding length of " + title.getName());
        this.totalLength += title.getLengthInMinutes();
    }

    public int getTotalLength() {
        return totalLength;
    }
}