package gui_swing_events;

import java.util.ArrayList;
import java.util.List;

public class Excel {
    private ArrayList<Double> numbers;

    public Excel(ArrayList<Double> numbers) {
        this.numbers = numbers;
    }

    public Excel(String input) {
        numbers = new ArrayList<>();
        String[] numStrings = input.split(",");
        for (String numString : numStrings) {
            try {
                double number = Double.parseDouble(numString.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                // Ignore non-numeric values
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (double num : numbers) {
            total += num;
        }
        return total;
    }

    public double calculateAverage() {
        double total = calculateTotal();
        return total / numbers.size();
    }

    public double calculateMaximum() {
        double max = Double.MIN_VALUE;
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public double calculateMinimum() {
        double min = Double.MAX_VALUE;
        for (double num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
